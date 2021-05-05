package AST.Elements.ElementsNodes;


import AST.Elements.HtmlElement;

import java.util.ArrayList;
import java.util.List;

public class HtmlContent {


    private HtmlCharData htmlCharDataList;
    private List<HtmlContentComp> htmlContentComps = new ArrayList<>();

    public HtmlCharData getHtmlCharDataList() {
        return htmlCharDataList;
    }

    public void setHtmlCharDataList(HtmlCharData htmlCharDataList) {
        this.htmlCharDataList = htmlCharDataList;
    }

    public List<HtmlContentComp> getHtmlContentComps() {
        return htmlContentComps;
    }

    public void setHtmlContentComps(List<HtmlContentComp> htmlContentComps) {
        this.htmlContentComps = htmlContentComps;
    }
}
