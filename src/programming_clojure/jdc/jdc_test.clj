(ns programming-clojure.jdc.jdc-test)

(require '[jdbc.core :as jdbc])

(def dbspec {:vendor   "mysql"
             :name     "test"
             :host     "localhost"                          ;; Optional
             :port     3306                                 ;; Optional
             :user     "root"                               ;; Optional
             :password ""})


(let [conn (jdbc/connection dbspec)]
  (println (class conn))
  (.close conn))


(def res (with-open [conn (jdbc/connection dbspec)]
           (jdbc/fetch conn "select * from foo;")))

(println)