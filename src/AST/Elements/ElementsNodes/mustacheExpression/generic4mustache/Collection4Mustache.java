package AST.Elements.ElementsNodes.mustacheExpression.generic4mustache;


import AST.Elements.ElementsNodes.generic4Elements.Logic.ArithmeticLogic;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Logic.ArithmeticLogic4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.array.ObjArray4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.comparison.OneLineArithCondition4Must;
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
    private OneLineArithCondition4Must oneLineArithCondithion4Must;
    private ArithmeticLogic4Must arithmeticLogic4Must;

    public MustacheVariable getMustacheVariable() {
        return mustacheVariable;
    }

    public void setMustacheVariable(MustacheVariable mustacheVariable) {
        this.mustacheVariable = mustacheVariable;
    }

    public MustacheValue getMustacheValue() {
        return mustacheValue;
    }

    public void setMustacheValue(MustacheValue mustacheValue) {
        this.mustacheValue = mustacheValue;
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

    public OneLineArithCondition4Must getOneLineArithCondithion4Must() {
        return oneLineArithCondithion4Must;
    }

    public void setOneLineArithCondithion4Must(OneLineArithCondition4Must oneLineArithCondithion4Must) {
        this.oneLineArithCondithion4Must = oneLineArithCondithion4Must;
    }

    public ArithmeticLogic4Must getArithmeticLogic4Must() {
        return arithmeticLogic4Must;
    }

    public void setArithmeticLogic4Must(ArithmeticLogic4Must arithmeticLogic4Must) {
        this.arithmeticLogic4Must = arithmeticLogic4Must;
    }
}
