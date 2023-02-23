/*
 * Copyright 2023 HM Revenue & Customs
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

import uk.gov.hmrc.perftests.SCA.SCAUserJourney.baseUrlFor

object Utils {

  lazy val GGLoginFrontEnd = baseUrlFor("auth-frontend")
  lazy val SCAFrontEnd = baseUrlFor("sca-frontend")
  lazy val YourTaxesAndBenefits = baseUrlFor("sca-frontend")
  lazy val CheckProgress = baseUrlFor("tracking-frontend")
  lazy val Messages = baseUrlFor("pertax-frontend")
  lazy val ProfileAndSettings = baseUrlFor("pertax-frontend")
  lazy val AccountHome = baseUrlFor("pertax-frontend")
  lazy val WelshLanguageToggle = baseUrlFor("sca-frontend")
  lazy val EnglishLanguageToggle = baseUrlFor("sca-frontend")
}
