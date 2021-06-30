package symTab;

import generatedGrammers.HTMLParser;
import generatedGrammers.HTMLParserBaseListener;
import org.antlr.symtab.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;
import symTab.symbolsClasses.Elements.ElementsNodes.CpExpression.For.ForExpression;
import symTab.symbolsClasses.Elements.ElementsNodes.CpExpression.If.IfExpression;
import symTab.symbolsClasses.Elements.ElementsNodes.CpExpression.Switch.SwitchCaseExpression;
import symTab.symbolsClasses.Elements.ElementsNodes.CpExpression.app.AppExpression;

import java.util.Stack;

import static symTab.CheckSymbols.checkScope;

public class DefPhase extends HTMLParserBaseListener {
    ParseTreeProperty<Scope> scopes = new ParseTreeProperty<Scope>();
    GlobalScope globals;
    Scope currentScope;
    Stack<String> elementNames = new Stack<>();
    String thisElement = "";



    void saveScope(ParserRuleContext ctx, Scope s) { scopes.put(ctx, s); }

    @Override
    public void enterHtmlDocument(HTMLParser.HtmlDocumentContext ctx) {
        globals = new GlobalScope(null);
        currentScope = globals;
    }

    @Override
    public void exitHtmlDocument(HTMLParser.HtmlDocumentContext ctx) {
    }


