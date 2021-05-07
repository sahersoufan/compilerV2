package Base;

import AST.Elements.*;
import AST.Elements.ElementsNodes.*;
import AST.Elements.ElementsNodes.CpExpression.For.ForExpression;
import AST.Elements.ElementsNodes.CpExpression.If.IfExpression;
import AST.Elements.ElementsNodes.CpExpression.Switch.Collection4Switch1;
import AST.Elements.ElementsNodes.CpExpression.Switch.OneLine4switch1;
import AST.Elements.ElementsNodes.CpExpression.Switch.SwitchCaseExpression;
import AST.Elements.ElementsNodes.CpExpression.Switch.SwitchExpression;
import AST.Elements.ElementsNodes.CpExpression.annotation.AnnotationClickExpression;
import AST.Elements.ElementsNodes.CpExpression.annotation.AnnotationOverExpression;
import AST.Elements.ElementsNodes.CpExpression.app.AppExpression;
import AST.Elements.ElementsNodes.CpExpression.app.Collection4App1;
import AST.Elements.ElementsNodes.CpExpression.app.OneLine4AppCondition;
import AST.Elements.ElementsNodes.CpExpression.model.Collection4Model1;
import AST.Elements.ElementsNodes.CpExpression.model.ModelExpression;
import AST.Elements.ElementsNodes.CpExpression.model.OneLine4ModelCondition;
import AST.Elements.ElementsNodes.CpExpression.showHide.HideExpression;
import AST.Elements.ElementsNodes.CpExpression.showHide.ShowExpression;
import AST.Elements.ElementsNodes.generic4Elements.Collection4LogicRet;
import AST.Elements.ElementsNodes.generic4Elements.Logic.LogicComprison;
import AST.Elements.ElementsNodes.generic4Elements.Logic.MiddleAndLastLogicComparison;
import AST.Elements.ElementsNodes.generic4Elements.NUmber;
import AST.Elements.ElementsNodes.generic4Elements.TrueOrFalse;
import AST.Elements.ElementsNodes.generic4Elements.array.ArrName;
import AST.Elements.ElementsNodes.generic4Elements.array.ArrayCalling;
import AST.Elements.ElementsNodes.generic4Elements.array.ObjArray;
import AST.Elements.ElementsNodes.generic4Elements.variable.Variable;
import AST.Elements.ElementsNodes.generic4Elements.variable.VariableName;
import AST.Elements.ElementsNodes.mustacheExpression.MustacheExpression;
import AST.HtmlDocument;
import AST.HtmlEle;
import AST.HtmlXML;
import generatedGrammers.HTMLParser;
import generatedGrammers.HTMLParserBaseVisitor;
import treePrinter.SimpleTreeNode;

