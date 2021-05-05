package AST;

import AST.Elements.ScriptLetOrSeaWs;

import java.util.List;

public class HtmlXML {
    private List<ScriptLetOrSeaWs> scriptLetOrSeaWs;
    private String XML;

    public List<ScriptLetOrSeaWs> getScriptLetOrSeaWs() {
        return scriptLetOrSeaWs;
    }

    public void setScriptLetOrSeaWs(List<ScriptLetOrSeaWs> scriptLetOrSeaWs) {
        this.scriptLetOrSeaWs = scriptLetOrSeaWs;
    }

    public String getXML() {
        return XML;
    }

    public void setXML(String XML) {
        this.XML = XML;
    }
}
