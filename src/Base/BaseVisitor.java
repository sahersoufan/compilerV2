package Base;

import AST.Elements.*;
import AST.Elements.ElementsNodes.*;
import AST.Elements.ElementsNodes.CpExpression.For.*;
import AST.Elements.ElementsNodes.CpExpression.If.IfExpression;
import AST.Elements.ElementsNodes.CpExpression.Switch.SwitchCaseExpression;
import AST.Elements.ElementsNodes.CpExpression.Switch.SwitchExpression;
import AST.Elements.ElementsNodes.CpExpression.annotation.AnnotationClickExpression;
import AST.Elements.ElementsNodes.CpExpression.annotation.AnnotationOverExpression;
import AST.Elements.ElementsNodes.CpExpression.app.AppExpression;
import AST.Elements.ElementsNodes.CpExpression.model.ModelExpression;
import AST.Elements.ElementsNodes.CpExpression.showHide.HideExpression;
import AST.Elements.ElementsNodes.CpExpression.showHide.ShowExpression;
import AST.Elements.ElementsNodes.generic4Elements.Collection4LogicRet;
import AST.Elements.ElementsNodes.generic4Elements.Logic.ArithmeticLogic;
import AST.Elements.ElementsNodes.generic4Elements.Logic.LogicComprison;
import AST.Elements.ElementsNodes.generic4Elements.Logic.MiddleAndLastLogicComparison;
import AST.Elements.ElementsNodes.generic4Elements.NUmber;
import AST.Elements.ElementsNodes.generic4Elements.TrueOrFalse;
import AST.Elements.ElementsNodes.generic4Elements.array.ArrName;
import AST.Elements.ElementsNodes.generic4Elements.array.Array;
import AST.Elements.ElementsNodes.generic4Elements.array.ArrayCalling;
import AST.Elements.ElementsNodes.generic4Elements.array.ObjArray;
import AST.Elements.ElementsNodes.generic4Elements.comparison.ComparisonExpression;
import AST.Elements.ElementsNodes.generic4Elements.function.FunctionCall;
import AST.Elements.ElementsNodes.generic4Elements.object.Obj;
import AST.Elements.ElementsNodes.generic4Elements.object.ObjBody;
import AST.Elements.ElementsNodes.generic4Elements.object.SubObj;
import AST.Elements.ElementsNodes.generic4Elements.variable.Variable;
import AST.Elements.ElementsNodes.generic4Elements.variable.VariableName;
import AST.Elements.ElementsNodes.mustacheExpression.MustacheExpression;
import AST.HtmlDocument;
import AST.HtmlEle;
import AST.HtmlXML;
import generatedGrammers.HTMLParser;
import generatedGrammers.HTMLParserBaseVisitor;

import java.util.ArrayList;
import java.util.List;


// For create new node in tree
//-------------------Use this code---------------------------

//SimpleTreeNode root = new SimpleTreeNode("root");
//Notice "We have only one root and many children"

//root.addChild(new SimpleTreeNode("Child 1"));
// For adding endpoint child

//SimpleTreeNode child3 = new SimpleTreeNode("Child 3");
//For create new child that has many children

//root.addChild(child3);
// For adding child

//new ListingTreePrinter().print(root);
// For print tree

//new TraditionalTreePrinter().print(root);
// For print Traditional Tree

//new TraditionalTreePrinter().print(new BorderTreeNodeDecorator(root));
//for print Traditional Tree with Border


public class BaseVisitor extends HTMLParserBaseVisitor {
    @Override
    public Object visitHtmlDocument(HTMLParser.HtmlDocumentContext ctx) {
        HtmlDocument htmlDocument = new HtmlDocument();


        List<ScriptLetOrSeaWs> ObjscriptletOrSeaWs = new ArrayList<>();
        if(ctx.scriptletOrSeaWs() != null){
            for (int i =0 ; i <  ctx.scriptletOrSeaWs().size() ; i++){
                ObjscriptletOrSeaWs.add( (ScriptLetOrSeaWs) visitScriptletOrSeaWs(ctx.scriptletOrSeaWs(i)));
            }
            htmlDocument.setScriptLetORSeaWs(ObjscriptletOrSeaWs);
        }

        if(ctx.DTD() != null){
            htmlDocument.setDTD(ctx.DTD().getSymbol().getText());
        }

        if (ctx.htmlXML() != null){
            htmlDocument.setHtmlXML((HtmlXML) visitHtmlXML(ctx.htmlXML()));
        }

        if (ctx.htmlEle() != null){
            htmlDocument.setHtmlEle((HtmlEle) visitHtmlEle(ctx.htmlEle()));
        }
        return super.visitHtmlDocument(ctx);
    }

    @Override
    public Object visitScriptletOrSeaWs(HTMLParser.ScriptletOrSeaWsContext ctx) {
        ScriptLetOrSeaWs scriptLetOrSeaWs = new ScriptLetOrSeaWs();
        if (ctx.SCRIPTLET() != null){
            scriptLetOrSeaWs.setScriptLet(ctx.SCRIPTLET().getSymbol().getText());
        }
        if (ctx.SEA_WS() != null){
            scriptLetOrSeaWs.setSeaWs(ctx.SEA_WS().getSymbol().getText());
        }

        return super.visitScriptletOrSeaWs(ctx);
    }

    @Override
    public Object visitHtmlXML(HTMLParser.HtmlXMLContext ctx) {
         HtmlXML htmlXML = new HtmlXML();

        List<ScriptLetOrSeaWs> ObjscriptletOrSeaWs = new ArrayList<>();
        if(ctx.scriptletOrSeaWs() != null){
            for (int i =0 ; i <  ctx.scriptletOrSeaWs().size() ; i++){
                ObjscriptletOrSeaWs.add( (ScriptLetOrSeaWs) visitScriptletOrSeaWs(ctx.scriptletOrSeaWs(i)));
            }
            htmlXML.setScriptLetOrSeaWs(ObjscriptletOrSeaWs);
        }

        if (ctx.XML() != null){
            htmlXML.setXML(ctx.XML().getSymbol().getText());
        }
        return super.visitHtmlXML(ctx);
    }

