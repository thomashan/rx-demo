package au.com.nab.account

import au.com.nab.account.HttpParameters.ACCEPT_HEADER
import au.com.nab.account.SimulationConfig.baseUrl
import io.gatling.core.Predef._
import io.gatling.http.Predef.http

object HttpConfig {
  val HTTP_CONF = http
    .baseURL(baseUrl)
    .acceptHeader(ACCEPT_HEADER)
}