    @Override
    public void enterHtmlElement(HTMLParser.HtmlElementContext ctx) {
        String tag2 = "";
        String tag1 = "";
        if (!ctx.TAG_NAME().isEmpty()) {
            try {
                if (ctx.TAG_NAME(0) != null) {
                    tag1 = ctx.TAG_NAME(0).getSymbol().getText();
                    thisElement = tag1;
                    elementNames.push(thisElement);
                }

                if (ctx.TAG_NAME(1) != null) {
                    tag2 = ctx.TAG_NAME(1).getSymbol().getText();
                    if (!ctx.TAG_NAME(0).getSymbol().getText().equals(ctx.TAG_NAME(1).getSymbol().getText())) {
                        throw new Exception();
                    }
                }
            } catch (Exception e) {
                System.out.println();
                System.out.println("tags" + tag1 + " and " + tag2 + " are not equal");
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
    public void exitHtmlAttribute(HTMLParser.HtmlAttributeContext ctx) {
        super.exitHtmlAttribute(ctx);
    }

    @Override
    public void enterAppExpression(HTMLParser.AppExpressionContext ctx) {
    }

    @Override
    public void exitAppExpression(HTMLParser.AppExpressionContext ctx) {
        currentScope = new AppExpression(currentScope, "APP");
        saveScope(ctx, currentScope);

    }

    @Override
    public void enterForExpression(HTMLParser.ForExpressionContext ctx) {
        currentScope = new ForExpression(currentScope, "FOR");
        saveScope(ctx,currentScope);
    }

    @Override
    public void exitForExpression(HTMLParser.ForExpressionContext ctx) {

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
    public void enterSwitchCaseExpression(HTMLParser.SwitchCaseExpressionContext ctx) {
    }

    @Override
    public void exitSwitchCaseExpression(HTMLParser.SwitchCaseExpressionContext ctx) {

        currentScope  = new SwitchCaseExpression(currentScope, "CASE");
        saveScope(ctx,currentScope);

    }

    @Override
    public void enterIfExpression(HTMLParser.IfExpressionContext ctx) {
    }

    @Override
    public void exitIfExpression(HTMLParser.IfExpressionContext ctx) {

        currentScope = new IfExpression(currentScope, "IF");
        saveScope(ctx,currentScope);

    }

    @Override
    public void enterVariableName(HTMLParser.VariableNameContext ctx) {


    }

    @Override
    public void exitVariableName(HTMLParser.VariableNameContext ctx) {
        if (ctx.CP_CONTENT_IDENTIFIER() != null){
            defineVar(ctx.CP_CONTENT_IDENTIFIER().getSymbol());
        }


    }

    @Override
    public void enterArrName(HTMLParser.ArrNameContext ctx) {

    }

    @Override
    public void exitArrName(HTMLParser.ArrNameContext ctx) {
        if (ctx.CP_CONTENT_IDENTIFIER() != null){
            defineVar(ctx.CP_CONTENT_IDENTIFIER().getSymbol());
        }

    }

    @Override
    public void enterObj(HTMLParser.ObjContext ctx) {

    }

    @Override
    public void exitObj(HTMLParser.ObjContext ctx) {
        if (ctx.CP_CONTENT_IDENTIFIER() != null){
            defineVar(ctx.CP_CONTENT_IDENTIFIER().getSymbol());
        }

    }

    @Override
    public void enterSubObj(HTMLParser.SubObjContext ctx) {

    }

    @Override
    public void exitSubObj(HTMLParser.SubObjContext ctx) {
        if (ctx.CP_CONTENT_IDENTIFIER() != null){
            defineVar(ctx.CP_CONTENT_IDENTIFIER().getSymbol());
        }

    }

    @Override
    public void enterFunctionName(HTMLParser.FunctionNameContext ctx) {

    }

    @Override
    public void exitFunctionName(HTMLParser.FunctionNameContext ctx) {
        if (ctx.CP_CONTENT_IDENTIFIER() != null){
            defineVar(ctx.CP_CONTENT_IDENTIFIER().getSymbol());
        }

    }

    @Override
    public void exitPropertyValue(HTMLParser.PropertyValueContext ctx) {
        if (ctx.CP_CONTENT_IDENTIFIER() != null){
            defineVar(ctx.CP_CONTENT_IDENTIFIER().getSymbol());
        }
    }

    @Override
    public void enterMustacheExpression(HTMLParser.MustacheExpressionContext ctx) {

//        if (ctx != null){
//            currentScope = new MustacheExpression(currentScope);
//            saveScope(ctx,currentScope);
//        }
    }

    @Override
    public void exitMustacheExpression(HTMLParser.MustacheExpressionContext ctx) {
//        currentScope = currentScope.getEnclosingScope();
    }

    @Override
    public void enterMustacheVariable(HTMLParser.MustacheVariableContext ctx) {
        super.enterMustacheVariable(ctx);

    }

    @Override
    public void exitMustacheVariable(HTMLParser.MustacheVariableContext ctx) {

        if (ctx.MUSTACHE_IDENTIFIER() != null){
            defineVar(ctx.MUSTACHE_IDENTIFIER().getSymbol());
        }
    }

    @Override
    public void enterArrName4Must(HTMLParser.ArrName4MustContext ctx) {
        super.enterArrName4Must(ctx);
    }

    @Override
    public void exitArrName4Must(HTMLParser.ArrName4MustContext ctx) {
        if (ctx.MUSTACHE_IDENTIFIER() != null){
            defineVar(ctx.MUSTACHE_IDENTIFIER().getSymbol());
        }
    }

    @Override
    public void enterFunctionName4Must(HTMLParser.FunctionName4MustContext ctx) {
        super.enterFunctionName4Must(ctx);
    }

    @Override
    public void exitFunctionName4Must(HTMLParser.FunctionName4MustContext ctx) {
        if (ctx.MUSTACHE_IDENTIFIER() != null){
            defineVar(ctx.MUSTACHE_IDENTIFIER().getSymbol());
        }
    }

    @Override
    public void enterSubObj4Must(HTMLParser.SubObj4MustContext ctx) {
        super.enterSubObj4Must(ctx);
    }

    @Override
    public void exitPropertyValue4Must(HTMLParser.PropertyValue4MustContext ctx) {
        if (ctx.MUSTACHE_IDENTIFIER() != null){
            defineVar(ctx.MUSTACHE_IDENTIFIER().getSymbol());
        }
    }

    @Override
    public void exitSubObj4Must(HTMLParser.SubObj4MustContext ctx) {
        if (ctx.MUSTACHE_IDENTIFIER() != null){
            defineVar(ctx.MUSTACHE_IDENTIFIER().getSymbol());
        }
    }



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




    void defineVar(Token nameToken) {
        VariableSymbol var = new VariableSymbol(nameToken.getText());
        if (!saveItInPreviousScope) {
            boolean addIt = checkScope(currentScope, nameToken);
            if (addIt) {
                try {
                    currentScope.define(var); // Define symbol in current scope
                } catch (IllegalArgumentException ignored) {
                }
            }
        }else{
            boolean addIt = checkScope(currentScope.getEnclosingScope(), nameToken);
            if (addIt) {
                try {
                    currentScope.getEnclosingScope().define(var); // Define symbol in current scope
                } catch (IllegalArgumentException ignored) {
                }
            }
        }
    }

}
