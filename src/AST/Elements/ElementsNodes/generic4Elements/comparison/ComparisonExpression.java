package AST.Elements.ElementsNodes.generic4Elements.comparison;

public class ComparisonExpression {
    private Collection4comparison firstCollection4comparison;
    private ComparisonOperator comparisonOperator;
    private Collection4comparison secondCollection4comparison;

    public Collection4comparison getFirstCollection4comparison() {
        return firstCollection4comparison;
    }

    public void setFirstCollection4comparison(Collection4comparison firstCollection4comparison) {
        this.firstCollection4comparison = firstCollection4comparison;
    }

    public ComparisonOperator getComparisonOperator() {
        return comparisonOperator;
    }

    public void setComparisonOperator(ComparisonOperator comparisonOperator) {
        this.comparisonOperator = comparisonOperator;
    }

    public Collection4comparison getSecondCollection4comparison() {
        return secondCollection4comparison;
    }

    public void setSecondCollection4comparison(Collection4comparison secondCollection4comparison) {
        this.secondCollection4comparison = secondCollection4comparison;
    }
}
