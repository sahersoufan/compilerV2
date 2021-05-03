package AST.Elements;

import java.util.ArrayList;
import java.util.List;

public class HtmlElementsComp {
    private HtmlElement htmlElement;
    private List<HtmlMisc> htmlMiscList = new ArrayList<>();

    public HtmlElement getHtmlElement() {
        return htmlElement;
    }

    public void setHtmlElement(HtmlElement htmlElement) {
        this.htmlElement = htmlElement;
    }

    public List<HtmlMisc> getHtmlMiscList() {
        return htmlMiscList;
    }

    public void setHtmlMiscList(List<HtmlMisc> htmlMiscList) {
        this.htmlMiscList = htmlMiscList;
    }
}
