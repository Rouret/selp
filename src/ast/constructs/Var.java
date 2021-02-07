package ast.constructs;

import ast.State;
import typer.SemanticError;
import typer.Type;

public class Var extends Exp {

    private final String varName;
    private Type type;

    public Var(String varName) {
        this.varName = varName;
    }

    public String getVarName() {
        return varName;
    }

    @Override
    public String gen() {
        return this.varName;
    }

    @Override
    public int eval(State<Integer> stateVariables) {
        return 0;
    }

    @Override
    public Type type(State<Type> stVar) {
        return Type.INT;
    }

    @Override
    public void checkDeclarations(State<Type> vars) throws SemanticError {
        try {
            Type type = vars.lookup(this.varName);
            this.type=type;
        }catch (RuntimeException exception){
            throw new SemanticError(this.varName+" is not defined");
        }
    }

    @Override
    public String toString() {
        return "VAR("+this.varName+")";
    }
}
