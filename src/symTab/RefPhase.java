package symTab;

import generatedGrammers.HTMLParser;
import generatedGrammers.HTMLParserBaseListener;
import org.antlr.symtab.GlobalScope;
import org.antlr.symtab.Scope;
import org.antlr.symtab.Symbol;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Stack;

public class RefPhase extends HTMLParserBaseListener {
    ParseTreeProperty<Scope> scopes;
    GlobalScope globals;
    Scope currentScope;
    Stack<String> elementNames = new Stack<>();
    String thisElement = null;
    boolean justOneCp = false;
    public RefPhase(GlobalScope globals, ParseTreeProperty<Scope> scopes) {
        this.scopes = scopes;
        this.globals = globals;
    }


    @Override
    public void enterHtmlDocument(HTMLParser.HtmlDocumentContext ctx) {

        currentScope = globals;
    }

    @Override
    public void exitHtmlDocument(HTMLParser.HtmlDocumentContext ctx) {

    }

    @Override
    public void enterHtmlElement(HTMLParser.HtmlElementContext ctx) {

        if (!ctx.TAG_NAME().isEmpty()) {
            if (ctx.TAG_NAME(0) != null){
                    thisElement = ctx.TAG_NAME(0).getSymbol().getText();
                    elementNames.push(thisElement);
                    justOneCp = false;



                    boolean thereIsNoUlOrOl = false;
                    if (thisElement.equals("li")){
                        for (String s : elementNames){
                            if (s.equals("ul") || s.equals("ol")){
                                thereIsNoUlOrOl = true;
                            }
                        }
                        if (!thereIsNoUlOrOl) {
                            CheckSymbols.error(ctx.TAG_NAME(0).getSymbol(), "ti's LI out of UL or OL, idiot !!! ");
                        }
                    }

                    boolean thereIsSrc = false;
                    if (thisElement.equals("img")){
                        if (!ctx.htmlAttribute().isEmpty()){
                            for (int i = 0 ; i < ctx.htmlAttribute().size() ; i++){
                                if (ctx.htmlAttribute(i).TAG_NAME() != null){
                                    if (ctx.htmlAttribute(i).TAG_NAME().getSymbol().getText().equals("src")) {
                                        thereIsSrc = true;
                                        break;
                                    }
                                }
                            }
                        }
                        if (!thereIsSrc){
                            CheckSymbols.error(ctx.TAG_NAME(0).getSymbol(), "it's don't have src, idiot !!! ");
                        }
                    }

                    boolean thereIsHref = false;
                if (thisElement.equals("a")){
                    if (!ctx.htmlAttribute().isEmpty()){
                        for (int i = 0 ; i < ctx.htmlAttribute().size() ; i++) {
                            if (ctx.htmlAttribute(i).TAG_NAME() != null) {
                                if (ctx.htmlAttribute(i).TAG_NAME().getSymbol().getText().equals("href")) {
                                    thereIsHref = true;
                                    break;
                                }
                            }
                        }
                    }
                    if (!thereIsHref){
                        CheckSymbols.error(ctx.TAG_NAME(0).getSymbol(), "it's don't have href, idiot !!! ");
                    }
                }


            }
        }

    }

    @Override
    public void exitHtmlElement(HTMLParser.HtmlElementContext ctx) {
        boolean doIt = false;
        if (!elementNames.isEmpty() && ctx.TAG_NAME(1) != null) {
            for (int i = 0 ; i < ctx.htmlAttribute().size() ; i++){
                if (ctx.htmlAttribute(i).forExpression() != null ||
                        ctx.htmlAttribute(i).ifExpression() != null ||
                        ctx.htmlAttribute(i).switchCaseExpression() != null ||
                        ctx.htmlAttribute(i).appExpression() != null){
                    doIt = true;
                }
            }
            if (elementNames.peek().equals(ctx.TAG_NAME(1).getSymbol().getText()) && doIt) {
                currentScope = currentScope.getEnclosingScope();
            }
            elementNames.pop();
        }
    }

