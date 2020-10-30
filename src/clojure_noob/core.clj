el(ns clojure-noob.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (if false
    (do (println "You killed The Boss!")
      "Long Live Big Boss!")
      (do (println "You died against The Boss!")
      "Naked Snake is Dead!")
  )
  ;; This is like a if statement mixed with do since it can print multiple
  ;; lines but returns nil if the when is false since it can take else statements
  (when true
    (println "Ocelot is Defeated!")
    "Bye Bye Hand")

  (nil? 1)
  (nil? nil)

  ;; nil and false are considered the false statements and everything else
  ;; is considered a true statement thats why the next if evaluates correctly and
  ;; shows the "bears beets Battlestar Galactica" since the value is true
  (if "bears eat beets"
    "bears beets Battlestar Galactica")

  ;; In this case nil will always evaluate to false no matter what
  (if nil
    "This won't be the result because nil is falsey"
    "nil is falsey")
  
  ;; = is the equality operator in clojure
  (= 1 1)
  (= nil nil)
  (= 1 2)

  ;; or evaluates and returns the first true value or the last value
  (or false nil :large_I_mean_venti :why_cant_I_just_say_large)
  (or (= 0 1) nil (= "yes" "no"))
  (or nil)

  ;; and evaluates and returns the first false value or the last true value
  (and :free_wifi :hot_coffee)
  (and :feelin_super_cool nil false)

  ;; we can use defn to bind a name to a value in clojure
  (def failed-cobra-unit
    ["The Fear" "The End" "The Sorrow" "The Pain" "The Fury" "The Boss"])
  failed-cobra-unit

  ;; According to the book trying to change a variable association
  ;; is not a great idea since it makes a clojure program harder to understand since we don't know the def
  ;; of the variable any longer
  (def severity :mild)
  (def error-message "OH GOD! IT'S A DISASTER! WE'RE ")
  (if (= severity :mild)
    (def error-message (str error-message "MILDLY INCONVENIENCED!"))
    (def error-message (str error-message "DOOOOOOOMED!")))
  error-message

  (defn error-message
    [severity]
    (str "OH GOD! IT'S A DISASTER! WE'RE "
         (if (= severity :mild)
           "MILDLY INCONVENIENCED!"
           "DOOOOOOOMED!")))
  (error-message :doom)

  ;; Numbers are being represented here
  ;; The important one is the ratio at the end which clojure understands
  93
  1.2
  1/5

  ;; Strings are represented very similiar like in other languages
  "Big Boss"
  "\"Solid Snake and Liquid Snake\""
  "\"Les Enfant Terribles\" - The Patriots"
  
  ;; Strings can only be conncatenated using the string function
  (def name 
    "Liquid")
  (str name " Snake")

  ;; MAPS is next
  {
    :first-name "Charlie"
    :last-name "McFishwich"
  }

  { 
    "string-key" +
  }

  {
    :name {
      :first "John" 
      :middle "Jacob" 
      :last "Jingleheimerschmidt"
     }
  }

  (hash-map :a 1 :b 2)
  (get {:a 0 :b 1} :b)
  (get {:a 0 :b {:c "ho hum"}} :b)

  ;; If no return value found it will return nil or
  ;; a default value used for the map
  (get {:a 0 :b 1} :c)
  (get {:a 0 :b 1} :c "Otacon?")

  ;; The get-in function lets us look up values in nested maps
  (get-in {:a 0 :b {:c "ho hum"}} [:b :c])

  ;; We can treat a map as a function and use the key as the argument
  ({:name "The Human Coffeepot"} :name)
  (:d {:a 1 :b 2 :c 3} "No gnome knows homes like Noah knows")

  ;; Vectors as in other math envs is a 0 indexed array
  [3 2 1]
  (get [3 2 1] 0)

  ;; Vectors can be of any type
  (get ["a" {:name "Pugsley Winterbottom"} "c"] 1)

  ;;Can be created using the Vector funcion
  (vector 1 2 3)

  ;; We can use the conj function to add items to the end of the vector
  (conj [1 2 3] 4)

  ;; Lists are different than vectors in syntax and functionality
  ;; it requires a single quote when defining those
  '(1 2 3 4)

  ;; And we can't use get to retreive values we need to use nth fucntion
  (nth '(:a :b :c) 0)

  ;; Lists can also be of any type and can be created using the list function
  (list 1 "two" {3 4})

  ;; Using conj function it adds elements to the beggining of the list
  (conj '(1 2 3) 4)

  ;; Hash sets are unique collections of items of any type
  #{"kurt vonnegut" 20 :icicle}

  ;; Hash sets can also be created using the hash-set function
  (hash-set "test" "test" 2)

  ;; Similar as any SFDC Set it will be unique so adding same value
  ;; will not add an additional value it will keep uniqueness
  (conj #{:a :b} :b)

  ;; Contains will check for set membership
  (contains? #{:a :b} :a)
  (contains? #{:a :b} 2)
  (contains? #{nil} nil)

  ;; We can also use keywords and gets with sets
  (:a #{:a :b})
  (get #{:a :b} :a)

  ;; Functions are an interesting thing in clojure i find this as one of the most
  ;; intriguing pieces of code where a logic operand like "or" can evaluate + and -
  ;; return the first true value (it seems that even negative is a true value maybe != nil)
  ;; and then you can use that function within another function and perform the actual operation
  ;; function structure is (operator operand1 operandn)
  (or - +)
  ((or + -) 1 2 3 4)

  ;; This function call returns the plus since the and operand will return the las truth value
  ;; in the evaluation
  ((and (= 1 1) +) 1 2 3)

  ;; one more example of function calls
  ((first [+ 0]) 1 2 3)

  ;; Functions can be passed as parameters of other functions.
  ;; Functions that can take other functions as params are called higher-order functions,
  ;; programming languages that support high order functions are said to support first class functions
  ;; since they treat functions simalrly as other data types

  (map inc [0 1 2 3 4])

  ;; Functions in clojure use the precedence order
  ;; evaluating the inner most parenthesis first recursively
  ;; (+ (inc 199) (/ 100 (- 7 2)))
  ;; (+ 200 (/ 100 (- 7 2))) First evaluation in the inc function
  ;; (+ 200 (/ 100 5) evaluating the  (- 7 2)
  ;; (+ 200 20)
  ;; 220

  (+ (inc 199) (/ 100 (- 7 2)))

  ;; Function Structure and definition
  ;; 1. function name
  ;; 2. Doc string useful for documentation
  ;; 3. Function arguments or parameters
  ;; 4. Function body
  (defn no-params ;; 1
    "This is the doc string no params 0 arity" ;; 2
    [] ;; 3
    "I take no parameters!") ;; 4
  (defn one-param
    "This is the doc string of function of 1 arity"
    [x]
    (str "I take one parameter: " x))
  (defn two-params
    "This is the doc string of function of 2 arity"
    [x y]
    (str "Two parameters! That's nothing! Pah! I will smoosh them "
    "together to spite you! " x y))

  (no-params)
  (one-param "Snake!!")
  (two-params "Solid" " Snake")
  
  ;; Function can support arity overloading by defining the different body
  ;; depending on the number of parameters each body must be enclosed in parenthesis
  (defn x-chop
    "Describe the kind of chop you're inflicting on someone"
    ([name chop-type]
       (str "I " chop-type " chop " name "! Take that!"))
    ([name]
       (x-chop name "CQC")))
  
  (x-chop "Boss")
  
  ;; Clojure can use a "rest" parameter use to group all the rest of parameters
  ;; this is done by using an & in the paramaters like in the codger
  (defn codger-communication
    "Function that will write an angry message"
    [whippersnapper]
    (str "Time for you to die, " whippersnapper "!!!"))
  
  (defn codger
    "This function will accept parameters and write an angry message about each"
    [& whippersnappers]
    (map codger-communication whippersnappers))

  (codger "The Sorrow" "The Pain" "The Fear" "The Fury" "The Boss")

  ;; We can mix in parameters with the rest param but the only requirement
  ;; is that the rest parameter should come last
  (defn favorite-things
    [name & things]
    (str "Hi, " name ", here are my favorite things: "
         (clojure.string/join ", " things)))
  
  (favorite-things "Big Boss" "Cigar" "M4A" "PSG1")

  ;; Destructuring
  ;; You can define names for specifi items within a collection (Vector) of paramters 
  
  ;; Return the first element of a collection
  (defn my-first
    [[first-thing second-thing & whatever]] ; Notice that first-thing is within a vector
    whatever)

  (my-first ["Patriot" "Patch" "PSG1" "Eva" "Shagohod"])

  (defn chooser
    [[first-choice second-choice & unimportant-choices]]
    (println (str "Your first choice is: " first-choice))
    (println (str "Your second choice is: " second-choice))
    (println (str "We're ignoring the rest of your choices. "
                  "Here they are in case you need to cry over them: "
                  (clojure.string/join ", " unimportant-choices))))
  
  (chooser ["Grey Fox", "Solid Snake", "Solidus", "Liquid" "Ocelot"])

  ;; We can also destructure maps
  (defn announce-treasure-location
    [{lat :lat lng :lng}]
      (println (str "Treasure lat: " lat))
      (println (str "Treasure lng: " lng)))
    
  (announce-treasure-location {:lat 28.22 :lng 81.33})

  ;; This has the same result as before with the addition of
  ;; the ability to keep the old values in the system
  (defn announce-treasure-location
    [{:keys [lat lng] :as treasure-location}]
      (println (str "Treasure lat: " lat))
      (println (str "Treasure lng: " lng)))
    
  (announce-treasure-location {:lat 28.22 :lng 81.33})

  ;; The function body will return always the last line of the body
  ;; the next function has 3 lines and will only return joe but will
  ;; evaluate the complete function
  (defn illustrative-function
    []
    (+ 1 304)
    30
    "joe")

  (illustrative-function)

  ;; Similar function that returns the last line but with an if statement
  (defn number-comment
    [x]
    (if (> x 6)
      "Oh my gosh! What a big number!"
      "That number's OK, I guess"))
  
  (number-comment 5)
  (number-comment 7)

  ;; We can define anonymous functions by using the fn function
  (map (fn [name] (str "Hi, " name))
     ["Adam" "Major Zero" "Eva"])

  ((fn [x] (* x 3)) 8)
  
  ;; we can assign a name to it
  (def my-special-multiplier (fn [x] (* x 3)))
  (my-special-multiplier 3)
  
  ;; Here is a short version on how to define a function
  #(* % 3)
  (#(* % 3) 8)

  ;; Example of anonymous function being passed as a parameter
  (map #(str "Hi, " %)
     ["Adam" "Major Zero" "Eva"])

  ;; You can return functions as return atrributes in which case
  ;; the function has access to all the variables in scope that was created
  (defn inc-maker
    "Create a custom incrementor"
    [inc-by]
    #(+ % inc-by))
  
  (def inc3 (inc-maker 3))
  (inc3 7)

  ;; The let function binds names to values
  (let [x 3]
    x)

  (def cobra-unit-list
    ["The Pain" "The End" "The Sorrow" "The Fury" "The Boss" "The Fear"])
  (let [cobras (take 2 cobra-unit-list)]
    cobras)

  (let [[pain & cobras] cobra-unit-list]
    [pain cobras])

  ;; Using let defines a new scope context
  ;; which means that if a var had a different value before then
  ;; then we can have thje same var with a different value within the scope
  ;; of let
  (def x 0)
  (println (str "Value outer scope: " x))
  (let [x 1] 
    (println (str "Value inner scope: " x)))

  ;; We can also reference existing values into the let scope
  (def x 0)
  (println (str "Value outer scope: " x))
  (let [x (inc x)] 
    (println (str "Value inner scope: " x)))
  (println (str "Value after let scope: " x))

  ;; loop function allows us to recursively traverse something over
  ;; a series of iterations
  (loop [iteration 0]
    (println (str "Iteration " iteration))
    (if (> iteration 13)
      (println "Goodbye!")
      (recur (inc iteration))))

  (re-find #"^left-" "left-eye")
  (re-find #"left-" "cleft-eye")

  ;; CLOJURE CORE FUNCTIONS
  ;; under the clojure env we find that the seq is actually one of the most used
  ;; types since everything gets translated as a seq maps, sets lists and strings so
  ;; far seems to be items that can be transforced into seq
)