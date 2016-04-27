package au.com.nab.account

import grails.converters.JSON

class AccountsController {
    AccountsService accountsService

    def traditionalList() {
        render accountsService.traditionalGetAccounts() as JSON
    }

    def reactiveList() {
        accountsService.observableGetAccounts()
                .map({ a -> a as JSON })
                .subscribe({ a -> response << "$a\n" })
    }
}
