grammar Prolog;

// GRAMMAR

start
    :   definitions
    ;

definitions
    :   definition+
    ;

definition
    :   (   setDef
        |   variableDef
        |   conditionDef
        ) SEMI
    ;

setDef
    :   type=ID LeftBrace RightBrace CMP3 LeftBrace setParams RightBrace
    ;

setParams
    :   setParam (COMMA setParam)*
    ;

setParam
    :   string=Literal
    |   num=Number
    |   lower=Number RANGE upper=Number
    ;

variableDef
    :   type=ID
        (   vDef1
        |   vDef2 LeftBracket RightBracket
        |   vDef3)
    ;

vDef1
    :   id=ID (COMMA id=ID)*
    ;

vDef2
    :   id=ID (COMMA id=ID)*
    ;

vDef3
    :   id=ID LeftParen typeParams RightParen (COMMA id=ID LeftParen typeParams RightParen)*
    ;

typeParams
    :   ID (COMMA ID)*
    ;

conditionDef
    :   quantifiers? expression
    ;

quantifiers
    :   (quantifier COMMA)+
    ;

quantifier
    :   AT (Existential | Universal) id=ID (Belong) type=ID
    ;

parameters
    :   expression (COMMA expression)*
    ;

expression
    :   ID
    |   Number
    |   Literal
    |   LeftParen expression RightParen
    |   id=ID LeftParen parameters RightParen
    |   id=ID LeftBracket Number RightBracket
    |   uop=NOT expression
    |   expression bop=ART1 expression
    |   expression bop=ART2 expression
    |   expression bop=CMP1 expression
    |   expression bop=CMP2 expression
    |   expression bop=CMP3 expression
    |   expression bop=CMP4 expression
    |   expression bop=LOG1 expression
    |   expression bop=LOG2 expression
    |   expression bop=XOR expression
    |   expression bop=IMPLY expression
    ;

// TOKEN

Existential : '\u5b58' '\u5728';
Universal : '\u4efb' '\u610f';
Belong : '\u5c5e' '\u4e8e';

NOT : ('!' | '~');
ART1 : (Star | Div | Mod);
ART2 : (Plus | Minus);
CMP1 : (Less | Greater);
CMP2 : (Less Equal | Greater Equal);
CMP3 : ((Equal Equal) | Equal);
CMP4 : ('!=' | '<>');
LOG1 : ('&' | '&&');
LOG2 : ('|' | '||');
XOR : ('^');
IMPLY : ('->');

AT : '@';
SEMI : ';';
COMMA : ',';
RANGE : '..';

LeftParen : '(';
RightParen : ')';
LeftBracket : '[';
RightBracket : ']';
LeftBrace : '{';
RightBrace : '}';

ID : WORD (WORD | '0'..'9')*;

Literal
    :   '\"' .*? '\"'
    ;

Number
    :  DIGIT+
    ;

// FRAGMENT

fragment Plus : '+';
fragment Minus : '-';
fragment Star : '*';
fragment Div : '/';
fragment Mod : '%';

fragment Equal : '=';
fragment Less : '<';
fragment Greater : '>';

fragment
DIGIT
    :   '0'..'9'
    ;

fragment
WORD
    :   'a'..'z'
    |   'A'..'Z'
    |   '_'
    |   '$'
    |   '\u4E00'..'\u9FA5'
    ;

// SKIP

Whitespace
    :   [ \t]+
        -> skip
    ;

Newline
    :   (   '\r' '\n'?
        |   '\n'
        )
        -> skip
    ;

BlockComment
    :   '/*' .*? '*/'
        -> skip
    ;

LineComment
    :   '//' ~[\r\n]*
        -> skip
    ;