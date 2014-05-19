## What was used

* [Leiningen][l]
* [Clojure ] [a]
* [http-kit] [h] (http server)
* [data.json][j] (JSON encoding / decoding)
* [cheshire] [c] (JSON encoding / decoding)
* [clj-json] [f] (JSON encoding / decoding)

## how to run it

Follow these steps:

1. Install Leiningen from http://leiningen.org/#install
2. Change directory into project's root directory
3. Run (using Leiningen):

		$lein trampoline run

		Threads to compute response from request = { Runtime.getRuntime().availableProcessors() }
		Ready to receive requests!

4. Ready to take request @ http://127.0.0.1:8080/
	4.1 /text 
	4.2 /json_stock [data.json][j]
	4.2 /json_chesire [cheshire][c]
	4.3 /json_clj-json [clj-json][f]


[l]: http://leiningen.org/
[h]: http://http-kit.org/
[j]: https://github.com/clojure/data.json
[c]: https://github.com/dakrone/cheshire
[f]: https://github.com/mmcgrana/clj-json
[a]: http://clojure.org/