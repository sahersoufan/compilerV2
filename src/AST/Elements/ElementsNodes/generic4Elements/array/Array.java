package AST.Elements.ElementsNodes.generic4Elements.array;

import AST.Elements.ElementsNodes.generic4Elements.Collection4everything;

import java.util.ArrayList;

public class Array {
    private String openBracket;
    private ArrayList<Collection4everything> internalCollection4everythings = new ArrayList<>();
    private String closeBracket;

    public String getOpenBracket() {
        return openBracket;
    }

    public void setOpenBracket(String openBracket) {
        this.openBracket = openBracket;
    }

    public String getCloseBracket() {
        return closeBracket;
    }

    public void setCloseBracket(String closeBracket) {
        this.closeBracket = closeBracket;
    }

    public ArrayList<Collection4everything> getInternalCollection4everythings() {
        return internalCollection4everythings;
    }

    public void setInternalCollection4everythings(ArrayList<Collection4everything> internalCollection4everythings) {
        this.internalCollection4everythings = internalCollection4everythings;
    }
}
