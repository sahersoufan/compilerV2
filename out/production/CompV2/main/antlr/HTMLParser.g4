parser grammar HTMLParser;

options { tokenVocab=HTMLLexer; }

htmlDocument
    : scriptletOrSeaWs* DTD? scriptletOrSeaWs* XML?  scriptletOrSeaWs* htmlElements*
    ;

scriptletOrSeaWs
    : SCRIPTLET
    | SEA_WS
    ;

htmlElements
    : htmlMisc* htmlElement htmlMisc*
    ;

htmlElement
    : TAG_OPEN TAG_NAME htmlAttribute*
          (TAG_CLOSE (htmlContent TAG_OPEN TAG_SLASH TAG_NAME TAG_CLOSE)? | TAG_SLASH_CLOSE)
    | SCRIPTLET
    | script
    | style
    | mustacheExpression
    ;


htmlContent
    : htmlChardata? ((htmlElement | CDATA | htmlComment) htmlChardata?)*
    ;

                                   /* *********************************** */

htmlAttribute
    : CP_APP CP_EQUALS CP_OPEN_DOUBLE_QUOTE appExpression CP_CONTENT_CLOSE_DOUBLE_QUOTE

    | CP_FOR CP_EQUALS CP_OPEN_DOUBLE_QUOTE forExpression CP_CONTENT_CLOSE_DOUBLE_QUOTE

    | CP_SHOW CP_EQUALS CP_OPEN_DOUBLE_QUOTE showExpression CP_CONTENT_CLOSE_DOUBLE_QUOTE
    | CP_HIDE CP_EQUALS CP_OPEN_DOUBLE_QUOTE hideExpression CP_CONTENT_CLOSE_DOUBLE_QUOTE

    | CP_SWITCH CP_EQUALS CP_OPEN_DOUBLE_QUOTE switchExpression CP_CONTENT_CLOSE_DOUBLE_QUOTE
    | CP_SWITCH_CASE CP_EQUALS CP_OPEN_DOUBLE_QUOTE switchCaseExpression CP_CONTENT_CLOSE_DOUBLE_QUOTE
    | CP_SWITCH_DEF

    | CP_IF CP_EQUALS CP_OPEN_DOUBLE_QUOTE ifExpression CP_CONTENT_CLOSE_DOUBLE_QUOTE

    | CP_MODEL CP_EQUALS CP_OPEN_DOUBLE_QUOTE modelExpression CP_CONTENT_CLOSE_DOUBLE_QUOTE

    | CP_CLICK CP_EQUALS CP_OPEN_DOUBLE_QUOTE click CP_CONTENT_CLOSE_DOUBLE_QUOTE
    | CP_DOUBLE_CLICK CP_EQUALS CP_OPEN_DOUBLE_QUOTE doubleClick CP_CONTENT_CLOSE_DOUBLE_QUOTE

    | TAG_NAME (TAG_EQUALS ATTVALUE_VALUE)?
    ;


                                 /* ************************************ */



htmlChardata
    : HTML_TEXT
    | SEA_WS
    ;

htmlMisc
    : htmlComment
    | SEA_WS
    ;

htmlComment
    : HTML_COMMENT
    | HTML_CONDITIONAL_COMMENT
    ;


// APP
appExpression
    : collection4App1
    ;

collection4App1
    : variable
    | objArray
    | functionCall
    | subObj
    | oneLine4AppCondition
    ;

oneLine4AppCondition
    : CP_CONTENT_OPEN_PAR logicComprison CP_CONTENT_QUESTION_MARK collection4App1 CP_CONTENT_COLON collection4App1 CP_CONTENT_CLOSE_PAR
    ;

//
//for(true)
//for(i in "saher")
//for(i,j in a)
//for(i in a ; z = INDEX )
//(!a && b < c || c)
// FOR
forExpression
    : collection4For1 IN   collection4For2 (CP_CONTENT_SEMI_COLON collection4For1 CP_CONTENT_EQUALS INDEX)?
    | collection4For1 CP_CONTENT_COMMA collection4For1 IN collection4For3
    | collection4For4
    ;

