name := "finatra_example"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.10.4"

libraryDependencies ++= Seq(
  "com.twitter" %% "finatra" % "1.5.3",
  "com.github.nscala-time" %% "nscala-time" % "1.0.0"
)

resolvers +=
  "Twitter" at "http://maven.twttr.com"
