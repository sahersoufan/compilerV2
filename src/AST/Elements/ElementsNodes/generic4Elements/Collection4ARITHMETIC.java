package AST.Elements.ElementsNodes.generic4Elements;

import AST.Elements.ElementsNodes.generic4Elements.array.ObjArray;
import AST.Elements.ElementsNodes.generic4Elements.comparison.OneLineArithCondition;
import AST.Elements.ElementsNodes.generic4Elements.function.FunctionCall;
import AST.Elements.ElementsNodes.generic4Elements.object.SubObj;
import AST.Elements.ElementsNodes.generic4Elements.variable.Variable;

public class Collection4ARITHMETIC {
    private Variable variable;
    private Collection4ARITHMETIC collection4ARITHMETIC;
    private ObjArray objArray;
    private FunctionCall functionCall;
    private SubObj subObj;
    private OneLineArithCondition oneLineArithCondition;

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    public Collection4ARITHMETIC getCollection4ARITHMETIC() {
        return collection4ARITHMETIC;
    }

    public void setCollection4ARITHMETIC(Collection4ARITHMETIC collection4ARITHMETIC) {
        this.collection4ARITHMETIC = collection4ARITHMETIC;
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

    public OneLineArithCondition getOneLineArithCondition() {
        return oneLineArithCondition;
    }

    public void setOneLineArithCondition(OneLineArithCondition oneLineArithCondition) {
        this.oneLineArithCondition = oneLineArithCondition;
    }
}