collection4For1
    :variable
    |subObj
    |objArray
    ;
collection4For2
    : variable
    | CP_CONTENT_STRING
    | number
    | subObj
    | objArray
    | array
    | functionCall
    | oneLine4For2Condition
    | arithmeticLogic
    ;




oneLine4For2Condition
: CP_CONTENT_OPEN_PAR logicComprison CP_CONTENT_QUESTION_MARK collection4For2 CP_CONTENT_COLON collection4For2 CP_CONTENT_CLOSE_PAR
;
collection4For3
    :obj
    |objBody
    |subObj
    |objArray
    |functionCall
    |oneLine4For3Condition
    ;

oneLine4For3Condition
: CP_CONTENT_OPEN_PAR logicComprison CP_CONTENT_QUESTION_MARK collection4For3 CP_CONTENT_SEMI_COLON collection4For3 CP_CONTENT_CLOSE_PAR
;

collection4For4
    : variable
    | number
    | trueOrFalse
    | objArray
    | functionCall
    | subObj
    | comparisonExpression
    | oneLine4For4Condition
    | logicComprison
    | arithmeticLogic
    ;
oneLine4For4Condition
    : CP_CONTENT_OPEN_PAR logicComprison CP_CONTENT_QUESTION_MARK collection4For4 CP_CONTENT_SEMI_COLON collection4For4 CP_CONTENT_CLOSE_PAR
    ;
//


//SHOW
//HIDE
showExpression
    : logicComprison
    ;
hideExpression
    : logicComprison
    ;

//

//<a cp-switch="c">
//
//<a1 cp-case="4">
//
//<a2 cp-default>
//</a>


// SWITCH
switchExpression
    : collection4Switch1
    ;

switchCaseExpression
    : collection4Switch1
    ;

collection4Switch1
    : variable
    | CP_CONTENT_STRING
    | number
    | objArray
    | subObj
    | oneLine4switch1
    | arithmeticLogic
    ;
oneLine4switch1
: CP_CONTENT_OPEN_PAR logicComprison CP_CONTENT_QUESTION_MARK collection4Switch1 CP_CONTENT_SEMI_COLON collection4Switch1 CP_CONTENT_CLOSE_PAR
;
//


// IF
ifExpression
    : logicComprison
    ;

//


// MODEL
modelExpression
    : collection4Model1
    ;
collection4Model1
        : variable
        | objArray
        | functionCall
        | subObj
        | oneLine4ModelCondition
    ;

oneLine4ModelCondition
    : CP_CONTENT_OPEN_PAR logicComprison CP_CONTENT_QUESTION_MARK collection4Model1 CP_CONTENT_COLON collection4Model1 CP_CONTENT_CLOSE_PAR
    ;
//




// ANNOTATION
click
    : collection4Annotation
    ;
doubleClick
    : collection4Annotation
    ;
collection4Annotation
    : functionCall4AnnotOneLine
    | arrName arrayFuncRet4AnnotOneLine
    | obj propFuncRet4AnnotOneLine
    | oneLine4Annotation
    ;
oneLine4Annotation
: CP_CONTENT_OPEN_PAR logicComprison CP_CONTENT_QUESTION_MARK collection4Annotation CP_CONTENT_COLON collection4Annotation CP_CONTENT_CLOSE_PAR
;
//func()[1][2][2].b().a()
//f()()[]()
//f()()[].a
//f()().a()
//f()().a[]

functionCall4AnnotOneLine
    : functionName funcEndRet4AnnotOneLine
    ;
arrayFuncRet4AnnotOneLine
    : (CP_CONTENT_OPEN_BRACKETS  arithmeticLogic  CP_CONTENT_CLOSE_BRACKETS)+ (propFuncRet4AnnotOneLine | funcEndRet4AnnotOneLine)
    ;