    @Override
    public void enterHtmlAttribute(HTMLParser.HtmlAttributeContext ctx) {

        if (ctx.TAG_NAME() != null){
            if(ctx.TAG_NAME().getSymbol().getText().equals("id")){
                if (!CheckSymbols.checkIdsDifferent(ctx.ATTVALUE_VALUE().getSymbol().getText())){
                    CheckSymbols.error(ctx.ATTVALUE_VALUE().getSymbol(), "it's repeated, idiot !!! ");
                }
            }
        }
    }

    @Override
    public void enterAppExpression(HTMLParser.AppExpressionContext ctx) {
        if (justOneCp){
            System.err.println("you can't add more than one cp attribute here, idiot !!! ");
        }
        if (currentScope.getName().contains("App")){
            System.err.println("APP , it's repeated, idiot !!! ");
        }
    }

    @Override
    public void exitAppExpression(HTMLParser.AppExpressionContext ctx) {
        currentScope = scopes.get(ctx);
    }

    @Override
    public void enterForExpression(HTMLParser.ForExpressionContext ctx) {
        currentScope = scopes.get(ctx);
        if (justOneCp){
            System.err.println("you can't add more than one cp attribute here, idiot !!! ");
        }
        justOneCp = true;
    }

    boolean addItToColl4For1 = false;
    @Override
    public void enterCollection4For1(HTMLParser.Collection4For1Context ctx) {
    addItToColl4For1 = true;
    }

    boolean saveItInPreviousScope = false;
    @Override
    public void enterCollection4For2(HTMLParser.Collection4For2Context ctx) {
        saveItInPreviousScope = true;
    }

    @Override
    public void exitCollection4For2(HTMLParser.Collection4For2Context ctx) {
        saveItInPreviousScope = false;
    }

    @Override
    public void enterCollection4For3(HTMLParser.Collection4For3Context ctx) {
        saveItInPreviousScope = true;
    }

    @Override
    public void exitCollection4For3(HTMLParser.Collection4For3Context ctx) {
        saveItInPreviousScope = false;
    }

    @Override
    public void enterCollection4For4(HTMLParser.Collection4For4Context ctx) {
        saveItInPreviousScope = true;
    }

    @Override
    public void exitCollection4For4(HTMLParser.Collection4For4Context ctx) {
        saveItInPreviousScope = false;
    }


    @Override
    public void enterShowExpression(HTMLParser.ShowExpressionContext ctx) {
        if (justOneCp){
            System.err.println("you can't add more than one cp attribute here, idiot !!! ");
        }
        justOneCp = true;
    }

    @Override
    public void enterHideExpression(HTMLParser.HideExpressionContext ctx) {
        if (justOneCp){
            System.err.println("you can't add more than one cp attribute here, idiot !!! ");
        }
        justOneCp = true;
    }

    @Override
    public void enterSwitchExpression(HTMLParser.SwitchExpressionContext ctx) {
        if (justOneCp){
            System.err.println("you can't add more than one cp attribute here, idiot !!! ");
        }
    }

    @Override
    public void enterSwitchCaseExpression(HTMLParser.SwitchCaseExpressionContext ctx) {
        if (justOneCp){
            System.err.println("you can't add more than one cp attribute here, idiot !!! ");
        }
        justOneCp = true;
    }

    @Override
    public void exitSwitchCaseExpression(HTMLParser.SwitchCaseExpressionContext ctx) {
        currentScope = scopes.get(ctx);

    }

    @Override
    public void enterIfExpression(HTMLParser.IfExpressionContext ctx) {
        if (justOneCp){
            System.err.println("you can't add more than one cp attribute here, idiot !!! ");
        }
        justOneCp = true;
    }

    @Override
    public void exitIfExpression(HTMLParser.IfExpressionContext ctx) {
        currentScope = scopes.get(ctx);

    }

    @Override
    public void enterModelExpression(HTMLParser.ModelExpressionContext ctx) {
        if (justOneCp){
            System.err.println("you can't add more than one cp attribute here, idiot !!! ");
        }
    }

