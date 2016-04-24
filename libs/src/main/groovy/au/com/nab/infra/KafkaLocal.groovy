package au.com.nab.infra

import kafka.server.KafkaConfig
import kafka.server.KafkaServerStartable

class KafkaLocal {
    private static final String TMP_DIR = System.getProperty("java.io.tmpdir")
    private KafkaServerStartable kafka
    private ZooKeeperLocal zookeeper
    private Map kafkaProperties
    private Properties zkProperties

    KafkaLocal() {
        this(defaultKafkaProperties(), defaultZookeeperProperties())
    }

    KafkaLocal(Map kafkaProperties, Properties zkProperties) {
        this.kafkaProperties = kafkaProperties
        this.zkProperties = zkProperties

        zookeeper = new ZooKeeperLocal(zkProperties)
        println "zookeeper started"

        //start local kafka broker
        kafka = new KafkaServerStartable(new KafkaConfig(kafkaProperties))
        kafka.startup()
        println "kafka started"
    }

    private static Map defaultKafkaProperties() {
        ["zookeeper.connect": "localhost:2181",
         "broker.id"        : "1",
         "log.dirs"         : "${TMP_DIR}kafka-local/${UUID.randomUUID().toString()}".toString()
        ]
    }

    private static Properties defaultZookeeperProperties() {
        Properties zkProperties = new Properties()
        zkProperties.put("dataDir", "${TMP_DIR}zookeeper-local/${UUID.randomUUID().toString()}".toString())
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
