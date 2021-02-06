package ast;

import ast.constructs.*;
import parser.CalcBaseVisitor;
import parser.CalcParser;

import java.util.ArrayList;
import java.util.List;


public class ASTVisitor extends CalcBaseVisitor<AST> {
    @Override
    public AST visitIntLit(CalcParser.IntLitContext ctx) {
        return new IntLit(Integer.parseInt(ctx.getText()));
    }

    @Override
    public AST visitUnDEF(CalcParser.UnDEFContext ctx) {
        OPSYM operator = OPSYM.parseOP(ctx.getChild(0).getText());
        Exp exp1=(Exp)visit(ctx.expression());
        //CalcParser.ExpressionContext exp2= ctx.tail().expression();
        return new UnDEF(operator,exp1);
    }

    @Override
    public AST visitBinExp(CalcParser.BinExpContext ctx) {
        OPSYM operator = OPSYM.parseOP(ctx.getChild(1).getText());
        Exp exp1 = (Exp)visit(ctx.expression().get(0));
        Exp exp2 = (Exp)visit(ctx.expression().get(1));
        return new BinExp(operator, exp1, exp2);
    }

    @Override
    public AST visitBoolLit(CalcParser.BoolLitContext ctx) {
        boolean bool=Boolean.parseBoolean(ctx.getChild(0).getText());
        return new BoolLit(bool);
    }

    @Override
    public AST visitTernaryExp(CalcParser.TernaryExpContext ctx) {
        Exp toTest = (Exp)visit(ctx.expression().get(0));
        Exp ExpIsTrue = (Exp)visit(ctx.expression().get(1));
        Exp ExpIsFalse = (Exp)visit(ctx.expression().get(2));
        return new CondExp(toTest,ExpIsTrue,ExpIsFalse);
    }

    @Override
    public AST visitParExp(CalcParser.ParExpContext ctx) {
        return new ParExp((Exp)visit(ctx.expression()));
    }

    @Override
    public AST visitVariableId(CalcParser.VariableIdContext ctx) {
        return new Var(ctx.getText());
    }

    @Override
    public AST visitVarDef(CalcParser.VarDefContext ctx) {
        Var varId = (Var)visit(ctx.variableId());
        Exp expression = (Exp)visit(ctx.expression());
        return new VarDef(varId, expression);
    }

    @Override
    public AST visitBody(CalcParser.BodyContext ctx) {

        List<CalcParser.VarDefContext> varDefContexts = ctx.varDef();
        List<VarDef> varDefList = new ArrayList<>();
        //For each varDef context, visit it to add it to the varDef list
        for (CalcParser.VarDefContext varDefContext : varDefContexts) {
            varDefList.add((VarDef)visit(varDefContext));
        }

        Exp expr = (Exp)visit(ctx.expression());
        return  new Body(varDefList, expr);
    }
}
