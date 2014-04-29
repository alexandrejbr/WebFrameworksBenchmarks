// needed because sbt-twirl depends on twirl-compiler which is only available
// at repo.spray.io
resolvers += "spray repo" at "http://repo.spray.io"

addSbtPlugin("io.spray" % "sbt-revolver" % "0.7.2")

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.4.0")

addSbtPlugin("io.spray" % "sbt-twirl" % "0.7.0")

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.11.2")