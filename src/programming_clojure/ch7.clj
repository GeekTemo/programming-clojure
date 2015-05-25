(ns programming-clojure.ch7)

(defmacro unless [expr form]
  (list 'if expr nil form))

(unless false (println "Hello World"))

(println (macroexpand-1 '(unless false (println "Hello World"))))

(println (macroexpand-1 '(.. arm getHand getFinger)))

(when-not false (println "This") (println "and alseo this"))

(defmacro chain
  ([x form] (list '. x form))
  ([x form & more] (concat (list 'chain (list '. x form)) more)))


(defmacro chain [x form]
  `(. ~x ~form))

(println (macroexpand '(chain arm getHand)))

(defmacro chain
  ([x form] `(. ~x ~form))
  ([x form & more] `(chain (. ~x ~form) ~more)))

(println (macroexpand '(chain arm getHand getFinger)))


(defmacro chain
  ([x form] `(. ~x ~form))
  ([x form & more] `(chain (. ~x ~form) ~@more)))

(println (macroexpand '(chain arm getHand getFinger getOther)))

(defmacro bench [expr]
  `(let [start# (System/nanoTime)
         result# ~expr]
     {:result result# :elapsed (- (System/nanoTime) start#)}))

(println (bench (Thread/sleep 2000)))













