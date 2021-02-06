package ast.constructs;

import ast.AST;
import ast.State;
import typer.Type;

public abstract class Exp extends AST {
    public abstract int eval(State<Integer> stateVariables);
    public abstract Type type();
}

