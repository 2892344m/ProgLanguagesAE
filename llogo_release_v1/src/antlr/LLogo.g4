grammar LLogo;

@header {
package antlr;
}

expr: base_expr SEMICOLON expr # Sequence
    | LET IDENT EQ expr IN expr # Let
    | LET FUN IDENT LPAREN IDENT COLON type RPAREN EQ expr IN expr # LetFun
    | LET REC IDENT LPAREN IDENT COLON type RPAREN COLON type EQ expr IN expr # LetRec
    | LET LPAREN IDENT COMMA IDENT RPAREN EQ expr IN expr # LetPair
    | base_expr # BaseExpr
    ;

base_expr:
      base_expr DIV base_expr # Div
    | base_expr STAR base_expr # Mul
    | base_expr ADD base_expr # Add
    | base_expr SUB base_expr # Sub
    | base_expr EQQ base_expr # Eq
    | base_expr LT base_expr # Lt
    | base_expr GT base_expr # Gt
    | base_expr LTE base_expr # Lte
    | base_expr GTE base_expr # Gte
    | base_expr AND base_expr # And
    | base_expr OR base_expr # Or
    | IF LPAREN base_expr RPAREN LBRACE expr RBRACE ELSE LBRACE expr RBRACE # Cond
    | CASE base_expr OF LBRACE LBRACKET RBRACKET RIGHTARROW base_expr PIPE IDENT COLONCOLON IDENT RIGHTARROW base_expr RBRACE # Case
    | FST LPAREN expr RPAREN # Fst
    | SND LPAREN expr RPAREN # Snd
    | FORWARD LPAREN expr RPAREN # Forward
    | BACKWARD LPAREN expr RPAREN # Backward
    | LEFT LPAREN expr RPAREN # Left
    | RIGHT LPAREN expr RPAREN # Right
    | PENUP LPAREN RPAREN # PenUp
    | PENDOWN LPAREN RPAREN # PenDown
    | SETCOL LPAREN expr RPAREN # SetCol
    | RANDCOL LPAREN expr RPAREN # RandCol
    | list # ListExpr
    ;

list:
      app COLONCOLON list # Cons
    | app # AppExpr
    ;

app:
      app LPAREN base_expr RPAREN # Application
    | prim # Fact 
    ;

prim: BACKSLASH IDENT COLON type DOT expr # Lambda
    | REC IDENT '(' IDENT COLON type ')' COLON type DOT expr # Rec
    | IDENT # Var
    | INT # Int
    | TRUE # True
    | FALSE # False
    | colour # ColourLit
    | LPAREN RPAREN # Unit
    | LBRACKET RBRACKET # EmptyList
    | LPAREN base_expr COMMA base_expr RPAREN # Pair
    | '(' expr ')' # Parens
    ;

colour: 
      RED # Red
    | BLUE # Blue
    | GREEN # Green
    | PINK # Pink
    | BLACK # Black
    ;

type: prim_type RIGHTARROW type # TyFun
    | prim_type # TyPrim
    ;

prim_type:
      TYINT # TyInt
    | TYBOOL # TyBool
    | TYCOLOUR # TyColour
    | TYCOLOURLIST # TyColourList
    | TYUNIT # TyUnit
    | '(' type STAR type ')' # TyProduct
    | '(' type ')' # TyParen
    ;

INT : [0-9]+ ;
CASE: 'case';
OF: 'of';
PIPE: '|';
DIV: '/' ;
SUB: '-' ;
ADD: '+' ;
EQ: '=';
BACKSLASH: '\\';
DOT: '.';
COMMA: ',';
LET: 'let';
IN: 'in';
REC: 'rec';
FUN: 'fun';
TRUE: 'true';
FALSE: 'false';
EQQ: '==' ;
AND: '&&' ;
OR: '||' ;
LT: '<' ;
GT: '>' ;
LTE: '<=' ;
GTE: '>=' ;
IF: 'if' ;
THEN: 'then' ;
ELSE: 'else' ;
RIGHTARROW: '->';
SEMICOLON: ';' ;
TYINT: 'Int';
TYBOOL: 'Bool';
LPAREN: '(';
RPAREN: ')';
LBRACKET: '[';
RBRACKET: ']';
LBRACE: '{';
RBRACE: '}';
COLONCOLON: '::';
COLON: ':';
RED: 'red';
BLUE: 'blue';
GREEN: 'green';
PINK: 'pink';
BLACK: 'black';
FORWARD: 'forward';
BACKWARD: 'backward';
LEFT: 'left';
RIGHT: 'right';
PENUP: 'penUp';
PENDOWN: 'penDown';
SETCOL: 'setCol';
RANDCOL: 'randCol';
FST: 'fst';
SND: 'snd';
TYCOLOUR: 'Colour';
STAR: '*';
TYUNIT: 'Unit';
TYCOLOURLIST: 'ColourList';
IDENT: [a-z][a-zA-Z0-9]*;
WS : [ \t\r\n]+ -> skip ;