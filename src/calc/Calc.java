package calc;

import lexer.SLexer;
import lexer.Token;
import lexer.tokens.EOF;
import parser.AST;
import parser.State;
import parser.SyntaxError;
import parser.constructs.Body;
import parser.constructs.Exp;
import parser.constructs.FunDef;
import parser.constructs.Prog;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Calc {

    public static void main(String[] args) throws IOException, SyntaxError {
        InputStream is;
        String filename;

        switch (args.length) {
            case 0 -> is = System.in;
            case 1 -> {
                filename = args[0];
                is = new FileInputStream(filename);
            }
            default -> throw new IllegalArgumentException();
        }
        Calc.interpret(is);
    }
    public static int interpret(InputStream in) throws IOException, SyntaxError {
        SLexer.init(in);



        Prog prog = Prog.parse(SLexer.getToken());
        if(!(SLexer.getToken() instanceof EOF)){
            throw new SyntaxError("EOF not detected");
        }


        Integer result=prog.eval();
        System.out.println("eval = " + result);

        return result;
        //return 0;
    }
}
