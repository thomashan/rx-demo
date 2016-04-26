import service2.ReactiveDepositJob

class BootStrap {
    def init = { servletContext ->
        ReactiveDepositJob.triggerNow()
    }
    def destroy = {
    }
}
