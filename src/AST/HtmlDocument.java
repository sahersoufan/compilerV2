package AST;

import AST.Elements.HtmlElements;
import AST.Elements.ScriptLetOrSeaWs;

import java.util.ArrayList;
import java.util.List;

public class HtmlDocument {




    private List<ScriptLetOrSeaWs> scriptLetORSeaWs = new ArrayList<>();
    private String XML;
    private String DTD;
    private List<HtmlElements> htmlElements = new ArrayList<>();


    public List<ScriptLetOrSeaWs> getScriptLetORSeaWs() {
        return scriptLetORSeaWs;
    }

    public void setScriptLetORSeaWs(List<ScriptLetOrSeaWs> scriptLetORSeaWs) {
        this.scriptLetORSeaWs = scriptLetORSeaWs;
    }

    public String getXML() {
        return XML;
    }

    public void setXML(String XML) {
        this.XML = XML;
    }

    public String getDTD() {
        return DTD;
    }

    public void setDTD(String DTD) {
        this.DTD = DTD;
    }

    public List<HtmlElements> getHtmlElements() {
        return htmlElements;
    }

    public void setHtmlElements(List<HtmlElements> htmlElements) {
        this.htmlElements = htmlElements;
    }
}
