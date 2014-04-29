import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "sample-play-scala"
  val appVersion      = "1.3"

  val appDependencies = Seq(
      cache,
      "com.github.nscala-time" %% "nscala-time" % "1.0.0",
      "io.spray" %%  "spray-json" % "1.2.6"
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}
