package parser;

import debug.*;
import exceptions.ParseException;
import syntaxTree.BlockST;
import tokenizer.*;
import tokenizer.Token.TokenType;

/*
This class defines a recursive descent parser for the language PDef-light with context free grammar as follows:

    Program     --> Block
    Block       --> lcbT StmtList rcbT
    StmtList    --> Stmt { commaT Stmt }
    Stmt        --> Declaration | Assignment | Block
    Declaration --> typeT identT
    Assignment  --> identT assignT identT
    
In this grammar the terminals lcbT, rcbT, commaT, identT, typeT, assignT represent tokens in the lexical description for PDef-light.

*/

public class Parser {

	// Class Invariant:
	// The data member currentToken is a
	// reference to the next token of interest.
	private Tokenizer tokenStream;
	private ParserDebug debug;
	private Token currentToken;

	// Pre: tokenStream has a value
	// Post: debug == new ParserDebug() AND
	// 		this.tokenStream == tokenStream AND
	// 		class invariant is true
	public Parser(Tokenizer tokenStream) {
		this.debug = new ParserDebug();
		this.tokenStream = tokenStream;

		// ensure class invariant is true for call to parseProgram
		currentToken = tokenStream.getNextToken();
	}

	// Grammar Rule: Program --> Block eotT
	public BlockST parseProgram() throws ParseException{
		debug.show(">>> Entering parseProgram");

		parseBlock();
		consume(Token.TokenType.EOF_T);

		debug.show("<<< Leaving parseProgram");
		return null;
	}

	// Grammar Rule: Block --> lcbT StmtList rcbT
	private void parseBlock() throws ParseException{
		debug.show(">>> Entering parseBlock");

		consume(Token.TokenType.LCB_T);
		parseStmtList();
		consume(Token.TokenType.RCB_T);

		debug.show("<<< Leaving parseBlock");
	}

	// Grammar Rule: StmtList --> Stmt [ commaT Stmt ]
	private void parseStmtList() throws ParseException{
		debug.show(">>> Entering parseStmtList");

		parseStmt();
		while( currentToken.getType() == Token.TokenType.COMMA_T ) {
			consume(Token.TokenType.COMMA_T);
			parseStmt();
		}

		debug.show("<<< Leaving parseStmtList");
	}

	// Grammar Rule: Stmt --> Assignment | Declaration | Block
	private void parseStmt() throws ParseException{
		debug.show(">>> Entering parseStmt");

		try{

			if (currentToken.getType() == TokenType.IDENT_T)
				parseAssignment();
			else if(currentToken.getType() == TokenType.TYPE_T)
				parseDeclaration();
			else if(currentToken.getType() == TokenType.LCB_T)
				parseBlock();

			if ( !canFollowStmt(currentToken)) {
				throw new ParseException("Expected a statement terminator.", currentToken);
			}
		}

		catch (ParseException exc) {
			exc.print();
			consume2StatementEnd();
		}
		debug.show("<<< Leaving parseStmt");
		}
		
		

	private boolean canFollowStmt(Token t) {
		Token.TokenType type = t.getType();
		return (type == Token.TokenType.COMMA_T) ||
			(type == Token.TokenType.RCB_T) ||
			(type == Token.TokenType.EOF_T);
	}

	private void consume2StatementEnd() {
		while ( !canFollowStmt(currentToken)) {
			currentToken = tokenStream.getNextToken();
		}
	}

	// Grammar Rule: Assignment --> identT assign identT
	private void parseAssignment() throws ParseException {
		consume(Token.TokenType.IDENT_T);

		try { consume(Token.TokenType.ASSIGN_T); }
		catch (ParseException exc) {
			exc.print();
		}
		consume(Token.TokenType.IDENT_T);
	}

	// Grammar Rule: Declaration --> typeT identT
	private void parseDeclaration() throws ParseException {
		debug.show(">>> Entering parseDeclaration");
		consume(Token.TokenType.TYPE_T);
		consume(Token.TokenType.IDENT_T);
		
		debug.show("<<< Leaving parseDeclaration");
	}

	private void error() {}

	private void consume(Token.TokenType type) throws ParseException { 
		if (currentToken.getType() != type) {
			String msg = "Expected to see token" + type +
				" but saw token " + currentToken.getType(); 
				 throw new ParseException(msg, currentToken);
		}
		currentToken = tokenStream.getNextToken();

	}



	/**
	 * @throws ParseException
	 */
	private void parseOtherExp() throws ParseException {
		debug.show(">>> Entering parseOtherExpr");

		if ( !canFollowOtherExpr(currentToken)) {

			if(currentToken.getType() == TokenType.ADD_T)
				consume(TokenType.ADD_T);
			else if (currentToken.getType() == TokenType.SUB_T)
				consume(TokenType.SUB_T);
			else{
				throw new ParseException("Expected to see ADD_T or SUB_T", currentToken);
			}

			parseTerm();
			parseOtherExp();
		}

		debug.show("<<< Leaving parseOtherExpr");

	
	}

	private void parseTerm() {
	}

	private void parseOtherTerm() throws ParseException {
		debug.show(">>> Entering parseOtherTerm");

		if ( !canFollowOtherTerm(currentToken)) {

			if(currentToken.getType() ==TokenType.MUL_T){
				consume(TokenType.MUL_T);
			}
			else if (currentToken.getType() == TokenType.DIV_T){
				consume(TokenType.DIV_T);
			}
			else if (currentToken.getType() == TokenType.MOD_T){
				consume(TokenType.MOD_T);
			}  
			else{
				throw new ParseException("Expected to see MUL_T, DIV_T, or MOD_T", currentToken);
			}

			parseFactor();
			parseOtherTerm();
		}

		debug.show("<<< Leaving parseOtherTerm");
	}


	private void parseFactor() {
	}

	private boolean canFollowOtherTerm(Token t) {
		Token.TokenType type = t.getType();
		return (type == Token.TokenType.ADD_T || 
				type == Token.TokenType.SUB_T || 
				type == Token.TokenType.COMMA_T ||
				type == Token.TokenType.RCB_T ||
				type == Token.TokenType.RP_T);
	}

	/**
	 * @param t
	 * @return
	 */
	private boolean canFollowOtherExpr(Token t) {
		Token.TokenType type = t.getType();
		return (type == Token.TokenType.RP_T) ||
				(type == Token.TokenType.COMMA_T) ||
				(type == Token.TokenType.RCB_T);
	}
}