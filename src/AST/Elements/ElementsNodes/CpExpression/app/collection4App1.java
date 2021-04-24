package AST.Elements.ElementsNodes.CpExpression.app;

import AST.Elements.ElementsNodes.generic4Elements.array.Array;
import AST.Elements.ElementsNodes.generic4Elements.array.ObjArray;
import AST.Elements.ElementsNodes.generic4Elements.comparison.OneLineArithCondition;
import AST.Elements.ElementsNodes.generic4Elements.comparison.OneLineBoolCondition;
import AST.Elements.ElementsNodes.generic4Elements.function.FunctionCall;
import AST.Elements.ElementsNodes.generic4Elements.object.SubObj;
import AST.Elements.ElementsNodes.generic4Elements.Value;
import AST.Elements.ElementsNodes.generic4Elements.variable.Variable;

public class collection4App1 {
    private Variable variable;
    private Value value;
    private Array array;
    private ObjArray objArray;
    private FunctionCall functionCall;
    private SubObj subObj;
    private OneLineBoolCondition oneLineBoolCondition;
    private OneLineArithCondition oneLineArithCondition;

    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public void setArray(Array array) {
        this.array = array;
    }

    public void setObjArray(ObjArray objArray) {
        this.objArray = objArray;
    }

    public void setFunctionCall(FunctionCall functionCall) {
        this.functionCall = functionCall;
    }

    public void setSubObj(SubObj subObj) {
        this.subObj = subObj;
    }

    public void setOneLineBoolCondition(OneLineBoolCondition oneLineBoolCondition) {
        this.oneLineBoolCondition = oneLineBoolCondition;
    }

    public void setOneLineArithCondition(OneLineArithCondition oneLineArithCondition) {
        this.oneLineArithCondition = oneLineArithCondition;
    }



    public Variable getVariable() {
        return variable;
    }

    public Value getValue() {
        return value;
    }

    public Array getArray() {
        return array;
    }

    public ObjArray getObjArray() {
        return objArray;
    }

    public FunctionCall getFunctionCall() {
        return functionCall;
    }

    public SubObj getSubObj() {
        return subObj;
    }

    public OneLineBoolCondition getOneLineBoolCondition() {
        return oneLineBoolCondition;
    }

    public OneLineArithCondition getOneLineArithCondition() {
        return oneLineArithCondition;
    }


}
