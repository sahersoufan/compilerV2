package Base;

import AST.HtmlDocument;
import generatedGrammers.HTMLParser;
import generatedGrammers.HTMLParserBaseVisitor;
import jdk.dynalink.linker.LinkerServices;

import java.util.ArrayList;
import java.util.List;

public class BaseVisitors extends HTMLParserBaseVisitor {

    @Override
    public Object visitHtmlDocument(HTMLParser.HtmlDocumentContext ctx) {
        HtmlDocument htmlDocument = new HtmlDocument();
        List<String> ScriptletOrSeaWs = new ArrayList<>();

        if(!ctx.scriptletOrSeaWs().isEmpty()){
                for(int i = 0 ; i < ctx.scriptletOrSeaWs().size() ; i ++){
                    ScriptletOrSeaWs.add((String)visitScriptletOrSeaWs(ctx.scriptletOrSeaWs(i)));
                }
                htmlDocument.setScriptLetORSeaWs(ScriptletOrSeaWs);
        }


        return htmlDocument;
    }

    @Override
    public Object visitScriptletOrSeaWs(HTMLParser.ScriptletOrSeaWsContext ctx) {
    if(ctx.SCRIPTLET() != null){
        String scriptLet;
        scriptLet = ctx.SCRIPTLET().getSymbol().getText();
        return scriptLet;
    }
    if(ctx.SEA_WS() != null){
        String seaWs;
        seaWs = ctx.SEA_WS().getSymbol().getText();
        return  seaWs;
    }
    return  "";
    }

    @Override
    public Object visitHtmlElements(HTMLParser.HtmlElementsContext ctx) {
        return super.visitHtmlElements(ctx);
    }

    @Override
    public Object visitHtmlElement(HTMLParser.HtmlElementContext ctx) {
        return super.visitHtmlElement(ctx);
    }

    @Override
    public Object visitHtmlContent(HTMLParser.HtmlContentContext ctx) {
        return super.visitHtmlContent(ctx);
    }

    @Override
    public Object visitHtmlAttribute(HTMLParser.HtmlAttributeContext ctx) {
        return super.visitHtmlAttribute(ctx);
    }

    @Override
    public Object visitHtmlChardata(HTMLParser.HtmlChardataContext ctx) {
        return super.visitHtmlChardata(ctx);
    }

    @Override
    public Object visitHtmlMisc(HTMLParser.HtmlMiscContext ctx) {
        return super.visitHtmlMisc(ctx);
    }

    @Override
    public Object visitHtmlComment(HTMLParser.HtmlCommentContext ctx) {


        return super.visitHtmlComment(ctx);
    }












    ///////////////////////////// Fatimaaaaaaaaaaaaaaaaaaaaaaaaaaa ///////////////////////////////////

    @Override
    public Object visitAppExpression(HTMLParser.AppExpressionContext ctx) {

        return super.visitAppExpression(ctx);
    }

    @Override
    public Object visitCollection4App1(HTMLParser.Collection4App1Context ctx) {
        return super.visitCollection4App1(ctx);
    }

    @Override
    public Object visitCollection4App2(HTMLParser.Collection4App2Context ctx) {
        return super.visitCollection4App2(ctx);
    }

    @Override
    public Object visitForExpression(HTMLParser.ForExpressionContext ctx) {
        return super.visitForExpression(ctx);
    }

    @Override
    public Object visitCollection4For1(HTMLParser.Collection4For1Context ctx) {
        return super.visitCollection4For1(ctx);
    }

    @Override
    public Object visitCollection4For2(HTMLParser.Collection4For2Context ctx) {
        return super.visitCollection4For2(ctx);
    }

    @Override
    public Object visitOneLine4For2Condition(HTMLParser.OneLine4For2ConditionContext ctx) {
        return super.visitOneLine4For2Condition(ctx);
    }

    @Override
    public Object visitCollection4For3(HTMLParser.Collection4For3Context ctx) {
        return super.visitCollection4For3(ctx);
    }

    @Override
    public Object visitOneLine4For3Condition(HTMLParser.OneLine4For3ConditionContext ctx) {
        return super.visitOneLine4For3Condition(ctx);
    }

    @Override
    public Object visitCollection4For4(HTMLParser.Collection4For4Context ctx) {
        return super.visitCollection4For4(ctx);
    }

