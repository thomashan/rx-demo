import au.com.thomashan.account.Account
import au.com.thomashan.account.AccountsLoader
import au.com.thomashan.infra.KafkaLocal

class BootStrap {
    private KafkaLocal kafkaLocal

    def init = { servletContext ->
        kafkaLocal = new KafkaLocal()

        Account.withTransaction {
            AccountsLoader.load(1000)
        }
    }

    def destroy = {
        kafkaLocal.shutdown()
    }
}
