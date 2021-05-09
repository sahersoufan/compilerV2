package AST.Elements;

import java.util.ArrayList;
import java.util.List;

public class HtmlElements {

    private List<HtmlMisc> misc = new ArrayList<>();
    private HtmlElement htmlElement;

    public List<HtmlMisc> getMisc() {
        return misc;
    }

    public void setMisc(List<HtmlMisc> misc) {
        this.misc = misc;
    }

    public HtmlElement getHtmlElement() {
        return htmlElement;
    }

    public void setHtmlElement(HtmlElement htmlElement) {
        this.htmlElement = htmlElement;
    }
}
