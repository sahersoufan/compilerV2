package AST.Elements.ElementsNodes;

import AST.Elements.HtmlComment;
import AST.Elements.HtmlElement;

public class HtmlContentComp {
    private HtmlElement htmlElement;
    private String CDATA;
    private HtmlComment htmlComment;
    private HtmlCharData htmlCharData;


    public HtmlElement getHtmlElement() {
        return htmlElement;
    }

    public void setHtmlElement(HtmlElement htmlElement) {
        this.htmlElement = htmlElement;
    }

    public String getCDATA() {
        return CDATA;
    }

    public void setCDATA(String CDATA) {
        this.CDATA = CDATA;
    }

    public HtmlComment getHtmlComment() {
        return htmlComment;
    }

    public void setHtmlComment(HtmlComment htmlComment) {
        this.htmlComment = htmlComment;
    }

    public HtmlCharData getHtmlCharData() {
        return htmlCharData;
    }

    public void setHtmlCharData(HtmlCharData htmlCharData) {
        this.htmlCharData = htmlCharData;
    }
}
