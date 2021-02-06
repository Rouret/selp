package ast.constructs;

import ast.AST;

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
