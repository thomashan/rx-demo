package au.com.nab.account

import grails.transaction.Transactional
import rx.Observable

@Transactional
class AccountService {
    List<Account> traditionalGetAccounts() {
        Account.findAll()
    }

    Observable<Account> observableGetAccounts() {
        Observable.from(Account.findAll())
    }
}
