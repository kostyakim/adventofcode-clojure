(ns adventofcode-clojure.core
  (:gen-class))

(def inputString (slurp "/home/kuma/first"))
(defn numCount 
  [inp pos sum]
  (letfn [(parse-int [s](Integer. s))
          (subNumber [n p] (parse-int (subs n p (+ p 1))))
          (sum-equal [n p](= (subNumber n p) (subNumber n (+ p 1))))
          (get-new-sum [n p sum](if (sum-equal n p) (+ sum (subNumber n p)) sum))
          ]
  (if (= (+ pos 2) (count inp))
    sum
    (recur inp (+ 1 pos) (get-new-sum inp pos sum))
  ))
)
(defn -main
  [& args]
  (println (numCount inputString 0 0)))


