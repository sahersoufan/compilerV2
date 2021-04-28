package AST.Elements.ElementsNodes.mustacheExpression.generic4mustache;


import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.array.ObjArray4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.comparison.OneLineCondition4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.function.FunctionCall4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.object.SubObj4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.var.MustacheVariable;

public class Collection4CompMust {
    private MustacheVariable mustacheVariable;

    private MustacheNumber mustacheNumber;
    private String mustachArithmetic ;
    private Collection4MUSTArithmetic Collection4MUSTARITHMETIC;

    private String mustacheString;
    private ObjArray4Must objArray4Must;
    private FunctionCall4Must functionCall4Must;
    private SubObj4Must subObj4Must;
    private OneLineCondition4Must oneLineCondition4Must;

    public MustacheVariable getMustacheVariable() {
        return mustacheVariable;
    }

    public void setMustacheVariable(MustacheVariable mustacheVariable) {
        this.mustacheVariable = mustacheVariable;
    }

    public MustacheNumber getMustacheNumber() {
        return mustacheNumber;
    }

    public void setMustacheNumber(MustacheNumber mustacheNumber) {
        this.mustacheNumber = mustacheNumber;
    }

    public String getMustachArithmetic() {
        return mustachArithmetic;
    }

    public void setMustachArithmetic(String mustachArithmetic) {
        this.mustachArithmetic = mustachArithmetic;
    }

    public Collection4MUSTArithmetic getCollection4MUSTARITHMETIC() {
        return Collection4MUSTARITHMETIC;
    }

    public void setCollection4MUSTARITHMETIC(Collection4MUSTArithmetic collection4MUSTARITHMETIC) {
        Collection4MUSTARITHMETIC = collection4MUSTARITHMETIC;
    }

    public String getMustacheString() {
        return mustacheString;
    }

    public void setMustacheString(String mustacheString) {
        this.mustacheString = mustacheString;
    }

    public ObjArray4Must getObjArray4Must() {
        return objArray4Must;
    }

    public void setObjArray4Must(ObjArray4Must objArray4Must) {
        this.objArray4Must = objArray4Must;
    }

    public FunctionCall4Must getFunctionCall4Must() {
        return functionCall4Must;
    }

    public void setFunctionCall4Must(FunctionCall4Must functionCall4Must) {
        this.functionCall4Must = functionCall4Must;
    }

    public SubObj4Must getSubObj4Must() {
        return subObj4Must;
    }

    public void setSubObj4Must(SubObj4Must subObj4Must) {
        this.subObj4Must = subObj4Must;
    }

    public OneLineCondition4Must getOneLineCondition4Must() {
        return oneLineCondition4Must;
    }

    public void setOneLineCondition4Must(OneLineCondition4Must oneLineCondition4Must) {
        this.oneLineCondition4Must = oneLineCondition4Must;
    }
}
