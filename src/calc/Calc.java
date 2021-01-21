package calc;

import lexer.SLexer;
import lexer.tokens.EOF;
import parser.SyntaxError;
import parser.constructs.Exp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

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
        Exp ast=Exp.parse(SLexer.getToken());
        if(!(SLexer.getToken() instanceof EOF)){
            throw new SyntaxError("EOF not detected");
        }
        System.out.println("Eval: "+ ast.eval());
        return ast.eval();
    }
}
