package AST.Elements.ElementsNodes.CpExpression.For;

import AST.Elements.ElementsNodes.generic4Elements.array.array;
import AST.Elements.ElementsNodes.generic4Elements.array.objArray;
import AST.Elements.ElementsNodes.generic4Elements.comparison.oneLineArithCondition;
import AST.Elements.ElementsNodes.generic4Elements.function.functionCall;
import AST.Elements.ElementsNodes.generic4Elements.object.subObj;
import AST.Elements.ElementsNodes.generic4Elements.variable.variable;

public class collection4For2 {
    private variable variable;
    private NUmber number;
    //TODO add number ro generic
     private subObj subObj;
     private objArray objArray;
     private array array;
     private functionCall functionCall;
    private oneLineArithCondition oneLineArithCondithion;
    private OneLine4For2Condition oneLine4For2Condition;

    public void setVariable(variable variable) {
        this.variable = variable;
    }

    public void setSubObj(subObj subObj) {
        this.subObj = subObj;
    }

    public void setObjArray(objArray objArray) {
        this.objArray = objArray;
    }

    public void setArray(array array) {
        this.array = array;
    }

    public void setFunctionCall(functionCall functionCall) {
        this.functionCall = functionCall;
    }

    public void setOneLine4For2Condition(OneLine4For2Condition oneLine4For2Condition) {
        this.oneLine4For2Condition = oneLine4For2Condition;
    }

    public void setOneLineArithCondithion(oneLineArithCondition oneLineArithCondithion) {
        this.oneLineArithCondithion = oneLineArithCondithion;
    }



    public variable getVariable() {
        return variable;
    }

    public subObj getSubObj() {
        return subObj;
    }

    public objArray getObjArray() {
        return objArray;
    }

    public array getArray() {
        return array;
    }

    public functionCall getFunctionCall() {
        return functionCall;
    }

    public OneLine4For2Condition getOneLine4For2Condition() {
        return oneLine4For2Condition;
    }

    public oneLineArithCondition getOneLineArithCondithion() {
        return oneLineArithCondithion;
    }

    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }
}
