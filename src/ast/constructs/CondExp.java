package ast.constructs;

import ast.State;

public class CondExp extends Exp {

    private Exp operand1;
    private Exp operand2;
    private Exp operand3;


    public CondExp(Exp operand1, Exp operand2, Exp operand3) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operand3 = operand3;
    }

    @Override
    public String gen() {
        return "(" + operand1.gen() + "?" + operand2.gen() + ":" + operand3.gen() + ")";
    }

    @Override
    public String toString() {
        return "ConDex(" +
                "," + operand1 +
                "," + operand2 +
                "," + operand3 +
                ')';
    }

    @Override
    public int eval(State<Integer> stateVariables) {
        if(operand1.eval(stateVariables)!= 0){
            return this.operand2.eval(stateVariables);
        }else{
            return this.operand3.eval(stateVariables);
        }
    }
}
