(ns programming-clojure.scheduler
  (:import (java.util.concurrent ScheduledThreadPoolExecutor)))

(defn scheduled-executor
  "Create a scheduler executor."
  ^ScheduledThreadPoolExecutor [threads]
  (ScheduledThreadPoolExecutor. threads))

(defn periodically
  )