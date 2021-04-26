package AST.Elements.ElementsNodes.mustacheExpression.generic4mustache;


import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.array.ObjArray4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.comparison.OneLineCondition4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.function.FunctionCall4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.object.SubObj4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.var.MustacheVariable;

import java.util.ArrayList;
import java.util.List;

public class Collection4CompMust {
    private MustacheVariable mustacheVariable;
    private int MUSTACHE_NUMBER;
   private List<String> MUSTACHE_STRING=new ArrayList<>();
    private ObjArray4Must objArray4Must;
    private FunctionCall4Must functionCall4Must;
    private SubObj4Must subObj4Must;
    private OneLineCondition4Must oneLineCondition4Must;

    public void setmustacheVariable(MustacheVariable mustacheVariable) {
        this.mustacheVariable = mustacheVariable;
    }
    public void setMUSTACHE_NUMBER(int MUSTACHE_NUMBER) {
        this.MUSTACHE_NUMBER = MUSTACHE_NUMBER;
    }

    public void setMUSTACHE_STRING(List<String> MUSTACHE_STRING) {
        this.MUSTACHE_STRING = MUSTACHE_STRING;
    }

    public void setobjArray4Must(ObjArray4Must objArray4Must) {
        this.objArray4Must = objArray4Must;
    }

    public void setfunctionCall4Must(FunctionCall4Must functionCall4Must) {
        this.functionCall4Must = functionCall4Must;
    }

    public void setsubObj4Must(SubObj4Must subObj4Must) {
        this.subObj4Must = subObj4Must;
    }

    public void setoneLineCondition4Must(OneLineCondition4Must subOboneLineCondition4Mustj4Must) {
        this.oneLineCondition4Must = oneLineCondition4Must;
    }

    public MustacheVariable getmustacheVariable() {
        return mustacheVariable;
    }

    public int getMUSTACHE_NUMBER() {
        return MUSTACHE_NUMBER;
    }

    public List<String> getMUSTACHE_STRING() {
        return MUSTACHE_STRING;
    }

    public ObjArray4Must getobjArray4Must() {
        return objArray4Must;
    }
    public FunctionCall4Must getfunctionCall4Must() {
        return functionCall4Must;
    }
    public SubObj4Must getsubObj4Must() {
        return subObj4Must;
    }
    public OneLineCondition4Must getoneLineCondition4Must() {
        return oneLineCondition4Must;
    }







}
