package au.com.nab.account

import io.gatling.app.Gatling

object TraditionalListRunner extends App {
  Gatling.main(Array("-s", "au.com.nab.account.AccountsSimulation"))
}