    @Override
    public Object visitHtmlEle(HTMLParser.HtmlEleContext ctx) {
        HtmlEle htmlEle = new HtmlEle();

        List<ScriptLetOrSeaWs> ObjscriptletOrSeaWs = new ArrayList<>();
        if(ctx.scriptletOrSeaWs() != null){
            for (int i =0 ; i <  ctx.scriptletOrSeaWs().size() ; i++){
                ObjscriptletOrSeaWs.add( (ScriptLetOrSeaWs) visitScriptletOrSeaWs(ctx.scriptletOrSeaWs(i)));
            }
            htmlEle.setScriptLetOrSeaWs(ObjscriptletOrSeaWs);
        }
        List<HtmlElements> htmlElements = new ArrayList<>();
        if (ctx.htmlElements() != null){
            for (int i =0 ; i <  ctx.htmlElements().size() ; i++) {
            htmlElements.add((HtmlElements) visitHtmlElements(ctx.htmlElements(i)));
            }
            htmlEle.setHtmlElements(htmlElements);
        }
        return super.visitHtmlEle(ctx);
    }

    @Override
    public Object visitHtmlElements(HTMLParser.HtmlElementsContext ctx) {
        HtmlElements htmlElements = new HtmlElements();
        List<HtmlMisc> htmlMiscs = new ArrayList<>();

        if (ctx.htmlMisc() != null){
            for (int i = 0 ; i < ctx.htmlMisc().size() ; i ++ ){
                htmlMiscs.add((HtmlMisc) visitHtmlMisc(ctx.htmlMisc(i)));
            }
            htmlElements.setMisc(htmlMiscs);
        }

        if (ctx.htmlElementsComp() != null){
            htmlElements.setHtmlElement((HtmlElementsComp) visitHtmlElementsComp(ctx.htmlElementsComp()));
        }

        return super.visitHtmlElements(ctx);
    }

    @Override
    public Object visitHtmlElementsComp(HTMLParser.HtmlElementsCompContext ctx) {
        HtmlElementsComp htmlElementsComp = new HtmlElementsComp();

        if (ctx.htmlElement() != null){
            htmlElementsComp.setHtmlElement((HtmlElement) visitHtmlElement(ctx.htmlElement()));
        }

        List<HtmlMisc> htmlMiscs = new ArrayList<>();

        if (ctx.htmlMisc() != null){
            for (int i = 0 ; i < ctx.htmlMisc().size() ; i ++ ){
                htmlMiscs.add((HtmlMisc) visitHtmlMisc(ctx.htmlMisc(i)));
            }
            htmlElementsComp.setHtmlMiscList(htmlMiscs);
        }

        return super.visitHtmlElementsComp(ctx);
    }

    @Override
    public Object visitHtmlElement(HTMLParser.HtmlElementContext ctx) {
        //////////this
        //
        // tagOpen
        // tagName
        // htmlAttribute*
        // this tagClose
        // (htmlContent tagOpen tagSlash tagName tagClose) ?
        // or tagSlashClose
        //
        /////////or
        //ScriptLet
        //
        /////////or
        //script
        /////////or
        //style
        ////////or
        //mustacheExpression
        HtmlElement htmlElement = new HtmlElement();
        if(ctx.TAG_NAME() != null){
            if(ctx.TAG_OPEN(0) != null){
                htmlElement.setTagName(ctx.TAG_OPEN(0).getSymbol().getText());
            }
            if (ctx.TAG_NAME(1) != null){
                htmlElement.setTagName(ctx.TAG_OPEN(1).getSymbol().getText());
            }
        }

        List<HtmlAttribute> htmlAttributeList = new ArrayList<>();
        if (ctx.htmlAttribute() != null) {
            for (int i = 0; i < ctx.htmlAttribute().size(); i++) {
                htmlAttributeList.add((HtmlAttribute) visitHtmlAttribute(ctx.htmlAttribute(i)));
            }
            htmlElement.setHtmlAttributeList(htmlAttributeList);
        }

        if (ctx.htmlContent() != null){
            htmlElement.setHtmlContent((HtmlContent) visitHtmlContent(ctx.htmlContent()));
        }

        if (ctx.SCRIPTLET() != null){
            htmlElement.setScriptLet(ctx.SCRIPTLET().getSymbol().getText());
        }

        if (ctx.script() != null){
            htmlElement.setScript((Script) visitScript(ctx.script()));
        }

        if (ctx.style() != null){
            htmlElement.setStyle((Style) visitStyle(ctx.style()));
        }

        if (ctx.mustacheExpression() != null){
            htmlElement.setMustacheExpression((MustacheExpression) visitMustacheExpression(ctx.mustacheExpression()));
        }


        return super.visitHtmlElement(ctx);
    }

    @Override
    public Object visitHtmlContent(HTMLParser.HtmlContentContext ctx) {
        ////////this
        // htmlCharData?
        // ((htmlElement | CDATA | htmlComment) htmlChardata?)*
        HtmlContent htmlContent = new HtmlContent();

        if (ctx.htmlChardata() != null){
            htmlContent.setHtmlCharDataList((HtmlCharData) visitHtmlChardata(ctx.htmlChardata()));
        }
        List<HtmlContentComp> htmlContentComps = new ArrayList<>();
        if (ctx.htmlContentComp() != null){
            for (int i = 0 ; i < ctx.htmlContentComp().size() ; i ++){
                htmlContentComps.add((HtmlContentComp) visitHtmlContentComp(ctx.htmlContentComp(i)));
            }
            htmlContent.setHtmlContentComps(htmlContentComps);
        }
        return super.visitHtmlContent(ctx);
    }

