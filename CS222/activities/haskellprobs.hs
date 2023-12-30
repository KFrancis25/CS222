--Problem 1
--doubling even numbers in a list using map and a list comprehension

allEven :: [Int] -> [Int]
allEven [] = []
allEven xs = [2 * x | x <- xs, even x]

--problem 2
--given a list of integers, return a list of tuples when each tuple consists of the integer and its square root

squareRoots :: [Int] -> [(Int, Float)]
squareRoots ls = [(x, sqrt(fromIntegral x)) | x <- ls]

--problem 3
--find the product of the non-negative numbers in a list using foldr
-- productNonNeg :: [Int] -> Int
-- productNonNeg xs = foldr (\x acc -> if x >= 0 then x * acc else acc)  l xs

--Problem 4
--write a function to add the odd numbers in a list
oddSum :: [Int] -> [Int]
oddSum xs = sum [x | x <- xs, odd x]

--Problem 5
--given a list of tuples where the first element is a string and the second element
-- is a list of integers, return a list of tuples where the first element is the string
-- and the second element is the sum of the integers in the list

sumTuples :: [(String, [Int])] -> [(String, Int)]
sumTuples xs = [(s, sum) | (s, l) <- xs]

--problem 6
-- given a string return a tuple containing the string and the count of the vowels
-- in the string
countVowels :: String -> Int
countVowels xs = length [x | x <- xs, elem x "aeiouAEIOU"]

countVowels :: String -> (String, Int)
countVowels xs = l
-- problem 7
-- write a function that returns the list of all divisors in integer n