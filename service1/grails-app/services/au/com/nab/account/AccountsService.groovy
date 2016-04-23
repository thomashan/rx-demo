package au.com.nab.account

import grails.transaction.Transactional
import rx.Observable

import static grails.async.Promises.*

@Transactional
class AccountsService {
    List<Account> traditionalGetAccounts() {
        Account.list()
    }

    Observable<Account> observableGetAccounts() {
        Observable.from(Account.list())
    }
}
