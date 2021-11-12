organization := "com.oskarro"
name := "FoodCash"
version := "0.1-SNAPSHOT"
      
lazy val `foodcash` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "Akka Snapshot Repository" at "https://repo.akka.io/snapshots/"
scalaVersion := "2.13.6"

libraryDependencies ++= Seq( jdbc , ehcache , ws , specs2 % Test , guice )

enablePlugins(JavaAppPackaging)
      