propFuncRet4AnnotOneLine
    : (CP_CONTENT_DOT propertyValue)+ (arrayFuncRet4AnnotOneLine | funcEndRet4AnnotOneLine)
    ;
funcEndRet4AnnotOneLine
    :(CP_CONTENT_OPEN_PAR parameters? CP_CONTENT_CLOSE_PAR)+ (arrayFuncRet4AnnotOneLine | propFuncRet4AnnotOneLine)?
    ;
//


// VARIABLE
variable
    : variableName
    ;

variableName
    : CP_CONTENT_IDENTIFIER
    ;
//


//NUMBER
 number
 : CP_CONTENT_NUMBER
;
//

//TrueFalse
trueOrFalse
:  (CP_CONTENT_TRUE | CP_CONTENT_FALSE)
;
//
// ARRAY
objArray
    : arrName arrayCalling
         ;
arrName
    : CP_CONTENT_IDENTIFIER
    ;

arrayCalling
    : (CP_CONTENT_OPEN_BRACKETS  arithmeticLogic CP_CONTENT_CLOSE_BRACKETS)+ (functionCallFromVar | property)?
    ;
array
    : CP_CONTENT_OPEN_BRACKETS collection4everything (CP_CONTENT_COMMA collection4everything)* CP_CONTENT_CLOSE_BRACKETS
    ;


//


// OBJECT
obj
    : CP_CONTENT_IDENTIFIER
    ;
subObj
    : CP_CONTENT_IDENTIFIER property
    ;
objBody
    : CP_CONTENT_OPEN_CURLY_BRACKETS (pair (CP_CONTENT_COMMA pair)*)* CP_CONTENT_CLOSE_CURLY_BRACKETS
    ;
pair
    : key CP_CONTENT_COLON collection4everything
    ;
key
    : CP_CONTENT_IDENTIFIER
    ;
//


//PROPERTY
property
: (CP_CONTENT_DOT propertyValue)+ (arrayCalling | functionCallFromVar)?
;

propertyValue
    : CP_CONTENT_IDENTIFIER
    ;
//


//FUNCTION
functionCall
    : functionName functionCallFromVar
    ;
functionCallFromVar
    : (CP_CONTENT_OPEN_PAR parameters? CP_CONTENT_CLOSE_PAR)+ (arrayCalling | property)?
    ;
functionName
    : CP_CONTENT_IDENTIFIER
    ;

parameters
    : parameter (CP_CONTENT_COMMA parameter)*
    ;

parameter
    : collection4everything
    ;
//

// comparison
comparisonExpression
    : collection4comparison comparisonOperator collection4comparison
    ;

//(a < x)
//( !(a < (c < d ? 1 : 5) )  && a < b || c < d    ? 1 : 3)
oneLineCondition
: CP_CONTENT_OPEN_PAR logicComprison CP_CONTENT_QUESTION_MARK collection4everything CP_CONTENT_COLON collection4everything CP_CONTENT_CLOSE_PAR
    ;
oneLineBoolCondition
: CP_CONTENT_OPEN_PAR logicComprison CP_CONTENT_QUESTION_MARK CP_CONTENT_TRUE CP_CONTENT_COLON CP_CONTENT_FALSE CP_CONTENT_CLOSE_PAR
    ;
//v = (a < c ? 1 : 2) + a
//v = (a < c ? 1 : [1,2,3]) + a
oneLineArithCondition
    : CP_CONTENT_OPEN_PAR logicComprison CP_CONTENT_QUESTION_MARK arithmeticLogic CP_CONTENT_COLON arithmeticLogic CP_CONTENT_CLOSE_PAR
    ;

