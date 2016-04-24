import au.com.nab.deposit.DepositService

class BootStrap {
    DepositService depositService

    def init = { servletContext ->
        depositService.listenToDepositMessages()
    }
    def destroy = {
    }
}