    @Override
    public void enterAnnotationClickExpression(HTMLParser.AnnotationClickExpressionContext ctx) {
        if (justOneCp){
            System.err.println("you can't add more than one cp attribute here, idiot !!! ");
        }
    }

    @Override
    public void enterAnnotationOverExpression(HTMLParser.AnnotationOverExpressionContext ctx) {
        if (justOneCp){
            System.err.println("you can't add more than one cp attribute here, idiot !!! ");
        }
    }



    @Override
    public void enterVariableName(HTMLParser.VariableNameContext ctx) {
        if (!saveItInPreviousScope) {
            String name = ctx.CP_CONTENT_IDENTIFIER().getSymbol().getText();
            if (CheckSymbols.checKResolve(currentScope, name) && CheckSymbols.checkScope(currentScope, ctx.CP_CONTENT_IDENTIFIER().getSymbol())) {
                System.out.println();
                System.out.println(currentScope.getName());
                Symbol var = currentScope.resolve(name);
                if (var == null) {

                    CheckSymbols.error(ctx.CP_CONTENT_IDENTIFIER().getSymbol(), "ti's null, idiot !!! ");
                } else {

                    System.out.println("VariableName = " + var.getName());
                }
            }

            if (addItToColl4For1 && !CheckSymbols.checkScope(currentScope, ctx.CP_CONTENT_IDENTIFIER().getSymbol())){
                CheckSymbols.error(ctx.CP_CONTENT_IDENTIFIER().getSymbol(), "ti's repeated Iterator, idiot !!! ");
                addItToColl4For1=false;
            }
        }else{

            String name = ctx.CP_CONTENT_IDENTIFIER().getSymbol().getText();
            if (CheckSymbols.checKResolve(currentScope.getEnclosingScope(), name) && CheckSymbols.checkScope(currentScope.getEnclosingScope(), ctx.CP_CONTENT_IDENTIFIER().getSymbol())) {
                System.out.println();
                System.out.println(currentScope.getEnclosingScope().getName());
                Symbol var = currentScope.getEnclosingScope().resolve(name);
                if (var == null) {

                    CheckSymbols.error(ctx.CP_CONTENT_IDENTIFIER().getSymbol(), "ti's null, idiot !!! ");
                } else {

                    System.out.println("VariableName = " + var.getName());
                }
            }
        }
    }
// li in ul/ol
    @Override
    public void enterArrName(HTMLParser.ArrNameContext ctx) {
        if (!saveItInPreviousScope) {
            String name = ctx.CP_CONTENT_IDENTIFIER().getSymbol().getText();
            if (CheckSymbols.checKResolve(currentScope, name) && CheckSymbols.checkScope(currentScope, ctx.CP_CONTENT_IDENTIFIER().getSymbol())) {
                System.out.println();
                System.out.println(currentScope.getName());
                Symbol var = currentScope.resolve(name);
                if (var == null) {

                    CheckSymbols.error(ctx.CP_CONTENT_IDENTIFIER().getSymbol(), "ti's null, idiot !!! ");
                } else {

                    System.out.println("ArrayName = " + var.getName());
                }
            }
        }else {
            String name = ctx.CP_CONTENT_IDENTIFIER().getSymbol().getText();
            if (CheckSymbols.checKResolve(currentScope.getEnclosingScope(), name) && CheckSymbols.checkScope(currentScope.getEnclosingScope(), ctx.CP_CONTENT_IDENTIFIER().getSymbol())) {
                System.out.println();
                System.out.println(currentScope.getEnclosingScope().getName());
                Symbol var = currentScope.getEnclosingScope().resolve(name);
                if (var == null) {

                    CheckSymbols.error(ctx.CP_CONTENT_IDENTIFIER().getSymbol(), "ti's null, idiot !!! ");
                } else {

                    System.out.println("ArrayName = " + var.getName());
                }
            }
        }
    }

