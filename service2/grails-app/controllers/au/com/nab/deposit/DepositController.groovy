package au.com.nab.deposit

class DepositController {
    DepositService depositService

    def traditionalDeposit() {
        def body = request.JSON
        depositService.deposit(params.long("id"), body.amount)

        render(status: 200)
    }
}
