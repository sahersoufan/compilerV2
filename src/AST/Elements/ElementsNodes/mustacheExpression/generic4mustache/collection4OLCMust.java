package AST.Elements.ElementsNodes.mustacheExpression.generic4mustache;


import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.array.objArray4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.comparison.comparisonExp4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.function.functionCall4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.object.subObj4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.var.mustacheVariable;

import java.util.ArrayList;

public class collection4OLCMust {
    private mustacheVariable mustacheVariable;
    private  boolean  MUSTACHE_TRUE;
    private boolean MUSTACHE_FALSE;
    private objArray4Must objArray4Must;
     private functionCall4Must functionCall4Must;
    private subObj4Must subObj4Must;
    private comparisonExp4Must comparisonExp4Must;

    public void setmustacheVariable(mustacheVariable mustacheVariable) {
        this.mustacheVariable = mustacheVariable;
    }
    public void setMUSTACHE_TRUE(boolean MUSTACHE_TRUE) {
        this.MUSTACHE_TRUE = MUSTACHE_TRUE;
    }
    public void setMUSTACHE_FALSE(boolean MUSTACHE_FALSE) {
        this.MUSTACHE_FALSE = MUSTACHE_FALSE;
    }
    public void setobjArray4Must(objArray4Must objArray4Must) {
        this.objArray4Must = objArray4Must;
    }

    public void setfunctionCall4Must(functionCall4Must functionCall4Must) {
        this.functionCall4Must = functionCall4Must;
    }
    public void setsubObj4Must(subObj4Must subObj4Must) {
        this.subObj4Must = subObj4Must;
    }
    public void setcomparisonExp4Must(comparisonExp4Must comparisonExp4Must) {
        this.comparisonExp4Must = comparisonExp4Must;
    }


    public mustacheVariable getmustacheVariable() {
        return mustacheVariable;
    }
    public boolean getMUSTACHE_TRUE() {
        return MUSTACHE_TRUE;
    }
    public boolean getMUSTACHE_FALSE() {
        return MUSTACHE_FALSE;
    }
    public objArray4Must getobjArray4Must() {
        return objArray4Must;
    }
    public functionCall4Must getfunctionCall4Must() {
        return functionCall4Must;
    }
    public subObj4Must getsubObj4Must() {
        return subObj4Must;
    }
    public comparisonExp4Must getcomparisonExp4Must() {
        return comparisonExp4Must;
    }




}
