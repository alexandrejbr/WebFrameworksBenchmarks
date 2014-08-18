(defproject http-kit-example "0.2.0"
  :description "http-kit and various json encoding libraries benchmark"
  :main http-kit-example.core
  :uberjar-name "http-kit-example-uberjar.jar"
  :aot [http-kit-example.core]            
  :dependencies [[org.clojure/clojure "1.6.0"] 
  				 [http-kit "2.1.18"]
  				 [clj-json "0.5.3"]
  				 [org.clojure/data.json "0.2.4"]
  				 [cheshire "5.3.1"]])
