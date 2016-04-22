package au.com.nab.account

import com.typesafe.config.ConfigFactory

object SimulationConfig {
  private val config = ConfigFactory.load()
  val baseUrl = config.getString("performance.baseUrl")
  val duration = config.getInt("performance.duration")
  val ramp = config.getInt("performance.ramp")
  val spikeUsers = config.getInt("performance.spikeUsers")
  val users = config.getInt("performance.users")
}
