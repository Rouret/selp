package lexer;

import java.io.IOException;
import java.io.InputStream;

public class SLexer {
    private static Lexer lexer;

    public static void init(InputStream in) throws IOException {
        SLexer.lexer=new Lexer(in);
    }
    public static Token getToken() throws IOException {
        Token t = lexer.getToken();
        return t;
    }
}
