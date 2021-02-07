package ast.constructs;

import ast.State;
import typer.SemanticError;
import typer.Type;


public class ParExp extends Exp{
    private Exp expression;

    public ParExp(Exp expression){
        this.expression = expression;
    }

    @Override
    public String gen() {
        return "( " + this.expression.gen() + " )";
    }

    @Override
    public int eval(State<Integer> stateVariables) {
        return this.expression.eval(stateVariables);
    }

    @Override
    public Type type(State<Type> stVar) {
        return this.expression.type(stVar);
    }

    @Override
    public void checkDeclarations(State<Type> vars) throws SemanticError {
        this.expression.checkDeclarations(vars);
    }

    @Override
    public String toString() {
        return "ParExp(" +
                expression.toString() +
                ')';
    }
}
