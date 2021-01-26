package ast.constructs;

import ast.State;
import lexer.SLexer;
import lexer.Token;
import lexer.tokens.*;
import ast.AST;
import ast.SyntaxError;

import java.io.IOException;

public abstract class Exp extends AST {
    public static Exp parse(Token token) throws IOException, SyntaxError {
        if (!(token instanceof LPAR))
            return parseSimple(token);
        else
            return parseCompoundTail(SLexer.getToken());
    }
    public static Exp parseSimple(Token token) throws SyntaxError {
        if(token instanceof INTEGER) {
            return new IntLit(((INTEGER) token).getValue());
        } else if( token instanceof IDENTIFIER){
            return new Var(((IDENTIFIER) token).getValue());
        }
        else {
            throw new SyntaxError("Expression non attendu  : " + token);
        }
    }
    public static Exp parseCompoundTail(Token tokenOP) throws IOException, SyntaxError {
        if(tokenOP instanceof OP) {
            BinExp binExp = new BinExp(((OP) tokenOP).getValue());
            Token tokenEXP1 = SLexer.getToken();
            if (tokenEXP1 instanceof LPAR || tokenEXP1 instanceof INTEGER || tokenEXP1 instanceof IDENTIFIER) {
                //RECURSION
                binExp.setOperand1(Exp.parse(tokenEXP1));
            } else {
                throw new SyntaxError("Syntax Error " + tokenEXP1 + " need to be a LAP or INTEGER");
            }
            Token tokenEXP2 = SLexer.getToken();
            if(tokenEXP2 instanceof RPAR  && ((OP) tokenOP).getValue().equals("-")){
                return new UnDEF(binExp.getOperand1());
            }
            else if (tokenEXP2 instanceof LPAR || tokenEXP2 instanceof INTEGER || tokenEXP2 instanceof IDENTIFIER) {
                binExp.setOperand2(Exp.parse(tokenEXP2));
            } else {
                throw new SyntaxError("Syntax Error " + tokenEXP2 + " need to be a LAP or INTEGER");
            }
            Token tokenRPAR = SLexer.getToken();
            if (!(tokenRPAR instanceof RPAR)) throw new SyntaxError("Missing ')'");
            return binExp;
        }
        //CONDEF
        else if(tokenOP instanceof IF){
            CondExp conDex = new CondExp();

            Token tokenEXP1 = SLexer.getToken();
            conDex.setOperand1(Exp.parse(tokenEXP1));

            Token tokenEXP2 = SLexer.getToken();
            conDex.setOperand2(Exp.parse(tokenEXP2));

            Token tokenEXP3 = SLexer.getToken();
            conDex.setOperand3(Exp.parse(tokenEXP3));

            Token tokenRPAR = SLexer.getToken();
            if (!(tokenRPAR instanceof RPAR)) throw new SyntaxError("Missing ')'");

            return conDex;
        }
        else {
            throw new SyntaxError("Missing an operator");
        }
    }

    public abstract int eval(State<Integer> stateVariables);
}

