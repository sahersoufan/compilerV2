package AST.Elements.ElementsNodes.generic4Elements.object;

import java.util.ArrayList;

public class ObjBody {
    private ArrayList<Pair> pairs = new ArrayList<>();

    public ArrayList<Pair> getPair() {
        return pairs;
    }

    public void setPair(ArrayList<Pair> pair) {
        this.pairs = pair;
    }
}
