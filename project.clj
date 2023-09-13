(defproject dbtest "0.1.0-SNAPSHOT"
  :description "Sample code showing how to create and use an H2 database within a Clojure project."
  :url "https://github.com/timotheosh/dbtest"
  :license {:name "MIT"
            :url "https://opensource.org/license/MIT/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [com.h2database/h2 "2.2.222"]
                 [com.github.seancorfield/next.jdbc "1.3.883"]]
  :main ^:skip-aot dbtest.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
