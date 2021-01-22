package parser.constructs;

import lexer.Token;
import lexer.tokens.IDENTIFIER;
import lexer.tokens.RPAR;
import parser.AST;
import parser.State;
import parser.SyntaxError;

import java.io.IOException;

import static lexer.SLexer.getToken;
public class VarDef extends AST {

    private final String varName;
    private final Exp exp;

    public VarDef(String varName, Exp exp) {
        this.varName = varName;
        this.exp = exp;
    }

    public static VarDef parse (Token token) throws IOException, SyntaxError {
        if(!(token instanceof IDENTIFIER)) throw new SyntaxError("Must be an Identifier");
        Var var = new Var(((IDENTIFIER) token).getValue());
        Exp exp = Exp.parse(getToken());
        if (!(getToken() instanceof RPAR)) throw new SyntaxError("Missing ')'");
        return new VarDef(var.getVarName(), exp);
    }

    public void eval(State<Integer> stateVariable){
        stateVariable.bind(this.varName,this.exp.eval(stateVariable));
    }
    @Override
    public String toString() {
        return null;
    }
}
