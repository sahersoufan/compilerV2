package AST.Elements.ElementsNodes.CpExpression.model;

import AST.Elements.ElementsNodes.generic4Elements.array.array;
import AST.Elements.ElementsNodes.generic4Elements.array.objArray;
import AST.Elements.ElementsNodes.generic4Elements.comparison.oneLineArithCondition;
import AST.Elements.ElementsNodes.generic4Elements.comparison.oneLineBoolCondition;
import AST.Elements.ElementsNodes.generic4Elements.function.functionCall;
import AST.Elements.ElementsNodes.generic4Elements.object.subObj;
import AST.Elements.ElementsNodes.generic4Elements.value;
import AST.Elements.ElementsNodes.generic4Elements.variable.variable;

public class collection4Model1 {
    private variable variable;
    private value value;
    private array array;
    private objArray objArray;
    private functionCall functionCall;
    private subObj subObj;
    private oneLineBoolCondition oneLineBoolCondition;
    private oneLineArithCondition oneLineArithCondition;

    public void setVariable(variable variable) {
        this.variable = variable;
    }

    public void setValue(value value) {
        this.value = value;
    }

    public void setArray(array array) {
        this.array = array;
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

    public void setOneLineBoolCondition(oneLineBoolCondition oneLineBoolCondition) {
        this.oneLineBoolCondition = oneLineBoolCondition;
    }

    public void setOneLineArithCondition(oneLineArithCondition oneLineArithCondition) {
        this.oneLineArithCondition = oneLineArithCondition;
    }



    public variable getVariable() {
        return variable;
    }

    public value getValue() {
        return value;
    }

    public array getArray() {
        return array;
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

    public oneLineBoolCondition getOneLineBoolCondition() {
        return oneLineBoolCondition;
    }

    public oneLineArithCondition getOneLineArithCondition() {
        return oneLineArithCondition;
    }


}
