package au.com.nab.account

import au.com.nab.account.HttpConfiguration.HTTP_CONF
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class ReactiveListSimulation extends Simulation {
  val reactiveListScenario = scenario("AccountsList")
    .exec(http("reactiveList")
      .get("/accounts/reactiveList"))

  setUp(
    reactiveListScenario.inject(atOnceUsers(1))
  ).protocols(HTTP_CONF)
}
