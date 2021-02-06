package ast.constructs;

import ast.AST;

import java.util.List;

public class Body extends AST {

    private final List<VarDef> defList;
    private final Exp exp;

    public Body(List<VarDef> defList, Exp exp) {
        this.defList = defList;
        this.exp = exp;
    }


    /* piste rouge
    @Override
    public String gen() {
        StringBuilder stringBuilder = new StringBuilder();

        defList.forEach(varDef -> {
            stringBuilder.append(AST.INDENT + varDef.gen() + "\n");
        });

        stringBuilder.append(AST.INDENT+"return printf(\"%i\\n\", "+exp.gen()+");\n");

        return stringBuilder.toString();
    }

    public String genMain() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("int main() {\n");

        defList.forEach(varDef -> {
            stringBuilder.append(AST.INDENT + varDef.gen() + "\n");
        });

        stringBuilder.append(AST.INDENT+"return printf(\"%i\\n\", "+exp.gen()+");\n");

        stringBuilder.append("}\n");

        return stringBuilder.toString();
    }*/

    @Override
    public String gen() {
        StringBuilder stringBuilder = new StringBuilder();


        defList.forEach(varDef -> {
            stringBuilder.append(AST.INDENT + varDef.gen() + "\n");
        });

        stringBuilder.append(AST.INDENT+"return printf(\"%i\\n\", "+exp.gen()+");\n");


        return stringBuilder.toString();
    }
    public static String genMain(AST ast) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("#include <stdio.h>\n\n");
        stringBuilder.append("int main() {\n");

        stringBuilder.append(ast.gen());

        stringBuilder.append("}\n");

        return stringBuilder.toString();
    }




    @Override
    public String toString() {
        return "Body";
    }
}
