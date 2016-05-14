package au.com.thomashan.account

import grails.transaction.Transactional
import rx.Observable

@Transactional
class AccountsService {
    List<Account> traditionalGetAccounts() {
        Account.list()
    }

    Observable<Account> observableGetAccounts() {
        Observable.from(Account.list())
    }
}
