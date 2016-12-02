organization := "com.example"

name := "$name$"

scalaVersion := "$scala_version$"

version := "0.1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  "net.databinder" %% "unfiltered-filter" % "$unfiltered_version$",
  "net.databinder" %% "unfiltered-jetty" % "$unfiltered_version$",
  "net.databinder" %% "unfiltered-oauth" % "$unfiltered_version$",
  "net.databinder" %% "unfiltered-json4s" % "$unfiltered_version$",
  "com.typesafe.scala-logging" %% "scala-logging" % "$scala_logging_version$",
  "ch.qos.logback" % "logback-classic" % "$logback_version$"
)
