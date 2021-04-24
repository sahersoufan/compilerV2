package AST.Elements.ElementsNodes.generic4Elements.comparison;

import AST.Elements.ElementsNodes.generic4Elements.Collection4ARITHMETIC;

import java.util.ArrayList;

public class OneLineArithCondition {
    private Collection4oneLineCondition collection4oneLineCondition;
    private ArrayList<Collection4oneLineCondition> collection4oneLineConditions = new ArrayList<>();
    private Collection4ARITHMETIC firstCollection4ARITHMETIC;
    private Collection4ARITHMETIC secondCollection4ARITHMETIC;

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

    public Collection4ARITHMETIC getFirstCollection4ARITHMETIC() {
        return firstCollection4ARITHMETIC;
    }

    public void setFirstCollection4ARITHMETIC(Collection4ARITHMETIC firstCollection4ARITHMETIC) {
        this.firstCollection4ARITHMETIC = firstCollection4ARITHMETIC;
    }

    public Collection4ARITHMETIC getSecondCollection4ARITHMETIC() {
        return secondCollection4ARITHMETIC;
    }

    public void setSecondCollection4ARITHMETIC(Collection4ARITHMETIC secondCollection4ARITHMETIC) {
        this.secondCollection4ARITHMETIC = secondCollection4ARITHMETIC;
    }
}
