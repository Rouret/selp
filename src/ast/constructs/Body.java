package ast.constructs;

import lexer.Token;
import lexer.tokens.DEFVAR;
import lexer.tokens.LPAR;
import ast.AST;
import ast.State;
import ast.SyntaxError;

import static lexer.SLexer.getToken;

import java.io.IOException;
import java.util.List;

public class Body extends AST {

    private final List<VarDef> list;
    private final Exp exp;

    public Body(List<VarDef> list, Exp exp) {
        this.list = list;
        this.exp = exp;
    }

    public static Body parse(Token token, List<VarDef> defs) throws IOException, SyntaxError {
        if (token instanceof LPAR) {
            Token token2 = getToken();
            if (token2 instanceof DEFVAR) {
                //NOM DE LA VARIABLE
                VarDef def = VarDef.parse(getToken());
                defs.add(def);
                // loop on the rest of the body with the accumulated definitions
                //VALEUR DE LA VARIABLE
                return parse(getToken(), defs);
            } else { // there is a compound expression after the definitions*
                Exp exp = Exp.parseCompoundTail(token2);
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
    public int eval(State<Integer> stateVariables){
        for (VarDef varDef: this.list) {
            varDef.eval(stateVariables);
        }
        return this.exp.eval(stateVariables);
    }

    @Override
    public String gen() {
      return  null;
    }

    @Override
    public String toString() {
        return null;
    }
}
