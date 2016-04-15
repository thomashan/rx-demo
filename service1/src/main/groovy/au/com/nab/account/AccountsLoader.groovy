package au.com.nab.account

class AccountsLoader {
    private AccountsLoader() {}

    static def load(int numberOfAccounts) {
        (1..numberOfAccounts).forEach { number ->
            new Account(name: "account-$number",
                    accountNumber: UUID.randomUUID().toString(),
                    balance: 0
            ).save()
        }
    }
}
