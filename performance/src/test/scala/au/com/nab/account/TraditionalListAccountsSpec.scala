package au.com.nab.account

import io.gatling.core.Predef._
import io.gatling.http.Predef.http
import io.gatling.http.Predef.css
import io.gatling.http.funspec.GatlingHttpFunSpec
import au.com.nab.account.TraditionalListAccountsSpec._

class TraditionalListAccountsSpec extends GatlingHttpFunSpec {
  val baseURL = "http://localhost:8080"

  override def httpConf = super.httpConf

  spec {
    http("Traditional account list")
      .get("/accounts/traditionalList")
      .check(h1.exists)
  }
}

object TraditionalListAccountsSpec {
  def h1 = css("h1")
}
