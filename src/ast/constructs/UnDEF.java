package ast.constructs;


import ast.State;

public class UnDEF extends Exp {

    private OPSYM op;
    private final Exp exp;

    public UnDEF(OPSYM op,Exp value) {
        this.exp = value;
        this.op = op;
    }


    @Override
    public int eval(State<Integer> stateVariables) {
        return -1 * this.exp.eval(stateVariables);
    }

    @Override
    public String gen() {
        return "(" + this.op.toString() + "(" + this.exp.gen()+ ")" + ")";
    }

    @Override
    public String toString() {
        return "UnDEF("+this.exp+")";
    }
}
