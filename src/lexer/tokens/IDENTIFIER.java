package lexer.tokens;

import lexer.Token;

public class IDENTIFIER implements Token {
    private final String value;

    public IDENTIFIER(String value){
        this.value = value;
    }

    public String toString() {
        return ("IDENTIFIER("+this.value+")");
    }
}
