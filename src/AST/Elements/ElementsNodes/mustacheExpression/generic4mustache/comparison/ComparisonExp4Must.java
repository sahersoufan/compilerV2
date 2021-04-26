package AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.comparison;

import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Collection4CompMust;

public class ComparisonExp4Must {
    private Collection4CompMust collection4CompMust;
      private MustacheComparisonOperator mustacheComparisonOperator;

    public void setCollection4CompMust(Collection4CompMust collection4CompMust) {
        this.collection4CompMust = collection4CompMust;
    }

    public void setMustacheComparisonOperator(MustacheComparisonOperator mustacheComparisonOperator) {
        this.mustacheComparisonOperator = mustacheComparisonOperator;

    }

    public Collection4CompMust getCollection4CompMust() {
        return collection4CompMust;
    }

    public MustacheComparisonOperator getMustacheComparisonOperator() {
        return mustacheComparisonOperator;
    }
}
