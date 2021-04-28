package AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.value;

import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Collection4MUSTArithmetic;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.MustacheNumber;

public class MustacheValue {
    private MustacheNumber mustacheNumber;
    private String mustacheString;
    private Object mustacheNull;
    private Boolean mustacheFalse;
    private Boolean mustacheTrue;


    public void setMUSTACHE_FALSE(Boolean mustacheFalse) {
        this.mustacheFalse = mustacheFalse;
    }
    public void setMUSTACHE_NULL(Object mustacheNull) {
        this.mustacheNull = mustacheNull;
    }
    public void setMUSTACHE_TRUE(Boolean mustacheTrue) {
        this.mustacheTrue = mustacheTrue;
    }

    public void setMustacheString(String mustacheString) {this.mustacheString = mustacheString; }

    public Object getMUSTACHE_NULL() {
        return mustacheNull;
    }
    public Boolean getMUSTACHE_FALSE() {
        return mustacheFalse;
    }
    public Boolean getMUSTACHE_TRUE() {
        return mustacheTrue;
    }


    public String getMustacheString() {
        return mustacheString;
    }

    public MustacheNumber getMustacheNumber() {
        return mustacheNumber;
    }

    public void setMustacheNumber(MustacheNumber mustacheNumber) {
        this.mustacheNumber = mustacheNumber;
    }

    public Object getMustacheNull() {
        return mustacheNull;
    }

    public void setMustacheNull(Object mustacheNull) {
        this.mustacheNull = mustacheNull;
    }

    public Boolean getMustacheFalse() {
        return mustacheFalse;
    }

    public void setMustacheFalse(Boolean mustacheFalse) {
        this.mustacheFalse = mustacheFalse;
    }

    public Boolean getMustacheTrue() {
        return mustacheTrue;
    }

    public void setMustacheTrue(Boolean mustacheTrue) {
        this.mustacheTrue = mustacheTrue;
    }
}
