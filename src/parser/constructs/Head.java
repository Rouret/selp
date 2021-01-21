package parser.constructs;

import lexer.Token;
import lexer.tokens.IDENTIFIER;
import lexer.tokens.LPAR;
import lexer.tokens.RPAR;
import parser.AST;
import parser.SyntaxError;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static lexer.SLexer.getToken;

public class Head extends AST {

    private IDENTIFIER functionId;
    private List<IDENTIFIER> args;

    public IDENTIFIER getFunctionId() {
        return functionId;
    }

    public List<IDENTIFIER> getArgs() {
        return args;
    }

    public Head(IDENTIFIER functionId, List<IDENTIFIER> variableId) {
        this.functionId = functionId;
        this.args = variableId;
    }

    public static Head parse(Token token) throws SyntaxError, IOException {
        //'(' functionId variableId* ')'

        if(!(token instanceof LPAR)) throw new SyntaxError("");
        token=getToken();

        if(!(token instanceof IDENTIFIER)) throw new SyntaxError("");
        IDENTIFIER identifier= (IDENTIFIER) token;

        token=getToken();
        List<IDENTIFIER> args = new ArrayList<>();

        while (token instanceof IDENTIFIER){
            args.add((IDENTIFIER) token);
            token=getToken();
        }

        if(!(token instanceof RPAR)) throw new SyntaxError("");
        Head head  = new Head(identifier,args);
        return head;
    }
    @Override
    public String toString() {
        return "Head("+this.functionId+")";
    }
}
