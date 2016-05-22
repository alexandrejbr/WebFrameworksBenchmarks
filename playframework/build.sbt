name := """sample-play-scala"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
      cache,
      "com.github.nscala-time" %% "nscala-time" % "1.0.0",
      "io.spray" %%  "spray-json" % "1.3.2"
  )

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
