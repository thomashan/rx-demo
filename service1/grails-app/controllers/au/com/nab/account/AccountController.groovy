package au.com.nab.account

import au.com.nab.deposit.DepositMessage
import au.com.nab.message.MessageType
import rx.Observable

class AccountController {
    static allowedMethods = [traditionalDeposit: ' POST',
                             reactiveDeposit   : 'POST']
    AccountService accountService

    def traditionalDeposit() {
        accountService.traditionalDeposit($accountNumber, 1)

        render(status: 200)
    }

    def reactiveDeposit() {
        Observable<DepositMessage> depositMessages = createDepositMessages(100000)

        accountService.reactiveDeposit(depositMessages)

        render(status: 200)
    }

    private Observable<DepositMessage> createDepositMessages(int times) {
        DepositMessage depositMessage = new DepositMessage(
                messageType: MessageType.REQUEST,
                version: "1",
                from: "service1-deposit",
                to: "service2-deposit",
                accountName: params.accountName,
                amount: 10
        )

        Observable.just(depositMessage).repeat(times)
    }
}
