package calc;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import lexer.*;

public class TestLexer {
	/**
	 * @param args - arg[0] is the filename of the file to analyze,
	 *                otherwise, the program is entered at the console.
	 * IMPORTANT REQUIREMENT: the errors are propagated up the stack.
	 */
	public static void main(String[] args) throws IOException {
		InputStream is;
		String filename;
		List<Token> tokens;

		switch (args.length) {
			case 0 -> is = System.in;
			case 1 -> {
				filename = args[0];
				is = new FileInputStream(filename);
			}
			default -> throw new IllegalArgumentException();
		}

		Lexer lexer = new Lexer(is);
		tokens = lexer.lex();
		// output result
		System.out.println("Found " + tokens.size() + " token(s)");
		System.out.println(tokens);
	}
}
