package ast.constructs;


import ast.State;
import typer.SemanticError;
import typer.Type;


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
    public Type type(State<Type> stVar) {
        switch (this.op.toString()){
            case "-":
                if(this.exp.type(stVar) != Type.INT)
                    throw new SemanticError(this.exp + " must be literal expression.");
                return Type.INT;
            case "!":
                if(this.exp.type(stVar) != Type.BOOL)
                    throw new SemanticError(this.exp + " must be boolean expression.");
                return Type.BOOL;
            default:
                throw new RuntimeException();
        }
    }

    @Override
    public void checkDeclarations(State<Type> vars) throws SemanticError {
        this.exp.checkDeclarations(vars);
    }

    @Override
    public String gen() {
        return "(" + this.op.toString() + "(" + this.exp.gen()+ ")" + ")";
    }

    @Override
    public String toString() {
        return "UnDEF("+this.op+","+this.exp+")";
    }


}
