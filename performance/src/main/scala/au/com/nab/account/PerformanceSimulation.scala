package au.com.nab.account

import au.com.nab.account.HttpConfig.HTTP_CONF
import au.com.nab.account.SimulationConfig.{ramp, users}
import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._

import scala.concurrent.duration._

class ReactiveListSimulation extends Simulation {
  val reactiveListScenario = scenario("AccountsList")
    .exec(http("reactiveList")
      .get("/accounts/reactiveList")
      .check(status.is(200))
    )

  setUp(
    reactiveListScenario
      .inject(rampUsers(users) over (ramp minutes))
  ).protocols(HTTP_CONF)
}

class TraditionalListSimulation extends Simulation {
  val traditionalListScenario = scenario("AccountsList")
    .exec(http("traditionalList")
      .get("/accounts/traditionalList")
      .check(status.is(200))
    )

  setUp(
    traditionalListScenario
      .inject(rampUsers(users) over (ramp minutes))
  ).protocols(HTTP_CONF)
}
