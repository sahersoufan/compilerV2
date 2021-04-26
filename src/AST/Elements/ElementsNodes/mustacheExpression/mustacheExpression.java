package AST.Elements.ElementsNodes.mustacheExpression;

import AST.Elements.ElementsNodes.mustacheExpression.filter.filter;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.collection4Mustache;

public class mustacheExpression {
    private collection4Mustache collection4Mustache;
    private filter filter;

    public void setCollection4Mustache(collection4Mustache collection4Mustache) {
        this.collection4Mustache = collection4Mustache;
    }

    public void setFilter(filter filter) {
        this.filter = filter;
    }

    public collection4Mustache getCollection4Mustache() {
        return collection4Mustache;
    }

    public filter getFilter() {
        return filter;
    }
}
