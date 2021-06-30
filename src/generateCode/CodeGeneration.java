package generateCode;

import AST.Elements.ElementsNodes.CpExpression.model.ModelExpression;
import AST.Elements.ElementsNodes.HtmlAttribute;
import AST.Elements.ElementsNodes.generic4Elements.object.SubObj;
import AST.Elements.ElementsNodes.mustacheExpression.MustacheExpression;
import AST.Elements.HtmlElement;
import AST.Elements.HtmlElements;
import AST.HtmlDocument;
import org.antlr.v4.runtime.misc.Pair;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Inet4Address;
import java.util.List;

public class CodeGeneration {
    StringBuilder JSContent = new StringBuilder();
    String JSFile;

    public CodeGeneration(String JSFile) {
        this.JSFile = JSFile;
    }

    public void start() {
        JSContent.append("<script>\n");
        JSContent.append("changes = [];\n");
        JSContent.append("renders = [];\n");
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


        // Get Model Value
        if (modelExp.getCollection4Model1().getVariable() != null) {
            ModelVarible(modelExp,id);

        } else if (modelExp.getCollection4Model1().getSubObj() != null) {
            ModelSubobj(modelExp,id);
        }else if(modelExp.getCollection4Model1().getOneLine4ModelCondition()!=null){
            ModelOneLine4ModelCondition(modelExp,id);
        }



        JSContent.append("        document.getElementById(\""+id+"\").addEventListener(\"input\", function(event) {\n" +
                "            changes.push("+id+"Changes);\n" +
                "        });\n" +
                "        changes.push("+id+"Changes);\n");
    }

    public void ModelVarible(ModelExpression modelExp ,String id){


        String modelValue = null;

        modelValue = modelExp.getCollection4Model1().getVariable().getVariableName().getIdentifier();
        JSContent.append("        document.getElementById(\""+id+"\").value = forthyear."+modelValue+";\n");
    }
    public void ModelSubobj(ModelExpression modelExp,String id ){

        String modelValue = null;
        ;
        modelValue = dealWithSubobj(modelExp.getCollection4Model1().getSubObj()).toString();
        JSContent.append("        var "+id+"Changes = function (event) {\n" +
                "            forthyear."+modelValue+" = document.getElementById(\""+id+"\").value;\n" +
                "        };\n");
    }
    public void ModelObjArray(ModelExpression modelExp,String id){

    }
    public void ModelFunctioncall(ModelExpression modelExp,String id){

    };
    public void ModelOneLine4ModelCondition(ModelExpression modelExp,String id) {
        String modelValue = null;

        StringBuilder tempValue = new StringBuilder();
        tempValue.append("(");

        //Collection4Model1_1_1
        if (modelExp.getCollection4Model1().getOneLine4ModelCondition().getCollection4Model1_1_1().getVariable() != null) {
            ModelVarible(modelExp,id);
        } else if (modelExp.getCollection4Model1().getOneLine4ModelCondition().getCollection4Model1_1_1().getSubObj() != null){
            ModelSubobj(modelExp,id);
        }
        else if(modelExp.getCollection4Model1().getOneLine4ModelCondition().getCollection4Model1_1_1().getObjArray()!=null){
            ModelObjArray(modelExp,id);
        }else if(modelExp.getCollection4Model1().getOneLine4ModelCondition().getCollection4Model1_1_1().getFunctionCall()!=null){
            ModelFunctioncall(modelExp,id);
        }

        //LogicComprison
        if(modelExp.getCollection4Model1().getOneLine4ModelCondition().getLogicComprison()!=null){

        }

        //getCollection4Model1_1_2
        if(modelExp.getCollection4Model1().getOneLine4ModelCondition().getCollection4Model1_1_2().getVariable()!=null){
            ModelVarible(modelExp,id);
        } else if (modelExp.getCollection4Model1().getOneLine4ModelCondition().getCollection4Model1_1_2().getSubObj() != null){
            ModelSubobj(modelExp,id);
        }
        else if(modelExp.getCollection4Model1().getOneLine4ModelCondition().getCollection4Model1_1_2().getObjArray()!=null){
            ModelObjArray(modelExp,id);
        }else if(modelExp.getCollection4Model1().getOneLine4ModelCondition().getCollection4Model1_1_2().getFunctionCall()!=null){
            ModelFunctioncall(modelExp,id);
        }




    }


    //subobj
    public StringBuilder dealWithSubobj(SubObj sb){

        StringBuilder tempValue = new StringBuilder();
        tempValue.append(sb.getIdentifier());
        for (int i = 0; i < sb.getProperty().getPropertyValues().size(); i++) {
            tempValue.append(".");
            tempValue.append(sb.getProperty().getPropertyValues().get(i).getIdentifier());
        }
        return tempValue;
    }







    // CP-MUSTACHE
    public void dealWithMustacheExp(String id, MustacheExpression me){
        String MustValue;

        id=id.substring(1,id.length()-1);
        if (id == null) {
            throw new NullPointerException(id);
        }

        if (me.getCollection4Mustache() != null){
            MustValue = me.getCollection4Mustache().getMustacheVariable().getMustacheVariable();
            JSContent.append("        var "+id+"Changes4Must = function (event) {\n" +
                    "            var defaultText = \"My Text is: {{"+MustValue+"}}\";\n" +
                    "            document.getElementById(\""+id+"\").innerHTML = defaultText.replace(\"{{"+MustValue+"}}\", forthyear."+MustValue+");\n" +
                    "        };\n " +
                    "renders.push("+id+"Changes4Must);\n");
        }
    }

}