import javax.accessibility.AccessibleTable;
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
    SimpleTreeNode root = new SimpleTreeNode("root");
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
        AppExpression appExpression=new AppExpression();

        if(ctx.collection4App1()!=null){
            appExpression.setCollection4App1((Collection4App1) visitCollection4App1(ctx.collection4App1()));
        }

        return super.visitAppExpression(ctx);
    }

    @Override
    public Object visitCollection4App1(HTMLParser.Collection4App1Context ctx) {

        Collection4App1 collection4App1=new Collection4App1();

        //collection4App1 role1
        if(ctx.variable()!=null){
            collection4App1.setVariable((Variable) visitVariable(ctx.variable()));
        }
        //collection4App1 role2

        if(ctx.subObj()!=null){
            collection4App1.setSubObj((SubObj) visitSubObj(ctx.subObj()));
        }
        //collection4App1  role 3
        if(ctx.objArray()!=null){
            collection4App1.setObjArray((ObjArray) visitObjArray(ctx.objArray()));
        }

        //collection4App1  role 4
        if(ctx.functionCall()!=null){
            collection4App1.setFunctionCall((FunctionCall) visitFunctionCall(ctx.functionCall()));
        }

        //collection4App1  role 5
        if(ctx.oneLine4AppCondition()!=null){
            collection4App1.setOneLine4AppCondition((OneLine4AppCondition) visitOneLine4AppCondition(ctx.oneLine4AppCondition()));
        }


        return super.visitCollection4App1(ctx);
    }

    @Override
    public Object visitOneLine4AppCondition(HTMLParser.OneLine4AppConditionContext ctx) {

        OneLine4AppCondition  oneLine4AppCondition=new OneLine4AppCondition();

        if(ctx.logicComprison()!=null&& ctx.collection4App1()!=null){
            oneLine4AppCondition.setLogicComprison((LogicComprison) visitLogicComprison(ctx.logicComprison()));
            oneLine4AppCondition.setCollection4App1_1((Collection4App1) visitCollection4App1(ctx.collection4App1(0)));
            oneLine4AppCondition.setCollection4App1_2((Collection4App1) visitCollection4App1(ctx.collection4App1(1)));
        }

        return super.visitOneLine4AppCondition(ctx);
    }


    ////////////////////// forExpression ////////////////////////
    @Override
    public Object visitForExpression(HTMLParser.ForExpressionContext ctx) {
       ForExpression forExpression=new ForExpression();

       //For CpExpression role 1
       if(ctx.collection4For1()!=null&& ctx.collection4For2()!=null){
           forExpression.setCollection4For1_1_1((Collection4For1) visitCollection4For1(ctx.collection4For1(0)));
           forExpression.setCollection4For2_1_1((Collection4For2) visitCollection4For2(ctx.collection4For2()));

          if(ctx.collection4For1().size()>1){
              forExpression.setCollection4For1_1_2((Collection4For1) visitCollection4For1(ctx.collection4For1(1)));

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

        oneLine4For2Condition.setOpenPar(ctx.CP_CONTENT_OPEN_PAR().getSymbol().getText());
           if(ctx.logicComprison()!=null&& ctx.collection4For2()!=null){
               oneLine4For2Condition.setLogicComprison((LogicComprison) visitLogicComprison(ctx.logicComprison()));
               oneLine4For2Condition.setCollection4For2_1_1((Collection4For2) visitCollection4For2(ctx.collection4For2(0)));
               oneLine4For2Condition.setCollection4For2_1_2((Collection4For2) visitCollection4For2(ctx.collection4For2(1)));
           }


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

    /////////////////////////// show exprition ///////////////////////////
    @Override
    public Object visitShowExpression(HTMLParser.ShowExpressionContext ctx) {

        ShowExpression showExpression=new ShowExpression();
        if(ctx.logicComprison()!=null){
            showExpression.setLogicComprison((LogicComprison) visitLogicComprison(ctx.logicComprison()));
        }

        return super.visitShowExpression(ctx);
    }
    /////////////////////////// end show exprition ///////////////////////////

    ///////////////////////////  Hide exprition ///////////////////////////
    @Override
    public Object visitHideExpression(HTMLParser.HideExpressionContext ctx) {
        HideExpression hideExpression=new HideExpression();

        if(ctx.logicComprison()!=null){
            hideExpression.setLogicComprison((LogicComprison) visitLogicComprison(ctx.logicComprison()));
        }
        return super.visitHideExpression(ctx);
    }

    ///////////////////////////  end Hide exprition ///////////////////////////


    ///////////////////////////  Switch exprition ///////////////////////////
    @Override
    public Object visitSwitchExpression(HTMLParser.SwitchExpressionContext ctx) {
      SwitchExpression switchExpression=new SwitchExpression();

      if(ctx.collection4Switch1()!=null){
          switchExpression.setCollection4Switch1((Collection4Switch1) visitCollection4Switch1(ctx.collection4Switch1()));
      }

        return super.visitSwitchExpression(ctx);
    }

    @Override
    public Object visitSwitchCaseExpression(HTMLParser.SwitchCaseExpressionContext ctx) {

        SwitchCaseExpression switchCaseExpression=new SwitchCaseExpression();

        if(ctx.collection4Switch1()!=null){
            switchCaseExpression.setCollection4Switch1((Collection4Switch1) visitCollection4Switch1(ctx.collection4Switch1()));
        }
        return super.visitSwitchCaseExpression(ctx);
    }

    @Override
    public Object visitCollection4Switch1(HTMLParser.Collection4Switch1Context ctx) {

        Collection4Switch1 collection4Switch1=new Collection4Switch1();


        //Collection4Switch1  role 1

        if(ctx.variable()!=null){
            collection4Switch1.setVariable((Variable) visitVariable(ctx.variable()));
        }
        //Collection4Switch1  role 2

        if(ctx.CP_CONTENT_STRING()!=null){
            collection4Switch1.setString(ctx.CP_CONTENT_STRING().getSymbol().getText());
        }
        //Collection4Switch1  role 3
        if(ctx.number()!=null){
            collection4Switch1.setNumber((NUmber) visitNumber(ctx.number()));
        }
        //Collection4Switch1  role 4
        if(ctx.subObj()!=null){
            collection4Switch1.setSubObj((SubObj) visitSubObj(ctx.subObj()));
        }
        //Collection4Switch1  role 5
        if(ctx.objArray()!=null){
            collection4Switch1.setObjArray((ObjArray) visitObjArray(ctx.objArray()));
        }

        //Collection4Switch1  role 6
        if(ctx.oneLine4switch1()!=null){
            collection4Switch1.setOneLine4switch1((OneLine4switch1) visitOneLine4switch1(ctx.oneLine4switch1()));
        }

        //Collection4Switch1  role 7
        if(ctx.arithmeticLogic()!=null){
            collection4Switch1.setArithmeticLogic((ArithmeticLogic) visitArithmeticLogic(ctx.arithmeticLogic()));
        }


        return super.visitCollection4Switch1(ctx);
    }

    @Override
    public Object visitOneLine4switch1(HTMLParser.OneLine4switch1Context ctx) {

        OneLine4switch1  oneLine4switch1=new OneLine4switch1 ();

        if(ctx.logicComprison()!=null&& ctx.collection4Switch1()!=null){
            oneLine4switch1.setLogicComprison((LogicComprison) visitLogicComprison(ctx.logicComprison()));
            oneLine4switch1.setCollection4Switch1_1_1((Collection4Switch1) visitCollection4Switch1(ctx.collection4Switch1(0)));
            oneLine4switch1.setCollection4Switch1_1_2((Collection4Switch1) visitCollection4Switch1(ctx.collection4Switch1(1)));
        }

        return super.visitOneLine4switch1(ctx);
    }

    ///////////////////////////   End Switch exprition ///////////////////////////

    ///////////////////////////  If exprition ///////////////////////////

    @Override
    public Object visitIfExpression(HTMLParser.IfExpressionContext ctx) {

        IfExpression ifExpression =new IfExpression();

      if(ctx.logicComprison()!=null){
          ifExpression.setLogicComprison((LogicComprison) visitLogicComprison(ctx.logicComprison()));
      }

        return super.visitIfExpression(ctx);
    }

    ///////////////////////////  end If exprition ///////////////////////////

    ///////////////////////////  Model exprition ///////////////////////////
    @Override
    public Object visitModelExpression(HTMLParser.ModelExpressionContext ctx) {

        ModelExpression modelExpression =new ModelExpression();

        if(ctx.collection4Model1()!=null){
            modelExpression.setCollection4Model1((Collection4Model1) visitCollection4Model1(ctx.collection4Model1()));
        }

        return super.visitModelExpression(ctx);
    }

    @Override
    public Object visitCollection4Model1(HTMLParser.Collection4Model1Context ctx) {

       Collection4Model1 collection4Model1=new Collection4Model1();

        //Collection4Model1 role 1
        if(ctx.variable()!=null){
            collection4Model1.setVariable((Variable) visitVariable(ctx.variable()));
        }


        //Collection4Model1 role 2
        if(ctx.objArray()!=null){
            collection4Model1.setObjArray((ObjArray) visitObjArray(ctx.objArray()));
        }

        //Collection4Model1 role 3
        if(ctx.functionCall()!=null){
            collection4Model1.setFunctionCall((FunctionCall) visitFunctionCall(ctx.functionCall()));
        }

        //Collection4Model1 role 4
        if(ctx.subObj()!=null){
            collection4Model1.setSubObj((SubObj) visitSubObj(ctx.subObj()));
        }

        //Collection4Model1 role 5
        if(ctx.oneLine4ModelCondition()!=null){
            collection4Model1.setOneLine4ModelCondition((OneLine4ModelCondition) visitOneLine4ModelCondition(ctx.oneLine4ModelCondition()));
        }

        return super.visitCollection4Model1(ctx);
    }

    @Override
    public Object visitOneLine4ModelCondition(HTMLParser.OneLine4ModelConditionContext ctx) {

        OneLine4ModelCondition oneLine4ModelCondition=new OneLine4ModelCondition();

        if(ctx.logicComprison()!=null&& ctx.collection4Model1()!=null){
            oneLine4ModelCondition.setLogicComprison((LogicComprison) visitLogicComprison(ctx.logicComprison()));
            oneLine4ModelCondition.setCollection4Model1_1_1((Collection4Model1) visitCollection4Model1(ctx.collection4Model1(0)));
            oneLine4ModelCondition.setCollection4Model1_1_2((Collection4Model1) visitCollection4Model1(ctx.collection4Model1(1)));
        }

        return super.visitOneLine4ModelCondition(ctx);
    }
    /////////////////////////// End  Model exprition ///////////////////////////

    ///////////////////////////  Annotation exprition ///////////////////////////

    @Override
    public Object visitAnnotationClickExpression(HTMLParser.AnnotationClickExpressionContext ctx) {
       AnnotationClickExpression clickExpression =new AnnotationClickExpression();

       if(ctx.collection4Annotation()!=null){
           clickExpression.setCollection4Annotation((Collection4Annotation) visitCollection4Annotation(ctx.collection4Annotation()));
       }

        return super.visitAnnotationClickExpression(ctx);
    }

    @Override
    public Object visitAnnotationOverExpression(HTMLParser.AnnotationOverExpressionContext ctx) {

         AnnotationOverExpression overExpression =new AnnotationOverExpression ();

        if(ctx.collection4Annotation()!=null){
            overExpression.setCollection4Annotation((Collection4Annotation) visitCollection4Annotation(ctx.collection4Annotation()));
        }

        return super.visitAnnotationOverExpression(ctx);
    }

    @Override
    public Object visitCollection4Annotation(HTMLParser.Collection4AnnotationContext ctx) {
        Collection4Annotation collection4Annotation =new Collection4Annotation();

        if(ctx.functionCall4AnnotOneLine()!=null){
            collection4Annotation.setFunctionCall4AnnotOneLine((FunctionCall4AnnotOneLine) visitFunctionCall4AnnotOneLine(ctx.functionCall4AnnotOneLine()));
        }

        if(ctx.arrName()!=null && ctx.arrayFuncRet4AnnotOneLine()!=null){
            collection4Annotation.setArrName((ArrName) visitArrName(ctx.arrName()));
            collection4Annotation.setArrayFuncRet4AnnotOneLine((ArrayFuncRet4AnnotOneLine) visitFunctionCall4AnnotOneLine(ctx.functionCall4AnnotOneLine()));
        }

        if(ctx.obj()!=null && ctx.propFuncRet4AnnotOneLine()!=null){
            collection4Annotation.setPropFuncRet4AnnotOneLine((PropFuncRet4AnnotOneLine) visitPropFuncRet4AnnotOneLine(ctx.propFuncRet4AnnotOneLine()));
            collection4Annotation.setObj((Obj) visitObj(ctx.obj()));
        }

        if(ctx.oneLine4Annotation()!=null){
            collection4Annotation.setOneLine4Annotation((OneLine4Annotation) visitOneLine4Annotation(ctx.oneLine4Annotation()));
        }


        return super.visitCollection4Annotation(ctx);
    }

    @Override
    public Object visitOneLine4Annotation(HTMLParser.OneLine4AnnotationContext ctx) {

          OneLine4Annotation oneLine4Annotation=new OneLine4Annotation();
        if(ctx.logicComprison()!=null&& ctx.collection4Annotation()!=null){
            oneLine4Annotation.setLogicComprison((LogicComprison) visitLogicComprison(ctx.logicComprison()));
            oneLine4Annotation.setCollection4Annotation1_1((Collection4Annotation) visitCollection4Annotation(ctx.collection4Annotation(0)));
            oneLine4Annotation.setCollection4Annotation1_2((Collection4Annotation) visitCollection4Annotation(ctx.collection4Annotation(1)));
        }
        return super.visitOneLine4Annotation(ctx);
    }

    @Override
    public Object visitFunctionCall4AnnotOneLine(HTMLParser.FunctionCall4AnnotOneLineContext ctx) {

       FunctionCall4AnnotOneLine functionCall4AnnotOneLine=new FunctionCall4AnnotOneLine();

       if(ctx.funcEndRet4AnnotOneLine()!=null&&ctx.funcEndRet4AnnotOneLine()!=null){

           functionCall4AnnotOneLine.setFuncEndRet4AnnotOneLine((FuncEndRet4AnnotOneLine) visitFuncEndRet4AnnotOneLine(ctx.funcEndRet4AnnotOneLine()));
           functionCall4AnnotOneLine.setFunctionName((FunctionName) visitFunctionName(ctx.functionName()));
       }

        return super.visitFunctionCall4AnnotOneLine(ctx);
    }

    @Override
    public Object visitArrayFuncRet4AnnotOneLine(HTMLParser.ArrayFuncRet4AnnotOneLineContext ctx) {

        ArrayFuncRet4AnnotOneLine arrayFuncRet4AnnotOneLine=new ArrayFuncRet4AnnotOneLine();
        List <ArithmeticLogic> arithmeticLogics=new ArrayList<>();


        if(ctx.arithmeticLogic()!=null){

            for(int i=0;i<ctx.arithmeticLogic().size();i++){
                arithmeticLogics.add((ArithmeticLogic) visitArithmeticLogic(ctx.arithmeticLogic(i)));
            }
            arrayFuncRet4AnnotOneLine.setArithmeticLogics(arithmeticLogics);
        }


        if(ctx.propFuncRet4AnnotOneLine()!=null) {
            arrayFuncRet4AnnotOneLine.setPropFuncRet4AnnotOneLine((PropFuncRet4AnnotOneLine) visitPropFuncRet4AnnotOneLine(ctx.propFuncRet4AnnotOneLine()));

        }
        if(ctx.funcEndRet4AnnotOneLine()!=null){
            arrayFuncRet4AnnotOneLine.setFuncEndRet4AnnotOneLine((FuncEndRet4AnnotOneLine) visitFuncEndRet4AnnotOneLine(ctx.funcEndRet4AnnotOneLine()));
        }


        return super.visitArrayFuncRet4AnnotOneLine(ctx);
    }

    @Override
    public Object visitPropFuncRet4AnnotOneLine(HTMLParser.PropFuncRet4AnnotOneLineContext ctx) {
       PropFuncRet4AnnotOneLine propFuncRet4AnnotOneLine=new PropFuncRet4AnnotOneLine();
       List <PropertyValue>propertyValues=new ArrayList<>();

       if(ctx.propertyValue()!=null){
           for(int i=0;i<ctx.propertyValue().size();i++){
               propertyValues.add((PropertyValue) visitPropertyValue(ctx.propertyValue(i)));
           }
           propFuncRet4AnnotOneLine.setPropertyValue(propertyValues);
       }


       if(ctx.arrayFuncRet4AnnotOneLine()!=null){
           propFuncRet4AnnotOneLine.setArrayFuncRet4AnnotOneLine((ArrayFuncRet4AnnotOneLine) visitArrayFuncRet4AnnotOneLine(ctx.arrayFuncRet4AnnotOneLine()));

       }
       if(ctx.funcEndRet4AnnotOneLine()!=null){

            propFuncRet4AnnotOneLine.setFuncEndRet4AnnotOneLine((FuncEndRet4AnnotOneLine) visitFuncEndRet4AnnotOneLine(ctx.funcEndRet4AnnotOneLine()));


       }

        return super.visitPropFuncRet4AnnotOneLine(ctx);
    }

    @Override
    public Object visitFuncEndRet4AnnotOneLine(HTMLParser.FuncEndRet4AnnotOneLineContext ctx) {

         FuncEndRet4AnnotOneLine funcEndRet4AnnotOneLine=new FuncEndRet4AnnotOneLine();
         List<Parameters>parameters=new ArrayList<>();

         if(ctx.parameters()!=null){
             for(int i=0;i<ctx.parameters().size();i++){ ;
                 parameters.add((Parameters)visitParameters(ctx.parameters(i)));
             }
             funcEndRet4AnnotOneLine.setFunctionParameters(parameters);
         }


        if(ctx.arrayFuncRet4AnnotOneLine()!=null){
            funcEndRet4AnnotOneLine.setArrayFuncRet4AnnotOneLine((ArrayFuncRet4AnnotOneLine) visitArrayFuncRet4AnnotOneLine(ctx.arrayFuncRet4AnnotOneLine()));

        }if(ctx.propFuncRet4AnnotOneLine()!=null){
             funcEndRet4AnnotOneLine.setPropFuncRet4AnnotOneLine((PropFuncRet4AnnotOneLine) visitPropFuncRet4AnnotOneLine(ctx.propFuncRet4AnnotOneLine()));

         }


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

        List<ArithmeticLogic> arithmeticLogics = new ArrayList<>();
        if (ctx.arithmeticLogic() != null){
            for (int i = 0 ; i < ctx.arithmeticLogic().size() ; i ++){
                arithmeticLogics.add((ArithmeticLogic) visitArithmeticLogic(ctx.arithmeticLogic(i)));
            }
            arrayCalling.setArithmeticLogic(arithmeticLogics);
        }

        if (ctx.functionCallFromVar() != null){
            arrayCalling.setFunctionCallFromVar((FunctionCallFromVar) visitFunctionCallFromVar(ctx.functionCallFromVar()));
        }

        if (ctx.property() != null){
            arrayCalling.setProperty((Property) visitProperty(ctx.property()));
        }

        return super.visitArrayCalling(ctx);
    }

    @Override
    public Object visitArray(HTMLParser.ArrayContext ctx) {
        Array array = new Array();


        ArrayList<Collection4everything> internalCollections4EveryThings = new ArrayList<>();
        if (ctx.collection4everything() != null){
            for (int i =0 ; i<ctx.collection4everything().size();i++){
                internalCollections4EveryThings.add((Collection4everything) visitCollection4everything(ctx.collection4everything(i)));
            }
            array.setInternalCollection4everythings(internalCollections4EveryThings);

        }
        return super.visitArray(ctx);
    }

    @Override
    public Object visitObj(HTMLParser.ObjContext ctx) {
//    : CP_CONTENT_IDENTIFIER

        Obj obj = new Obj();

        if (ctx.CP_CONTENT_IDENTIFIER() != null){
            obj.setIdentifier(ctx.CP_CONTENT_IDENTIFIER().getSymbol().getText());
        }
        return super.visitObj(ctx);
    }

    @Override
    public Object visitSubObj(HTMLParser.SubObjContext ctx) {
//    : CP_CONTENT_IDENTIFIER property
        SubObj subObj = new SubObj();

        if (ctx.CP_CONTENT_IDENTIFIER() != null){
            subObj.setIdentifier(ctx.CP_CONTENT_IDENTIFIER().getSymbol().getText());
        }

        if (ctx.property() != null){
            subObj.setProperty((Property) visitProperty(ctx.property()));
        }
        return super.visitSubObj(ctx);
    }

    @Override
    public Object visitObjBody(HTMLParser.ObjBodyContext ctx) {
//: CP_CONTENT_OPEN_CURLY_BRACKETS (pair (CP_CONTENT_COMMA pair)*)* CP_CONTENT_CLOSE_CURLY_BRACKETS

        ObjBody objBody = new ObjBody();

        ArrayList<Pair> pairs = new ArrayList<>();
        if (ctx.pair() != null){
            for (int i=0 ; i< ctx.pair().size(); i++){
                pairs.add((Pair) visitPair(ctx.pair(i)));
            }
            objBody.setPairs(pairs);
        }
        return super.visitObjBody(ctx);
    }

    @Override
    public Object visitPair(HTMLParser.PairContext ctx) {
//    : key CP_CONTENT_COLON collection4everything
        Pair pair = new Pair();

        if (ctx.key() != null){
            pair.setKey((Key) visitKey(ctx.key()));
        }

        if (ctx.collection4everything() != null){
            pair.setCollection4everything((Collection4everything) visitCollection4everything(ctx.collection4everything()));
        }
        return super.visitPair(ctx);
    }

    @Override
    public Object visitKey(HTMLParser.KeyContext ctx) {
//            : CP_CONTENT_IDENTIFIER

        Key key = new Key();

        if (ctx.CP_CONTENT_IDENTIFIER() != null){
            key.setIdentifier(ctx.CP_CONTENT_IDENTIFIER().getSymbol().getText());
        }
        return super.visitKey(ctx);
    }

    @Override
    public Object visitProperty(HTMLParser.PropertyContext ctx) {
//        : (CP_CONTENT_DOT propertyValue)+ (arrayCalling | functionCallFromVar)?

        Property property = new Property();

        ArrayList<PropertyValue> propertyValues = new ArrayList<>();
        if (ctx.propertyValue() != null){
            for (int i=0; i<ctx.propertyValue().size();i++){
                propertyValues.add((PropertyValue) visitPropertyValue(ctx.propertyValue(i)));
            }
            property.setPropertyValues(propertyValues);
        }
//        We have OR --"(arrayCalling | functionCallFromVar)?"--

        if (ctx.arrayCalling() != null){
            property.setArrayCalling((ArrayCalling) visitArrayCalling(ctx.arrayCalling()));
        }
        //OR
        if (ctx.functionCallFromVar() != null){
            property.setFunctionCallFromVar((FunctionCallFromVar) visitFunctionCallFromVar(ctx.functionCallFromVar()));
        }
        return super.visitProperty(ctx);
    }

    @Override
    public Object visitPropertyValue(HTMLParser.PropertyValueContext ctx) {
//        : CP_CONTENT_IDENTIFIER
        PropertyValue propertyValue = new PropertyValue();
        if (ctx.CP_CONTENT_IDENTIFIER() != null){
            propertyValue.setIdentifier(ctx.CP_CONTENT_IDENTIFIER().getSymbol().getText());
        }
        return super.visitPropertyValue(ctx);
    }

    @Override
    public Object visitFunctionCall(HTMLParser.FunctionCallContext ctx) {
//    : functionName functionCallFromVar

        FunctionCall functionCall = new FunctionCall();

        if (ctx.functionName() != null){
            functionCall.setFunctionName((FunctionName) visitFunctionName(ctx.functionName()));
        }

        if (ctx.functionCallFromVar() != null){
            functionCall.setFunctionCallFromVar((FunctionCallFromVar) visitFunctionCallFromVar(ctx.functionCallFromVar()));
        }
        return super.visitFunctionCall(ctx);
    }

    @Override
    public Object visitFunctionCallFromVar(HTMLParser.FunctionCallFromVarContext ctx) {
//    : (CP_CONTENT_OPEN_PAR parameters? CP_CONTENT_CLOSE_PAR)+ (arrayCalling | property)?

        FunctionCallFromVar functionCallFromVar = new FunctionCallFromVar();

        ArrayList<Parameters> parametersArrayList = new ArrayList<>();
        if (ctx.parameters() != null){
            for (int i=0; i< ctx.parameters().size();i++){
                parametersArrayList.add((Parameters) visitParameters(ctx.parameters(i)));
            }
            functionCallFromVar.setParameters(parametersArrayList);
        }
//        We have OR --"(arrayCalling | property)?"--
        if (ctx.arrayCalling() != null){
            functionCallFromVar.setArrayCalling((ArrayCalling) visitArrayCalling(ctx.arrayCalling()));
        }
        // --OR--

        if (ctx.property() != null){
            functionCallFromVar.setProperty((Property) visitProperty(ctx.property()));
        }

        return super.visitFunctionCallFromVar(ctx);
    }

    @Override
    public Object visitFunctionName(HTMLParser.FunctionNameContext ctx) {
//    : CP_CONTENT_IDENTIFIER

        FunctionName functionName = new FunctionName();

        if (ctx.CP_CONTENT_IDENTIFIER() != null){
            functionName.setIdentifier(ctx.CP_CONTENT_IDENTIFIER().getSymbol().getText());
        }
        return super.visitFunctionName(ctx);
    }

    @Override
    public Object visitParameters(HTMLParser.ParametersContext ctx) {
//        : parameter (CP_CONTENT_COMMA parameter)*

        Parameters parameters = new Parameters();

        ArrayList<Parameter> parameterArrayList = new ArrayList<>();
        if (ctx.parameter() != null){
            for (int i=0; i< ctx.parameter().size();i++){
                parameterArrayList.add((Parameter) visitParameter(ctx.parameter(i)));
            }
            parameters.setParameters(parameterArrayList);
        }
        return super.visitParameters(ctx);
    }

    @Override
    public Object visitParameter(HTMLParser.ParameterContext ctx) {
//: collection4everything
        Parameter parameter = new Parameter();
        if (ctx.collection4everything() != null){
            parameter.setCollection4everything((Collection4everything) visitCollection4everything(ctx.collection4everything()));
        }

        return super.visitParameter(ctx);
    }

    @Override
    public Object visitComparisonExpression(HTMLParser.ComparisonExpressionContext ctx) {
//: collection4comparison comparisonOperator collection4comparison

        ComparisonExpression comparisonExpression = new ComparisonExpression();

        /**I use index (0) in parameter of visit for first collection4comparison
         *  because we have same expression
         * And index (1) for next collection4comparison
         * And all of that because we have arrayList of collection4comparison from Parser
        **/

        if (ctx.collection4comparison() != null){
            //index (0)
            comparisonExpression.setCollection4comparison1((Collection4comparison) visitCollection4comparison(ctx.collection4comparison(0)));
            // index(1)
            comparisonExpression.setCollection4comparison2((Collection4comparison) visitCollection4comparison(ctx.collection4comparison(1)));
        }

        if (ctx.comparisonOperator() != null){
            comparisonExpression.setComparisonOperator((ComparisonOperator) visitComparisonOperator(ctx.comparisonOperator()));
        }
        return super.visitComparisonExpression(ctx);
    }

    @Override
    public Object visitOneLineCondition(HTMLParser.OneLineConditionContext ctx) {
//: CP_CONTENT_OPEN_PAR logicComprison CP_CONTENT_QUESTION_MARK collection4everything CP_CONTENT_COLON collection4everything CP_CONTENT_CLOSE_PAR

        OneLineCondition oneLineCondition = new OneLineCondition();
        if (ctx.logicComprison() != null){
            oneLineCondition.setLogicComprison((LogicComprison) visitLogicComprison(ctx.logicComprison()));
        }


        /**I use index (0) in parameter of visit for first collection4everything
         *  because we have same expression
         * And index (1) for next collection4comparison
         * And all of that because we have arrayList of collection4comparison from Parser
         **/
        //index (0)
        //index(1)
        if (ctx.collection4everything() != null){
            oneLineCondition.setCollection4everything1((Collection4everything) visitCollection4everything(ctx.collection4everything(0)));
            oneLineCondition.setCollection4everything2((Collection4everything) visitCollection4everything(ctx.collection4everything(1)));
        }
        return super.visitOneLineCondition(ctx);
    }

    @Override
    public Object visitOneLineBoolCondition(HTMLParser.OneLineBoolConditionContext ctx) {
//: CP_CONTENT_OPEN_PAR logicComprison CP_CONTENT_QUESTION_MARK CP_CONTENT_TRUE CP_CONTENT_COLON CP_CONTENT_FALSE CP_CONTENT_CLOSE_PAR

        OneLineBoolCondition oneLineBoolCondition = new OneLineBoolCondition();

        if (ctx.logicComprison() != null){
            oneLineBoolCondition.setLogicComprison((LogicComprison) visitLogicComprison(ctx.logicComprison()));
        }

        if (ctx.CP_CONTENT_FALSE() != null){
            oneLineBoolCondition.setFalse(false);
        }

        if (ctx.CP_CONTENT_TRUE() != null){
            oneLineBoolCondition.setTrue(true);
        }
        return super.visitOneLineBoolCondition(ctx);
    }

    @Override
    public Object visitOneLineArithCondition(HTMLParser.OneLineArithConditionContext ctx) {
//: CP_CONTENT_OPEN_PAR logicComprison CP_CONTENT_QUESTION_MARK arithmeticLogic CP_CONTENT_COLON arithmeticLogic CP_CONTENT_CLOSE_PAR

        OneLineArithCondition oneLineArithCondition = new OneLineArithCondition();

        if (ctx.logicComprison() != null){
            oneLineArithCondition.setLogicComprison((LogicComprison) visitLogicComprison(ctx.logicComprison()));
        }
        /**I use index (0) in parameter of visit for first arithmeticLogic
         *  because we have same expression
         * And index (1) for next arithmeticLogic
         * And all of that because we have arrayList of arithmeticLogic from Parser
         **/

        // Index (0)
        // index(1)
        if (ctx.arithmeticLogic() != null){
            oneLineArithCondition.setArithmeticLogic1((ArithmeticLogic) visitArithmeticLogic(ctx.arithmeticLogic(0)));
            oneLineArithCondition.setArithmeticLogic2((ArithmeticLogic) visitArithmeticLogic(ctx.arithmeticLogic(1)));
        }
        return super.visitOneLineArithCondition(ctx);
    }

    @Override
    public Object visitComparisonOperator(HTMLParser.ComparisonOperatorContext ctx) {
//          : CP_CONTENT_GREATER_THAN
//                | CP_CONTENT_GREATER_EQ
//                | CP_CONTENT_LESS_THAN
//                | CP_CONTENT_LESS_EQ
//                | CP_CONTENT_EQUAL_TO
//                | CP_CONTENT_NOT_EQUAL

        ComparisonOperator comparisonOperator = new ComparisonOperator();

        //CP_CONTENT_GREATER_THAN
        if (ctx.CP_CONTENT_GREATER_THAN() != null){
            comparisonOperator.setComparisonOperator(ctx.CP_CONTENT_GREATER_THAN().getSymbol().getText());
        }
//        CP_CONTENT_GREATER_EQ
        if (ctx.CP_CONTENT_GREATER_EQ() != null){
            comparisonOperator.setComparisonOperator(ctx.CP_CONTENT_GREATER_EQ().getSymbol().getText());
        }
        //CP_CONTENT_LESS_THAN
        if (ctx.CP_CONTENT_LESS_THAN() != null){
            comparisonOperator.setComparisonOperator(ctx.CP_CONTENT_LESS_THAN().getSymbol().getText());
        }
        //CP_CONTENT_LESS_EQ
        if (ctx.CP_CONTENT_LESS_EQ() != null){
            comparisonOperator.setComparisonOperator(ctx.CP_CONTENT_LESS_EQ().getSymbol().getText());
        }
        //CP_CONTENT_EQUAL_TO
        if (ctx.CP_CONTENT_EQUAL_TO() != null){
            comparisonOperator.setComparisonOperator(ctx.CP_CONTENT_EQUAL_TO().getSymbol().getText());
        }
        //CP_CONTENT_NOT_EQUAL
        if (ctx.CP_CONTENT_NOT_EQUAL() != null){
            comparisonOperator.setComparisonOperator(ctx.CP_CONTENT_NOT_EQUAL().getSymbol().getText());
        }
        return super.visitComparisonOperator(ctx);
    }

    @Override
    public Object visitLogicComprison(HTMLParser.LogicComprisonContext ctx) {
//        : ((CP_CONTENT_NOT)? ((collection4LogicRet) | (CP_CONTENT_OPEN_PAR logicComprison CP_CONTENT_CLOSE_PAR))) /// first
//        middleAndLastLogicComparison*
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
//           : ((CP_CONTENT_AND (CP_CONTENT_NOT)?) | (CP_CONTENT_OR (CP_CONTENT_NOT)?))   /// middle
//        (collection4LogicRet | CP_CONTENT_OPEN_PAR logicComprison CP_CONTENT_CLOSE_PAR)

        MiddleAndLastLogicComparison middleAndLastLogicComparison = new MiddleAndLastLogicComparison();
        //First OR between ----- && or || -----

        //Only && (&&)
        if (ctx.CP_CONTENT_AND() != null){
            middleAndLastLogicComparison.setAndMiddle(ctx.CP_CONTENT_AND().getSymbol().getText());
            if (ctx.CP_CONTENT_NOT() != null){
                middleAndLastLogicComparison.setNotAndMiddle(ctx.CP_CONTENT_NOT().getSymbol().getText());
            }
        }
        // OR

        //Only || (||)
        if (ctx.CP_CONTENT_OR() != null){
            middleAndLastLogicComparison.setAndMiddle(ctx.CP_CONTENT_OR().getSymbol().getText());
            if (ctx.CP_CONTENT_NOT() != null){
                middleAndLastLogicComparison.setNotOrMiddle(ctx.CP_CONTENT_NOT().getSymbol().getText());
            }
        }

        //Second OR between ----- collection4LogicRet or CP_CONTENT_OPEN_PAR logicComprison CP_CONTENT_CLOSE_PAR -----

        if (ctx.collection4LogicRet() != null){
            middleAndLastLogicComparison.setCollection4LogicRet((Collection4LogicRet) visitCollection4LogicRet(ctx.collection4LogicRet()));
        }

        // OR

        if (ctx.logicComprison() != null){
            middleAndLastLogicComparison.setLogicComprisonLast((LogicComprison) visitLogicComprison(ctx.logicComprison()));
        }

        return super.visitMiddleAndLastLogicComparison(ctx);
    }
    @Override
    public Object visitArithmeticLogic(HTMLParser.ArithmeticLogicContext ctx) {
//: (collection4Arithmetic | CP_CONTENT_OPEN_PAR arithmeticLogic CP_CONTENT_CLOSE_PAR) lastArithmeticLogic*

        ArithmeticLogic arithmeticLogic = new ArithmeticLogic();

        //First OR  between ----"collection4Arithmetic" and "arithmeticLogic"----

        if (ctx.collection4Arithmetic() != null){
            arithmeticLogic.setCollection4Arithmetic((Collection4Arithmetic) visitCollection4Arithmetic(ctx.collection4Arithmetic()));
        }
        // OR

        if (ctx.arithmeticLogic() != null){
            arithmeticLogic.setArithmeticLogic((ArithmeticLogic) visitArithmeticLogic(ctx.arithmeticLogic()));
        }

        ArrayList<LastArithmeticLogic> lastArithmeticLogicArrayList = new ArrayList<>();
        if (ctx.lastArithmeticLogic() != null){
            for (int i=0; i< ctx.lastArithmeticLogic().size();i++){
                lastArithmeticLogicArrayList.add((LastArithmeticLogic) visitLastArithmeticLogic(ctx.lastArithmeticLogic(i)));
            }
            arithmeticLogic.setLastArithmeticLogic(lastArithmeticLogicArrayList);
        }
        return super.visitArithmeticLogic(ctx);
    }
    @Override
    public Object visitLastArithmeticLogic(HTMLParser.LastArithmeticLogicContext ctx) {
//: CP_CONTENT_ARITHMETIC (collection4Arithmetic | CP_CONTENT_OPEN_PAR arithmeticLogic CP_CONTENT_CLOSE_PAR)

        LastArithmeticLogic lastArithmeticLogic = new LastArithmeticLogic();

        if (ctx.CP_CONTENT_ARITHMETIC() != null){
            lastArithmeticLogic.setArithmetic(ctx.CP_CONTENT_ARITHMETIC().getSymbol().getText());
        }

        // First OR between -----"collection4Arithmetic"  OR "arithmeticLogic"-----
        if (ctx.collection4Arithmetic() != null){
            lastArithmeticLogic.setCollection4Arithmetic((Collection4Arithmetic) visitCollection4Arithmetic(ctx.collection4Arithmetic()));
        }
        // OR

        if (ctx.arithmeticLogic() != null){
            lastArithmeticLogic.setArithmeticLogic((ArithmeticLogic) visitArithmeticLogic(ctx.arithmeticLogic()));
        }
        return super.visitLastArithmeticLogic(ctx);
    }
    @Override
    public Object visitValue(HTMLParser.ValueContext ctx) {
//        : CP_CONTENT_STRING
//                | number
//                | trueOrFalse
//                | CP_CONTENT_NULL

        Value value = new Value();

        if (ctx.CP_CONTENT_STRING() != null){
            value.setString(ctx.CP_CONTENT_STRING().getSymbol().getText());
        }
        if (ctx.CP_CONTENT_NULL() != null){
            value.setNull(null);
        }


        if (ctx.number() != null){
            value.setNumber((NUmber) visitNumber(ctx.number()));
        }
        if (ctx.trueOrFalse() != null){
            value.setTrueOrFalse((TrueOrFalse) visitTrueOrFalse(ctx.trueOrFalse()));
        }
        return super.visitValue(ctx);
    }

    @Override
    public Object visitCollection4everything(HTMLParser.Collection4everythingContext ctx) {
//         : variable
//                | value
//                | array
//                | objArray
//                | functionCall
//                | subObj
//                | oneLineCondition
//                | comparisonExpression
//                | logicComprison
//                | arithmeticLogic

        Collection4everything collection4everything = new Collection4everything();

        //variable
        if (ctx.variable()  != null){
            collection4everything.setVariable((Variable) visitVariable(ctx.variable()));
        }
        //value
        if (ctx.value()  != null){
            collection4everything.setValue((Value) visitValue(ctx.value()));
        }
        //array
        if (ctx.array()  != null){
            collection4everything.setArray((Array) visitArray(ctx.array()));
        }
        //objArray
        if (ctx.objArray()  != null){
            collection4everything.setObjArray((ObjArray) visitObjArray(ctx.objArray()));
        }
        //functionCall
        if (ctx.functionCall()  != null){
            collection4everything.setFunctionCall((FunctionCall) visitFunctionCall(ctx.functionCall()));
        }
        //subObj
        if (ctx.subObj()  != null){
            collection4everything.setSubObj((SubObj) visitSubObj(ctx.subObj()));
        }
        //oneLineCondition
        if (ctx.oneLineCondition()  != null){
            collection4everything.setOneLineCondition((OneLineCondition) visitOneLineCondition(ctx.oneLineCondition()));
        }
        //comparisonExpression
        if (ctx.comparisonExpression()  != null){
            collection4everything.setComparisonExpression((ComparisonExpression) visitComparisonExpression(ctx.comparisonExpression()));
        }
        //logicComprison
        if (ctx.logicComprison()  != null){
            collection4everything.setLogicComprison((LogicComprison) visitLogicComprison(ctx.logicComprison()));
        }
        //arithmeticLogic
        if (ctx.arithmeticLogic()  != null){
            collection4everything.setArithmeticLogic((ArithmeticLogic) visitArithmeticLogic(ctx.arithmeticLogic()));
        }
        return super.visitCollection4everything(ctx);
    }

    @Override
    public Object visitCollection4comparison(HTMLParser.Collection4comparisonContext ctx) {
//            : arithmeticLogic

        Collection4comparison collection4comparison = new Collection4comparison();
        if (ctx.arithmeticLogic() != null){
            collection4comparison.setArithmeticLogic((ArithmeticLogic) visitArithmeticLogic(ctx.arithmeticLogic()));
        }

        return super.visitCollection4comparison(ctx);
    }

    @Override
    public Object visitCollection4Arithmetic(HTMLParser.Collection4ArithmeticContext ctx) {
//         : variable
//                | number
//                | objArray
//                | functionCall
//                | subObj
//                | oneLineArithCondition

        Collection4Arithmetic collection4Arithmetic = new Collection4Arithmetic();

        //variable
        if (ctx.variable()  != null){
            collection4Arithmetic.setVariable((Variable) visitVariable(ctx.variable()));
        }
        //number
        if (ctx.number()  != null){
            collection4Arithmetic.setNumber((NUmber) visitNumber(ctx.number()));
        }
        //objArray
        if (ctx.objArray()  != null){
            collection4Arithmetic.setObjArray((ObjArray) visitObjArray(ctx.objArray()));
        }
        //functionCall
        if (ctx.functionCall()  != null){
            collection4Arithmetic.setFunctionCall((FunctionCall) visitFunctionCall(ctx.functionCall()));
        }
        //subObj
        if (ctx.subObj()  != null){
            collection4Arithmetic.setSubObj((SubObj) visitSubObj(ctx.subObj()));
        }
        //oneLineArithCondition
        if (ctx.oneLineArithCondition()  != null){
            collection4Arithmetic.setOneLineArithCondition((OneLineArithCondition) visitOneLineArithCondition(ctx.oneLineArithCondition()));
        }
        return super.visitCollection4Arithmetic(ctx);
    }

    @Override
    public Object visitCollection4LogicRet(HTMLParser.Collection4LogicRetContext ctx) {
//        : variable
//                | trueOrFalse
//                | objArray
//                | functionCall
//                | subObj
//                | comparisonExpression
//                | oneLineBoolCondition

        Collection4LogicRet collection4LogicRet = new Collection4LogicRet();

        //variable
        if (ctx.variable()  != null){
            collection4LogicRet.setVariable((Variable) visitVariable(ctx.variable()));
        }
        //trueOrFalse
        if (ctx.trueOrFalse()  != null){
            collection4LogicRet.setTrueOrFalse((TrueOrFalse) visitTrueOrFalse(ctx.trueOrFalse()));
        }
        //objArray
        if (ctx.objArray()  != null){
            collection4LogicRet.setObjArray((ObjArray) visitObjArray(ctx.objArray()));
        }
        //functionCall
        if (ctx.functionCall()  != null){
            collection4LogicRet.setFunctionCall((FunctionCall) visitFunctionCall(ctx.functionCall()));
        }
        //subObj
        if (ctx.subObj()  != null){
            collection4LogicRet.setSubObj((SubObj) visitSubObj(ctx.subObj()));
        }
        //comparisonExpression
        if (ctx.comparisonExpression()  != null){
            collection4LogicRet.setComparisonExpression((ComparisonExpression) visitComparisonExpression(ctx.comparisonExpression()));
        }
        //oneLineBoolCondition
        if (ctx.oneLineBoolCondition()  != null){
            collection4LogicRet.setOneLineBoolCondition((OneLineBoolCondition) visitOneLineBoolCondition(ctx.oneLineBoolCondition()));
        }
        return super.visitCollection4LogicRet(ctx);
    }


    //////////////////////////////////////////////////










    ///////////////////////// NOOR /////////////////////////
    @Override
    public Object visitMustacheExpression(HTMLParser.MustacheExpressionContext ctx) {
        MustacheExpression mustacheExpression = new MustacheExpression();

        if (ctx.collection4Mustache() != null){
            mustacheExpression.setCollection4Mustache((Collection4Mustache) visitCollection4Mustache(ctx.collection4Mustache()));
        }

        if (ctx.filter() != null){
            mustacheExpression.setFilter((Filter) visitFilter(ctx.filter()));
        }
        return super.visitMustacheExpression(ctx);
    }
    @Override
    public Object visitCollection4Mustache(HTMLParser.Collection4MustacheContext ctx) {
        Collection4Mustache collection4Mustache = new Collection4Mustache();

        if (ctx.mustacheVariable() != null){
            collection4Mustache.setMustacheVariable((MustacheVariable) visitMustacheVariable(ctx.mustacheVariable()));
        }
        if (ctx.mustacheValue() != null){
            collection4Mustache.setMustacheValue((MustacheValue) visitMustacheValue(ctx.mustacheValue()));
        }

        if (ctx.objArray4Must() != null){
            collection4Mustache.setObjArray4Must((ObjArray4Must) visitObjArray4Must(ctx.objArray4Must()));
        }

        if (ctx.functionCall4Must() != null){
            collection4Mustache.setFunctionCall4Must((FunctionCall4Must) visitFunctionCall4Must(ctx.functionCall4Must()));
        }

        if (ctx.subObj4Must() != null){
            collection4Mustache.setSubObj4Must((SubObj4Must) visitSubObj4Must(ctx.subObj4Must()));
        }

        if (ctx.oneLineCondition4Must() != null){
            collection4Mustache.setOneLineCondition4Must((OneLineCondition4Must) visitOneLineCondition4Must(ctx.oneLineCondition4Must()));
        }

        if (ctx.oneLineArithCondition4Must() != null){
            collection4Mustache.setOneLineArithCondithion4Must((OneLineArithCondition4Must) visitOneLineArithCondition4Must(ctx.oneLineArithCondition4Must()));
        }

        if (ctx.arithmeticLogic4Must() != null){
            collection4Mustache.setArithmeticLogic4Must((ArithmeticLogic4Must) visitArithmeticLogic4Must(ctx.arithmeticLogic4Must()));
        }

        return super.visitCollection4Mustache(ctx);
    }

    @Override
    public Object visitCollection4LogicRet4Must(HTMLParser.Collection4LogicRet4MustContext ctx) {
        Collection4LogicRet4Must collection4LogicRet4Must = new Collection4LogicRet4Must();

        if (ctx.mustacheVariable() != null){
            collection4LogicRet4Must.setMustacheVariable((MustacheVariable) visitMustacheVariable(ctx.mustacheVariable()));
        }

        if (ctx.MUSTACHE_TRUE() != null){
            collection4LogicRet4Must.setMustacheTrue(true);
        }
        if (ctx.MUSTACHE_FALSE() != null){
            collection4LogicRet4Must.setMustacheFalse(false);
        }

        if (ctx.objArray4Must() != null){
            collection4LogicRet4Must.setObjArray4Must((ObjArray4Must) visitObjArray4Must(ctx.objArray4Must()));
        }

        if (ctx.functionCall4Must() != null){
            collection4LogicRet4Must.setFunctionCall4Must((FunctionCall4Must) visitFunctionCall4Must(ctx.functionCall4Must()));
        }

        if (ctx.subObj4Must() != null){
            collection4LogicRet4Must.setSubObj4Must((SubObj4Must) visitSubObj4Must(ctx.subObj4Must()));
        }

        if (ctx.comparisonExp4Must() != null){
            collection4LogicRet4Must.setComparisonExp4Must((ComparisonExp4Must) visitComparisonExp4Must(ctx.comparisonExp4Must()));
        }

        if (ctx.oneLineBoolCondition4Must() != null){
            collection4LogicRet4Must.setOneLineBoolCondition4Must((OneLineBoolCondition4Must) visitOneLineBoolCondition4Must(ctx.oneLineBoolCondition4Must()));
        }
        return super.visitCollection4LogicRet4Must(ctx);
    }

    @Override
    public Object visitCollection4CompMust(HTMLParser.Collection4CompMustContext ctx) {
        Collection4CompMust collection4CompMust = new Collection4CompMust();

        if (ctx.arithmeticLogic4Must() != null){
            collection4CompMust.setArithmeticLogic4Must((ArithmeticLogic4Must) visitArithmeticLogic4Must(ctx.arithmeticLogic4Must()));
        }

        return super.visitCollection4CompMust(ctx);
    }

    @Override
    public Object visitCollection4MUSTArithmetic(HTMLParser.Collection4MUSTArithmeticContext ctx) {
        Collection4MUSTArithmetic collection4MUSTArithmetic = new Collection4MUSTArithmetic();

        if (ctx.mustacheVariable() != null){
            collection4MUSTArithmetic.setMustacheVariable((MustacheVariable) visitMustacheVariable(ctx.mustacheVariable()));
        }

        if (ctx.mustacheNumber() != null){
            collection4MUSTArithmetic.setMustacheNumber((MustacheNumber) visitMustacheNumber(ctx.mustacheNumber()));
        }

        if (ctx.objArray4Must() != null){
            collection4MUSTArithmetic.setObjArray4Must((ObjArray4Must) visitObjArray4Must(ctx.objArray4Must()));
        }

        if (ctx.functionCall4Must() != null){
            collection4MUSTArithmetic.setFunctionCall4Must((FunctionCall4Must) visitFunctionCall4Must(ctx.functionCall4Must()));
        }

        if (ctx.subObj4Must() != null){
            collection4MUSTArithmetic.setSubObj4Must((SubObj4Must) visitSubObj4Must(ctx.subObj4Must()));
        }

        if (ctx.oneLineArithCondition4Must() != null){
            collection4MUSTArithmetic.setOneLineArithCondithion4Must1((OneLineArithCondition4Must) visitOneLineArithCondition4Must(ctx.oneLineArithCondition4Must()));
        }
        return super.visitCollection4MUSTArithmetic(ctx);
    }

    @Override
    public Object visitLogicComprison4Must(HTMLParser.LogicComprison4MustContext ctx) {
        LogicComprison4Must logicComprison4Must = new LogicComprison4Must();
        // !
        if (ctx.MUSTACHE_NOT() != null){
            logicComprison4Must.setNotFirst(ctx.MUSTACHE_NOT().getSymbol().getText());
        }
        // this
        if (ctx.collection4LogicRet4Must() != null){
            logicComprison4Must.setCollection4LogicRetFirst((Collection4LogicRet4Must) visitCollection4LogicRet4Must(ctx.collection4LogicRet4Must()));
        }
        // or this
        if (ctx.logicComprison4Must() != null){
            logicComprison4Must.setLogicComprisonFirst((LogicComprison4Must) visitLogicComprison4Must(ctx.logicComprison4Must()));
        }
        // middle and last
        List<MiddleAndLastLogicComparison4Must> middleAndLastLogicComparison4Musts = new ArrayList<>();
        if (ctx.middleAndLastLogicComparison4Must() != null){
            for (int i = 0 ; i < ctx.middleAndLastLogicComparison4Must().size() ; i ++){
                middleAndLastLogicComparison4Musts.add((MiddleAndLastLogicComparison4Must) visitMiddleAndLastLogicComparison4Must(ctx.middleAndLastLogicComparison4Must(i)));
            }
            logicComprison4Must.setMiddleAndLastLogicComparisons(middleAndLastLogicComparison4Musts);
        }
        return super.visitLogicComprison4Must(ctx);
    }

    @Override
    public Object visitMiddleAndLastLogicComparison4Must(HTMLParser.MiddleAndLastLogicComparison4MustContext ctx) {
        MiddleAndLastLogicComparison4Must middleAndLastLogicComparison4Must = new MiddleAndLastLogicComparison4Must();
        //middle
        //this AND NOT?
        if (ctx.MUSTACHE_AND() != null){
            middleAndLastLogicComparison4Must.setAndMiddle(ctx.MUSTACHE_AND().getSymbol().getText());
            if (ctx.MUSTACHE_NOT() != null){
                middleAndLastLogicComparison4Must.setNotAndMiddle(ctx.MUSTACHE_NOT().getSymbol().getText());
            }
        }
        // or this OR NOT?
        if (ctx.MUSTACHE_OR() != null){
            middleAndLastLogicComparison4Must.setOrMiddle(ctx.MUSTACHE_OR().getSymbol().getText());
            if (ctx.MUSTACHE_NOT() != null){
                middleAndLastLogicComparison4Must.setNotOrMiddle(ctx.MUSTACHE_NOT().getSymbol().getText());
            }
        }

        //last
        //this collection4LogicRet4Must
        if (ctx.collection4LogicRet4Must()!= null){
            middleAndLastLogicComparison4Must.setCollection4LogicRet((Collection4LogicRet4Must) visitCollection4LogicRet4Must(ctx.collection4LogicRet4Must()));
        }
        // or logicComprison4Must
        if (ctx.logicComprison4Must() != null){
            middleAndLastLogicComparison4Must.setLogicComprisonLast((LogicComprison4Must) visitLogicComprison4Must(ctx.logicComprison4Must()));
        }
        return super.visitMiddleAndLastLogicComparison4Must(ctx);
    }

    @Override
    public Object visitArithmeticLogic4Must(HTMLParser.ArithmeticLogic4MustContext ctx) {
        ArithmeticLogic4Must arithmeticLogic4Must = new ArithmeticLogic4Must();

        //this collection4MUSTArithmetic
        if (ctx.collection4MUSTArithmetic() != null){
            arithmeticLogic4Must.setCollection4Arithmetic((Collection4MUSTArithmetic) visitCollection4MUSTArithmetic(ctx.collection4MUSTArithmetic()));
        }

        // or arithmeticLogic4Must
        if (ctx.arithmeticLogic4Must() != null){
            arithmeticLogic4Must.setArithmeticLogic((ArithmeticLogic4Must) visitArithmeticLogic4Must(ctx.arithmeticLogic4Must()));
        }

        List<LastArithmeticLogic4Must> lastArithmeticLogic4Musts = new ArrayList<>();
        if (ctx.lastArithmeticLogic4Must() != null) {
            for (int i = 0; i < ctx.lastArithmeticLogic4Must().size(); i++) {
                lastArithmeticLogic4Musts.add((LastArithmeticLogic4Must) visitLastArithmeticLogic4Must(ctx.lastArithmeticLogic4Must(i)));
            }
            arithmeticLogic4Must.setLastArithmeticLogic(lastArithmeticLogic4Musts);
        }
        return super.visitArithmeticLogic4Must(ctx);
    }

    @Override
    public Object visitLastArithmeticLogic4Must(HTMLParser.LastArithmeticLogic4MustContext ctx) {
        LastArithmeticLogic4Must lastArithmeticLogic4Must = new LastArithmeticLogic4Must();

        if (ctx.MUSTACHE_ARITHMETIC() != null){
            lastArithmeticLogic4Must.setArithmetic(ctx.MUSTACHE_ARITHMETIC().getSymbol().getText());
        }
        //this
        if (ctx.collection4MUSTArithmetic() != null){
            lastArithmeticLogic4Must.setCollection4MUSTArithmetic((Collection4MUSTArithmetic) visitCollection4MUSTArithmetic(ctx.collection4MUSTArithmetic()));
        }
        //or
        if (ctx.arithmeticLogic4Must() != null){
            lastArithmeticLogic4Must.setArithmeticLogic((ArithmeticLogic4Must) visitArithmeticLogic4Must(ctx.arithmeticLogic4Must()));
        }

        return super.visitLastArithmeticLogic4Must(ctx);
    }
    @Override
    public Object visitMustacheVariable(HTMLParser.MustacheVariableContext ctx) {
        MustacheVariable mustacheVariable = new MustacheVariable();
        if (ctx.MUSTACHE_IDENTIFIER() != null){
            mustacheVariable.setMustacheVariable(ctx.MUSTACHE_IDENTIFIER().getSymbol().getText());
        }
        return super.visitMustacheVariable(ctx);
    }

    @Override
    public Object visitMustacheNumber(HTMLParser.MustacheNumberContext ctx) {
        MustacheNumber mustacheNumber = new MustacheNumber();
        if (ctx.MUSTACHE_NUMBER() != null){
            // TODO i don't know if this is right or not
            double numberType = Double.valueOf(ctx.MUSTACHE_NUMBER().getSymbol().getText());
            // For check what's the type of Number
            if (numberType == (int) numberType) {
                mustacheNumber.setNumber(Integer.parseInt(ctx.MUSTACHE_NUMBER().getSymbol().getText()));
            }
            else if (numberType == (float)numberType){
                mustacheNumber.setNumber(Float.parseFloat(ctx
                        .MUSTACHE_NUMBER().getSymbol().getText()));
            }
            else{
                mustacheNumber.setNumber(Double.parseDouble(ctx.MUSTACHE_NUMBER().getSymbol().getText()));
            }
        }

        return super.visitMustacheNumber(ctx);
    }

    @Override
    public Object visitMustacheValue(HTMLParser.MustacheValueContext ctx) {
        MustacheValue mustacheValue = new MustacheValue();

        if (ctx.mustacheNumber() != null){
            mustacheValue.setMustacheNumber((MustacheNumber) visitMustacheNumber(ctx.mustacheNumber()));
        }

        if (ctx.MUSTACHE_STRING() != null){
            mustacheValue.setMustacheString(ctx.MUSTACHE_STRING().getSymbol().getText());
        }

        if (ctx.MUSTACHE_TRUE() != null){
            mustacheValue.setMustacheTrue(true);
        }

        if (ctx.MUSTACHE_FALSE() != null){
            mustacheValue.setMustacheFalse(false);
        }

        if (ctx.MUSTACHE_NULL() != null){
            mustacheValue.setMUSTACHE_NULL(null);
        }

        return super.visitMustacheValue(ctx);
    }

    @Override
    public Object visitObjArray4Must(HTMLParser.ObjArray4MustContext ctx) {
        ObjArray4Must objArray4Must = new ObjArray4Must();

        if (ctx.arrName4Must() != null){
            objArray4Must.setArrName4Must1((ArrName4Must) visitArrName4Must(ctx.arrName4Must()));
        }

        if (ctx.arrayCalling4Must() != null){
            objArray4Must.setArrayCalling4Must((ArrayCalling4Must) visitArrayCalling4Must(ctx.arrayCalling4Must()));
        }
        return super.visitObjArray4Must(ctx);
    }

    @Override
    public Object visitArrName4Must(HTMLParser.ArrName4MustContext ctx) {
        ArrName4Must arrName4Must = new ArrName4Must();
        if (ctx.MUSTACHE_IDENTIFIER() != null){
            arrName4Must.setArrName4Must(ctx.MUSTACHE_IDENTIFIER().getSymbol().getText());
        }
        return super.visitArrName4Must(ctx);
    }

    @Override
    public Object visitArrayCalling4Must(HTMLParser.ArrayCalling4MustContext ctx) {
        ArrayCalling4Must arrayCalling4Must = new ArrayCalling4Must();

        List<ArithmeticLogic4Must> arithmeticLogic4Musts = new ArrayList<>();
        if (ctx.arithmeticLogic4Must() != null){
            for (int i = 0 ; i < ctx.arithmeticLogic4Must().size() ; i ++){
                arithmeticLogic4Musts.add((ArithmeticLogic4Must) visitArithmeticLogic4Must(ctx.arithmeticLogic4Must(i)));
            }
            arrayCalling4Must.setArithmeticLogic4Must(arithmeticLogic4Musts);
        }

        if (ctx.functionCallFromVar4Must() != null){
            arrayCalling4Must.setFunctionCallFromVar4Must((FunctionCallFromVar4Must) visitFunctionCallFromVar4Must(ctx.functionCallFromVar4Must()));
        }

        if (ctx.property4Must() != null){
            arrayCalling4Must.setProperty4Must((Property4Must) visitProperty4Must(ctx.property4Must()));
        }
        return super.visitArrayCalling4Must(ctx);
    }

    @Override
    public Object visitFunctionCall4Must(HTMLParser.FunctionCall4MustContext ctx) {
        FunctionCall4Must functionCall4Must = new FunctionCall4Must();

        if (ctx.functionName4Must() != null){
            functionCall4Must.setFunctionName4Must1((FunctionName4Must) visitFunctionName4Must(ctx.functionName4Must()));
        }

        if (ctx.functionCallFromVar4Must() != null){
            functionCall4Must.setFunctionCallFromVar4Must((FunctionCallFromVar4Must) visitFunctionCallFromVar4Must(ctx.functionCallFromVar4Must()));
        }

        return super.visitFunctionCall4Must(ctx);
    }

    @Override
    public Object visitFunctionCallFromVar4Must(HTMLParser.FunctionCallFromVar4MustContext ctx) {
        FunctionCallFromVar4Must functionCallFromVar4Must = new FunctionCallFromVar4Must();

        List<Parameters4Must> parameters4Musts = new ArrayList<>();
        if (ctx.parameters4Must() != null){
            for (int i = 0 ; i < ctx.parameters4Must().size() ; i ++){
                parameters4Musts.add((Parameters4Must) visitParameters4Must(ctx.parameters4Must(i)));
            }
            functionCallFromVar4Must.setParameters4Must(parameters4Musts);
        }

        if (ctx.arrayCalling4Must() != null){
            functionCallFromVar4Must.setArrayCalling4Must((ArrayCalling4Must) visitArrayCalling4Must(ctx.arrayCalling4Must()));
        }

        if (ctx.property4Must() != null){
            functionCallFromVar4Must.setProperty4Must((Property4Must) visitProperty4Must(ctx.property4Must()));
        }

        return super.visitFunctionCallFromVar4Must(ctx);
    }

    @Override
    public Object visitFunctionName4Must(HTMLParser.FunctionName4MustContext ctx) {
        FunctionName4Must functionName4Must = new FunctionName4Must();
        if (ctx.MUSTACHE_IDENTIFIER() != null){
            functionName4Must.setFunctionName4Must(ctx.MUSTACHE_IDENTIFIER().getSymbol().getText());
        }
        return super.visitFunctionName4Must(ctx);
    }

    @Override
    public Object visitParameters4Must(HTMLParser.Parameters4MustContext ctx) {
        Parameters4Must parameters4Must = new Parameters4Must();

        List<Parameter4Must> parameter4Musts = new ArrayList<>();
        if (ctx.parameter4Must() != null){
            for (int i = 0 ; i < ctx.parameter4Must().size() ; i ++){
                parameter4Musts.add((Parameter4Must) visitParameter4Must(ctx.parameter4Must(i)));
            }
            parameters4Must.setParameters4Musts(parameter4Musts);
        }
        return super.visitParameters4Must(ctx);
    }

    @Override
    public Object visitParameter4Must(HTMLParser.Parameter4MustContext ctx) {
        Parameter4Must parameter4Must = new Parameter4Must();

        if (ctx.collection4Mustache() != null){
            parameter4Must.setCollection4Mustache((Collection4Mustache) visitCollection4Mustache(ctx.collection4Mustache()));
        }

        return super.visitParameter4Must(ctx);
    }

    @Override
    public Object visitSubObj4Must(HTMLParser.SubObj4MustContext ctx) {
        SubObj4Must subObj4Must = new SubObj4Must();

        if (ctx.MUSTACHE_IDENTIFIER() != null){
            subObj4Must.setSubObj4MustName(ctx.MUSTACHE_IDENTIFIER().getSymbol().getText());
        }

        if (ctx.property4Must() != null){
            subObj4Must.setProperty4Must((Property4Must) visitProperty4Must(ctx.property4Must()));
        }
        return super.visitSubObj4Must(ctx);
    }

    @Override
    public Object visitProperty4Must(HTMLParser.Property4MustContext ctx) {
        Property4Must property4Must = new Property4Must();

        List<PropertyValue4Must> propertyValue4Musts = new ArrayList<>();
        if (ctx.propertyValue4Must() != null){
            for (int i = 0 ; i < ctx.propertyValue4Must().size() ; i ++){
                propertyValue4Musts.add((PropertyValue4Must) visitPropertyValue4Must(ctx.propertyValue4Must(i)));
            }
            property4Must.setPropertyValue4Must(propertyValue4Musts);
        }

        if (ctx.arrayCalling4Must() != null){
            property4Must.setArrayCalling4Must((ArrayCalling4Must) visitArrayCalling4Must(ctx.arrayCalling4Must()));
        }

        if (ctx.functionCallFromVar4Must() != null){
            property4Must.setFunctionCallFromVar4Must((FunctionCallFromVar4Must) visitFunctionCallFromVar4Must(ctx.functionCallFromVar4Must()));
        }
        return super.visitProperty4Must(ctx);
    }

    @Override
    public Object visitPropertyValue4Must(HTMLParser.PropertyValue4MustContext ctx) {
        PropertyValue4Must propertyValue4Must = new PropertyValue4Must();

        if (ctx.MUSTACHE_IDENTIFIER() != null){
            propertyValue4Must.setPropertyValue4Must(ctx.MUSTACHE_IDENTIFIER().getSymbol().getText());
        }
        return super.visitPropertyValue4Must(ctx);
    }

    @Override
    public Object visitOneLineCondition4Must(HTMLParser.OneLineCondition4MustContext ctx) {
        OneLineCondition4Must oneLineCondition4Must = new OneLineCondition4Must();

        if (ctx.logicComprison4Must() != null){
            oneLineCondition4Must.setLogicComprison4Must((LogicComprison4Must) visitLogicComprison4Must(ctx.logicComprison4Must()));
        }

        if (ctx.collection4Mustache() != null){
            oneLineCondition4Must.setCollection4Mustache1((Collection4Mustache) visitCollection4Mustache(ctx.collection4Mustache(0)));
            oneLineCondition4Must.setCollection4Mustache2((Collection4Mustache) visitCollection4Mustache(ctx.collection4Mustache(1)));
        }

        return super.visitOneLineCondition4Must(ctx);
    }

    @Override
    public Object visitOneLineArithCondition4Must(HTMLParser.OneLineArithCondition4MustContext ctx) {
        OneLineArithCondition4Must oneLineArithCondition4Must = new OneLineArithCondition4Must();

        if (ctx.logicComprison4Must() != null){
            oneLineArithCondition4Must.setLogicComprison4Must((LogicComprison4Must) visitLogicComprison4Must(ctx.logicComprison4Must()));
        }

        if (ctx.arithmeticLogic4Must() != null){
            oneLineArithCondition4Must.setArithmeticLogic4Must1((ArithmeticLogic4Must) visitArithmeticLogic4Must(ctx.arithmeticLogic4Must(0)));
            oneLineArithCondition4Must.setArithmeticLogic4Must2((ArithmeticLogic4Must) visitArithmeticLogic4Must(ctx.arithmeticLogic4Must(1)));
        }
        return super.visitOneLineArithCondition4Must(ctx);
    }

    @Override
    public Object visitOneLineBoolCondition4Must(HTMLParser.OneLineBoolCondition4MustContext ctx) {
        OneLineBoolCondition4Must oneLineBoolCondition4Must = new OneLineBoolCondition4Must();

        if (ctx.logicComprison4Must() != null){
            oneLineBoolCondition4Must.setLogicComprison4Must((LogicComprison4Must) visitLogicComprison4Must(ctx.logicComprison4Must()));
        }

        if (ctx.MUSTACHE_TRUE() != null){
            oneLineBoolCondition4Must.setTrue(true);
        }
        if (ctx.MUSTACHE_FALSE() != null){
            oneLineBoolCondition4Must.setFalse(false);
        }
        return super.visitOneLineBoolCondition4Must(ctx);
    }

    @Override
    public Object visitComparisonExp4Must(HTMLParser.ComparisonExp4MustContext ctx) {
        ComparisonExp4Must comparisonExp4Must = new ComparisonExp4Must();

        if (ctx.collection4CompMust() != null){
            comparisonExp4Must.setCollection4CompMust((Collection4CompMust) visitCollection4CompMust(ctx.collection4CompMust(0)));
            comparisonExp4Must.setCollection4CompMust2((Collection4CompMust) visitCollection4CompMust(ctx.collection4CompMust(1)));
        }

        if (ctx.mustacheComparisonOperator() != null){
            comparisonExp4Must.setMustacheComparisonOperator((MustacheComparisonOperator) visitMustacheComparisonOperator(ctx.mustacheComparisonOperator()));
        }
        return super.visitComparisonExp4Must(ctx);
    }

    @Override
    public Object visitMustacheComparisonOperator(HTMLParser.MustacheComparisonOperatorContext ctx) {
        MustacheComparisonOperator mustacheComparisonOperator = new MustacheComparisonOperator();

        if (ctx.MUSTACHE_GREATER_THAN() != null){

            mustacheComparisonOperator.setOperator(ctx.MUSTACHE_GREATER_THAN().getSymbol().getText());
        }

        if (ctx.MUSTACHE_GREATER_EQ() != null){

            mustacheComparisonOperator.setOperator(ctx.MUSTACHE_GREATER_EQ().getSymbol().getText());
        }



        if (ctx.MUSTACHE_LESS_THAN() != null){

            mustacheComparisonOperator.setOperator(ctx.MUSTACHE_LESS_THAN().getSymbol().getText());
        }


        if (ctx.MUSTACHE_LESS_EQ() != null){

            mustacheComparisonOperator.setOperator(ctx.MUSTACHE_LESS_EQ().getSymbol().getText());
        }


        if (ctx.MUSTACHE_EQUAL_TO() != null){

            mustacheComparisonOperator.setOperator(ctx.MUSTACHE_EQUAL_TO().getSymbol().getText());
        }
        if (ctx.MUSTACHE_NOT_EQUAL() != null){

            mustacheComparisonOperator.setOperator(ctx.MUSTACHE_NOT_EQUAL().getSymbol().getText());
        }

        return super.visitMustacheComparisonOperator(ctx);
    }

    @Override
    public Object visitFilter(HTMLParser.FilterContext ctx) {
        Filter filter = new Filter();

        if (ctx.modelName() != null){
            filter.setModelName((ModelName) visitModelName(ctx.modelName()));
        }

        if (ctx.MUSTACHE_FILTER() != null){
            filter.setFilter(ctx.MUSTACHE_FILTER().getSymbol().getText());
        }

        if (ctx.formatName() != null){
            filter.setFormatName((FormatName) visitFormatName(ctx.formatName()));
        }

        if (ctx.collection4Mustache() != null){
            filter.setCollection4Mustache((Collection4Mustache) visitCollection4Mustache(ctx.collection4Mustache()));
        }
        return super.visitFilter(ctx);
    }

    @Override
    public Object visitModelName(HTMLParser.ModelNameContext ctx) {
        ModelName modelName = new ModelName();
        if (ctx.MUSTACHE_IDENTIFIER() != null){
            modelName.setMustachIdentifier(ctx.MUSTACHE_IDENTIFIER().getSymbol().getText());
        }
        return super.visitModelName(ctx);
    }

    @Override
    public Object visitFormatName(HTMLParser.FormatNameContext ctx) {
        FormatName formatName = new FormatName();
        if (ctx.MUSTACHE_IDENTIFIER() != null){
            formatName.setMustachIdentifier(ctx.MUSTACHE_IDENTIFIER().getSymbol().getText());
        }
        return super.visitFormatName(ctx);
    }

    @Override
    public Object visitScript(HTMLParser.ScriptContext ctx) {
        Script script = new Script();

        if (ctx.SCRIPT_OPEN() != null){
            script.setScriptOpen(ctx.SCRIPT_OPEN().getSymbol().getText());
        }

        if (ctx.SCRIPT_BODY() != null){
            script.setScriptBody(ctx.SCRIPT_BODY().getSymbol().getText());
        }

        if (ctx.SCRIPT_SHORT_BODY() != null){
            script.setScripShortBody(ctx.SCRIPT_SHORT_BODY().getSymbol().getText());
        }
        return super.visitScript(ctx);
    }

    @Override
    public Object visitStyle(HTMLParser.StyleContext ctx) {
        Style style = new Style();

        if (ctx.STYLE_OPEN() != null){
            style.setStyleOpen(ctx.STYLE_OPEN().getSymbol().getText());
        }

        if (ctx.STYLE_BODY() != null){
            style.setStyleBody(ctx.STYLE_BODY().getSymbol().getText());
        }

        if (ctx.STYLE_SHORT_BODY() != null){
            style.setStyleShort(ctx.STYLE_SHORT_BODY().getSymbol().getText());
        }
        return super.visitStyle(ctx);
    }
    //////////////////////////////////////////////////


}
