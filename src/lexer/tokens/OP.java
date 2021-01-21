package lexer.tokens;

import lexer.Token;

public class OP implements Token {


    private final String value;

    public OP(String value){
        this.value = value;
    }

    public String toString() {
        return ("OP("+this.value+")");
    }

    public String getValue() {
        return value;
    }


}
