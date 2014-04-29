## What was used

* [spray 1.3.1 (_spray-can_)][s] 
* [twirl][t]
* [nscala-time][j]

## how to run it

Follow these steps:

1. Get the latest stable version of Scala Simple Build Tool (SBT) from **http://www.scala-sbt.org/release/docs/Getting-Started/Setup.html** and install it
2. Change directory into project's root directory

		$cd spray.twirl
3. Launch SBT:

		$ sbt
4. Compile:

		> compile
5. Generate executable jar file:

		> assembly
6. The generated jar is placed at **\target\scala-2.10\sample-spray-twirl-assembly-0.1.jar** 

7. Run it!

		$ java -jar sample-spray-twirl-assembly-0.1.jar

[s]: http://spray.io/
[t]: https://github.com/spray/twirl
[j]: https://github.com/nscala-time/nscala-time