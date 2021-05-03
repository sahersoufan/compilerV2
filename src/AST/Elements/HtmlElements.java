package AST.Elements;

import java.util.ArrayList;
import java.util.List;

public class HtmlElements {

    private List<HtmlMisc> misc = new ArrayList<>();
    private HtmlElementsComp htmlElement;

    public List<HtmlMisc> getMisc() {
        return misc;
    }

    public void setMisc(List<HtmlMisc> misc) {
        this.misc = misc;
    }

    public HtmlElementsComp getHtmlElement() {
        return htmlElement;
    }

    public void setHtmlElement(HtmlElementsComp htmlElement) {
        this.htmlElement = htmlElement;
    }
}
