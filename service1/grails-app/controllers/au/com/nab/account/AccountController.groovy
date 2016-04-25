package au.com.nab.account

import au.com.nab.message.Message
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
        Observable<Message> depositMessages = createDepositMessages(10000)

        accountService.reactiveDeposit(depositMessages)

        render(status: 200)
    }

    private Observable<Message> createDepositMessages(int times) {
        def id = params.id
        Message depositMessage = new Message(
                messageType: MessageType.REQUEST,
                version: "1",
                from: "service1-deposit",
                to: "service2-deposit",
                body: [id: params.long("id"), amount: 10]
        )

        Observable.just(depositMessage).repeat(times)
    }
}
