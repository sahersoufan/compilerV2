package AST.Elements.ElementsNodes.CpExpression.For;


import AST.Elements.ElementsNodes.generic4Elements.comparison.Collection4oneLineCondition;

import java.util.ArrayList;
import java.util.List;

public class OneLine4For2Condition {


    private List<Collection4oneLineCondition> collection4oneLineCondition=new ArrayList<>();
    private Collection4For2 collection4For2;
    // TODO make this right ! && ||
    // TODO check this


    public List<Collection4oneLineCondition> getCollection4oneLineCondition() {
        return collection4oneLineCondition;
    }

    public void setCollection4oneLineCondition(List<Collection4oneLineCondition> collection4oneLineCondition) {
        this.collection4oneLineCondition = collection4oneLineCondition;
    }

    public Collection4For2 getCollection4For2() {
        return collection4For2;
    }

    public void setCollection4For2(Collection4For2 collection4For2) {
        this.collection4For2 = collection4For2;
    }
}
