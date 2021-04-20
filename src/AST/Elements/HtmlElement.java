package AST.Elements;


import AST.Elements.ElementsNodes.HtmlAttribute;
import AST.Elements.ElementsNodes.HtmlContent;
import AST.Elements.ElementsNodes.script;
import AST.Elements.ElementsNodes.style;
import AST.Elements.ElementsNodes.mustacheExpression.mustacheExpression;
import java.util.ArrayList;
import java.util.List;

public class HtmlElement {


    private String tagName;
    private List<HtmlAttribute> htmlAttributeList = new ArrayList<>();
    private HtmlContent htmlContent = new HtmlContent();
    private mustacheExpression mustacheExpression = new mustacheExpression();
    private String ScriptLet;
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

    public AST.Elements.ElementsNodes.mustacheExpression.mustacheExpression getMustacheExpression() {
        return mustacheExpression;
    }

    public void setMustacheExpression(AST.Elements.ElementsNodes.mustacheExpression.mustacheExpression mustacheExpression) {
        this.mustacheExpression = mustacheExpression;
    }

    public String getScriptLet() {
        return ScriptLet;
    }

    public void setScriptLet(String scriptLet) {
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
