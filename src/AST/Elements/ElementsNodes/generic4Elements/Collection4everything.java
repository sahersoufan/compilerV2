package AST.Elements.ElementsNodes.generic4Elements;

import AST.Elements.ElementsNodes.generic4Elements.array.Array;
import AST.Elements.ElementsNodes.generic4Elements.array.ObjArray;
import AST.Elements.ElementsNodes.generic4Elements.comparison.OneLineArithCondition;
import AST.Elements.ElementsNodes.generic4Elements.comparison.OneLineArithCondition1;
import AST.Elements.ElementsNodes.generic4Elements.comparison.OneLineCondition;
import AST.Elements.ElementsNodes.generic4Elements.function.FunctionCall;
import AST.Elements.ElementsNodes.generic4Elements.object.SubObj;
import AST.Elements.ElementsNodes.generic4Elements.variable.Variable;

public class Collection4everything {
    private Variable variable;
    private Value value;
    private Array array;
    private ObjArray objArray;
    private FunctionCall functionCall;
    private SubObj subObj;
    private OneLineCondition oneLineCondition;
    private OneLineArithCondition1 oneLineArithCondition1;

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Array getArray() {
        return array;
    }

    public void setArray(Array array) {
        this.array = array;
    }

    public ObjArray getObjArray() {
        return objArray;
    }

    public void setObjArray(ObjArray objArray) {
        this.objArray = objArray;
    }

    public FunctionCall getFunctionCall() {
        return functionCall;
    }

    public void setFunctionCall(FunctionCall functionCall) {
        this.functionCall = functionCall;
    }

    public SubObj getSubObj() {
        return subObj;
    }

    public void setSubObj(SubObj subObj) {
        this.subObj = subObj;
    }

    public OneLineCondition getOneLineCondition() {
        return oneLineCondition;
    }

    public void setOneLineCondition(OneLineCondition oneLineCondition) {
        this.oneLineCondition = oneLineCondition;
    }

    public OneLineArithCondition1 getOneLineArithCondition1() {
        return oneLineArithCondition1;
    }

    public void setOneLineArithCondition1(OneLineArithCondition1 oneLineArithCondition1) {
        this.oneLineArithCondition1 = oneLineArithCondition1;
    }
}
