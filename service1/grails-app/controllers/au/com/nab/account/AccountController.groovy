package au.com.nab.account

import au.com.nab.message.Message
import au.com.nab.message.MessageType
import rx.Observable

class AccountController {
    AccountService accountService

    def traditionalDeposit() {
        accountService.traditionalDeposit(params.long("id"), 1)

        render(status: 200)
    }

    def reactiveDeposit() {
        Observable<Message> depositMessages = createDepositMessages(100000)

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
                body: [id: params.long("id"), amount: 1]
        )

        Observable.just(depositMessage).repeat(times)
    }
}
