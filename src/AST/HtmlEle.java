package AST;

import AST.Elements.HtmlElements;
import AST.Elements.ScriptLetOrSeaWs;

import java.util.ArrayList;
import java.util.List;

public class HtmlEle {
    private List<ScriptLetOrSeaWs> scriptLetOrSeaWs = new ArrayList<>();
    private List<HtmlElements> htmlElements = new ArrayList<>();

    public List<ScriptLetOrSeaWs> getScriptLetOrSeaWs() {
        return scriptLetOrSeaWs;
    }

    public void setScriptLetOrSeaWs(List<ScriptLetOrSeaWs> scriptLetOrSeaWs) {
        this.scriptLetOrSeaWs = scriptLetOrSeaWs;
    }

    public List<HtmlElements> getHtmlElements() {
        return htmlElements;
    }

    public void setHtmlElements(List<HtmlElements> htmlElements) {
        this.htmlElements = htmlElements;
    }
}
