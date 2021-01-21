package lexer;

public class LexicalError extends RuntimeException {
	public LexicalError(int i){
		super("unexpected character : ascii " + i + " - " + (char)i);
	}

}
