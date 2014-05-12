(ns http-kit-example.core
	(:use org.httpkit.server)
	(:require [cheshire.core :refer :all]))

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

(defn json_response [json_body] 
	{:status 200
 	 :headers {"Content-Type" "application/json"}
 	 :body json_body})

(defn clj-json [] (json_response (json/write-str msg)))

(defn cheshire-json [] (json_response (generate-string msg)))

(defn text []
	{:status 200
	 :headers {"Content-Type" "text/plain"}
	 :body msg_text})

(defn not-found []
	{:status 404
	 :headers {"Content-Type" "text/plain"}
	 :body "Not found!"})

(def routing-map
	{"/json" cheshire-json
	 "/text" text})

(defn app [req] ((get routing-map (get req :uri) not-found)))

(defn -main [] (run-server app {:port 8080}))