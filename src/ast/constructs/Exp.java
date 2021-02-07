package ast.constructs;

import ast.AST;
import ast.State;
import typer.SemanticError;
import typer.Type;

public abstract class Exp extends AST {
    public abstract int eval(State<Integer> stateVariables);
    public abstract Type type(State<Type> stVar);

    @Override
    public void checkDeclarations(State<Type> vars) throws SemanticError {

    }
}

