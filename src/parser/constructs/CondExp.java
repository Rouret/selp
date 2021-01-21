package parser.constructs;

import lexer.tokens.IF;
import parser.State;

class ConDex extends Exp {

    private final IF operator;
    private Exp operand1;
    private Exp operand2;
    private Exp operand3;


    public ConDex(IF operator) {
        this.operator = operator;
    }

    public void setOperand1(Exp operand1) {
        this.operand1 = operand1;
    }

    public void setOperand2(Exp operand2) {
        this.operand2 = operand2;
    }

    public void setOperand3(Exp operand3) {
        this.operand3 = operand3;
    }

    @Override
    public String toString() {
        return "ConDex(" +
                operator +
                "," + operand1 +
                "," + operand2 +
                "," + operand3 +
                ')';
    }

    @Override
    public int eval(State<Integer> stateVariables, State<FunDef> stateFunDef) {
        if(operand1.eval(stateVariables, stateFunDef)!= 0){
            return this.operand2.eval(stateVariables, stateFunDef);
        }else{
            return this.operand3.eval(stateVariables, stateFunDef);
        }
    }
}
