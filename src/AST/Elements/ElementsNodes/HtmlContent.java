package AST.Elements.ElementsNodes;

import old.generatedback.ASTBack.Elements.HtmlElement;

import java.util.ArrayList;
import java.util.List;


public class HtmlContent {


    private List<HtmlCharData> htmlCharDataList = new ArrayList<>();
    private List<HtmlElement> htmlElement = new ArrayList<>();
    private List<String> htmlComment = new ArrayList<>();
    private List<CData> cDatas = new List<CData>();

    public List<HtmlCharData> getHtmlCharDataList() {
        return htmlCharDataList;
    }

    public void setHtmlCharDataList(List<HtmlCharData> htmlCharDataList) {
        this.htmlCharDataList = htmlCharDataList;
    }

    public List<HtmlElement> getHtmlElement() {
        return htmlElement;
    }

    public void setHtmlElement(List<HtmlElement> htmlElement) {
        this.htmlElement = htmlElement;
    }

    public List<String> getHtmlComment() {
        return htmlComment;
    }

    public void setHtmlComment(List<String> htmlComment) {
        this.htmlComment = htmlComment;
    }

    public List<CData> getcDatas() {
        return cDatas;
    }

    public void setcDatas(List<CData> cDatas) {
        this.cDatas = cDatas;
    }
}
