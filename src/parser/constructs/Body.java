package parser.constructs;

import lexer.SLexer;
import lexer.Token;
import lexer.tokens.DEFVAR;
import lexer.tokens.LPAR;
import parser.AST;
import parser.State;
import parser.SyntaxError;


import java.io.IOException;
import java.util.List;

import static lexer.SLexer.getToken;

public class Body extends AST {

    private List<VarDef> list;
    private Exp exp;

    public Body(List<VarDef> list, Exp exp) {
        this.list = list;
        this.exp = exp;
    }

    public static Body parse(Token token, List<VarDef> defs) throws IOException, SyntaxError {
        if (token instanceof LPAR) {
            token = getToken();
            if (token instanceof DEFVAR) {
                //NOM DE LA VARIABLE
                VarDef def = VarDef.parse(getToken());
                while(def instanceof VarDef){
                    defs.add(def);
                    def = VarDef.parse(getToken());
                }
                // loop on the rest of the body with the accumulated definitions
                //VALEUR DE LA VARIABLE
                return parse(getToken(), defs);
            } else { // there is a compound expression after the definitions*
                Exp exp = Exp.parseCompoundTail(token);
                return new Body(defs, exp);
            }
        } else {
            return parseSimpleBody(token, defs);// there is a simple expression at the end of a simple body
        }

    }

    public static Body parseSimpleBody(Token token, List<VarDef> defs) throws SyntaxError {
        Exp exp =  Exp.parseSimple(token);
        return new Body(defs, exp);
    }
    public int eval(State<Integer> stateVariables,State<FunDef> stateFunDef){
        for (VarDef varDef: this.list) {
            varDef.eval(stateVariables,stateFunDef);
        }
        return this.exp.eval(stateVariables,stateFunDef);
    }
    @Override
    public String toString() {
        return "Body";
    }
}
