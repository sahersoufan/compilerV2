package AST.Elements.ElementsNodes.generic4Elements.object;

import java.util.ArrayList;

public class ObjBody {
    private String openCurlyBracket;
    private ArrayList<Pair> pairs = new ArrayList<>();
    private String closeCurlyBracket;

    public String getOpenCurlyBracket() {
        return openCurlyBracket;
    }

    public void setOpenCurlyBracket(String openCurlyBracket) {
        this.openCurlyBracket = openCurlyBracket;
    }

    public ArrayList<Pair> getPairs() {
        return pairs;
    }

    public void setPairs(ArrayList<Pair> pairs) {
        this.pairs = pairs;
    }

    public String getCloseCurlyBracket() {
        return closeCurlyBracket;
    }

    public void setCloseCurlyBracket(String closeCurlyBracket) {
        this.closeCurlyBracket = closeCurlyBracket;
    }
}
