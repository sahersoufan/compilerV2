package AST.Elements.ElementsNodes.CpExpression.app;

import AST.Elements.ElementsNodes.generic4Elements.array.ObjArray;
import AST.Elements.ElementsNodes.generic4Elements.function.FunctionCall;
import AST.Elements.ElementsNodes.generic4Elements.object.SubObj;
import AST.Elements.ElementsNodes.generic4Elements.variable.Variable;

public class Collection4App1 {
    private Variable variable;
    private ObjArray objArray;
    private FunctionCall functionCall;
    private SubObj subObj;
    private OneLine4AppCondition oneLine4AppCondition;

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

    public OneLine4AppCondition getOneLine4AppCondition() {
        return oneLine4AppCondition;
    }

    public void setOneLine4AppCondition(OneLine4AppCondition oneLine4AppCondition) {
        this.oneLine4AppCondition = oneLine4AppCondition;
    }
}
