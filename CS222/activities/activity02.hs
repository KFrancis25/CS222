-- what does this function do???
mystery :: Integer -> Integer
mystery n = if n >= 0 then n else (-n)

-- doublesmall function
doubleSmall :: Int -> Int
doubleSmall x = if x <= 100 then x * 2 else x

--area of a circle
circleArea :: Float -> Float
circleArea r = pi * r * r

--whatToWear
whatToWear :: Float -> (Float, String)
whatToWear fahrenheit = (celsius, recommendation)
    where celsius = (fahrenheit - 32) * 5 / 9
          recommendation
            | celsius <= 0   = "Wear a coat!"
            | celsius < 40   = "Consider a light jacket."
            | celsius >= 40  = "Avoid going outside at all."
