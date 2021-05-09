package AST;

import AST.Elements.HtmlElements;
import AST.Elements.ScriptLetOrSeaWs;

import java.util.ArrayList;
import java.util.List;

public class HtmlDocument {
    private List<ScriptLetOrSeaWs> scriptLetORSeaWs = new ArrayList<>();
    private String DTD;
    private String XML;
    private List<HtmlElements> htmlElements = new ArrayList<>();


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

    public String getXML() {
        return XML;
    }

    public void setXML(String XML) {
        this.XML = XML;
    }

    public List<HtmlElements> getHtmlElements() {
        return htmlElements;
    }


    public void setHtmlElements(List<HtmlElements> htmlElements) {
            this.htmlElements = htmlElements;
    }
}
