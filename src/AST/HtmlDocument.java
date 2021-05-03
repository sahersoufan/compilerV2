package AST;

import AST.Elements.HtmlElements;
import AST.Elements.ScriptLetOrSeaWs;

import java.util.ArrayList;
import java.util.List;

public class HtmlDocument {
    private List<ScriptLetOrSeaWs> scriptLetORSeaWs = new ArrayList<>();
    private String DTD;
    private HtmlXML htmlXML;
    private HtmlEle htmlEle;

    public List<ScriptLetOrSeaWs> getScriptLetORSeaWs() {
        return scriptLetORSeaWs;
    }

    public void setScriptLetORSeaWs(List<ScriptLetOrSeaWs> scriptLetORSeaWs) {
        this.scriptLetORSeaWs = scriptLetORSeaWs;
    }

    public String getDTD() {
        return DTD;
    }

    public void setDTD(String DTD) {
        this.DTD = DTD;
    }

    public HtmlXML getHtmlXML() {
        return htmlXML;
    }

    public void setHtmlXML(HtmlXML htmlXML) {
        this.htmlXML = htmlXML;
    }

    public HtmlEle getHtmlEle() {
        return htmlEle;
    }

    public void setHtmlEle(HtmlEle htmlEle) {
        this.htmlEle = htmlEle;
    }
}