    @Override
    public Object visitHtmlContentComp(HTMLParser.HtmlContentCompContext ctx) {
        HtmlContentComp htmlContentComp = new HtmlContentComp();

        if (ctx.htmlElement() != null){
            htmlContentComp.setHtmlElement((HtmlElement) visitHtmlElement(ctx.htmlElement()));
        }

        if (ctx.CDATA() != null){
            htmlContentComp.setCDATA(ctx.CDATA().getSymbol().getText());
        }

        if (ctx.htmlComment() != null){
            htmlContentComp.setHtmlComment((HtmlComment) visitHtmlComment(ctx.htmlComment()));
        }

        if (ctx.htmlChardata() != null){
            htmlContentComp.setHtmlCharData((HtmlCharData) visitHtmlChardata(ctx.htmlChardata()));
        }
        return super.visitHtmlContentComp(ctx);
    }

    @Override
    public Object visitHtmlAttribute(HTMLParser.HtmlAttributeContext ctx) {
        HtmlAttribute htmlAttribute = new HtmlAttribute();
        //app
        if (ctx.appExpression() != null){
            htmlAttribute.setAppExpression((AppExpression) visitAppExpression(ctx.appExpression()));
        }
        //for
        if (ctx.forExpression() != null){
            htmlAttribute.setForExpression((ForExpression) visitForExpression(ctx.forExpression()));
        }
        //show
        if (ctx.showExpression() != null){
            htmlAttribute.setShowExpression((ShowExpression) visitShowExpression(ctx.showExpression()));
        }
        //hide
        if (ctx.hideExpression() != null){
            htmlAttribute.setHideExpression((HideExpression) visitHideExpression(ctx.hideExpression()));
        }
        //switch
        if (ctx.switchExpression() != null){
            htmlAttribute.setSwitchExpression((SwitchExpression) visitSwitchExpression(ctx.switchExpression()));
        }
        //switchCase
        if(ctx.switchCaseExpression() != null){
            htmlAttribute.setSwitchCaseExpression((SwitchCaseExpression) visitSwitchCaseExpression(ctx.switchCaseExpression()));
        }
        //switchDefault // TODO may we need to check it

        //if
        if (ctx.ifExpression() != null){
            htmlAttribute.setIfExpression((IfExpression) visitIfExpression(ctx.ifExpression()));
        }
        //model
        if(ctx.modelExpression() != null){
            htmlAttribute.setModelExpression((ModelExpression) visitModelExpression(ctx.modelExpression()));
        }
        //click
        if (ctx.annotationClickExpression() != null){
            htmlAttribute.setAnnotationClickExpression((AnnotationClickExpression) visitAnnotationClickExpression(ctx.annotationClickExpression()));
        }
        //Over
        if (ctx.annotationOverExpression() != null){
            htmlAttribute.setAnnotationOverExpression((AnnotationOverExpression) visitAnnotationOverExpression(ctx.annotationOverExpression()));
        }
        //generic
        if (ctx.TAG_NAME() != null){
            htmlAttribute.setTagName(ctx.TAG_NAME().getSymbol().getText());
        }
        if (ctx.ATTVALUE_VALUE() != null){
            htmlAttribute.setAttValue(ctx.ATTVALUE_VALUE().getSymbol().getText());
        }

        return super.visitHtmlAttribute(ctx);
    }

    @Override
    public Object visitHtmlChardata(HTMLParser.HtmlChardataContext ctx) {
        HtmlCharData htmlCharData = new HtmlCharData();
        if (ctx.HTML_TEXT() != null){
            htmlCharData.setHtmlText(ctx.HTML_TEXT().getSymbol().getText());
        }

        if (ctx.SEA_WS() != null){
            htmlCharData.setSeaWs(ctx.SEA_WS().getSymbol().getText());
        }
        return super.visitHtmlChardata(ctx);
    }

    @Override
    public Object visitHtmlMisc(HTMLParser.HtmlMiscContext ctx) {
        HtmlMisc htmlMisc = new HtmlMisc();
        if (ctx.htmlComment() != null){
            htmlMisc.setHtmlComment((HtmlComment) visitHtmlComment(ctx.htmlComment()));
        }
        if (ctx.SEA_WS() != null){
            htmlMisc.setSeaWs(ctx.SEA_WS().getSymbol().getText());
        }
        return super.visitHtmlMisc(ctx);
    }

    @Override
    public Object visitHtmlComment(HTMLParser.HtmlCommentContext ctx) {
        HtmlComment htmlComment = new HtmlComment();
        if (ctx.HTML_COMMENT() != null){
            htmlComment.setHtmlComment(ctx.HTML_COMMENT().getSymbol().getText());
        }

        if (ctx.HTML_CONDITIONAL_COMMENT() != null){
            htmlComment.setHtmlConditionalComment(ctx.HTML_CONDITIONAL_COMMENT().getSymbol().getText());
        }
        return super.visitHtmlComment(ctx);
    }




    ///////////////////////// FATIMA /////////////////////////
    @Override
    public Object visitAppExpression(HTMLParser.AppExpressionContext ctx) {
        return super.visitAppExpression(ctx);
    }

    @Override
    public Object visitCollection4App1(HTMLParser.Collection4App1Context ctx) {
        return super.visitCollection4App1(ctx);
    }

    @Override
    public Object visitOneLine4AppCondition(HTMLParser.OneLine4AppConditionContext ctx) {
        return super.visitOneLine4AppCondition(ctx);
    }
        //////////// Fatima started  work from here /////////////

