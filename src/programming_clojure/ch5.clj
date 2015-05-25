(ns programming-clojure.ch5)

(defrecord Message [sender text])

(defn add-message [msg]
  (dosync (alter messages conj msg)))

(def validate-message-list
  (partial every? #(and (:sender %) (:text %))))

(def messages (ref () :validator validate-message-list))