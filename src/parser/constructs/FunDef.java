package parser.constructs;

import lexer.Token;
import lexer.tokens.DEFUN;
import lexer.tokens.IDENTIFIER;
import lexer.tokens.LPAR;
import lexer.tokens.RPAR;
import parser.AST;
import parser.SyntaxError;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static lexer.SLexer.getToken;

public class FunDef extends AST {

    private Head head;
    private Body body;


    public Body getBody() {
        return body;
    }

    public Head getHead() {
        return head;
    }

    public FunDef(Head varName, Body body) {
        this.head = varName;
        this.body = body;
    }

    public static FunDef parse(Token token) throws IOException, SyntaxError {
        //funcDef  : '(' 'defun' '(' functionId variableId* ')' body ')'
        if (!(token instanceof LPAR)) throw new SyntaxError("");
        token = getToken();
        if (!(token instanceof DEFUN)) throw new SyntaxError("");
        token = getToken();
        Head head= Head.parse(token);

        Body body= Body.parse(getToken(),new ArrayList<>());

        token=getToken();
        if(!(token instanceof RPAR)) throw new SyntaxError("");

        return new FunDef(head,body);

    }
    @Override
    public String toString() {
        return null;
    }
}
