(defproject hello "aleph"
  :description "JSON/plaintext tests"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [clj-tuple "0.2.2"]
                 [org.clojure/tools.cli "0.3.3"]
                 [aleph "0.4.1-beta2"]
                 [cheshire "5.6.3"]
                 [clj-json "0.5.3"]]
  :main hello.handler
    :aot :all)
