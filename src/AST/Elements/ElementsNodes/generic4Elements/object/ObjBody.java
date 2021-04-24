package AST.Elements.ElementsNodes.generic4Elements.object;

import java.util.ArrayList;

public class ObjBody {
    private ArrayList<Pair> pairs = new ArrayList<>();
    private ArrayList<Pair> internalPairs = new ArrayList<>();

    public ArrayList<Pair> getPairs() {
        return pairs;
    }

    public void setPairs(ArrayList<Pair> pairs) {
        this.pairs = pairs;
    }

    public ArrayList<Pair> getInternalPairs() {
        return internalPairs;
    }

    public void setInternalPairs(ArrayList<Pair> internalPairs) {
        this.internalPairs = internalPairs;
    }
}
