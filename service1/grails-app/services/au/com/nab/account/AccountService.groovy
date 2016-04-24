package au.com.nab.account

import au.com.nab.deposit.DepositMessage
import com.cj.kafka.rx.Record
import groovyx.net.http.RESTClient
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.Producer
import rx.Observable

import static au.com.nab.infra.KafkaUtils.saveToKafka
import static au.com.nab.infra.KafkaUtils.toProducerRecord
import static groovyx.net.http.ContentType.JSON
import static org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG
import static org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG

class AccountService {
    private RESTClient restClient = createHttpClient()
    private Producer producer = createProducer()
    private static final String TOPIC = "service2-request"

    void traditionalDeposit(String accountNumber, BigDecimal amount) {
        restClient.post(
                path: "/account/$accountNumber/deposit",
                requestContentType: JSON
        )
    }

    void reactiveDeposit(Observable<DepositMessage> depositMessages) {
        depositMessages
                .map({ depositMessage -> toProducerRecord(TOPIC, depositMessage) })
                .forEach({ record -> saveToKafka(record, producer).forEach({ Record r -> r.commit() }) })
    }

    private RESTClient createHttpClient() {
        new RESTClient("http://localhost:8081")
    }

    private Producer createProducer() {
        Map<String, String> config =
                ["bootstrap.servers"            : "localhost:9092",
                 (KEY_SERIALIZER_CLASS_CONFIG)  : "org.apache.kafka.common.serialization.StringSerializer",
                 (VALUE_SERIALIZER_CLASS_CONFIG): "org.apache.kafka.common.serialization.StringSerializer"
                ]

        new KafkaProducer(config)
    }
}
