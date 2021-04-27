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

    private int mustacheNumber;
    private String mustachArithmetic ;
    private  Collection4MUSTARITHMETIC Collection4MUSTARITHMETIC;

    private String mustacheString;
    private ObjArray4Must objArray4Must;
    private FunctionCall4Must functionCall4Must;
    private SubObj4Must subObj4Must;
    private OneLineCondition4Must oneLineCondition4Must;

    public void setmustacheVariable(MustacheVariable mustacheVariable) {
        this.mustacheVariable = mustacheVariable;
    }
    public void setMUSTACHE_NUMBER(int mustacheNumber) {
        this.mustacheNumber = mustacheNumber;
    }

    public void setMUSTAHCE_ARITHMETIC(String mustachArithmetic) {
        this.mustachArithmetic = mustachArithmetic;
    }

    public void setCollection4MUSTARITHMETIC(Collection4MUSTARITHMETIC Collection4MUSTARITHMETIC) {
        this.Collection4MUSTARITHMETIC = Collection4MUSTARITHMETIC;
    }

    public void setMustacheString(String mustacheString) {
        this.mustacheString = mustacheString;
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

    public AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Collection4MUSTARITHMETIC getCollection4MUSTARITHMETIC() {
        return Collection4MUSTARITHMETIC;
    }

    public MustacheVariable getmustacheVariable() {
        return mustacheVariable;
    }
    public int getMUSTACHE_NUMBER() {
        return mustacheNumber;
    }

    public String getMustachArithmetic() { return mustachArithmetic; }

    public String getMUSTACHE_STRING() {return mustacheString; }
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
