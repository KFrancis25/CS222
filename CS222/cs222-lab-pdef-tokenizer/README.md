# Lab - PDef Tokenizer

You will first complete the implementation of a lexical analyzer for PDef-lite, then extend that implementation for PDef.
It is expected that you have read chapters 11 and 12 of Programming Languages Through Translation.
In particular, chapter 12 provides the background for the steps you will be completing.

It includes the following starter code:

```
debug/
  Debug.java
  TokenizerDebug.java
tokenizer/
  Token.java
  Tokenizer.java
PDef.java
test
test2
README.md
```

## What does each component do?

* `debug/` contains a Debug superclass and TokenizerDebug subclass.
It implements the debugging framework.
The tokenizer debugger has method `show("debug msg")` which will display the given debug message if the program was executed with debugging enabled.

* `tokenizer/` contains a Token class and Tokenizer class.
The tokenizer implements obtaining the next token from a given file.
A token consists of a name and token type.

* `README.md` That's what you're seeing right now.

* `PDef.java` is the main driver which tests the tokenizer.
You can use `test` and `test2` as example input files, which are programs written in the PDef language.
`PDef.java` will read them as input and use the tokenizer to identify each token.



## Tasks
Follow along with chapter 12 of your book.

0. [ ] Edit the `main()` so that the first line of the tokenizer output is your name.

---

1. [ ] Complete Activity 30 (pg 198) - Compile and execute the driver program in `PDef.java`. Use the following commands to compile the program and run it twice - once with the debugger disabled and the second time with the debugger enabled.
```
javac PDef.java
java PDef test
java PDef test t
```

You should see the following output after the first execution (you'll see a more detailed output with the debugger enabled):
```
Tokens appearing in input file `test'

IDENT_T( { )
IDENT_T( A )
IDENT_T( x )
IDENT_T( y )
IDENT_T( = )
IDENT_T( B )
IDENT_T( , )
IDENT_T( i )
IDENT_T( n )
IDENT_T( t )
IDENT_T( B )
IDENT_T( , )
IDENT_T( { )
IDENT_T( i )
IDENT_T( n )
IDENT_T( t )
IDENT_T( A )
IDENT_T( , )
IDENT_T( B )
IDENT_T( = )
IDENT_T( A )
IDENT_T( , )
IDENT_T( f )
IDENT_T( l )
IDENT_T( o )
IDENT_T( a )
IDENT_T( t )
IDENT_T( C )
IDENT_T( , )
IDENT_T( c )
IDENT_T( h )
IDENT_T( a )
IDENT_T( r )
IDENT_T( B )
IDENT_T( , )
IDENT_T( C )
IDENT_T( = )
IDENT_T( A )
IDENT_T( } )
IDENT_T( , )
IDENT_T( c )
IDENT_T( h )
IDENT_T( a )
IDENT_T( r )
IDENT_T( A )
IDENT_T( b )
IDENT_T( c )
IDENT_T( d )
IDENT_T( } )
EOF_T(  )

All done!
```

Based on the output, draw the finite state machine that seems to describe the tokens being recognized. Note that this isn't complete... we'll fix it in later tasks!

---

2. [ ] Complete Activity 31