    ////////////////////// forExpression ////////////////////////
    @Override
    public Object visitForExpression(HTMLParser.ForExpressionContext ctx) {
       ForExpression forExpression=new ForExpression();

       //For CpExpression role 1
       if(ctx.collection4For1()!=null&& ctx.collection4For2()!=null){
           forExpression.setCollection4For1_1_1((Collection4For1) visitCollection4For1(ctx.collection4For1(0)));
           forExpression.setCollection4For2_1_1((Collection4For2) visitCollection4For2(ctx.collection4For2()));
           // note :i think you must be to add terminal node (In) to ForExpression in ast

          if(ctx.collection4For1().size()>1){
              //note: i did add parameter collection4For1_1_2 in ast
              forExpression.setCollection4For1_1_2((Collection4For1) visitCollection4For1(ctx.collection4For1(1)));
              // note :i think you must be to add terminal node (CP_CONTENT_EQUALS) to ForExpression in ast // TODO no you don't
              // note :i think you must be to add terminal node (INDEX) to ForExpression in ast // TODO no you don't
              // note :i think you must be to add terminal node (CP_CONTENT_SEMI_COLON) to ForExpression in ast // TODO no you don't


          }

       }

       //For CpExpression role 2
        if(ctx.collection4For1()!=null&& ctx.collection4For3()!=null){
            forExpression.setCollection4For1_2_1((Collection4For1) visitCollection4For1(ctx.collection4For1(0)));
            forExpression.setCollection4For1_2_2((Collection4For1) visitCollection4For1(ctx.collection4For1(1)));
            forExpression.setCollection4For3_2_1((Collection4For3) visitCollection4For3(ctx.collection4For3()));

        }

        //For CpExpression role 3
        if(ctx.collection4For5()!=null){
            forExpression.setCollection4For5_3_1((Collection4For4) visitCollection4For5(ctx.collection4For5()));
        }

        return super.visitForExpression(ctx);
    }

    @Override
    public Object visitCollection4For1(HTMLParser.Collection4For1Context ctx) {

      Collection4For1 collection4For1=new Collection4For1();

      //Collection4For1  role 1
      if(ctx.variable()!=null){
          collection4For1.setVariable((Variable) visitVariable(ctx.variable()));
      }
      //Collection4For1  role 2
      if(ctx.subObj()!=null){
          collection4For1.setSubObj((SubObj) visitSubObj(ctx.subObj()));
      }
      //Collection4For1  role 3
      if(ctx.objArray()!=null){
          collection4For1.setObjArray((ObjArray) visitObjArray(ctx.objArray()));
      }

        return super.visitCollection4For1(ctx);
    }

    @Override
    public Object visitCollection4For2(HTMLParser.Collection4For2Context ctx) {
       Collection4For2 collection4For2=new Collection4For2();

        //Collection4For2  role 1

        if(ctx.variable()!=null){
            collection4For2.setVariable((Variable) visitVariable(ctx.variable()));
        }
        //Collection4For2  role 2

        if(ctx.CP_CONTENT_STRING()!=null){
            collection4For2.setString(ctx.CP_CONTENT_STRING().getSymbol().getText());
        }
        //Collection4For2  role 3
        if(ctx.number()!=null){
            collection4For2.setNumber((NUmber) visitNumber(ctx.number()));
        }
        //Collection4For2  role 4
        if(ctx.subObj()!=null){
            collection4For2.setSubObj((SubObj) visitSubObj(ctx.subObj()));
        }
        //Collection4For2  role 5
        if(ctx.objArray()!=null){
            collection4For2.setObjArray((ObjArray) visitObjArray(ctx.objArray()));
        }

        //Collection4For2  role 6
        if(ctx.array()!=null){
            collection4For2.setArray((Array) visitArray(ctx.array()));
        }

        //Collection4For2  role 7
        if(ctx.functionCall()!=null){
            collection4For2.setFunctionCall((FunctionCall) visitFunctionCall(ctx.functionCall()));
        }

        //Collection4For2  role 8
        if(ctx.oneLine4For2Condition()!=null){
            collection4For2.setOneLine4For2Condition((OneLine4For2Condition) visitOneLine4For2Condition(ctx.oneLine4For2Condition()));
        }

        //Collection4For2  role 9
        if(ctx.arithmeticLogic()!=null){
            collection4For2.setArithmeticLogic((ArithmeticLogic) visitArithmeticLogic(ctx.arithmeticLogic()));
        }




        return super.visitCollection4For2(ctx);
    }

    @Override
    public Object visitOneLine4For2Condition(HTMLParser.OneLine4For2ConditionContext ctx) {

        // ex: (true && (a<b ?true :false ) && !c ? b : b)

        OneLine4For2Condition oneLine4For2Condition=new OneLine4For2Condition();

        // TODO there is no importance to this if
//       if(ctx.CP_CONTENT_OPEN_PAR()!=null&&ctx.CP_CONTENT_CLOSE_PAR()!=null){
//           oneLine4For2Condition.setOpenPar(ctx.CP_CONTENT_OPEN_PAR().getSymbol().getText());


           if(ctx.logicComprison()!=null&& ctx.collection4For2()!=null){
               oneLine4For2Condition.setLogicComprison((LogicComprison) visitLogicComprison(ctx.logicComprison()));
               oneLine4For2Condition.setCollection4For2_1_1((Collection4For2) visitCollection4For2(ctx.collection4For2(0)));
               oneLine4For2Condition.setCollection4For2_1_2((Collection4For2) visitCollection4For2(ctx.collection4For2(1)));

               // TODO it's wrong you don't need it
//              if(ctx.CP_CONTENT_QUESTION_MARK()!=null){
//                  oneLine4For2Condition.setQuestionMark(ctx.CP_CONTENT_QUESTION_MARK().getSymbol().getText());
//              }
           }
           // TODO you don't need this condition
//           if(ctx.collection4For2().size()>1){
//           }
            // maybe you think to add (Colon) to oneLine4For2Condition in ast // TODO no you don't
           oneLine4For2Condition.setClosePar(ctx.CP_CONTENT_CLOSE_PAR().getSymbol().getText());


//       }



        return super.visitOneLine4For2Condition(ctx);
    }

