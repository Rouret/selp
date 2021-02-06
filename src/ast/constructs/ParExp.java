package ast.constructs;

import ast.State;
import ast.SyntaxError;
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
    public Type type() {
        return this.expression.type();
    }

    @Override
    public String toString() {
        return "ParExp(" +
                expression.toString() +
                ')';
    }
}