comparisonOperator
    : CP_CONTENT_GREATER_THAN
    | CP_CONTENT_GREATER_EQ
    | CP_CONTENT_LESS_THAN
    | CP_CONTENT_LESS_EQ
    | CP_CONTENT_EQUAL_TO
    | CP_CONTENT_NOT_EQUAL
    ;
//

// LOGIC

// ((a>b? 5 :3) > (1 < 3 ? ( c > o ? 1 : ( 2 > 8 ? a :d)))? 2 : 3)
     //( ?2:3)
logicComprison
    : ((CP_CONTENT_NOT)? ((collection4LogicRet) | (CP_CONTENT_OPEN_PAR logicComprison CP_CONTENT_CLOSE_PAR))) /// first
      middleAndLastLogicComparison*
    ;

middleAndLastLogicComparison
    : ((CP_CONTENT_AND (CP_CONTENT_NOT)?) | (CP_CONTENT_OR (CP_CONTENT_NOT)?))   /// middle
      (collection4LogicRet | CP_CONTENT_OPEN_PAR logicComprison CP_CONTENT_CLOSE_PAR) /// last
    ;

arithmeticLogic
    : (collection4Arithmetic | CP_CONTENT_OPEN_PAR arithmeticLogic CP_CONTENT_CLOSE_PAR) lastArithmeticLogic*
    ;
lastArithmeticLogic
    : CP_CONTENT_ARITHMETIC (collection4Arithmetic | CP_CONTENT_OPEN_PAR arithmeticLogic CP_CONTENT_CLOSE_PAR)
    ;

//

value
    : CP_CONTENT_STRING
    | number
    | trueOrFalse
    | CP_CONTENT_NULL
    ;

collection4everything
    : variable
    | value
    | array
    | objArray
    | functionCall
    | subObj
    | oneLineCondition
    | comparisonExpression
    | logicComprison
    | arithmeticLogic
    ;

collection4comparison
    : arithmeticLogic
    ;

collection4Arithmetic
    : variable
    | number
    | objArray
    | functionCall
    | subObj
    | oneLineArithCondition
    ;

collection4LogicRet
        : variable
        | trueOrFalse
        | objArray
        | functionCall
        | subObj
        | comparisonExpression
        | oneLineBoolCondition
    ;



 ///////////////////////// MUSTACHE /////////////////////////

mustacheExpression
    : OPEN_MUSTACHE (collection4Mustache filter?)+ CLOSE_MUSTACHE
    ;

collection4Mustache
    : mustacheVariable
    | mustacheValue
    | objArray4Must
    | functionCall4Must
    | subObj4Must
    | oneLineCondition4Must
    | oneLineArithCondition4Must
    | arithmeticLogic4Must
    ;

collection4LogicRet4Must
    : mustacheVariable
    | MUSTACHE_TRUE
    | MUSTACHE_FALSE
    | objArray4Must
    | functionCall4Must
    | subObj4Must
    | comparisonExp4Must
    | oneLineBoolCondition4Must
    ;

collection4CompMust
    : arithmeticLogic4Must
    ;

collection4MUSTArithmetic
    : mustacheVariable
    | mustacheNumber
    | objArray4Must
    | functionCall4Must
    | subObj4Must
    | oneLineArithCondition4Must
    ;

// LOGIC
logicComprison4Must
    :((MUSTACHE_NOT)? ((collection4LogicRet4Must) | (MUSTACHE_OPEN_PAR logicComprison4Must MUSTACHE_CLOSE_PAR))) /// first
      middleAndLastLogicComparison4Must*
    ;

middleAndLastLogicComparison4Must
    : ((MUSTACHE_AND (MUSTACHE_NOT)?) | (MUSTACHE_OR (MUSTACHE_NOT)?))   /// middle
      (collection4LogicRet4Must | MUSTACHE_OPEN_PAR logicComprison4Must MUSTACHE_CLOSE_PAR)/// last
    ;

