(ns http-kit-example.core
	(:gen-class)
	(:use org.httpkit.server)
	(:require [cheshire.core :refer :all]
			  [http-kit-example.books :as books]
			  [clojure.data.json :as json]
			  [clj-json.core :as clj-json]))

;cpu count:

(def n-cpu (.availableProcessors (Runtime/getRuntime)))

(def list-of-books-txt (json/write-str books/list-of-books))

(defn json_response [json_body] 
	{:status 200
 	 :headers {"Content-Type" "application/json"}
 	 :body json_body})

;http request handlers:

(defn stock-json [] (json_response (json/write-str books/list-of-books)))

(defn cheshire-json [] (json_response (generate-string books/list-of-books)))

(defn clj-json [] (json_response (clj-json/generate-string books/list-of-books)))

(defn text []
	{:status 200
	 :headers {"Content-Type" "text/plain"}
	 :body list-of-books-txt})

(defn not-found []
	{:status 404
	 :headers {"Content-Type" "text/plain"}
	 :body "Not found!"})

;http request routing:

(def routing-map
	{"/json_stock" stock-json
	 "/json_chesire" cheshire-json
	 "/json_clj-json" clj-json
	 "/text" text})

;main http handler:

(defn app [req] ((get routing-map (get req :uri) not-found)))

;entry point:

(defn -main [] (run-server app {:port 8080 :thread n-cpu}) 
	(print "Threads to compute response from request = ")
	(println n-cpu)
	(print "Ready to receive requests!"))