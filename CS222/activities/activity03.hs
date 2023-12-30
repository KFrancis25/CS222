--Kai Francis
-- head [ ] produces an error because the head function requires a non-empty list as its argument.
-- > head []
-- *** Exception: Prelude.head: empty list

-- tail [ ] produces an error because the tail function requires a non-empty list as its argument.
-- > tail []
-- *** Exception: Prelude.tail: empty list

-- tail (head [1..100]) produces an error because the `head` function returns an element of the list, not a list. The `tail` function requires a list as its argument.
-- > tail (head [1..100])
-- *** Exception: Prelude.tail: expected a list, but got: 1


--number 1
revHead ls = (head (tail ls)) : ((head ls) : (tail (tail ls)))

--number 2
addL :: [a] -> [a] -> [a] -> [a]
addL xs ys zs = xs ++ ys ++ zs

--number 3
firstLast :: [a] -> Either String [a]
firstLast [] = Left "Error: List must have at least two elements."
firstLast [_] = Left "Error: List must have at least two elements."
firstLast xs = Right (init (tail xs))

--number 4
strip :: Int -> [a] -> [a]
strip n xs
  | length xs <= 2 * n = []
  | otherwise = take (length xs - 2 * n) (drop n xs)