    @Override
    public Object visitCollection4For3(HTMLParser.Collection4For3Context ctx) {
       Collection4For3 collection4For3=new Collection4For3();

       //Collection4For3 role 1
        if(ctx.obj()!=null){
            collection4For3.setObj((Obj) visitObj(ctx.obj()));
        }

        //Collection4For3 role 2
        if(ctx.objBody()!=null){
            collection4For3.setObjBody((ObjBody)visitObjBody(ctx.objBody()));
        }

        //Collection4For3 role 3
        if(ctx.subObj()!=null){
            collection4For3.setSubObj((SubObj) visitSubObj(ctx.subObj()));
        }

        //Collection4For3 role 4
        if(ctx.objArray()!=null){
            collection4For3.setObjArray((ObjArray) visitObjArray(ctx.objArray()));
        }

        //Collection4For3 role 5
        if(ctx.functionCall()!=null){
            collection4For3.setFunctionCall((FunctionCall) visitFunctionCall(ctx.functionCall()));
        }

        //Collection4For3 role 6
        if(ctx.oneLine4For3Condition()!=null){
            collection4For3.setOneLine4For3Condition((OneLine4For3Condition) visitOneLine4For3Condition(ctx.oneLine4For3Condition()));
        }


        return super.visitCollection4For3(ctx);
    }

    @Override
    public Object visitOneLine4For3Condition(HTMLParser.OneLine4For3ConditionContext ctx) {

        OneLine4For3Condition oneLine4For3Condition=new OneLine4For3Condition();


            if(ctx.logicComprison()!=null&& ctx.collection4For3()!=null) {
                oneLine4For3Condition.setLogicComprison((LogicComprison) visitLogicComprison(ctx.logicComprison()));
                oneLine4For3Condition.setCollection4For3_1_1((Collection4For3) visitCollection4For3(ctx.collection4For3(0)));
                oneLine4For3Condition.setCollection4For3_1_2((Collection4For3) visitCollection4For3(ctx.collection4For3(1)));

            }
        return super.visitOneLine4For3Condition(ctx);
    }

    @Override
    public Object visitCollection4For5(HTMLParser.Collection4For5Context ctx) {

        Collection4For4 collection4For4=new Collection4For4();

        //Collection4For4 role 1
        if(ctx.variable()!=null){
            collection4For4.setVariable((Variable) visitVariable(ctx.variable()));
        }

        //Collection4For4 role 2
        if(ctx.number()!=null){
            collection4For4.setNumber((NUmber) visitNumber(ctx.number()));
        }

        //Collection4For4 role 3
        if(ctx.trueOrFalse()!=null){
            collection4For4.setTrueOrFalse((TrueOrFalse) visitTrueOrFalse(ctx.trueOrFalse()));
        }

        //Collection4For4 role 4
        if(ctx.objArray()!=null){
            collection4For4.setObjArray((ObjArray) visitObjArray(ctx.objArray()));
        }

        //Collection4For4 role 5
        if(ctx.functionCall()!=null){
            collection4For4.setFunctionCall((FunctionCall) visitFunctionCall(ctx.functionCall()));
        }

        //Collection4For4 role 6
        if(ctx.subObj()!=null){
            collection4For4.setSubObj((SubObj) visitSubObj(ctx.subObj()));
        }

        //Collection4For4 role 7
        if(ctx.comparisonExpression()!=null){
            collection4For4.setComparisonExpression((ComparisonExpression) visitComparisonExpression(ctx.comparisonExpression()));
        }

        //Collection4For4 role 8
        if(ctx.oneLine4For5Condition()!=null){
            collection4For4.setOneLine4For5Condition((OneLine4For4Condition) visitOneLine4For5Condition(ctx.oneLine4For5Condition()));
        }

        //Collection4For4 role 9
        if(ctx.logicComprison()!=null){
            collection4For4.setLogicComprison((LogicComprison) visitLogicComprison(ctx.logicComprison()));
        }

        //Collection4For4 role 10
        if(ctx.arithmeticLogic()!=null){
            collection4For4.setArithmeticLogic((ArithmeticLogic) visitArithmeticLogic(ctx.arithmeticLogic()));
        }


        return super.visitCollection4For5(ctx);
    }

    @Override
    public Object visitOneLine4For5Condition(HTMLParser.OneLine4For5ConditionContext ctx) {

        OneLine4For4Condition oneLine4For4Condition = new OneLine4For4Condition();


            if (ctx.logicComprison() != null && ctx.collection4For5() != null) {
                oneLine4For4Condition.setLogicComprison((LogicComprison) visitLogicComprison(ctx.logicComprison()));
                oneLine4For4Condition.setCollection4For5_1_1((Collection4For4) visitCollection4For5(ctx.collection4For5(0)));
                oneLine4For4Condition.setCollection4For5_1_2((Collection4For4) visitCollection4For5(ctx.collection4For5(1)));

            }

        return super.visitOneLine4For5Condition(ctx);
    }

   /////////////////////////// end forexprition ///////////////////////////
    @Override
    public Object visitShowExpression(HTMLParser.ShowExpressionContext ctx) {
        return super.visitShowExpression(ctx);
    }

    @Override
    public Object visitHideExpression(HTMLParser.HideExpressionContext ctx) {
        return super.visitHideExpression(ctx);
    }

    @Override
    public Object visitSwitchExpression(HTMLParser.SwitchExpressionContext ctx) {
        return super.visitSwitchExpression(ctx);
    }

    @Override
    public Object visitSwitchCaseExpression(HTMLParser.SwitchCaseExpressionContext ctx) {
        return super.visitSwitchCaseExpression(ctx);
    }

