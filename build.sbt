lazy val root = (project in file("."))
  .enablePlugins(GatlingPlugin)
  .settings(
    name := "single-customer-account-performance-tests",
    version := "3.0.0-SNAPSHOT",
    scalaVersion := "2.13.16",
    scalacOptions ++= Seq("-feature", "-language:implicitConversions", "-language:postfixOps"),
    Test / testOptions := Seq.empty,
    libraryDependencies ++= Dependencies.test
  )
