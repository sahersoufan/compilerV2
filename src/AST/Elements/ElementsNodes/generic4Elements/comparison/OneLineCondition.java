package AST.Elements.ElementsNodes.generic4Elements.comparison;

import AST.Elements.ElementsNodes.generic4Elements.Collection4everything;

import java.util.ArrayList;

public class OneLineCondition {
    private Collection4oneLineCondition collection4oneLineCondition;
    private ArrayList<Collection4oneLineCondition> collection4oneLineConditions = new ArrayList<>();
    private Collection4everything firstCollection4everything;
    private Collection4everything secondCollection4everything;

    public Collection4oneLineCondition getCollection4oneLineCondition() {
        return collection4oneLineCondition;
    }

    public void setCollection4oneLineCondition(Collection4oneLineCondition collection4oneLineCondition) {
        this.collection4oneLineCondition = collection4oneLineCondition;
    }

    public ArrayList<Collection4oneLineCondition> getCollection4oneLineConditions() {
        return collection4oneLineConditions;
    }

    public void setCollection4oneLineConditions(ArrayList<Collection4oneLineCondition> collection4oneLineConditions) {
        this.collection4oneLineConditions = collection4oneLineConditions;
    }

    public Collection4everything getFirstCollection4everything() {
        return firstCollection4everything;
    }

    public void setFirstCollection4everything(Collection4everything firstCollection4everything) {
        this.firstCollection4everything = firstCollection4everything;
    }

    public Collection4everything getSecondCollection4everything() {
        return secondCollection4everything;
    }

    public void setSecondCollection4everything(Collection4everything secondCollection4everything) {
        this.secondCollection4everything = secondCollection4everything;
    }
}
