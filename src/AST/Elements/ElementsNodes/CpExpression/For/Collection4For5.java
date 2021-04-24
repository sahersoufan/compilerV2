package AST.Elements.ElementsNodes.CpExpression.For;

import AST.Elements.ElementsNodes.generic4Elements.array.objArray;
import AST.Elements.ElementsNodes.generic4Elements.collection4ARITHMETIC;
import AST.Elements.ElementsNodes.generic4Elements.comparison.comparisonExpression;
import AST.Elements.ElementsNodes.generic4Elements.comparison.oneLineBoolCondition;
import AST.Elements.ElementsNodes.generic4Elements.function.functionCall;
import AST.Elements.ElementsNodes.generic4Elements.object.subObj;
import AST.Elements.ElementsNodes.generic4Elements.variable.variable;

public class Collection4For5 {
    private variable variable;
    private NUmber number;
    private boolean True;
    private boolean False;
    private objArray objArray;
    private functionCall functionCall;
    private subObj subObj;
    private comparisonExpression comparisonExpression;
    private oneLineBoolCondition oneLineBoolCondition;

    public void setVariable(variable variable) {
        this.variable = variable;
    }

    public void setCollection4ARITHMETIC(collection4ARITHMETIC collection4ARITHMETIC) {
        this.collection4ARITHMETIC = collection4ARITHMETIC;
    }

    public void setObjArray(objArray objArray) {
        this.objArray = objArray;
    }

    public void setFunctionCall(functionCall functionCall) {
        this.functionCall = functionCall;
    }

    public void setSubObj(subObj subObj) {
        this.subObj = subObj;
    }

    public void setComparisonExpression(comparisonExpression comparisonExpression) {
        this.comparisonExpression = comparisonExpression;
    }

    public void setOneLineBoolCondition(oneLineBoolCondition oneLineBoolCondition) {
        this.oneLineBoolCondition = oneLineBoolCondition;
    }



    public variable getVariable() {
        return variable;
    }

    public collection4ARITHMETIC getCollection4ARITHMETIC() {
        return collection4ARITHMETIC;
    }

    public objArray getObjArray() {
        return objArray;
    }

    public functionCall getFunctionCall() {
        return functionCall;
    }

    public subObj getSubObj() {
        return subObj;
    }

    public comparisonExpression getComparisonExpression() {
        return comparisonExpression;
    }

    public oneLineBoolCondition getOneLineBoolCondition() {
        return oneLineBoolCondition;
    }

    public NUmber getNumber() {
        return number;
    }

    public void setNumber(NUmber number) {
        this.number = number;
    }

    public boolean isTrue() {
        return True;
    }

    public void setTrue(boolean aTrue) {
        True = aTrue;
    }

    public boolean isFalse() {
        return False;
    }

    public void setFalse(boolean aFalse) {
        False = aFalse;
    }
}
