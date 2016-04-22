package au.com.nab.account

import grails.converters.JSON

class AccountsController {
    AccountService accountService

    def traditionalList() {
        render accountService.traditionalGetAccounts() as JSON
    }

    def reactiveList() {
        accountService.observableGetAccounts()
                .map({ a -> a.toJson() })
                .subscribe({ a -> response << "$a\n" })
    }
}
