-- The GHCi interpreter returns the type signature of drop, which takes an Int and a list of any type a and returns a list of the same type a. 
-- :t drop 2, which asks for the type of drop when it is partially applied with an argument of 2. 
--This returns a new type signature, which shows that drop 2 takes a list of any type a and returns a list of the same type a.
--This means that when drop 2 is applied to a list, it returns a new list with the first two elements removed.

list2drop :: [[a]] -> [[a]]
list2drop ls = map (drop 2) ls


-- increment :: Int -> Int
increment x = x + 1

addOneAll :: [Int] -> [Int]
addOneAll xs = map increment xs

powerAll :: [Int] -> [Int]
powerOfTwo x = 2 ^ x
powerAll xs = map powerOfTwo xs

-- this takes the instructions from the line and outputs all integers from 1-100 that are less than 10
-- ghci> [x | x <- [1..100], x < 10]
-- [1,2,3,4,5,6,7,8,9]


-- these functions take the arguments in the set and output the corresponding integers or sets of integers
-- ghci> [(x,y) | x <- [2, 3, 4], y <- [5, 6]]
-- [(2,5),(2,6),(3,5),(3,6),(4,5),(4,6)]
-- ghci> [(i, j) | i <- [1..10], even i, j <- [i..10], odd j]
-- [(2,3),(2,5),(2,7),(2,9),(4,5),(4,7),(4,9),(6,7),(6,9),(8,9)]

quickSort :: [Int] -> [Int]
quickSort [] = []
quickSort (x:xs) = quickSort [y | y <- xs, y < x] ++ [x] ++ quickSort [y | y <- xs, y >= x]


insert' :: Ord a => [a] -> a -> [a]
insert' xs x = [y | y <- xs, y <= x] ++ [x] ++ [y | y <- xs, y > x]


-- | This function takes a list of integers, and returns a list of strings.
-- | If an integer is less than 10 and odd, the corresponding string is "BOOM!",
-- | otherwise it is "BANG!".
boomBangs :: [Int] -> [String]
boomBangs xs = [if x < 10 then "BOOM!" else "BANG!" | x <- xs, odd x]


-- | This function takes a list of integers and returns a list of strings.
-- | For each integer in the input list, if it is divisible by 3, the string "fizz" is added to the output list.
-- | If it is divisible by 5, the string "buzz" is added to the output list.
-- | If it is divisible by both 3 and 5, the string "fizz buzz" is added to the output list.
-- | Otherwise, the integer is converted to a string and added to the output list.
fizzBuzz :: [Int] -> [String]
fizzBuzz xs = [if x `mod` 3 == 0 && x `mod` 5 == 0 then "fizz buzz"
               else if x `mod` 3 == 0 then "fizz"
               else if x `mod` 5 == 0 then "buzz"
               else show x | x <- xs]


-- | This function takes a string and returns a new string with all uppercase characters removed.
removeUpperCase :: String -> String
removeUpperCase str = [c | c <- str, not (elem c ['A'..'Z'])]
