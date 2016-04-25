package au.com.nab.deposit

import au.com.nab.account.Account
import au.com.nab.message.Message
import au.com.nab.message.MessageType
import com.cj.kafka.rx.Record
import com.cj.kafka.rx.RxConsumer
import grails.transaction.Transactional
import groovy.json.JsonSlurper
import kafka.serializer.StringDecoder

import javax.annotation.PostConstruct

import static rx.lang.scala.JavaConversions.toJavaObservable

class DepositService {
    private static final String TOPIC = "service2"
//    static lazyInit = false
    RxConsumer rxConsumer = new RxConsumer("localhost:2181", "service2-group", false, false, null)

//    @PostConstruct
//    private void initialise() {
//        listenToDepositMessages()
//    }

    @Transactional
    def deposit(long id, BigDecimal amount) {
        Account account = Account.get(id)
        account.deposit(amount)
    }

    def listenToDepositMessages() {
        JsonSlurper jsonSlurper = new JsonSlurper()

        toJavaObservable(rxConsumer.getRecordStream(TOPIC, new StringDecoder(), new StringDecoder()))
                .map({ Record record -> record.value().toString() })
                .map({ message ->
                    new Message(jsonSlurper.parseText(message))
                })
                // this is how you handle different message types
                .filter({ message -> message.messageType == MessageType.REQUEST })
                // This is how you handle multiple versions
                .filter({ message -> message.version == "1" })
                .forEach({ message ->
                    long id = message.body.id
                    BigDecimal amount = message.body.amount
                    Account account = Account.get(id)

                    Account.withTransaction {
                        account.deposit(amount)
                    }
                })
    }
}
