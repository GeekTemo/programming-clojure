(ns programming-clojure.ch8
  (:import (java.sql Date)))

(defmulti my-print class)

(defmethod my-print String [s]
  (.write *out* s))

;(defmethod my-print :default [s]
;  (.write *out* "#<")
;  (.write *out* (.toString s))
;  (.write *out* ">"))

;(my-print (Date. 0))

(defmulti my-print class :default :everything-else)

(defmethod my-print :everything-else [_]
  (.write *out* "Not implement yet..."))

(my-print (Date. 0))