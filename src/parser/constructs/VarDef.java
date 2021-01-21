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

    private String varName;
    private Exp exp;

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

    public void eval(State<Integer> stateVariables, State<FunDef> stateFunDef){
        stateVariables.bind(this.varName,this.exp.eval(stateVariables, stateFunDef));
    }
    @Override
    public String toString() {
        return null;
    }
}
