package AST.Elements.ElementsNodes.CpExpression.For;

import AST.Elements.ElementsNodes.generic4Elements.array.Array;
import AST.Elements.ElementsNodes.generic4Elements.array.ObjArray;
import AST.Elements.ElementsNodes.generic4Elements.comparison.OneLineArithCondition;
import AST.Elements.ElementsNodes.generic4Elements.function.FunctionCall;
import AST.Elements.ElementsNodes.generic4Elements.object.SubObj;
import AST.Elements.ElementsNodes.generic4Elements.variable.Variable;

public class collection4For2 {
    private Variable variable;
     private SubObj subObj;
     private ObjArray objArray;
     private Array array;
     private FunctionCall functionCall;
    private OneLineArithCondition oneLineArithCondithion;
    private  oneLine4For2Condition oneLine4For2Condition;

    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    public void setSubObj(SubObj subObj) {
        this.subObj = subObj;
    }

    public void setObjArray(ObjArray objArray) {
        this.objArray = objArray;
    }

    public void setArray(Array array) {
        this.array = array;
    }

    public void setFunctionCall(FunctionCall functionCall) {
        this.functionCall = functionCall;
    }

    public void setOneLine4For2Condition(oneLine4For2Condition oneLine4For2Condition) {
        this.oneLine4For2Condition = oneLine4For2Condition;
    }

    public void setOneLineArithCondithion(OneLineArithCondition oneLineArithCondithion) {
        this.oneLineArithCondithion = oneLineArithCondithion;
    }



    public Variable getVariable() {
        return variable;
    }

    public SubObj getSubObj() {
        return subObj;
    }

    public ObjArray getObjArray() {
        return objArray;
    }

    public Array getArray() {
        return array;
    }

    public FunctionCall getFunctionCall() {
        return functionCall;
    }

    public oneLine4For2Condition getOneLine4For2Condition() {
        return oneLine4For2Condition;
    }

    public OneLineArithCondition getOneLineArithCondithion() {
        return oneLineArithCondithion;
    }


}
