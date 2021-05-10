package Base;

import AST.Elements.*;
import AST.Elements.ElementsNodes.*;
import AST.Elements.ElementsNodes.CpExpression.For.*;
import AST.Elements.ElementsNodes.CpExpression.If.IfExpression;
import AST.Elements.ElementsNodes.CpExpression.Switch.Collection4Switch1;
import AST.Elements.ElementsNodes.CpExpression.Switch.OneLine4switch1;
import AST.Elements.ElementsNodes.CpExpression.Switch.SwitchCaseExpression;
import AST.Elements.ElementsNodes.CpExpression.Switch.SwitchExpression;
import AST.Elements.ElementsNodes.CpExpression.annotation.*;
import AST.Elements.ElementsNodes.CpExpression.app.AppExpression;
import AST.Elements.ElementsNodes.CpExpression.app.Collection4App1;
import AST.Elements.ElementsNodes.CpExpression.app.OneLine4AppCondition;
import AST.Elements.ElementsNodes.CpExpression.model.Collection4Model1;
import AST.Elements.ElementsNodes.CpExpression.model.ModelExpression;
import AST.Elements.ElementsNodes.CpExpression.model.OneLine4ModelCondition;
import AST.Elements.ElementsNodes.CpExpression.showHide.HideExpression;
import AST.Elements.ElementsNodes.CpExpression.showHide.ShowExpression;
import AST.Elements.ElementsNodes.generic4Elements.*;
import AST.Elements.ElementsNodes.generic4Elements.Logic.ArithmeticLogic;
import AST.Elements.ElementsNodes.generic4Elements.Logic.LastArithmeticLogic;
import AST.Elements.ElementsNodes.generic4Elements.Logic.LogicComprison;
import AST.Elements.ElementsNodes.generic4Elements.Logic.MiddleAndLastLogicComparison;
import AST.Elements.ElementsNodes.generic4Elements.array.ArrName;
import AST.Elements.ElementsNodes.generic4Elements.array.Array;
import AST.Elements.ElementsNodes.generic4Elements.array.ArrayCalling;
import AST.Elements.ElementsNodes.generic4Elements.array.ObjArray;
import AST.Elements.ElementsNodes.generic4Elements.comparison.*;
import AST.Elements.ElementsNodes.generic4Elements.function.*;
import AST.Elements.ElementsNodes.generic4Elements.object.*;
import AST.Elements.ElementsNodes.generic4Elements.property.Property;
import AST.Elements.ElementsNodes.generic4Elements.property.PropertyValue;
import AST.Elements.ElementsNodes.generic4Elements.variable.Variable;
import AST.Elements.ElementsNodes.generic4Elements.variable.VariableName;
import AST.Elements.ElementsNodes.mustacheExpression.MustacheExpression;
import AST.Elements.ElementsNodes.mustacheExpression.filter.Filter;
import AST.Elements.ElementsNodes.mustacheExpression.filter.FormatName;
import AST.Elements.ElementsNodes.mustacheExpression.filter.ModelName;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.*;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Logic.ArithmeticLogic4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Logic.LastArithmeticLogic4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Logic.LogicComprison4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Logic.MiddleAndLastLogicComparison4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.array.ArrName4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.array.ArrayCalling4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.array.ObjArray4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.comparison.*;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.function.*;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.object.SubObj4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.property.Property4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.property.PropertyValue4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.value.MustacheValue;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.var.MustacheVariable;
import AST.HtmlDocument;
import generatedGrammers.HTMLParser;
import generatedGrammers.HTMLParserBaseVisitor;
import treePrinter.SimpleTreeNode;
import treePrinter.decorator.BorderTreeNodeDecorator;
import treePrinter.printer.listing.ListingTreePrinter;
import treePrinter.printer.traditional.TraditionalTreePrinter;