    @Override
    public Object visitCollection4Switch1(HTMLParser.Collection4Switch1Context ctx) {
        return super.visitCollection4Switch1(ctx);
    }

    @Override
    public Object visitOneLine4switch1(HTMLParser.OneLine4switch1Context ctx) {
        return super.visitOneLine4switch1(ctx);
    }

    @Override
    public Object visitIfExpression(HTMLParser.IfExpressionContext ctx) {
        return super.visitIfExpression(ctx);
    }

    @Override
    public Object visitModelExpression(HTMLParser.ModelExpressionContext ctx) {
        return super.visitModelExpression(ctx);
    }

    @Override
    public Object visitCollection4Model1(HTMLParser.Collection4Model1Context ctx) {
        return super.visitCollection4Model1(ctx);
    }

    @Override
    public Object visitOneLine4ModelCondition(HTMLParser.OneLine4ModelConditionContext ctx) {
        return super.visitOneLine4ModelCondition(ctx);
    }

    @Override
    public Object visitAnnotationClickExpression(HTMLParser.AnnotationClickExpressionContext ctx) {
        return super.visitAnnotationClickExpression(ctx);
    }

    @Override
    public Object visitAnnotationOverExpression(HTMLParser.AnnotationOverExpressionContext ctx) {
        return super.visitAnnotationOverExpression(ctx);
    }

    @Override
    public Object visitCollection4Annotation(HTMLParser.Collection4AnnotationContext ctx) {
        return super.visitCollection4Annotation(ctx);
    }

    @Override
    public Object visitOneLine4Annotation(HTMLParser.OneLine4AnnotationContext ctx) {
        return super.visitOneLine4Annotation(ctx);
    }

    @Override
    public Object visitFunctionCall4AnnotOneLine(HTMLParser.FunctionCall4AnnotOneLineContext ctx) {
        return super.visitFunctionCall4AnnotOneLine(ctx);
    }

    @Override
    public Object visitArrayFuncRet4AnnotOneLine(HTMLParser.ArrayFuncRet4AnnotOneLineContext ctx) {
        return super.visitArrayFuncRet4AnnotOneLine(ctx);
    }

    @Override
    public Object visitPropFuncRet4AnnotOneLine(HTMLParser.PropFuncRet4AnnotOneLineContext ctx) {
        return super.visitPropFuncRet4AnnotOneLine(ctx);
    }

    @Override
    public Object visitFuncEndRet4AnnotOneLine(HTMLParser.FuncEndRet4AnnotOneLineContext ctx) {
        return super.visitFuncEndRet4AnnotOneLine(ctx);
    }


    //////////////////////////////////////////////////




    ///////////////////////// MAYAR /////////////////////////

    @Override
    public Object visitVariable(HTMLParser.VariableContext ctx) {
        //: variableName
        Variable variable = new Variable();
        if (ctx.variableName() != null){
            variable.setVariableName((VariableName) visitVariableName(ctx.variableName()));
        }

        return super.visitVariable(ctx);
    }

    @Override
    public Object visitVariableName(HTMLParser.VariableNameContext ctx) {
        //: CP_CONTENT_IDENTIFIER
        VariableName variableName = new VariableName();
        if (ctx.CP_CONTENT_IDENTIFIER() != null){
            variableName.setIdentifier(ctx.CP_CONTENT_IDENTIFIER().getSymbol().getText());
        }
        return super.visitVariableName(ctx);
    }

    @Override
    public Object visitNumber(HTMLParser.NumberContext ctx) {
//        : CP_CONTENT_NUMBER
        NUmber nUmber = new NUmber();
        if (ctx.CP_CONTENT_NUMBER() != null) {
            // TODO i don't know if this is right or not
            double numberType = Double.valueOf(ctx.CP_CONTENT_NUMBER().getSymbol().getText());
            // For check what's the type of Number
            if (numberType == (int) numberType) {
                nUmber.setNumber(Integer.parseInt(ctx.CP_CONTENT_NUMBER().getSymbol().getText()));
            }
            else if (numberType == (float)numberType){
                nUmber.setNumber(Float.parseFloat(ctx
                .CP_CONTENT_NUMBER().getSymbol().getText()));
            }
            else{
                nUmber.setNumber(Double.parseDouble(ctx.CP_CONTENT_NUMBER().getSymbol().getText()));
            }
        }
        return super.visitNumber(ctx);
    }

    @Override
    public Object visitTrueOrFalse(HTMLParser.TrueOrFalseContext ctx) {
//        :  (CP_CONTENT_TRUE | CP_CONTENT_FALSE)
        TrueOrFalse trueOrFalse = new TrueOrFalse();
        if (ctx.CP_CONTENT_TRUE() != null){
            trueOrFalse.setTrue(true);
        }

        if (ctx.CP_CONTENT_FALSE() != null){
            trueOrFalse.setFalse(false);
        }
        return super.visitTrueOrFalse(ctx);
    }

    @Override
    public Object visitObjArray(HTMLParser.ObjArrayContext ctx) {
//        : arrName arrayCalling
        ObjArray objArray = new ObjArray();

        if (ctx.arrName() != null){
            objArray.setArrName((ArrName) visitArrName(ctx.arrName()));
        }
        if (ctx.arrayCalling() != null){
            objArray.setArrayCalling((ArrayCalling) visitArrayCalling(ctx.arrayCalling()));
        }
        return super.visitObjArray(ctx);
    }

    @Override
    public Object visitArrName(HTMLParser.ArrNameContext ctx) {
//        : CP_CONTENT_IDENTIFIER
        ArrName arrName = new ArrName();

        if (ctx.CP_CONTENT_IDENTIFIER() != null){
            arrName.setIdentifier(ctx.CP_CONTENT_IDENTIFIER().getSymbol().getText());
        }
        return super.visitArrName(ctx);
    }

