package AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.value;

import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Collection4MUSTARITHMETIC;

import javax.lang.model.type.NullType;
import java.util.ArrayList;
import java.util.List;

public class MustacheValue {
    private int MUSTAHCE_ARITHMETIC;
    private Collection4MUSTARITHMETIC collection4MUSTARITHMETIC;
    private String mustacheString;
    private Object mustacheNull;
    private boolean mustacheFalse;
    private boolean mustacheTrue;

    public void setCollection4MUSTARITHMETIC(Collection4MUSTARITHMETIC collection4MUSTARITHMETIC) {
        this.collection4MUSTARITHMETIC = collection4MUSTARITHMETIC;
    }

    public void setMUSTAHCE_ARITHMETIC(int MUSTAHCE_ARITHMETIC) {
        this.MUSTAHCE_ARITHMETIC = MUSTAHCE_ARITHMETIC;
    }

    public void setMUSTACHE_FALSE(boolean MUSTACHE_FALSE) {
        this.MUSTACHE_FALSE = MUSTACHE_FALSE;
    }

    public void setMUSTACHE_STRING(List<String> MUSTACHE_STRING) {
        this.MUSTACHE_STRING = MUSTACHE_STRING;
    }

    public void setMUSTACHE_NULL(NullType MUSTACHE_NULL) {
        this.MUSTACHE_NULL = MUSTACHE_NULL;
    }

    public void setMUSTACHE_TRUE(boolean MUSTACHE_TRUE) {
        this.MUSTACHE_TRUE = MUSTACHE_TRUE;
    }

    public List<String> getMUSTACHE_STRING() {
        return MUSTACHE_STRING;
    }

    public NullType getMUSTACHE_NULL() {
        return MUSTACHE_NULL;
    }


    public boolean getMUSTACHE_FALSE() {
        return MUSTACHE_FALSE;
    }

    public boolean getMUSTACHE_TRUE() {
        return MUSTACHE_TRUE;
    }

    public Collection4MUSTARITHMETIC getCollection4MUSTARITHMETIC() {
        return collection4MUSTARITHMETIC;
    }

    public int getMUSTAHCE_ARITHMETIC() {
        return MUSTAHCE_ARITHMETIC;
    }
}
