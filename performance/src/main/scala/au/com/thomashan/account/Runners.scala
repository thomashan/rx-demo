package au.com.thomashan.account

import io.gatling.app.Gatling

object TraditionalListRunner extends App {
  Gatling.main(Array("-s", "au.com.thomashan.account.TraditionalListSimulation"))
}

object TraditionalListSpikeRunner extends App {
  Gatling.main(Array("-s", "au.com.thomashan.account.TraditionalListSpikeSimulation"))
}

object ReactiveListRunner extends App {
  Gatling.main(Array("-s", "au.com.thomashan.account.ReactiveListSimulation"))
}

object ReactiveListSpikeRunner extends App {
  Gatling.main(Array("-s", "au.com.thomashan.account.ReactiveListSpikeSimulation"))
}

object TraditionalDepositRunner extends App {
  Gatling.main(Array("-s", "au.com.thomashan.account.TraditionalDepositSimulation"))
}
