package parser.constructs;

import lexer.tokens.OP;

public class BinExp extends Exp {

    private OPSYM operator;
    private Exp operand1;
    private Exp operand2;

    public BinExp(OP operator) {

        switch (operator.getValue().toLowerCase()){
            case "+" -> {
                this.operator = OPSYM.PLUS;
            }
            case "-" -> {
                this.operator = OPSYM.MINUS;
            }
            case "*" -> {
                this.operator = OPSYM.TIMES;
            }
            case "/" -> {
                this.operator = OPSYM.DIVIDER;
            }
            case "==" -> {
                this.operator = OPSYM.EQUALS;
            }
            case "<" -> {
                this.operator = OPSYM.LOWER_THAN;
            }
            case ">" -> {
                this.operator = OPSYM.UPPER_THAN;
            }
        }
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

    public OPSYM getOperator() {
        return operator;
    }

    public Exp getOperand1() {
        return operand1;
    }

    public Exp getOperand2() {
        return operand2;
    }
}