arithmeticLogic4Must
    : (collection4MUSTArithmetic | MUSTACHE_OPEN_PAR arithmeticLogic4Must MUSTACHE_CLOSE_PAR)
      lastArithmeticLogic4Must*
    ;
lastArithmeticLogic4Must
    : MUSTACHE_ARITHMETIC (collection4MUSTArithmetic | MUSTACHE_OPEN_PAR arithmeticLogic4Must MUSTACHE_CLOSE_PAR)
    ;
//


// VAR
mustacheVariable
    : MUSTACHE_IDENTIFIER
    ;
//


//NUMBER
 mustacheNumber
 : MUSTACHE_NUMBER
 ;


// VALUE
mustacheValue
    : mustacheNumber
    | MUSTACHE_STRING
    | MUSTACHE_NULL
    | MUSTACHE_FALSE
    | MUSTACHE_TRUE
    ;
//


// ARRAY
objArray4Must
    : arrName4Must arrayCalling4Must
    ;
arrName4Must
    : MUSTACHE_IDENTIFIER
    ;
arrayCalling4Must
    : (MUSTACHE_OPEN_BRACKETS arithmeticLogic4Must MUSTACHE_CLOSE_BRACKETS)+ (functionCallFromVar4Must | property4Must)?
    ;
//


// FUNCTION
functionCall4Must
    : functionName4Must functionCallFromVar4Must
    ;
functionCallFromVar4Must
    : (MUSTACHE_OPEN_PAR parameters4Must? MUSTACHE_CLOSE_PAR)+ (arrayCalling4Must | property4Must)?
    ;
functionName4Must
    : MUSTACHE_IDENTIFIER
    ;

parameters4Must
    : parameter4Must (MUSTACHE_COMMA parameter4Must)*
    ;

parameter4Must
    : collection4Mustache
    ;
//

// OBJECT
subObj4Must
    : MUSTACHE_IDENTIFIER property4Must
    ;
//


//PROPERTY
property4Must
: (MUSTACHE_DOT propertyValue4Must)+ (arrayCalling4Must | functionCallFromVar4Must)?
;

propertyValue4Must
    : MUSTACHE_IDENTIFIER
    ;
//

// COMPARISON
oneLineCondition4Must
    : MUSTACHE_OPEN_PAR logicComprison4Must MUSTACHE_QUESTION_MARK collection4Mustache MUSTACHE_COLON collection4Mustache MUSTACHE_CLOSE_PAR
    ;

oneLineArithCondition4Must
    : MUSTACHE_OPEN_PAR logicComprison4Must MUSTACHE_QUESTION_MARK arithmeticLogic4Must MUSTACHE_COLON arithmeticLogic4Must MUSTACHE_CLOSE_PAR
    ;

oneLineBoolCondition4Must
    : MUSTACHE_OPEN_PAR logicComprison4Must MUSTACHE_QUESTION_MARK MUSTACHE_TRUE MUSTACHE_COLON MUSTACHE_FALSE MUSTACHE_CLOSE_PAR
    ;
comparisonExp4Must
    : collection4CompMust mustacheComparisonOperator collection4CompMust
    ;

mustacheComparisonOperator
    : MUSTACHE_GREATER_THAN
    | MUSTACHE_GREATER_EQ
    | MUSTACHE_LESS_THAN
    | MUSTACHE_LESS_EQ
    | MUSTACHE_EQUAL_TO
    | MUSTACHE_NOT_EQUAL
    ;
//


// FILTER
filter
    : MUSTACHE_FILTER formatName (MUSTACHE_COLON MUSTACHE_STRING)?
    ;

formatName
    : MUSTACHE_IDENTIFIER
    ;
//


//*****************************************************************************************************************


script
    : SCRIPT_OPEN ( SCRIPT_BODY | SCRIPT_SHORT_BODY)
    ;

style
    : STYLE_OPEN (STYLE_BODY | STYLE_SHORT_BODY)
    ;
