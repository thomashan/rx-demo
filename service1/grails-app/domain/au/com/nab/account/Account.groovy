package au.com.nab.account

class Account implements Json {
    String name
    String accountNumber
    BigDecimal balance

    def deposit(BigDecimal amount) {
        balance = +amount
    }
}
