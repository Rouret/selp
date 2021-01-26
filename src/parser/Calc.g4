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
           | BOOLEAN                                       # BoolLit
           | variableId                                    # Var
           | (MINUS | NOT) expression                      # UnDEF
           | expression OpMult expression                  # BinExp
           | expression (PLUS | MINUS) expression          # BinExp
           | expression OpRelational  expression           # BinExp
           | expression OpEquality  expression             # BinExp
           | expression AND  expression                    # BinExp
           | expression OR  expression                     # BinExp
           | <assoc = right> expression '?' expression ':' expression #TernaryExp
           ;

variableId : IDENTIFIER
           ;
functionId : IDENTIFIER
           ;


IDENTIFIER : ('a'..'z')('a'..'z' | '0'..'9')*
         ;
LITERAL  : '0' | ('1'..'9')('0'..'9')* ;

BOOLEAN  : 'true' | 'false'
         ;
WS       : [ \t\n\r]+ -> channel(HIDDEN)
         ;
LINE_COMMENT : '//' ~'\n'* '\n' -> channel(HIDDEN)
         ;
MINUS      : '-' ;
NOT        : '!' ;
PLUS : '+';

OpMult : '*' | '/';
OpRelational : '<' | '>' | '<=' | '>=';
OpEquality : '==' | '!=';
AND : '&&';
OR : '||';