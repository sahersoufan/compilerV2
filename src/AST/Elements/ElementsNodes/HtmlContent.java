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



    public List<String> getCDATA() {
        return CDATA;
    }



    public List<HtmlComment> getHtmlComment() {
        return htmlComment;
    }


    public List<HtmlCharData> getHtmlCharData() {
        return htmlCharData;
    }



    public void setHtmlComment(List<HtmlComment> htmlComments) {
        this.htmlComment=htmlComments;
    }

    public void setCDATA(List<String> cData) {
        this.CDATA = CDATA;
    }

    public void setHtmlCharData(List<HtmlCharData> htmlCharData) {
        this.htmlCharData = htmlCharData;
    }

    public void setHtmlElement(List<HtmlElement> htmlElements) {
        this.htmlElement = htmlElement;
    }
}
