--Kai Francis, COW 2025

--YOUR ANSWER: This code will not compile. The first line sets test1 equal to the number 1, 
-- but the second line tries to define test1 as a function that takes one argument x and returns the number 42.

test1 = 1
test1 x = 42

--YOUR ANSWER: This function expects a non-empty list as input, and returns a tuple containing the first element 
-- and the rest of the list. However, if the input list is empty, this code will throw an error. 
test2 (x:y) = (x,y)

--YOUR ANSWER: This function expects a list with at least three elements, and returns a tuple containing the first three elements. 
-- However, if the input list has fewer than three elements, this code will throw an error. 
test3 (x:y:z) = (x,y,z)

--YOUR ANSWER: This function takes one argument x, but always returns the number 4. It does not use the input value x in any way, 
-- so this function will always return 4.
test4 x = 4

--YOUR ANSWER: This function returns the second element of a list if the list has exactly two elements, and returns the first element of a list otherwise. 
test5 [] = error "bad input"
test5 [1] = error "not horrible input but also not"
test5 [1,x] = x
test5 (h : t) = h

--YOUR ASNWER: This function expects a tuple with two elements, and returns the first element. 
-- However, if the input is not a tuple with two elements, this code will throw an error.
test6 (x,y) = x

--twoHeads function
twoHeads :: [a] -> (a,a)
twoHeads [] = error "List is empty"
twoHeads [x] = error "List has only one element"
twoHeads (x:y:_) = (x, y)

--dAdams function
dAdams :: Int -> String
dAdams 1 = "one"
dAdams 2 = "two"
dAdams 3 = "three"
dAdams _ = "A suffusion of yellow"

--myZip function
myZip :: [a] -> [b] -> [(a,b)]
myZip [] _ = []
myZip _ [] = []
myZip (x:xs) (y:ys) = (x,y) : myZip xs ys
