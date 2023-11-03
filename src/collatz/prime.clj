(ns hobbiz.prime
  (:require [clojure.string :as str]))

(defn- divides?
  [x d]
  (zero? (mod x d)))

(defn- generate-prime-candidates
  [n]
  (->> (iterate #(+ 6 %) 6)
       (mapcat (juxt dec inc))
       (concat [2 3])
       (take-while #(<= % n))))

(defn- prime?
  [x]
  (and (<= 2 x)
       (not-any? #(divides? x %) (generate-prime-candidates (int (Math/sqrt (double x)))))))

(defn generate-primes
  [x]
  (let [candidates (generate-prime-candidates x)]
    (reduce (fn [acc x]
              (let [sqrt (int (Math/sqrt (double x)))]
                (if (some #(divides? x %) (take-while #(<= % sqrt) acc))
                  acc
                  (conj acc x))))
            (vec (take-while #(<= % (min x 23)) candidates))
            (drop-while #(<= % (min x 23)) candidates))))

(defn prime-base
  [x]
  (let [primes (generate-primes x)
        count-divisions (fn [x d cnt]
                          (let [r (quot x d)]
                            (if (== x (* r d))
                              (recur r d (inc cnt))
                              [cnt x])))]
    (loop [x x
           ps primes
           acc []]
      (if (== 1 x)
        acc
        (let [[cnt rem] (count-divisions x (first ps) 0)]
          (recur
           rem
           (rest ps)
           (conj acc cnt)))))))

(defn print-prime-base
  [pb]
  (let [int-char #(cond
                    (< % 10) (str %)
                    (< % 32) (char (+ (int \a) (- % 10)))
                    (< % 58) (char (+ (int \A) (- % 32)))
                    :else (throw (ex-info "primebase invalid" {:primebase pb})))]
    (str/join (map int-char (rseq pb)))))

(defn generate-verbose-collatz-series
  [x]
  (->> x
       (iterate #(if (divides? % 2)
                   (quot % 2)
                   (inc (* 3 %))))
       (take-while #(> % 4))))

(defn generate-short-collatz-series
  [x]
  (->> x
       generate-verbose-collatz-series
       (remove #(divides? % 2))))


#_(->> (generate-short-collatz-series 125)
       (map  (juxt identity prime? (comp print-prime-base prime-base))))

#_(->> (for [i (range 100000000)
                         :let [r (generate-short-collatz-series i)]]
                     [i (count r)])
                   (sort-by second >)
                   (take 10))
