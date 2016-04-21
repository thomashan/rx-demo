package au.com.nab.account

import au.com.nab.account.HttpParameters.ACCEPT_HEADER
import io.gatling.core.Predef._
import io.gatling.http.Predef.http

object HttpConfiguration {
  val HTTP_CONF = http
    .baseURL("http://localhost:8080")
    .acceptHeader(ACCEPT_HEADER)
}
