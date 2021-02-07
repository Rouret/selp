package ast.constructs;

import ast.AST;
import ast.State;
import typer.SemanticError;
import typer.Type;

public class VarDef extends AST {

    private Var variable;
    private Exp exp;

    public VarDef(Var variable, Exp exp) {
        this.variable = variable;
        this.exp = exp;
    }

    @Override
    public String gen() {
        return "int "+ this.variable.getVarName() + "=" + this.exp.gen()+";";
    }

    @Override
    public String toString() {
        return "VarDef("+this.variable.getVarName()+","+this.exp+")";
    }

    @Override
    public void checkDeclarations(State<Type> vars) throws SemanticError {
        try {
            if(vars.lookup(this.variable.getVarName()) != null)
                throw new SemanticError(this + " already defined.");
        }catch (RuntimeException exception){
            this.exp.checkDeclarations(vars);
            vars.bind(this.variable.getVarName(), this.exp.type(vars));
        }
    }
}
