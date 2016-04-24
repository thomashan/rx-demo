package au.com.nab.deposit

import au.com.nab.account.Account
import au.com.nab.message.MessageType
import com.cj.kafka.rx.Record
import com.cj.kafka.rx.RxConsumer
import groovy.json.JsonSlurper
import kafka.serializer.StringDecoder

import static rx.lang.scala.JavaConversions.toJavaObservable

class DepositService {
    RxConsumer rxConsumer = new RxConsumer("localhost:2181", "service2-group", false, false, null)

    def listenToDepositMessages() {
        JsonSlurper jsonSlurper = new JsonSlurper()

        toJavaObservable(rxConsumer.getRecordStream("service2-request", new StringDecoder(), new StringDecoder()))
                .map({ Record record -> record.value().toString() })
                .map({ message -> new DepositMessage(jsonSlurper.parseText(message)) })
                // this is how you handle message types
                .filter({message -> message.messageType == MessageType.REQUEST})
                // This is how you handle multiple versions
                .filter({message -> message.version == "1"})
                .forEach({ message ->
                    String accountName = message.accountName
                    BigDecimal amount = message.amount
                    Account account = Account.findByName(accountName)

                    Account.withTransaction {
                        account.deposit(amount)
                    }
                })
    }
}
