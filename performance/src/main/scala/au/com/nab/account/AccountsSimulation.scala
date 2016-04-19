package au.com.nab.account

import au.com.nab.account.HttpParameters.ACCEPT_HEADER
import io.gatling.core.Predef._
import io.gatling.http.Predef._


class AccountsSimulation extends Simulation {
  val httpConfiguration = http
    .baseURL("http://localhost:8080")
    .acceptHeader(ACCEPT_HEADER)

  val traditionalListScenario = scenario("AccountsList")
    .exec(http("traditionalList")
      .get("/accounts/traditionalList"))

  val reactiveListScenario = scenario("AccountsList")
    .exec(http("reactiveList")
      .get("/accounts/reactiveList"))

  setUp(
    traditionalListScenario.inject(atOnceUsers(1))
  ).protocols(httpConfiguration)
}
