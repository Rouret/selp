package ast.constructs;

import ast.State;
import typer.SemanticError;
import typer.Type;

public class IntLit extends Exp {

    private final int value;



    public IntLit(int value) {
        this.value = value;
    }

    @Override
    public String gen() {
        return String.valueOf(this.value);
    }

    @Override
    public String toString() {
        return "IntLit(" + this.value + ")";
    }

    @Override
    public int eval(State<Integer> stateVariables) {
        return value;
    }

    @Override
    public Type type(State<Type> stVar) {
        return Type.INT;
    }

    @Override
    public void checkDeclarations(State<Type> vars) throws SemanticError {

    }

    public int getValue() {
        return value;
    }

}
