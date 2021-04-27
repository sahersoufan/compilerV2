package AST.Elements.ElementsNodes.mustacheExpression.generic4mustache;


import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.array.ObjArray4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.comparison.OneLineArithCondithion4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.comparison.OneLineCondition4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.function.FunctionCall4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.object.SubObj4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.value.MustacheValue;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.var.MustacheVariable;

public class Collection4Mustache {
    private MustacheVariable mustacheVariable;
    private MustacheValue mustacheValue;
    private ObjArray4Must objArray4Must;
    private FunctionCall4Must functionCall4Must;
    private SubObj4Must subObj4Must;
    private OneLineCondition4Must oneLineCondition4Must;
    private OneLineArithCondithion4Must oneLineArithCondithion4Must;

    public void setmustacheVariable(MustacheVariable mustacheVariable) {
        this.mustacheVariable = mustacheVariable;
    }

    public void setmustacheValue(MustacheValue mustacheValue) {
        this.mustacheValue = mustacheValue;
    }

    public void setobjArray4Must(ObjArray4Must objArray4Must) {
        this.objArray4Must = objArray4Must;
    }

    public void setFunctionCall(FunctionCall4Must functionCall4Must) {
        this.functionCall4Must = functionCall4Must;
    }

    public void setsubObj4Must(SubObj4Must subObj4Must) {
        this.subObj4Must = subObj4Must;
    }

    public void setoneLineCondition4Must(OneLineCondition4Must oneLineCondition4Must) {
        this.oneLineCondition4Must = oneLineCondition4Must;
    }

    public void setoneLineArithCondithion4Must(OneLineArithCondithion4Must oneLineArithCondithion4Must) {
        this.oneLineArithCondithion4Must = oneLineArithCondithion4Must;
    }


    public MustacheVariable getmustacheVariable() {
        return mustacheVariable;
    }
    public MustacheValue getmustacheValue() {
        return mustacheValue;
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
    public OneLineArithCondithion4Must getoneLineArithCondithion4Must() {
        return oneLineArithCondithion4Must;
    }

}
