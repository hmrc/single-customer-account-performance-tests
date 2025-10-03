/*
 * Copyright 2025 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.perftests.SCA

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.SCA.Utils._

object SCAUserJourney extends ServicesConfiguration {
  // GGLogin
  def getGGStartPage: HttpRequestBuilder =
    http("GET - GG Login Page")
      .get(GGLoginFrontEnd + "/auth-login-stub/gg-sign-in": String)
      .check(status.in(200, 303))
      .check(currentLocation.is(GGLoginFrontEnd + "/auth-login-stub/gg-sign-in": String))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postGGCredentials(isLocal: Boolean = false): HttpRequestBuilder = {
    val redirectionUrl = if (isLocal) "http://localhost:8420/single-customer-account" else "/single-customer-account"

    http("POST - GG Login credentials page")
      .post(GGLoginFrontEnd + "/auth-login-stub/gg-sign-in": String)
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("authorityId", "")
      .formParam("gatewayToken", "")
      .formParam("redirectionUrl", redirectionUrl)
      .formParam("credentialStrength", "strong")
      .formParam("confidenceLevel", "200")
      .formParam("affinityGroup", "Individual")
      .formParam("usersName", "")
      .formParam("email", "user@test.com")
      .formParam("credentialRole", "User")
      .formParam("nino", "#{NINO}")
      .formParam("groupIdentifier", "")
      .formParam("agent.agentId", "")
      .formParam("agent.agentCode", "")
      .formParam("agent.agentFriendlyName", "")
      .formParam("unreadMessageCount", "")
      .formParam("mdtp.sessionId", "")
      .formParam("mdtp.deviceId", "")
      .formParam("presets-dropdown", "IR-SA")
      .formParam("enrolment[0].name", "")
      .formParam("enrolment[0].taxIdentifier[0].name", "")
      .formParam("enrolment[0].taxIdentifier[0].value", "")
      .formParam("enrolment[0].state", "Activated")
      .formParam("enrolment[1].name", "")
      .formParam("enrolment[1].taxIdentifier[0].name", "")
      .formParam("enrolment[1].taxIdentifier[0].value", "")
      .formParam("enrolment[1].state", "Activated")
      .formParam("enrolment[2].name", "")
      .formParam("enrolment[2].taxIdentifier[0].name", "")
      .formParam("enrolment[2].taxIdentifier[0].value", "")
      .formParam("enrolment[2].state", "Activated")
      .formParam("enrolment[3].name", "")
      .formParam("enrolment[3].taxIdentifier[0].name", "")
      .formParam("enrolment[3].taxIdentifier[0].value", "")
      .formParam("enrolment[3].state", "Activated")
      .formParam("enrolment[4].name", "IR-SA")
      .formParam("enrolment[4].taxIdentifier[0].name", "UTR")
      .formParam("enrolment[4].taxIdentifier[0].value", "#{UTRNumber}")
      .formParam("enrolment[4].state", "Activated")
      .formParam("itmp.givenName", "")
      .formParam("itmp.middleName", "")
      .formParam("itmp.familyName", "")
      .formParam("itmp.dateOfBirth", "")
      .formParam("itmp.address.line1", "")
      .formParam("itmp.address.line2", "")
      .formParam("itmp.address.line3", "")
      .formParam("itmp.address.line4", "")
      .formParam("itmp.address.line5", "")
      .formParam("itmp.address.postCode", "")
      .formParam("itmp.address.countryName", "")
      .formParam("itmp.address.countryCode", "")
      .check(status.is(303))
      .check(currentLocation.is(GGLoginFrontEnd + "/auth-login-stub/gg-sign-in": String))
  }

  // SCA Home Page
  def getSCAHomePage: HttpRequestBuilder =
    http("GET - SCA Home page")
      .get(SCAFrontEnd + "/single-customer-account": String)
      .check(status.in(200, 303))
      .check(currentLocation.is(SCAFrontEnd + "/single-customer-account": String))

  def getYourTaxesAndBenefits: HttpRequestBuilder =
    http("GET - YourTaxesAndBenefits")
      .get(YourTaxesAndBenefits + "/single-customer-account/taxes-and-benefits": String)
      .check(status.in(200))
      .check(currentLocation.is(YourTaxesAndBenefits + "/single-customer-account/taxes-and-benefits": String))

  def getMessages: HttpRequestBuilder =
    http("GET - SCA Messages")
      .get(Messages + "/single-customer-account/messages": String)
      .check(status.in(200))
      .check(currentLocation.is(Messages + "/single-customer-account/messages": String))

}
