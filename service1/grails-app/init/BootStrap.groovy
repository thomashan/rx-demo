import au.com.nab.account.Account
import au.com.nab.account.AccountsLoader
import au.com.nab.infra.KafkaLocal

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
