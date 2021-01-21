package lexer.tokens;

import lexer.Token;

public class INTEGER implements Token {
    private final int value;

    public INTEGER(int value){
        this.value = value;
    }

    public String toString() {
        return ("INTEGER("+this.value+")");
    }

    public int getValue() {
        return value;
    }
}
