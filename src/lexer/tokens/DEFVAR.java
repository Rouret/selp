package lexer.tokens;

import lexer.Token;

public class DEFVAR implements Token {
    @Override
    public String toString() {
        return "DEFVAR";
    }
}
