package calc;

import lexer.SLexer;
import lexer.tokens.EOF;
import parser.AST;
import parser.State;
import parser.SyntaxError;
import parser.constructs.Body;
import parser.constructs.Exp;

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
        Body body = Body.parse(SLexer.getToken(), new ArrayList<>());
        if(!(SLexer.getToken() instanceof EOF)){

            throw new SyntaxError("EOF not detected");
        }
        State<Integer> state=new State<Integer>();
        Integer result=body.eval(state);
        System.out.println("eval = " + result);
        return result;
    }
}
