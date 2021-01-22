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

        List<FunDef> funDefList = new ArrayList<>();

        AST ast = null;
        do {
            if (!(token instanceof LPAR)) break;;
            Token temp_token = getToken();
            if (!(temp_token instanceof DEFUN)) break;

            token = getToken();
            ast = FunDef.parse(token);
            funDefList.add((FunDef) ast);
            //PAS DE TOKEN
        }while (ast instanceof FunDef);

        Body body = Body.parse(token,new ArrayList<>());

        return new Prog(funDefList, body);

    }

    public int eval(){
        State<Integer> stateVariables=new State<Integer>();
        State<FunDef> stateFunDef=new State<FunDef>();

        for (FunDef funDef: this.listFunDef
             ) {
            stateFunDef.bind(funDef.getHead().getFunctionId().getValue(),funDef);
        }

        return this.body.eval(stateVariables,stateFunDef);
    }


    @Override
    public String toString() {
        return null;
    }
}
