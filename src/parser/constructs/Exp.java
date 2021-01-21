package parser.constructs;

import lexer.SLexer;
import lexer.Token;
import lexer.tokens.*;
import parser.AST;
import parser.State;
import parser.SyntaxError;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static lexer.SLexer.getToken;

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
            BinExp binExp = new BinExp((OP) tokenOP);
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
        else if(tokenOP instanceof IDENTIFIER){
            IDENTIFIER identifier = (IDENTIFIER) tokenOP;
            Token nextToken = getToken();

            List<Exp> args= new ArrayList<Exp>();
            if(nextToken instanceof RPAR) return new Call(identifier.getValue(),args);

            AST ast=parse(nextToken);

            while (ast instanceof  Exp){
                args.add((Exp) ast);

                nextToken = getToken();

                if(nextToken instanceof RPAR) break;

                ast = parse(nextToken);

            }

            if(nextToken instanceof RPAR) return new Call(identifier.getValue(),args);

            throw new SyntaxError("missing ')'");
        }
        else {
            throw new SyntaxError("Missing an operator");
        }
    }

    public abstract int eval(State<Integer> stateVariables, State<FunDef> stateFunDef);
}

