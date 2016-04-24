package au.com.nab.infra

import org.apache.zookeeper.server.ServerConfig
import org.apache.zookeeper.server.ZooKeeperServerMain
import org.apache.zookeeper.server.quorum.QuorumPeerConfig

class ZooKeeperLocal {
    ZooKeeperServerMain zooKeeperServer

    ZooKeeperLocal(Properties zkProperties) {
        QuorumPeerConfig quorumConfiguration = new QuorumPeerConfig()
        try {
            quorumConfiguration.parseProperties(zkProperties)
        } catch (Exception e) {
            throw new RuntimeException(e)
        }

        zooKeeperServer = new ZooKeeperServerMain()
        ServerConfig configuration = new ServerConfig()
        configuration.readFrom(quorumConfiguration)


        new Thread() {
            public void run() {
                try {
                    zooKeeperServer.runFromConfig(configuration)
                } catch (IOException e) {
                    println "ZooKeeper Failed"
                    e.printStackTrace(System.err)
                }
            }
        }.start()
    }

    void shutdown() {
        zooKeeperServer.shutdown()
    }
}