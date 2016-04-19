package au.com.nab.account

import grails.converters.JSON

import static grails.async.Promises.task

class AccountsController {
    AccountService accountService

    def traditionalList() {
        render accountService.traditionalGetAccounts() as JSON
    }

    def reactiveList() {
        task {
            accountService.observableGetAccounts()
                    .map({ a -> a.toJson() })
                    .subscribe({ a -> response << "$a\n" })
        }
    }
}
