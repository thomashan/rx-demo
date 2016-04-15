package au.com.nab.account

class AccountsController {

    def traditionalList() {
        render Account.findAll()
    }

    def reactiveList() {

    }
}
