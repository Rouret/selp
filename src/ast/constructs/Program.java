package ast.constructs;

import ast.AST;

public class Program {
    public static String genMain(AST ast){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("#include <stdio.h>\n\n");
        stringBuilder.append("int main() {\n");
    stringBuilder.append(AST.INDENT+"return printf(\"%i\\n\", "+ast.gen()+");\n");
        stringBuilder.append("}\n");

        return stringBuilder.toString();
    }
}
