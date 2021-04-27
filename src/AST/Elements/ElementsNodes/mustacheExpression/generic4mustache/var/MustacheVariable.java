package AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.var;

import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Collection4MUSTARITHMETIC;

import java.util.ArrayList;
import java.util.List;


public class MustacheVariable {


    private String mustacheVariable;

    private String mustachArithmetic;
    private Collection4MUSTARITHMETIC Collection4MUSTARITHMETIC;

    public void setCollection4MUSTARITHMETIC(Collection4MUSTARITHMETIC collection4MUSTARITHMETIC) {
        Collection4MUSTARITHMETIC = collection4MUSTARITHMETIC;
    }

    public void setMustachArithmetic(String mustachArithmetic) {
        this.mustachArithmetic = mustachArithmetic;
    }

    public Collection4MUSTARITHMETIC getCollection4MUSTARITHMETIC() {
        return Collection4MUSTARITHMETIC;
    }

    public String getMustachArithmetic() {
        return mustachArithmetic;
    }

    public String getMustacheVariable() {
        return mustacheVariable;
    }

    public void setMustacheVariable(String mustacheVariable) {
        this.mustacheVariable = mustacheVariable;
    }
}
