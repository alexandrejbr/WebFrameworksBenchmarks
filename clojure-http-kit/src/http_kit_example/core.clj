(ns http-kit-example.core
	(:use org.httpkit.server))

(require '[clojure.data.json :as json])

(def msg (list 
	{:title "Animal Farm"
	 :authors (list "George Orwell")
	 :publisher "Penguin"
	 :isbn13 9780141036137
	 :publishedDate "April 27, 2014"}
	{:title "1984"
	 :authors (list "George Orwell")
	 :publisher "Penguin"
	 :isbn13 9780141036144
	 :publishedDate "April 27, 2014"}
	{:title "The Razor's Edge"
	 :authors (list "William Sommerset Maugham")
	 :publisher "Vintage"
	 :isbn13 9780099284864
	 :publishedDate "April 27, 2014"}))
	 
(def msg_text (json/write-str msg))

(defn json [] 
 	{:status 200
 	 :headers {"Content-Type" "application/json"}
 	 :body (json/write-str msg)})

(defn text [] 
	{:status 200
	 :headers {"Content-Type" "text/plain"}
	 :body msg_text})

(defn not-found []
	{:status 404
	 :headers {"Content-Type" "text/plain"}
	 :body "Not found!"})

(def routing-map
	{"/json" json
	 "/text" text})

(defn app [req] 
	"Http request handler"
	((get routing-map (get req :uri) not-found)))

(defn -main
	"Application entry point"
	[]
	(run-server app {:port 8080}))