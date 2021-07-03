package generateCode;

import AST.Elements.ElementsNodes.CpExpression.For.*;
import AST.Elements.ElementsNodes.CpExpression.If.IfExpression;
import AST.Elements.ElementsNodes.CpExpression.Switch.SwitchCaseExpression;
import AST.Elements.ElementsNodes.CpExpression.Switch.SwitchExpression;
import AST.Elements.ElementsNodes.CpExpression.annotation.*;
import AST.Elements.ElementsNodes.CpExpression.app.AppExpression;
import AST.Elements.ElementsNodes.CpExpression.model.ModelExpression;
import AST.Elements.ElementsNodes.CpExpression.showHide.HideExpression;
import AST.Elements.ElementsNodes.CpExpression.showHide.ShowExpression;
import AST.Elements.ElementsNodes.HtmlAttribute;
import AST.Elements.ElementsNodes.generic4Elements.*;
import AST.Elements.ElementsNodes.generic4Elements.Logic.ArithmeticLogic;
import AST.Elements.ElementsNodes.generic4Elements.Logic.LastArithmeticLogic;
import AST.Elements.ElementsNodes.generic4Elements.Logic.LogicComprison;
import AST.Elements.ElementsNodes.generic4Elements.Logic.MiddleAndLastLogicComparison;
import AST.Elements.ElementsNodes.generic4Elements.array.Array;
import AST.Elements.ElementsNodes.generic4Elements.array.ArrayCalling;
import AST.Elements.ElementsNodes.generic4Elements.array.ObjArray;
import AST.Elements.ElementsNodes.generic4Elements.comparison.ComparisonExpression;
import AST.Elements.ElementsNodes.generic4Elements.comparison.OneLineArithCondition;
import AST.Elements.ElementsNodes.generic4Elements.comparison.OneLineBoolCondition;
import AST.Elements.ElementsNodes.generic4Elements.comparison.OneLineCondition;
import AST.Elements.ElementsNodes.generic4Elements.function.FunctionCall;
import AST.Elements.ElementsNodes.generic4Elements.function.FunctionCallFromVar;
import AST.Elements.ElementsNodes.generic4Elements.function.Parameter;
import AST.Elements.ElementsNodes.generic4Elements.function.Parameters;
import AST.Elements.ElementsNodes.generic4Elements.object.ObjBody;
import AST.Elements.ElementsNodes.generic4Elements.object.SubObj;
import AST.Elements.ElementsNodes.generic4Elements.property.Property;
import AST.Elements.ElementsNodes.mustacheExpression.MustacheExpression;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Collection4CompMust;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Collection4LogicRet4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Collection4MUSTArithmetic;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Collection4Mustache;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Logic.ArithmeticLogic4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Logic.LastArithmeticLogic4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Logic.LogicComprison4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Logic.MiddleAndLastLogicComparison4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.array.ArrayCalling4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.array.ObjArray4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.comparison.ComparisonExp4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.comparison.OneLineArithCondition4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.comparison.OneLineBoolCondition4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.comparison.OneLineCondition4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.function.FunctionCall4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.function.FunctionCallFromVar4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.function.Parameter4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.function.Parameters4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.object.SubObj4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.property.Property4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.value.MustacheValue;
import AST.Elements.HtmlElement;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CodeGeneration {
    StringBuilder JSContent = new StringBuilder();
    String JSFile;
    public String App;

    public CodeGeneration(String JSFile) {
        this.JSFile = JSFile;
    }

    public void start() {
        JSContent.append("<script>\n");
        //ToDo add switch &&Show $$ hide to changes[]
        JSContent.append("changes = [];\n");
        JSContent.append("renders = [];\n");
        JSContent.append(" new_elements = [];\n");
    }

    public void end(){
        JSContent.append("        function render() {\n" +
                "            setInterval(() => {\n" +
                "                console.log(\"render\")\n" +
                "                // for (change in changes) {\n" +
                "                for (var i = 0; i < changes.length; i++) {\n" +
                "                    // console.log(changes[i]);\n" +
                "                    changes[i]();\n" +
                "                }\n" +
                "                changes = [];\n" +
                "                for (var i = 0; i < renders.length; i++) {\n" +
                "                    renders[i]();\n" +
                "                    }"+
                "            }, 1000);\n" +
                "        }\n" +
                "        render();\n");
        JSContent.append("</script>\n");

        File jsFile = new File(JSFile);
        if (jsFile.exists()){
            jsFile.delete();
        }
        try{

            FileWriter fw = new FileWriter(jsFile);
            fw.write(JSContent.toString());
            fw.close();
        }catch (IOException e){
            System.out.println("can't write to JS file");
        }
    }

    public void dealWithAppExp(List<HtmlAttribute> attributes){
        AppExpression appExpression = null;
        String appValue= null;
        String id = null;

        //Get Model And Id From Element
        for (HtmlAttribute ha : attributes) {
            if (ha.getModelExpression() != null) {
                appExpression = ha.getAppExpression();
            }
            if (ha.getTagName() != null) {
                if (ha.getTagName().equals("id")) {
                    id = ha.getAttValue().substring(1,ha.getAttValue().length()-1);
                }
            }
        }
        if (id == null || appExpression == null) {
            throw new NullPointerException(id);
        }

        App = appValue;
    }



    // CP-MODEL
    public void dealWIthModel(List<HtmlAttribute> attributes){

        ModelExpression modelExp = null;
        String modelValue = null;
        String id = null;

        //Get Model And Id From Element
        for (HtmlAttribute ha : attributes) {
            if (ha.getModelExpression() != null) {
                modelExp = ha.getModelExpression();
            }
            if (ha.getTagName() != null) {
                if (ha.getTagName().equals("id")) {
                    id = ha.getAttValue().substring(1,ha.getAttValue().length()-1);


                }
            }
        }
        if (id == null || modelExp == null) {
            throw new NullPointerException(id);
        }



        if (modelExp.getCollection4Model1().getVariable() != null) {
            modelValue=ModelVarible(modelExp);
            JSContent.append(" document.getElementById(\""+id+"\").value = "+modelValue+";\n");

            JSContent.append(" var "+id+"Changes = function (event) {\n" +
                    "var temp"+id+"Changes = "+modelValue+ ";\n"+
                    "            "+modelValue+" = document.getElementById(\""+id+"\").value;\n" +
                    "        };\n");
        } else if (modelExp.getCollection4Model1().getSubObj() != null) {
            modelValue= ModelSubobj(modelExp);
            JSContent.append(" document.getElementById(\""+id+"\").value = "+modelValue+";\n");

            JSContent.append(" var "+id+"Changes = function (event) {\n" +
                    "var temp"+id+"Changes = "+modelValue+ ";\n"+
                    "            "+modelValue+" = document.getElementById(\""+id+"\").value;\n" +
                    "        };\n");

        }else if(modelExp.getCollection4Model1().getOneLine4ModelCondition()!=null){
            modelValue=ModelOneLine4ModelCondition(modelExp);
            JSContent.append(
                    "document.getElementById(\""+id+"\").value = "+modelValue+";");

         // TODO check this
            /*
            (1 < 2 ? ( 2 < 2 ? a : c) : b)
            if(1 < 2){
                app.a = = document.getElementById(\""+id+"\").value;\n" ;
            }else{
                app.b =
            }*/


        }else if(modelExp.getCollection4Model1().getFunctionCall()!=null){
            modelValue=ModelFunctioncall(modelExp);
            JSContent.append("document.getElementById(\""+id+"\").value = "+modelValue+";\n");

            JSContent.append(" var "+id+"Changes = function (event) {\n" +
                    "            "+modelValue+" = document.getElementById(\""+id+"\").value;\n" +
                    "        };\n");
        }




        JSContent.append("document.getElementById(\""+id+"\").addEventListener(\"input\", function(event) {\n" +
                "            changes.push("+id+"Changes);\n" +
                "        });\n" +
                "        changes.push("+id+"Changes);\n");


    }

    public String ModelVarible(ModelExpression modelExp ){
        return " "+App+"."+modelExp.getCollection4Model1().getVariable().getVariableName().getIdentifier();

    }
    public String ModelSubobj(ModelExpression modelExp){
        return dealWithSubObj(modelExp.getCollection4Model1().getSubObj());
    }
    public String ModelObjArray(ModelExpression modelExp){
          return dealWithObjArray(modelExp.getCollection4Model1().getObjArray());
    }
    public String ModelFunctioncall(ModelExpression modelExp){
      return dealWithFunctionCall(modelExp.getCollection4Model1().getFunctionCall());
    }
    public String ModelOneLine4ModelCondition(ModelExpression modelExp) {

        StringBuilder tempValue = new StringBuilder();
        tempValue.append("( ");

        //LogicComprison
        if(modelExp.getCollection4Model1().getOneLine4ModelCondition().getLogicComprison()!=null){
           // tempValue.append();
        }
        tempValue.append(" ? ");

        //Collection4Model1_1_1
        if (modelExp.getCollection4Model1().getOneLine4ModelCondition().getCollection4Model1_1_1().getVariable() != null) {
            tempValue.append(ModelVarible(modelExp));
        } else if (modelExp.getCollection4Model1().getOneLine4ModelCondition().getCollection4Model1_1_1().getSubObj() != null){
            tempValue.append(ModelSubobj(modelExp));
        }
        else if(modelExp.getCollection4Model1().getOneLine4ModelCondition().getCollection4Model1_1_1().getObjArray()!=null){
            tempValue.append( ModelObjArray(modelExp));
        }else if(modelExp.getCollection4Model1().getOneLine4ModelCondition().getCollection4Model1_1_1().getFunctionCall()!=null){
            tempValue.append(ModelFunctioncall(modelExp));
        }

        tempValue.append(" : ");

        //getCollection4Model1_1_2
        if(modelExp.getCollection4Model1().getOneLine4ModelCondition().getCollection4Model1_1_2().getVariable()!=null){
            tempValue.append(ModelVarible(modelExp));
        } else if (modelExp.getCollection4Model1().getOneLine4ModelCondition().getCollection4Model1_1_2().getSubObj() != null){
            tempValue.append(ModelSubobj(modelExp));
        }
        else if(modelExp.getCollection4Model1().getOneLine4ModelCondition().getCollection4Model1_1_2().getObjArray()!=null){
            tempValue.append( ModelObjArray(modelExp));
        }else if(modelExp.getCollection4Model1().getOneLine4ModelCondition().getCollection4Model1_1_2().getFunctionCall()!=null){
            tempValue.append( ModelFunctioncall(modelExp));
        }

        tempValue.append(" )");
        return tempValue.toString();
    }




   // CP-Show
    public void dealWithShow(List<HtmlAttribute> attributes){

       ShowExpression showExp=null;
       String id=null;
       String showValue=null;

        //Get Id and Show From Element
        for (HtmlAttribute ha : attributes) {
            if (ha.getShowExpression() != null) {
                showExp = ha.getShowExpression();
            }
            if (ha.getTagName() != null) {
                if (ha.getTagName().equals("id")) {
                    id = ha.getAttValue().substring(1,ha.getAttValue().length()-1);
                }
            }
        }

        if (id == null || showExp == null) {
            throw new NullPointerException(id);
        }

        // Get Show Value
        if (showExp.getLogicComprison() != null) {
            showValue=ShowLogicComparison(showExp);

            JSContent.append("" +
                    "var "+id+"render function (event) {\n\n" +
                    "if("+showValue.substring(1,showValue.length()-1)+")\n " +
                    " document.getElementById(\""+id+"\").style.display=\"block\";" +
                    "else" +
                    "document.getElementById(\""+id+"\").style.display=\"none\";\n\n" +
                    "}\n\n" +
                    "renders.push("+id+"render");

        }


    }
    public String ShowLogicComparison(ShowExpression showExp){
       return dealWithLogicComparison(showExp.getLogicComprison());
    }


    // CP-Hide
    public void dealWithHide(List<HtmlAttribute> attributes){

        HideExpression hideExp=null;
        String id=null;
        String hideValue=null;

        //Get Id and Hide From Element
        for (HtmlAttribute ha : attributes) {
            if (ha.getHideExpression() != null) {
                hideExp = ha.getHideExpression();
            }
            if (ha.getTagName() != null) {
                if (ha.getTagName().equals("id")) {
                    id = ha.getAttValue().substring(1,ha.getAttValue().length()-1);


                }
            }
        }

        if (id == null || hideExp == null) {
            throw new NullPointerException(id);
        }

        // Get Show Value
        if (hideExp.getLogicComprison() != null) {
            hideValue=HideLogicComparison(hideExp);
            JSContent.append("" +
                    "var "+id+"render function (event) {\n\n" +
                    "if("+hideValue.substring(1,hideValue.length()-1)+")\n " +
                    " document.getElementById(\""+id+"\").style.display=\"none\";" +
                    "else" +
                    "document.getElementById(\""+id+"\").style.display=\"block\";\n\n" +
                    "}\n\n" +
                    "renders.push("+id+"render");
        }

    }
    public String HideLogicComparison(HideExpression hideExp){
        return dealWithLogicComparison(hideExp.getLogicComprison());
    }


    //CP-Switch
    public void dealWithSwitch(List<HtmlAttribute> attributes, HtmlElement htmlElement){
        SwitchExpression switchExp=null;
        SwitchCaseExpression switchCaseExp=null;
        String id=null;
        String idSwitchcase=null;
        String switchValue=null;
        String switchcaseValue=null;

        //Get Id and Switch From Element
        for (HtmlAttribute ha : attributes) {
            if (ha.getSwitchExpression() != null) {
                switchExp = ha.getSwitchExpression();
            }
            if (ha.getTagName() != null) {
                if (ha.getTagName().equals("id")) {
                    id = ha.getAttValue().substring(1,ha.getAttValue().length()-1);
                }
            }
        }

        if (id == null || switchExp == null) {
            throw new NullPointerException(id);
        }

        if(switchExp.getCollection4Switch1().getVariable()!=null){
            switchValue=SwitchVarible(switchExp);

        }
        else if(switchExp.getCollection4Switch1().getSubObj()!=null){
            switchValue=SwitchSubobj(switchExp);

        }else if(switchExp.getCollection4Switch1().getObjArray()!=null){
            switchValue=SwitchObjArray(switchExp);

        }else if(switchExp.getCollection4Switch1().getNumber()!=null){
            switchValue=SwitchNumber(switchExp);

        }else if(switchExp.getCollection4Switch1().getString()!=null){
            switchValue=SwitchString(switchExp);

        }else if(switchExp.getCollection4Switch1().getArithmeticLogic()!=null){
            switchValue=SwitchArithmeticLogic(switchExp);

        }else if(switchExp.getCollection4Switch1().getOneLine4switch1()!=null){
            switchValue=SwitchOneLine4switch1(switchExp);
        }


        JSContent.append("" +
                "var "+id+"render function (event) {\n\n" +
                "switch("+switchValue+"){\n\n");
        for(HtmlElement h: htmlElement.getHtmlContent().getHtmlElement() ){

            for(HtmlAttribute ha: h.getHtmlAttributeList()){
                if (ha.getTagName() != null) {
                    if (ha.getTagName().equals("id")) {
                        idSwitchcase = ha.getAttValue().substring(1,ha.getAttValue().length()-1);
                    }
                    if (idSwitchcase == null) {
                        throw new NullPointerException(idSwitchcase);
                    }
                }
                if(ha.getSwitchCaseExpression()!=null){
                    switchcaseValue=discussionsSwitchcase(switchExp,ha.getSwitchCaseExpression(),idSwitchcase);
                    if (switchcaseValue == null) {
                        throw new NullPointerException(idSwitchcase);
                    }

                    JSContent.append("case "+switchcaseValue+":\n" +
                            "document.getElementById(\""+idSwitchcase+"\").style.display=\"block\";\n" +
                            "break; \n\n");
                }

               //ToDo switch case default

                JSContent.append("}} \n\n" +
                        "renders.push("+id+"render");
            }


        }




    }
    public String SwitchVarible(SwitchExpression switchExp ){
        return " "+App+"."+switchExp.getCollection4Switch1().getVariable().getVariableName().getIdentifier();

    }
    public String SwitchSubobj(SwitchExpression switchExp){
        return dealWithSubObj(switchExp.getCollection4Switch1().getSubObj()).toString();
    }
    public String SwitchObjArray(SwitchExpression switchExp){
        return dealWithObjArray(switchExp.getCollection4Switch1().getObjArray());
    }
    public String SwitchNumber(SwitchExpression switchExp){
        return switchExp.getCollection4Switch1().getNumber().getNumber().toString();
    }
    public String SwitchString(SwitchExpression switchExp){

        return switchExp.getCollection4Switch1().getString();
    }
    public String SwitchArithmeticLogic(SwitchExpression switchExp){
        return dealWithArithLogic(switchExp.getCollection4Switch1().getArithmeticLogic());
    }

    public String SwitchOneLine4switch1(SwitchExpression switchExp){
        StringBuilder tempValue = new StringBuilder();
        tempValue.append("( ");

        //LogicComprison
        if(switchExp.getCollection4Switch1().getOneLine4switch1().getLogicComprison()!=null){
            tempValue.append(dealWithLogicComparison(switchExp.getCollection4Switch1().getOneLine4switch1().getLogicComprison()));


        }
        tempValue.append(" ? ");

        //Collection4Model1_1_1
        if (switchExp.getCollection4Switch1().getOneLine4switch1().getCollection4Switch1_1_1().getVariable() != null) {
            tempValue.append(SwitchVarible(switchExp));
        } else if (switchExp.getCollection4Switch1().getOneLine4switch1().getCollection4Switch1_1_1().getSubObj() != null){
            tempValue.append(SwitchSubobj(switchExp));
        }
        else if(switchExp.getCollection4Switch1().getOneLine4switch1().getCollection4Switch1_1_1().getObjArray()!=null){
            tempValue.append( SwitchObjArray(switchExp));
        }else if(switchExp.getCollection4Switch1().getOneLine4switch1().getCollection4Switch1_1_1().getArithmeticLogic()!=null){
            tempValue.append(SwitchArithmeticLogic(switchExp));
        }else if(switchExp.getCollection4Switch1().getOneLine4switch1().getCollection4Switch1_1_1().getNumber()!=null){
            tempValue.append(SwitchNumber(switchExp));
        }else if(switchExp.getCollection4Switch1().getOneLine4switch1().getCollection4Switch1_1_1().getString()!=null){
            tempValue.append(SwitchString(switchExp));
        }else if(switchExp.getCollection4Switch1().getOneLine4switch1().getCollection4Switch1_1_1().getOneLine4switch1()!=null){
            tempValue.append(SwitchOneLine4switch1(switchExp));
        }

        tempValue.append(" : ");

        //getCollection4Model1_1_2
        if (switchExp.getCollection4Switch1().getOneLine4switch1().getCollection4Switch1_1_2().getVariable() != null) {
            tempValue.append(SwitchVarible(switchExp));
        } else if (switchExp.getCollection4Switch1().getOneLine4switch1().getCollection4Switch1_1_2().getSubObj() != null){
            tempValue.append(SwitchSubobj(switchExp));
        }
        else if(switchExp.getCollection4Switch1().getOneLine4switch1().getCollection4Switch1_1_2().getObjArray()!=null){
            tempValue.append( SwitchObjArray(switchExp));
        }else if(switchExp.getCollection4Switch1().getOneLine4switch1().getCollection4Switch1_1_2().getArithmeticLogic()!=null){
            tempValue.append(SwitchArithmeticLogic(switchExp));
        }else if(switchExp.getCollection4Switch1().getOneLine4switch1().getCollection4Switch1_1_2().getNumber()!=null){
            tempValue.append(SwitchNumber(switchExp));
        }else if(switchExp.getCollection4Switch1().getOneLine4switch1().getCollection4Switch1_1_2().getString()!=null){
            tempValue.append(SwitchString(switchExp));
        }else if(switchExp.getCollection4Switch1().getOneLine4switch1().getCollection4Switch1_1_2().getOneLine4switch1()!=null){
            tempValue.append(SwitchOneLine4switch1(switchExp));
        }
        tempValue.append(" )");

        return tempValue.toString();
    }


    public String discussionsSwitchcase(SwitchExpression switchExp ,SwitchCaseExpression switchCaseExp,String id){


        String switchValue=null;
        if(switchCaseExp.getCollection4Switch1().getVariable()!=null){
            switchValue=SwitchVarible(switchExp);

        }else if(switchCaseExp.getCollection4Switch1().getSubObj()!=null){
            switchValue=SwitchSubobj(switchExp);

        }else if(switchCaseExp.getCollection4Switch1().getObjArray()!=null){
            switchValue=SwitchObjArray(switchExp);

        }else if(switchCaseExp.getCollection4Switch1().getNumber()!=null){
            switchValue=SwitchNumber(switchExp);

        }else if(switchCaseExp.getCollection4Switch1().getString()!=null){
            switchValue=SwitchString(switchExp);

        }else if(switchCaseExp.getCollection4Switch1().getArithmeticLogic()!=null){
            switchValue=SwitchArithmeticLogic(switchExp);

        }else if(switchCaseExp.getCollection4Switch1().getOneLine4switch1()!=null){

            switchValue=SwitchOneLine4switch1(switchExp);
        }
       return switchValue;
    }


  /*  //CP-If
    public void dealWithIf(List<HtmlAttribute> attributes,HtmlElement htmlElement){
        IfExpression ifExp=null;
        String id=null;
        String ifValue=null;

        //Get Id and If From Element
        for (HtmlAttribute ha : attributes) {
            if (ha.getIfExpression() != null) {
                ifExp = ha.getIfExpression();
            }
            if (ha.getTagName() != null) {
                if (ha.getTagName().equals("id")) {
                    id = ha.getAttValue().substring(1,ha.getAttValue().length()-1);
                }
            }

        }

        if (id == null || ifExp == null) {
            throw new NullPointerException(id);
        }

        JSContent.append(" var "+id+"Changes = function () {\n" );
        JSContent.append("document.getElementById(\""+id+"\").remove();");
        if(ifExp.getLogicComprison()!=null){
            ifValue=dealWithLogicComparison(ifExp.getLogicComprison());
            JSContent.append("if("+ifValue+"){\n ");
            JSContent.append("var element=document.createElement(\""+htmlElement.getTagName()+"\");");
            IfContent(htmlElement);
            JSContent.append("} ");
            JSContent.append(" };\n\n" +
                    "renders.push("+id+"Changes");
        }


    }
    public void IfContent(HtmlElement htmlElement){

         String mustachvalue=null;
         String id=null;
        if( htmlElement.getHtmlContent().getHtmlElement()!=null){
            int i=0;
            for(HtmlElement h: htmlElement.getHtmlContent().getHtmlElement()){

                JSContent.append("var element"+i+"=document.createElement(\""+h.getTagName()+"\");\n\n");
                if(h.getHtmlAttributeList()!=null){
                    int j=0;
                    for(HtmlAttribute ha:h.getHtmlAttributeList()){
                        if (ha.getTagName() != null) {
                            if (ha.getTagName().equals("id")) {
                                id = ha.getAttValue().substring(1,ha.getAttValue().length()-1);
                            }
                        }
                        JSContent.append("var att"+j+"=document.createAttribute(\""+ha.getTagName()+"\");\n" +
                                "att"+j+".value="+ha.getAttValue()+";\n\n");
                    }
                    JSContent.append("element"+i+".setAttributeNode(att"+j+");\n\n");

                }
                else if(h.getHtmlContent()!=null){
                    IfContent(h);
                }else if(h.getMustacheExpression()!=null){
                    mustachvalue=dealWithMustacheExp(id,h.getMustacheExpression());
                    JSContent.append("var mustach=document.creatTextNode("+mustachvalue+");" +
                            "element"+i+".appenChild(mustach) }\n\n");

                }
                JSContent.append("element"+i+".appenChild(h) \n}\n\n");
                i++;
            }

        }
        else if( htmlElement.getHtmlContent().getHtmlCharData()!=null){
                JSContent.append("var CharData=document.creatTextNode(\""+htmlElement.getHtmlContent().getHtmlCharData()+"\");" +
                        "element.appenChild(CharData) }\n\n");
        }
        else if( htmlElement.getHtmlContent().getCDATA()!=null){
            JSContent.append("var cdata=document.creatTextNode(\""+htmlElement.getHtmlContent().getCDATA()+"\");" +
                    "element.appenChild(cdata) }\n\n");
        }else if( htmlElement.getMustacheExpression()!=null){
            mustachvalue=dealWithMustacheExp(id,htmlElement.getMustacheExpression());
            JSContent.append("var mustach=document.creatTextNode("+mustachvalue+");" +
                    "element.appenChild(mustach) }\n\n");

        }
    }


    //CP-For
    public void dealWithFor(List<HtmlAttribute> attributes,HtmlElement htmlElement){
        ForExpression forExp=null;
        String id=null;
        String collection4For1_1_1=null;
        String collection4For1_1_2=null;
        String collection4For2_1_1=null;
        String collection4For1_2_1=null;
        String collection4For1_2_2=null;
        String collection4For3_2_1=null;
        String collection4For4_3_1=null;

        //Get Id and for From Element
        for (HtmlAttribute ha : attributes) {
            if (ha.getForExpression() != null) {
                forExp = ha.getForExpression();
            }
            if (ha.getTagName() != null) {
                if (ha.getTagName().equals("id")) {
                    id = ha.getAttValue().substring(1,ha.getAttValue().length()-1);
                }
            }
        }

        if (id == null || forExp == null) {
            throw new NullPointerException(id);
        }


       //Collection4For1_1_1
        if(forExp.getCollection4For1_1_1().getVariable()!=null){
            collection4For1_1_1=forExp.getCollection4For1_1_1().getVariable().toString();
        }else if(forExp.getCollection4For1_1_1().getSubObj()!=null){
            collection4For1_1_1=ForSubObj(forExp.getCollection4For1_1_1().getSubObj());
        }else if(forExp.getCollection4For1_1_1().getObjArray()!=null){
            collection4For1_1_1=ForObjArray(forExp.getCollection4For1_1_1().getObjArray());
        }

        if(collection4For1_1_1!=null){

            collection4For2_1_1=discussionsCollection4For2_1_1(forExp.getCollection4For2_1_1());
           //discussion for 1
            if(collection4For2_1_1!=null){

                if(forExp.getCollection4For1_1_2().getVariable()!=null){
                    collection4For1_1_2=forExp.getCollection4For1_1_2().getVariable().toString();

                }else if(forExp.getCollection4For1_1_2().getSubObj()!=null){
                    collection4For1_1_2=ForSubObj(forExp.getCollection4For1_1_1().getSubObj());
                }else if(forExp.getCollection4For1_1_2().getObjArray()!=null){
                    collection4For1_1_2=ForObjArray(forExp.getCollection4For1_1_1().getObjArray());
                }

                //discussion model for 1_2
                //ex:for(i in a ; z = INDEX )
                if(collection4For1_1_2!=null){
                    JS4For1_2(id,htmlElement,collection4For1_1_1,collection4For2_1_1,collection4For1_1_2);
                }else{
                    //discussion model for 1_1
                    //for(i in "fatima")
                    JS4For1_1(id,htmlElement,collection4For1_1_1,collection4For2_1_1);
                }
            }
            else{
                //discussion model for 2
                //for(i,j in a)

                ///Collection4For1_2_1
                if(forExp.getCollection4For1_2_1().getVariable()!=null){
                    collection4For1_2_1=forExp.getCollection4For1_2_1().getVariable().toString();

                }else if(forExp.getCollection4For1_2_1().getSubObj()!=null){
                    collection4For1_2_1=ForSubObj(forExp.getCollection4For1_2_1().getSubObj());
                }else if(forExp.getCollection4For1_2_1().getObjArray()!=null){
                    collection4For1_2_1=ForObjArray(forExp.getCollection4For1_2_1().getObjArray());
                }


                ///Collection4For1_2_2

                if(forExp.getCollection4For1_2_2().getVariable()!=null){
                    collection4For1_2_2=forExp.getCollection4For1_2_2().getVariable().toString();

                }else if(forExp.getCollection4For1_2_2().getSubObj()!=null){
                    collection4For1_2_2=ForSubObj(forExp.getCollection4For1_2_2().getSubObj());
                }else if(forExp.getCollection4For1_2_2().getObjArray()!=null){
                    collection4For1_2_2=ForObjArray(forExp.getCollection4For1_2_2().getObjArray());
                }


                //// collection4For3_2_1
                if(forExp.getCollection4For3_2_1().getFunctionCall()!=null){
                    collection4For3_2_1=ForFunctionCall(forExp.getCollection4For3_2_1().getFunctionCall());
                }else if(forExp.getCollection4For3_2_1().getObjArray()!=null){
                    collection4For3_2_1=ForObjArray(forExp.getCollection4For3_2_1().getObjArray());
                }else if(forExp.getCollection4For3_2_1().getOneLine4For3Condition()!=null){
                    collection4For3_2_1=dealWithOneLine4For3Condition(forExp.getCollection4For3_2_1().getOneLine4For3Condition());
                }else if(forExp.getCollection4For3_2_1().getSubObj()!=null){
                    collection4For3_2_1=ForSubObj(forExp.getCollection4For3_2_1().getSubObj());
                }else if(forExp.getCollection4For3_2_1().getObjBody()!=null){
                    collection4For3_2_1=dealWithObjBody(forExp.getCollection4For3_2_1().getObjBody());
                }else if(forExp.getCollection4For3_2_1().getObj()!=null){
                    collection4For3_2_1=" " + App+ "."+ forExp.getCollection4For3_2_1().getObj().getIdentifier();
                }
                JS4For2(id,htmlElement,collection4For1_2_1, collection4For1_2_2, collection4For3_2_1);

            }

        }
        else{
             //discussion model for 3
            //for(true)
            collection4For4_3_1=discussionsCollection4For4_3_1(forExp.getCollection4For4_3_1());
            JS4For3(id, htmlElement,collection4For4_3_1);

        }



    }
    public String ForVariable( ForExpression forExp){
        return " " + App + "." +forExp.getCollection4For1_1_1().getVariable().toString();
    }
    public String ForSubObj(SubObj so){
        return dealWithSubObj(so);
    }
    public String ForObjArray(ObjArray  oa){
        return dealWithObjArray(oa);
    }
    public String ForComparisonExpression(ComparisonExpression CS){
        return dealWithComparisonExp(CS);
    }
    public String ForFunctionCall(FunctionCall FC){
        return dealWithFunctionCall(FC);
    }
  /*  public String ForLogicComprison(LogicComprison lo){
        return dealWithLogicComparison(lo);
    }
    public String ForArithmeticLogic(ArithmeticLogic al){
        return dealWithArithLogic(al);
    }
    public String discussionsCollection4For4_3_1(Collection4For4 collection4For4){
        String Collection4For4_3_1=null;

        if(collection4For4.getArithmeticLogic()!=null){
            Collection4For4_3_1=ForArithmeticLogic(collection4For4.getArithmeticLogic());

        }else if(collection4For4.getComparisonExpression()!=null){
            Collection4For4_3_1=ForComparisonExpression(collection4For4.getComparisonExpression());

        }else if(collection4For4.getFunctionCall()!=null){
            Collection4For4_3_1=ForFunctionCall(collection4For4.getFunctionCall());

        }else if(collection4For4.getLogicComprison()!=null){
            Collection4For4_3_1=ForLogicComprison(collection4For4.getLogicComprison());

        }else if(collection4For4.getOneLine4For4Condition()!=null){
          //  Collection4For4_3_1=dealWithOneLineCond(collection4For4.getOneLine4For4Condition());
            //TODO creat dealwithOneLine4For4Condition()

        }else  if(collection4For4.getVariable()!=null){
            Collection4For4_3_1=collection4For4.getVariable().toString();
        }else if(collection4For4.getSubObj()!=null){
            Collection4For4_3_1=ForSubObj(collection4For4.getSubObj());
        }else if(collection4For4.getObjArray()!=null){
            Collection4For4_3_1=ForObjArray(collection4For4.getObjArray());
        }else if(collection4For4.getNumber()!=null){
            Collection4For4_3_1=collection4For4.getNumber().toString();
        }else if(collection4For4.getTrueOrFalse()!=null){
            Collection4For4_3_1=collection4For4.getTrueOrFalse().toString();
        }
        return Collection4For4_3_1;
    }
    public String discussionsCollection4For2_1_1(Collection4For2 collection4For2){
        String Collection4For2_1_1=null;

        if(collection4For2.getArithmeticLogic()!=null) {
            Collection4For2_1_1 = ForArithmeticLogic(collection4For2.getArithmeticLogic());

        }else if(collection4For2.getFunctionCall()!=null) {
            Collection4For2_1_1 = ForFunctionCall(collection4For2.getFunctionCall());

        }else  if(collection4For2.getVariable()!=null){
            Collection4For2_1_1=collection4For2.getVariable().toString();
        }else if(collection4For2.getSubObj()!=null){
            Collection4For2_1_1=ForSubObj(collection4For2.getSubObj());
        }else if(collection4For2.getObjArray()!=null){
            Collection4For2_1_1=ForObjArray(collection4For2.getObjArray());
        }else if(collection4For2.getNumber()!=null){
            Collection4For2_1_1=collection4For2.getNumber().toString();
        }
        return Collection4For2_1_1;
    }
    public String discussionsCollection4For3_1_1(Collection4For3 collection4For3){
        String Collection4For3_1_1=null;

      if(collection4For3.getFunctionCall()!=null) {
          Collection4For3_1_1 = ForFunctionCall(collection4For3.getFunctionCall());


        }else if(collection4For3.getSubObj()!=null){
          Collection4For3_1_1=ForSubObj(collection4For3.getSubObj());
        }else if(collection4For3.getObjArray()!=null){
          Collection4For3_1_1=ForObjArray(collection4For3.getObjArray());
        }else if(collection4For3.getOneLine4For3Condition()!=null){
          Collection4For3_1_1=dealWithOneLine4For3Condition(collection4For3.getOneLine4For3Condition());
      }else if(collection4For3.getObj()!=null){
          Collection4For3_1_1=collection4For3.getObj().getIdentifier();
      }else if(collection4For3.getObjBody()!=null){
          Collection4For3_1_1= dealWithObjBody(collection4For3.getObjBody());
      }
        return Collection4For3_1_1;
    }
    public String dealWithOneLine4For3Condition(OneLine4For3Condition oneLine4For3Condition){
        StringBuilder tempValue = new StringBuilder();
        String lineValue=null;
        tempValue.append("(");
        if(oneLine4For3Condition.getLogicComprison()!=null){
            lineValue= ForLogicComprison(oneLine4For3Condition.getLogicComprison());
            tempValue.append(lineValue);
        }
        tempValue.append("?");
        if(oneLine4For3Condition.getCollection4For3_1_1()!=null){
            lineValue= discussionsCollection4For3_1_1(oneLine4For3Condition.getCollection4For3_1_1());
            tempValue.append(lineValue);
        }
        tempValue.append(":");
        if(oneLine4For3Condition.getCollection4For3_1_2()!=null){
            lineValue= discussionsCollection4For3_1_1(oneLine4For3Condition.getCollection4For3_1_1());
            tempValue.append(lineValue);
        }
        tempValue.append(")");
        return  tempValue.toString();
    }
    public void JS4For1_1(String id,HtmlElement htmlElement,String collection4For1_1_1, String collection4For2_1_1){
        JSContent.append(" let originalElement"+id+" = document.getElementById(\""+id+"\");" +
                "let container"+id+" = originalElement"+id+".parentElement;");

        if(htmlElement.getHtmlContent().getHtmlElement()!=null){
            JSContent.append(
                    "var "+id+"randem="+collection4For2_1_1.split(".")+";"+
                            "if("+id+"randem[1]== null)\n"+
                            "var "+id+"randem0="+collection4For2_1_1+"\n" +
                            "else "+id+"randem0="+id+"randem[1]"+
                            "var "+collection4For1_1_1+" "+
                            "for("+collection4For1_1_1+" in "+id+"randem0) \n");


        }
        else if(htmlElement.getHtmlContent().getHtmlCharData()!=null){
            JSContent.append(" let defaultText"+id+" =\""+htmlElement.getHtmlContent().getHtmlCharData()+"\";" +
                   "var "+id+"randem="+collection4For2_1_1.split(".")+";"+
                    "if("+id+"randem[1]== null)\n"+
                    "var "+id+"randem0="+collection4For2_1_1+"\n" +
                    "else "+id+"randem0="+id+"randem[1]"+
                    "var "+collection4For1_1_1+" "+
                    "for("+collection4For1_1_1+" in "+id+"randem0) {\n" +
                    " let elem = originalElement"+id+".cloneNode(true);\n" +
                    "elem.id = \""+id+"\" + "+collection4For1_1_1+";\n" +
                    " elem.innerHTML = defaultText"+id+";\n" +
                    " elem.hidden= false;\n" +
                    "container+"+id+"+.appendChild(elem);\n" +
                    " new_elements.push(elem);\n" +
                    "} \n " +
                    "originalElement"+id+".hidden = true;");

        }
        else if(htmlElement.getHtmlContent().getCDATA()!=null){
            JSContent.append(" let defaultText"+id+" =\""+htmlElement.getHtmlContent().getHtmlCharData()+"\";" +
                    "var "+id+"randem="+collection4For2_1_1.split(".")+";"+
                    "if("+id+"randem[1]== null)\n"+
                    "var "+id+"randem0="+collection4For2_1_1+"\n" +
                    "else "+id+"randem0="+id+"randem[1]"+
                    "var "+collection4For1_1_1+" "+
                    "for("+collection4For1_1_1+" in "+id+"randem0) {\n" +
                    " let elem = originalElement"+id+".cloneNode(true);\n" +
                    "elem.id = \""+id+"\" + "+collection4For1_1_1+";\n" +
                    " elem.innerHTML = defaultText"+id+";\n" +
                    " elem.hidden= false;\n" +
                    "container"+id+".appendChild(elem);\n" +
                    " new_elements.push(elem);\n" +
                    "} \n " +
                    "originalElement"+id+".hidden = true;");
        }
        else if(htmlElement.getMustacheExpression()!=null){
            String s=null;
            for(int i=0;i<htmlElement.getMustacheExpression().getMustacheContent().size();i++){
                s=s+"elem.innerHTML = defaultText"+id+".replace('{{"+htmlElement.getMustacheExpression().getMustacheContent().get(i).a+" }}',"+htmlElement.getMustacheExpression().getMustacheContent().get(i).b.getFormatName()+"("+id+"randem0));\n";
            }
            JSContent.append(" let defaultText"+id+" =\"{{"+dealWithMustacheExp(id,htmlElement.getMustacheExpression())+"}}\";" +
                    "var "+id+"randem="+collection4For2_1_1.split(".")+";"+
                    "if("+id+"randem[1]== null)\n"+
                    "var "+id+"randem0="+collection4For2_1_1+"\n" +
                    "else "+id+"randem0="+id+"randem[1]"+
                    "var "+collection4For1_1_1+" "+
                    "for("+collection4For1_1_1+" in "+id+"randem0) {\n" +
                    " let elem = originalElement"+id+".cloneNode(true);\n" +
                    "elem.id = \""+id+"\" + "+collection4For1_1_1+";\n" +

                     ""+s+""+
                     " elem.hidden= false;\n" +
                    "container"+id+".appendChild(elem);\n" +
                    " new_elements.push(elem);\n" +
                    "} \n " +
                    "originalElement"+id+".hidden = true;");
        }
    }
    public void JS4For1_2(String id,HtmlElement htmlElement,String collection4For1_1_1,String collection4For2_1_1,String collection4For1_1_2){
        JSContent.append(" let originalElement"+id+" = document.getElementById(\""+id+"\");" +
                "let container"+id+" = originalElement"+id+".parentElement;");

        if(htmlElement.getHtmlContent().getHtmlElement()!=null){
            JSContent.append(
                    "var "+id+"randem="+collection4For2_1_1.split(".")+";"+
                            "if("+id+"randem[1]== null)\n"+
                            "var "+id+"randem0="+collection4For2_1_1+"\n" +
                            "else "+id+"randem0="+id+"randem[1]"+
                            "var "+collection4For1_1_1+" "+
                            "for("+collection4For1_1_1+" in "+id+"randem0 ; "+collection4For1_1_2+" = INDEX) \n");


        }
        else if(htmlElement.getHtmlContent().getHtmlCharData()!=null){
            JSContent.append(" let defaultText"+id+" =\""+htmlElement.getHtmlContent().getHtmlCharData()+"\";" +
                    "var "+id+"randem="+collection4For2_1_1.split(".")+";"+
                    "if("+id+"randem[1]== null)\n"+
                    "var "+id+"randem0="+collection4For2_1_1+"\n" +
                    "else "+id+"randem0="+id+"randem[1]"+
                    "var "+collection4For1_1_1+" "+
                    "for("+collection4For1_1_1+" in "+id+"randem0 ; "+collection4For1_1_2+" = INDEX) \n"+
                    " let elem = originalElement"+id+".cloneNode(true);\n" +
                    "elem.id = \""+id+"\" + "+collection4For1_1_1+";\n" +
                    " elem.innerHTML = defaultText"+id+";\n" +
                    " elem.hidden= false;\n" +
                    "container+"+id+"+.appendChild(elem);\n" +
                    " new_elements.push(elem);\n" +
                    "} \n " +
                    "originalElement"+id+".hidden = true;");

        }
        else if(htmlElement.getHtmlContent().getCDATA()!=null){
            JSContent.append(" let defaultText"+id+" =\""+htmlElement.getHtmlContent().getHtmlCharData()+"\";" +
                    "var "+id+"randem="+collection4For2_1_1.split(".")+";"+
                    "if("+id+"randem[1]== null)\n"+
                    "var "+id+"randem0="+collection4For2_1_1+"\n" +
                    "else "+id+"randem0="+id+"randem[1]"+
                    "var "+collection4For1_1_1+" "+
                    "for("+collection4For1_1_1+" in "+id+"randem0 ; "+collection4For1_1_2+" = INDEX) \n"+
                    " let elem = originalElement"+id+".cloneNode(true);\n" +
                    "elem.id = \""+id+"\" + "+collection4For1_1_1+";\n" +
                    " elem.innerHTML = defaultText"+id+";\n" +
                    " elem.hidden= false;\n" +
                    "container"+id+".appendChild(elem);\n" +
                    " new_elements.push(elem);\n" +
                    "} \n " +
                    "originalElement"+id+".hidden = true;");
        }
        else if(htmlElement.getMustacheExpression()!=null){
            String s=null;
            for(int i=0;i<htmlElement.getMustacheExpression().getMustacheContent().size();i++){
                s=s+"elem.innerHTML = defaultText"+id+".replace('{{"+htmlElement.getMustacheExpression().getMustacheContent().get(i).a+" }}',"+htmlElement.getMustacheExpression().getMustacheContent().get(i).b.getFormatName()+"("+id+"randem0));\n";
            }
            JSContent.append(" let defaultText"+id+" =\"{{"+dealWithMustacheExp(id,htmlElement.getMustacheExpression())+"}}\";" +
                    "var "+id+"randem="+collection4For2_1_1.split(".")+";"+
                    "if("+id+"randem[1]== null)\n"+
                    "var "+id+"randem0="+collection4For2_1_1+"\n" +
                    "else "+id+"randem0="+id+"randem[1]"+
                    "var "+collection4For1_1_1+" "+
                    "for("+collection4For1_1_1+" in "+id+"randem0 ; "+collection4For1_1_2+" = INDEX) \n"+
                    " let elem = originalElement"+id+".cloneNode(true);\n" +
                    "elem.id = \""+id+"\" + "+collection4For1_1_1+";\n" +

                    ""+s+""+
                    " elem.hidden= false;\n" +
                    "container"+id+".appendChild(elem);\n" +
                    " new_elements.push(elem);\n" +
                    "} \n " +
                    "originalElement"+id+".hidden = true;");
        }
    }
    public void JS4For2(String id,HtmlElement htmlElement,String collection4For1_2_1, String collection4For1_2_2, String collection4For3_2_1){
        JSContent.append(" let originalElement"+id+" = document.getElementById(\""+id+"\");" +
                "let container"+id+" = originalElement"+id+".parentElement;");

        if(htmlElement.getHtmlContent().getHtmlElement()!=null){
            JSContent.append(
                    "var "+id+"randem="+collection4For3_2_1.split(".")+";"+
                            "if("+id+"randem[1]== null)\n"+
                            "var "+id+"randem0="+collection4For3_2_1+"\n" +
                            "else "+id+"randem0="+id+"randem[1]"+
                            "var "+collection4For1_2_1+" "+
                            "var "+collection4For1_2_2+" "+
                            "for("+collection4For1_2_2+","+collection4For1_2_1+" in "+id+"randem0) \n");


        }
        else if(htmlElement.getHtmlContent().getHtmlCharData()!=null){
            JSContent.append(" let defaultText"+id+" =\""+htmlElement.getHtmlContent().getHtmlCharData()+"\";" +
                    "var "+id+"randem="+collection4For3_2_1.split(".")+";"+
                    "if("+id+"randem[1]== null)\n"+
                    "var "+id+"randem0="+collection4For3_2_1+"\n" +
                    "else "+id+"randem0="+id+"randem[1]"+
                    "var "+collection4For1_2_1+" "+
                    "var "+collection4For1_2_2+" "+
                    "for("+collection4For1_2_2+","+collection4For1_2_1+" in "+id+"randem0) \n"+
            " let elem = originalElement"+id+".cloneNode(true);\n" +
                    "elem.id = \""+id+"\" + "+collection4For1_2_1+";\n" +
                    " elem.innerHTML = defaultText"+id+";\n" +
                    " elem.hidden= false;\n" +
                    "container+"+id+"+.appendChild(elem);\n" +
                    " new_elements.push(elem);\n" +
                    "} \n " +
                    "originalElement"+id+".hidden = true;");

        }
        else if(htmlElement.getHtmlContent().getCDATA()!=null){
            JSContent.append(" let defaultText"+id+" =\""+htmlElement.getHtmlContent().getHtmlCharData()+"\";" +
                    "var "+id+"randem="+collection4For3_2_1.split(".")+";"+
                    "if("+id+"randem[1]== null)\n"+
                    "var "+id+"randem0="+collection4For3_2_1+"\n" +
                    "else "+id+"randem0="+id+"randem[1]"+
                    "var "+collection4For1_2_1+" "+
                    "var "+collection4For1_2_2+" "+
                    "for("+collection4For1_2_2+","+collection4For1_2_1+" in "+id+"randem0) \n"+

                  " let elem = originalElement"+id+".cloneNode(true);\n" +
                    "elem.id = \""+id+"\" + "+collection4For1_2_1+";\n" +
                    " elem.innerHTML = defaultText"+id+";\n" +
                    " elem.hidden= false;\n" +
                    "container"+id+".appendChild(elem);\n" +
                    " new_elements.push(elem);\n" +
                    "} \n " +
                    "originalElement"+id+".hidden = true;"  );
        }
        else if(htmlElement.getMustacheExpression()!=null){
            String s=null;
            for(int i=0;i<htmlElement.getMustacheExpression().getMustacheContent().size();i++){
                s=s+"elem.innerHTML = defaultText"+id+".replace('{{"+htmlElement.getMustacheExpression().getMustacheContent().get(i).a+" }}',"+htmlElement.getMustacheExpression().getMustacheContent().get(i).b.getFormatName()+"("+id+"randem0));\n";
            }
            JSContent.append(" let defaultText"+id+" =\"{{"+dealWithMustacheExp(id,htmlElement.getMustacheExpression())+"}}\";" +
                    "var "+id+"randem="+collection4For3_2_1.split(".")+";"+
                    "if("+id+"randem[1]== null)\n"+
                    "var "+id+"randem0="+collection4For3_2_1+"\n" +
                    "else "+id+"randem0="+id+"randem[1]"+
                    "var "+collection4For1_2_1+" "+
                    "var "+collection4For1_2_2+" "+
                    "for("+collection4For1_2_2+","+collection4For1_2_1+" in "+id+"randem0) \n"+

                  " let elem = originalElement"+id+".cloneNode(true);\n" +
                    "elem.id = \""+id+"\" + "+collection4For1_2_1+";\n" +

                    ""+s+""+
                    " elem.hidden= false;\n" +
                    "container"+id+".appendChild(elem);\n" +
                    " new_elements.push(elem);\n" +
                    "} \n " +
                    "originalElement"+id+".hidden = true;");
        }
    }
    public void JS4For3(String id,HtmlElement htmlElement,String collection4For4_3_1){
        JSContent.append(" let originalElement"+id+" = document.getElementById(\""+id+"\");" +
                "let container"+id+" = originalElement"+id+".parentElement;");

        if(htmlElement.getHtmlContent().getHtmlElement()!=null){
            JSContent.append(

                            "for("+collection4For4_3_1+") \n");


        }
        else if(htmlElement.getHtmlContent().getHtmlCharData()!=null){
            JSContent.append(" let defaultText"+id+" =\""+htmlElement.getHtmlContent().getHtmlCharData()+"\";" +
                            "for("+collection4For4_3_1+") \n"+
                    " let elem = originalElement"+id+".cloneNode(true);\n" +
                    "elem.id = \""+id+"\" + "+collection4For4_3_1+";\n" +
                    " elem.innerHTML = defaultText"+id+";\n" +
                    " elem.hidden= false;\n" +
                    "container+"+id+"+.appendChild(elem);\n" +
                    " new_elements.push(elem);\n" +
                    "} \n " +
                    "originalElement"+id+".hidden = true;");

        }
        else if(htmlElement.getHtmlContent().getCDATA()!=null){
            JSContent.append(" let defaultText"+id+" =\""+htmlElement.getHtmlContent().getHtmlCharData()+"\";" +
                            "for("+collection4For4_3_1+") \n"+

                    " let elem = originalElement"+id+".cloneNode(true);\n" +
                    "elem.id = \""+id+"\" + "+collection4For4_3_1+";\n" +
                    " elem.innerHTML = defaultText"+id+";\n" +
                    " elem.hidden= false;\n" +
                    "container"+id+".appendChild(elem);\n" +
                    " new_elements.push(elem);\n" +
                    "} \n " +
                    "originalElement"+id+".hidden = true;"  );
        }
        else if(htmlElement.getMustacheExpression()!=null){
            String s=null;
            for(int i=0;i<htmlElement.getMustacheExpression().getMustacheContent().size();i++){
                s=s+"elem.innerHTML = defaultText"+id+".replace('{{"+htmlElement.getMustacheExpression().getMustacheContent().get(i).a+" }}',"+htmlElement.getMustacheExpression().getMustacheContent().get(i).b.getFormatName()+"("+id+"randem0));\n";
            }
            JSContent.append(" let defaultText"+id+" =\"{{"+dealWithMustacheExp(id,htmlElement.getMustacheExpression())+"}}\";" +
                    "for("+collection4For4_3_1+") \n"+

                    " let elem = originalElement"+id+".cloneNode(true);\n" +
                    "elem.id = \""+id+"\" + "+collection4For4_3_1+";\n" +

                    ""+s+""+
                    " elem.hidden= false;\n" +
                    "container"+id+".appendChild(elem);\n" +
                    " new_elements.push(elem);\n" +
                    "} \n " +
                    "originalElement"+id+".hidden = true;");
        }
    }

*/




    //@ckick
    public void dealWithClick(List<HtmlAttribute> attributes){
        Click click =null;
        String id=null;
        String clickvalue=null;

        //Get Id and for From Element
        for (HtmlAttribute ha : attributes) {
            if (ha.getClick() != null) {
                click = ha.getClick();
            }
            if (ha.getTagName() != null) {
                if (ha.getTagName().equals("id")) {
                    id = ha.getAttValue().substring(1,ha.getAttValue().length()-1);
                }
            }
        }

        if (id == null || click == null) {
            throw new NullPointerException(id);
        }


        if(click.getCollection4Annotation().getFunctionCall4AnnotOneLine()!=null){
            clickvalue=ClickFunctionCall4AnnotOneLine(click.getCollection4Annotation().getFunctionCall4AnnotOneLine());
            JSContent.append("function click1"+id+"(){\n" +
                    "var Click" + id + "=document.getElementById(\"" + id + "\")\n" +
                    "Click" + id + ".addEventListener(\"click\", " + click.getCollection4Annotation().getFunctionCall4AnnotOneLine().getFunctionName() + ");\n" +
                    "}\n" +
                    " changes.push(click1"+id+");");

        }
       else if(click.getCollection4Annotation().getArrName()!=null) {
            clickvalue = click.getCollection4Annotation().getArrName().getIdentifier();
            if (click.getCollection4Annotation().getArrayFuncRet4AnnotOneLine() != null) {
                clickvalue += ClickArrayFuncRet4AnnotOneLine(click.getCollection4Annotation().getArrayFuncRet4AnnotOneLine());
            }

            JSContent.append("function click1"+id+"(){\n" +
                    "var Click" + id + "=document.getElementById(\"" + id + "\")\n" +
                    "Click" + id + ".addEventListener(\"click\", " + clickvalue + ");\n" +
                    "}\n" +
                    " changes.push(click1"+id+");");
        } else if(click.getCollection4Annotation().getObj()!=null){
            clickvalue=click.getCollection4Annotation().getObj().getIdentifier();
            if(click.getCollection4Annotation().getPropFuncRet4AnnotOneLine()!=null){
                clickvalue+=ClickPropFuncRet4AnnotOneLine(click.getCollection4Annotation().getPropFuncRet4AnnotOneLine());
            }
            JSContent.append("function click1"+id+"(){\n" +
                    "var Click" + id + "=document.getElementById(\"" + id + "\")\n" +
                    "Click" + id + ".addEventListener(\"click\", " + clickvalue + ");\n" +
                    "}\n" +
                    " changes.push(click1"+id+");");

        }

        if(click.getCollection4Annotation().getOneLine4Annotation()!=null){
                clickvalue=ClickOneLine4Annotion(click.getCollection4Annotation().getOneLine4Annotation());
            JSContent.append("function click1"+id+"(){\n" +
                    "var Click" + id + "=document.getElementById(\"" + id + "\")\n" +
                    "Click" + id + ".addEventListener(\"click\", " + clickvalue + ");\n" +
                    "}\n" +
                    " changes.push(click1"+id+");");
        }


    }
    public String ClickParameters(ArrayList<Parameter> p){
        StringBuilder Pvalue=new StringBuilder() ;
        for(int i=0;i<p.size();i++){
            Pvalue.append(dealWithColl4Every(p.get(i).getCollection4everything()));
            Pvalue.append(",");
        }
        return Pvalue.toString();

    }
    public String ClickFunctionParameters(List<Parameters> FP){
        StringBuilder FPvalue=new StringBuilder() ;
        for(int i=0;i<FP.size();i++){
            FPvalue.append("(");
           FPvalue.append(ClickParameters(FP.get(i).getParameters()) );
            FPvalue.append(")");
        }
return  FPvalue.toString();
    }
    public String ClickFunctionCall4AnnotOneLine(FunctionCall4AnnotOneLine FC){
        StringBuilder FCvalue=new StringBuilder() ;


        if(FC.getFunctionName()!=null){
            FCvalue.append(FC.getFunctionName().getIdentifier());
        } if(FC.getFuncEndRet4AnnotOneLine()!=null){
            FCvalue.append(ClickFuncEndRet4AnnotOneLine(FC.getFuncEndRet4AnnotOneLine()));
        }
return FCvalue.toString();
    }
    public  String ClickPropFuncRet4AnnotOneLine(PropFuncRet4AnnotOneLine P){
        StringBuilder avalue=new StringBuilder() ;

        if(P.getPropertyValue()!=null){
            for(int i=0;i<P.getPropertyValue().size();i++){
                avalue.append(".");
                avalue.append(P.getPropertyValue().get(i).getIdentifier());
            }
        }
        if(P.getArrayFuncRet4AnnotOneLine()!=null){
            avalue.append(ClickArrayFuncRet4AnnotOneLine(P.getArrayFuncRet4AnnotOneLine()));
        }else if(P.getFuncEndRet4AnnotOneLine()!=null){
            avalue.append(ClickFuncEndRet4AnnotOneLine(P.getFuncEndRet4AnnotOneLine()));
        }
        return avalue.toString();

    }
    public String ClickArrayFuncRet4AnnotOneLine(ArrayFuncRet4AnnotOneLine a){
        StringBuilder avalue=new StringBuilder() ;
        avalue.append("(");
        if(a.getArithmeticLogics()!=null){
            for(int i=0;i<a.getArithmeticLogics().size();i++)
            avalue.append(dealWithArithLogic(a.getArithmeticLogics().get(i)));
        }
        avalue.append(")");
        if(a.getFuncEndRet4AnnotOneLine()!=null){
            avalue.append( ClickFuncEndRet4AnnotOneLine(a.getFuncEndRet4AnnotOneLine()));
        } else if(a.getPropFuncRet4AnnotOneLine()!=null){
            avalue.append(ClickPropFuncRet4AnnotOneLine(a.getPropFuncRet4AnnotOneLine()));
        }
        return  avalue.toString();
    }
    public String ClickFuncEndRet4AnnotOneLine(FuncEndRet4AnnotOneLine FC){
        StringBuilder FCvalue=new StringBuilder() ;
        FCvalue.append("(");
        if(FC.getFunctionParameters()!=null){
            FCvalue.append(ClickFunctionParameters(FC.getFunctionParameters()));
        }
        FCvalue.append(")");
        if(FC.getArrayFuncRet4AnnotOneLine()!=null){
            FCvalue.append(ClickArrayFuncRet4AnnotOneLine(FC.getArrayFuncRet4AnnotOneLine()));
        }else if(FC.getPropFuncRet4AnnotOneLine()!=null){
            FCvalue.append(ClickPropFuncRet4AnnotOneLine(FC.getPropFuncRet4AnnotOneLine()));
        }
return  FCvalue.toString();
    }
    public String ClickOneLine4Annotion(OneLine4Annotation oa){
        StringBuilder tempValue = new StringBuilder();
        tempValue.append("( ");

        //LogicComprison
        if(oa.getLogicComprison()!=null){
             tempValue.append(dealWithLogicComparison(oa.getLogicComprison()));
        }
        tempValue.append(" ? ");


        if (oa.getCollection4Annotation1_1().getOneLine4Annotation() != null) {
            tempValue.append(ClickOneLine4Annotion(oa.getCollection4Annotation1_1().getOneLine4Annotation()));
        } else if (oa.getCollection4Annotation1_1().getPropFuncRet4AnnotOneLine() != null){
            tempValue.append(ClickPropFuncRet4AnnotOneLine(oa.getCollection4Annotation1_1().getPropFuncRet4AnnotOneLine()));
        }
        else if(oa.getCollection4Annotation1_1().getFunctionCall4AnnotOneLine()!=null){
            tempValue.append( ClickFunctionCall4AnnotOneLine(oa.getCollection4Annotation1_1().getFunctionCall4AnnotOneLine()));
        }else if(oa.getCollection4Annotation1_1().getArrayFuncRet4AnnotOneLine()!=null){
            tempValue.append(ClickArrayFuncRet4AnnotOneLine(oa.getCollection4Annotation1_1().getArrayFuncRet4AnnotOneLine()));
        }else if(oa.getCollection4Annotation1_1().getObj()!=null){
            tempValue.append(oa.getCollection4Annotation1_1().getObj().getIdentifier());
        }else if(oa.getCollection4Annotation1_1().getArrName()!=null){
            tempValue.append(oa.getCollection4Annotation1_1().getArrName().getIdentifier());
        }

        tempValue.append(" : ");


        if (oa.getCollection4Annotation1_2().getOneLine4Annotation() != null) {
            tempValue.append(ClickOneLine4Annotion(oa.getCollection4Annotation1_2().getOneLine4Annotation()));
        } else if (oa.getCollection4Annotation1_2().getPropFuncRet4AnnotOneLine() != null){
            tempValue.append(ClickPropFuncRet4AnnotOneLine(oa.getCollection4Annotation1_2().getPropFuncRet4AnnotOneLine()));
        }
        else if(oa.getCollection4Annotation1_2().getFunctionCall4AnnotOneLine()!=null){
            tempValue.append( ClickFunctionCall4AnnotOneLine(oa.getCollection4Annotation1_2().getFunctionCall4AnnotOneLine()));
        }else if(oa.getCollection4Annotation1_2().getArrayFuncRet4AnnotOneLine()!=null){
            tempValue.append(ClickArrayFuncRet4AnnotOneLine(oa.getCollection4Annotation1_2().getArrayFuncRet4AnnotOneLine()));
        }else if(oa.getCollection4Annotation1_2().getObj()!=null){
            tempValue.append(oa.getCollection4Annotation1_2().getObj().getIdentifier());
        }else if(oa.getCollection4Annotation1_2().getArrName()!=null){
            tempValue.append(oa.getCollection4Annotation1_2().getArrName().getIdentifier());
        }

        tempValue.append(" )");
        return tempValue.toString();
    }


    //@double ckick
    public void dealWithdoubleClick(List<HtmlAttribute> attributes){
        DoubleClick click =null;
        String id=null;
        String clickvalue=null;

        //Get Id and for From Element
        for (HtmlAttribute ha : attributes) {
            if (ha.getDoubleClick() != null) {
                click = ha.getDoubleClick();
            }
            if (ha.getTagName() != null) {
                if (ha.getTagName().equals("id")) {
                    id = ha.getAttValue().substring(1,ha.getAttValue().length()-1);
                }
            }
        }

        if (id == null || click == null) {
            throw new NullPointerException(id);
        }


        if(click.getCollection4Annotation().getFunctionCall4AnnotOneLine()!=null){
            clickvalue=ClickFunctionCall4AnnotOneLine(click.getCollection4Annotation().getFunctionCall4AnnotOneLine());
            JSContent.append("function click1"+id+"(){\n" +
                    "var Click" + id + "=document.getElementById(\"" + id + "\")\n" +
                    "Click" + id + ".addEventListener(\"mouseout\", " + click.getCollection4Annotation().getFunctionCall4AnnotOneLine().getFunctionName() + ");\n" +
                    "}\n" +
                    " changes.push(click1"+id+");");

        }
        else if(click.getCollection4Annotation().getArrName()!=null) {
            clickvalue = click.getCollection4Annotation().getArrName().getIdentifier();
            if (click.getCollection4Annotation().getArrayFuncRet4AnnotOneLine() != null) {
                clickvalue += ClickArrayFuncRet4AnnotOneLine(click.getCollection4Annotation().getArrayFuncRet4AnnotOneLine());
            }

            JSContent.append("function click1"+id+"(){\n" +
                    "var Click" + id + "=document.getElementById(\"" + id + "\")\n" +
                    "Click" + id + ".addEventListener(\"mouseout\", " + clickvalue + ");\n" +
                    "}\n" +
                    " changes.push(click1"+id+");");
        } else if(click.getCollection4Annotation().getObj()!=null){
            clickvalue=click.getCollection4Annotation().getObj().getIdentifier();
            if(click.getCollection4Annotation().getPropFuncRet4AnnotOneLine()!=null){
                clickvalue+=ClickPropFuncRet4AnnotOneLine(click.getCollection4Annotation().getPropFuncRet4AnnotOneLine());
            }
            JSContent.append("function click1"+id+"(){\n" +
                    "var Click" + id + "=document.getElementById(\"" + id + "\")\n" +
                    "Click" + id + ".addEventListener(\"mouseout\", " + clickvalue + ");\n" +
                    "}\n" +
                    " changes.push(click1"+id+");");

        }

        if(click.getCollection4Annotation().getOneLine4Annotation()!=null){
            clickvalue=ClickOneLine4Annotion(click.getCollection4Annotation().getOneLine4Annotation());
            JSContent.append("function click1"+id+"(){\n" +
                    "var Click" + id + "=document.getElementById(\"" + id + "\")\n" +
                    "Click" + id + ".addEventListener(\"mouseout\", " + clickvalue + ");\n" +
                    "}\n" +
                    " changes.push(click1"+id+");");
        }


    }




    public String dealWithObjArray(ObjArray OA){

        StringBuilder st = new StringBuilder();

        if (OA.getArrName() != null){

            st.append(" "+App+"."+OA.getArrName().getIdentifier());
        }

        if (OA.getArrayCalling() != null){
            st.append(dealWithArrayCalling(OA.getArrayCalling()));
            return st.toString();
        }

        return "";
    }
    public String dealWithArrayCalling(ArrayCalling AC) {
        StringBuilder st = new StringBuilder();
        if (!AC.getArithmeticLogic().isEmpty()) {

            for (int i = 0; i < AC.getArithmeticLogic().size(); i++) {
                st.append(" [ ");
                st.append(dealWithArithLogic(AC.getArithmeticLogic().get(i)));
                st.append(" ] ");
            }
        }
        if (AC.getProperty() != null) {

            st.append(dealWithProperty(AC.getProperty()));
        } else if (AC.getFunctionCallFromVar() != null) {

            st.append(dealWithFunctionFromVar(AC.getFunctionCallFromVar()));
        }
        return st.toString();
    }

    public String dealWithArray(Array a){


        StringBuilder st = new StringBuilder();
        st.append("[ ");

        for (int i = 0 ; i < a.getInternalCollection4everythings().size() ; i++){

            st.append(dealWithColl4Every(a.getInternalCollection4everythings().get(i)));
            if (i != a.getInternalCollection4everythings().size() - 1){
                st.append(" , ");
            }
        }
        st.append(" ]");
        return st.toString();
    }

    public String dealWithObjBody(ObjBody OB){

        StringBuilder st = new StringBuilder();

        st.append(" { ");
        for (int i = 0 ; i < OB.getPairs().size() ; i ++){

            st.append("\"" + OB.getPairs().get(i).getKey().getIdentifier() + "\"");
            st.append(" : ");
            st.append("\"" + dealWithColl4Every(OB.getPairs().get(i).getCollection4everything()) + "\"");

            if (i != OB.getPairs().size() - 1){
                st.append(" , ");
            }
        }
        st.append(" } ");

        return st.toString();
    }
    public String dealWithSubObj(SubObj SO){

        StringBuilder st = new StringBuilder();
        st.append(" "+App+"."+SO.getIdentifier());
        st.append(dealWithProperty(SO.getProperty()));

        return st.toString();
    }
    public String dealWithProperty(Property p){
        StringBuilder st = new StringBuilder();

        for (int i = 0 ; i < p.getPropertyValues().size() ; i++){

            st.append(".");
            st.append(p.getPropertyValues().get(i).getIdentifier());
        }

        if (p.getArrayCalling() != null){
            st.append(dealWithArrayCalling(p.getArrayCalling()));
        }else if (p.getFunctionCallFromVar() != null){
            st.append(dealWithFunctionFromVar(p.getFunctionCallFromVar()));
        }

        return st.toString();

    }
    public String dealWithFunctionCall(FunctionCall FC){
        StringBuilder st = new StringBuilder();

        st.append(" "+App+"."+FC.getFunctionName().getIdentifier());
        st.append(dealWithFunctionFromVar(FC.getFunctionCallFromVar()));
        // return value
        return st.toString();
    }
    public String dealWithFunctionFromVar(FunctionCallFromVar FCV){

        StringBuilder st = new StringBuilder();

        for (int i = 0 ; i < FCV.getParameters().size() ; i ++){

            st.append("( ");
            st.append(dealWithparameters(FCV.getParameters().get(i)));
            st.append(" )");
        }


        if (FCV.getProperty() != null){
            st.append(dealWithProperty(FCV.getProperty()));
        }

        if (FCV.getArrayCalling() != null){
            st.append(dealWithArrayCalling(FCV.getArrayCalling()));
        }


        return st.toString();
    }
    public String dealWithparameters(Parameters p){

        StringBuilder st = new StringBuilder();
        for (int i = 0 ; i < p.getParameters().size() ; i++){
            Parameter parameter =  p.getParameters().get(i);
            st.append(dealWithColl4Every(parameter.getCollection4everything()));
        }


    return st.toString();
    }
    public String dealWithComparisonExp(ComparisonExpression CS){
        StringBuilder st = new StringBuilder();

        st.append(dealWithColl4Comp(CS.getCollection4comparison1()));
        st.append(" "+ CS.getComparisonOperator().getComparisonOperator()+" ");
        st.append(dealWithColl4Comp(CS.getCollection4comparison2()));

        return st.toString();
    }
    public String dealWithOneLineCond(OneLineCondition OLC){

        StringBuilder st = new StringBuilder();

        st.append("( ");
        st.append(" "+ dealWithLogicComparison(OLC.getLogicComprison()));
        st.append(" ? ");
        st.append(dealWithColl4Every(OLC.getCollection4everything1()));
        st.append(" : ");
        st.append(dealWithColl4Every(OLC.getCollection4everything2()));
        st.append(" )");
        return st.toString();
    }
    public String dealWithOneLineBoolCond(OneLineBoolCondition OLBC){
        StringBuilder st = new StringBuilder();

        st.append("( ");
        st.append(dealWithLogicComparison(OLBC.getLogicComprison()));
        st.append(" ? ");
        st.append(OLBC.isFirst());
        st.append(" : ");
        st.append(OLBC.isSecond());
        st.append(" )");
        return st.toString();
    }
    public String dealWithOneLineArithCond(OneLineArithCondition OLAC){
        StringBuilder st = new StringBuilder();

        st.append(" ( ");
        st.append(dealWithLogicComparison(OLAC.getLogicComprison()));
        st.append(" ? ");
        st.append(dealWithArithLogic(OLAC.getArithmeticLogic1()));
        st.append(" : ");
        st.append(dealWithArithLogic(OLAC.getArithmeticLogic2()));
        st.append(" )");

        return st.toString();
    }




    // LOGIC COMPARISON
    public String dealWithLogicComparison(LogicComprison logicComprison){

        // start
        if (logicComprison.getCollection4LogicRetFirst() != null){
            if (logicComprison.getNotFirst() != null){
                return "!" + dealWithCOll4Log(logicComprison.getCollection4LogicRetFirst());
            }else {
                return dealWithCOll4Log(logicComprison.getCollection4LogicRetFirst());
            }

        }else if(logicComprison.getLogicComprisonFirst() != null){

            StringBuilder st = new StringBuilder();
            st.append("( ");
            st.append(dealWithLogicComparison(logicComprison.getLogicComprisonFirst()));
            st.append(" )");

            if (!logicComprison.getMiddleAndLastLogicComparisons().isEmpty()){
                for (int i = 0 ; i <logicComprison.getMiddleAndLastLogicComparisons().size(); i ++) {
                    // add middle and last
                    MiddleAndLastLogicComparison middleAndLastLogicComparison = logicComprison.getMiddleAndLastLogicComparisons().get(i);
                    if (middleAndLastLogicComparison.getAndMiddle() != null){
                        st.append(" && ");
                        if (middleAndLastLogicComparison.getNotAndMiddle() != null) {
                            st.append(" !");
                        }
                        if (middleAndLastLogicComparison.getCollection4LogicRet() != null){

                            st.append(dealWithCOll4Log(middleAndLastLogicComparison.getCollection4LogicRet()));
                        }else if (middleAndLastLogicComparison.getLogicComprisonLast() != null){
                            st.append("( ");
                            st.append(dealWithLogicComparison(middleAndLastLogicComparison.getLogicComprisonLast()));
                            st.append(" )");
                        }

                    }else if (middleAndLastLogicComparison.getOrMiddle() != null){
                        st.append(" || ");
                        if (middleAndLastLogicComparison.getNotOrMiddle() != null){
                            st.append(" !");
                        }
                        if (middleAndLastLogicComparison.getCollection4LogicRet() != null){

                            st.append(dealWithCOll4Log(middleAndLastLogicComparison.getCollection4LogicRet()));
                        }else if (middleAndLastLogicComparison.getLogicComprisonLast() != null){
                            st.append(" ( ");
                            st.append(dealWithLogicComparison(middleAndLastLogicComparison.getLogicComprisonLast()));
                            st.append(" ) ");
                        }
                    }
                }
            }
            return st.toString();
        }
        return "";
    }
    public String dealWithArithLogic(ArithmeticLogic AL){

        StringBuilder st = new StringBuilder();
        if (AL.getCollection4Arithmetic() != null){
            st.append(dealWithColl4Arith(AL.getCollection4Arithmetic()));
        }else{
            st.append("( ");
            st.append(dealWithArithLogic(AL.getArithmeticLogic()));
            st.append(" )");
        }


        if (!AL.getLastArithmeticLogic().isEmpty()){
            for (int i = 0; i < AL.getLastArithmeticLogic().size() ; i++){
                LastArithmeticLogic LAL = AL.getLastArithmeticLogic().get(i);
                st.append(LAL.getArithmetic());
                if (LAL.getCollection4Arithmetic() != null){
                    st.append(dealWithColl4Arith(LAL.getCollection4Arithmetic()));
                }else {
                    st.append("( ");
                    st.append(dealWithArithLogic(LAL.getArithmeticLogic()));
                    st.append(" )");
                }
            }
        }

        return st.toString();
    }
    public String  dealWithValue(Value V){
        if (V.getString() != null){
            return V.getString();
        }else if (V.getNumber() != null){
            return V.getNumber().toString();
        }else if (V.getTrueOrFalse() != null){
            if (V.getTrueOrFalse().isFalse()){
                return "true";
            }else {
                return "false";
            }
        }else {
            return "null";
        }
    }
    public String dealWithColl4Every(Collection4everything CE){
        if (CE.getVariable() != null){
            return App+"."+CE.getVariable().getVariableName().getIdentifier();
        }else if (CE.getValue() != null){
            return dealWithValue(CE.getValue());
        }else if(CE.getArray() != null){
            return dealWithArray(CE.getArray());
        }else if (CE.getObjArray() != null){
            return dealWithObjArray(CE.getObjArray());
        }else if (CE.getFunctionCall() != null){
            return dealWithFunctionCall(CE.getFunctionCall());
        }else if (CE.getSubObj() != null){
            return dealWithSubObj(CE.getSubObj());
        }else if (CE.getOneLineCondition() != null){
            return dealWithOneLineCond(CE.getOneLineCondition());
        }else if (CE.getComparisonExpression() != null){
            return dealWithComparisonExp(CE.getComparisonExpression());
        }else if (CE.getLogicComprison() != null){
            return dealWithLogicComparison(CE.getLogicComprison());
        }else if (CE.getArithmeticLogic() != null){
            return dealWithArithLogic(CE.getArithmeticLogic());
        }else {
            return "";
        }
    }
    public String dealWithColl4Comp(Collection4comparison CC){
        return dealWithArithLogic(CC.getArithmeticLogic());
    }
    public String dealWithColl4Arith(Collection4Arithmetic CA){
        if (CA.getVariable() != null){
            return App+"."+CA.getVariable().getVariableName().getIdentifier();
        }else if (CA.getNumber() != null){
            return CA.getNumber().getNumber().toString();
        }else if (CA.getObjArray() != null){
            return dealWithObjArray(CA.getObjArray());
        }else if (CA.getFunctionCall() != null){
            return dealWithFunctionCall(CA.getFunctionCall());
        }else if (CA.getSubObj() != null){
            return dealWithSubObj(CA.getSubObj());
        }else if (CA.getOneLineArithCondition() != null){
            return dealWithOneLineArithCond(CA.getOneLineArithCondition());
        }
            else {
            return "";
        }
    }
    public String dealWithCOll4Log(Collection4LogicRet CL){
        if (CL.getVariable() != null){
            return App+"."+CL.getVariable().getVariableName().getIdentifier();
        }else if (CL.getTrueOrFalse()!= null){
            if (CL.getTrueOrFalse().isTrue()){
                return "true";
            }else {
                return "false";
            }
        }else if (CL.getObjArray() != null){
            return dealWithObjArray(CL.getObjArray());
        }else if (CL.getFunctionCall() != null){
            return dealWithFunctionCall(CL.getFunctionCall());
        }else if (CL.getSubObj() != null){
            return dealWithSubObj(CL.getSubObj());
        }else if (CL.getComparisonExpression() != null){
            return dealWithComparisonExp(CL.getComparisonExpression());
        }else if (CL.getOneLineBoolCondition() !=null){
            return dealWithOneLineBoolCond(CL.getOneLineBoolCondition());
        }
        else {
            return "";
        }
    }








    //    MIUSTACHE
    public String dealWithObjArray4M(ObjArray4Must OA){

        StringBuilder st = new StringBuilder();

        if (OA.getArrName4Must1() != null){

            st.append(" "+App+"."+OA.getArrName4Must1());
        }

        if (OA.getArrayCalling4Must() != null){
            st.append(dealWithArrayCalling4M(OA.getArrayCalling4Must()));
            return st.toString();
        }

        return "";
    }
    public String dealWithArrayCalling4M(ArrayCalling4Must AC){
        StringBuilder st = new StringBuilder();
        if (!AC.getArithmeticLogic4Must().isEmpty()){

            for (int i = 0 ; i < AC.getArithmeticLogic4Must().size() ; i++){
                st.append("[ ");
                st.append(dealWithArithLogic4M(AC.getArithmeticLogic4Must().get(i)));
                st.append(" ]");
            }
        }
        if (AC.getProperty4Must() != null){

            st.append(dealWithProperty4M(AC.getProperty4Must()));
        }else if (AC.getFunctionCallFromVar4Must() != null){

            st.append(dealWithFunctionFromVar4M(AC.getFunctionCallFromVar4Must()));
        }
        return st.toString();
    }
    public String dealWithFunctionCall4M(FunctionCall4Must FC){
        StringBuilder st = new StringBuilder();

        st.append(" "+App+"."+FC.getFunctionName4Must1().getFunctionName4Must());
        st.append(dealWithFunctionFromVar4M(FC.getFunctionCallFromVar4Must()));
        // return value
        return st.toString();
    }
    public String dealWithFunctionFromVar4M(FunctionCallFromVar4Must FCV){

        StringBuilder st = new StringBuilder();

        for (int i = 0 ; i < FCV.getParameters4Must().size() ; i ++){

            st.append("( ");
            st.append(dealWithparameters4M(FCV.getParameters4Must().get(i)));
            st.append(" )");
        }


        if (FCV.getProperty4Must() != null){
            st.append(dealWithProperty4M(FCV.getProperty4Must()));
        }

        if (FCV.getArrayCalling4Must() != null){
            st.append(dealWithArrayCalling4M(FCV.getArrayCalling4Must()));
        }


        return st.toString();
    }
    public String dealWithparameters4M(Parameters4Must p){

        StringBuilder st = new StringBuilder();
        for (int i = 0 ; i < p.getParameters4Musts().size() ; i++){
            Parameter4Must parameter =  p.getParameters4Musts().get(i);
            st.append(dealWithColl4Every4M(parameter.getCollection4Mustache()));
        }
        return st.toString();
    }
    public String dealWithSubObj4M(SubObj4Must SO){

        StringBuilder st = new StringBuilder();
        st.append(""+App+"."+SO.getSubObj4MustName());
        st.append(dealWithProperty4M(SO.getProperty4Must()));

        return st.toString();
    }
    public String dealWithProperty4M(Property4Must p){
        StringBuilder st = new StringBuilder();

        for (int i = 0 ; i < p.getPropertyValue4Must().size() ; i++){

            st.append(".");
            st.append(p.getPropertyValue4Must().get(i).getPropertyValue4Must());
        }

        if (p.getArrayCalling4Must() != null){
            st.append(dealWithArrayCalling4M(p.getArrayCalling4Must()));
        }else if (p.getFunctionCallFromVar4Must() != null){
            st.append(dealWithFunctionFromVar4M(p.getFunctionCallFromVar4Must()));
        }

        return st.toString();

    }
    public String dealWithOneLineCond4M(OneLineCondition4Must OLC){

        StringBuilder st = new StringBuilder();

        st.append("( ");
        st.append(" "+ dealWithLogicComparison4M(OLC.getLogicComprison4Must()));
        st.append(" ? ");
        st.append(dealWithColl4Every4M(OLC.getCollection4Mustache1()));
        st.append(" : ");
        st.append(dealWithColl4Every4M(OLC.getCollection4Mustache2()));
        st.append(" )");
        return st.toString();
    }
    public String dealWithOneLineArithCond4M(OneLineArithCondition4Must OLAC){
        StringBuilder st = new StringBuilder();

        st.append("( ");
        st.append(dealWithLogicComparison4M(OLAC.getLogicComprison4Must()));
        st.append(" ? ");
        st.append(dealWithArithLogic4M(OLAC.getArithmeticLogic4Must1()));
        st.append(" : ");
        st.append(dealWithArithLogic4M(OLAC.getArithmeticLogic4Must2()));
        st.append(" )");

        return st.toString();
    }
    public String dealWithOneLineBoolCond4M(OneLineBoolCondition4Must OLBC){
        StringBuilder st = new StringBuilder();

        st.append("( ");
        st.append(dealWithLogicComparison4M(OLBC.getLogicComprison4Must()));
        st.append(" ? ");
        st.append(OLBC.isFirst());
        st.append(" : ");
        st.append(OLBC.isSecond());
        st.append(" )");
        return st.toString();
    }
    public String dealWithComparisonExp4M(ComparisonExp4Must CS){
        StringBuilder st = new StringBuilder();

        st.append(dealWithColl4Comp4M(CS.getCollection4CompMust()));
        st.append(" "+ CS.getMustacheComparisonOperator().getOperator()+" ");
        st.append(dealWithColl4Comp4M(CS.getCollection4CompMust2()));

        return st.toString();
    }
    public String dealWithArithLogic4M(ArithmeticLogic4Must AL){

        StringBuilder st = new StringBuilder();
        if (AL.getCollection4Arithmetic() != null){
            st.append(dealWithColl4Arith4M(AL.getCollection4Arithmetic()));
        }else{
            st.append("( ");
            st.append(dealWithArithLogic4M(AL.getArithmeticLogic()));
            st.append(" )");
        }


        if (!AL.getLastArithmeticLogic().isEmpty()){
            for (int i = 0; i < AL.getLastArithmeticLogic().size() ; i++){
                LastArithmeticLogic4Must LAL = AL.getLastArithmeticLogic().get(i);
                st.append(LAL.getArithmetic());
                if (LAL.getCollection4MUSTArithmetic() != null){
                    st.append(dealWithColl4Arith4M(LAL.getCollection4MUSTArithmetic()));
                }else {
                    st.append("( ");
                    st.append(dealWithArithLogic4M(LAL.getArithmeticLogic()));
                    st.append(" )");
                }
            }
        }

        return st.toString();
    }
    public String dealWithLogicComparison4M(LogicComprison4Must logicComprison){

        // start
        if (logicComprison.getCollection4LogicRetFirst() != null){
            if (logicComprison.getNotFirst() != null){
                return " !" + dealWithCOll4Log4M(logicComprison.getCollection4LogicRetFirst());
            }else {
                return dealWithCOll4Log4M(logicComprison.getCollection4LogicRetFirst());
            }

        }else if(logicComprison.getLogicComprisonFirst() != null){

            StringBuilder st = new StringBuilder();
            st.append("( ");
            st.append(dealWithLogicComparison4M(logicComprison.getLogicComprisonFirst()));
            st.append(" )");

            if (!logicComprison.getMiddleAndLastLogicComparisons().isEmpty()){
                for (int i = 0 ; i <logicComprison.getMiddleAndLastLogicComparisons().size(); i ++) {
                    // add middle and last
                    MiddleAndLastLogicComparison4Must middleAndLastLogicComparison = logicComprison.getMiddleAndLastLogicComparisons().get(i);
                    if (middleAndLastLogicComparison.getAndMiddle() != null){
                        st.append(" && ");
                        if (middleAndLastLogicComparison.getNotAndMiddle() != null) {
                            st.append(" !");
                        }
                        if (middleAndLastLogicComparison.getCollection4LogicRet() != null){

                            st.append(dealWithCOll4Log4M(middleAndLastLogicComparison.getCollection4LogicRet()));
                        }else if (middleAndLastLogicComparison.getLogicComprisonLast() != null){
                            st.append("( ");
                            st.append(dealWithLogicComparison4M(middleAndLastLogicComparison.getLogicComprisonLast()));
                            st.append(" )");
                        }

                    }else if (middleAndLastLogicComparison.getOrMiddle() != null){
                        st.append(" || ");
                        if (middleAndLastLogicComparison.getNotOrMiddle() != null){
                            st.append(" !");
                        }
                        if (middleAndLastLogicComparison.getCollection4LogicRet() != null){

                            st.append(dealWithCOll4Log4M(middleAndLastLogicComparison.getCollection4LogicRet()));
                        }else if (middleAndLastLogicComparison.getLogicComprisonLast() != null){
                            st.append(" ( ");
                            st.append(dealWithLogicComparison4M(middleAndLastLogicComparison.getLogicComprisonLast()));
                            st.append(" ) ");
                        }
                    }
                }
            }
            return st.toString();
        }
        return "";
    }
    public String dealWithColl4Every4M(Collection4Mustache CE){
        if (CE.getMustacheVariable() != null){
            return App+"."+CE.getMustacheVariable().getMustacheVariable();
        }else if (CE.getMustacheValue() != null){
            return dealWithValue4M(CE.getMustacheValue());
        }else if (CE.getObjArray4Must() != null){
            return dealWithObjArray4M(CE.getObjArray4Must());
        }else if (CE.getFunctionCall4Must() != null){
            return dealWithFunctionCall4M(CE.getFunctionCall4Must());
        }else if (CE.getSubObj4Must() != null){
            return dealWithSubObj4M(CE.getSubObj4Must());
        }else if (CE.getOneLineCondition4Must() != null){
            return dealWithOneLineCond4M(CE.getOneLineCondition4Must());
        }else if (CE.getArithmeticLogic4Must() != null){
            return dealWithArithLogic4M(CE.getArithmeticLogic4Must());
        }else if (CE.getOneLineArithCondithion4Must() != null){
            return dealWithOneLineArithCond4M(CE.getOneLineArithCondithion4Must());
        }else{
            return "";
        }
    }
    public String dealWithColl4Comp4M(Collection4CompMust CC){
        return dealWithArithLogic4M(CC.getArithmeticLogic4Must());
    }
    public String  dealWithValue4M(MustacheValue V){
        if (V.getMustacheString() != null){
            return V.getMustacheString();
        }else if (V.getMustacheNumber() != null){
            return V.getMustacheNumber().toString();
        }else if (V.getMustacheTrue() != null) {
            return "true";
        }
        else if (V.getMustacheFalse() != null) {
            return "false";

        }else {
            return "";
        }
    }
    public String dealWithCOll4Log4M(Collection4LogicRet4Must CL){
        if (CL.getMustacheVariable() != null){
            return " "+App+"."+CL.getMustacheVariable().getMustacheVariable();
        }else if (CL.getMustacheTrue() != null) {
            return "true";
        }else if (CL.getMustacheFalse() != null) {
            return "false";
        }else if (CL.getObjArray4Must() != null){
            return dealWithObjArray4M(CL.getObjArray4Must());
        }else if (CL.getFunctionCall4Must() != null){
            return dealWithFunctionCall4M(CL.getFunctionCall4Must());
        }else if (CL.getSubObj4Must() != null){
            return dealWithSubObj4M(CL.getSubObj4Must());
        }else if (CL.getComparisonExp4Must() != null){
            return dealWithComparisonExp4M(CL.getComparisonExp4Must());
        }else if (CL.getOneLineBoolCondition4Must() !=null){
            return dealWithOneLineBoolCond4M(CL.getOneLineBoolCondition4Must());
        }else {
            return "";
        }
    }
    public String dealWithColl4Arith4M(Collection4MUSTArithmetic CA){
        if (CA.getmustacheVariable() != null){
            return " "+App+"."+CA.getmustacheVariable().getMustacheVariable();
        }else if (CA.getMustacheNumber() != null){
            return CA.getMustacheNumber().getNumber().toString();
        }else if (CA.getObjArray4Must() != null){
            return dealWithObjArray4M(CA.getObjArray4Must());
        }else if (CA.getFunctionCall4Must() != null){
            return dealWithFunctionCall4M(CA.getFunctionCall4Must());
        }else if (CA.getSubObj4Must() != null){
            return dealWithSubObj4M(CA.getSubObj4Must());
        }else if (CA.getOneLineArithCondithion4Must1() != null){
            return dealWithOneLineArithCond4M(CA.getOneLineArithCondithion4Must1());
        }
        else {
            return "";
        }
    }

}
