package au.com.nab.infra

import kafka.server.KafkaConfig
import kafka.server.KafkaServerStartable

class KafkaLocal {
    private static final String TMP_DIR = System.getProperty("java.io.tmpdir")
    private KafkaServerStartable kafka
    private ZooKeeperLocal zookeeper
    private Properties kafkaProperties
    private Properties zkProperties

    KafkaLocal() {
        this(defaultKafkaProperties(), defaultZookeeperProperties())
    }

    KafkaLocal(Properties kafkaProperties, Properties zkProperties) {
        this.kafkaProperties = kafkaProperties
        this.zkProperties = zkProperties

        zookeeper = new ZooKeeperLocal(zkProperties)
        println "zookeeper started"

        //start local kafka broker
        kafka = new KafkaServerStartable(new KafkaConfig(kafkaProperties))
        kafka.startup()
        println "kafka started"
    }

    private static Properties defaultKafkaProperties() {
        Properties kafkaProperties = new Properties()
        kafkaProperties.put("zookeeper.connect", "localhost:2181")
        kafkaProperties.put("broker.id", "1")
        kafkaProperties.put("log.dirs", "${TMP_DIR}/kafka-local")

        return kafkaProperties
    }

    private static Properties defaultZookeeperProperties() {
        Properties zkProperties = new Properties()
        zkProperties.put("dataDir", "${TMP_DIR}/zookeeper-local")
        zkProperties.put("clientPort", "2181")

        return zkProperties
    }


    void shutdown() {
        //stop kafka broker
        kafka.shutdown()
        new File(kafkaProperties.getProperty("log.dirs")).deleteDir()
        new File(zkProperties.getProperty("dataDir")).deleteDir()
        println "stopped kafka"
        zookeeper.shutdown()
        println "stopped zookeeper"
    }
}
