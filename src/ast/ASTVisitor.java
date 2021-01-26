package ast;

import ast.constructs.*;
import parser.CalcBaseVisitor;
import parser.CalcParser;


public class ASTVisitor extends CalcBaseVisitor<AST> {
    @Override
    public AST visitIntLit(CalcParser.IntLitContext ctx) {
        return new IntLit(Integer.parseInt(ctx.getText()));
    }

    @Override
    public AST visitUnExp(CalcParser.UnExpContext ctx) {
        System.out.println(ctx.expression().getChildCount());
        Exp exp1=(Exp)visit(ctx.expression());
        CalcParser.ExpressionContext exp2= ctx.tail().expression();
        if(exp2 == null){
            return new UnDEF(exp1);
        }
        return new BinExp("-", exp1, (Exp)visit(exp2));
    }

    @Override
    public AST visitBinExp(CalcParser.BinExpContext ctx) {
        String op =ctx.OP().toString();
        Exp exp1 = (Exp)visit(ctx.expression().get(0));
        Exp exp2 = (Exp)visit(ctx.expression().get(1));
        return new BinExp(op, exp1, exp2);
    }

    @Override
    public AST visitCondExp(CalcParser.CondExpContext ctx) {
        Exp exp1 = (Exp)visit(ctx.expression().get(0));
        Exp exp2 = (Exp)visit(ctx.expression().get(1));
        Exp exp3 = (Exp)visit(ctx.expression().get(2));
        return new CondExp(exp1, exp2, exp3);
    }

}
