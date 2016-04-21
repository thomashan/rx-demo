package au.com.nab.account

import com.typesafe.config.ConfigFactory

object SimulationConfig {
  private val config = ConfigFactory.load()
  val baseUrl = config.getString("performance.baseUrl")
  val users = config.getInt("performance.users")
  val ramp = config.getInt("performance.ramp")
  val duration = config.getInt("performance.duration")
}
