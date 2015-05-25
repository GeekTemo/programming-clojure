(ns programming-clojure.ch9
  (:import (java.net HttpURLConnection URL)))


(defn response-code [address]
  (let [conn ^HttpURLConnection (.openConnection (URL. address))
        code (.getResponseCode conn)]
    (when (< code 400)
      (-> conn .getInputStream .close))
    code
    ))

(println (response-code "https://www.google.com"))

(defn available? [address]
  (= 200 (response-code address)))

(println (available? "https://www.google.com"))


(defn -main []
  (let [addresses '("http://google.com" "http://amazon.com" "http://google.com/badurl")]
    (while true
      (doseq [address addresses]
        (println (available? address))))))

