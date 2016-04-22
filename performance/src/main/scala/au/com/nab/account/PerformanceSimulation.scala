package au.com.nab.account

import au.com.nab.account.HttpConfig.HTTP_CONF
import au.com.nab.account.SimulationConfig.{duration, spikeUsers, users}
import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._

import scala.concurrent.duration._

class ConstantRequestSimulation extends Simulation {
  val reactiveListScenario = scenario("Constant load - account list")
    .exec(http("reactive")
      .get("/accounts/reactiveList")
      .check(status.is(200))
    )
    .exec(http("traditional")
      .get("/accounts/traditionalList")
      .check(status.is(200))
    )

  setUp(
    reactiveListScenario
      .inject(constantUsersPerSec(users) during (duration minutes))
  ).protocols(HTTP_CONF)
}

class ReactiveListSimulation extends Simulation {
  val reactiveListScenario = scenario("Reactive account list - constant load")
    .exec(http("reactiveList")
      .get("/accounts/reactiveList")
      .check(status.is(200))
    )

  setUp(
    reactiveListScenario
      .inject(constantUsersPerSec(users) during (duration minutes))
  ).protocols(HTTP_CONF)
}

class ReactiveListSpikeSimulation extends Simulation {
  val reactiveListScenario = scenario("Reactive account list - spike load")
    .exec(http("reactiveList")
      .get("/accounts/reactiveList")
      .check(status.is(200))
    )

  setUp(
    reactiveListScenario
      .inject(atOnceUsers(spikeUsers))
  ).protocols(HTTP_CONF)
}

class TraditionalListSimulation extends Simulation {
  val traditionalListScenario = scenario("Traditional account list - constant load")
    .exec(http("traditionalList")
      .get("/accounts/traditionalList")
      .check(status.is(200))
    )

  setUp(
    traditionalListScenario
      .inject(constantUsersPerSec(users) during (duration minutes))
  ).protocols(HTTP_CONF)
}


class TraditionalListSpikeSimulation extends Simulation {
  val traditionalListScenario = scenario("Traditional account list - spike load")
    .exec(http("traditionalList")
      .get("/accounts/traditionalList")
      .check(status.is(200))
    )

  setUp(
    traditionalListScenario
      .inject(atOnceUsers(spikeUsers))
  ).protocols(HTTP_CONF)
}
