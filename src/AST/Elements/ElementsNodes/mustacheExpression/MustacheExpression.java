package AST.Elements.ElementsNodes.mustacheExpression;

import AST.Elements.ElementsNodes.mustacheExpression.filter.Filter;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Collection4Mustache;

public class MustacheExpression {
    private Collection4Mustache collection4Mustache;
    private Filter filter;

    public void setCollection4Mustache(Collection4Mustache collection4Mustache) {
        this.collection4Mustache = collection4Mustache;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public Collection4Mustache getCollection4Mustache() {
        return collection4Mustache;
    }

    public Filter getFilter() {
        return filter;
    }
}
