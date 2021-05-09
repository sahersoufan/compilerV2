package AST.Elements.ElementsNodes;


import AST.Elements.HtmlComment;
import AST.Elements.HtmlElement;

import java.util.ArrayList;
import java.util.List;

public class HtmlContent {
    private List<HtmlElement> htmlElement = new ArrayList<>();
    private List<String> CDATA = new ArrayList<>();
    private List<HtmlComment> htmlComment = new ArrayList<>();
    private List<HtmlCharData> htmlCharData = new ArrayList<>();

    public List<HtmlElement> getHtmlElement() {
        return htmlElement;
    }

    public void setHtmlElement(List<HtmlElement> htmlElement) {
        this.htmlElement = htmlElement;
    }

    public List<String> getCDATA() {
        return CDATA;
    }

    public void setCDATA(List<String> CDATA) {
        this.CDATA = CDATA;
    }

    public List<HtmlComment> getHtmlComment() {
        return htmlComment;
    }

    public void setHtmlComment(List<HtmlComment> htmlComment) {
        this.htmlComment = htmlComment;
    }

    public List<HtmlCharData> getHtmlCharData() {
        return htmlCharData;
    }

    public void setHtmlCharData(List<HtmlCharData> htmlCharData) {
        this.htmlCharData = htmlCharData;
    }
}
