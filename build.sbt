name := "smoke"

organization := "com.mdialog"

version := "2.1.0"

scalaVersion := "2.10.3"

scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-feature",
  "-language:postfixOps",
  "-language:implicitConversions"
)

libraryDependencies ++= Seq(
  "org.clapper" % "grizzled-slf4j_2.10" % "1.0.1",
  "ch.qos.logback" % "logback-classic" % "1.0.5",
  "io.netty" % "netty" % "3.7.0.Final",
  "com.typesafe" % "config" % "1.2.0",
  "com.typesafe.akka" %% "akka-actor" % "2.3.0",
  "org.scalatest" %% "scalatest" % "2.1.0" % "test"
)

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

publishTo <<= version { (v: String) =>
  if (v.trim.endsWith("-SNAPSHOT"))
    Some(Resolver.file("Snapshots", file("../mdialog.github.com/snapshots/")))
  else
    Some(Resolver.file("Releases", file("../mdialog.github.com/releases/")))
}

parallelExecution in Test := false
