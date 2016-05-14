package au.com.thomashan.account

import HttpParameters.ACCEPT_HEADER
import SimulationConfig.baseUrl
import io.gatling.core.Predef._
import io.gatling.http.Predef.http

object HttpConfig {
  val HTTP_CONF = http
    .baseURL(baseUrl)
    .acceptHeader(ACCEPT_HEADER)
}