    @Override
    public Object visitArrayCalling(HTMLParser.ArrayCallingContext ctx) {
//: (CP_CONTENT_OPEN_BRACKETS  arithmeticLogic CP_CONTENT_CLOSE_BRACKETS)+ (functionCallFromVar | property)?
        ArrayCalling arrayCalling = new ArrayCalling();

        return super.visitArrayCalling(ctx);
    }

    @Override
    public Object visitArray(HTMLParser.ArrayContext ctx) {
        return super.visitArray(ctx);
    }

    @Override
    public Object visitObj(HTMLParser.ObjContext ctx) {
        return super.visitObj(ctx);
    }

    @Override
    public Object visitSubObj(HTMLParser.SubObjContext ctx) {
        return super.visitSubObj(ctx);
    }

    @Override
    public Object visitObjBody(HTMLParser.ObjBodyContext ctx) {
        return super.visitObjBody(ctx);
    }

    @Override
    public Object visitPair(HTMLParser.PairContext ctx) {
        return super.visitPair(ctx);
    }

    @Override
    public Object visitKey(HTMLParser.KeyContext ctx) {
        return super.visitKey(ctx);
    }

    @Override
    public Object visitProperty(HTMLParser.PropertyContext ctx) {
        return super.visitProperty(ctx);
    }

    @Override
    public Object visitPropertyValue(HTMLParser.PropertyValueContext ctx) {
        return super.visitPropertyValue(ctx);
    }

    @Override
    public Object visitFunctionCall(HTMLParser.FunctionCallContext ctx) {
        return super.visitFunctionCall(ctx);
    }

    @Override
    public Object visitFunctionCallFromVar(HTMLParser.FunctionCallFromVarContext ctx) {
        return super.visitFunctionCallFromVar(ctx);
    }

    @Override
    public Object visitFunctionName(HTMLParser.FunctionNameContext ctx) {
        return super.visitFunctionName(ctx);
    }

    @Override
    public Object visitParameters(HTMLParser.ParametersContext ctx) {
        return super.visitParameters(ctx);
    }

    @Override
    public Object visitParameter(HTMLParser.ParameterContext ctx) {
        return super.visitParameter(ctx);
    }

    @Override
    public Object visitComparisonExpression(HTMLParser.ComparisonExpressionContext ctx) {
        return super.visitComparisonExpression(ctx);
    }

    @Override
    public Object visitOneLineCondition(HTMLParser.OneLineConditionContext ctx) {
        return super.visitOneLineCondition(ctx);
    }

    @Override
    public Object visitOneLineBoolCondition(HTMLParser.OneLineBoolConditionContext ctx) {
        return super.visitOneLineBoolCondition(ctx);
    }

    @Override
    public Object visitOneLineArithCondition(HTMLParser.OneLineArithConditionContext ctx) {
        return super.visitOneLineArithCondition(ctx);
    }

    @Override
    public Object visitComparisonOperator(HTMLParser.ComparisonOperatorContext ctx) {
        return super.visitComparisonOperator(ctx);
    }

    @Override
    public Object visitLogicComprison(HTMLParser.LogicComprisonContext ctx) {
        LogicComprison logicComprison = new LogicComprison();
        if (ctx.CP_CONTENT_NOT() != null){
            logicComprison.setNotFirst(ctx.CP_CONTENT_NOT().getSymbol().getText());
        }

        if (ctx.collection4LogicRet() != null){
            logicComprison.setCollection4LogicRetFirst((Collection4LogicRet) visitCollection4LogicRet(ctx.collection4LogicRet()));
        }

        if (ctx.CP_CONTENT_OPEN_PAR() != null){
            logicComprison.setOpenParFirst(ctx.CP_CONTENT_OPEN_PAR().getSymbol().getText());
        }

        if (ctx.logicComprison() != null){
            logicComprison.setLogicComprisonFirst((LogicComprison) visitLogicComprison(ctx.logicComprison()));
        }

        List<MiddleAndLastLogicComparison> middleAndLastLogicComparisons = new ArrayList<>();
        if (ctx.middleAndLastLogicComparison() != null){
            for (int i = 0 ; i < ctx.middleAndLastLogicComparison().size() ; i++){
                middleAndLastLogicComparisons.add((MiddleAndLastLogicComparison) visitMiddleAndLastLogicComparison(ctx.middleAndLastLogicComparison(i)));
            }
            logicComprison.setMiddleAndLastLogicComparisons(middleAndLastLogicComparisons);
        }
        return super.visitLogicComprison(ctx);
    }
    @Override
    public Object visitMiddleAndLastLogicComparison(HTMLParser.MiddleAndLastLogicComparisonContext ctx) {
        return super.visitMiddleAndLastLogicComparison(ctx);
    }
    @Override
    public Object visitArithmeticLogic(HTMLParser.ArithmeticLogicContext ctx) {
        return super.visitArithmeticLogic(ctx);
    }
    @Override
    public Object visitLastArithmeticLogic(HTMLParser.LastArithmeticLogicContext ctx) {
        return super.visitLastArithmeticLogic(ctx);
    }
    @Override
    public Object visitValue(HTMLParser.ValueContext ctx) {
        return super.visitValue(ctx);
    }

    @Override
    public Object visitCollection4everything(HTMLParser.Collection4everythingContext ctx) {
        return super.visitCollection4everything(ctx);
    }

    @Override
    public Object visitCollection4comparison(HTMLParser.Collection4comparisonContext ctx) {
        return super.visitCollection4comparison(ctx);
    }

    @Override
    public Object visitCollection4Arithmetic(HTMLParser.Collection4ArithmeticContext ctx) {
        return super.visitCollection4Arithmetic(ctx);
    }

