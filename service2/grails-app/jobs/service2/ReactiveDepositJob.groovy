package service2

import au.com.thomashan.account.Account
import au.com.thomashan.message.Message
import au.com.thomashan.message.MessageType
import com.cj.kafka.rx.Record
import com.cj.kafka.rx.RxConsumer
import grails.plugins.quartz.QuartzJob
import groovy.json.JsonSlurper
import kafka.serializer.StringDecoder

import static rx.lang.scala.JavaConversions.toJavaObservable

class ReactiveDepositJob implements QuartzJob {
    private static final String TOPIC = "service2"

    void execute() {
        println "start reactive deposit!"
        RxConsumer rxConsumer = new RxConsumer("localhost:2181", "service2-group", false, false, null)
        JsonSlurper jsonSlurper = new JsonSlurper()

        toJavaObservable(rxConsumer.getRecordStream(TOPIC, new StringDecoder(), new StringDecoder()))
                .map({ Record record -> record.value().toString() })
                .map({ message -> new Message(jsonSlurper.parseText(message)) })
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
