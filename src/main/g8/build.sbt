organization := "com.example"

name := "$name$"

scalaVersion := "$scala_version$"

version := "0.1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  "ws.unfiltered" %% "unfiltered-filter" % "$unfiltered_version$",
  "ws.unfiltered" %% "unfiltered-jetty" % "$unfiltered_version$",
  "ws.unfiltered" %% "unfiltered-oauth" % "$unfiltered_version$",
  "ws.unfiltered" %% "unfiltered-json4s" % "$unfiltered_version$",
  "ch.qos.logback" % "logback-classic" % "$logback_version$"
)
