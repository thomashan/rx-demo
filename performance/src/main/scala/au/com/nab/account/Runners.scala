package au.com.nab.account

import io.gatling.app.Gatling

object TraditionalListRunner extends App {
  Gatling.main(Array("-s", "au.com.nab.account.TraditionalListSimulation"))
}

object TraditionalListSpikeRunner extends App {
  Gatling.main(Array("-s", "au.com.nab.account.TraditionalListSpikeSimulation"))
}

object ReactiveListRunner extends App {
  Gatling.main(Array("-s", "au.com.nab.account.ReactiveListSimulation"))
}

object ReactiveListSpikeRunner extends App {
  Gatling.main(Array("-s", "au.com.nab.account.ReactiveListSpikeSimulation"))
}

object TraditionalDeposit extends App {
  Gatling.main(Array("-s", "au.com.nab.account.TraditionalDepositSimulation"))
}
