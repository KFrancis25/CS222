import Data.Char --used for Char
import Data.List --used later for insert


cap :: [Char] -> [Char]
cap [] = []
cap (a : ls) = (toUpper a) : (cap ls)

cap2 :: [Char] -> [Char]
cap2 ls = map toUpper ls

absList :: [Int] -> [Int]
absList [] = []           -- base case: empty list
absList (x:xs) = abs x : absList xs    -- recursive case: add absolute value of x to result

stringLengths :: [String] -> [Int]
stringLengths = map length'
  where length' str = length str

--foldr (holds 3 parameters)
-- foldr :: (a -> b -> b) -> b -> [a] -> b
-- foldr f z [] = z
-- foldr f z (x : xs) = f x (foldr f z xs) 

sumAll :: [Int] -> Int
sumAll ls = foldr (+) 0 ls

insertionSort :: [Int] -> [Int]
insertionSort ls = foldr insert [] ls

coolFactorial :: [Int] -> Int
coolFactorial xs = foldr (*) 1 xs

