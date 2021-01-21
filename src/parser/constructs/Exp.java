package parser.constructs;

import lexer.SLexer;
import lexer.Token;
import lexer.tokens.*;
import parser.AST;
import parser.SyntaxError;

import java.io.IOException;

public abstract class Exp extends AST {
    public static Exp parse(Token token) throws IOException, SyntaxError {
        if (!(token instanceof LPAR))
            return parseSimple(token);
        else
            return parseCompoundTail(token);
    }
    public static Exp parseSimple(Token token) throws SyntaxError {
        if(token instanceof INTEGER) {
            return new IntLit(((INTEGER) token).getValue());
        } else {
            throw new SyntaxError("Expression non attentdu  : " + token);
        }
    }
    public static Exp parseCompoundTail(Token token) throws IOException, SyntaxError {
        Token tokenOP = SLexer.getToken();
        if(tokenOP instanceof OP) {
            BinExp binExp = new BinExp((OP) tokenOP);
            Token tokenEXP1 = SLexer.getToken();
            if (tokenEXP1 instanceof LPAR || tokenEXP1 instanceof INTEGER) {
                //RECURSION
                binExp.setOperand1(Exp.parse(tokenEXP1));
            } else {
                throw new SyntaxError("Syntax Error " + token + " need to be a LAP or INTEGER");
            }
            Token tokenEXP2 = SLexer.getToken();
            if(tokenEXP2 instanceof RPAR  && ((OP) tokenOP).getValue().equals("-")){
                return new UnDEF(binExp.getOperand1().eval());
            }
            else if (tokenEXP2 instanceof LPAR || tokenEXP2 instanceof INTEGER) {
                binExp.setOperand2(Exp.parse(tokenEXP2));
            } else {
                throw new SyntaxError("Syntax Error " + token + " need to be a LAP or INTEGER");
            }
            Token tokenRPAR = SLexer.getToken();
            if (!(tokenRPAR instanceof RPAR)) throw new SyntaxError("Missing ')'");
            return binExp;
        }
        //CONDEF
        else if(tokenOP instanceof IF){
            ConDex conDex = new ConDex((IF) tokenOP);

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

    public abstract int eval();
}

