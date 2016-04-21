package au.com.nab.account

import au.com.nab.account.HttpConfiguration.HTTP_CONF
import io.gatling.core.Predef._
import io.gatling.http.Predef._


class TraditionalListSimulation extends Simulation {
  val traditionalListScenario = scenario("AccountsList")
    .exec(http("traditionalList")
      .get("/accounts/traditionalList"))

  setUp(
    traditionalListScenario.inject(atOnceUsers(1))
  ).protocols(HTTP_CONF)
}
