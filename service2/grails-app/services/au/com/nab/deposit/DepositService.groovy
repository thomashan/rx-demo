package au.com.nab.deposit

import au.com.nab.account.Account
import grails.transaction.Transactional

class DepositService {
    @Transactional
    def deposit(long id, BigDecimal amount) {
        Account account = Account.findById(id, [lock: true])
        account.deposit(amount)
    }
}
