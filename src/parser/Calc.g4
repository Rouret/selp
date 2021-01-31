grammar Calc;
// syntactic rules

program  : funcDef* body
         ;
funcDef : '(' 'defun' head body ')'
         ;
head     : '(' functionId variableId* ')'
         ;
body     : varDef* expression
         ;
varDef   : variableId '=' expression
         ;

expression : LITERAL                                       # IntLit
           | variableId                                    # Var
           | BOOLEAN                                       # BoolLit
           | (MINUS | NOT) expression                      # UnDEF
           | expression OpMult expression                               # BinExp
           | expression (MINUS | PLUS) expression                       # BinExp
           | expression OpRelational expression                         # BinExp
           | expression OpEquality expression                           # BinExp
           | expression AND expression                                  # BinExp
           | expression OR expression                                   # BinExp
           | <assoc = right> expression '?' expression ':' expression #TernaryExp
           | '(' expression ')'                                         # ParExp
           ;

variableId : IDENTIFIER
           ;
functionId : IDENTIFIER
           ;


OpMult : '*' | '/';
OpRelational : '<' | '>' | '<=' | '>=';
OpEquality : '==' | '!=';
AND : '&&';
OR : '||';

MINUS      : '-' ;
NOT        : '!' ;
PLUS : '+';

BOOLEAN : 'true' | 'false';

IDENTIFIER : ('a'..'z')('a'..'z' | '0'..'9')*
         ;
LITERAL  : '0' | ('1'..'9')('0'..'9')* ;


WS       : [ \t\n\r]+ -> channel(HIDDEN)
         ;
LINE_COMMENT : '//' ~'\n'* '\n' -> channel(HIDDEN)
         ;


