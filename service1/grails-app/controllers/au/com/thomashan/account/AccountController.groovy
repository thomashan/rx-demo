package au.com.thomashan.account

import au.com.thomashan.message.Message
import au.com.thomashan.message.MessageType
import rx.Observable

class AccountController {
    AccountService accountService

    def traditionalDeposit() {
        int statusCode = accountService.traditionalDeposit(params.long("id"), 1)

        render(status: statusCode)
    }

    def reactiveDeposit() {
        Observable<Message> depositMessages = createDepositMessages(2500)

        accountService.reactiveDeposit(depositMessages)

        render(status: 200)
    }

    private Observable<Message> createDepositMessages(int times) {
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
