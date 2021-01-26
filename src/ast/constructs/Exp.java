package ast.constructs;

import ast.State;
import lexer.SLexer;
import lexer.Token;
import lexer.tokens.*;
import ast.AST;
import ast.SyntaxError;

import java.io.IOException;

public abstract class Exp extends AST {
    public abstract int eval(State<Integer> stateVariables);
}

