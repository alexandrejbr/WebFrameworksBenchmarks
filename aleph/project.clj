(defproject hello "aleph"
  :description "JSON/plaintext tests"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [clj-tuple "0.2.2"]
                 [org.clojure/tools.cli "0.3.3"]
                 [aleph "0.4.3"]
                 [cheshire "5.7.0"]
                 [clj-json "0.5.3"]
                 [clj-time "0.12.0"]]
  :main hello.handler
    :aot :all)
