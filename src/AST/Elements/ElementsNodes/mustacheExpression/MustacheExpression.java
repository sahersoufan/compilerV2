package AST.Elements.ElementsNodes.mustacheExpression;

import AST.Elements.ElementsNodes.mustacheExpression.filter.Filter;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Collection4Mustache;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;
import java.util.List;

public class MustacheExpression {
    List<Pair<Collection4Mustache, Filter>> MustacheContent = new ArrayList<>();

    public List<Pair<Collection4Mustache, Filter>> getMustacheContent() {
        return MustacheContent;
    }

    public void setMustacheContent(List<Pair<Collection4Mustache, Filter>> mustacheContent) {
        MustacheContent = mustacheContent;
    }
}