    @Override
    public Object visitCollection4LogicRet(HTMLParser.Collection4LogicRetContext ctx) {
        return super.visitCollection4LogicRet(ctx);
    }


    //////////////////////////////////////////////////










    ///////////////////////// NOOR /////////////////////////
    @Override
    public Object visitMustacheExpression(HTMLParser.MustacheExpressionContext ctx) {
        return super.visitMustacheExpression(ctx);
    }
    @Override
    public Object visitCollection4Mustache(HTMLParser.Collection4MustacheContext ctx) {
        return super.visitCollection4Mustache(ctx);
    }

    @Override
    public Object visitCollection4LogicRet4Must(HTMLParser.Collection4LogicRet4MustContext ctx) {
        return super.visitCollection4LogicRet4Must(ctx);
    }

    @Override
    public Object visitCollection4CompMust(HTMLParser.Collection4CompMustContext ctx) {
        return super.visitCollection4CompMust(ctx);
    }

    @Override
    public Object visitCollection4MUSTArithmetic(HTMLParser.Collection4MUSTArithmeticContext ctx) {
        return super.visitCollection4MUSTArithmetic(ctx);
    }

    @Override
    public Object visitLogicComprison4Must(HTMLParser.LogicComprison4MustContext ctx) {
        return super.visitLogicComprison4Must(ctx);
    }

    @Override
    public Object visitMiddleAndLastLogicComparison4Must(HTMLParser.MiddleAndLastLogicComparison4MustContext ctx) {
        return super.visitMiddleAndLastLogicComparison4Must(ctx);
    }

    @Override
    public Object visitArithmeticLogic4Must(HTMLParser.ArithmeticLogic4MustContext ctx) {
        return super.visitArithmeticLogic4Must(ctx);
    }

    @Override
    public Object visitLastArithmeticLogic4Must(HTMLParser.LastArithmeticLogic4MustContext ctx) {
        return super.visitLastArithmeticLogic4Must(ctx);
    }
    @Override
    public Object visitMustacheVariable(HTMLParser.MustacheVariableContext ctx) {
        return super.visitMustacheVariable(ctx);
    }

    @Override
    public Object visitMustacheNumber(HTMLParser.MustacheNumberContext ctx) {
        return super.visitMustacheNumber(ctx);
    }

    @Override
    public Object visitMustacheValue(HTMLParser.MustacheValueContext ctx) {
        return super.visitMustacheValue(ctx);
    }

    @Override
    public Object visitObjArray4Must(HTMLParser.ObjArray4MustContext ctx) {
        return super.visitObjArray4Must(ctx);
    }

    @Override
    public Object visitArrName4Must(HTMLParser.ArrName4MustContext ctx) {
        return super.visitArrName4Must(ctx);
    }

    @Override
    public Object visitArrayCalling4Must(HTMLParser.ArrayCalling4MustContext ctx) {
        return super.visitArrayCalling4Must(ctx);
    }

    @Override
    public Object visitFunctionCall4Must(HTMLParser.FunctionCall4MustContext ctx) {
        return super.visitFunctionCall4Must(ctx);
    }

    @Override
    public Object visitFunctionCallFromVar4Must(HTMLParser.FunctionCallFromVar4MustContext ctx) {
        return super.visitFunctionCallFromVar4Must(ctx);
    }

    @Override
    public Object visitFunctionName4Must(HTMLParser.FunctionName4MustContext ctx) {
        return super.visitFunctionName4Must(ctx);
    }

    @Override
    public Object visitParameters4Must(HTMLParser.Parameters4MustContext ctx) {
        return super.visitParameters4Must(ctx);
    }

    @Override
    public Object visitParameter4Must(HTMLParser.Parameter4MustContext ctx) {
        return super.visitParameter4Must(ctx);
    }

    @Override
    public Object visitSubObj4Must(HTMLParser.SubObj4MustContext ctx) {
        return super.visitSubObj4Must(ctx);
    }

    @Override
    public Object visitProperty4Must(HTMLParser.Property4MustContext ctx) {
        return super.visitProperty4Must(ctx);
    }

    @Override
    public Object visitPropertyValue4Must(HTMLParser.PropertyValue4MustContext ctx) {
        return super.visitPropertyValue4Must(ctx);
    }

    @Override
    public Object visitOneLineCondition4Must(HTMLParser.OneLineCondition4MustContext ctx) {
        return super.visitOneLineCondition4Must(ctx);
    }

    @Override
    public Object visitOneLineArithCondition4Must(HTMLParser.OneLineArithCondition4MustContext ctx) {
        return super.visitOneLineArithCondition4Must(ctx);
    }

    @Override
    public Object visitOneLineBoolCondition4Must(HTMLParser.OneLineBoolCondition4MustContext ctx) {
        return super.visitOneLineBoolCondition4Must(ctx);
    }

    @Override
    public Object visitComparisonExp4Must(HTMLParser.ComparisonExp4MustContext ctx) {
        return super.visitComparisonExp4Must(ctx);
    }

    @Override
    public Object visitMustacheComparisonOperator(HTMLParser.MustacheComparisonOperatorContext ctx) {
        return super.visitMustacheComparisonOperator(ctx);
    }

    @Override
    public Object visitFilter(HTMLParser.FilterContext ctx) {
        return super.visitFilter(ctx);
    }

    @Override
    public Object visitModelName(HTMLParser.ModelNameContext ctx) {
        return super.visitModelName(ctx);
    }

    @Override
    public Object visitFormatName(HTMLParser.FormatNameContext ctx) {
        return super.visitFormatName(ctx);
    }

    @Override
    public Object visitScript(HTMLParser.ScriptContext ctx) {
        return super.visitScript(ctx);
    }

    @Override
    public Object visitStyle(HTMLParser.StyleContext ctx) {
        return super.visitStyle(ctx);
    }
    //////////////////////////////////////////////////


}
