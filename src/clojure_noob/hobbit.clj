;; Hobbit defition
(def asym-hobbit-body-parts [{:name "head" :size 3}
                            {:name "left-eye" :size 1}
                            {:name "left-ear" :size 1}
                            {:name "mouth" :size 1}
                            {:name "nose" :size 1}
                            {:name "neck" :size 2}
                            {:name "left-shoulder" :size 3}
                            {:name "left-upper-arm" :size 3}
                            {:name "chest" :size 10}
                            {:name "back" :size 10}
                            {:name "left-forearm" :size 3}
                            {:name "abdomen" :size 6}
                            {:name "left-kidney" :size 1}
                            {:name "left-hand" :size 2}
                            {:name "left-knee" :size 2}
                            {:name "left-thigh" :size 4}
                            {:name "left-lower-leg" :size 3}
                            {:name "left-achilles" :size 1}
                            {:name "left-foot" :size 2}])

;; The next function will match each hobbit part with its 
;; right counter part by replacing the left with right
;; and matching the same size
(defn matching-part
    [part]
    {:name (clojure.string/replace (:name part) #"^left-" "right-")
        :size (:size part)})

;; This function will call tge matching part and loop through 
;; the bodyparts and match it accordingly
(defn symmetrize-body-parts
    "Expects a seq of maps that have a :name and :size"
    [asym-body-parts]
    (loop [remaining-asym-parts asym-body-parts
            final-body-parts []]
        (if (empty? remaining-asym-parts)
            final-body-parts ;; when statement if remaining-asym-parts is empty
            (let [[part & remaining] remaining-asym-parts] ;; else statement
                (recur remaining
                    (into final-body-parts
                        (set [part (matching-part part)]))
                )
            )
        )
    )
)

;; using reduce function we are able to apply a function to the first 2 items in a collection
;; then apply function to the result of the first and the next item in the collection
(reduce + [1 2 3 4]) ;; This is equal to (+ (+ (+ 1 2) 3) 4)

(defn better-symmetrize-body-parts
    "Expects a seq of maps that have a :name and :size"
    [asym-body-parts]
    (reduce (fn [final-body-parts part]
              (into final-body-parts (set [part (matching-part part)])))
            []
            asym-body-parts))  

(defn hit
    [asym-body-parts]
    (let [sym-parts (better-symmetrize-body-parts asym-body-parts)
            body-part-size-sum (reduce + (map :size sym-parts))
            target (rand body-part-size-sum)]
            (println body-part-size-sum)
        (loop [[part & remaining] sym-parts
                accumulated-size (:size part)]
        (if (> accumulated-size target)
            part
            (recur remaining (+ accumulated-size (:size (first remaining))))))))

(hit asym-hobbit-body-parts)

;; EXERCISES ;;



(defn is-palindrome
    [input]
    (def input-seq (seq input))
    (def palindrome-seq (reverse input-seq))

    ;; Evaluate that palindrome is correct
    (= input-seq palindrome-seq)
)

(is-palindrome 110011)

;; Function that adds 100 to any number
((fn [x] (+ 100 x)) 5)


;; Function that creates a decrement maker
(defn dec-maker
    "Create a custom incrementor"
    [dec-by]
    #(- % dec-by)
)
(def dec9 (dec-maker 9))
(dec9 10)

;; Write a function that receives a map and returns a set
(defn mapset
    "Transform map into a set"
    [function payload]
    (set (map function payload))
)
(mapset inc [1 1 2 2])