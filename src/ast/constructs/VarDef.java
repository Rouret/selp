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

    private Var variable;
    private Exp exp;

    public VarDef(Var variable, Exp exp) {
        this.variable = variable;
        this.exp = exp;
    }

    @Override
    public String gen() {
        return "int "+ this.variable.getVarName() + "=" + this.exp.gen()+";";
    }

    @Override
    public String toString() {
        return "VarDef("+this.variable.getVarName()+","+this.exp+")";
    }
}
