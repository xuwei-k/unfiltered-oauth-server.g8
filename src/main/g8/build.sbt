organization := "com.example"

name := "$name$"

scalaVersion := "$scala_version$"

val unusedWarnings = (
  "-Ywarn-unused" ::
  "-Ywarn-unused-import" ::
  Nil
)

scalacOptions ++= PartialFunction.condOpt(CrossVersion.partialVersion(scalaVersion.value)){
  case Some((2, v)) if v >= 11 => unusedWarnings
}.toList.flatten

Seq(Compile, Test).flatMap(c =>
  scalacOptions in (c, console) --= unusedWarnings
)

scalacOptions ++= "-deprecation" :: "unchecked" :: "-feature" :: Nil

version := "0.1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  "ws.unfiltered" %% "unfiltered-filter" % "$unfiltered_version$",
  "ws.unfiltered" %% "unfiltered-jetty" % "$unfiltered_version$",
  "ws.unfiltered" %% "unfiltered-oauth" % "$unfiltered_version$",
  "ws.unfiltered" %% "unfiltered-json4s" % "$unfiltered_version$",
  "ch.qos.logback" % "logback-classic" % "$logback_version$"
)
