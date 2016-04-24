package au.com.nab.account

import au.com.nab.domain.Json

class Account implements Json {
    String name
    String accountNumber
    BigDecimal balance

    def deposit(BigDecimal amount) {
        balance = balance + amount
    }
}
