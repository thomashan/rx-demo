package au.com.thomashan.infra

import au.com.thomashan.message.Message
import com.cj.kafka.rx.ProducerRecordObservable
import org.apache.kafka.clients.producer.{Producer, ProducerRecord}
import rx.Observable
import rx.lang.scala.JavaConversions.{toJavaObservable, toScalaObservable}

object KafkaUtils {
  def toProducerRecord(topic: String, message: Message): Observable[ProducerRecord[String, String]] = {
    Observable.just(new ProducerRecord[String, String](topic, message.message()))
  }

  def saveToKafka(stream: Observable[ProducerRecord[String, String]], producer: Producer[String, String]) = {
    toJavaObservable(toScalaObservable(stream).saveToKafka(producer))
  }
}
