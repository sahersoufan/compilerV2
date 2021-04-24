package AST.Elements.ElementsNodes.generic4Elements.array;

import AST.Elements.ElementsNodes.generic4Elements.Collection4everything;

import java.util.ArrayList;

public class Array {
    private Collection4everything collection4everything;
    private ArrayList<Collection4everything> internalCollection4everythings = new ArrayList<>();

    public Collection4everything getCollection4everything() {
        return collection4everything;
    }

    public void setCollection4everything(Collection4everything collection4everything) {
        this.collection4everything = collection4everything;
    }

    public ArrayList<Collection4everything> getInternalCollection4everythings() {
        return internalCollection4everythings;
    }

    public void setInternalCollection4everythings(ArrayList<Collection4everything> internalCollection4everythings) {
        this.internalCollection4everythings = internalCollection4everythings;
    }
}
