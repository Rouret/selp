package ast.constructs;

import lexer.Token;
import lexer.tokens.IDENTIFIER;
import lexer.tokens.RPAR;
import ast.AST;
import ast.State;
import ast.SyntaxError;

import java.io.IOException;

import static lexer.SLexer.getToken;
public class VarDef extends AST {

    private final String varName;
    private final Exp exp;

    public VarDef(String varName, Exp exp) {
        this.varName = varName;
        this.exp = exp;
    }



    public void eval(State<Integer> stateVariables){
        stateVariables.bind(this.varName,this.exp.eval(stateVariables));
    }

    @Override
    public String gen() {
        return "int "+ varName+ "=" + this.exp.gen()+";";
    }

    @Override
    public String toString() {
        return null;
    }
}
