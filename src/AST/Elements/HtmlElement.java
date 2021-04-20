package AST.Elements;

import old.generatedback.ASTBack.Elements.ElementsNodes.*;
import old.generatedback.ASTBack.Elements.ElementsNodes.MustacheExpression.MustacheExpression;

import java.util.ArrayList;
import java.util.List;

public class HtmlElement {


    private String tagName;
    private List<HtmlAttribute> htmlAttributeList = new ArrayList<>();
    private HtmlContent htmlContent = new HtmlContent();
    private MustacheExpression mustacheExpression = new MustacheExpression();
    private ScriptLet ScriptLet;
    private script script;
    private style style;

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public List<HtmlAttribute> getHtmlAttributeList() {
        return htmlAttributeList;
    }

    public void setHtmlAttributeList(List<HtmlAttribute> htmlAttributeList) {
        this.htmlAttributeList = htmlAttributeList;
    }

    public HtmlContent getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(HtmlContent htmlContent) {
        this.htmlContent = htmlContent;
    }

    public MustacheExpression getMustacheExpression() {
        return mustacheExpression;
    }

    public void setMustacheExpression(MustacheExpression mustacheExpression) {
        this.mustacheExpression = mustacheExpression;
    }

    public ScriptLet getScriptLet() {
        return ScriptLet;
    }

    public void setScriptLet(ScriptLet scriptLet) {
        ScriptLet = scriptLet;
    }

    public script getScript() {
        return script;
    }

    public void setScript(script script) {
        this.script = script;
    }

    public style getStyle() {
        return style;
    }

    public void setStyle(style style) {
        this.style = style;
    }
}