    @Override
    public void enterObj(HTMLParser.ObjContext ctx) {
        if (!saveItInPreviousScope) {
            String name = ctx.CP_CONTENT_IDENTIFIER().getSymbol().getText();
            if (CheckSymbols.checKResolve(currentScope, name) && CheckSymbols.checkScope(currentScope, ctx.CP_CONTENT_IDENTIFIER().getSymbol())) {
                System.out.println();
                System.out.println(currentScope.getName());
                Symbol var = currentScope.resolve(name);
                if (var == null) {

                    CheckSymbols.error(ctx.CP_CONTENT_IDENTIFIER().getSymbol(), "ti's null, idiot !!! ");
                } else {

                    System.out.println("ObjectName = " + var.getName());
                }
            }
        }else{
            String name = ctx.CP_CONTENT_IDENTIFIER().getSymbol().getText();
            if (CheckSymbols.checKResolve(currentScope.getEnclosingScope(), name) && CheckSymbols.checkScope(currentScope.getEnclosingScope(), ctx.CP_CONTENT_IDENTIFIER().getSymbol())) {
                System.out.println();
                System.out.println(currentScope.getEnclosingScope().getName());
                Symbol var = currentScope.getEnclosingScope().resolve(name);
                if (var == null) {

                    CheckSymbols.error(ctx.CP_CONTENT_IDENTIFIER().getSymbol(), "ti's null, idiot !!! ");
                } else {

                    System.out.println("ObjectName = " + var.getName());
                }
            }
        }
    }

    @Override
    public void exitObj(HTMLParser.ObjContext ctx) {
        super.exitObj(ctx);
    }

    @Override
    public void enterSubObj(HTMLParser.SubObjContext ctx) {
        if (!saveItInPreviousScope) {
            String name = ctx.CP_CONTENT_IDENTIFIER().getSymbol().getText();
            if (CheckSymbols.checKResolve(currentScope, name) && CheckSymbols.checkScope(currentScope, ctx.CP_CONTENT_IDENTIFIER().getSymbol())) {
                System.out.println();
                System.out.println(currentScope.getName());
                Symbol var = currentScope.resolve(name);
                if (var == null) {

                    CheckSymbols.error(ctx.CP_CONTENT_IDENTIFIER().getSymbol(), "ti's null, idiot !!! ");
                } else {
                    System.out.println("ObjectName = " + var.getName());
                }
            }
        }else{
            String name = ctx.CP_CONTENT_IDENTIFIER().getSymbol().getText();
            if (CheckSymbols.checKResolve(currentScope.getEnclosingScope(), name) && CheckSymbols.checkScope(currentScope.getEnclosingScope(), ctx.CP_CONTENT_IDENTIFIER().getSymbol())) {
                System.out.println();
                System.out.println(currentScope.getEnclosingScope().getName());
                Symbol var = currentScope.getEnclosingScope().resolve(name);
                if (var == null) {

                    CheckSymbols.error(ctx.CP_CONTENT_IDENTIFIER().getSymbol(), "ti's null, idiot !!! ");
                } else {
                    System.out.println("ObjectName = " + var.getName());
                }
            }
        }
    }

    @Override
    public void enterPropertyValue(HTMLParser.PropertyValueContext ctx) {
        if (!saveItInPreviousScope) {
            String name = ctx.CP_CONTENT_IDENTIFIER().getSymbol().getText();
            if (CheckSymbols.checKResolve(currentScope, name) && CheckSymbols.checkScope(currentScope, ctx.CP_CONTENT_IDENTIFIER().getSymbol())) {
                Symbol var = currentScope.resolve(name);
                if (var == null) {

                    CheckSymbols.error(ctx.CP_CONTENT_IDENTIFIER().getSymbol(), "ti's null, idiot !!! ");
                } else {
                    System.out.println("PropertyName = " + var.getName());
                }
            }
        }else{
            String name = ctx.CP_CONTENT_IDENTIFIER().getSymbol().getText();
            if (CheckSymbols.checKResolve(currentScope.getEnclosingScope(), name) && CheckSymbols.checkScope(currentScope.getEnclosingScope(), ctx.CP_CONTENT_IDENTIFIER().getSymbol())) {
                Symbol var = currentScope.getEnclosingScope().resolve(name);
                if (var == null) {

                    CheckSymbols.error(ctx.CP_CONTENT_IDENTIFIER().getSymbol(), "ti's null, idiot !!! ");
                } else {
                    System.out.println("PropertyName = " + var.getName());
                }
            }
        }
    }

