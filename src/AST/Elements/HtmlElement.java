package AST.Elements;


import AST.Elements.ElementsNodes.HtmlAttribute;
import AST.Elements.ElementsNodes.HtmlContent;
import AST.Elements.ElementsNodes.Script;
import AST.Elements.ElementsNodes.Style;
import AST.Elements.ElementsNodes.mustacheExpression.MustacheExpression;
import java.util.ArrayList;
import java.util.List;

public class HtmlElement {


    private String tagName;
    private List<HtmlAttribute> htmlAttributeList = new ArrayList<>();
    private HtmlContent htmlContent = new HtmlContent();
    private MustacheExpression mustacheExpression = new MustacheExpression();
    private String ScriptLet;
    private Script script;
    private Style style;

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

    public String getScriptLet() {
        return ScriptLet;
    }

    public void setScriptLet(String scriptLet) {
        ScriptLet = scriptLet;
    }

    public Script getScript() {
        return script;
    }

    public void setScript(Script script) {
        this.script = script;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }
}
