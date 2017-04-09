(defproject http-kit-example "0.2.0"
  :description "http-kit and various json encoding libraries benchmark"
  :main http-kit-example.core
  :uberjar-name "http-kit-example-uberjar.jar"
  :aot [http-kit-example.core]            
  :dependencies [[org.clojure/clojure "1.8.0"] 
  				 [http-kit "2.2.0"]
  				 [clj-json "0.5.3"]
  				 [org.clojure/data.json "0.2.6"]
  				 [cheshire "5.7.0"]])
