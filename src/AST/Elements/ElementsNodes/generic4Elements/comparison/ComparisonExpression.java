package AST.Elements.ElementsNodes.generic4Elements.comparison;

import AST.Elements.ElementsNodes.generic4Elements.Collection4comparison;

public class ComparisonExpression {
    private Collection4comparison collection4comparison1;
    private ComparisonOperator comparisonOperator;
    private Collection4comparison collection4comparison2;

    public Collection4comparison getCollection4comparison1() {
        return collection4comparison1;
    }

    public void setCollection4comparison1(Collection4comparison collection4comparison1) {
        this.collection4comparison1 = collection4comparison1;
    }

    public ComparisonOperator getComparisonOperator() {
        return comparisonOperator;
    }

    public void setComparisonOperator(ComparisonOperator comparisonOperator) {
        this.comparisonOperator = comparisonOperator;
    }

    public Collection4comparison getCollection4comparison2() {
        return collection4comparison2;
    }

    public void setCollection4comparison2(Collection4comparison collection4comparison2) {
        this.collection4comparison2 = collection4comparison2;
    }
}