    @Override
    public void enterFunctionName(HTMLParser.FunctionNameContext ctx) {
        if (!saveItInPreviousScope) {
            String name = ctx.CP_CONTENT_IDENTIFIER().getSymbol().getText();
            if (CheckSymbols.checKResolve(currentScope, name) && CheckSymbols.checkScope(currentScope, ctx.CP_CONTENT_IDENTIFIER().getSymbol())) {
                System.out.println();
                System.out.println(currentScope.getName());
                Symbol var = currentScope.resolve(name);
                if (var == null) {

                    CheckSymbols.error(ctx.CP_CONTENT_IDENTIFIER().getSymbol(), "ti's null, idiot !!! ");
                } else {
                    System.out.println("Function = " + var.getName());
                }
            }
        }else{
            String name = ctx.CP_CONTENT_IDENTIFIER().getSymbol().getText();
            if (CheckSymbols.checKResolve(currentScope.getEnclosingScope(), name) && CheckSymbols.checkScope(currentScope.getEnclosingScope(), ctx.CP_CONTENT_IDENTIFIER().getSymbol())) {
                System.out.println();
                System.out.println(currentScope.getEnclosingScope().getName());
                Symbol var = currentScope.getEnclosingScope().resolve(name);
                if (var == null) {

                    CheckSymbols.error(ctx.CP_CONTENT_IDENTIFIER().getSymbol(), "ti's null, idiot !!! ");
                } else {
                    System.out.println("Function = " + var.getName());
                }
            }
        }
    }



    @Override
    public void enterMustacheExpression(HTMLParser.MustacheExpressionContext ctx) {
//        currentScope = scopes.get(ctx);


    }

    @Override
    public void enterMustacheVariable(HTMLParser.MustacheVariableContext ctx) {
        String name = ctx.MUSTACHE_IDENTIFIER().getSymbol().getText();
        if (CheckSymbols.checKResolve(currentScope,name)  && CheckSymbols.checkScope(currentScope,ctx.MUSTACHE_IDENTIFIER().getSymbol())){
            System.out.println();
            System.out.println(currentScope.getName());
            Symbol var = currentScope.resolve(name);
            if (var == null){

                CheckSymbols.error(ctx.MUSTACHE_IDENTIFIER().getSymbol(), "ti's null, idiot !!! ");
            }
            else{
                System.out.println("variableMust = "+var.getName());
            }
        }

    }

    @Override
    public void enterArrName4Must(HTMLParser.ArrName4MustContext ctx) {
        String name = ctx.MUSTACHE_IDENTIFIER().getSymbol().getText();
        if (CheckSymbols.checKResolve(currentScope,name)   && CheckSymbols.checkScope(currentScope,ctx.MUSTACHE_IDENTIFIER().getSymbol())){
            System.out.println();
            System.out.println(currentScope.getName());
            Symbol var = currentScope.resolve(name);
            if (var == null){

                CheckSymbols.error(ctx.MUSTACHE_IDENTIFIER().getSymbol(), "ti's null, idiot !!! ");
            }
            else{
                System.out.println("ArrayNameMust = "+var.getName());
            }
        }
    }


    @Override
    public void enterFunctionName4Must(HTMLParser.FunctionName4MustContext ctx) {
        String name = ctx.MUSTACHE_IDENTIFIER().getSymbol().getText();
        if (CheckSymbols.checKResolve(currentScope,name)   && CheckSymbols.checkScope(currentScope,ctx.MUSTACHE_IDENTIFIER().getSymbol())){
            System.out.println();
            System.out.println(currentScope.getName());
            Symbol var = currentScope.resolve(name);
            if (var == null){

                CheckSymbols.error(ctx.MUSTACHE_IDENTIFIER().getSymbol(), "ti's null, idiot !!! ");
            }
            else{
                System.out.println("FunctionNameMust = "+var.getName());
            }
        }
    }

