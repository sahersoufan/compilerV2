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
import generateCode.CodeGeneration;
import generatedGrammers.HTMLParser;
import generatedGrammers.HTMLParserBaseVisitor;
import treePrinter.SimpleTreeNode;
import treePrinter.printer.listing.ListingTreePrinter;

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
    Node node = new Node();
    public Boolean InsideBody = false;
    String javaScript = "E:\\forth year\\1\\CompV2\\src\\JS.js";
    CodeGeneration cg = new CodeGeneration(javaScript);

    // ID
    String id = null;
    List<org.antlr.v4.runtime.misc.Pair<String,Integer>> ids = new ArrayList<>();
    List<String> currentId = new ArrayList<>();
    String finalId;
    @Override
    public Object visitHtmlDocument(HTMLParser.HtmlDocumentContext ctx) {
        HtmlDocument htmlDocument = new HtmlDocument();
        SimpleTreeNode htmlDocumentNode = new SimpleTreeNode("Visit htmlDocument");
        node.setNode(htmlDocumentNode);

        root.addChild(node.getNode());

        cg.start();

        if(!ctx.scriptletOrSeaWs().isEmpty()){
            List<ScriptLetOrSeaWs> ObjscriptletOrSeaWs = new ArrayList<>();
            for (int i =0 ; i <  ctx.scriptletOrSeaWs().size() ; i++){
                ObjscriptletOrSeaWs.add( (ScriptLetOrSeaWs) visitScriptletOrSeaWs(ctx.scriptletOrSeaWs(i)));
                SimpleTreeNode scriptletOrSeaWsNode = new SimpleTreeNode("Visit scriptletOrSeaWs");
                node.setNode(scriptletOrSeaWsNode);
                htmlDocumentNode.addChild(node.getNode());
            }
            htmlDocument.setScriptLetORSeaWs(ObjscriptletOrSeaWs);
        }

        if(ctx.DTD() != null){
            htmlDocument.setDTD(ctx.DTD().getSymbol().getText());
            SimpleTreeNode DTD_Node = new SimpleTreeNode(htmlDocument.getDTD());
            htmlDocumentNode.addChild(DTD_Node);
        }

        if (!ctx.htmlElements().isEmpty()){
            List<HtmlElements> htmlElements = new ArrayList<>();
            for (int i =0 ; i <  ctx.htmlElements().size() ; i++){

                htmlDocumentNode.addChild(addNode("htmlElements"));
                htmlElements.add( (HtmlElements) visitHtmlElements(ctx.htmlElements(i)));

            }
            htmlDocument.setHtmlElements(htmlElements);
        }

        if (ctx.XML() != null){
            htmlDocument.setXML(ctx.XML().getSymbol().getText());

            htmlDocumentNode.addChild(new SimpleTreeNode(htmlDocument.getXML()));
        }

        cg.end();
        return htmlDocument;
    }

    @Override
    public Object visitScriptletOrSeaWs(HTMLParser.ScriptletOrSeaWsContext ctx) {
        ScriptLetOrSeaWs scriptLetOrSeaWs = new ScriptLetOrSeaWs();
        SimpleTreeNode scriptLetOrSeaWsNode = node.getNode();

        if (ctx.SCRIPTLET() != null){

            scriptLetOrSeaWs.setScriptLet(ctx.SCRIPTLET().getSymbol().getText());


        }
        if (ctx.SEA_WS() != null){
            scriptLetOrSeaWsNode.addChild(addNode("SEA_WS"));
            scriptLetOrSeaWs.setSeaWs(ctx.SEA_WS().getSymbol().getText());

        }


        return scriptLetOrSeaWs;
    }


    @Override
    public Object visitHtmlElements(HTMLParser.HtmlElementsContext ctx) {
        HtmlElements htmlElements = new HtmlElements();
        SimpleTreeNode htmlElementsNode = node.getNode();

        if (!ctx.htmlMisc().isEmpty()){
            List<HtmlMisc> htmlMiscs = new ArrayList<>();
            for (int i = 0 ; i < ctx.htmlMisc().size() ; i ++ ){
                htmlElementsNode.addChild(addNode("htmlMisc"));
                htmlMiscs.add((HtmlMisc) visitHtmlMisc(ctx.htmlMisc(i)));
            }
            htmlElements.setMisc(htmlMiscs);
        }

        if (ctx.htmlElement() != null){
            htmlElementsNode.addChild(addNode("htmlElement"));
            htmlElements.setHtmlElement((HtmlElement) visitHtmlElement(ctx.htmlElement()));

        }


        return htmlElements;
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
        SimpleTreeNode htmlElementNode = node.getNode();

        if(!ctx.TAG_NAME().isEmpty()){
                htmlElement.setTagName(ctx.TAG_NAME(0).getSymbol().getText());
                htmlElementNode.addChild( new SimpleTreeNode(ctx.TAG_NAME(0).getSymbol().getText()));
                if (ctx.TAG_NAME(0).getSymbol().getText().equals("body")) {
                    InsideBody = true;
                }

                String tagName = ctx.TAG_NAME(0).getSymbol().getText();
                    currentId.add(tagName);

                    StringBuilder st = new StringBuilder();
                    for (String s : currentId) {
                        st.append(s);
                    }

                    Boolean notEqualAnything = true;
                    if (!ids.isEmpty()) {
                        for (int i = 0; i < ids.size(); i++) {
                            if (ids.get(i).a.equals(st.toString())) {
                                Integer num = ids.get(i).b + 1;
                                ids.remove(i);
                                ids.add(new org.antlr.v4.runtime.misc.Pair<>(st.toString(), num));
                                st.append(num);
                                notEqualAnything = false;
                                break;
                            }
                        }
                        if (notEqualAnything){
                            ids.add(new org.antlr.v4.runtime.misc.Pair<>(st.toString(), 0));
                        }

                    }else{
                        ids.add(new org.antlr.v4.runtime.misc.Pair<>(st.toString(), 0));
                    }

                    finalId = st.toString();
                }

            if (ctx.TAG_SLASH_CLOSE() == null){
                if (ctx.TAG_NAME(1) != null){
                    htmlElement.setTagName2(ctx.TAG_NAME(1).getSymbol().getText());

                    htmlElementNode.addChild(new SimpleTreeNode(ctx.TAG_NAME(1).getSymbol().getText()));
                }

            }

        List<HtmlAttribute> htmlAttributeList = new ArrayList<>();
            Boolean haveId = false;
        if (!ctx.htmlAttribute().isEmpty()) {
            for (int i = 0; i < ctx.htmlAttribute().size(); i++) {
                htmlElementNode.addChild(addNode("htmlAttribute"));
                HtmlAttribute h = (HtmlAttribute) visitHtmlAttribute(ctx.htmlAttribute(i));
                htmlAttributeList.add(h);
                if (h.getTagName() != null) {
                    if (h.getTagName().equals("id")) {
                        haveId = true;
                    }
                }

            }
        }

        if (!haveId){
            HtmlAttribute temp4MakeId = new HtmlAttribute();
            temp4MakeId.setTagName("id");
            temp4MakeId.setAttValue(finalId);
            htmlAttributeList.add(temp4MakeId);
            System.out.println(finalId);
        }
        htmlElement.setHtmlAttributeList(htmlAttributeList);


        if (ctx.htmlContent() != null){
            htmlElementNode.addChild(addNode("htmlContent"));
            htmlElement.setHtmlContent((HtmlContent) visitHtmlContent(ctx.htmlContent()));
        }

        if (ctx.SCRIPTLET() != null){
            htmlElement.setScriptLet(ctx.SCRIPTLET().getSymbol().getText());
            htmlElementNode.addChild(new SimpleTreeNode(htmlElement.getScriptLet()));
        }

        if (ctx.script() != null){
            htmlElementNode.addChild(addNode("script"));
            htmlElement.setScript((Script) visitScript(ctx.script()));
        }

        if (ctx.style() != null){
            htmlElementNode.addChild(addNode("style"));
            htmlElement.setStyle((Style) visitStyle(ctx.style()));
        }
        MustacheExpression me = null;
        if (ctx.mustacheExpression() != null){
            htmlElementNode.addChild(addNode("mustacheExpression"));
            me = (MustacheExpression) visitMustacheExpression(ctx.mustacheExpression());
            htmlElement.setMustacheExpression(me);
        }
/*

        if (InsideBody && !ctx.htmlAttribute().isEmpty()){
                for (HtmlAttribute ha : htmlAttributeList) {
                    if (ha.getAppExpression() != null){
                        cg.dealWithAppExp(htmlAttributeList);
                    }else if (ha.getModelExpression() != null) {
                        cg.dealWIthModel(htmlAttributeList);
                    }else if (ha.getForExpression() != null){
                        System.out.println("cp-for");
                    }else if (ha.getHideExpression() != null){
                        cg.dealWithHide(htmlAttributeList);
                    }else if (ha.getShowExpression() != null){
                        cg.dealWithShow(htmlAttributeList);
                    }else if (ha.getIfExpression() != null){
                        cg.dealWithIf(htmlAttributeList,htmlElement);
                    }else if (ha.getSwitchExpression() != null){
                        cg.dealWithSwitch(htmlAttributeList,htmlElement);
                    }else if (ha.getSwitchCaseExpression() != null){
                        System.out.println("cp-case");
                    }else if (ha.getClick() != null){
                        System.out.println("cp-click");
                    }else if (ha.getDoubleClick() != null){
                        System.out.println("cp-Over");
                    }else if (ha.getTagName() != null){
                        if (ha.getTagName().equals("id")) {
                            id = ha.getAttValue();
                        }
                    }
                }
        }

        if (InsideBody){
            if (me != null){
                cg.dealWithMustacheExp(id,me);
            }
        }
*/

        currentId.remove(currentId.size() - 1);
        return htmlElement;
    }


    @Override
    public Object visitHtmlContent(HTMLParser.HtmlContentContext ctx) {
        ////////this
        // htmlCharData?
        // ((htmlElement | CDATA | htmlComment) htmlChardata?)*
        HtmlContent htmlContent = new HtmlContent();
        SimpleTreeNode htmlContentNode = node.getNode();

        if (!ctx.htmlComment().isEmpty()){
            List<HtmlComment> htmlComments = new ArrayList<>();
            for (int i = 0; i < ctx.htmlComment().size(); i++) {
                htmlContentNode.addChild(addNode("htmlComment"));
                htmlComments.add((HtmlComment) visitHtmlComment(ctx.htmlComment(i)));
            }
            htmlContent.setHtmlComment(htmlComments);
        }

        if (!ctx.CDATA().isEmpty()){
            List<String> cData = new ArrayList<>();
            for (int i = 0; i < ctx.CDATA().size(); i++) {
                htmlContentNode.addChild(new SimpleTreeNode(ctx.CDATA(i).getSymbol().getText()));
                cData.add((String) ctx.CDATA(i).getSymbol().getText());
            }
            htmlContent.setCDATA(cData);
        }

        if (!ctx.htmlChardata().isEmpty()){
            List<HtmlCharData> htmlCharData = new ArrayList<>();
            for (int i = 0; i < ctx.htmlChardata().size(); i++) {
                htmlContentNode.addChild(addNode("htmlChardata"));
                htmlCharData.add((HtmlCharData) visitHtmlChardata(ctx.htmlChardata(i)));
            }
            htmlContent.setHtmlCharData(htmlCharData);
        }

        if (!ctx.htmlElement().isEmpty()){
            List<HtmlElement> htmlElements = new ArrayList<>();
            for (int i = 0; i < ctx.htmlElement().size(); i++) {
                htmlContentNode.addChild(addNode("htmlElement"));
                htmlElements.add((HtmlElement) visitHtmlElement(ctx.htmlElement(i)));
            }
            htmlContent.setHtmlElement(htmlElements);
        }

        return htmlContent;
    }

    @Override
    public Object visitHtmlAttribute(HTMLParser.HtmlAttributeContext ctx) {
        HtmlAttribute htmlAttribute = new HtmlAttribute();
        SimpleTreeNode htmlAttributeNode = node.getNode();


        //app
        if (ctx.appExpression() != null){
            htmlAttributeNode.addChild(addNode("appExpression"));
            htmlAttribute.setAppExpression((AppExpression) visitAppExpression(ctx.appExpression()));
        }
        //for
        if (ctx.forExpression() != null){
            htmlAttributeNode.addChild(addNode("forExpression"));
            htmlAttribute.setForExpression((ForExpression) visitForExpression(ctx.forExpression()));
        }
        //show
        if (ctx.showExpression() != null){
            htmlAttributeNode.addChild(addNode("showExpression"));
            htmlAttribute.setShowExpression((ShowExpression) visitShowExpression(ctx.showExpression()));
        }
        //hide
        if (ctx.hideExpression() != null){
            htmlAttributeNode.addChild(addNode("hideExpression"));
            htmlAttribute.setHideExpression((HideExpression) visitHideExpression(ctx.hideExpression()));
        }
        //switch
        if (ctx.switchExpression() != null){
            htmlAttributeNode.addChild(addNode("switchExpression"));
            htmlAttribute.setSwitchExpression((SwitchExpression) visitSwitchExpression(ctx.switchExpression()));
        }
        //switchCase
        if(ctx.switchCaseExpression() != null){
            htmlAttributeNode.addChild(addNode("switchCaseExpression"));
            htmlAttribute.setSwitchCaseExpression((SwitchCaseExpression) visitSwitchCaseExpression(ctx.switchCaseExpression()));
        }
        //switchDefault // TODO may we need to check it

        //if
        if (ctx.ifExpression() != null){
            htmlAttributeNode.addChild(addNode("ifExpression"));
            htmlAttribute.setIfExpression((IfExpression) visitIfExpression(ctx.ifExpression()));
        }
        //model
        if(ctx.modelExpression() != null){
            htmlAttributeNode.addChild(addNode("modelExpression"));
            htmlAttribute.setModelExpression((ModelExpression) visitModelExpression(ctx.modelExpression()));
        }
        //click
        if (ctx.click() != null){
            htmlAttributeNode.addChild(addNode("click"));
            htmlAttribute.setClick((Click) visitClick(ctx.click()));
        }
        //Over
        if (ctx.doubleClick() != null){
            htmlAttributeNode.addChild(addNode("doubleClick"));
            htmlAttribute.setDoubleClick((DoubleClick) visitDoubleClick(ctx.doubleClick()));
        }
        //generic
        if (ctx.TAG_NAME() != null){
            htmlAttribute.setTagName(ctx.TAG_NAME().getSymbol().getText());
            htmlAttributeNode.addChild(new SimpleTreeNode(ctx.TAG_NAME().getSymbol().getText()));
        }
        if (ctx.ATTVALUE_VALUE() != null){
            htmlAttribute.setAttValue(ctx.ATTVALUE_VALUE().getSymbol().getText());
            htmlAttributeNode.addChild(new SimpleTreeNode(ctx.ATTVALUE_VALUE().getSymbol().getText()));
        }

        return htmlAttribute;
    }

    @Override
    public Object visitHtmlChardata(HTMLParser.HtmlChardataContext ctx) {
        HtmlCharData htmlCharData = new HtmlCharData();
        SimpleTreeNode htmlCharDataNode = node.getNode();
        if (ctx.HTML_TEXT() != null){
            htmlCharData.setHtmlText(ctx.HTML_TEXT().getSymbol().getText());
            htmlCharDataNode.addChild(new SimpleTreeNode(htmlCharData.getHtmlText()));
        }

        if (ctx.SEA_WS() != null){
            htmlCharData.setSeaWs(ctx.SEA_WS().getSymbol().getText());
            htmlCharDataNode.addChild(new SimpleTreeNode(htmlCharData.getSeaWs()));
        }

        return htmlCharData;
    }

    @Override
    public Object visitHtmlMisc(HTMLParser.HtmlMiscContext ctx) {
        HtmlMisc htmlMisc = new HtmlMisc();
        SimpleTreeNode htmlMiscNode = node.getNode();
        if (ctx.htmlComment() != null){
            htmlMiscNode.addChild(addNode("htmlComment"));
            htmlMisc.setHtmlComment((HtmlComment) visitHtmlComment(ctx.htmlComment()));
        }
        if (ctx.SEA_WS() != null){
            htmlMisc.setSeaWs(ctx.SEA_WS().getSymbol().getText());
            htmlMiscNode.addChild(new SimpleTreeNode(htmlMisc.getSeaWs()));
        }
        return htmlMisc;
    }

    @Override
    public Object visitHtmlComment(HTMLParser.HtmlCommentContext ctx) {
        HtmlComment htmlComment = new HtmlComment();
        SimpleTreeNode htmlCommentNode = node.getNode();
        if (ctx.HTML_COMMENT() != null){
            htmlComment.setHtmlComment(ctx.HTML_COMMENT().getSymbol().getText());
            htmlCommentNode.addChild(new SimpleTreeNode(htmlComment.getHtmlComment()));
        }

        if (ctx.HTML_CONDITIONAL_COMMENT() != null){
            htmlComment.setHtmlConditionalComment(ctx.HTML_CONDITIONAL_COMMENT().getSymbol().getText());
            htmlCommentNode.addChild(new SimpleTreeNode(htmlComment.getHtmlConditionalComment()));
        }

        return htmlComment;
    }




    ///////////////////////// FATIMA /////////////////////////
    @Override
    public Object visitAppExpression(HTMLParser.AppExpressionContext ctx) {
        AppExpression appExpression=new AppExpression();
        SimpleTreeNode appExpressionNode = node.getNode();

        if(ctx.collection4App1()!=null){
            appExpressionNode.addChild(addNode("collection4App1"));
            appExpression.setCollection4App1((Collection4App1) visitCollection4App1(ctx.collection4App1()));
        }
        return appExpression;
    }

    @Override
    public Object visitCollection4App1(HTMLParser.Collection4App1Context ctx) {

        Collection4App1 collection4App1=new Collection4App1();
        SimpleTreeNode collection4App1Node = node.getNode();
        //collection4App1 role1
        if(ctx.variable()!=null){
            collection4App1Node.addChild(addNode("variable"));
            collection4App1.setVariable((Variable) visitVariable(ctx.variable()));
        }
        //collection4App1 role2

        if(ctx.subObj()!=null){
            collection4App1Node.addChild(addNode("subObj"));
            collection4App1.setSubObj((SubObj) visitSubObj(ctx.subObj()));
        }
        //collection4App1  role 3
        if(ctx.objArray()!=null){
            collection4App1Node.addChild(addNode("objArray"));
            collection4App1.setObjArray((ObjArray) visitObjArray(ctx.objArray()));
        }

        //collection4App1  role 4
        if(ctx.functionCall()!=null){
            collection4App1Node.addChild(addNode("functionCall"));
            collection4App1.setFunctionCall((FunctionCall) visitFunctionCall(ctx.functionCall()));
        }

        //collection4App1  role 5
        if(ctx.oneLine4AppCondition()!=null){
            collection4App1Node.addChild(addNode("oneLine4AppCondition"));
        collection4App1.setOneLine4AppCondition((OneLine4AppCondition) visitOneLine4AppCondition(ctx.oneLine4AppCondition()));
    }

        return collection4App1;
    }

    @Override
    public Object visitOneLine4AppCondition(HTMLParser.OneLine4AppConditionContext ctx) {

        OneLine4AppCondition  oneLine4AppCondition=new OneLine4AppCondition();
        SimpleTreeNode oneLine4AppConditionNode = node.getNode();

        if(ctx.logicComprison()!=null&& ctx.collection4App1()!=null){
            oneLine4AppConditionNode.addChild(addNode("logicComprison"));
            oneLine4AppCondition.setLogicComprison((LogicComprison) visitLogicComprison(ctx.logicComprison()));

            oneLine4AppConditionNode.addChild(addNode("Collection4App1_1"));
            oneLine4AppCondition.setCollection4App1_1((Collection4App1) visitCollection4App1(ctx.collection4App1(0)));

            oneLine4AppConditionNode.addChild(addNode("Collection4App1_2"));
            oneLine4AppCondition.setCollection4App1_2((Collection4App1) visitCollection4App1(ctx.collection4App1(1)));
        }
        return oneLine4AppCondition;
    }


    ////////////////////// forExpression ////////////////////////
    @Override
    public Object visitForExpression(HTMLParser.ForExpressionContext ctx) {
       ForExpression forExpression=new ForExpression();
       SimpleTreeNode forExpressionNode = node.getNode();

       //For CpExpression role 1
       if(ctx.collection4For1()!=null&& ctx.collection4For2()!=null){
           forExpressionNode.addChild(addNode("collection4For1"));
           forExpression.setCollection4For1_1_1((Collection4For1) visitCollection4For1(ctx.collection4For1(0)));

           //
           forExpressionNode.addChild(addNode("Collection4For2_1_1"));
           forExpression.setCollection4For2_1_1((Collection4For2) visitCollection4For2(ctx.collection4For2()));

          if(ctx.collection4For1().size()>1){
              forExpressionNode.addChild(addNode("Collection4For1_1_2"));
              forExpression.setCollection4For1_1_2((Collection4For1) visitCollection4For1(ctx.collection4For1(1)));

          }

       }

       //For CpExpression role 2
        if(ctx.collection4For1()!=null&& ctx.collection4For3()!=null){
            forExpressionNode.addChild(addNode("collection4For1"));
            forExpression.setCollection4For1_2_1((Collection4For1) visitCollection4For1(ctx.collection4For1(0)));

            //
            forExpressionNode.addChild(addNode("Collection4For1_2_2"));
            forExpression.setCollection4For1_2_2((Collection4For1) visitCollection4For1(ctx.collection4For1(1)));

            //
            forExpressionNode.addChild(addNode("Collection4For3_2_1"));
            forExpression.setCollection4For3_2_1((Collection4For3) visitCollection4For3(ctx.collection4For3()));

        }

        //For CpExpression role 3
        if(ctx.collection4For4()!=null){
            forExpressionNode.addChild(addNode("collection4For4"));
            forExpression.setCollection4For4_3_1((Collection4For4) visitCollection4For4(ctx.collection4For4()));
        }


        return forExpression;
    }

    @Override
    public Object visitCollection4For1(HTMLParser.Collection4For1Context ctx) {

      Collection4For1 collection4For1=new Collection4For1();
      SimpleTreeNode collection4For1Node = node.getNode();

      //Collection4For1  role 1
      if(ctx.variable()!=null){
          collection4For1Node.addChild(addNode("variable"));
          collection4For1.setVariable((Variable) visitVariable(ctx.variable()));
      }
      //Collection4For1  role 2
      if(ctx.subObj()!=null){
          collection4For1Node.addChild(addNode("subObj"));
          collection4For1.setSubObj((SubObj) visitSubObj(ctx.subObj()));
      }
      //Collection4For1  role 3
      if(ctx.objArray()!=null){
          collection4For1Node.addChild(addNode("objArray"));
          collection4For1.setObjArray((ObjArray) visitObjArray(ctx.objArray()));
      }

        return collection4For1;
    }

    @Override
    public Object visitCollection4For2(HTMLParser.Collection4For2Context ctx) {
       Collection4For2 collection4For2=new Collection4For2();
       SimpleTreeNode collection4For2Node = node.getNode();

        //Collection4For2  role 1

        if(ctx.variable()!=null){
            collection4For2Node.addChild(addNode("variable"));
            collection4For2.setVariable((Variable) visitVariable(ctx.variable()));
        }
        //Collection4For2  role 2

        if(ctx.CP_CONTENT_STRING()!=null){
            collection4For2.setString(ctx.CP_CONTENT_STRING().getSymbol().getText());
            collection4For2Node.addChild(new SimpleTreeNode(collection4For2.getString()));
        }
        //Collection4For2  role 3
        if(ctx.number()!=null){
            collection4For2Node.addChild(addNode("number"));
            collection4For2.setNumber((NUmber) visitNumber(ctx.number()));
        }
        //Collection4For2  role 4
        if(ctx.subObj()!=null){
            collection4For2Node.addChild(addNode("subObj"));
            collection4For2.setSubObj((SubObj) visitSubObj(ctx.subObj()));
        }
        //Collection4For2  role 5
        if(ctx.objArray()!=null){
            collection4For2Node.addChild(addNode("objArray"));
            collection4For2.setObjArray((ObjArray) visitObjArray(ctx.objArray()));
        }

        //Collection4For2  role 6
        if(ctx.array()!=null){
            collection4For2Node.addChild(addNode("array"));
            collection4For2.setArray((Array) visitArray(ctx.array()));
        }

        //Collection4For2  role 7
        if(ctx.functionCall()!=null){
            collection4For2Node.addChild(addNode("functionCall"));
            collection4For2.setFunctionCall((FunctionCall) visitFunctionCall(ctx.functionCall()));
        }

        //Collection4For2  role 8
        if(ctx.oneLine4For2Condition()!=null){
            collection4For2Node.addChild(addNode("oneLine4For2Condition"));
            collection4For2.setOneLine4For2Condition((OneLine4For2Condition) visitOneLine4For2Condition(ctx.oneLine4For2Condition()));
        }

        //Collection4For2  role 9
        if(ctx.arithmeticLogic()!=null){
            collection4For2Node.addChild(addNode("arithmeticLogic"));
            collection4For2.setArithmeticLogic((ArithmeticLogic) visitArithmeticLogic(ctx.arithmeticLogic()));
        }


        return collection4For2;
    }

    @Override
    public Object visitOneLine4For2Condition(HTMLParser.OneLine4For2ConditionContext ctx) {

        // ex: (true && (a<b ?true :false ) && !c ? b : b)

        OneLine4For2Condition oneLine4For2Condition=new OneLine4For2Condition();
        SimpleTreeNode oneLine4For2ConditionNode = node.getNode();

        oneLine4For2Condition.setOpenPar(ctx.CP_CONTENT_OPEN_PAR().getSymbol().getText());
        oneLine4For2ConditionNode.addChild(new SimpleTreeNode(oneLine4For2Condition.getOpenPar()));

           if(ctx.logicComprison()!=null&& ctx.collection4For2()!=null){
               oneLine4For2ConditionNode.addChild(addNode("logicComprison"));
               oneLine4For2Condition.setLogicComprison((LogicComprison) visitLogicComprison(ctx.logicComprison()));

               //
               oneLine4For2ConditionNode.addChild(addNode("Collection4For2_1_1"));
               oneLine4For2Condition.setCollection4For2_1_1((Collection4For2) visitCollection4For2(ctx.collection4For2(0)));

               //
               oneLine4For2ConditionNode.addChild(addNode("Collection4For2_1_2"));
               oneLine4For2Condition.setCollection4For2_1_2((Collection4For2) visitCollection4For2(ctx.collection4For2(1)));
           }


        return oneLine4For2Condition;
    }

    @Override
    public Object visitCollection4For3(HTMLParser.Collection4For3Context ctx) {
       Collection4For3 collection4For3=new Collection4For3();
       SimpleTreeNode collection4For3Node = node.getNode();

       //Collection4For3 role 1
        if(ctx.obj()!=null){
            collection4For3Node.addChild(addNode("obj"));
            collection4For3.setObj((Obj) visitObj(ctx.obj()));
        }

        //Collection4For3 role 2
        if(ctx.objBody()!=null){
            collection4For3Node.addChild(addNode("objBody"));
            collection4For3.setObjBody((ObjBody)visitObjBody(ctx.objBody()));
        }

        //Collection4For3 role 3
        if(ctx.subObj()!=null){
            collection4For3Node.addChild(addNode("subObj"));
            collection4For3.setSubObj((SubObj) visitSubObj(ctx.subObj()));
        }

        //Collection4For3 role 4
        if(ctx.objArray()!=null){
            collection4For3Node.addChild(addNode("objArray"));
            collection4For3.setObjArray((ObjArray) visitObjArray(ctx.objArray()));
        }

        //Collection4For3 role 5
        if(ctx.functionCall()!=null){
            collection4For3Node.addChild(addNode("functionCall"));
            collection4For3.setFunctionCall((FunctionCall) visitFunctionCall(ctx.functionCall()));
        }

        //Collection4For3 role 6
        if(ctx.oneLine4For3Condition()!=null){
            collection4For3Node.addChild(addNode("oneLine4For3Condition"));
            collection4For3.setOneLine4For3Condition((OneLine4For3Condition) visitOneLine4For3Condition(ctx.oneLine4For3Condition()));
        }
        return collection4For3;
    }

    @Override
    public Object visitOneLine4For3Condition(HTMLParser.OneLine4For3ConditionContext ctx) {

        OneLine4For3Condition oneLine4For3Condition=new OneLine4For3Condition();
        SimpleTreeNode oneLine4For3ConditionNode = node.getNode();


            if(ctx.logicComprison()!=null&& ctx.collection4For3()!=null) {
                oneLine4For3ConditionNode.addChild(addNode("logicComprison"));
                oneLine4For3Condition.setLogicComprison((LogicComprison) visitLogicComprison(ctx.logicComprison()));

                //

                oneLine4For3ConditionNode.addChild(addNode("Collection4For3_1_1"));
                oneLine4For3Condition.setCollection4For3_1_1((Collection4For3) visitCollection4For3(ctx.collection4For3(0)));

                //

                oneLine4For3ConditionNode.addChild(addNode("Collection4For3_1_2"));
                oneLine4For3Condition.setCollection4For3_1_2((Collection4For3) visitCollection4For3(ctx.collection4For3(1)));

            }
        return oneLine4For3Condition;
    }

    @Override
    public Object visitCollection4For4(HTMLParser.Collection4For4Context ctx) {

        Collection4For4 collection4For4=new Collection4For4();
        SimpleTreeNode collection4For4Node = node.getNode();

        //Collection4For4 role 1
        if(ctx.variable()!=null){
            collection4For4Node.addChild(addNode("variable"));
            collection4For4.setVariable((Variable) visitVariable(ctx.variable()));
        }

        //Collection4For4 role 2
        if(ctx.number()!=null){
            collection4For4Node.addChild(addNode("number"));
            collection4For4.setNumber((NUmber) visitNumber(ctx.number()));
        }

        //Collection4For4 role 3
        if(ctx.trueOrFalse()!=null){
            collection4For4Node.addChild(addNode("trueOrFalse"));
            collection4For4.setTrueOrFalse((TrueOrFalse) visitTrueOrFalse(ctx.trueOrFalse()));
        }

        //Collection4For4 role 4
        if(ctx.objArray()!=null){
            collection4For4Node.addChild(addNode("objArray"));
            collection4For4.setObjArray((ObjArray) visitObjArray(ctx.objArray()));
        }

        //Collection4For4 role 5
        if(ctx.functionCall()!=null){
            collection4For4Node.addChild(addNode("functionCall"));
            collection4For4.setFunctionCall((FunctionCall) visitFunctionCall(ctx.functionCall()));
        }

        //Collection4For4 role 6
        if(ctx.subObj()!=null){
            collection4For4Node.addChild(addNode("subObj"));
            collection4For4.setSubObj((SubObj) visitSubObj(ctx.subObj()));
        }

        //Collection4For4 role 7
        if(ctx.comparisonExpression()!=null){
            collection4For4Node.addChild(addNode("comparisonExpression"));
            collection4For4.setComparisonExpression((ComparisonExpression) visitComparisonExpression(ctx.comparisonExpression()));
        }

        //Collection4For4 role 8
        if(ctx.oneLine4For4Condition()!=null){
            collection4For4Node.addChild(addNode("oneLine4For4Condition"));
            collection4For4.setOneLine4For4Condition((OneLine4For4Condition) visitOneLine4For4Condition(ctx.oneLine4For4Condition()));
        }

        //Collection4For4 role 9
        if(ctx.logicComprison()!=null){
            collection4For4Node.addChild(addNode("logicComprison"));
            collection4For4.setLogicComprison((LogicComprison) visitLogicComprison(ctx.logicComprison()));
        }

        //Collection4For4 role 10
        if(ctx.arithmeticLogic()!=null){
            collection4For4Node.addChild(addNode("arithmeticLogic"));
            collection4For4.setArithmeticLogic((ArithmeticLogic) visitArithmeticLogic(ctx.arithmeticLogic()));
        }
        return collection4For4;
    }

    @Override
    public Object visitOneLine4For4Condition(HTMLParser.OneLine4For4ConditionContext ctx) {

        OneLine4For4Condition oneLine4For4Condition = new OneLine4For4Condition();
        SimpleTreeNode oneLine4For4ConditionNode = node.getNode();


            if (ctx.logicComprison() != null && ctx.collection4For4() != null) {
                oneLine4For4ConditionNode.addChild(addNode("logicComprison"));
                oneLine4For4Condition.setLogicComprison((LogicComprison) visitLogicComprison(ctx.logicComprison()));

                //

                oneLine4For4ConditionNode.addChild(addNode("Collection4For4_1_1"));
                oneLine4For4Condition.setCollection4For4_1_1((Collection4For4) visitCollection4For4(ctx.collection4For4(0)));

                //

                oneLine4For4ConditionNode.addChild(addNode("Collection4For4_1_2"));
                oneLine4For4Condition.setCollection4For4_1_2((Collection4For4) visitCollection4For4(ctx.collection4For4(1)));

            }
        return oneLine4For4Condition;
    }

   /////////////////////////// end forexprition ///////////////////////////

    /////////////////////////// show exprition ///////////////////////////
    @Override
    public Object visitShowExpression(HTMLParser.ShowExpressionContext ctx) {

        ShowExpression showExpression=new ShowExpression();
        SimpleTreeNode showExpressionNode = node.getNode();
        if(ctx.logicComprison()!=null){
            showExpressionNode.addChild(addNode("logicComprison"));
            showExpression.setLogicComprison((LogicComprison) visitLogicComprison(ctx.logicComprison()));
        }
        return showExpression;
    }
    /////////////////////////// end show exprition ///////////////////////////

    ///////////////////////////  Hide exprition ///////////////////////////
    @Override
    public Object visitHideExpression(HTMLParser.HideExpressionContext ctx) {
        HideExpression hideExpression=new HideExpression();
        SimpleTreeNode hideExpressionNode = node.getNode();

        if(ctx.logicComprison()!=null){
            hideExpressionNode.addChild(addNode("logicComprison"));
            hideExpression.setLogicComprison((LogicComprison) visitLogicComprison(ctx.logicComprison()));
        }
        return hideExpression;
    }

    ///////////////////////////  end Hide exprition ///////////////////////////


    ///////////////////////////  Switch exprition ///////////////////////////
    @Override
    public Object visitSwitchExpression(HTMLParser.SwitchExpressionContext ctx) {
      SwitchExpression switchExpression=new SwitchExpression();
      SimpleTreeNode switchExpressionNode = node.getNode();

      if(ctx.collection4Switch1()!=null){
          switchExpressionNode.addChild(addNode("collection4Switch1"));
          switchExpression.setCollection4Switch1((Collection4Switch1) visitCollection4Switch1(ctx.collection4Switch1()));
      }

        return switchExpression;
    }

    @Override
    public Object visitSwitchCaseExpression(HTMLParser.SwitchCaseExpressionContext ctx) {

        SwitchCaseExpression switchCaseExpression=new SwitchCaseExpression();
        SimpleTreeNode switchCaseExpressionNode = node.getNode();

        if(ctx.collection4Switch1()!=null){
            switchCaseExpressionNode.addChild(addNode("collection4Switch1"));
            switchCaseExpression.setCollection4Switch1((Collection4Switch1) visitCollection4Switch1(ctx.collection4Switch1()));
        }

        return switchCaseExpression;
    }

    @Override
    public Object visitCollection4Switch1(HTMLParser.Collection4Switch1Context ctx) {

        Collection4Switch1 collection4Switch1=new Collection4Switch1();
        SimpleTreeNode collection4Switch1Node = node.getNode();


        //Collection4Switch1  role 1

        if(ctx.variable()!=null){
            collection4Switch1Node.addChild(addNode("variable"));
            collection4Switch1.setVariable((Variable) visitVariable(ctx.variable()));
        }
        //Collection4Switch1  role 2

        if(ctx.CP_CONTENT_STRING()!=null){
            collection4Switch1.setString(ctx.CP_CONTENT_STRING().getSymbol().getText());
            collection4Switch1Node.addChild(new SimpleTreeNode(collection4Switch1.getString()));
        }
        //Collection4Switch1  role 3
        if(ctx.number()!=null){
            collection4Switch1Node.addChild(addNode("number"));
            collection4Switch1.setNumber((NUmber) visitNumber(ctx.number()));
        }
        //Collection4Switch1  role 4
        if(ctx.subObj()!=null){
            collection4Switch1Node.addChild(addNode("subObj"));
            collection4Switch1.setSubObj((SubObj) visitSubObj(ctx.subObj()));
        }
        //Collection4Switch1  role 5
        if(ctx.objArray()!=null){
            collection4Switch1Node.addChild(addNode("objArray"));
            collection4Switch1.setObjArray((ObjArray) visitObjArray(ctx.objArray()));
        }

        //Collection4Switch1  role 6
        if(ctx.oneLine4switch1()!=null){
            collection4Switch1Node.addChild(addNode("oneLine4switch1"));
            collection4Switch1.setOneLine4switch1((OneLine4switch1) visitOneLine4switch1(ctx.oneLine4switch1()));
        }

        //Collection4Switch1  role 7
        if(ctx.arithmeticLogic()!=null){
            collection4Switch1Node.addChild(addNode("arithmeticLogic"));
            collection4Switch1.setArithmeticLogic((ArithmeticLogic) visitArithmeticLogic(ctx.arithmeticLogic()));
        }

        return collection4Switch1;
    }

    @Override
    public Object visitOneLine4switch1(HTMLParser.OneLine4switch1Context ctx) {

        OneLine4switch1  oneLine4switch1=new OneLine4switch1 ();
        SimpleTreeNode oneLine4switch1Node = node.getNode();

        if(ctx.logicComprison()!=null&& ctx.collection4Switch1()!=null){
            oneLine4switch1Node.addChild(addNode("logicComprison"));
            oneLine4switch1.setLogicComprison((LogicComprison) visitLogicComprison(ctx.logicComprison()));

            //

            oneLine4switch1Node.addChild(addNode("Collection4Switch1_1_1"));
            oneLine4switch1.setCollection4Switch1_1_1((Collection4Switch1) visitCollection4Switch1(ctx.collection4Switch1(0)));

            //

            oneLine4switch1Node.addChild(addNode("Collection4Switch1_1_2"));
            oneLine4switch1.setCollection4Switch1_1_2((Collection4Switch1) visitCollection4Switch1(ctx.collection4Switch1(1)));
        }
        return oneLine4switch1;
    }

    ///////////////////////////   End Switch exprition ///////////////////////////

    ///////////////////////////  If exprition ///////////////////////////

    @Override
    public Object visitIfExpression(HTMLParser.IfExpressionContext ctx) {

        IfExpression ifExpression =new IfExpression();
        SimpleTreeNode ifExpressionNode = node.getNode();

      if(ctx.logicComprison()!=null){
          ifExpressionNode.addChild(addNode("logicComprison"));
          ifExpression.setLogicComprison((LogicComprison) visitLogicComprison(ctx.logicComprison()));
      }

        return ifExpression;
    }

    ///////////////////////////  end If exprition ///////////////////////////

    ///////////////////////////  Model exprition ///////////////////////////
    @Override
    public Object visitModelExpression(HTMLParser.ModelExpressionContext ctx) {

        ModelExpression modelExpression =new ModelExpression();
        SimpleTreeNode modelExpressionNode  = node.getNode();

        if(ctx.collection4Model1()!=null){
            modelExpressionNode.addChild(addNode("collection4Model1"));
            modelExpression.setCollection4Model1((Collection4Model1) visitCollection4Model1(ctx.collection4Model1()));
        }
        return modelExpression;
    }

    @Override
    public Object visitCollection4Model1(HTMLParser.Collection4Model1Context ctx) {

       Collection4Model1 collection4Model1=new Collection4Model1();
       SimpleTreeNode collection4Model1Node = node.getNode();

        //Collection4Model1 role 1
        if(ctx.variable()!=null){
            collection4Model1Node.addChild(addNode("variable"));
            collection4Model1.setVariable((Variable) visitVariable(ctx.variable()));
        }


        //Collection4Model1 role 2
        if(ctx.objArray()!=null){
            collection4Model1Node.addChild(addNode("objArray"));
            collection4Model1.setObjArray((ObjArray) visitObjArray(ctx.objArray()));
        }

        //Collection4Model1 role 3
        if(ctx.functionCall()!=null){
            collection4Model1Node.addChild(addNode("functionCall"));
            collection4Model1.setFunctionCall((FunctionCall) visitFunctionCall(ctx.functionCall()));
        }

        //Collection4Model1 role 4
        if(ctx.subObj()!=null){
            collection4Model1Node.addChild(addNode("subObj"));
            collection4Model1.setSubObj((SubObj) visitSubObj(ctx.subObj()));
        }

        //Collection4Model1 role 5
        if(ctx.oneLine4ModelCondition()!=null){
            collection4Model1Node.addChild(addNode("oneLine4ModelCondition"));
            collection4Model1.setOneLine4ModelCondition((OneLine4ModelCondition) visitOneLine4ModelCondition(ctx.oneLine4ModelCondition()));
        }

        return collection4Model1;
    }

    @Override
    public Object visitOneLine4ModelCondition(HTMLParser.OneLine4ModelConditionContext ctx) {

        OneLine4ModelCondition oneLine4ModelCondition=new OneLine4ModelCondition();
        SimpleTreeNode oneLine4ModelConditionNode = node.getNode();

        if(ctx.logicComprison()!=null&& ctx.collection4Model1()!=null){
            oneLine4ModelConditionNode.addChild(addNode("logicComprison"));
            oneLine4ModelCondition.setLogicComprison((LogicComprison) visitLogicComprison(ctx.logicComprison()));

            //

            oneLine4ModelConditionNode.addChild(addNode("Collection4Model1_1_1"));
            oneLine4ModelCondition.setCollection4Model1_1_1((Collection4Model1) visitCollection4Model1(ctx.collection4Model1(0)));

            //

            oneLine4ModelConditionNode.addChild(addNode("Collection4Model1_1_2"));
            oneLine4ModelCondition.setCollection4Model1_1_2((Collection4Model1) visitCollection4Model1(ctx.collection4Model1(1)));
        }
        return oneLine4ModelCondition;
    }
    /////////////////////////// End  Model exprition ///////////////////////////

    ///////////////////////////  Annotation exprition ///////////////////////////


    @Override
    public Object visitClick(HTMLParser.ClickContext ctx) {
        Click click = new Click();
        SimpleTreeNode clickExpressionNode = node.getNode();

        if(ctx.collection4Annotation()!=null){
            clickExpressionNode.addChild(addNode("collection4Annotation"));
            click.setCollection4Annotation((Collection4Annotation) visitCollection4Annotation(ctx.collection4Annotation()));
        }
        return click;
    }

    @Override
    public Object visitDoubleClick(HTMLParser.DoubleClickContext ctx) {
        DoubleClick doubleClick = new DoubleClick();
        SimpleTreeNode clickExpressionNode = node.getNode();

        if(ctx.collection4Annotation()!=null){
            clickExpressionNode.addChild(addNode("collection4Annotation"));
            doubleClick.setCollection4Annotation((Collection4Annotation) visitCollection4Annotation(ctx.collection4Annotation()));
        }
        return doubleClick;
    }

    @Override
    public Object visitCollection4Annotation(HTMLParser.Collection4AnnotationContext ctx) {
        Collection4Annotation collection4Annotation =new Collection4Annotation();
        SimpleTreeNode collection4AnnotationNode = node.getNode();

        if(ctx.functionCall4AnnotOneLine()!=null){
            collection4AnnotationNode.addChild(addNode("functionCall4AnnotOneLine"));
            collection4Annotation.setFunctionCall4AnnotOneLine((FunctionCall4AnnotOneLine) visitFunctionCall4AnnotOneLine(ctx.functionCall4AnnotOneLine()));
        }

        if(ctx.arrName()!=null && ctx.arrayFuncRet4AnnotOneLine()!=null){
            collection4AnnotationNode.addChild(addNode("arrName"));
            collection4Annotation.setArrName((ArrName) visitArrName(ctx.arrName()));

            //

            collection4AnnotationNode.addChild(addNode("ArrayFuncRet4AnnotOneLine"));
            collection4Annotation.setArrayFuncRet4AnnotOneLine((ArrayFuncRet4AnnotOneLine) visitFunctionCall4AnnotOneLine(ctx.functionCall4AnnotOneLine()));
        }

        if(ctx.obj()!=null && ctx.propFuncRet4AnnotOneLine()!=null){
            collection4AnnotationNode.addChild(addNode("obj"));
            collection4Annotation.setPropFuncRet4AnnotOneLine((PropFuncRet4AnnotOneLine) visitPropFuncRet4AnnotOneLine(ctx.propFuncRet4AnnotOneLine()));

            //

            collection4AnnotationNode.addChild(addNode("propFuncRet4AnnotOneLine"));
            collection4Annotation.setObj((Obj) visitObj(ctx.obj()));
        }

        if(ctx.oneLine4Annotation()!=null){
            collection4AnnotationNode.addChild(addNode("oneLine4Annotation"));
            collection4Annotation.setOneLine4Annotation((OneLine4Annotation) visitOneLine4Annotation(ctx.oneLine4Annotation()));
        }

        return collection4Annotation;
    }

    @Override
    public Object visitOneLine4Annotation(HTMLParser.OneLine4AnnotationContext ctx) {

          OneLine4Annotation oneLine4Annotation=new OneLine4Annotation();
          SimpleTreeNode oneLine4AnnotationNode = node.getNode();

        if(ctx.logicComprison()!=null&& ctx.collection4Annotation()!=null){
            oneLine4AnnotationNode.addChild(addNode("logicComprison"));
            oneLine4Annotation.setLogicComprison((LogicComprison) visitLogicComprison(ctx.logicComprison()));

            //

            oneLine4AnnotationNode.addChild(addNode("Collection4Annotation1_1"));
            oneLine4Annotation.setCollection4Annotation1_1((Collection4Annotation) visitCollection4Annotation(ctx.collection4Annotation(0)));

            //

            oneLine4AnnotationNode.addChild(addNode("Collection4Annotation1_2"));
            oneLine4Annotation.setCollection4Annotation1_2((Collection4Annotation) visitCollection4Annotation(ctx.collection4Annotation(1)));
        }
        return oneLine4Annotation;
    }

    @Override
    public Object visitFunctionCall4AnnotOneLine(HTMLParser.FunctionCall4AnnotOneLineContext ctx) {

       FunctionCall4AnnotOneLine functionCall4AnnotOneLine=new FunctionCall4AnnotOneLine();
       SimpleTreeNode functionCall4AnnotOneLineNode = node.getNode();

       if(ctx.funcEndRet4AnnotOneLine()!=null&&ctx.functionName()!=null){
           functionCall4AnnotOneLineNode.addChild(addNode("funcEndRet4AnnotOneLine"));
           functionCall4AnnotOneLine.setFuncEndRet4AnnotOneLine((FuncEndRet4AnnotOneLine) visitFuncEndRet4AnnotOneLine(ctx.funcEndRet4AnnotOneLine()));

           //

           functionCall4AnnotOneLineNode.addChild(addNode("functionName"));
           functionCall4AnnotOneLine.setFunctionName((FunctionName) visitFunctionName(ctx.functionName()));
       }
        return functionCall4AnnotOneLine;
    }

    @Override
    public Object visitArrayFuncRet4AnnotOneLine(HTMLParser.ArrayFuncRet4AnnotOneLineContext ctx) {

        ArrayFuncRet4AnnotOneLine arrayFuncRet4AnnotOneLine=new ArrayFuncRet4AnnotOneLine();
        SimpleTreeNode arrayFuncRet4AnnotOneLineNode = node.getNode();


        if(ctx.arithmeticLogic()!=null){
            List <ArithmeticLogic> arithmeticLogics=new ArrayList<>();
            for(int i=0;i<ctx.arithmeticLogic().size();i++){
                arrayFuncRet4AnnotOneLineNode.addChild(addNode("arithmeticLogic"));
                arithmeticLogics.add((ArithmeticLogic) visitArithmeticLogic(ctx.arithmeticLogic(i)));
            }
            arrayFuncRet4AnnotOneLine.setArithmeticLogics(arithmeticLogics);
        }


        if(ctx.propFuncRet4AnnotOneLine()!=null) {
            arrayFuncRet4AnnotOneLineNode.addChild(addNode("propFuncRet4AnnotOneLine"));
            arrayFuncRet4AnnotOneLine.setPropFuncRet4AnnotOneLine((PropFuncRet4AnnotOneLine) visitPropFuncRet4AnnotOneLine(ctx.propFuncRet4AnnotOneLine()));

        }
        if(ctx.funcEndRet4AnnotOneLine()!=null){
            arrayFuncRet4AnnotOneLineNode.addChild(addNode("funcEndRet4AnnotOneLine"));
            arrayFuncRet4AnnotOneLine.setFuncEndRet4AnnotOneLine((FuncEndRet4AnnotOneLine) visitFuncEndRet4AnnotOneLine(ctx.funcEndRet4AnnotOneLine()));
        }


        return arrayFuncRet4AnnotOneLine;
    }

    @Override
    public Object visitPropFuncRet4AnnotOneLine(HTMLParser.PropFuncRet4AnnotOneLineContext ctx) {
       PropFuncRet4AnnotOneLine propFuncRet4AnnotOneLine=new PropFuncRet4AnnotOneLine();
       SimpleTreeNode propFuncRet4AnnotOneLineNode = node.getNode();


       if(ctx.propertyValue()!=null){
           List <PropertyValue>propertyValues=new ArrayList<>();
           for(int i=0;i<ctx.propertyValue().size();i++){
               propFuncRet4AnnotOneLineNode.addChild(addNode("propertyValue"));
               propertyValues.add((PropertyValue) visitPropertyValue(ctx.propertyValue(i)));
           }
           propFuncRet4AnnotOneLine.setPropertyValue(propertyValues);
       }


       if(ctx.arrayFuncRet4AnnotOneLine()!=null){
           propFuncRet4AnnotOneLineNode.addChild(addNode("arrayFuncRet4AnnotOneLine"));
           propFuncRet4AnnotOneLine.setArrayFuncRet4AnnotOneLine((ArrayFuncRet4AnnotOneLine) visitArrayFuncRet4AnnotOneLine(ctx.arrayFuncRet4AnnotOneLine()));

       }
       if(ctx.funcEndRet4AnnotOneLine()!=null){
           propFuncRet4AnnotOneLineNode.addChild(addNode("funcEndRet4AnnotOneLine"));
            propFuncRet4AnnotOneLine.setFuncEndRet4AnnotOneLine((FuncEndRet4AnnotOneLine) visitFuncEndRet4AnnotOneLine(ctx.funcEndRet4AnnotOneLine()));


       }

        return propFuncRet4AnnotOneLine;
    }

    @Override
    public Object visitFuncEndRet4AnnotOneLine(HTMLParser.FuncEndRet4AnnotOneLineContext ctx) {

         FuncEndRet4AnnotOneLine funcEndRet4AnnotOneLine=new FuncEndRet4AnnotOneLine();
         SimpleTreeNode funcEndRet4AnnotOneLineNode = node.getNode();


         if(ctx.parameters()!=null){
             List<Parameters>parameters=new ArrayList<>();
             for(int i=0;i<ctx.parameters().size();i++){
                 funcEndRet4AnnotOneLineNode.addChild(addNode("parameters"));
                 parameters.add((Parameters)visitParameters(ctx.parameters(i)));
             }
             funcEndRet4AnnotOneLine.setFunctionParameters(parameters);
         }


        if(ctx.arrayFuncRet4AnnotOneLine()!=null){
            funcEndRet4AnnotOneLineNode.addChild(addNode("arrayFuncRet4AnnotOneLine"));
            funcEndRet4AnnotOneLine.setArrayFuncRet4AnnotOneLine((ArrayFuncRet4AnnotOneLine) visitArrayFuncRet4AnnotOneLine(ctx.arrayFuncRet4AnnotOneLine()));

        }if(ctx.propFuncRet4AnnotOneLine()!=null){
            funcEndRet4AnnotOneLineNode.addChild(addNode("propFuncRet4AnnotOneLine"));
             funcEndRet4AnnotOneLine.setPropFuncRet4AnnotOneLine((PropFuncRet4AnnotOneLine) visitPropFuncRet4AnnotOneLine(ctx.propFuncRet4AnnotOneLine()));

         }

        return funcEndRet4AnnotOneLine;
    }


    //////////////////////////////////////////////////




    ///////////////////////// MAYAR /////////////////////////

    @Override
    public Object visitVariable(HTMLParser.VariableContext ctx) {
        //: variableName
        Variable variable = new Variable();
        SimpleTreeNode variableNode = node.getNode();



        if (ctx.variableName() != null){

            variableNode.addChild(addNode("variableName"));
            variable.setVariableName((VariableName) visitVariableName(ctx.variableName()));
        }

        return variable;
    }

    @Override
    public Object visitVariableName(HTMLParser.VariableNameContext ctx) {
        //: CP_CONTENT_IDENTIFIER
        VariableName variableName = new VariableName();
        SimpleTreeNode variableNameNode =node.getNode();

        if (ctx.CP_CONTENT_IDENTIFIER() != null){
            variableName.setIdentifier(ctx.CP_CONTENT_IDENTIFIER().getSymbol().getText());
            variableNameNode.addChild(new SimpleTreeNode(variableName.getIdentifier()));
        }

        return variableName;
    }

    @Override
    public Object visitNumber(HTMLParser.NumberContext ctx) {
//        : CP_CONTENT_NUMBER
        NUmber nUmber = new NUmber();
        SimpleTreeNode nUmberNode = node.getNode();

        if (ctx.CP_CONTENT_NUMBER() != null) {
            // TODO i don't know if this is right or not
            double numberType = Double.parseDouble(ctx.CP_CONTENT_NUMBER().getSymbol().getText());
            // For check what's the type of Number
            if (numberType == (int) numberType) {
                nUmber.setNumber(Integer.parseInt(ctx.CP_CONTENT_NUMBER().getSymbol().getText()));
                nUmberNode.addChild(new SimpleTreeNode(nUmber.getNumber().toString()));
            }
            else if (numberType == (float)numberType){
                nUmber.setNumber(Float.parseFloat(ctx
                .CP_CONTENT_NUMBER().getSymbol().getText()));
                nUmberNode.addChild(new SimpleTreeNode(nUmber.getNumber().toString()));
            }
            else{
                nUmber.setNumber(Double.parseDouble(ctx.CP_CONTENT_NUMBER().getSymbol().getText()));
                nUmberNode.addChild(new SimpleTreeNode(nUmber.getNumber().toString()));
            }
        }

        return nUmber;
    }

    @Override
    public Object visitTrueOrFalse(HTMLParser.TrueOrFalseContext ctx) {
//        :  (CP_CONTENT_TRUE | CP_CONTENT_FALSE)
        TrueOrFalse trueOrFalse = new TrueOrFalse();
        SimpleTreeNode trueOrFalseNode = node.getNode();
        if (ctx.CP_CONTENT_TRUE() != null){
            trueOrFalse.setTrue(true);
            trueOrFalseNode.addChild(new SimpleTreeNode("True"));
        }

        if (ctx.CP_CONTENT_FALSE() != null){
            trueOrFalse.setFalse(false);
            trueOrFalseNode.addChild(new SimpleTreeNode("False"));
        }

        return trueOrFalse;
    }

    @Override
    public Object visitObjArray(HTMLParser.ObjArrayContext ctx) {
//        : arrName arrayCalling
        ObjArray objArray = new ObjArray();
        SimpleTreeNode objArrayNode = node.getNode();

        if (ctx.arrName() != null){
            objArrayNode.addChild(addNode("arrName"));
            objArray.setArrName((ArrName) visitArrName(ctx.arrName()));
        }
        if (ctx.arrayCalling() != null){
            objArrayNode.addChild(addNode("arrayCalling"));
            objArray.setArrayCalling((ArrayCalling) visitArrayCalling(ctx.arrayCalling()));
        }

        return objArray;
    }

    @Override
    public Object visitArrName(HTMLParser.ArrNameContext ctx) {
//        : CP_CONTENT_IDENTIFIER
        ArrName arrName = new ArrName();
        SimpleTreeNode arrNameNode  = node.getNode();

        if (ctx.CP_CONTENT_IDENTIFIER() != null){
            arrName.setIdentifier(ctx.CP_CONTENT_IDENTIFIER().getSymbol().getText());
            arrNameNode.addChild(new SimpleTreeNode(arrName.getIdentifier()));
        }
        return arrName;
    }

    @Override
    public Object visitArrayCalling(HTMLParser.ArrayCallingContext ctx) {
//: (CP_CONTENT_OPEN_BRACKETS  arithmeticLogic CP_CONTENT_CLOSE_BRACKETS)+ (functionCallFromVar | property)?
        ArrayCalling arrayCalling = new ArrayCalling();
        SimpleTreeNode arrayCallingNode  = node.getNode();

        if (!ctx.arithmeticLogic().isEmpty()){
            List<ArithmeticLogic> arithmeticLogics = new ArrayList<>();
            for (int i = 0 ; i < ctx.arithmeticLogic().size() ; i ++){
                arrayCallingNode.addChild(addNode("arithmeticLogic"));
                arithmeticLogics.add((ArithmeticLogic) visitArithmeticLogic(ctx.arithmeticLogic(i)));
            }
            arrayCalling.setArithmeticLogic(arithmeticLogics);
        }

        if (ctx.functionCallFromVar() != null){
            arrayCallingNode.addChild(addNode("functionCallFromVar"));
            arrayCalling.setFunctionCallFromVar((FunctionCallFromVar) visitFunctionCallFromVar(ctx.functionCallFromVar()));
        }

        if (ctx.property() != null){
            arrayCallingNode.addChild(addNode("functionCallFromVar"));
            arrayCalling.setProperty((Property) visitProperty(ctx.property()));
        }

        return arrayCalling;
    }

    @Override
    public Object visitArray(HTMLParser.ArrayContext ctx) {
        Array array = new Array();
        SimpleTreeNode arrayNode = node.getNode();


        if (!ctx.collection4everything().isEmpty()){
            ArrayList<Collection4everything> internalCollections4EveryThings = new ArrayList<>();
            for (int i =0 ; i<ctx.collection4everything().size();i++){
                arrayNode.addChild(addNode("collection4everything"));
                internalCollections4EveryThings.add((Collection4everything) visitCollection4everything(ctx.collection4everything(i)));
            }
            array.setInternalCollection4everythings(internalCollections4EveryThings);

        }
        return array;
    }

    @Override
    public Object visitObj(HTMLParser.ObjContext ctx) {
//    : CP_CONTENT_IDENTIFIER

        Obj obj = new Obj();
        SimpleTreeNode objNode = node.getNode();

        if (ctx.CP_CONTENT_IDENTIFIER() != null){
            obj.setIdentifier(ctx.CP_CONTENT_IDENTIFIER().getSymbol().getText());
            objNode.addChild(new SimpleTreeNode(obj.getIdentifier()));
        }

        return obj;
    }

    @Override
    public Object visitSubObj(HTMLParser.SubObjContext ctx) {
//    : CP_CONTENT_IDENTIFIER property
        SubObj subObj = new SubObj();
        SimpleTreeNode subObjNode = node.getNode();

        if (ctx.CP_CONTENT_IDENTIFIER() != null){
            subObj.setIdentifier(ctx.CP_CONTENT_IDENTIFIER().getSymbol().getText());
            subObjNode.addChild(new SimpleTreeNode(subObj.getIdentifier()));
        }

        if (ctx.property() != null){
            subObjNode.addChild(addNode("property"));
            subObj.setProperty((Property) visitProperty(ctx.property()));
        }

        return subObj;
    }

    @Override
    public Object visitObjBody(HTMLParser.ObjBodyContext ctx) {
//: CP_CONTENT_OPEN_CURLY_BRACKETS (pair (CP_CONTENT_COMMA pair)*)* CP_CONTENT_CLOSE_CURLY_BRACKETS

        ObjBody objBody = new ObjBody();
        SimpleTreeNode objBodyNode = node.getNode();

        if (!ctx.pair().isEmpty()){
            ArrayList<Pair> pairs = new ArrayList<>();
            for (int i=0 ; i< ctx.pair().size(); i++){
                objBodyNode.addChild(addNode("pair"));
                pairs.add((Pair) visitPair(ctx.pair(i)));
            }
            objBody.setPairs(pairs);
        }

        return objBody;
    }

    @Override
    public Object visitPair(HTMLParser.PairContext ctx) {
//    : key CP_CONTENT_COLON collection4everything
        Pair pair = new Pair();
        SimpleTreeNode pairNode  = node.getNode();

        if (ctx.key() != null){
            pairNode.addChild(addNode("key"));
            pair.setKey((Key) visitKey(ctx.key()));
        }

        if (ctx.collection4everything() != null){
            pairNode.addChild(addNode("collection4everything"));
            pair.setCollection4everything((Collection4everything) visitCollection4everything(ctx.collection4everything()));
        }

        return pair;
    }

    @Override
    public Object visitKey(HTMLParser.KeyContext ctx) {
//            : CP_CONTENT_IDENTIFIER

        Key key = new Key();
        SimpleTreeNode keyNode = node.getNode();

        if (ctx.CP_CONTENT_IDENTIFIER() != null){
            key.setIdentifier(ctx.CP_CONTENT_IDENTIFIER().getSymbol().getText());
            keyNode.addChild(new SimpleTreeNode(key.getIdentifier()));
        }

        return key;
    }

    @Override
    public Object visitProperty(HTMLParser.PropertyContext ctx) {
//        : (CP_CONTENT_DOT propertyValue)+ (arrayCalling | functionCallFromVar)?

        Property property = new Property();
        SimpleTreeNode propertyNode = node.getNode();

        if (!ctx.propertyValue().isEmpty()){
            ArrayList<PropertyValue> propertyValues = new ArrayList<>();
            for (int i=0; i<ctx.propertyValue().size();i++){
                propertyNode.addChild(addNode("propertyValue"));
                propertyValues.add((PropertyValue) visitPropertyValue(ctx.propertyValue(i)));
            }
            property.setPropertyValues(propertyValues);
        }
//        We have OR --"(arrayCalling | functionCallFromVar)?"--

        if (ctx.arrayCalling() != null){
            propertyNode.addChild(addNode("arrayCalling"));
            property.setArrayCalling((ArrayCalling) visitArrayCalling(ctx.arrayCalling()));
        }
        //OR
        if (ctx.functionCallFromVar() != null){
            propertyNode.addChild(addNode("functionCallFromVar"));
            property.setFunctionCallFromVar((FunctionCallFromVar) visitFunctionCallFromVar(ctx.functionCallFromVar()));
        }

        return property;
    }

    @Override
    public Object visitPropertyValue(HTMLParser.PropertyValueContext ctx) {
//        : CP_CONTENT_IDENTIFIER
        PropertyValue propertyValue = new PropertyValue();
        SimpleTreeNode propertyValueNode = node.getNode();

        if (ctx.CP_CONTENT_IDENTIFIER() != null){
            propertyValue.setIdentifier(ctx.CP_CONTENT_IDENTIFIER().getSymbol().getText());
            propertyValueNode.addChild(new SimpleTreeNode(propertyValue.getIdentifier()));
        }

        return propertyValue;
    }

    @Override
    public Object visitFunctionCall(HTMLParser.FunctionCallContext ctx) {
//    : functionName functionCallFromVar

        FunctionCall functionCall = new FunctionCall();
        SimpleTreeNode functionCallNode = node.getNode();

        if (ctx.functionName() != null){
            functionCallNode.addChild(addNode("functionName"));
            functionCall.setFunctionName((FunctionName) visitFunctionName(ctx.functionName()));
        }

        if (ctx.functionCallFromVar() != null){
            functionCallNode.addChild(addNode("functionCallFromVar"));
            functionCall.setFunctionCallFromVar((FunctionCallFromVar) visitFunctionCallFromVar(ctx.functionCallFromVar()));
        }

        return functionCall;
    }

    @Override
    public Object visitFunctionCallFromVar(HTMLParser.FunctionCallFromVarContext ctx) {
//    : (CP_CONTENT_OPEN_PAR parameters? CP_CONTENT_CLOSE_PAR)+ (arrayCalling | property)?

        FunctionCallFromVar functionCallFromVar = new FunctionCallFromVar();
        SimpleTreeNode functionCallFromVarNode = node.getNode();

        if (!ctx.parameters().isEmpty()){
            ArrayList<Parameters> parametersArrayList = new ArrayList<>();
            for (int i=0; i< ctx.parameters().size();i++){
                functionCallFromVarNode.addChild(addNode("parameters"));
                parametersArrayList.add((Parameters) visitParameters(ctx.parameters(i)));
            }
            functionCallFromVar.setParameters(parametersArrayList);
        }
//        We have OR --"(arrayCalling | property)?"--
        if (ctx.arrayCalling() != null){
            functionCallFromVarNode.addChild(addNode("arrayCalling"));
            functionCallFromVar.setArrayCalling((ArrayCalling) visitArrayCalling(ctx.arrayCalling()));
        }
        // --OR--

        if (ctx.property() != null){
            functionCallFromVarNode.addChild(addNode("property"));
            functionCallFromVar.setProperty((Property) visitProperty(ctx.property()));
        }

        return functionCallFromVar;
    }

    @Override
    public Object visitFunctionName(HTMLParser.FunctionNameContext ctx) {
//    : CP_CONTENT_IDENTIFIER

        FunctionName functionName = new FunctionName();
        SimpleTreeNode functionNameNode = node.getNode();

        if (ctx.CP_CONTENT_IDENTIFIER() != null){
            functionName.setIdentifier(ctx.CP_CONTENT_IDENTIFIER().getSymbol().getText());
            functionNameNode.addChild(new SimpleTreeNode(functionName.getIdentifier()));
        }

        return functionName;
    }

    @Override
    public Object visitParameters(HTMLParser.ParametersContext ctx) {
//        : parameter (CP_CONTENT_COMMA parameter)*

        Parameters parameters = new Parameters();
        SimpleTreeNode parametersNode = node.getNode();

        if (!ctx.parameter().isEmpty()){
            ArrayList<Parameter> parameterArrayList = new ArrayList<>();
            for (int i=0; i< ctx.parameter().size();i++){
                parametersNode.addChild(addNode("parameter"));
                parameterArrayList.add((Parameter) visitParameter(ctx.parameter(i)));
            }
            parameters.setParameters(parameterArrayList);
        }

        return parameters;
    }

    @Override
    public Object visitParameter(HTMLParser.ParameterContext ctx) {
//: collection4everything
        Parameter parameter = new Parameter();
        SimpleTreeNode parameterNode = node.getNode();
        if (ctx.collection4everything() != null){
            parameterNode.addChild(addNode("collection4everything"));
            parameter.setCollection4everything((Collection4everything) visitCollection4everything(ctx.collection4everything()));
        }

        return parameter;
    }

    @Override
    public Object visitComparisonExpression(HTMLParser.ComparisonExpressionContext ctx) {
//: collection4comparison comparisonOperator collection4comparison

        ComparisonExpression comparisonExpression = new ComparisonExpression();
        SimpleTreeNode comparisonExpressionNode = node.getNode();

        /**I use index (0) in parameter of visit for first collection4comparison
         *  because we have same expression
         * And index (1) for next collection4comparison
         * And all of that because we have arrayList of collection4comparison from Parser
        **/

        if (ctx.collection4comparison() != null){
            //index (0)
            comparisonExpressionNode.addChild(addNode("Collection4comparison1"));
            comparisonExpression.setCollection4comparison1((Collection4comparison) visitCollection4comparison(ctx.collection4comparison(0)));
            // index(1)
            comparisonExpressionNode.addChild(addNode("Collection4comparison2"));
            comparisonExpression.setCollection4comparison2((Collection4comparison) visitCollection4comparison(ctx.collection4comparison(1)));
        }

        if (ctx.comparisonOperator() != null){
            comparisonExpressionNode.addChild(addNode("comparisonOperator"));
            comparisonExpression.setComparisonOperator((ComparisonOperator) visitComparisonOperator(ctx.comparisonOperator()));
        }

        return comparisonExpression;
    }

    @Override
    public Object visitOneLineCondition(HTMLParser.OneLineConditionContext ctx) {
//: CP_CONTENT_OPEN_PAR logicComprison CP_CONTENT_QUESTION_MARK collection4everything CP_CONTENT_COLON collection4everything CP_CONTENT_CLOSE_PAR

        OneLineCondition oneLineCondition = new OneLineCondition();
        SimpleTreeNode oneLineConditionNode = node.getNode();
        if (ctx.logicComprison() != null){
            oneLineConditionNode.addChild(addNode("logicComparison"));
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
            oneLineConditionNode.addChild(addNode("Collection4everything1"));
            oneLineCondition.setCollection4everything1((Collection4everything) visitCollection4everything(ctx.collection4everything(0)));
            oneLineConditionNode.addChild(addNode("Collection4everything2"));
            oneLineCondition.setCollection4everything2((Collection4everything) visitCollection4everything(ctx.collection4everything(1)));
        }

        return oneLineCondition;
    }

    @Override
    public Object visitOneLineBoolCondition(HTMLParser.OneLineBoolConditionContext ctx) {
//: CP_CONTENT_OPEN_PAR logicComprison CP_CONTENT_QUESTION_MARK CP_CONTENT_TRUE CP_CONTENT_COLON CP_CONTENT_FALSE CP_CONTENT_CLOSE_PAR

        OneLineBoolCondition oneLineBoolCondition = new OneLineBoolCondition();
        SimpleTreeNode oneLineBoolConditionNode = node.getNode();

        if (ctx.logicComprison() != null){
            oneLineBoolConditionNode.addChild(addNode("logicComparison"));
            oneLineBoolCondition.setLogicComprison((LogicComprison) visitLogicComprison(ctx.logicComprison()));
        }

        if (ctx.CP_CONTENT_FALSE() != null){
            oneLineBoolCondition.setFalse(false);
            oneLineBoolConditionNode.addChild(new SimpleTreeNode("False"));
        }

        if (ctx.CP_CONTENT_TRUE() != null){
            oneLineBoolCondition.setTrue(true);
            oneLineBoolConditionNode.addChild(new SimpleTreeNode("True"));
        }
        return oneLineBoolCondition;
    }

    @Override
    public Object visitOneLineArithCondition(HTMLParser.OneLineArithConditionContext ctx) {
//: CP_CONTENT_OPEN_PAR logicComprison CP_CONTENT_QUESTION_MARK arithmeticLogic CP_CONTENT_COLON arithmeticLogic CP_CONTENT_CLOSE_PAR

        OneLineArithCondition oneLineArithCondition = new OneLineArithCondition();
        SimpleTreeNode oneLineArithConditionNode = node.getNode();

        if (ctx.logicComprison() != null){
            oneLineArithConditionNode.addChild(addNode("logicComparison"));
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
            oneLineArithConditionNode.addChild(addNode("ArithmeticLogic1"));
            oneLineArithCondition.setArithmeticLogic1((ArithmeticLogic) visitArithmeticLogic(ctx.arithmeticLogic(0)));
            oneLineArithConditionNode.addChild(addNode("ArithmeticLogic2"));
            oneLineArithCondition.setArithmeticLogic2((ArithmeticLogic) visitArithmeticLogic(ctx.arithmeticLogic(1)));
        }

        return oneLineArithCondition;
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
        SimpleTreeNode comparisonOperatorNode = node.getNode();

        //CP_CONTENT_GREATER_THAN
        if (ctx.CP_CONTENT_GREATER_THAN() != null){
            comparisonOperator.setComparisonOperator(ctx.CP_CONTENT_GREATER_THAN().getSymbol().getText());
            comparisonOperatorNode.addChild(new SimpleTreeNode(comparisonOperator.getComparisonOperator()));
        }
//        CP_CONTENT_GREATER_EQ
        if (ctx.CP_CONTENT_GREATER_EQ() != null){
            comparisonOperator.setComparisonOperator(ctx.CP_CONTENT_GREATER_EQ().getSymbol().getText());
            comparisonOperatorNode.addChild(new SimpleTreeNode(comparisonOperator.getComparisonOperator()));
        }
        //CP_CONTENT_LESS_THAN
        if (ctx.CP_CONTENT_LESS_THAN() != null){
            comparisonOperator.setComparisonOperator(ctx.CP_CONTENT_LESS_THAN().getSymbol().getText());
            comparisonOperatorNode.addChild(new SimpleTreeNode(comparisonOperator.getComparisonOperator()));
        }
        //CP_CONTENT_LESS_EQ
        if (ctx.CP_CONTENT_LESS_EQ() != null){
            comparisonOperator.setComparisonOperator(ctx.CP_CONTENT_LESS_EQ().getSymbol().getText());
            comparisonOperatorNode.addChild(new SimpleTreeNode(comparisonOperator.getComparisonOperator()));
        }
        //CP_CONTENT_EQUAL_TO
        if (ctx.CP_CONTENT_EQUAL_TO() != null){
            comparisonOperator.setComparisonOperator(ctx.CP_CONTENT_EQUAL_TO().getSymbol().getText());
            comparisonOperatorNode.addChild(new SimpleTreeNode(comparisonOperator.getComparisonOperator()));
        }
        //CP_CONTENT_NOT_EQUAL
        if (ctx.CP_CONTENT_NOT_EQUAL() != null){
            comparisonOperator.setComparisonOperator(ctx.CP_CONTENT_NOT_EQUAL().getSymbol().getText());
            comparisonOperatorNode.addChild(new SimpleTreeNode(comparisonOperator.getComparisonOperator()));
        }

        return comparisonOperator;
    }

    @Override
    public Object visitLogicComprison(HTMLParser.LogicComprisonContext ctx) {
//        : ((CP_CONTENT_NOT)? ((collection4LogicRet) | (CP_CONTENT_OPEN_PAR logicComprison CP_CONTENT_CLOSE_PAR))) /// first
//        middleAndLastLogicComparison*
        LogicComprison logicComprison = new LogicComprison();
        SimpleTreeNode logicComprisonNode = node.getNode();
        if (ctx.CP_CONTENT_NOT() != null){
            logicComprison.setNotFirst(ctx.CP_CONTENT_NOT().getSymbol().getText());
            logicComprisonNode.addChild(new SimpleTreeNode(logicComprison.getNotFirst()));
        }

        if (ctx.collection4LogicRet() != null){

            logicComprisonNode.addChild(addNode("collection4LogicRet"));
            logicComprison.setCollection4LogicRetFirst((Collection4LogicRet) visitCollection4LogicRet(ctx.collection4LogicRet()));
        }

        if (ctx.CP_CONTENT_OPEN_PAR() != null){
            logicComprison.setOpenParFirst(ctx.CP_CONTENT_OPEN_PAR().getSymbol().getText());
            logicComprisonNode.addChild(new SimpleTreeNode(logicComprison.getOpenParFirst()));
        }

        if (ctx.logicComprison() != null){
            logicComprisonNode.addChild(addNode("logicComprison"));
            logicComprison.setLogicComprisonFirst((LogicComprison) visitLogicComprison(ctx.logicComprison()));
        }

        if (!ctx.middleAndLastLogicComparison().isEmpty()){
            List<MiddleAndLastLogicComparison> middleAndLastLogicComparisons = new ArrayList<>();
            for (int i = 0 ; i < ctx.middleAndLastLogicComparison().size() ; i++){
                logicComprisonNode.addChild(addNode("middleAndLastLogicComparison"));
                middleAndLastLogicComparisons.add((MiddleAndLastLogicComparison) visitMiddleAndLastLogicComparison(ctx.middleAndLastLogicComparison(i)));
            }
            logicComprison.setMiddleAndLastLogicComparisons(middleAndLastLogicComparisons);
        }

        return logicComprison;
    }
    @Override
    public Object visitMiddleAndLastLogicComparison(HTMLParser.MiddleAndLastLogicComparisonContext ctx) {
//           : ((CP_CONTENT_AND (CP_CONTENT_NOT)?) | (CP_CONTENT_OR (CP_CONTENT_NOT)?))   /// middle
//        (collection4LogicRet | CP_CONTENT_OPEN_PAR logicComprison CP_CONTENT_CLOSE_PAR)

        MiddleAndLastLogicComparison middleAndLastLogicComparison = new MiddleAndLastLogicComparison();
        SimpleTreeNode middleAndLastLogicComparisonNode = node.getNode();
        //First OR between ----- && or || -----

        //Only && (&&)
        if (ctx.CP_CONTENT_AND() != null){
            middleAndLastLogicComparison.setAndMiddle(ctx.CP_CONTENT_AND().getSymbol().getText());
            middleAndLastLogicComparisonNode.addChild(new SimpleTreeNode(middleAndLastLogicComparison.getAndMiddle()));
            if (ctx.CP_CONTENT_NOT() != null){
                middleAndLastLogicComparison.setNotAndMiddle(ctx.CP_CONTENT_NOT().getSymbol().getText());
                middleAndLastLogicComparisonNode.addChild(new SimpleTreeNode(middleAndLastLogicComparison.getNotAndMiddle()));
            }
        }
        // OR

        //Only || (||)
        if (ctx.CP_CONTENT_OR() != null){
            middleAndLastLogicComparison.setOrMiddle(ctx.CP_CONTENT_OR().getSymbol().getText());
            middleAndLastLogicComparisonNode.addChild(new SimpleTreeNode(middleAndLastLogicComparison.getOrMiddle()));
            if (ctx.CP_CONTENT_NOT() != null){
                middleAndLastLogicComparison.setNotOrMiddle(ctx.CP_CONTENT_NOT().getSymbol().getText());
                middleAndLastLogicComparisonNode.addChild(new SimpleTreeNode(middleAndLastLogicComparison.getNotOrMiddle()));
            }
        }

        //Second OR between ----- collection4LogicRet or CP_CONTENT_OPEN_PAR logicComprison CP_CONTENT_CLOSE_PAR -----

        if (ctx.collection4LogicRet() != null){
            middleAndLastLogicComparisonNode.addChild(addNode("collection4LogicRet"));
            middleAndLastLogicComparison.setCollection4LogicRet((Collection4LogicRet) visitCollection4LogicRet(ctx.collection4LogicRet()));
        }

        // OR

        if (ctx.logicComprison() != null){
            middleAndLastLogicComparisonNode.addChild(addNode("logicComprison"));
            middleAndLastLogicComparison.setLogicComprisonLast((LogicComprison) visitLogicComprison(ctx.logicComprison()));
        }

        return middleAndLastLogicComparison;
    }
    @Override
    public Object visitArithmeticLogic(HTMLParser.ArithmeticLogicContext ctx) {
//: (collection4Arithmetic | CP_CONTENT_OPEN_PAR arithmeticLogic CP_CONTENT_CLOSE_PAR) lastArithmeticLogic*

        ArithmeticLogic arithmeticLogic = new ArithmeticLogic();
        SimpleTreeNode arithmeticLogicNode = node.getNode();

        //First OR  between ----"collection4Arithmetic" and "arithmeticLogic"----

        if (ctx.collection4Arithmetic() != null){
            arithmeticLogicNode.addChild(addNode("collection4Arithmetic"));
            arithmeticLogic.setCollection4Arithmetic((Collection4Arithmetic) visitCollection4Arithmetic(ctx.collection4Arithmetic()));
        }
        // OR

        if (ctx.arithmeticLogic() != null){
            arithmeticLogicNode.addChild(addNode("arithmeticLogic"));
            arithmeticLogic.setArithmeticLogic((ArithmeticLogic) visitArithmeticLogic(ctx.arithmeticLogic()));
        }

        if (!ctx.lastArithmeticLogic().isEmpty()){
            ArrayList<LastArithmeticLogic> lastArithmeticLogicArrayList = new ArrayList<>();
            for (int i=0; i< ctx.lastArithmeticLogic().size();i++){
                arithmeticLogicNode.addChild(addNode("lastArithmeticLogic"));
                lastArithmeticLogicArrayList.add((LastArithmeticLogic) visitLastArithmeticLogic(ctx.lastArithmeticLogic(i)));
            }
            arithmeticLogic.setLastArithmeticLogic(lastArithmeticLogicArrayList);
        }

        return arithmeticLogic;
    }
    @Override
    public Object visitLastArithmeticLogic(HTMLParser.LastArithmeticLogicContext ctx) {
//: CP_CONTENT_ARITHMETIC (collection4Arithmetic | CP_CONTENT_OPEN_PAR arithmeticLogic CP_CONTENT_CLOSE_PAR)

        LastArithmeticLogic lastArithmeticLogic = new LastArithmeticLogic();
        SimpleTreeNode lastArithmeticLogicNode = node.getNode();

        if (ctx.CP_CONTENT_ARITHMETIC() != null){
            lastArithmeticLogic.setArithmetic(ctx.CP_CONTENT_ARITHMETIC().getSymbol().getText());
            lastArithmeticLogicNode.addChild(new SimpleTreeNode(lastArithmeticLogic.getArithmetic()));
        }

        // First OR between -----"collection4Arithmetic"  OR "arithmeticLogic"-----
        if (ctx.collection4Arithmetic() != null){
            lastArithmeticLogicNode.addChild(addNode("collection4Arithmetic"));
            lastArithmeticLogic.setCollection4Arithmetic((Collection4Arithmetic) visitCollection4Arithmetic(ctx.collection4Arithmetic()));

        }
        // OR

        if (ctx.arithmeticLogic() != null){
            lastArithmeticLogicNode.addChild(addNode("arithmeticLogic"));
            lastArithmeticLogic.setArithmeticLogic((ArithmeticLogic) visitArithmeticLogic(ctx.arithmeticLogic()));
        }

        return lastArithmeticLogic;
    }
    @Override
    public Object visitValue(HTMLParser.ValueContext ctx) {
//        : CP_CONTENT_STRING
//                | number
//                | trueOrFalse
//                | CP_CONTENT_NULL

        Value value = new Value();
        SimpleTreeNode valueNode = node.getNode();

        if (ctx.CP_CONTENT_STRING() != null){
            value.setString(ctx.CP_CONTENT_STRING().getSymbol().getText());
            valueNode.addChild(new SimpleTreeNode(value.getString()));
        }
        if (ctx.CP_CONTENT_NULL() != null){
            value.setNull(null);
            valueNode.addChild(new SimpleTreeNode(value.getNull().toString()));
        }


        if (ctx.number() != null){
            valueNode.addChild(addNode("number"));
            value.setNumber((NUmber) visitNumber(ctx.number()));
        }
        if (ctx.trueOrFalse() != null){
            valueNode.addChild(addNode("trueOrFalse"));
            value.setTrueOrFalse((TrueOrFalse) visitTrueOrFalse(ctx.trueOrFalse()));
        }

        return value;
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
        SimpleTreeNode collection4everythingNode = node.getNode();

        //variable
        if (ctx.variable()  != null){
            collection4everythingNode.addChild(addNode("variable"));
            collection4everything.setVariable((Variable) visitVariable(ctx.variable()));
        }
        //value
        if (ctx.value()  != null){
            collection4everythingNode.addChild(addNode("value"));
            collection4everything.setValue((Value) visitValue(ctx.value()));
        }
        //array
        if (ctx.array()  != null){
            collection4everythingNode.addChild(addNode("array"));
            collection4everything.setArray((Array) visitArray(ctx.array()));
        }
        //objArray
        if (ctx.objArray()  != null){
            collection4everythingNode.addChild(addNode("objArray"));
            collection4everything.setObjArray((ObjArray) visitObjArray(ctx.objArray()));
        }
        //functionCall
        if (ctx.functionCall()  != null){
            collection4everythingNode.addChild(addNode("functionCall"));
            collection4everything.setFunctionCall((FunctionCall) visitFunctionCall(ctx.functionCall()));
        }
        //subObj
        if (ctx.subObj()  != null){
            collection4everythingNode.addChild(addNode("subObj"));
            collection4everything.setSubObj((SubObj) visitSubObj(ctx.subObj()));
        }
        //oneLineCondition
        if (ctx.oneLineCondition()  != null){
            collection4everythingNode.addChild(addNode("oneLineCondition"));
            collection4everything.setOneLineCondition((OneLineCondition) visitOneLineCondition(ctx.oneLineCondition()));
        }
        //comparisonExpression
        if (ctx.comparisonExpression()  != null){
            collection4everythingNode.addChild(addNode("comparisonExpression"));
            collection4everything.setComparisonExpression((ComparisonExpression) visitComparisonExpression(ctx.comparisonExpression()));
        }
        //logicComprison
        if (ctx.logicComprison()  != null){
            collection4everythingNode.addChild(addNode("logicComprison"));
            collection4everything.setLogicComprison((LogicComprison) visitLogicComprison(ctx.logicComprison()));
        }
        //arithmeticLogic
        if (ctx.arithmeticLogic()  != null){
            collection4everythingNode.addChild(addNode("arithmeticLogic"));
            collection4everything.setArithmeticLogic((ArithmeticLogic) visitArithmeticLogic(ctx.arithmeticLogic()));
        }

        return collection4everything;
    }

    @Override
    public Object visitCollection4comparison(HTMLParser.Collection4comparisonContext ctx) {
//            : arithmeticLogic

        Collection4comparison collection4comparison = new Collection4comparison();
        SimpleTreeNode collection4comparisonNode = node.getNode();
        if (ctx.arithmeticLogic() != null){
            collection4comparisonNode.addChild(addNode("arithmeticLogic"));
            collection4comparison.setArithmeticLogic((ArithmeticLogic) visitArithmeticLogic(ctx.arithmeticLogic()));
        }

        return collection4comparison;
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
        SimpleTreeNode collection4ArithmeticNode = node.getNode();


        //variable
        if (ctx.variable()  != null){
            collection4ArithmeticNode.addChild(addNode("variable"));
            collection4Arithmetic.setVariable((Variable) visitVariable(ctx.variable()));
        }
        //number
        if (ctx.number()  != null){
            collection4ArithmeticNode.addChild(addNode("number"));
            collection4Arithmetic.setNumber((NUmber) visitNumber(ctx.number()));
        }
        //objArray
        if (ctx.objArray()  != null){
            collection4ArithmeticNode.addChild(addNode("objArray"));
            collection4Arithmetic.setObjArray((ObjArray) visitObjArray(ctx.objArray()));
        }
        //functionCall
        if (ctx.functionCall()  != null){
            collection4ArithmeticNode.addChild(addNode("functionCall"));
            collection4Arithmetic.setFunctionCall((FunctionCall) visitFunctionCall(ctx.functionCall()));
        }
        //subObj
        if (ctx.subObj()  != null){
            collection4ArithmeticNode.addChild(addNode("subObj"));
            collection4Arithmetic.setSubObj((SubObj) visitSubObj(ctx.subObj()));
        }
        //oneLineArithCondition
        if (ctx.oneLineArithCondition()  != null){
            collection4ArithmeticNode.addChild(addNode("oneLineArithCondition"));
            collection4Arithmetic.setOneLineArithCondition((OneLineArithCondition) visitOneLineArithCondition(ctx.oneLineArithCondition()));
        }

        return collection4Arithmetic;
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
        SimpleTreeNode collection4LogicRetNode = node.getNode();

        //variable
        if (ctx.variable()  != null){
            collection4LogicRetNode.addChild(addNode("variable"));
            collection4LogicRet.setVariable((Variable) visitVariable(ctx.variable()));
        }
        //trueOrFalse
        if (ctx.trueOrFalse()  != null){
            collection4LogicRetNode.addChild(addNode("trueOrFalse"));
            collection4LogicRet.setTrueOrFalse((TrueOrFalse) visitTrueOrFalse(ctx.trueOrFalse()));
        }
        //objArray
        if (ctx.objArray()  != null){
            collection4LogicRetNode.addChild(addNode("objArray"));
            collection4LogicRet.setObjArray((ObjArray) visitObjArray(ctx.objArray()));
        }
        //functionCall
        if (ctx.functionCall()  != null){
            collection4LogicRetNode.addChild(addNode("functionCall"));;
            collection4LogicRet.setFunctionCall((FunctionCall) visitFunctionCall(ctx.functionCall()));
        }
        //subObj
        if (ctx.subObj()  != null){
            collection4LogicRetNode.addChild(addNode("subObj"));
            collection4LogicRet.setSubObj((SubObj) visitSubObj(ctx.subObj()));
        }
        //comparisonExpression
        if (ctx.comparisonExpression()  != null){
            collection4LogicRetNode.addChild(addNode("comparisonExpression"));
            collection4LogicRet.setComparisonExpression((ComparisonExpression) visitComparisonExpression(ctx.comparisonExpression()));
        }
        //oneLineBoolCondition
        if (ctx.oneLineBoolCondition()  != null){
            collection4LogicRetNode.addChild(addNode("oneLineBoolCondition"));
            collection4LogicRet.setOneLineBoolCondition((OneLineBoolCondition) visitOneLineBoolCondition(ctx.oneLineBoolCondition()));
        }

        return collection4LogicRet;
    }


    //////////////////////////////////////////////////










    ///////////////////////// NOOR /////////////////////////
    @Override
    public Object visitMustacheExpression(HTMLParser.MustacheExpressionContext ctx) {
        MustacheExpression mustacheExpression = new MustacheExpression();
        SimpleTreeNode mustacheExpressionNode = node.getNode();

        if (!ctx.collection4Mustache().isEmpty()){
            mustacheExpressionNode.addChild(addNode("collection4Mustache"));
            List<org.antlr.v4.runtime.misc.Pair<Collection4Mustache, Filter>> mustacheContent = new ArrayList<>();

            for (int i = 0 ; i < ctx.collection4Mustache().size() ; i ++){
                Collection4Mustache cm = (Collection4Mustache) visitCollection4Mustache(ctx.collection4Mustache(i));
                if (ctx.filter() != null){
                    mustacheExpressionNode.addChild(addNode("filter"));
                    Filter f = (Filter) visitFilter(ctx.filter(i));
                    mustacheContent.add(new org.antlr.v4.runtime.misc.Pair<>(cm,f));
                    continue;
                }
                mustacheContent.add(new org.antlr.v4.runtime.misc.Pair<>(cm,null));
            }
            mustacheExpression.setMustacheContent(mustacheContent);
        }
        return mustacheExpression;
    }
    @Override
    public Object visitCollection4Mustache(HTMLParser.Collection4MustacheContext ctx) {
        Collection4Mustache collection4Mustache = new Collection4Mustache();
        SimpleTreeNode collection4MustacheNode = node.getNode();

        if (ctx.mustacheVariable() != null){
            collection4MustacheNode.addChild(addNode("mustacheVariable"));
            collection4Mustache.setMustacheVariable((MustacheVariable) visitMustacheVariable(ctx.mustacheVariable()));
        }
        if (ctx.mustacheValue() != null){
            collection4MustacheNode.addChild(addNode("mustacheValue"));
            collection4Mustache.setMustacheValue((MustacheValue) visitMustacheValue(ctx.mustacheValue()));
        }

        if (ctx.objArray4Must() != null){
            collection4MustacheNode.addChild(addNode("objArray4Must"));
            collection4Mustache.setObjArray4Must((ObjArray4Must) visitObjArray4Must(ctx.objArray4Must()));
        }

        if (ctx.functionCall4Must() != null){
            collection4MustacheNode.addChild(addNode("functionCall4Must"));
            collection4Mustache.setFunctionCall4Must((FunctionCall4Must) visitFunctionCall4Must(ctx.functionCall4Must()));
        }

        if (ctx.subObj4Must() != null){
            collection4MustacheNode.addChild(addNode("subObj4Must"));
            collection4Mustache.setSubObj4Must((SubObj4Must) visitSubObj4Must(ctx.subObj4Must()));
        }

        if (ctx.oneLineCondition4Must() != null){
            collection4MustacheNode.addChild(addNode("oneLineCondition4Must"));
            collection4Mustache.setOneLineCondition4Must((OneLineCondition4Must) visitOneLineCondition4Must(ctx.oneLineCondition4Must()));
        }

        if (ctx.oneLineArithCondition4Must() != null){
            collection4MustacheNode.addChild(addNode("oneLineArithCondition4Must"));
            collection4Mustache.setOneLineArithCondithion4Must((OneLineArithCondition4Must) visitOneLineArithCondition4Must(ctx.oneLineArithCondition4Must()));
        }

        if (ctx.arithmeticLogic4Must() != null){
            collection4MustacheNode.addChild(addNode("arithmeticLogic4Must"));
            collection4Mustache.setArithmeticLogic4Must((ArithmeticLogic4Must) visitArithmeticLogic4Must(ctx.arithmeticLogic4Must()));
        }

        return collection4Mustache;
    }

    @Override
    public Object visitCollection4LogicRet4Must(HTMLParser.Collection4LogicRet4MustContext ctx) {
        Collection4LogicRet4Must collection4LogicRet4Must = new Collection4LogicRet4Must();
        SimpleTreeNode collection4LogicRet4MustNode = node.getNode();

        if (ctx.mustacheVariable() != null){
            collection4LogicRet4MustNode.addChild(addNode("mustacheVariable"));
            collection4LogicRet4Must.setMustacheVariable((MustacheVariable) visitMustacheVariable(ctx.mustacheVariable()));
        }

        if (ctx.MUSTACHE_TRUE() != null){
            collection4LogicRet4Must.setMustacheTrue(true);
            collection4LogicRet4MustNode.addChild(new SimpleTreeNode("True"));
        }
        if (ctx.MUSTACHE_FALSE() != null){
            collection4LogicRet4Must.setMustacheFalse(false);
            collection4LogicRet4MustNode.addChild(new SimpleTreeNode("False"));
        }

        if (ctx.objArray4Must() != null){
            collection4LogicRet4MustNode.addChild(addNode("objArray4Must"));
            collection4LogicRet4Must.setObjArray4Must((ObjArray4Must) visitObjArray4Must(ctx.objArray4Must()));
        }

        if (ctx.functionCall4Must() != null){
            collection4LogicRet4MustNode.addChild(addNode("functionCall4Must"));
            collection4LogicRet4Must.setFunctionCall4Must((FunctionCall4Must) visitFunctionCall4Must(ctx.functionCall4Must()));
        }

        if (ctx.subObj4Must() != null){
            collection4LogicRet4MustNode.addChild(addNode("subObj4Must"));
            collection4LogicRet4Must.setSubObj4Must((SubObj4Must) visitSubObj4Must(ctx.subObj4Must()));
        }

        if (ctx.comparisonExp4Must() != null){
            collection4LogicRet4MustNode.addChild(addNode("comparisonExp4Must"));
            collection4LogicRet4Must.setComparisonExp4Must((ComparisonExp4Must) visitComparisonExp4Must(ctx.comparisonExp4Must()));
        }

        if (ctx.oneLineBoolCondition4Must() != null){
            collection4LogicRet4MustNode.addChild(addNode("oneLineBoolCondition4Must"));
            collection4LogicRet4Must.setOneLineBoolCondition4Must((OneLineBoolCondition4Must) visitOneLineBoolCondition4Must(ctx.oneLineBoolCondition4Must()));
        }

        return collection4LogicRet4Must;
    }

    @Override
    public Object visitCollection4CompMust(HTMLParser.Collection4CompMustContext ctx) {
        Collection4CompMust collection4CompMust = new Collection4CompMust();
        SimpleTreeNode collection4CompMustNode = node.getNode();

        if (ctx.arithmeticLogic4Must() != null){
            collection4CompMustNode.addChild(addNode("arithmeticLogic4Must"));
            collection4CompMust.setArithmeticLogic4Must((ArithmeticLogic4Must) visitArithmeticLogic4Must(ctx.arithmeticLogic4Must()));
        }

        return collection4CompMust;
    }

    @Override
    public Object visitCollection4MUSTArithmetic(HTMLParser.Collection4MUSTArithmeticContext ctx) {
        Collection4MUSTArithmetic collection4MUSTArithmetic = new Collection4MUSTArithmetic();
        SimpleTreeNode collection4MUSTArithmeticNode = node.getNode();

        if (ctx.mustacheVariable() != null){
            collection4MUSTArithmeticNode.addChild(addNode("mustacheVariable"));
            collection4MUSTArithmetic.setMustacheVariable((MustacheVariable) visitMustacheVariable(ctx.mustacheVariable()));
        }

        if (ctx.mustacheNumber() != null){
            collection4MUSTArithmeticNode.addChild(addNode("mustacheNumber"));
            collection4MUSTArithmetic.setMustacheNumber((MustacheNumber) visitMustacheNumber(ctx.mustacheNumber()));
        }

        if (ctx.objArray4Must() != null){
            collection4MUSTArithmeticNode.addChild(addNode("objArray4Must"));
            collection4MUSTArithmetic.setObjArray4Must((ObjArray4Must) visitObjArray4Must(ctx.objArray4Must()));
        }

        if (ctx.functionCall4Must() != null){
            collection4MUSTArithmeticNode.addChild(addNode("functionCall4Must"));
            collection4MUSTArithmetic.setFunctionCall4Must((FunctionCall4Must) visitFunctionCall4Must(ctx.functionCall4Must()));
        }

        if (ctx.subObj4Must() != null){
            collection4MUSTArithmeticNode.addChild(addNode("subObj4Must"));
            collection4MUSTArithmetic.setSubObj4Must((SubObj4Must) visitSubObj4Must(ctx.subObj4Must()));
        }

        if (ctx.oneLineArithCondition4Must() != null){
            collection4MUSTArithmeticNode.addChild(addNode("oneLineArithCondition4Must"));
            collection4MUSTArithmetic.setOneLineArithCondithion4Must1((OneLineArithCondition4Must) visitOneLineArithCondition4Must(ctx.oneLineArithCondition4Must()));
        }

        return collection4MUSTArithmetic;
    }

    @Override
    public Object visitLogicComprison4Must(HTMLParser.LogicComprison4MustContext ctx) {
        LogicComprison4Must logicComprison4Must = new LogicComprison4Must();
        SimpleTreeNode logicComprison4MustNode =node.getNode();
        // !
        if (ctx.MUSTACHE_NOT() != null){
            logicComprison4Must.setNotFirst(ctx.MUSTACHE_NOT().getSymbol().getText());
            logicComprison4MustNode.addChild(new SimpleTreeNode(logicComprison4Must.getNotFirst()));
        }
        // this
        if (ctx.collection4LogicRet4Must() != null){
            logicComprison4MustNode.addChild(addNode("collection4LogicRet4Must"));
            logicComprison4Must.setCollection4LogicRetFirst((Collection4LogicRet4Must) visitCollection4LogicRet4Must(ctx.collection4LogicRet4Must()));
        }
        // or this
        if (ctx.logicComprison4Must() != null){
            logicComprison4MustNode.addChild(addNode("logicComprison4Must"));
            logicComprison4Must.setLogicComprisonFirst((LogicComprison4Must) visitLogicComprison4Must(ctx.logicComprison4Must()));
        }
        // middle and last
        if (!ctx.middleAndLastLogicComparison4Must().isEmpty()){
            List<MiddleAndLastLogicComparison4Must> middleAndLastLogicComparison4Musts = new ArrayList<>();
            for (int i = 0 ; i < ctx.middleAndLastLogicComparison4Must().size() ; i ++){
                logicComprison4MustNode.addChild(addNode("middleAndLastLogicComparison4Must"));
                middleAndLastLogicComparison4Musts.add((MiddleAndLastLogicComparison4Must) visitMiddleAndLastLogicComparison4Must(ctx.middleAndLastLogicComparison4Must(i)));
            }
            logicComprison4Must.setMiddleAndLastLogicComparisons(middleAndLastLogicComparison4Musts);
        }

        return logicComprison4Must;
    }

    @Override
    public Object visitMiddleAndLastLogicComparison4Must(HTMLParser.MiddleAndLastLogicComparison4MustContext ctx) {
        MiddleAndLastLogicComparison4Must middleAndLastLogicComparison4Must = new MiddleAndLastLogicComparison4Must();
        SimpleTreeNode middleAndLastLogicComparison4MustNode = node.getNode();
        //middle
        //this AND NOT?
        if (ctx.MUSTACHE_AND() != null){
            middleAndLastLogicComparison4Must.setAndMiddle(ctx.MUSTACHE_AND().getSymbol().getText());
            middleAndLastLogicComparison4MustNode.addChild(new SimpleTreeNode(middleAndLastLogicComparison4Must.getAndMiddle()));
            if (ctx.MUSTACHE_NOT() != null){
                middleAndLastLogicComparison4Must.setNotAndMiddle(ctx.MUSTACHE_NOT().getSymbol().getText());
                middleAndLastLogicComparison4MustNode.addChild(new SimpleTreeNode(middleAndLastLogicComparison4Must.getNotAndMiddle()));
            }
        }
        // or this OR NOT?
        if (ctx.MUSTACHE_OR() != null){
            middleAndLastLogicComparison4Must.setOrMiddle(ctx.MUSTACHE_OR().getSymbol().getText());
            middleAndLastLogicComparison4MustNode.addChild(new SimpleTreeNode(middleAndLastLogicComparison4Must.getOrMiddle()));
            if (ctx.MUSTACHE_NOT() != null){
                middleAndLastLogicComparison4Must.setNotOrMiddle(ctx.MUSTACHE_NOT().getSymbol().getText());
                middleAndLastLogicComparison4MustNode.addChild(new SimpleTreeNode(middleAndLastLogicComparison4Must.getNotOrMiddle()));
            }
        }

        //last
        //this collection4LogicRet4Must
        if (ctx.collection4LogicRet4Must()!= null){
            middleAndLastLogicComparison4MustNode.addChild(addNode("collection4LogicRet4Must"));
            middleAndLastLogicComparison4Must.setCollection4LogicRet((Collection4LogicRet4Must) visitCollection4LogicRet4Must(ctx.collection4LogicRet4Must()));
        }
        // or logicComprison4Must
        if (ctx.logicComprison4Must() != null){
            middleAndLastLogicComparison4MustNode.addChild(addNode("logicComprison4Must"));
            middleAndLastLogicComparison4Must.setLogicComprisonLast((LogicComprison4Must) visitLogicComprison4Must(ctx.logicComprison4Must()));
        }

        return middleAndLastLogicComparison4Must;
    }

    @Override
    public Object visitArithmeticLogic4Must(HTMLParser.ArithmeticLogic4MustContext ctx) {
        ArithmeticLogic4Must arithmeticLogic4Must = new ArithmeticLogic4Must();
        SimpleTreeNode arithmeticLogic4MustNode = node.getNode();

        //this collection4MUSTArithmetic
        if (ctx.collection4MUSTArithmetic() != null){
            arithmeticLogic4MustNode.addChild(addNode("collection4MUSTArithmetic"));
            arithmeticLogic4Must.setCollection4Arithmetic((Collection4MUSTArithmetic) visitCollection4MUSTArithmetic(ctx.collection4MUSTArithmetic()));
        }

        // or arithmeticLogic4Must
        if (ctx.arithmeticLogic4Must() != null){
            arithmeticLogic4MustNode.addChild(addNode("arithmeticLogic4Must"));
            arithmeticLogic4Must.setArithmeticLogic((ArithmeticLogic4Must) visitArithmeticLogic4Must(ctx.arithmeticLogic4Must()));
        }

        if (!ctx.lastArithmeticLogic4Must().isEmpty()) {
            List<LastArithmeticLogic4Must> lastArithmeticLogic4Musts = new ArrayList<>();
            for (int i = 0; i < ctx.lastArithmeticLogic4Must().size(); i++) {
                arithmeticLogic4MustNode.addChild(addNode("lastArithmeticLogic4Must"));
                lastArithmeticLogic4Musts.add((LastArithmeticLogic4Must) visitLastArithmeticLogic4Must(ctx.lastArithmeticLogic4Must(i)));
            }
            arithmeticLogic4Must.setLastArithmeticLogic(lastArithmeticLogic4Musts);
        }

        return arithmeticLogic4Must;
    }

    @Override
    public Object visitLastArithmeticLogic4Must(HTMLParser.LastArithmeticLogic4MustContext ctx) {
        LastArithmeticLogic4Must lastArithmeticLogic4Must = new LastArithmeticLogic4Must();
        SimpleTreeNode lastArithmeticLogic4MustNode = node.getNode();

        if (ctx.MUSTACHE_ARITHMETIC() != null){
            lastArithmeticLogic4Must.setArithmetic(ctx.MUSTACHE_ARITHMETIC().getSymbol().getText());
            lastArithmeticLogic4MustNode.addChild(new SimpleTreeNode(lastArithmeticLogic4Must.getArithmetic()));
        }
        //this
        if (ctx.collection4MUSTArithmetic() != null){
            lastArithmeticLogic4MustNode.addChild(addNode("collection4MUSTArithmetic"));
            lastArithmeticLogic4Must.setCollection4MUSTArithmetic((Collection4MUSTArithmetic) visitCollection4MUSTArithmetic(ctx.collection4MUSTArithmetic()));
        }
        //or
        if (ctx.arithmeticLogic4Must() != null){
            lastArithmeticLogic4MustNode.addChild(addNode("arithmeticLogic4Must"));
            lastArithmeticLogic4Must.setArithmeticLogic((ArithmeticLogic4Must) visitArithmeticLogic4Must(ctx.arithmeticLogic4Must()));
        }

        return lastArithmeticLogic4Must;
    }
    @Override
    public Object visitMustacheVariable(HTMLParser.MustacheVariableContext ctx) {
        MustacheVariable mustacheVariable = new MustacheVariable();
        SimpleTreeNode mustacheVariableNode = node.getNode();
        if (ctx.MUSTACHE_IDENTIFIER() != null){
            mustacheVariable.setMustacheVariable(ctx.MUSTACHE_IDENTIFIER().getSymbol().getText());
            mustacheVariableNode.addChild(new SimpleTreeNode(mustacheVariable.getMustacheVariable()));
        }

        return mustacheVariable;
    }

    @Override
    public Object visitMustacheNumber(HTMLParser.MustacheNumberContext ctx) {
        MustacheNumber mustacheNumber = new MustacheNumber();
        SimpleTreeNode mustacheNumberNode = node.getNode();
        if (ctx.MUSTACHE_NUMBER() != null){
            // TODO i don't know if this is right or not
            double numberType = Double.parseDouble(ctx.MUSTACHE_NUMBER().getSymbol().getText());
            // For check what's the type of Number
            if (numberType == (int) numberType) {
                mustacheNumber.setNumber(Integer.parseInt(ctx.MUSTACHE_NUMBER().getSymbol().getText()));
                mustacheNumberNode.addChild(new SimpleTreeNode(mustacheNumber.getNumber().toString()));
            }
            else if (numberType == (float)numberType){
                mustacheNumber.setNumber(Float.parseFloat(ctx
                        .MUSTACHE_NUMBER().getSymbol().getText()));
                mustacheNumberNode.addChild(new SimpleTreeNode(mustacheNumber.getNumber().toString()));
            }
            else{
                mustacheNumber.setNumber(Double.parseDouble(ctx.MUSTACHE_NUMBER().getSymbol().getText()));
                mustacheNumberNode.addChild(new SimpleTreeNode(mustacheNumber.getNumber().toString()));
            }
        }

        return mustacheNumber;
    }

    @Override
    public Object visitMustacheValue(HTMLParser.MustacheValueContext ctx) {
        MustacheValue mustacheValue = new MustacheValue();
        SimpleTreeNode mustacheValueNode = node.getNode();

        if (ctx.mustacheNumber() != null){
            mustacheValueNode.addChild(addNode("mustacheNumber"));
            mustacheValue.setMustacheNumber((MustacheNumber) visitMustacheNumber(ctx.mustacheNumber()));
        }

        if (ctx.MUSTACHE_STRING() != null){
            mustacheValue.setMustacheString(ctx.MUSTACHE_STRING().getSymbol().getText());
            mustacheValueNode.addChild(new SimpleTreeNode(mustacheValue.getMustacheString()));
        }

        if (ctx.MUSTACHE_TRUE() != null){
            mustacheValue.setMustacheTrue(true);
            mustacheValueNode.addChild(new SimpleTreeNode("True"));
        }

        if (ctx.MUSTACHE_FALSE() != null){
            mustacheValue.setMustacheFalse(false);
            mustacheValueNode.addChild(new SimpleTreeNode("False"));
        }

        if (ctx.MUSTACHE_NULL() != null){
            mustacheValue.setMUSTACHE_NULL(null);
            mustacheValueNode.addChild(new SimpleTreeNode("Null"));
        }

        return mustacheValue;
    }

    @Override
    public Object visitObjArray4Must(HTMLParser.ObjArray4MustContext ctx) {
        ObjArray4Must objArray4Must = new ObjArray4Must();
        SimpleTreeNode objArray4MustNode = node.getNode();

        if (ctx.arrName4Must() != null){
            objArray4MustNode.addChild(addNode("arrName4Must"));
            objArray4Must.setArrName4Must1((ArrName4Must) visitArrName4Must(ctx.arrName4Must()));
        }

        if (ctx.arrayCalling4Must() != null){
            objArray4MustNode.addChild(addNode("arrayCalling4Must"));
            objArray4Must.setArrayCalling4Must((ArrayCalling4Must) visitArrayCalling4Must(ctx.arrayCalling4Must()));
        }

        return objArray4Must;
    }

    @Override
    public Object visitArrName4Must(HTMLParser.ArrName4MustContext ctx) {
        ArrName4Must arrName4Must = new ArrName4Must();
        SimpleTreeNode arrName4MustNode = node.getNode();
        if (ctx.MUSTACHE_IDENTIFIER() != null){
            arrName4Must.setArrName4Must(ctx.MUSTACHE_IDENTIFIER().getSymbol().getText());
            arrName4MustNode.addChild(new SimpleTreeNode(arrName4Must.getArrName4Must()));
        }

        return arrName4Must;
    }

    @Override
    public Object visitArrayCalling4Must(HTMLParser.ArrayCalling4MustContext ctx) {
        ArrayCalling4Must arrayCalling4Must = new ArrayCalling4Must();
        SimpleTreeNode arrayCalling4MustNode = node.getNode();

        if (!ctx.arithmeticLogic4Must().isEmpty()){
            List<ArithmeticLogic4Must> arithmeticLogic4Musts = new ArrayList<>();
            for (int i = 0 ; i < ctx.arithmeticLogic4Must().size() ; i ++){
                arrayCalling4MustNode.addChild(addNode("arithmeticLogic4Must"));
                arithmeticLogic4Musts.add((ArithmeticLogic4Must) visitArithmeticLogic4Must(ctx.arithmeticLogic4Must(i)));
            }
            arrayCalling4Must.setArithmeticLogic4Must(arithmeticLogic4Musts);
        }

        if (ctx.functionCallFromVar4Must() != null){
            arrayCalling4MustNode.addChild(addNode("functionCallFromVar4Must"));
            arrayCalling4Must.setFunctionCallFromVar4Must((FunctionCallFromVar4Must) visitFunctionCallFromVar4Must(ctx.functionCallFromVar4Must()));
        }

        if (ctx.property4Must() != null){
            arrayCalling4MustNode.addChild(addNode("property4Must"));
            arrayCalling4Must.setProperty4Must((Property4Must) visitProperty4Must(ctx.property4Must()));
        }

        return arrayCalling4Must;
    }

    @Override
    public Object visitFunctionCall4Must(HTMLParser.FunctionCall4MustContext ctx) {
        FunctionCall4Must functionCall4Must = new FunctionCall4Must();
        SimpleTreeNode functionCall4MustNode = node.getNode();

        if (ctx.functionName4Must() != null){
            functionCall4MustNode.addChild(addNode("functionName4Must"));
            functionCall4Must.setFunctionName4Must1((FunctionName4Must) visitFunctionName4Must(ctx.functionName4Must()));
        }

        if (ctx.functionCallFromVar4Must() != null){
            functionCall4MustNode.addChild(addNode("functionCallFromVar4Must"));
            functionCall4Must.setFunctionCallFromVar4Must((FunctionCallFromVar4Must) visitFunctionCallFromVar4Must(ctx.functionCallFromVar4Must()));
        }

        return functionCall4Must;
    }

    @Override
    public Object visitFunctionCallFromVar4Must(HTMLParser.FunctionCallFromVar4MustContext ctx) {
        FunctionCallFromVar4Must functionCallFromVar4Must = new FunctionCallFromVar4Must();
        SimpleTreeNode functionCallFromVar4MustNode = node.getNode();

        if (!ctx.parameters4Must().isEmpty()){
            List<Parameters4Must> parameters4Musts = new ArrayList<>();
            for (int i = 0 ; i < ctx.parameters4Must().size() ; i ++){
                functionCallFromVar4MustNode.addChild(addNode("parameters4Must"));
                parameters4Musts.add((Parameters4Must) visitParameters4Must(ctx.parameters4Must(i)));
            }
            functionCallFromVar4Must.setParameters4Must(parameters4Musts);
        }

        if (ctx.arrayCalling4Must() != null){
            functionCallFromVar4MustNode.addChild(addNode("arrayCalling4Must"));
            functionCallFromVar4Must.setArrayCalling4Must((ArrayCalling4Must) visitArrayCalling4Must(ctx.arrayCalling4Must()));
        }

        if (ctx.property4Must() != null){
            functionCallFromVar4MustNode.addChild(addNode("property4Must"));
            functionCallFromVar4Must.setProperty4Must((Property4Must) visitProperty4Must(ctx.property4Must()));
        }

        return functionCallFromVar4Must;
    }

    @Override
    public Object visitFunctionName4Must(HTMLParser.FunctionName4MustContext ctx) {
        FunctionName4Must functionName4Must = new FunctionName4Must();
        SimpleTreeNode functionName4MustNode = node.getNode();
        if (ctx.MUSTACHE_IDENTIFIER() != null){
            functionName4Must.setFunctionName4Must(ctx.MUSTACHE_IDENTIFIER().getSymbol().getText());
            functionName4MustNode.addChild(new SimpleTreeNode(functionName4Must.getFunctionName4Must()));
        }

        return functionName4Must;
    }

    @Override
    public Object visitParameters4Must(HTMLParser.Parameters4MustContext ctx) {
        Parameters4Must parameters4Must = new Parameters4Must();
        SimpleTreeNode parameters4MustNode = node.getNode();

        if (!ctx.parameter4Must().isEmpty()){
            List<Parameter4Must> parameter4Musts = new ArrayList<>();
            for (int i = 0 ; i < ctx.parameter4Must().size() ; i ++){
                parameters4MustNode.addChild(addNode("parameter4Must"));
                parameter4Musts.add((Parameter4Must) visitParameter4Must(ctx.parameter4Must(i)));
            }
            parameters4Must.setParameters4Musts(parameter4Musts);
        }

        return parameters4Must;
    }

    @Override
    public Object visitParameter4Must(HTMLParser.Parameter4MustContext ctx) {
        Parameter4Must parameter4Must = new Parameter4Must();
        SimpleTreeNode parameter4MustNode = node.getNode();

        if (ctx.collection4Mustache() != null){
            parameter4MustNode.addChild(addNode("collection4Mustache"));
            parameter4Must.setCollection4Mustache((Collection4Mustache) visitCollection4Mustache(ctx.collection4Mustache()));
        }
        return parameter4Must;
    }

    @Override
    public Object visitSubObj4Must(HTMLParser.SubObj4MustContext ctx) {
        SubObj4Must subObj4Must = new SubObj4Must();
        SimpleTreeNode subObj4MustNode = node.getNode();

        if (ctx.MUSTACHE_IDENTIFIER() != null){
            subObj4Must.setSubObj4MustName(ctx.MUSTACHE_IDENTIFIER().getSymbol().getText());
            subObj4MustNode.addChild(new SimpleTreeNode(subObj4Must.getSubObj4MustName()));
        }

        if (ctx.property4Must() != null){
            subObj4MustNode.addChild(addNode("property4Must"));
            subObj4Must.setProperty4Must((Property4Must) visitProperty4Must(ctx.property4Must()));
        }

        return subObj4Must;
    }

    @Override
    public Object visitProperty4Must(HTMLParser.Property4MustContext ctx) {
        Property4Must property4Must = new Property4Must();
        SimpleTreeNode property4MustNode = node.getNode();

        if (!ctx.propertyValue4Must().isEmpty()){
            List<PropertyValue4Must> propertyValue4Musts = new ArrayList<>();
            for (int i = 0 ; i < ctx.propertyValue4Must().size() ; i ++){
                property4MustNode.addChild(addNode("propertyValue4Must"));
                propertyValue4Musts.add((PropertyValue4Must) visitPropertyValue4Must(ctx.propertyValue4Must(i)));
            }
            property4Must.setPropertyValue4Must(propertyValue4Musts);
        }

        if (ctx.arrayCalling4Must() != null){
            property4MustNode.addChild(addNode("arrayCalling4Must"));
            property4Must.setArrayCalling4Must((ArrayCalling4Must) visitArrayCalling4Must(ctx.arrayCalling4Must()));
        }

        if (ctx.functionCallFromVar4Must() != null){
            property4MustNode.addChild(addNode("functionCallFromVar4Must"));
            property4Must.setFunctionCallFromVar4Must((FunctionCallFromVar4Must) visitFunctionCallFromVar4Must(ctx.functionCallFromVar4Must()));
        }

        return property4Must;
    }

    @Override
    public Object visitPropertyValue4Must(HTMLParser.PropertyValue4MustContext ctx) {
        PropertyValue4Must propertyValue4Must = new PropertyValue4Must();
        SimpleTreeNode propertyValue4MustNode = node.getNode();

        if (ctx.MUSTACHE_IDENTIFIER() != null){
            propertyValue4Must.setPropertyValue4Must(ctx.MUSTACHE_IDENTIFIER().getSymbol().getText());
            propertyValue4MustNode.addChild(new SimpleTreeNode(propertyValue4Must.getPropertyValue4Must()));
        }
        return propertyValue4Must;
    }

    @Override
    public Object visitOneLineCondition4Must(HTMLParser.OneLineCondition4MustContext ctx) {
        OneLineCondition4Must oneLineCondition4Must = new OneLineCondition4Must();
        SimpleTreeNode oneLineCondition4MustNode = node.getNode();

        if (ctx.logicComprison4Must() != null){
            oneLineCondition4MustNode.addChild(addNode("logicComprison4Must"));
            oneLineCondition4Must.setLogicComprison4Must((LogicComprison4Must) visitLogicComprison4Must(ctx.logicComprison4Must()));
        }

        if (ctx.collection4Mustache() != null){
            oneLineCondition4MustNode.addChild(addNode("Collection4Mustache1"));
            oneLineCondition4Must.setCollection4Mustache1((Collection4Mustache) visitCollection4Mustache(ctx.collection4Mustache(0)));

            //

            oneLineCondition4MustNode.addChild(addNode("Collection4Mustache2"));
            oneLineCondition4Must.setCollection4Mustache2((Collection4Mustache) visitCollection4Mustache(ctx.collection4Mustache(1)));
        }
        return oneLineCondition4Must;
    }

    @Override
    public Object visitOneLineArithCondition4Must(HTMLParser.OneLineArithCondition4MustContext ctx) {
        OneLineArithCondition4Must oneLineArithCondition4Must = new OneLineArithCondition4Must();
        SimpleTreeNode oneLineArithCondition4MustNode = node.getNode();

        if (ctx.logicComprison4Must() != null){
            oneLineArithCondition4MustNode.addChild(addNode("logicComprison4Must"));
            oneLineArithCondition4Must.setLogicComprison4Must((LogicComprison4Must) visitLogicComprison4Must(ctx.logicComprison4Must()));
        }

        if (ctx.arithmeticLogic4Must() != null){
            oneLineArithCondition4MustNode.addChild(addNode("ArithmeticLogic4Must1"));
            oneLineArithCondition4Must.setArithmeticLogic4Must1((ArithmeticLogic4Must) visitArithmeticLogic4Must(ctx.arithmeticLogic4Must(0)));

            //

            oneLineArithCondition4MustNode.addChild(addNode("ArithmeticLogic4Must2"));
            oneLineArithCondition4Must.setArithmeticLogic4Must2((ArithmeticLogic4Must) visitArithmeticLogic4Must(ctx.arithmeticLogic4Must(1)));
        }

        return oneLineArithCondition4Must;
    }

    @Override
    public Object visitOneLineBoolCondition4Must(HTMLParser.OneLineBoolCondition4MustContext ctx) {
        OneLineBoolCondition4Must oneLineBoolCondition4Must = new OneLineBoolCondition4Must();
        SimpleTreeNode oneLineBoolCondition4MustNode = node.getNode();

        if (ctx.logicComprison4Must() != null){
            oneLineBoolCondition4MustNode.addChild(addNode("logicComprison4Must"));
            oneLineBoolCondition4Must.setLogicComprison4Must((LogicComprison4Must) visitLogicComprison4Must(ctx.logicComprison4Must()));
        }

        if (ctx.MUSTACHE_TRUE() != null){
            oneLineBoolCondition4Must.setTrue(true);
            oneLineBoolCondition4MustNode.addChild(new SimpleTreeNode("True"));
        }
        if (ctx.MUSTACHE_FALSE() != null){
            oneLineBoolCondition4Must.setFalse(false);
            oneLineBoolCondition4MustNode.addChild(new SimpleTreeNode("False"));
        }

        return oneLineBoolCondition4Must;
    }

    @Override
    public Object visitComparisonExp4Must(HTMLParser.ComparisonExp4MustContext ctx) {
        ComparisonExp4Must comparisonExp4Must = new ComparisonExp4Must();
        SimpleTreeNode comparisonExp4MustNode = node.getNode();

        if (ctx.collection4CompMust() != null){
            comparisonExp4MustNode.addChild(addNode("Collection4CompMust"));
            comparisonExp4Must.setCollection4CompMust((Collection4CompMust) visitCollection4CompMust(ctx.collection4CompMust(0)));

            //

            comparisonExp4MustNode.addChild(addNode("Collection4CompMust2"));
            comparisonExp4Must.setCollection4CompMust2((Collection4CompMust) visitCollection4CompMust(ctx.collection4CompMust(1)));
        }

        if (ctx.mustacheComparisonOperator() != null){
            comparisonExp4MustNode.addChild(addNode("mustacheComparisonOperator"));
            comparisonExp4Must.setMustacheComparisonOperator((MustacheComparisonOperator) visitMustacheComparisonOperator(ctx.mustacheComparisonOperator()));
        }

        return comparisonExp4Must;
    }

    @Override
    public Object visitMustacheComparisonOperator(HTMLParser.MustacheComparisonOperatorContext ctx) {
        MustacheComparisonOperator mustacheComparisonOperator = new MustacheComparisonOperator();
        SimpleTreeNode mustacheComparisonOperatorNode = node.getNode();

        if (ctx.MUSTACHE_GREATER_THAN() != null){

            mustacheComparisonOperator.setOperator(ctx.MUSTACHE_GREATER_THAN().getSymbol().getText());
            mustacheComparisonOperatorNode.addChild(new SimpleTreeNode(mustacheComparisonOperator.getOperator()));
        }

        if (ctx.MUSTACHE_GREATER_EQ() != null){

            mustacheComparisonOperator.setOperator(ctx.MUSTACHE_GREATER_EQ().getSymbol().getText());
            mustacheComparisonOperatorNode.addChild(new SimpleTreeNode(mustacheComparisonOperator.getOperator()));
        }



        if (ctx.MUSTACHE_LESS_THAN() != null){

            mustacheComparisonOperator.setOperator(ctx.MUSTACHE_LESS_THAN().getSymbol().getText());
            mustacheComparisonOperatorNode.addChild(new SimpleTreeNode(mustacheComparisonOperator.getOperator()));
        }


        if (ctx.MUSTACHE_LESS_EQ() != null){

            mustacheComparisonOperator.setOperator(ctx.MUSTACHE_LESS_EQ().getSymbol().getText());
            mustacheComparisonOperatorNode.addChild(new SimpleTreeNode(mustacheComparisonOperator.getOperator()));
        }


        if (ctx.MUSTACHE_EQUAL_TO() != null){

            mustacheComparisonOperator.setOperator(ctx.MUSTACHE_EQUAL_TO().getSymbol().getText());
            mustacheComparisonOperatorNode.addChild(new SimpleTreeNode(mustacheComparisonOperator.getOperator()));
        }
        if (ctx.MUSTACHE_NOT_EQUAL() != null){

            mustacheComparisonOperator.setOperator(ctx.MUSTACHE_NOT_EQUAL().getSymbol().getText());
            mustacheComparisonOperatorNode.addChild(new SimpleTreeNode(mustacheComparisonOperator.getOperator()));
        }

        return mustacheComparisonOperator;
    }

    @Override
    public Object visitFilter(HTMLParser.FilterContext ctx) {
        Filter filter = new Filter();
        SimpleTreeNode filterNode = node.getNode();

        if (ctx.MUSTACHE_FILTER() != null){
            filter.setFilter(ctx.MUSTACHE_FILTER().getSymbol().getText());
            filterNode.addChild(new SimpleTreeNode(filter.getFilter()));
        }

        if (ctx.formatName() != null){
            filterNode.addChild(addNode("formatName"));
            filter.setFormatName((FormatName) visitFormatName(ctx.formatName()));
        }

        if (ctx.MUSTACHE_STRING() != null){
            filterNode.addChild(addNode("mustacheString"));
            filter.setMustacheString(ctx.MUSTACHE_STRING().getSymbol().getText());
        }
        return filter;
    }

    @Override
    public Object visitFormatName(HTMLParser.FormatNameContext ctx) {
        FormatName formatName = new FormatName();
        SimpleTreeNode formatNameNode = node.getNode();
        if (ctx.MUSTACHE_IDENTIFIER() != null){
            formatName.setMustachIdentifier(ctx.MUSTACHE_IDENTIFIER().getSymbol().getText());
            formatNameNode.addChild(new SimpleTreeNode(formatName.getMustachIdentifier()));
        }
        return formatName;
    }

    @Override
    public Object visitScript(HTMLParser.ScriptContext ctx) {
        Script script = new Script();
        SimpleTreeNode scriptNode = node.getNode();

        if (ctx.SCRIPT_OPEN() != null){
            script.setScriptOpen(ctx.SCRIPT_OPEN().getSymbol().getText());
            scriptNode.addChild(new SimpleTreeNode(script.getScriptOpen()));
        }

        if (ctx.SCRIPT_BODY() != null){
            script.setScriptBody(ctx.SCRIPT_BODY().getSymbol().getText());
            scriptNode.addChild(new SimpleTreeNode(script.getScriptBody()));
        }

        if (ctx.SCRIPT_SHORT_BODY() != null){
            script.setScripShortBody(ctx.SCRIPT_SHORT_BODY().getSymbol().getText());
            scriptNode.addChild(new SimpleTreeNode(script.getScripShortBody()));
        }

        return script;
    }

    @Override
    public Object visitStyle(HTMLParser.StyleContext ctx) {
        Style style = new Style();
        SimpleTreeNode styleNode = node.getNode();

        if (ctx.STYLE_OPEN() != null){
            style.setStyleOpen(ctx.STYLE_OPEN().getSymbol().getText());
            styleNode.addChild(new SimpleTreeNode(style.getStyleOpen()));
        }

        if (ctx.STYLE_BODY() != null){
            style.setStyleBody(ctx.STYLE_BODY().getSymbol().getText());
            styleNode.addChild(new SimpleTreeNode(style.getStyleBody()));
        }

        if (ctx.STYLE_SHORT_BODY() != null){
            style.setStyleShort(ctx.STYLE_SHORT_BODY().getSymbol().getText());
            styleNode.addChild( new SimpleTreeNode(style.getStyleShort()));
        }

        return style;
    }
    //////////////////////////////////////////////////

    public void printTree(){

        new ListingTreePrinter().print(root);
    }
    public SimpleTreeNode addNode(String text){
        SimpleTreeNode tempNode = new SimpleTreeNode("Visit " +text );
        node.setNode(tempNode);
        return node.getNode();
    }
}
