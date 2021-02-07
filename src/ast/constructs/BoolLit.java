package ast.constructs;

import ast.AST;
import ast.State;
import ast.SyntaxError;
import typer.SemanticError;
import typer.Type;

public class BoolLit extends Exp {
    private boolean bool;

    public BoolLit(boolean bool) {
        this.bool = bool;
    }

    public static boolean parseBoolean(String value){
        return java.lang.Boolean.parseBoolean(value);
    }

    @Override
    public String gen() {
        return this.bool ? "1" : "0";
    }

    @Override
    public int eval(State<Integer> stateVariables) {
        return this.bool ? 1 : 0;
    }

    @Override
    public Type type(State<Type> stVar) {
        return Type.BOOL;
    }

    @Override
    public void checkDeclarations(State<Type> vars) throws SemanticError {

    }

    @Override
    public String toString() {
        return String.valueOf(bool);
    }

}
