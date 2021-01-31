package ast.constructs;

import ast.State;

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
        return 0;
    }
}
