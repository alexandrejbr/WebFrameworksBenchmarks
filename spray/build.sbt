import AssemblyKeys._

name := "sample-spray-twirl"

organization  := "com.example"

version       := "0.3"

scalaVersion  := "2.10.4"

resolvers ++= Seq(
  "spray repo" at "http://repo.spray.io/"
)

libraryDependencies ++= Seq(
  "io.spray"            %   "spray-can"     % "1.3.1",
  "io.spray"            %   "spray-routing" % "1.3.1",
  "io.spray" 			%%  "spray-json" 	% "1.2.6",
  "com.typesafe.akka"   %%  "akka-actor"    % "2.3.2",
  "com.typesafe.akka"   %%  "akka-slf4j"    % "2.3.2",
  "com.github.nscala-time" %% "nscala-time" % "1.0.0"
)

Revolver.settings

Twirl.settings

assemblySettings