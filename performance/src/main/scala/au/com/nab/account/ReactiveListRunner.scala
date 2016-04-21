package au.com.nab.account

import io.gatling.app.Gatling

object ReactiveListRunner extends App {
  Gatling.main(Array("-s", "au.com.nab.account.ReactiveListSimulation"))
}