import javax.accessibility.AccessibleTable;
import java.sql.SQLOutput;
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
        SimpleTreeNode htmlDocumentNode = new SimpleTreeNode("Visit htmlDocument");


        if(!ctx.scriptletOrSeaWs().isEmpty()){
            List<ScriptLetOrSeaWs> ObjscriptletOrSeaWs = new ArrayList<>();
            for (int i =0 ; i <  ctx.scriptletOrSeaWs().size() ; i++){
                ObjscriptletOrSeaWs.add( (ScriptLetOrSeaWs) visitScriptletOrSeaWs(ctx.scriptletOrSeaWs(i)));
            }
            htmlDocument.setScriptLetORSeaWs(ObjscriptletOrSeaWs);
        }

        if(ctx.DTD() != null){
            htmlDocument.setDTD(ctx.DTD().getSymbol().getText());
            SimpleTreeNode DTD_Node = new SimpleTreeNode(htmlDocument.getDTD());
            System.out.println(htmlDocument.getDTD());
            htmlDocumentNode.addChild(DTD_Node);
        }

        if (!ctx.htmlElements().isEmpty()){
            List<HtmlElements> htmlElements = new ArrayList<>();
            for (int i =0 ; i <  ctx.htmlElements().size() ; i++){
                htmlElements.add( (HtmlElements) visitHtmlElements(ctx.htmlElements(i)));
            }
            htmlDocument.setHtmlElements(htmlElements);
        }

        if (ctx.XML() != null){
            htmlDocument.setXML(ctx.XML().getSymbol().getText());
        }
        root.addChild(htmlDocumentNode);
        return htmlDocument;
    }

    @Override
    public Object visitScriptletOrSeaWs(HTMLParser.ScriptletOrSeaWsContext ctx) {
        ScriptLetOrSeaWs scriptLetOrSeaWs = new ScriptLetOrSeaWs();
        SimpleTreeNode scriptLetOrSeaWsNode = new SimpleTreeNode("Visit scriptLetOrSeaWs");

        if (ctx.SCRIPTLET() != null){
            scriptLetOrSeaWs.setScriptLet(ctx.SCRIPTLET().getSymbol().getText());
            SimpleTreeNode SCRIPTLET_Node = new SimpleTreeNode(scriptLetOrSeaWs.getScriptLet());
            scriptLetOrSeaWsNode.addChild(SCRIPTLET_Node);
        }
        if (ctx.SEA_WS() != null){
            scriptLetOrSeaWs.setSeaWs(ctx.SEA_WS().getSymbol().getText());
            SimpleTreeNode SeaWs_Node = new SimpleTreeNode(scriptLetOrSeaWs.getSeaWs());
            scriptLetOrSeaWsNode.addChild(SeaWs_Node);
        }
        root.addChild(scriptLetOrSeaWsNode);

        return super.visitScriptletOrSeaWs(ctx);
    }

    @Override
    public Object visitHtmlElements(HTMLParser.HtmlElementsContext ctx) {
        HtmlElements htmlElements = new HtmlElements();

        if (!ctx.htmlMisc().isEmpty()){
            List<HtmlMisc> htmlMiscs = new ArrayList<>();
            for (int i = 0 ; i < ctx.htmlMisc().size() ; i ++ ){
                htmlMiscs.add((HtmlMisc) visitHtmlMisc(ctx.htmlMisc(i)));
            }
            htmlElements.setMisc(htmlMiscs);
        }

        if (ctx.htmlElement() != null){
            htmlElements.setHtmlElement((HtmlElement) visitHtmlElement(ctx.htmlElement()));
        }


        return super.visitHtmlElements(ctx);
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
        SimpleTreeNode htmlElementNode = new SimpleTreeNode("Visit htmlElement");
        //TODO We have problem here
        if(ctx.TAG_NAME() != null){
                htmlElement.setTagName(ctx.TAG_NAME(0).getSymbol().getText());
                SimpleTreeNode tagName1Node = new SimpleTreeNode(ctx.TAG_NAME(0).getSymbol().getText());
                htmlElementNode.addChild(tagName1Node);
            }

            if (ctx.TAG_SLASH_CLOSE() == null){
                if (ctx.TAG_NAME(1) != null){
                    htmlElement.setTagName2(ctx.TAG_NAME(1).getSymbol().getText());
                    SimpleTreeNode tagName2Node = new SimpleTreeNode(ctx.TAG_NAME(1).getSymbol().getText());
                    htmlElementNode.addChild(tagName2Node);
                }

            }

        List<HtmlAttribute> htmlAttributeList = new ArrayList<>();
        if (!ctx.htmlAttribute().isEmpty()) {
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
            SimpleTreeNode ScriptLet_Node = new SimpleTreeNode(htmlElement.getScriptLet());
            htmlElementNode.addChild(ScriptLet_Node);
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

        root.addChild(htmlElementNode);
        return super.visitHtmlElement(ctx);
    }

    @Override
    public Object visitHtmlContent(HTMLParser.HtmlContentContext ctx) {
        ////////this
        // htmlCharData?
        // ((htmlElement | CDATA | htmlComment) htmlChardata?)*
        HtmlContent htmlContent = new HtmlContent();
        SimpleTreeNode htmlContentNode = new SimpleTreeNode("Visit htmlContent");

        if (!ctx.htmlComment().isEmpty()){
            List<HtmlComment> htmlComments = new ArrayList<>();
            for (int i = 0; i < ctx.htmlComment().size(); i++) {
                htmlComments.add((HtmlComment) visitHtmlComment(ctx.htmlComment(i)));
            }
            htmlContent.setHtmlComment(htmlComments);
        }

        if (!ctx.CDATA().isEmpty()){
            List<String> cData = new ArrayList<>();
            for (int i = 0; i < ctx.CDATA().size(); i++) {
                cData.add((String) ctx.CDATA(i).getSymbol().getText());
            }
            htmlContent.setCDATA(cData);
        }

        if (!ctx.htmlChardata().isEmpty()){
            List<HtmlCharData> htmlCharData = new ArrayList<>();
            for (int i = 0; i < ctx.htmlChardata().size(); i++) {
                htmlCharData.add((HtmlCharData) visitHtmlChardata(ctx.htmlChardata(i)));
            }
            htmlContent.setHtmlCharData(htmlCharData);
        }

        if (!ctx.htmlElement().isEmpty()){
            List<HtmlElement> htmlElements = new ArrayList<>();
            for (int i = 0; i < ctx.htmlElement().size(); i++) {
                htmlElements.add((HtmlElement) visitHtmlElement(ctx.htmlElement(i)));
            }
            htmlContent.setHtmlElement(htmlElements);
        }

        return super.visitHtmlContent(ctx);
    }

    @Override
    public Object visitHtmlAttribute(HTMLParser.HtmlAttributeContext ctx) {
        HtmlAttribute htmlAttribute = new HtmlAttribute();
        SimpleTreeNode htmlAttributeNode = new SimpleTreeNode("Visit htmlAttribute");
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
            SimpleTreeNode tagNameNode = new SimpleTreeNode(htmlAttribute.getTagName());
            htmlAttributeNode.addChild(tagNameNode);
        }
        if (ctx.ATTVALUE_VALUE() != null){
            htmlAttribute.setAttValue(ctx.ATTVALUE_VALUE().getSymbol().getText());
            SimpleTreeNode attValueNode = new SimpleTreeNode(htmlAttribute.getAttValue());
            htmlAttributeNode.addChild(attValueNode);
        }
        root.addChild(htmlAttributeNode);
        return super.visitHtmlAttribute(ctx);
    }

    @Override
    public Object visitHtmlChardata(HTMLParser.HtmlChardataContext ctx) {
        HtmlCharData htmlCharData = new HtmlCharData();
        SimpleTreeNode htmlCharDataNode = new SimpleTreeNode("Visit htmlCharData");
        if (ctx.HTML_TEXT() != null){
            htmlCharData.setHtmlText(ctx.HTML_TEXT().getSymbol().getText());
            SimpleTreeNode htmlTextNode = new SimpleTreeNode(htmlCharData.getHtmlText());
            htmlCharDataNode.addChild(htmlTextNode);
        }

        if (ctx.SEA_WS() != null){
            htmlCharData.setSeaWs(ctx.SEA_WS().getSymbol().getText());
            SimpleTreeNode seaWsNode = new SimpleTreeNode(htmlCharData.getSeaWs());
            htmlCharDataNode.addChild(seaWsNode);
        }
        root.addChild(htmlCharDataNode);
        return super.visitHtmlChardata(ctx);
    }

    @Override
    public Object visitHtmlMisc(HTMLParser.HtmlMiscContext ctx) {
        HtmlMisc htmlMisc = new HtmlMisc();
        SimpleTreeNode htmlMiscNode = new SimpleTreeNode("Visit htmlMisc");
        if (ctx.htmlComment() != null){
            htmlMisc.setHtmlComment((HtmlComment) visitHtmlComment(ctx.htmlComment()));
        }
        if (ctx.SEA_WS() != null){
            htmlMisc.setSeaWs(ctx.SEA_WS().getSymbol().getText());
            SimpleTreeNode seaWsNode = new SimpleTreeNode(htmlMisc.getSeaWs());
            htmlMiscNode.addChild(seaWsNode);
        }
        root.addChild(htmlMiscNode);
        return super.visitHtmlMisc(ctx);
    }

    @Override
    public Object visitHtmlComment(HTMLParser.HtmlCommentContext ctx) {
        HtmlComment htmlComment = new HtmlComment();
        SimpleTreeNode htmlCommentNode = new SimpleTreeNode("Visit htmlComment");
        if (ctx.HTML_COMMENT() != null){
            htmlComment.setHtmlComment(ctx.HTML_COMMENT().getSymbol().getText());
            SimpleTreeNode htmlCommentInternalNode = new SimpleTreeNode(htmlComment.getHtmlComment());
            htmlCommentNode.addChild(htmlCommentInternalNode);
        }

        if (ctx.HTML_CONDITIONAL_COMMENT() != null){
            htmlComment.setHtmlConditionalComment(ctx.HTML_CONDITIONAL_COMMENT().getSymbol().getText());
            SimpleTreeNode htmlConditionalCommentNode = new SimpleTreeNode(htmlComment.getHtmlConditionalComment());
            htmlCommentNode.addChild(htmlConditionalCommentNode);
        }
        root.addChild(htmlCommentNode);
        return super.visitHtmlComment(ctx);
    }




    ///////////////////////// FATIMA /////////////////////////
    @Override
    public Object visitAppExpression(HTMLParser.AppExpressionContext ctx) {
        AppExpression appExpression=new AppExpression();
        SimpleTreeNode appExpressionNode = new SimpleTreeNode("Visit appExpression");

        if(ctx.collection4App1()!=null){
            appExpression.setCollection4App1((Collection4App1) visitCollection4App1(ctx.collection4App1()));
        }
        root.addChild(appExpressionNode);
        return super.visitAppExpression(ctx);
    }

    @Override
    public Object visitCollection4App1(HTMLParser.Collection4App1Context ctx) {

        Collection4App1 collection4App1=new Collection4App1();
        SimpleTreeNode collection4App1Node = new SimpleTreeNode("Visit collection4App1");
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

        root.addChild(collection4App1Node);

        return super.visitCollection4App1(ctx);
    }

    @Override
    public Object visitOneLine4AppCondition(HTMLParser.OneLine4AppConditionContext ctx) {

        OneLine4AppCondition  oneLine4AppCondition=new OneLine4AppCondition();
        SimpleTreeNode oneLine4AppConditionNode = new SimpleTreeNode("Visit oneLine4AppCondition");

        if(ctx.logicComprison()!=null&& ctx.collection4App1()!=null){
            oneLine4AppCondition.setLogicComprison((LogicComprison) visitLogicComprison(ctx.logicComprison()));
            oneLine4AppCondition.setCollection4App1_1((Collection4App1) visitCollection4App1(ctx.collection4App1(0)));
            oneLine4AppCondition.setCollection4App1_2((Collection4App1) visitCollection4App1(ctx.collection4App1(1)));
        }
        root.addChild(oneLine4AppConditionNode);
        return super.visitOneLine4AppCondition(ctx);
    }


    ////////////////////// forExpression ////////////////////////
    @Override
    public Object visitForExpression(HTMLParser.ForExpressionContext ctx) {
       ForExpression forExpression=new ForExpression();
       SimpleTreeNode forExpressionNode = new SimpleTreeNode("Visit forExpression");

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
        root.addChild(forExpressionNode);

        return super.visitForExpression(ctx);
    }

    @Override
    public Object visitCollection4For1(HTMLParser.Collection4For1Context ctx) {

      Collection4For1 collection4For1=new Collection4For1();
      SimpleTreeNode collection4For1Node = new SimpleTreeNode("Visit collection4For1");

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
      root.addChild(collection4For1Node);
        return super.visitCollection4For1(ctx);
    }

    @Override
    public Object visitCollection4For2(HTMLParser.Collection4For2Context ctx) {
       Collection4For2 collection4For2=new Collection4For2();
       SimpleTreeNode collection4For2Node = new SimpleTreeNode("Visit collection4For2");

        //Collection4For2  role 1

        if(ctx.variable()!=null){
            collection4For2.setVariable((Variable) visitVariable(ctx.variable()));
        }
        //Collection4For2  role 2

        if(ctx.CP_CONTENT_STRING()!=null){
            collection4For2.setString(ctx.CP_CONTENT_STRING().getSymbol().getText());
            SimpleTreeNode stringNode = new SimpleTreeNode(collection4For2.getString());
            collection4For2Node.addChild(stringNode);
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

        root.addChild(collection4For2Node);

        return super.visitCollection4For2(ctx);
    }

    @Override
    public Object visitOneLine4For2Condition(HTMLParser.OneLine4For2ConditionContext ctx) {

        // ex: (true && (a<b ?true :false ) && !c ? b : b)

        OneLine4For2Condition oneLine4For2Condition=new OneLine4For2Condition();
        SimpleTreeNode oneLine4For2ConditionNode = new SimpleTreeNode("Visit oneLine4For2Condition");

        oneLine4For2Condition.setOpenPar(ctx.CP_CONTENT_OPEN_PAR().getSymbol().getText());
        SimpleTreeNode openParNode = new SimpleTreeNode(oneLine4For2Condition.getOpenPar());
        oneLine4For2ConditionNode.addChild(openParNode);
           if(ctx.logicComprison()!=null&& ctx.collection4For2()!=null){
               oneLine4For2Condition.setLogicComprison((LogicComprison) visitLogicComprison(ctx.logicComprison()));
               oneLine4For2Condition.setCollection4For2_1_1((Collection4For2) visitCollection4For2(ctx.collection4For2(0)));
               oneLine4For2Condition.setCollection4For2_1_2((Collection4For2) visitCollection4For2(ctx.collection4For2(1)));
           }

           root.addChild(oneLine4For2ConditionNode);
        return super.visitOneLine4For2Condition(ctx);
    }

    @Override
    public Object visitCollection4For3(HTMLParser.Collection4For3Context ctx) {
       Collection4For3 collection4For3=new Collection4For3();
       SimpleTreeNode collection4For3Node = new SimpleTreeNode("Visit collection4For3");

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
        root.addChild(collection4For3Node);
        return super.visitCollection4For3(ctx);
    }

    @Override
    public Object visitOneLine4For3Condition(HTMLParser.OneLine4For3ConditionContext ctx) {

        OneLine4For3Condition oneLine4For3Condition=new OneLine4For3Condition();
        SimpleTreeNode oneLine4For3ConditionNode = new SimpleTreeNode("Visit oneLine4For3Condition");


            if(ctx.logicComprison()!=null&& ctx.collection4For3()!=null) {
                oneLine4For3Condition.setLogicComprison((LogicComprison) visitLogicComprison(ctx.logicComprison()));
                oneLine4For3Condition.setCollection4For3_1_1((Collection4For3) visitCollection4For3(ctx.collection4For3(0)));
                oneLine4For3Condition.setCollection4For3_1_2((Collection4For3) visitCollection4For3(ctx.collection4For3(1)));

            }
            root.addChild(oneLine4For3ConditionNode);
        return super.visitOneLine4For3Condition(ctx);
    }

    @Override
    public Object visitCollection4For5(HTMLParser.Collection4For5Context ctx) {

        Collection4For4 collection4For4=new Collection4For4();
        SimpleTreeNode collection4For4Node = new SimpleTreeNode("Visit collection4For4");

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
        root.addChild(collection4For4Node);
        return super.visitCollection4For5(ctx);
    }

    @Override
    public Object visitOneLine4For5Condition(HTMLParser.OneLine4For5ConditionContext ctx) {

        OneLine4For4Condition oneLine4For4Condition = new OneLine4For4Condition();
        SimpleTreeNode oneLine4For4ConditionNode = new SimpleTreeNode("Visit oneLine4For4Condition");


            if (ctx.logicComprison() != null && ctx.collection4For5() != null) {
                oneLine4For4Condition.setLogicComprison((LogicComprison) visitLogicComprison(ctx.logicComprison()));
                oneLine4For4Condition.setCollection4For5_1_1((Collection4For4) visitCollection4For5(ctx.collection4For5(0)));
                oneLine4For4Condition.setCollection4For5_1_2((Collection4For4) visitCollection4For5(ctx.collection4For5(1)));

            }
            root.addChild(oneLine4For4ConditionNode);
        return super.visitOneLine4For5Condition(ctx);
    }

   /////////////////////////// end forexprition ///////////////////////////

    /////////////////////////// show exprition ///////////////////////////
    @Override
    public Object visitShowExpression(HTMLParser.ShowExpressionContext ctx) {

        ShowExpression showExpression=new ShowExpression();
        SimpleTreeNode showExpressionNode = new SimpleTreeNode("Visit showExpression");
        if(ctx.logicComprison()!=null){
            showExpression.setLogicComprison((LogicComprison) visitLogicComprison(ctx.logicComprison()));
        }
        root.addChild(showExpressionNode);
        return super.visitShowExpression(ctx);
    }
    /////////////////////////// end show exprition ///////////////////////////

    ///////////////////////////  Hide exprition ///////////////////////////
    @Override
    public Object visitHideExpression(HTMLParser.HideExpressionContext ctx) {
        HideExpression hideExpression=new HideExpression();
        SimpleTreeNode hideExpressionNode = new SimpleTreeNode("Visit hideExpression");

        if(ctx.logicComprison()!=null){
            hideExpression.setLogicComprison((LogicComprison) visitLogicComprison(ctx.logicComprison()));
        }
        root.addChild(hideExpressionNode);
        return super.visitHideExpression(ctx);
    }

    ///////////////////////////  end Hide exprition ///////////////////////////


    ///////////////////////////  Switch exprition ///////////////////////////
    @Override
    public Object visitSwitchExpression(HTMLParser.SwitchExpressionContext ctx) {
      SwitchExpression switchExpression=new SwitchExpression();
      SimpleTreeNode switchExpressionNode = new SimpleTreeNode("Visit switchExpression");

      if(ctx.collection4Switch1()!=null){
          switchExpression.setCollection4Switch1((Collection4Switch1) visitCollection4Switch1(ctx.collection4Switch1()));
      }
      root.addChild(switchExpressionNode);
        return super.visitSwitchExpression(ctx);
    }

    @Override
    public Object visitSwitchCaseExpression(HTMLParser.SwitchCaseExpressionContext ctx) {

        SwitchCaseExpression switchCaseExpression=new SwitchCaseExpression();
        SimpleTreeNode switchCaseExpressionNode = new SimpleTreeNode("Visit switchCaseExpression");

        if(ctx.collection4Switch1()!=null){
            switchCaseExpression.setCollection4Switch1((Collection4Switch1) visitCollection4Switch1(ctx.collection4Switch1()));
        }
        root.addChild(switchCaseExpressionNode);
        return super.visitSwitchCaseExpression(ctx);
    }

    @Override
    public Object visitCollection4Switch1(HTMLParser.Collection4Switch1Context ctx) {

        Collection4Switch1 collection4Switch1=new Collection4Switch1();
        SimpleTreeNode collection4Switch1Node = new SimpleTreeNode("Visit collection4Switch1");


        //Collection4Switch1  role 1

        if(ctx.variable()!=null){
            collection4Switch1.setVariable((Variable) visitVariable(ctx.variable()));
        }
        //Collection4Switch1  role 2

        if(ctx.CP_CONTENT_STRING()!=null){
            collection4Switch1.setString(ctx.CP_CONTENT_STRING().getSymbol().getText());
            SimpleTreeNode stringNode = new SimpleTreeNode(collection4Switch1.getString());
            collection4Switch1Node.addChild(stringNode);
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
        root.addChild(collection4Switch1Node);

        return super.visitCollection4Switch1(ctx);
    }

    @Override
    public Object visitOneLine4switch1(HTMLParser.OneLine4switch1Context ctx) {

        OneLine4switch1  oneLine4switch1=new OneLine4switch1 ();
        SimpleTreeNode oneLine4switch1Node = new SimpleTreeNode("Visit oneLine4switch1");

        if(ctx.logicComprison()!=null&& ctx.collection4Switch1()!=null){
            oneLine4switch1.setLogicComprison((LogicComprison) visitLogicComprison(ctx.logicComprison()));
            oneLine4switch1.setCollection4Switch1_1_1((Collection4Switch1) visitCollection4Switch1(ctx.collection4Switch1(0)));
            oneLine4switch1.setCollection4Switch1_1_2((Collection4Switch1) visitCollection4Switch1(ctx.collection4Switch1(1)));
        }
        root.addChild(oneLine4switch1Node);
        return super.visitOneLine4switch1(ctx);
    }

    ///////////////////////////   End Switch exprition ///////////////////////////

    ///////////////////////////  If exprition ///////////////////////////

    @Override
    public Object visitIfExpression(HTMLParser.IfExpressionContext ctx) {

        IfExpression ifExpression =new IfExpression();
        SimpleTreeNode ifExpressionNode = new SimpleTreeNode("Visit ifExpression");

      if(ctx.logicComprison()!=null){
          ifExpression.setLogicComprison((LogicComprison) visitLogicComprison(ctx.logicComprison()));
      }
      root.addChild(ifExpressionNode);
        return super.visitIfExpression(ctx);
    }

    ///////////////////////////  end If exprition ///////////////////////////

    ///////////////////////////  Model exprition ///////////////////////////
    @Override
    public Object visitModelExpression(HTMLParser.ModelExpressionContext ctx) {

        ModelExpression modelExpression =new ModelExpression();
        SimpleTreeNode modelExpressionNode  = new SimpleTreeNode("Visit modelExpression");

        if(ctx.collection4Model1()!=null){
            modelExpression.setCollection4Model1((Collection4Model1) visitCollection4Model1(ctx.collection4Model1()));
        }
        root.addChild(modelExpressionNode);
        return super.visitModelExpression(ctx);
    }

    @Override
    public Object visitCollection4Model1(HTMLParser.Collection4Model1Context ctx) {

       Collection4Model1 collection4Model1=new Collection4Model1();
       SimpleTreeNode collection4Model1Node = new SimpleTreeNode("Visit collection4Model1");

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
        root.addChild(collection4Model1Node);
        return super.visitCollection4Model1(ctx);
    }

    @Override
    public Object visitOneLine4ModelCondition(HTMLParser.OneLine4ModelConditionContext ctx) {

        OneLine4ModelCondition oneLine4ModelCondition=new OneLine4ModelCondition();
        SimpleTreeNode oneLine4ModelConditionNode = new SimpleTreeNode("Visit oneLine4ModelCondition");

        if(ctx.logicComprison()!=null&& ctx.collection4Model1()!=null){
            oneLine4ModelCondition.setLogicComprison((LogicComprison) visitLogicComprison(ctx.logicComprison()));
            oneLine4ModelCondition.setCollection4Model1_1_1((Collection4Model1) visitCollection4Model1(ctx.collection4Model1(0)));
            oneLine4ModelCondition.setCollection4Model1_1_2((Collection4Model1) visitCollection4Model1(ctx.collection4Model1(1)));
        }
        root.addChild(oneLine4ModelConditionNode);
        return super.visitOneLine4ModelCondition(ctx);
    }
    /////////////////////////// End  Model exprition ///////////////////////////

    ///////////////////////////  Annotation exprition ///////////////////////////

    @Override
    public Object visitAnnotationClickExpression(HTMLParser.AnnotationClickExpressionContext ctx) {
       AnnotationClickExpression clickExpression =new AnnotationClickExpression();
       SimpleTreeNode clickExpressionNode = new SimpleTreeNode("Visit clickExpression");

       if(ctx.collection4Annotation()!=null){
           clickExpression.setCollection4Annotation((Collection4Annotation) visitCollection4Annotation(ctx.collection4Annotation()));
       }
       root.addChild(clickExpressionNode);
        return super.visitAnnotationClickExpression(ctx);
    }

    @Override
    public Object visitAnnotationOverExpression(HTMLParser.AnnotationOverExpressionContext ctx) {

         AnnotationOverExpression overExpression =new AnnotationOverExpression ();
         SimpleTreeNode overExpressionNode  = new SimpleTreeNode("Visit overExpression");

        if(ctx.collection4Annotation()!=null){
            overExpression.setCollection4Annotation((Collection4Annotation) visitCollection4Annotation(ctx.collection4Annotation()));
        }
        root.addChild(overExpressionNode);
        return super.visitAnnotationOverExpression(ctx);
    }

    @Override
    public Object visitCollection4Annotation(HTMLParser.Collection4AnnotationContext ctx) {
        Collection4Annotation collection4Annotation =new Collection4Annotation();
        SimpleTreeNode collection4AnnotationNode = new SimpleTreeNode("Visit collection4Annotation");

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
        root.addChild(collection4AnnotationNode);
        return super.visitCollection4Annotation(ctx);
    }

    @Override
    public Object visitOneLine4Annotation(HTMLParser.OneLine4AnnotationContext ctx) {

          OneLine4Annotation oneLine4Annotation=new OneLine4Annotation();
          SimpleTreeNode oneLine4AnnotationNode = new SimpleTreeNode("Visit oneLine4Annotation");
        if(ctx.logicComprison()!=null&& ctx.collection4Annotation()!=null){
            oneLine4Annotation.setLogicComprison((LogicComprison) visitLogicComprison(ctx.logicComprison()));
            oneLine4Annotation.setCollection4Annotation1_1((Collection4Annotation) visitCollection4Annotation(ctx.collection4Annotation(0)));
            oneLine4Annotation.setCollection4Annotation1_2((Collection4Annotation) visitCollection4Annotation(ctx.collection4Annotation(1)));
        }
        root.addChild(oneLine4AnnotationNode);
        return super.visitOneLine4Annotation(ctx);
    }

    @Override
    public Object visitFunctionCall4AnnotOneLine(HTMLParser.FunctionCall4AnnotOneLineContext ctx) {

       FunctionCall4AnnotOneLine functionCall4AnnotOneLine=new FunctionCall4AnnotOneLine();
       SimpleTreeNode functionCall4AnnotOneLineNode = new SimpleTreeNode("Visit functionCall4AnnotOneLine");

       if(ctx.funcEndRet4AnnotOneLine()!=null&&ctx.funcEndRet4AnnotOneLine()!=null){

           functionCall4AnnotOneLine.setFuncEndRet4AnnotOneLine((FuncEndRet4AnnotOneLine) visitFuncEndRet4AnnotOneLine(ctx.funcEndRet4AnnotOneLine()));
           functionCall4AnnotOneLine.setFunctionName((FunctionName) visitFunctionName(ctx.functionName()));
       }
       root.addChild(functionCall4AnnotOneLineNode);
        return super.visitFunctionCall4AnnotOneLine(ctx);
    }

    @Override
    public Object visitArrayFuncRet4AnnotOneLine(HTMLParser.ArrayFuncRet4AnnotOneLineContext ctx) {

        ArrayFuncRet4AnnotOneLine arrayFuncRet4AnnotOneLine=new ArrayFuncRet4AnnotOneLine();
        SimpleTreeNode arrayFuncRet4AnnotOneLineNode = new SimpleTreeNode("Visit arrayFuncRet4AnnotOneLine");
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

        root.addChild(arrayFuncRet4AnnotOneLineNode);
        return super.visitArrayFuncRet4AnnotOneLine(ctx);
    }

    @Override
    public Object visitPropFuncRet4AnnotOneLine(HTMLParser.PropFuncRet4AnnotOneLineContext ctx) {
       PropFuncRet4AnnotOneLine propFuncRet4AnnotOneLine=new PropFuncRet4AnnotOneLine();
       SimpleTreeNode propFuncRet4AnnotOneLineNode = new SimpleTreeNode("Visit propFuncRet4AnnotOneLine");
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
       root.addChild(propFuncRet4AnnotOneLineNode);
        return super.visitPropFuncRet4AnnotOneLine(ctx);
    }

    @Override
    public Object visitFuncEndRet4AnnotOneLine(HTMLParser.FuncEndRet4AnnotOneLineContext ctx) {

         FuncEndRet4AnnotOneLine funcEndRet4AnnotOneLine=new FuncEndRet4AnnotOneLine();
         SimpleTreeNode funcEndRet4AnnotOneLineNode = new SimpleTreeNode("Visit funcEndRet4AnnotOneLine");
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
        root.addChild(funcEndRet4AnnotOneLineNode);
        return super.visitFuncEndRet4AnnotOneLine(ctx);
    }


    //////////////////////////////////////////////////




    ///////////////////////// MAYAR /////////////////////////

    @Override
    public Object visitVariable(HTMLParser.VariableContext ctx) {
        //: variableName
        Variable variable = new Variable();
        SimpleTreeNode variableNode = new SimpleTreeNode("Visit variable");



        if (ctx.variableName() != null){
            variable.setVariableName((VariableName) visitVariableName(ctx.variableName()));
        }
        root.addChild(variableNode);
        return super.visitVariable(ctx);
    }

    @Override
    public Object visitVariableName(HTMLParser.VariableNameContext ctx) {
        //: CP_CONTENT_IDENTIFIER
        VariableName variableName = new VariableName();
        SimpleTreeNode variableNameNode = new SimpleTreeNode("Visit variableName");

        if (ctx.CP_CONTENT_IDENTIFIER() != null){
            variableName.setIdentifier(ctx.CP_CONTENT_IDENTIFIER().getSymbol().getText());
            SimpleTreeNode identifierNode = new SimpleTreeNode(variableName.getIdentifier());
            variableNameNode.addChild(identifierNode);
        }
        root.addChild(variableNameNode);
        return super.visitVariableName(ctx);
    }

    @Override
    public Object visitNumber(HTMLParser.NumberContext ctx) {
//        : CP_CONTENT_NUMBER
        NUmber nUmber = new NUmber();
        SimpleTreeNode nUmberNode = new SimpleTreeNode("Visit nUmber");

        if (ctx.CP_CONTENT_NUMBER() != null) {
            // TODO i don't know if this is right or not
            double numberType = Double.parseDouble(ctx.CP_CONTENT_NUMBER().getSymbol().getText());
            // For check what's the type of Number
            if (numberType == (int) numberType) {
                nUmber.setNumber(Integer.parseInt(ctx.CP_CONTENT_NUMBER().getSymbol().getText()));
                SimpleTreeNode numberNode = new SimpleTreeNode(nUmber.getNumber().toString());
                nUmberNode.addChild(numberNode);
            }
            else if (numberType == (float)numberType){
                nUmber.setNumber(Float.parseFloat(ctx
                .CP_CONTENT_NUMBER().getSymbol().getText()));
                SimpleTreeNode numberNode = new SimpleTreeNode(nUmber.getNumber().toString());
                nUmberNode.addChild(numberNode);
            }
            else{
                nUmber.setNumber(Double.parseDouble(ctx.CP_CONTENT_NUMBER().getSymbol().getText()));
                SimpleTreeNode numberNode = new SimpleTreeNode(nUmber.getNumber().toString());
                nUmberNode.addChild(numberNode);
            }
        }
        root.addChild(nUmberNode);
        return super.visitNumber(ctx);
    }

    @Override
    public Object visitTrueOrFalse(HTMLParser.TrueOrFalseContext ctx) {
//        :  (CP_CONTENT_TRUE | CP_CONTENT_FALSE)
        TrueOrFalse trueOrFalse = new TrueOrFalse();
        SimpleTreeNode trueOrFalseNode = new SimpleTreeNode("Visit trueOrFalse");
        if (ctx.CP_CONTENT_TRUE() != null){
            trueOrFalse.setTrue(true);
            SimpleTreeNode trueNode = new SimpleTreeNode("True");
            trueOrFalseNode.addChild(trueNode);
        }

        if (ctx.CP_CONTENT_FALSE() != null){
            trueOrFalse.setFalse(false);
            SimpleTreeNode falseNode = new SimpleTreeNode("False");
            trueOrFalseNode.addChild(falseNode);
        }
        root.addChild(trueOrFalseNode);
        return super.visitTrueOrFalse(ctx);
    }

    @Override
    public Object visitObjArray(HTMLParser.ObjArrayContext ctx) {
//        : arrName arrayCalling
        ObjArray objArray = new ObjArray();
        SimpleTreeNode objArrayNode = new SimpleTreeNode("Visit objArray");

        if (ctx.arrName() != null){
            objArray.setArrName((ArrName) visitArrName(ctx.arrName()));
        }
        if (ctx.arrayCalling() != null){
            objArray.setArrayCalling((ArrayCalling) visitArrayCalling(ctx.arrayCalling()));
        }
        root.addChild(objArrayNode);
        return super.visitObjArray(ctx);
    }

    @Override
    public Object visitArrName(HTMLParser.ArrNameContext ctx) {
//        : CP_CONTENT_IDENTIFIER
        ArrName arrName = new ArrName();
        SimpleTreeNode arrNameNode  = new SimpleTreeNode("Visit arrName");

        if (ctx.CP_CONTENT_IDENTIFIER() != null){
            arrName.setIdentifier(ctx.CP_CONTENT_IDENTIFIER().getSymbol().getText());
            SimpleTreeNode identifierNode  = new SimpleTreeNode(arrName.getIdentifier());
            arrNameNode.addChild(identifierNode);
        }
        root.addChild(arrNameNode);
        return super.visitArrName(ctx);
    }

    @Override
    public Object visitArrayCalling(HTMLParser.ArrayCallingContext ctx) {
//: (CP_CONTENT_OPEN_BRACKETS  arithmeticLogic CP_CONTENT_CLOSE_BRACKETS)+ (functionCallFromVar | property)?
        ArrayCalling arrayCalling = new ArrayCalling();
        SimpleTreeNode arrayCallingNode  = new SimpleTreeNode("Visit arrayCalling");

        if (!ctx.arithmeticLogic().isEmpty()){
            List<ArithmeticLogic> arithmeticLogics = new ArrayList<>();
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
        root.addChild(arrayCallingNode);
        return super.visitArrayCalling(ctx);
    }

    @Override
    public Object visitArray(HTMLParser.ArrayContext ctx) {
        Array array = new Array();
        SimpleTreeNode arrayNode = new SimpleTreeNode("Visit array");


        if (!ctx.collection4everything().isEmpty()){
            ArrayList<Collection4everything> internalCollections4EveryThings = new ArrayList<>();
            for (int i =0 ; i<ctx.collection4everything().size();i++){
                internalCollections4EveryThings.add((Collection4everything) visitCollection4everything(ctx.collection4everything(i)));
            }
            array.setInternalCollection4everythings(internalCollections4EveryThings);

        }
        root.addChild(arrayNode);
        return super.visitArray(ctx);
    }

    @Override
    public Object visitObj(HTMLParser.ObjContext ctx) {
//    : CP_CONTENT_IDENTIFIER

        Obj obj = new Obj();
        SimpleTreeNode objNode = new SimpleTreeNode("Visit obj");

        if (ctx.CP_CONTENT_IDENTIFIER() != null){
            obj.setIdentifier(ctx.CP_CONTENT_IDENTIFIER().getSymbol().getText());
            SimpleTreeNode identifierNode = new SimpleTreeNode(obj.getIdentifier());
            objNode.addChild(identifierNode);
        }
        root.addChild(objNode);
        return super.visitObj(ctx);
    }

    @Override
    public Object visitSubObj(HTMLParser.SubObjContext ctx) {
//    : CP_CONTENT_IDENTIFIER property
        SubObj subObj = new SubObj();
        SimpleTreeNode subObjNode = new SimpleTreeNode("Visit subObj");

        if (ctx.CP_CONTENT_IDENTIFIER() != null){
            subObj.setIdentifier(ctx.CP_CONTENT_IDENTIFIER().getSymbol().getText());
            SimpleTreeNode identifierNode = new SimpleTreeNode(subObj.getIdentifier());
            subObjNode.addChild(identifierNode);
        }

        if (ctx.property() != null){
            subObj.setProperty((Property) visitProperty(ctx.property()));
        }
        root.addChild(subObjNode);
        return super.visitSubObj(ctx);
    }

    @Override
    public Object visitObjBody(HTMLParser.ObjBodyContext ctx) {
//: CP_CONTENT_OPEN_CURLY_BRACKETS (pair (CP_CONTENT_COMMA pair)*)* CP_CONTENT_CLOSE_CURLY_BRACKETS

        ObjBody objBody = new ObjBody();
        SimpleTreeNode objBodyNode = new SimpleTreeNode("Visit objBody");

        if (!ctx.pair().isEmpty()){
            ArrayList<Pair> pairs = new ArrayList<>();
            for (int i=0 ; i< ctx.pair().size(); i++){
                pairs.add((Pair) visitPair(ctx.pair(i)));
            }
            objBody.setPairs(pairs);
        }
        root.addChild(objBodyNode);
        return super.visitObjBody(ctx);
    }

    @Override
    public Object visitPair(HTMLParser.PairContext ctx) {
//    : key CP_CONTENT_COLON collection4everything
        Pair pair = new Pair();
        SimpleTreeNode pairNode  = new SimpleTreeNode("Visit pair");

        if (ctx.key() != null){
            pair.setKey((Key) visitKey(ctx.key()));
        }

        if (ctx.collection4everything() != null){
            pair.setCollection4everything((Collection4everything) visitCollection4everything(ctx.collection4everything()));
        }
        root.addChild(pairNode);
        return super.visitPair(ctx);
    }

    @Override
    public Object visitKey(HTMLParser.KeyContext ctx) {
//            : CP_CONTENT_IDENTIFIER

        Key key = new Key();
        SimpleTreeNode keyNode = new SimpleTreeNode("Visit key");

        if (ctx.CP_CONTENT_IDENTIFIER() != null){
            key.setIdentifier(ctx.CP_CONTENT_IDENTIFIER().getSymbol().getText());
            SimpleTreeNode identifierNode = new SimpleTreeNode(key.getIdentifier());
            keyNode.addChild(identifierNode);
        }
        root.addChild(keyNode);
        return super.visitKey(ctx);
    }

    @Override
    public Object visitProperty(HTMLParser.PropertyContext ctx) {
//        : (CP_CONTENT_DOT propertyValue)+ (arrayCalling | functionCallFromVar)?

        Property property = new Property();
        SimpleTreeNode propertyNode = new SimpleTreeNode("Visit property");

        if (!ctx.propertyValue().isEmpty()){
            ArrayList<PropertyValue> propertyValues = new ArrayList<>();
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
        root.addChild(propertyNode);
        return super.visitProperty(ctx);
    }

    @Override
    public Object visitPropertyValue(HTMLParser.PropertyValueContext ctx) {
//        : CP_CONTENT_IDENTIFIER
        PropertyValue propertyValue = new PropertyValue();
        SimpleTreeNode propertyValueNode = new SimpleTreeNode("Visit propertyValue");
        if (ctx.CP_CONTENT_IDENTIFIER() != null){
            propertyValue.setIdentifier(ctx.CP_CONTENT_IDENTIFIER().getSymbol().getText());
            SimpleTreeNode identifierNode = new SimpleTreeNode(propertyValue.getIdentifier());
            propertyValueNode.addChild(identifierNode);
        }
        root.addChild(propertyValueNode);
        return super.visitPropertyValue(ctx);
    }

    @Override
    public Object visitFunctionCall(HTMLParser.FunctionCallContext ctx) {
//    : functionName functionCallFromVar

        FunctionCall functionCall = new FunctionCall();
        SimpleTreeNode functionCallNode = new SimpleTreeNode("Visit functionCall");

        if (ctx.functionName() != null){
            functionCall.setFunctionName((FunctionName) visitFunctionName(ctx.functionName()));
        }

        if (ctx.functionCallFromVar() != null){
            functionCall.setFunctionCallFromVar((FunctionCallFromVar) visitFunctionCallFromVar(ctx.functionCallFromVar()));
        }
        root.addChild(functionCallNode);
        return super.visitFunctionCall(ctx);
    }

    @Override
    public Object visitFunctionCallFromVar(HTMLParser.FunctionCallFromVarContext ctx) {
//    : (CP_CONTENT_OPEN_PAR parameters? CP_CONTENT_CLOSE_PAR)+ (arrayCalling | property)?

        FunctionCallFromVar functionCallFromVar = new FunctionCallFromVar();
        SimpleTreeNode functionCallFromVarNode = new SimpleTreeNode("Visit functionCallFromVar");

        if (!ctx.parameters().isEmpty()){
            ArrayList<Parameters> parametersArrayList = new ArrayList<>();
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
        root.addChild(functionCallFromVarNode);
        return super.visitFunctionCallFromVar(ctx);
    }

    @Override
    public Object visitFunctionName(HTMLParser.FunctionNameContext ctx) {
//    : CP_CONTENT_IDENTIFIER

        FunctionName functionName = new FunctionName();
        SimpleTreeNode functionNameNode = new SimpleTreeNode("Visit functionName");

        if (ctx.CP_CONTENT_IDENTIFIER() != null){
            functionName.setIdentifier(ctx.CP_CONTENT_IDENTIFIER().getSymbol().getText());
            SimpleTreeNode identifierNode = new SimpleTreeNode(functionName.getIdentifier());
            functionNameNode.addChild(identifierNode);
        }
        root.addChild(functionNameNode);
        return super.visitFunctionName(ctx);
    }

    @Override
    public Object visitParameters(HTMLParser.ParametersContext ctx) {
//        : parameter (CP_CONTENT_COMMA parameter)*

        Parameters parameters = new Parameters();
        SimpleTreeNode parametersNode = new SimpleTreeNode("Visit parameters");

        if (!ctx.parameter().isEmpty()){
            ArrayList<Parameter> parameterArrayList = new ArrayList<>();
            for (int i=0; i< ctx.parameter().size();i++){
                parameterArrayList.add((Parameter) visitParameter(ctx.parameter(i)));
            }
            parameters.setParameters(parameterArrayList);
        }
        root.addChild(parametersNode);
        return super.visitParameters(ctx);
    }

    @Override
    public Object visitParameter(HTMLParser.ParameterContext ctx) {
//: collection4everything
        Parameter parameter = new Parameter();
        SimpleTreeNode parameterNode = new SimpleTreeNode("Visit parameter");
        if (ctx.collection4everything() != null){
            parameter.setCollection4everything((Collection4everything) visitCollection4everything(ctx.collection4everything()));
        }
        root.addChild(parameterNode);
        return super.visitParameter(ctx);
    }

    @Override
    public Object visitComparisonExpression(HTMLParser.ComparisonExpressionContext ctx) {
//: collection4comparison comparisonOperator collection4comparison

        ComparisonExpression comparisonExpression = new ComparisonExpression();
        SimpleTreeNode comparisonExpressionNode = new SimpleTreeNode("Visit comparisonExpression");

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
        root.addChild(comparisonExpressionNode);
        return super.visitComparisonExpression(ctx);
    }

    @Override
    public Object visitOneLineCondition(HTMLParser.OneLineConditionContext ctx) {
//: CP_CONTENT_OPEN_PAR logicComprison CP_CONTENT_QUESTION_MARK collection4everything CP_CONTENT_COLON collection4everything CP_CONTENT_CLOSE_PAR

        OneLineCondition oneLineCondition = new OneLineCondition();
        SimpleTreeNode oneLineConditionNode = new SimpleTreeNode("Visit oneLineCondition");
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
        root.addChild(oneLineConditionNode);
        return super.visitOneLineCondition(ctx);
    }

    @Override
    public Object visitOneLineBoolCondition(HTMLParser.OneLineBoolConditionContext ctx) {
//: CP_CONTENT_OPEN_PAR logicComprison CP_CONTENT_QUESTION_MARK CP_CONTENT_TRUE CP_CONTENT_COLON CP_CONTENT_FALSE CP_CONTENT_CLOSE_PAR

        OneLineBoolCondition oneLineBoolCondition = new OneLineBoolCondition();
        SimpleTreeNode oneLineBoolConditionNode = new SimpleTreeNode("Visit oneLineBoolCondition");

        if (ctx.logicComprison() != null){
            oneLineBoolCondition.setLogicComprison((LogicComprison) visitLogicComprison(ctx.logicComprison()));
        }

        if (ctx.CP_CONTENT_FALSE() != null){
            oneLineBoolCondition.setFalse(false);
            SimpleTreeNode falseNode = new SimpleTreeNode("False");
            oneLineBoolConditionNode.addChild(falseNode);
        }

        if (ctx.CP_CONTENT_TRUE() != null){
            oneLineBoolCondition.setTrue(true);
            SimpleTreeNode trueNode = new SimpleTreeNode("True");
            oneLineBoolConditionNode.addChild(trueNode);
        }
        root.addChild(oneLineBoolConditionNode);
        return super.visitOneLineBoolCondition(ctx);
    }

    @Override
    public Object visitOneLineArithCondition(HTMLParser.OneLineArithConditionContext ctx) {
//: CP_CONTENT_OPEN_PAR logicComprison CP_CONTENT_QUESTION_MARK arithmeticLogic CP_CONTENT_COLON arithmeticLogic CP_CONTENT_CLOSE_PAR

        OneLineArithCondition oneLineArithCondition = new OneLineArithCondition();
        SimpleTreeNode oneLineArithConditionNode = new SimpleTreeNode("Visit oneLineArithCondition");

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
        root.addChild(oneLineArithConditionNode);
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
        SimpleTreeNode comparisonOperatorNode = new SimpleTreeNode("Visit comparisonOperator");

        //CP_CONTENT_GREATER_THAN
        if (ctx.CP_CONTENT_GREATER_THAN() != null){
            comparisonOperator.setComparisonOperator(ctx.CP_CONTENT_GREATER_THAN().getSymbol().getText());
            SimpleTreeNode comparisonOperatorInternalNode = new SimpleTreeNode(comparisonOperator.getComparisonOperator());
            comparisonOperatorNode.addChild(comparisonOperatorInternalNode);
        }
//        CP_CONTENT_GREATER_EQ
        if (ctx.CP_CONTENT_GREATER_EQ() != null){
            comparisonOperator.setComparisonOperator(ctx.CP_CONTENT_GREATER_EQ().getSymbol().getText());
            SimpleTreeNode comparisonOperatorInternalNode = new SimpleTreeNode(comparisonOperator.getComparisonOperator());
            comparisonOperatorNode.addChild(comparisonOperatorInternalNode);
        }
        //CP_CONTENT_LESS_THAN
        if (ctx.CP_CONTENT_LESS_THAN() != null){
            comparisonOperator.setComparisonOperator(ctx.CP_CONTENT_LESS_THAN().getSymbol().getText());
            SimpleTreeNode comparisonOperatorInternalNode = new SimpleTreeNode(comparisonOperator.getComparisonOperator());
            comparisonOperatorNode.addChild(comparisonOperatorInternalNode);
        }
        //CP_CONTENT_LESS_EQ
        if (ctx.CP_CONTENT_LESS_EQ() != null){
            comparisonOperator.setComparisonOperator(ctx.CP_CONTENT_LESS_EQ().getSymbol().getText());
            SimpleTreeNode comparisonOperatorInternalNode = new SimpleTreeNode(comparisonOperator.getComparisonOperator());
            comparisonOperatorNode.addChild(comparisonOperatorInternalNode);
        }
        //CP_CONTENT_EQUAL_TO
        if (ctx.CP_CONTENT_EQUAL_TO() != null){
            comparisonOperator.setComparisonOperator(ctx.CP_CONTENT_EQUAL_TO().getSymbol().getText());
            SimpleTreeNode comparisonOperatorInternalNode = new SimpleTreeNode(comparisonOperator.getComparisonOperator());
            comparisonOperatorNode.addChild(comparisonOperatorInternalNode);
        }
        //CP_CONTENT_NOT_EQUAL
        if (ctx.CP_CONTENT_NOT_EQUAL() != null){
            comparisonOperator.setComparisonOperator(ctx.CP_CONTENT_NOT_EQUAL().getSymbol().getText());
            SimpleTreeNode comparisonOperatorInternalNode = new SimpleTreeNode(comparisonOperator.getComparisonOperator());
            comparisonOperatorNode.addChild(comparisonOperatorInternalNode);
        }
        root.addChild(comparisonOperatorNode);
        return super.visitComparisonOperator(ctx);
    }

    @Override
    public Object visitLogicComprison(HTMLParser.LogicComprisonContext ctx) {
//        : ((CP_CONTENT_NOT)? ((collection4LogicRet) | (CP_CONTENT_OPEN_PAR logicComprison CP_CONTENT_CLOSE_PAR))) /// first
//        middleAndLastLogicComparison*
        LogicComprison logicComprison = new LogicComprison();
        SimpleTreeNode logicComprisonNode = new SimpleTreeNode("Visit logicComprison");
        if (ctx.CP_CONTENT_NOT() != null){
            logicComprison.setNotFirst(ctx.CP_CONTENT_NOT().getSymbol().getText());
            SimpleTreeNode notFirstNode = new SimpleTreeNode(logicComprison.getNotFirst());
            logicComprisonNode.addChild(notFirstNode);
        }

        if (ctx.collection4LogicRet() != null){
            logicComprison.setCollection4LogicRetFirst((Collection4LogicRet) visitCollection4LogicRet(ctx.collection4LogicRet()));
        }

        if (ctx.CP_CONTENT_OPEN_PAR() != null){
            logicComprison.setOpenParFirst(ctx.CP_CONTENT_OPEN_PAR().getSymbol().getText());
            SimpleTreeNode openParFirstNode = new SimpleTreeNode(logicComprison.getOpenParFirst());
            logicComprisonNode.addChild(openParFirstNode);
        }

        if (ctx.logicComprison() != null){
            logicComprison.setLogicComprisonFirst((LogicComprison) visitLogicComprison(ctx.logicComprison()));
        }

        if (!ctx.middleAndLastLogicComparison().isEmpty()){
            List<MiddleAndLastLogicComparison> middleAndLastLogicComparisons = new ArrayList<>();
            for (int i = 0 ; i < ctx.middleAndLastLogicComparison().size() ; i++){
                middleAndLastLogicComparisons.add((MiddleAndLastLogicComparison) visitMiddleAndLastLogicComparison(ctx.middleAndLastLogicComparison(i)));
            }
            logicComprison.setMiddleAndLastLogicComparisons(middleAndLastLogicComparisons);
        }
        root.addChild(logicComprisonNode);
        return super.visitLogicComprison(ctx);
    }
    @Override
    public Object visitMiddleAndLastLogicComparison(HTMLParser.MiddleAndLastLogicComparisonContext ctx) {
//           : ((CP_CONTENT_AND (CP_CONTENT_NOT)?) | (CP_CONTENT_OR (CP_CONTENT_NOT)?))   /// middle
//        (collection4LogicRet | CP_CONTENT_OPEN_PAR logicComprison CP_CONTENT_CLOSE_PAR)

        MiddleAndLastLogicComparison middleAndLastLogicComparison = new MiddleAndLastLogicComparison();
        SimpleTreeNode middleAndLastLogicComparisonNode = new SimpleTreeNode("Visit middleAndLastLogicComparison");
        //First OR between ----- && or || -----

        //Only && (&&)
        if (ctx.CP_CONTENT_AND() != null){
            middleAndLastLogicComparison.setAndMiddle(ctx.CP_CONTENT_AND().getSymbol().getText());
            SimpleTreeNode andMiddleNode = new SimpleTreeNode(middleAndLastLogicComparison.getAndMiddle());
            middleAndLastLogicComparisonNode.addChild(andMiddleNode);
            if (ctx.CP_CONTENT_NOT() != null){
                middleAndLastLogicComparison.setNotAndMiddle(ctx.CP_CONTENT_NOT().getSymbol().getText());
                SimpleTreeNode notAndMiddleNode = new SimpleTreeNode(middleAndLastLogicComparison.getNotAndMiddle());
                middleAndLastLogicComparisonNode.addChild(notAndMiddleNode);
            }
        }
        // OR

        //Only || (||)
        if (ctx.CP_CONTENT_OR() != null){
            middleAndLastLogicComparison.setOrMiddle(ctx.CP_CONTENT_OR().getSymbol().getText());
            SimpleTreeNode orMiddleNode = new SimpleTreeNode(middleAndLastLogicComparison.getOrMiddle());
            middleAndLastLogicComparisonNode.addChild(orMiddleNode);
            if (ctx.CP_CONTENT_NOT() != null){
                middleAndLastLogicComparison.setNotOrMiddle(ctx.CP_CONTENT_NOT().getSymbol().getText());
                SimpleTreeNode notOrMiddleNode = new SimpleTreeNode(middleAndLastLogicComparison.getNotOrMiddle());
                middleAndLastLogicComparisonNode.addChild(notOrMiddleNode);
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
        root.addChild(middleAndLastLogicComparisonNode);
        return super.visitMiddleAndLastLogicComparison(ctx);
    }
    @Override
    public Object visitArithmeticLogic(HTMLParser.ArithmeticLogicContext ctx) {
//: (collection4Arithmetic | CP_CONTENT_OPEN_PAR arithmeticLogic CP_CONTENT_CLOSE_PAR) lastArithmeticLogic*

        ArithmeticLogic arithmeticLogic = new ArithmeticLogic();
        SimpleTreeNode arithmeticLogicNode = new SimpleTreeNode("Visit arithmeticLogic");

        //First OR  between ----"collection4Arithmetic" and "arithmeticLogic"----

        if (ctx.collection4Arithmetic() != null){
            arithmeticLogic.setCollection4Arithmetic((Collection4Arithmetic) visitCollection4Arithmetic(ctx.collection4Arithmetic()));
        }
        // OR

        if (ctx.arithmeticLogic() != null){
            arithmeticLogic.setArithmeticLogic((ArithmeticLogic) visitArithmeticLogic(ctx.arithmeticLogic()));
        }

        if (!ctx.lastArithmeticLogic().isEmpty()){
            ArrayList<LastArithmeticLogic> lastArithmeticLogicArrayList = new ArrayList<>();
            for (int i=0; i< ctx.lastArithmeticLogic().size();i++){
                lastArithmeticLogicArrayList.add((LastArithmeticLogic) visitLastArithmeticLogic(ctx.lastArithmeticLogic(i)));
            }
            arithmeticLogic.setLastArithmeticLogic(lastArithmeticLogicArrayList);
        }
        root.addChild(arithmeticLogicNode);
        return super.visitArithmeticLogic(ctx);
    }
    @Override
    public Object visitLastArithmeticLogic(HTMLParser.LastArithmeticLogicContext ctx) {
//: CP_CONTENT_ARITHMETIC (collection4Arithmetic | CP_CONTENT_OPEN_PAR arithmeticLogic CP_CONTENT_CLOSE_PAR)

        LastArithmeticLogic lastArithmeticLogic = new LastArithmeticLogic();
        SimpleTreeNode lastArithmeticLogicNode = new SimpleTreeNode("Visit lastArithmeticLogic");

        if (ctx.CP_CONTENT_ARITHMETIC() != null){
            lastArithmeticLogic.setArithmetic(ctx.CP_CONTENT_ARITHMETIC().getSymbol().getText());
            SimpleTreeNode arithmeticNode = new SimpleTreeNode(lastArithmeticLogic.getArithmetic());
            lastArithmeticLogicNode.addChild(arithmeticNode);
        }

        // First OR between -----"collection4Arithmetic"  OR "arithmeticLogic"-----
        if (ctx.collection4Arithmetic() != null){
            lastArithmeticLogic.setCollection4Arithmetic((Collection4Arithmetic) visitCollection4Arithmetic(ctx.collection4Arithmetic()));

        }
        // OR

        if (ctx.arithmeticLogic() != null){
            lastArithmeticLogic.setArithmeticLogic((ArithmeticLogic) visitArithmeticLogic(ctx.arithmeticLogic()));
        }
        root.addChild(lastArithmeticLogicNode);
        return super.visitLastArithmeticLogic(ctx);
    }
    @Override
    public Object visitValue(HTMLParser.ValueContext ctx) {
//        : CP_CONTENT_STRING
//                | number
//                | trueOrFalse
//                | CP_CONTENT_NULL

        Value value = new Value();
        SimpleTreeNode valueNode = new SimpleTreeNode("Visit value");

        if (ctx.CP_CONTENT_STRING() != null){
            value.setString(ctx.CP_CONTENT_STRING().getSymbol().getText());
            SimpleTreeNode stringNode = new SimpleTreeNode(value.getString());
            valueNode.addChild(stringNode);
        }
        if (ctx.CP_CONTENT_NULL() != null){
            value.setNull(null);
            SimpleTreeNode nullNode = new SimpleTreeNode(value.getNull().toString());
            valueNode.addChild(nullNode);
        }


        if (ctx.number() != null){
            value.setNumber((NUmber) visitNumber(ctx.number()));
        }
        if (ctx.trueOrFalse() != null){
            value.setTrueOrFalse((TrueOrFalse) visitTrueOrFalse(ctx.trueOrFalse()));
        }
        root.addChild(valueNode);
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
        SimpleTreeNode collection4everythingNode = new SimpleTreeNode("Visit collection4everything");

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
        root.addChild(collection4everythingNode);
        return super.visitCollection4everything(ctx);
    }

    @Override
    public Object visitCollection4comparison(HTMLParser.Collection4comparisonContext ctx) {
//            : arithmeticLogic

        Collection4comparison collection4comparison = new Collection4comparison();
        SimpleTreeNode collection4comparisonNode = new SimpleTreeNode("Visit collection4comparison");
        if (ctx.arithmeticLogic() != null){
            collection4comparison.setArithmeticLogic((ArithmeticLogic) visitArithmeticLogic(ctx.arithmeticLogic()));
        }
        root.addChild(collection4comparisonNode);
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
        SimpleTreeNode collection4ArithmeticNode = new SimpleTreeNode("Visit collection4Arithmetic");


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
        root.addChild(collection4ArithmeticNode);
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
        SimpleTreeNode collection4LogicRetNode = new SimpleTreeNode("Visit collection4LogicRet");

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
        root.addChild(collection4LogicRetNode);
        return super.visitCollection4LogicRet(ctx);
    }


    //////////////////////////////////////////////////










    ///////////////////////// NOOR /////////////////////////
    @Override
    public Object visitMustacheExpression(HTMLParser.MustacheExpressionContext ctx) {
        MustacheExpression mustacheExpression = new MustacheExpression();
        SimpleTreeNode mustacheExpressionNode = new SimpleTreeNode("Visit mustacheExpression");

        if (ctx.collection4Mustache() != null){
            mustacheExpression.setCollection4Mustache((Collection4Mustache) visitCollection4Mustache(ctx.collection4Mustache()));
        }

        if (ctx.filter() != null){
            mustacheExpression.setFilter((Filter) visitFilter(ctx.filter()));
        }
        root.addChild(mustacheExpressionNode);
        return super.visitMustacheExpression(ctx);
    }
    @Override
    public Object visitCollection4Mustache(HTMLParser.Collection4MustacheContext ctx) {
        Collection4Mustache collection4Mustache = new Collection4Mustache();
        SimpleTreeNode collection4MustacheNode = new SimpleTreeNode("Visit collection4Mustache");

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
        root.addChild(collection4MustacheNode);
        return super.visitCollection4Mustache(ctx);
    }

    @Override
    public Object visitCollection4LogicRet4Must(HTMLParser.Collection4LogicRet4MustContext ctx) {
        Collection4LogicRet4Must collection4LogicRet4Must = new Collection4LogicRet4Must();
        SimpleTreeNode collection4LogicRet4MustNode = new SimpleTreeNode("Visit collection4LogicRet4Must");

        if (ctx.mustacheVariable() != null){
            collection4LogicRet4Must.setMustacheVariable((MustacheVariable) visitMustacheVariable(ctx.mustacheVariable()));
        }

        if (ctx.MUSTACHE_TRUE() != null){
            collection4LogicRet4Must.setMustacheTrue(true);
            SimpleTreeNode mustacheTrueNode = new SimpleTreeNode("True");
            collection4LogicRet4MustNode.addChild(mustacheTrueNode);
        }
        if (ctx.MUSTACHE_FALSE() != null){
            collection4LogicRet4Must.setMustacheFalse(false);
            SimpleTreeNode mustacheFalseNode = new SimpleTreeNode("False");
            collection4LogicRet4MustNode.addChild(mustacheFalseNode);
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
        root.addChild(collection4LogicRet4MustNode);
        return super.visitCollection4LogicRet4Must(ctx);
    }

    @Override
    public Object visitCollection4CompMust(HTMLParser.Collection4CompMustContext ctx) {
        Collection4CompMust collection4CompMust = new Collection4CompMust();
        SimpleTreeNode collection4CompMustNode = new SimpleTreeNode("Visit collection4CompMust");

        if (ctx.arithmeticLogic4Must() != null){
            collection4CompMust.setArithmeticLogic4Must((ArithmeticLogic4Must) visitArithmeticLogic4Must(ctx.arithmeticLogic4Must()));
        }
        root.addChild(collection4CompMustNode);
        return super.visitCollection4CompMust(ctx);
    }

    @Override
    public Object visitCollection4MUSTArithmetic(HTMLParser.Collection4MUSTArithmeticContext ctx) {
        Collection4MUSTArithmetic collection4MUSTArithmetic = new Collection4MUSTArithmetic();
        SimpleTreeNode collection4MUSTArithmeticNode = new SimpleTreeNode("Visit collection4MUSTArithmetic");

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
        root.addChild(collection4MUSTArithmeticNode);
        return super.visitCollection4MUSTArithmetic(ctx);
    }

    @Override
    public Object visitLogicComprison4Must(HTMLParser.LogicComprison4MustContext ctx) {
        LogicComprison4Must logicComprison4Must = new LogicComprison4Must();
        SimpleTreeNode logicComprison4MustNode = new SimpleTreeNode("Visit logicComprison4Must");
        // !
        if (ctx.MUSTACHE_NOT() != null){
            logicComprison4Must.setNotFirst(ctx.MUSTACHE_NOT().getSymbol().getText());
            SimpleTreeNode notFirstNode = new SimpleTreeNode(logicComprison4Must.getNotFirst());
            logicComprison4MustNode.addChild(notFirstNode);
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
        if (!ctx.middleAndLastLogicComparison4Must().isEmpty()){
            List<MiddleAndLastLogicComparison4Must> middleAndLastLogicComparison4Musts = new ArrayList<>();
            for (int i = 0 ; i < ctx.middleAndLastLogicComparison4Must().size() ; i ++){
                middleAndLastLogicComparison4Musts.add((MiddleAndLastLogicComparison4Must) visitMiddleAndLastLogicComparison4Must(ctx.middleAndLastLogicComparison4Must(i)));
            }
            logicComprison4Must.setMiddleAndLastLogicComparisons(middleAndLastLogicComparison4Musts);
        }
        root.addChild(logicComprison4MustNode);
        return super.visitLogicComprison4Must(ctx);
    }

    @Override
    public Object visitMiddleAndLastLogicComparison4Must(HTMLParser.MiddleAndLastLogicComparison4MustContext ctx) {
        MiddleAndLastLogicComparison4Must middleAndLastLogicComparison4Must = new MiddleAndLastLogicComparison4Must();
        SimpleTreeNode middleAndLastLogicComparison4MustNode = new SimpleTreeNode("Visit middleAndLastLogicComparison4Must");
        //middle
        //this AND NOT?
        if (ctx.MUSTACHE_AND() != null){
            middleAndLastLogicComparison4Must.setAndMiddle(ctx.MUSTACHE_AND().getSymbol().getText());
            SimpleTreeNode andMiddleNode = new SimpleTreeNode(middleAndLastLogicComparison4Must.getAndMiddle());
            middleAndLastLogicComparison4MustNode.addChild(andMiddleNode);
            if (ctx.MUSTACHE_NOT() != null){
                middleAndLastLogicComparison4Must.setNotAndMiddle(ctx.MUSTACHE_NOT().getSymbol().getText());
                SimpleTreeNode notAndMiddleNode = new SimpleTreeNode(middleAndLastLogicComparison4Must.getNotAndMiddle());
                middleAndLastLogicComparison4MustNode.addChild(notAndMiddleNode);
            }
        }
        // or this OR NOT?
        if (ctx.MUSTACHE_OR() != null){
            middleAndLastLogicComparison4Must.setOrMiddle(ctx.MUSTACHE_OR().getSymbol().getText());
            SimpleTreeNode orMiddleNode = new SimpleTreeNode(middleAndLastLogicComparison4Must.getOrMiddle());
            middleAndLastLogicComparison4MustNode.addChild(orMiddleNode);
            if (ctx.MUSTACHE_NOT() != null){
                middleAndLastLogicComparison4Must.setNotOrMiddle(ctx.MUSTACHE_NOT().getSymbol().getText());
                SimpleTreeNode notOrMiddleNode = new SimpleTreeNode(middleAndLastLogicComparison4Must.getNotOrMiddle());
                middleAndLastLogicComparison4MustNode.addChild(notOrMiddleNode);
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
        root.addChild(middleAndLastLogicComparison4MustNode);
        return super.visitMiddleAndLastLogicComparison4Must(ctx);
    }

    @Override
    public Object visitArithmeticLogic4Must(HTMLParser.ArithmeticLogic4MustContext ctx) {
        ArithmeticLogic4Must arithmeticLogic4Must = new ArithmeticLogic4Must();
        SimpleTreeNode arithmeticLogic4MustNode = new SimpleTreeNode("Visit arithmeticLogic4Must");

        //this collection4MUSTArithmetic
        if (ctx.collection4MUSTArithmetic() != null){
            arithmeticLogic4Must.setCollection4Arithmetic((Collection4MUSTArithmetic) visitCollection4MUSTArithmetic(ctx.collection4MUSTArithmetic()));
        }

        // or arithmeticLogic4Must
        if (ctx.arithmeticLogic4Must() != null){
            arithmeticLogic4Must.setArithmeticLogic((ArithmeticLogic4Must) visitArithmeticLogic4Must(ctx.arithmeticLogic4Must()));
        }

        if (!ctx.lastArithmeticLogic4Must().isEmpty()) {
            List<LastArithmeticLogic4Must> lastArithmeticLogic4Musts = new ArrayList<>();
            for (int i = 0; i < ctx.lastArithmeticLogic4Must().size(); i++) {
                lastArithmeticLogic4Musts.add((LastArithmeticLogic4Must) visitLastArithmeticLogic4Must(ctx.lastArithmeticLogic4Must(i)));
            }
            arithmeticLogic4Must.setLastArithmeticLogic(lastArithmeticLogic4Musts);
        }
        root.addChild(arithmeticLogic4MustNode);
        return super.visitArithmeticLogic4Must(ctx);
    }

    @Override
    public Object visitLastArithmeticLogic4Must(HTMLParser.LastArithmeticLogic4MustContext ctx) {
        LastArithmeticLogic4Must lastArithmeticLogic4Must = new LastArithmeticLogic4Must();
        SimpleTreeNode lastArithmeticLogic4MustNode = new SimpleTreeNode("Visit lastArithmeticLogic4Must");

        if (ctx.MUSTACHE_ARITHMETIC() != null){
            lastArithmeticLogic4Must.setArithmetic(ctx.MUSTACHE_ARITHMETIC().getSymbol().getText());
            SimpleTreeNode arithmeticNode = new SimpleTreeNode(lastArithmeticLogic4Must.getArithmetic());
            lastArithmeticLogic4MustNode.addChild(arithmeticNode);
        }
        //this
        if (ctx.collection4MUSTArithmetic() != null){
            lastArithmeticLogic4Must.setCollection4MUSTArithmetic((Collection4MUSTArithmetic) visitCollection4MUSTArithmetic(ctx.collection4MUSTArithmetic()));
        }
        //or
        if (ctx.arithmeticLogic4Must() != null){
            lastArithmeticLogic4Must.setArithmeticLogic((ArithmeticLogic4Must) visitArithmeticLogic4Must(ctx.arithmeticLogic4Must()));
        }
        root.addChild(lastArithmeticLogic4MustNode);
        return super.visitLastArithmeticLogic4Must(ctx);
    }
    @Override
    public Object visitMustacheVariable(HTMLParser.MustacheVariableContext ctx) {
        MustacheVariable mustacheVariable = new MustacheVariable();
        SimpleTreeNode mustacheVariableNode = new SimpleTreeNode("Visit mustacheVariable");
        if (ctx.MUSTACHE_IDENTIFIER() != null){
            mustacheVariable.setMustacheVariable(ctx.MUSTACHE_IDENTIFIER().getSymbol().getText());
            SimpleTreeNode mustacheVariableInternalNode = new SimpleTreeNode(mustacheVariable.getMustacheVariable());
            mustacheVariableNode.addChild(mustacheVariableInternalNode);
        }
        root.addChild(mustacheVariableNode);
        return super.visitMustacheVariable(ctx);
    }

    @Override
    public Object visitMustacheNumber(HTMLParser.MustacheNumberContext ctx) {
        MustacheNumber mustacheNumber = new MustacheNumber();
        SimpleTreeNode mustacheNumberNode = new SimpleTreeNode("Visit mustacheNumber");
        if (ctx.MUSTACHE_NUMBER() != null){
            // TODO i don't know if this is right or not
            double numberType = Double.parseDouble(ctx.MUSTACHE_NUMBER().getSymbol().getText());
            // For check what's the type of Number
            if (numberType == (int) numberType) {
                mustacheNumber.setNumber(Integer.parseInt(ctx.MUSTACHE_NUMBER().getSymbol().getText()));
                SimpleTreeNode numberNode = new SimpleTreeNode(mustacheNumber.getNumber().toString());
                mustacheNumberNode.addChild(numberNode);
            }
            else if (numberType == (float)numberType){
                mustacheNumber.setNumber(Float.parseFloat(ctx
                        .MUSTACHE_NUMBER().getSymbol().getText()));
                SimpleTreeNode numberNode = new SimpleTreeNode(mustacheNumber.getNumber().toString());
                mustacheNumberNode.addChild(numberNode);
            }
            else{
                mustacheNumber.setNumber(Double.parseDouble(ctx.MUSTACHE_NUMBER().getSymbol().getText()));
                SimpleTreeNode numberNode = new SimpleTreeNode(mustacheNumber.getNumber().toString());
                mustacheNumberNode.addChild(numberNode);
            }
        }
        root.addChild(mustacheNumberNode);
        return super.visitMustacheNumber(ctx);
    }

    @Override
    public Object visitMustacheValue(HTMLParser.MustacheValueContext ctx) {
        MustacheValue mustacheValue = new MustacheValue();
        SimpleTreeNode mustacheValueNode = new SimpleTreeNode("Visit mustacheValue");

        if (ctx.mustacheNumber() != null){
            mustacheValue.setMustacheNumber((MustacheNumber) visitMustacheNumber(ctx.mustacheNumber()));
        }

        if (ctx.MUSTACHE_STRING() != null){
            mustacheValue.setMustacheString(ctx.MUSTACHE_STRING().getSymbol().getText());
            SimpleTreeNode mustacheStringNode = new SimpleTreeNode(mustacheValue.getMustacheString());
            mustacheStringNode.addChild(mustacheStringNode);
        }

        if (ctx.MUSTACHE_TRUE() != null){
            mustacheValue.setMustacheTrue(true);
            SimpleTreeNode mustacheTrueNode = new SimpleTreeNode("True");
            mustacheValueNode.addChild(mustacheTrueNode);
        }

        if (ctx.MUSTACHE_FALSE() != null){
            mustacheValue.setMustacheFalse(false);
            SimpleTreeNode mustacheFalseNode = new SimpleTreeNode("False");
            mustacheValueNode.addChild(mustacheFalseNode);
        }

        if (ctx.MUSTACHE_NULL() != null){
            mustacheValue.setMUSTACHE_NULL(null);
            SimpleTreeNode mustacheNullNode = new SimpleTreeNode("Null");
            mustacheValueNode.addChild(mustacheNullNode);
        }
        root.addChild(mustacheValueNode);
        return super.visitMustacheValue(ctx);
    }

    @Override
    public Object visitObjArray4Must(HTMLParser.ObjArray4MustContext ctx) {
        ObjArray4Must objArray4Must = new ObjArray4Must();
        SimpleTreeNode objArray4MustNode = new SimpleTreeNode("Visit objArray4Must");

        if (ctx.arrName4Must() != null){
            objArray4Must.setArrName4Must1((ArrName4Must) visitArrName4Must(ctx.arrName4Must()));
        }

        if (ctx.arrayCalling4Must() != null){
            objArray4Must.setArrayCalling4Must((ArrayCalling4Must) visitArrayCalling4Must(ctx.arrayCalling4Must()));
        }
        root.addChild(objArray4MustNode);
        return super.visitObjArray4Must(ctx);
    }

    @Override
    public Object visitArrName4Must(HTMLParser.ArrName4MustContext ctx) {
        ArrName4Must arrName4Must = new ArrName4Must();
        SimpleTreeNode arrName4MustNode = new SimpleTreeNode("Visit arrName4Must");
        if (ctx.MUSTACHE_IDENTIFIER() != null){
            arrName4Must.setArrName4Must(ctx.MUSTACHE_IDENTIFIER().getSymbol().getText());
            SimpleTreeNode arrName4MustIdentifierNode = new SimpleTreeNode(arrName4Must.getArrName4Must());
            arrName4MustNode.addChild(arrName4MustIdentifierNode);
        }
        root.addChild(arrName4MustNode);
        return super.visitArrName4Must(ctx);
    }

    @Override
    public Object visitArrayCalling4Must(HTMLParser.ArrayCalling4MustContext ctx) {
        ArrayCalling4Must arrayCalling4Must = new ArrayCalling4Must();
        SimpleTreeNode arrayCalling4MustNode = new SimpleTreeNode("Visit arrayCalling4Must");

        if (!ctx.arithmeticLogic4Must().isEmpty()){
            List<ArithmeticLogic4Must> arithmeticLogic4Musts = new ArrayList<>();
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
        root.addChild(arrayCalling4MustNode);
        return super.visitArrayCalling4Must(ctx);
    }

    @Override
    public Object visitFunctionCall4Must(HTMLParser.FunctionCall4MustContext ctx) {
        FunctionCall4Must functionCall4Must = new FunctionCall4Must();
        SimpleTreeNode functionCall4MustNode = new SimpleTreeNode("Visit functionCall4Must");

        if (ctx.functionName4Must() != null){
            functionCall4Must.setFunctionName4Must1((FunctionName4Must) visitFunctionName4Must(ctx.functionName4Must()));
        }

        if (ctx.functionCallFromVar4Must() != null){
            functionCall4Must.setFunctionCallFromVar4Must((FunctionCallFromVar4Must) visitFunctionCallFromVar4Must(ctx.functionCallFromVar4Must()));
        }
        root.addChild(functionCall4MustNode);
        return super.visitFunctionCall4Must(ctx);
    }

    @Override
    public Object visitFunctionCallFromVar4Must(HTMLParser.FunctionCallFromVar4MustContext ctx) {
        FunctionCallFromVar4Must functionCallFromVar4Must = new FunctionCallFromVar4Must();
        SimpleTreeNode functionCallFromVar4MustNode = new SimpleTreeNode("Visit functionCallFromVar4Must");

        if (!ctx.parameters4Must().isEmpty()){
            List<Parameters4Must> parameters4Musts = new ArrayList<>();
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
        root.addChild(functionCallFromVar4MustNode);
        return super.visitFunctionCallFromVar4Must(ctx);
    }

    @Override
    public Object visitFunctionName4Must(HTMLParser.FunctionName4MustContext ctx) {
        FunctionName4Must functionName4Must = new FunctionName4Must();
        SimpleTreeNode functionName4MustNode = new SimpleTreeNode("Visit functionName4Must");
        if (ctx.MUSTACHE_IDENTIFIER() != null){
            functionName4Must.setFunctionName4Must(ctx.MUSTACHE_IDENTIFIER().getSymbol().getText());
            SimpleTreeNode functionName4MustIdentifierNode = new SimpleTreeNode(functionName4Must.getFunctionName4Must());
            functionName4MustNode.addChild(functionName4MustIdentifierNode);
        }
        root.addChild(functionName4MustNode);
        return super.visitFunctionName4Must(ctx);
    }

    @Override
    public Object visitParameters4Must(HTMLParser.Parameters4MustContext ctx) {
        Parameters4Must parameters4Must = new Parameters4Must();
        SimpleTreeNode parameters4MustNode = new SimpleTreeNode("Visit parameters4Must");

        if (!ctx.parameter4Must().isEmpty()){
            List<Parameter4Must> parameter4Musts = new ArrayList<>();
            for (int i = 0 ; i < ctx.parameter4Must().size() ; i ++){
                parameter4Musts.add((Parameter4Must) visitParameter4Must(ctx.parameter4Must(i)));
            }
            parameters4Must.setParameters4Musts(parameter4Musts);
        }
        root.addChild(parameters4MustNode);
        return super.visitParameters4Must(ctx);
    }

    @Override
    public Object visitParameter4Must(HTMLParser.Parameter4MustContext ctx) {
        Parameter4Must parameter4Must = new Parameter4Must();
        SimpleTreeNode parameter4MustNode = new SimpleTreeNode("Visit parameter4Must");

        if (ctx.collection4Mustache() != null){
            parameter4Must.setCollection4Mustache((Collection4Mustache) visitCollection4Mustache(ctx.collection4Mustache()));
        }
        root.addChild(parameter4MustNode);
        return super.visitParameter4Must(ctx);
    }

    @Override
    public Object visitSubObj4Must(HTMLParser.SubObj4MustContext ctx) {
        SubObj4Must subObj4Must = new SubObj4Must();
        SimpleTreeNode subObj4MustNode = new SimpleTreeNode("Visit subObj4Must");

        if (ctx.MUSTACHE_IDENTIFIER() != null){
            subObj4Must.setSubObj4MustName(ctx.MUSTACHE_IDENTIFIER().getSymbol().getText());
            SimpleTreeNode subObj4MustIdentifierNameNode = new SimpleTreeNode(subObj4Must.getSubObj4MustName());
            subObj4MustNode.addChild(subObj4MustIdentifierNameNode);
        }

        if (ctx.property4Must() != null){
            subObj4Must.setProperty4Must((Property4Must) visitProperty4Must(ctx.property4Must()));
        }
        root.addChild(subObj4MustNode);
        return super.visitSubObj4Must(ctx);
    }

    @Override
    public Object visitProperty4Must(HTMLParser.Property4MustContext ctx) {
        Property4Must property4Must = new Property4Must();
        SimpleTreeNode property4MustNode = new SimpleTreeNode("Visit property4Must");

        if (!ctx.propertyValue4Must().isEmpty()){
            List<PropertyValue4Must> propertyValue4Musts = new ArrayList<>();
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
        root.addChild(property4MustNode);
        return super.visitProperty4Must(ctx);
    }

    @Override
    public Object visitPropertyValue4Must(HTMLParser.PropertyValue4MustContext ctx) {
        PropertyValue4Must propertyValue4Must = new PropertyValue4Must();
        SimpleTreeNode propertyValue4MustNode = new SimpleTreeNode("Visit propertyValue4Must");

        if (ctx.MUSTACHE_IDENTIFIER() != null){
            propertyValue4Must.setPropertyValue4Must(ctx.MUSTACHE_IDENTIFIER().getSymbol().getText());
            SimpleTreeNode propertyValue4MustIdentifierNode = new SimpleTreeNode(propertyValue4Must.getPropertyValue4Must());
            propertyValue4MustNode.addChild(propertyValue4MustIdentifierNode);
        }
        root.addChild(propertyValue4MustNode);
        return super.visitPropertyValue4Must(ctx);
    }

    @Override
    public Object visitOneLineCondition4Must(HTMLParser.OneLineCondition4MustContext ctx) {
        OneLineCondition4Must oneLineCondition4Must = new OneLineCondition4Must();
        SimpleTreeNode oneLineCondition4MustNode = new SimpleTreeNode("Visit oneLineCondition4Must");

        if (ctx.logicComprison4Must() != null){
            oneLineCondition4Must.setLogicComprison4Must((LogicComprison4Must) visitLogicComprison4Must(ctx.logicComprison4Must()));
        }

        if (ctx.collection4Mustache() != null){
            oneLineCondition4Must.setCollection4Mustache1((Collection4Mustache) visitCollection4Mustache(ctx.collection4Mustache(0)));
            oneLineCondition4Must.setCollection4Mustache2((Collection4Mustache) visitCollection4Mustache(ctx.collection4Mustache(1)));
        }
        root.addChild(oneLineCondition4MustNode);
        return super.visitOneLineCondition4Must(ctx);
    }

    @Override
    public Object visitOneLineArithCondition4Must(HTMLParser.OneLineArithCondition4MustContext ctx) {
        OneLineArithCondition4Must oneLineArithCondition4Must = new OneLineArithCondition4Must();
        SimpleTreeNode oneLineArithCondition4MustNode = new SimpleTreeNode("Visit oneLineArithCondition4Must");

        if (ctx.logicComprison4Must() != null){
            oneLineArithCondition4Must.setLogicComprison4Must((LogicComprison4Must) visitLogicComprison4Must(ctx.logicComprison4Must()));
        }

        if (ctx.arithmeticLogic4Must() != null){
            oneLineArithCondition4Must.setArithmeticLogic4Must1((ArithmeticLogic4Must) visitArithmeticLogic4Must(ctx.arithmeticLogic4Must(0)));
            oneLineArithCondition4Must.setArithmeticLogic4Must2((ArithmeticLogic4Must) visitArithmeticLogic4Must(ctx.arithmeticLogic4Must(1)));
        }
        root.addChild(oneLineArithCondition4MustNode);
        return super.visitOneLineArithCondition4Must(ctx);
    }

    @Override
    public Object visitOneLineBoolCondition4Must(HTMLParser.OneLineBoolCondition4MustContext ctx) {
        OneLineBoolCondition4Must oneLineBoolCondition4Must = new OneLineBoolCondition4Must();
        SimpleTreeNode oneLineBoolCondition4MustNode = new SimpleTreeNode("Visit oneLineBoolCondition4Must");

        if (ctx.logicComprison4Must() != null){
            oneLineBoolCondition4Must.setLogicComprison4Must((LogicComprison4Must) visitLogicComprison4Must(ctx.logicComprison4Must()));
        }

        if (ctx.MUSTACHE_TRUE() != null){
            oneLineBoolCondition4Must.setTrue(true);
            SimpleTreeNode trueNode = new SimpleTreeNode("True");
            oneLineBoolCondition4MustNode.addChild(trueNode);
        }
        if (ctx.MUSTACHE_FALSE() != null){
            oneLineBoolCondition4Must.setFalse(false);
            SimpleTreeNode falseNode = new SimpleTreeNode("False");
            oneLineBoolCondition4MustNode.addChild(falseNode);
        }
        root.addChild(oneLineBoolCondition4MustNode);
        return super.visitOneLineBoolCondition4Must(ctx);
    }

    @Override
    public Object visitComparisonExp4Must(HTMLParser.ComparisonExp4MustContext ctx) {
        ComparisonExp4Must comparisonExp4Must = new ComparisonExp4Must();
        SimpleTreeNode comparisonExp4MustNode = new SimpleTreeNode("Visit comparisonExp4Must");

        if (ctx.collection4CompMust() != null){
            comparisonExp4Must.setCollection4CompMust((Collection4CompMust) visitCollection4CompMust(ctx.collection4CompMust(0)));
            comparisonExp4Must.setCollection4CompMust2((Collection4CompMust) visitCollection4CompMust(ctx.collection4CompMust(1)));
        }

        if (ctx.mustacheComparisonOperator() != null){
            comparisonExp4Must.setMustacheComparisonOperator((MustacheComparisonOperator) visitMustacheComparisonOperator(ctx.mustacheComparisonOperator()));
        }
        root.addChild(comparisonExp4MustNode);
        return super.visitComparisonExp4Must(ctx);
    }

    @Override
    public Object visitMustacheComparisonOperator(HTMLParser.MustacheComparisonOperatorContext ctx) {
        MustacheComparisonOperator mustacheComparisonOperator = new MustacheComparisonOperator();
        SimpleTreeNode mustacheComparisonOperatorNode = new SimpleTreeNode("Visit mustacheComparisonOperator");

        if (ctx.MUSTACHE_GREATER_THAN() != null){

            mustacheComparisonOperator.setOperator(ctx.MUSTACHE_GREATER_THAN().getSymbol().getText());
            SimpleTreeNode operatorNode = new SimpleTreeNode(mustacheComparisonOperator.getOperator());
            mustacheComparisonOperatorNode.addChild(operatorNode);
        }

        if (ctx.MUSTACHE_GREATER_EQ() != null){

            mustacheComparisonOperator.setOperator(ctx.MUSTACHE_GREATER_EQ().getSymbol().getText());
            SimpleTreeNode operatorNode = new SimpleTreeNode(mustacheComparisonOperator.getOperator());
            mustacheComparisonOperatorNode.addChild(operatorNode);
        }



        if (ctx.MUSTACHE_LESS_THAN() != null){

            mustacheComparisonOperator.setOperator(ctx.MUSTACHE_LESS_THAN().getSymbol().getText());
            SimpleTreeNode operatorNode = new SimpleTreeNode(mustacheComparisonOperator.getOperator());
            mustacheComparisonOperatorNode.addChild(operatorNode);
        }


        if (ctx.MUSTACHE_LESS_EQ() != null){

            mustacheComparisonOperator.setOperator(ctx.MUSTACHE_LESS_EQ().getSymbol().getText());
            SimpleTreeNode operatorNode = new SimpleTreeNode(mustacheComparisonOperator.getOperator());
            mustacheComparisonOperatorNode.addChild(operatorNode);
        }


        if (ctx.MUSTACHE_EQUAL_TO() != null){

            mustacheComparisonOperator.setOperator(ctx.MUSTACHE_EQUAL_TO().getSymbol().getText());
            SimpleTreeNode operatorNode = new SimpleTreeNode(mustacheComparisonOperator.getOperator());
            mustacheComparisonOperatorNode.addChild(operatorNode);
        }
        if (ctx.MUSTACHE_NOT_EQUAL() != null){

            mustacheComparisonOperator.setOperator(ctx.MUSTACHE_NOT_EQUAL().getSymbol().getText());
            SimpleTreeNode operatorNode = new SimpleTreeNode(mustacheComparisonOperator.getOperator());
            mustacheComparisonOperatorNode.addChild(operatorNode);
        }
        root.addChild(mustacheComparisonOperatorNode);
        return super.visitMustacheComparisonOperator(ctx);
    }

    @Override
    public Object visitFilter(HTMLParser.FilterContext ctx) {
        Filter filter = new Filter();
        SimpleTreeNode filterNode = new SimpleTreeNode("Visit filter");

        if (ctx.modelName() != null){
            filter.setModelName((ModelName) visitModelName(ctx.modelName()));
        }

        if (ctx.MUSTACHE_FILTER() != null){
            filter.setFilter(ctx.MUSTACHE_FILTER().getSymbol().getText());
            SimpleTreeNode filterInternalNode = new SimpleTreeNode(filter.getFilter());
            filterNode.addChild(filterInternalNode);
        }

        if (ctx.formatName() != null){
            filter.setFormatName((FormatName) visitFormatName(ctx.formatName()));
        }

        if (ctx.collection4Mustache() != null){
            filter.setCollection4Mustache((Collection4Mustache) visitCollection4Mustache(ctx.collection4Mustache()));
        }
        root.addChild(filterNode);
        return super.visitFilter(ctx);
    }

    @Override
    public Object visitModelName(HTMLParser.ModelNameContext ctx) {
        ModelName modelName = new ModelName();
        SimpleTreeNode modelNameNode = new SimpleTreeNode("Visit modelName");
        if (ctx.MUSTACHE_IDENTIFIER() != null){
            modelName.setMustachIdentifier(ctx.MUSTACHE_IDENTIFIER().getSymbol().getText());
            SimpleTreeNode mustacheIdentifierNode = new SimpleTreeNode(modelName.getMustachIdentifier());
            modelNameNode.addChild(mustacheIdentifierNode);
        }
        root.addChild(modelNameNode);
        return super.visitModelName(ctx);
    }

    @Override
    public Object visitFormatName(HTMLParser.FormatNameContext ctx) {
        FormatName formatName = new FormatName();
        SimpleTreeNode formatNameNode = new SimpleTreeNode("Visit formatName");
        if (ctx.MUSTACHE_IDENTIFIER() != null){
            formatName.setMustachIdentifier(ctx.MUSTACHE_IDENTIFIER().getSymbol().getText());
            SimpleTreeNode mustacheIdentifierNode = new SimpleTreeNode(formatName.getMustachIdentifier());
            formatNameNode.addChild(mustacheIdentifierNode);
        }
        root.addChild(formatNameNode);
        return super.visitFormatName(ctx);
    }

    @Override
    public Object visitScript(HTMLParser.ScriptContext ctx) {
        Script script = new Script();
        SimpleTreeNode scriptNode = new SimpleTreeNode("Visit script");

        if (ctx.SCRIPT_OPEN() != null){
            script.setScriptOpen(ctx.SCRIPT_OPEN().getSymbol().getText());
            SimpleTreeNode scriptOpenNode = new SimpleTreeNode(script.getScriptOpen());
            scriptNode.addChild(scriptOpenNode);
        }

        if (ctx.SCRIPT_BODY() != null){
            script.setScriptBody(ctx.SCRIPT_BODY().getSymbol().getText());
            SimpleTreeNode scriptBodyNode = new SimpleTreeNode(script.getScriptBody());
            scriptNode.addChild(scriptBodyNode);
        }

        if (ctx.SCRIPT_SHORT_BODY() != null){
            script.setScripShortBody(ctx.SCRIPT_SHORT_BODY().getSymbol().getText());
            SimpleTreeNode scriptShortBodyNode = new SimpleTreeNode(script.getScripShortBody());
            scriptNode.addChild(scriptShortBodyNode);
        }
        root.addChild(scriptNode);
        return super.visitScript(ctx);
    }

    @Override
    public Object visitStyle(HTMLParser.StyleContext ctx) {
        Style style = new Style();
        SimpleTreeNode styleNode = new SimpleTreeNode("Visit style");

        if (ctx.STYLE_OPEN() != null){
            style.setStyleOpen(ctx.STYLE_OPEN().getSymbol().getText());
            SimpleTreeNode styleOpenNode = new SimpleTreeNode(style.getStyleOpen());
            styleNode.addChild(styleOpenNode);
        }

        if (ctx.STYLE_BODY() != null){
            style.setStyleBody(ctx.STYLE_BODY().getSymbol().getText());
            SimpleTreeNode styleBodyNode = new SimpleTreeNode(style.getStyleBody());
            styleNode.addChild(styleBodyNode);
        }

        if (ctx.STYLE_SHORT_BODY() != null){
            style.setStyleShort(ctx.STYLE_SHORT_BODY().getSymbol().getText());
            SimpleTreeNode styleShortNode = new SimpleTreeNode(style.getStyleShort());
            styleNode.addChild(styleShortNode);
        }
        root.addChild(styleNode);
        return super.visitStyle(ctx);
    }
    //////////////////////////////////////////////////

    public void printTree(){

        new ListingTreePrinter().print(root);
    }

}
