import au.com.nab.account.Account
import au.com.nab.account.AccountsLoader

class BootStrap {
    def init = { servletContext ->
        Account.withTransaction {
            new Account(name: "name",
                accountNumber: "accountNumber",
                balance: 0
            ).save()
        }
//        Account.withTransaction {
//            AccountsLoader.load(1000)
//        }
    }

    def destroy = {
        Account.findAll()*.delete()
    }
}
