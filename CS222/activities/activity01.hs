fact :: Integer -> Integer
> fact 0 = 1
> fact n = n * (fact (n-1))

div10by5 :: Integer
> div10by5 = div 10 5

choose :: Integer -> Integer -> Integer
> choose n k = product [k+1..n] `div` product [1..n-k]

fib :: Integer -> Integer
> fib 0 = 0
> fib 1 = 1
> fib n = fib (n-1) + fib (n-2)

abs2 :: Integer -> String
> abs2 x = if x < 0 then "(" ++ show (abs x) ++ ")" else show x
