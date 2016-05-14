package au.com.thomashan.account

class Account {
    String name
    String accountNumber
    BigDecimal balance

    def deposit(BigDecimal amount) {
        balance = +amount
    }
}
