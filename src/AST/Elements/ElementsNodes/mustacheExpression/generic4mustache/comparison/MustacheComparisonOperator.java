package AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.comparison;

import java.util.ArrayList;
import java.util.List;

public class MustacheComparisonOperator {

    private List<Boolean> operator=new ArrayList<>();

    public List<Boolean> operator() {
        return operator;
    }

    public void booolean(List<Boolean> operator) {
        this.operator = operator;
    }
}
