package ast.constructs;

import lexer.Token;
import lexer.tokens.DEFVAR;
import lexer.tokens.LPAR;
import ast.AST;
import ast.State;
import ast.SyntaxError;

import static lexer.SLexer.getToken;

import java.io.IOException;
import java.util.List;

public class Body extends AST {

    private final List<VarDef> list;
    private final Exp exp;

    public Body(List<VarDef> list, Exp exp) {
        this.list = list;
        this.exp = exp;
    }


    @Override
    public String gen() {
      return  null;
    }

    @Override
    public String toString() {
        return null;
    }
}
