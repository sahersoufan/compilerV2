package AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.value;

import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Collection4MUSTARITHMETIC;

import javax.lang.model.type.NullType;
import java.util.ArrayList;
import java.util.List;

public class MustacheValue {
    private int mustacheNumber;
    private String mustacheArithmetic;
    private Collection4MUSTARITHMETIC collection4MUSTARITHMETIC;


    private String mustacheString;
    private Object mustacheNull;
    private Boolean mustacheFalse;
    private Boolean mustacheTrue;

    public void setCollection4MUSTARITHMETIC(Collection4MUSTARITHMETIC collection4MUSTARITHMETIC) {
        this.collection4MUSTARITHMETIC = collection4MUSTARITHMETIC;
    }

    public void setMustacheNumber(int mustacheNumber) {
        this.mustacheNumber = mustacheNumber;
    }

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
    public void setMustacheArithmetic(String mustacheArithmetic) { this.mustacheArithmetic = mustacheArithmetic; }

    public Object getMUSTACHE_NULL() {
        return mustacheNull;
    }
    public Boolean getMUSTACHE_FALSE() {
        return mustacheFalse;
    }
    public Boolean getMUSTACHE_TRUE() {
        return mustacheTrue;
    }
    public int getMustacheNumber() {return mustacheNumber; }

    public String getMustacheArithmetic() {
        return mustacheArithmetic;
    }

    public String getMustacheString() {
        return mustacheString;
    }

    public Collection4MUSTARITHMETIC getCollection4MUSTARITHMETIC() {
        return collection4MUSTARITHMETIC;
    }
}
