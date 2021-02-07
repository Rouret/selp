package ast.constructs;

import ast.AST;
import ast.State;
import typer.SemanticError;
import typer.Type;

import java.util.List;

public class Body extends AST {

    private final List<VarDef> defList;
    private final Exp exp;

    public Body(List<VarDef> defList, Exp exp) {
        this.defList = defList;
        this.exp = exp;
    }

    @Override
    public String gen() {
        StringBuilder stringBuilder = new StringBuilder();

        defList.forEach(varDef -> {
            stringBuilder.append(AST.INDENT + varDef.gen() + "\n");
        });

        exp.type(new State<>());
        stringBuilder.append(AST.INDENT+"return printf(\"%i\\n\", "+exp.gen()+");\n");


        return stringBuilder.toString();
    }
    public static String genMain(AST ast) {

        ast.checkDeclarations(new State<>());

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("#include <stdio.h>\n\n");
        stringBuilder.append("int main() {\n");

        stringBuilder.append(ast.gen());

        stringBuilder.append("}\n");

        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Body([");
        defList.forEach(varDef -> {
            stringBuilder.append(varDef.toString());

            if(!defList.get(defList.size() - 1).equals(varDef)){
                stringBuilder.append(",");
            }
        });
        stringBuilder.append("],"+this.exp.toString()+")");
        return stringBuilder.toString();
    }

    @Override
    public void checkDeclarations(State<Type> vars) throws SemanticError {
        defList.forEach(varDef -> {
            varDef.checkDeclarations(vars);
        });

        this.exp.checkDeclarations(vars);
    }
}
