import service2.ReactiveDepositRunner

class BootStrap {
    def init = { servletContext ->
        ReactiveDepositRunner.triggerNow()
    }
    def destroy = {
    }
}