    @Override
    public Object visitCollection4For5(HTMLParser.Collection4For5Context ctx) {
        return super.visitCollection4For5(ctx);
    }

    @Override
    public Object visitShowHideExpression(HTMLParser.ShowHideExpressionContext ctx) {
        return super.visitShowHideExpression(ctx);
    }

    @Override
    public Object visitCollection4ShowHide1(HTMLParser.Collection4ShowHide1Context ctx) {
        return super.visitCollection4ShowHide1(ctx);
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
    public Object visitCollection4If(HTMLParser.Collection4IfContext ctx) {
        return super.visitCollection4If(ctx);
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
    public Object visitCollection4Model2(HTMLParser.Collection4Model2Context ctx) {
        return super.visitCollection4Model2(ctx);
    }

    @Override
    public Object visitAnnotationExpression(HTMLParser.AnnotationExpressionContext ctx) {
        return super.visitAnnotationExpression(ctx);
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








 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////








    ////////////////////// MAYAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAR //////////////////////

    @Override
    public Object visitVariable(HTMLParser.VariableContext ctx) {
        return super.visitVariable(ctx);
    }

    @Override
    public Object visitVariableName(HTMLParser.VariableNameContext ctx) {
        return super.visitVariableName(ctx);
    }

    @Override
    public Object visitNumber(HTMLParser.NumberContext ctx) {
        return super.visitNumber(ctx);
    }

    @Override
    public Object visitObjArray(HTMLParser.ObjArrayContext ctx) {
        return super.visitObjArray(ctx);
    }

    @Override
    public Object visitArrName(HTMLParser.ArrNameContext ctx) {
        return super.visitArrName(ctx);
    }

    @Override
    public Object visitArrayCalling(HTMLParser.ArrayCallingContext ctx) {
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
    public Object visitCollection4comparison(HTMLParser.Collection4comparisonContext ctx) {
        return super.visitCollection4comparison(ctx);
    }

    @Override
    public Object visitCollection4oneLineCondition(HTMLParser.Collection4oneLineConditionContext ctx) {
        return super.visitCollection4oneLineCondition(ctx);
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
    public Object visitCollection4ARITHMETIC(HTMLParser.Collection4ARITHMETICContext ctx) {
        return super.visitCollection4ARITHMETIC(ctx);
    }

    @Override
    public Object visitCollection4boolRet(HTMLParser.Collection4boolRetContext ctx) {
        return super.visitCollection4boolRet(ctx);
    }
 //////////////////////////////////////////////////////////////////////////////////////////////////////////











    ////////////////////// NOOOOOOOOOOOOOOOOOOOOOOOOOOOOR //////////////////////
    @Override
    public Object visitMustacheExpression(HTMLParser.MustacheExpressionContext ctx) {
        return super.visitMustacheExpression(ctx);
    }

    @Override
    public Object visitCollection4Mustache(HTMLParser.Collection4MustacheContext ctx) {
        return super.visitCollection4Mustache(ctx);
    }

    @Override
    public Object visitCollection4OLCMust(HTMLParser.Collection4OLCMustContext ctx) {
        return super.visitCollection4OLCMust(ctx);
    }

    @Override
    public Object visitCollection4CompMust(HTMLParser.Collection4CompMustContext ctx) {
        return super.visitCollection4CompMust(ctx);
    }

    @Override
    public Object visitCollection4MUSTARITHMETIC(HTMLParser.Collection4MUSTARITHMETICContext ctx) {
        return super.visitCollection4MUSTARITHMETIC(ctx);
    }

    @Override
    public Object visitMustacheVariable(HTMLParser.MustacheVariableContext ctx) {
        return super.visitMustacheVariable(ctx);
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
    public Object visitOneLineArithCondithion4Must(HTMLParser.OneLineArithCondithion4MustContext ctx) {
        return super.visitOneLineArithCondithion4Must(ctx);
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


    //////////////////////////////////////////////////////////////////////////////////////////////////////////










    @Override
    public Object visitScript(HTMLParser.ScriptContext ctx) {
        return super.visitScript(ctx);
    }

    @Override
    public Object visitStyle(HTMLParser.StyleContext ctx) {
        return super.visitStyle(ctx);
    }
}
