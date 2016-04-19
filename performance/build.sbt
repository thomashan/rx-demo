name := "microservice-performance-test"

version := "0.1"

scalaVersion := "2.11.7"

resolvers += Resolver.mavenLocal

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.5" % "test",
  "com.cj" %% "kafka-rx" % "0.3.1",
  "org.slf4j" % "log4j-over-slf4j" % "1.7.14",
  "ch.qos.logback" % "logback-classic" % "1.1.3",
  "ch.qos.logback" % "logback-core" % "1.1.3",
  "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.2.0"
).map(_.exclude("org.slf4j", "slf4j-log4j12"))
  .map(_.exclude("log4j", "log4j"))
