package parser.constructs;

import lexer.Token;
import lexer.tokens.DEFUN;
import lexer.tokens.DEFVAR;
import lexer.tokens.LPAR;
import lexer.tokens.RPAR;
import parser.AST;
import parser.State;
import parser.SyntaxError;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static lexer.SLexer.getToken;

public class Prog extends AST {

    private List<FunDef> listFunDef;
    private Body body;

    public Prog(List<FunDef> listFunDef, Body body) {
        this.listFunDef = listFunDef;
        this.body = body;
    }

    public static Prog parse (Token token) throws IOException, SyntaxError {
        if (token instanceof LPAR) {
            token = getToken();
            if (token instanceof DEFUN) {
                List<FunDef> list = new ArrayList<>();
                token = getToken();
                FunDef function = FunDef.parse(token);
                list.add(function);
                Body body = Body.parse(token,new ArrayList<>());

                return new Prog(list,body);
            }else{
                throw new SyntaxError("");
            }
        }else{
            throw new SyntaxError("");

        }
    }

    public int eval(){
        State<Integer> stateVariables=new State<Integer>();
        State<FunDef> stateFunDef=new State<FunDef>();


        return this.body.eval(stateVariables,stateFunDef);
    }


    @Override
    public String toString() {
        return null;
    }
}
