package AST.Elements.ElementsNodes.mustacheExpression.generic4mustache;

import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.array.ObjArray4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.comparison.OneLineArithCondithion4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.function.FunctionCall4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.object.SubObj4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.var.MustacheVariable;

import java.util.ArrayList;
import java.util.List;

public class Collection4MUSTARITHMETIC {

    private MustacheVariable mustacheVariable;

    private int mustacheNumber;
    private String mustachArithmetic;
    private Collection4MUSTARITHMETIC Collection4MUSTARITHMETIC;

    private ObjArray4Must objArray4Must;
    private FunctionCall4Must functionCall4Must;
    private SubObj4Must subObj4Must;
    private OneLineArithCondithion4Must oneLineArithCondithion4Must;

    public void setMUSTAHCE_ARITHMETIC(String mustachArithmetic) {
        this.mustachArithmetic = mustachArithmetic;
    }

    public void setCollection4MUSTARITHMETIC(Collection4MUSTARITHMETIC Collection4MUSTARITHMETIC) {
        this.Collection4MUSTARITHMETIC = Collection4MUSTARITHMETIC;
    }


    public void setmustacheVariable(MustacheVariable mustacheVariable) {
        this.mustacheVariable = mustacheVariable;
    }

    public void setMUSTACHE_NUMBER(int mustacheNumber) {
        this.mustacheNumber = mustacheNumber;
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


    public void setOneLineArithCondithion4Must(OneLineArithCondithion4Must oneLineArithCondithion4Must) {
        this.oneLineArithCondithion4Must = oneLineArithCondithion4Must;
    }

    public MustacheVariable getmustacheVariable() {
        return mustacheVariable;
    }

    public int getMUSTACHE_NUMBER() {
        return mustacheNumber;
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

    public OneLineArithCondithion4Must getOneLineArithCondithion4Must() {
        return oneLineArithCondithion4Must;
    }

    public AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Collection4MUSTARITHMETIC getCollection4MUSTARITHMETIC() {
        return Collection4MUSTARITHMETIC;
    }

    public String getMustachArithmetic() {
        return mustachArithmetic;
    }
}
