package lexer;

import lexer.tokens.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Lexer {
	private final InputStream in;
	private int i; // current ASCII character (coded as an integer)
	Buffer buffer;

	public Lexer(InputStream in) throws IOException {
		this.in = in;
		this.buffer = new Buffer();
		next(); // get first character
	}

	// helper method: read next character
	private void next() throws IOException {
		i = in.read();
	}
	
	public List<Token> lex() throws IOException {
		//USELESS
		//USELESS
		//USELESS
		// return the list of tokens recorded in the file
		List<Token> tokens = new ArrayList<>();
		
		try {
			Token token = getToken();
			while (! (token instanceof EOF)) {
				tokens.add(token);
				token = getToken();
			}
			tokens.add(token); // this is the EOF token
		} catch (IOException e){
				in.close(); // close the reader
				throw e; // pass the exception up the stack
		}
		return tokens;
	}

	public Token getToken() throws IOException{
		switch (i) {
			case '(' -> {
				next();
				return new LPAR();
			}
			case ')' -> {
				next();
				return new RPAR();
			}
			case '=' -> {
				next();
				return this.match('=') ? new OP("==") : new DEFVAR();
			}
			case '+', '-', '*', '/', '<' , '>' -> {
				String operator = Character.toString(this.currentChar());
				next();
				return new OP(operator);
			}
			case 10,9, 13, ' ' -> {
				next();
				return this.getToken();
			}
			case -1 -> {
				in.close();
				return new EOF();
			}
			default -> {
				if (this.isDigit(this.currentChar())) {
					return this.number();
				}
				if (this.isLetter(this.currentChar())) {
					return this.identifierOrIf();
				}
				throw new LexicalError(i);
			}
		}
	}

	/**
	 * @return INTEGER
	 */
	private Token number() throws IOException {
		if(this.currentChar()=='0'){
			this.next();
			return new INTEGER(0);
		}
		while (this.currentChar()!=' ' && this.isDigit(this.currentChar())){
			this.buffer.add(this.currentChar());
			this.next();
		}
		String returnValue=this.buffer.getBuffer();
		this.buffer.reset();
		return new INTEGER(Integer.parseInt(returnValue));
	}

	/**
	 * @return IDENTIFIER
	 */
	private Token identifierOrIf() throws IOException {
		while (this.currentChar()!=' ' && (this.isLetter(this.currentChar()) || this.isDigit(this.currentChar()))){
			this.buffer.add(this.currentChar());
			this.next();
		}
		String returnValue=this.buffer.getBuffer();
		this.buffer.reset();
		if(returnValue.equals("if")){
			return new IF();
		}else if (returnValue.equals("defun")){
			return new DEFUN();
		}

		return new IDENTIFIER(returnValue);
	}


	private char currentChar(){
		return (char) this.i;
	}
	/**
	 * @param expected char attendu
	 * @return true si le character prochain est celui attendu
	 */
	private boolean match(char expected) throws IOException {
		if (i != expected) return false;
		next();
		return true;
	}

	/**
	 * @param c le char en question
	 * @return true si l'element en question est un chiffre
	 */
	private boolean isDigit(char c) {
		return c >= '0' && c <= '9';
	}

	/**
	 * @param c le char en question
	 * @return true si l'element en question est une lettre
	 */
	private boolean isLetter(char c) {
		return c >= 'a' && c <= 'z';
	}
}


