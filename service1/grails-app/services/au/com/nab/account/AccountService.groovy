package au.com.nab.account

import au.com.nab.message.Message
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
    private static final String TOPIC = "service2"
    private static final String SERIALISER = "org.apache.kafka.common.serialization.StringSerializer"
    private RESTClient restClient = createHttpClient()
    private Producer producer = createProducer()

    void traditionalDeposit(String accountNumber, BigDecimal amount) {
        restClient.post(
                path: "/account/$accountNumber/deposit",
                requestContentType: JSON
        )
    }

    void reactiveDeposit(Observable<Message> depositMessages) {
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
                 (KEY_SERIALIZER_CLASS_CONFIG)  : SERIALISER,
                 (VALUE_SERIALIZER_CLASS_CONFIG): SERIALISER
                ]

        new KafkaProducer(config)
    }
}
