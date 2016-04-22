import au.com.nab.account.Account
import au.com.nab.account.AccountsLoader
import au.com.nab.infra.KafkaLocal

class BootStrap {
    def init = { servletContext ->
        new KafkaLocal()
        Account.withTransaction {
            AccountsLoader.load(1000)
        }
    }

    def destroy = {
        Account.findAll()*.delete()
    }
}
