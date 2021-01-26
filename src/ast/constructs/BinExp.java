package ast.constructs;

import ast.State;

public class BinExp extends Exp {


    private OPSYM operator;
    private Exp operand1;
    private Exp operand2;

    public BinExp(OPSYM operator) {
        this.operator=operator;
    }

    public BinExp(OPSYM operator, Exp operand1, Exp operand2) {
        this(operator);
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    @Override
    public String gen() {
        return "("+this.operand1.gen()+this.operator.toString()+this.operand2.gen()+")";
    }

    @Override
    public String toString() {
        return "BinExp(" +
                operator +
                "," + operand1 +
                "," + operand2 +
                ')';
    }


    @Override
    public int eval(State<Integer> stateVariables) {
        int resultOperand1 = operand1.eval(stateVariables);
        int resultOperand2 = operand2.eval(stateVariables);

        switch (this.operator){
            case PLUS -> {
                return resultOperand1 + resultOperand2;
            }
            case MINUS -> {
                return resultOperand1 - resultOperand2;
            }
            case DIVIDER -> {
                return resultOperand1 / resultOperand2;
            }
            case TIMES -> {
                return resultOperand1 * resultOperand2;
            }
            case EQUALS -> {
                return resultOperand1 == resultOperand2 ? 1 : 0;
            }
            case LOWER_THAN -> {
                return resultOperand1 < resultOperand2 ? 1 : 0;
            }
            case UPPER_THAN -> {
                return resultOperand1 > resultOperand2 ? 1 : 0;
            }
        }
        return 0;
    }

}
