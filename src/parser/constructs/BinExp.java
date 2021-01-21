package parser.constructs;

import lexer.tokens.OP;

public class BinExp extends Exp {

    private OP operator;
    private Exp operand1;
    private Exp operand2;

    public BinExp(OP operator) {
        this.operator = operator;

    }

    @Override
    public String toString() {
        return "BinExp(" +
                operator +
                "," + operand1 +
                "," + operand2 +
                ')';
    }

    public void setOperand1(Exp operand1) {
        this.operand1 = operand1;
    }

    public void setOperand2(Exp operand2) {
        this.operand2 = operand2;
    }

    @Override
    public int eval() {
        int resultOperand1 = operand1.eval();
        int resultOperand2 = operand2.eval();

        if ("+".equals(this.operator.getValue())) {
            return resultOperand1 + resultOperand2;
        } else if ("-".equals(this.operator.getValue())) {
            return resultOperand1 - resultOperand2;
        } else if ("*".equals(this.operator.getValue())) {
            return resultOperand1 * resultOperand2;
        } else if ("/".equals(this.operator.getValue())) {
            return resultOperand1 / resultOperand2;
        }else if ("==".equals(this.operator.getValue())) {
            return resultOperand1 == resultOperand2 ? 1 : 0;
        }
        return 0;

    }

    public OP getOperator() {
        return operator;
    }

    public Exp getOperand1() {
        return operand1;
    }

    public Exp getOperand2() {
        return operand2;
    }
}
