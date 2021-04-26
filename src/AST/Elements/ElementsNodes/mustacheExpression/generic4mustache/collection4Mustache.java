package AST.Elements.ElementsNodes.mustacheExpression.generic4mustache;


import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.array.objArray4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.comparison.oneLineArithCondithion4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.comparison.oneLineCondition4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.function.functionCall4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.object.subObj4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.value.mustacheValue;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.var.mustacheVariable;

public class collection4Mustache {
    private mustacheVariable mustacheVariable;
    private mustacheValue mustacheValue;
    private objArray4Must objArray4Must;
    private functionCall4Must functionCall4Must;
    private subObj4Must subObj4Must;
    private oneLineCondition4Must oneLineCondition4Must;
    private oneLineArithCondithion4Must oneLineArithCondithion4Must;

    public void setmustacheVariable(mustacheVariable mustacheVariable) {
        this.mustacheVariable = mustacheVariable;
    }

    public void setmustacheValue(mustacheValue mustacheValue) {
        this.mustacheValue = mustacheValue;
    }

    public void setobjArray4Must(objArray4Must objArray4Must) {
        this.objArray4Must = objArray4Must;
    }

    public void setFunctionCall(functionCall4Must functionCall4Must) {
        this.functionCall4Must = functionCall4Must;
    }

    public void setsubObj4Must(subObj4Must subObj4Must) {
        this.subObj4Must = subObj4Must;
    }

    public void setoneLineCondition4Must(oneLineCondition4Must oneLineCondition4Must) {
        this.oneLineCondition4Must = oneLineCondition4Must;
    }

    public void setoneLineArithCondithion4Must(oneLineArithCondithion4Must oneLineArithCondithion4Must) {
        this.oneLineArithCondithion4Must = oneLineArithCondithion4Must;
    }


    public mustacheVariable getmustacheVariable() {
        return mustacheVariable;
    }
    public mustacheValue getmustacheValue() {
        return mustacheValue;
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
    public oneLineArithCondithion4Must getoneLineArithCondithion4Must() {
        return oneLineArithCondithion4Must;
    }

}
