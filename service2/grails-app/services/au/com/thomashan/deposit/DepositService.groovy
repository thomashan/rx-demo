package au.com.thomashan.deposit

import au.com.thomashan.account.Account
import grails.transaction.Transactional

class DepositService {
    @Transactional
    def deposit(long id, BigDecimal amount) {
        Account account = Account.get(id)
        account.deposit(amount)
    }
}