    @Override
    public void enterSubObj4Must(HTMLParser.SubObj4MustContext ctx) {
        String name = ctx.MUSTACHE_IDENTIFIER().getSymbol().getText();
        if (CheckSymbols.checKResolve(currentScope,name)   && CheckSymbols.checkScope(currentScope,ctx.MUSTACHE_IDENTIFIER().getSymbol())){
            System.out.println();
            System.out.println(currentScope.getName());
            Symbol var = currentScope.resolve(name);
            if (var == null){

                CheckSymbols.error(ctx.MUSTACHE_IDENTIFIER().getSymbol(), "ti's null, idiot !!! ");
            }
            else{
                System.out.println("ObjNameMust = "+var.getName());
            }
        }
    }

    @Override
    public void enterPropertyValue4Must(HTMLParser.PropertyValue4MustContext ctx) {
        String name = ctx.MUSTACHE_IDENTIFIER().getSymbol().getText();
        if (CheckSymbols.checKResolve(currentScope,name) && CheckSymbols.checkScope(currentScope,ctx.MUSTACHE_IDENTIFIER().getSymbol())){
            Symbol var = currentScope.resolve(name);
            if (var == null){
                CheckSymbols.error(ctx.MUSTACHE_IDENTIFIER().getSymbol(), "ti's null, idiot !!! ");
            }
            else{
                System.out.println("ObjNameMust = "+var.getName());
            }
        }
    }

    @Override
    public void exitFilter(HTMLParser.FilterContext ctx) {

        if (ctx.MUSTACHE_STRING() != null){
            String value = ctx.MUSTACHE_STRING().getSymbol().getText();
            if (!CheckSymbols.CheckTypeOfFormat(value)){
                CheckSymbols.error(ctx.MUSTACHE_STRING().getSymbol(), "it's not good for the format, idiot !!! ");
            }
        }
    }

    @Override
    public void enterModelName(HTMLParser.ModelNameContext ctx) {
        String name = ctx.MUSTACHE_IDENTIFIER().getSymbol().getText();
        if (CheckSymbols.checKResolve(currentScope,name) &&
                CheckSymbols.checkScope(currentScope,ctx.MUSTACHE_IDENTIFIER().getSymbol())){

            System.out.println();
            System.out.println(currentScope.getName());
            Symbol var = currentScope.resolve(name);
            if (var == null){
                CheckSymbols.error(ctx.MUSTACHE_IDENTIFIER().getSymbol(), "ti's null, idiot !!! ");
            }
            else{
                System.out.println("ModelNameMust = "+var.getName());
            }
        }
    }

    @Override
    public void enterFormatName(HTMLParser.FormatNameContext ctx) {
        if (ctx.MUSTACHE_IDENTIFIER().getSymbol().getText().equals("date")){
            CheckSymbols.setTypeOfFormat("date");

        }else if(ctx.MUSTACHE_IDENTIFIER().getSymbol().getText().equals("currency")){
            CheckSymbols.setTypeOfFormat("currency");

        }else if(ctx.MUSTACHE_IDENTIFIER().getSymbol().getText().equals("upper")){
            CheckSymbols.setTypeOfFormat("upper");

        }else if(ctx.MUSTACHE_IDENTIFIER().getSymbol().getText().equals("lower")){
            CheckSymbols.setTypeOfFormat("lower");
        }else{
            CheckSymbols.setTypeOfFormat("somethingWrong");
        }



    }



    /////////////////////////////////////////////////


    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        super.enterEveryRule(ctx);
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        super.exitEveryRule(ctx);
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        super.visitTerminal(node);
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        super.visitErrorNode(node);
    }
}
