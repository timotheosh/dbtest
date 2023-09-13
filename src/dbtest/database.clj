(ns dbtest.database
  (:require [next.jdbc :as jdbc])
  (:import [org.h2.tools Server]))

(defn start []
  (let [options (into-array String ["-tcpPort", "9092", "-tcpAllowOthers"])
        server (.start (Server/createTcpServer options))]
    (println "H2 Database Server started on port 9092.")
    server))

(defn stop [server]
  (.stop server)
  (println "H2 Database Server stopped."))

(comment
  ;; Create a populate a database in H2
  ;; H2 auto-creates the database you try to connect to if it does not already exist.
  (def db {:dbtype "h2" :dbname "example"})
  (def ds (jdbc/get-datasource db))
  (jdbc/execute! ds ["
    create table address (
    id int auto_increment primary key,
    name varchar(32),
    email varchar(255)
    )"])

  (jdbc/execute! ds ["
    insert into address(name,email)
    values('Sean Corfield','sean@corfield.org')"])

  (jdbc/execute! ds ["select * from address"])

  ;; Code samples taken from next.jdbc documentation https://cljdoc.org/d/com.github.seancorfield/next.jdbc/1.3.883/doc/getting-started
  )
