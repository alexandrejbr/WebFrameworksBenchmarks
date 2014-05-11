## What was used

* [play framework 2.2.2][p]
* [nscala-time][j]

## how to run it

Follow these steps:

1. Install play framework from http://downloads.typesafe.com/play/2.2.2/play-2.2.2.zip
2. Be sure to have play's home directory in your PATH
3. Change directory into project's root directory

		$cd playframework.scala
4. Launch play framework:

		$ play
5. From play's console type **dist** to generate a standalone package

		> dist
6. The generated package is located at **\target\universal\sample-play-1.3.zip**
7. Extract the contents of the zip file and use the sample-play-scala file to run it
8. If you want to specify execution arguments you can use JAVA_OPTS environment variable or place the execution arguments in a file named SAMPLE_PLAY_SCALA_config.txt


[p]: http://www.playframework.com/
[j]: https://github.com/nscala-time/nscala-time