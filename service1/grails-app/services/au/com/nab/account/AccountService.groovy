package au.com.nab.account

import grails.transaction.Transactional
import rx.Observable

import static grails.async.Promises.*

@Transactional
class AccountService {
    List<Account> traditionalGetAccounts() {
        Account.list()
    }

    Observable<Account> observableGetAccounts() {
        Observable.from(waitAll(Account.async.list()).first())
    }
}
