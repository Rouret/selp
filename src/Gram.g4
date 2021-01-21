grammar Calc;
// syntactic rules

program  : funcDef* body
         ;
funcDef  : '(' 'defun' head body ')'
         ;
head     : '(' functionId variableId* ')'
         ;
body     : varDef* expression
         ;
varDef   : '(' '=' variableId expression ')'
         ;
expression : LITERAL                                       # IntLit
           | variableId                                    # Var
           | '(' '-' expression tail                       # UnExp
           | '(' OP expression expression ')'              # BinExp
           | '(' 'if' expression expression expression ')' # CondExp
           | '(' functionId expression* ')'                # FunCall
           ;

tail : ')'
     |  expression ')'
     ;

variableId : IDENTIFIER
           ;
functionId : IDENTIFIER
           ;


OP       : '+' | '-' | '*' | '/' | '==' | '<' | '!'
         ;
IDENTIFIER : ('a'..'z')('a'..'z' | '0'..'9')*
         ;
LITERAL  : '0' | ('1'..'9')('0'..'9')*
         ;
WS       : [ \t\n\r]+ -> channel(HIDDEN)
         ;
LINE_COMMENT : '//' ~'\n'* '\n' -> channel(HIDDEN)
         ;
