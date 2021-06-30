package AST.Elements.ElementsNodes.CpExpression.model;


import AST.Elements.ElementsNodes.generic4Elements.array.ObjArray;
import AST.Elements.ElementsNodes.generic4Elements.function.FunctionCall;
import AST.Elements.ElementsNodes.generic4Elements.object.SubObj;
import AST.Elements.ElementsNodes.generic4Elements.variable.Variable;

public class Collection4Model1 {
    private Variable variable;
    private ObjArray objArray;
    private FunctionCall functionCall; // error
    private SubObj subObj;
    private OneLine4ModelCondition oneLine4ModelCondition;


    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
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

    public OneLine4ModelCondition getOneLine4ModelCondition() {
        return oneLine4ModelCondition;
    }

    public void setOneLine4ModelCondition(OneLine4ModelCondition oneLine4ModelCondition) {
        this.oneLine4ModelCondition = oneLine4ModelCondition;
    }
}
