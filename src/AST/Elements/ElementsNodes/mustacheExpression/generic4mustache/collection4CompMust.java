package AST.Elements.ElementsNodes.mustacheExpression.generic4mustache;


import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.array.objArray4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.comparison.oneLineCondition4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.function.functionCall4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.object.subObj4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.var.mustacheVariable;

import java.util.ArrayList;
import java.util.List;

public class collection4CompMust {
    private mustacheVariable mustacheVariable;
    private int MUSTACHE_NUMBER;
   private List<String> MUSTACHE_STRING=new ArrayList<>();
    private objArray4Must objArray4Must;
    private functionCall4Must functionCall4Must;
    private subObj4Must subObj4Must;
    private oneLineCondition4Must oneLineCondition4Must;

    public void setmustacheVariable(mustacheVariable mustacheVariable) {
        this.mustacheVariable = mustacheVariable;
    }
    public void setMUSTACHE_NUMBER(int MUSTACHE_NUMBER) {
        this.MUSTACHE_NUMBER = MUSTACHE_NUMBER;
    }

    public void setMUSTACHE_STRING(List<String> MUSTACHE_STRING) {
        this.MUSTACHE_STRING = MUSTACHE_STRING;
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

    public void setoneLineCondition4Must(oneLineCondition4Must subOboneLineCondition4Mustj4Must) {
        this.oneLineCondition4Must = oneLineCondition4Must;
    }

    public mustacheVariable getmustacheVariable() {
        return mustacheVariable;
    }

    public int getMUSTACHE_NUMBER() {
        return MUSTACHE_NUMBER;
    }

    public List<String> getMUSTACHE_STRING() {
        return MUSTACHE_STRING;
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
    public oneLineCondition4Must getoneLineCondition4Must() {
        return oneLineCondition4Must;
    }







}
