package AST.Elements.ElementsNodes.CpExpression.For;

import AST.Elements.ElementsNodes.generic4Elements.Logic.ArithmeticLogic;
import AST.Elements.ElementsNodes.generic4Elements.NUmber;
import AST.Elements.ElementsNodes.generic4Elements.array.Array;
import AST.Elements.ElementsNodes.generic4Elements.array.ObjArray;
import AST.Elements.ElementsNodes.generic4Elements.function.FunctionCall;
import AST.Elements.ElementsNodes.generic4Elements.object.SubObj;
import AST.Elements.ElementsNodes.generic4Elements.variable.Variable;

public class Collection4For2 {
    private Variable variable;
    private String string;
    private NUmber number;
    private SubObj subObj;
    private ObjArray objArray;
    private Array array;
    private FunctionCall functionCall;
    private OneLine4For2Condition oneLine4For2Condition;
    private ArithmeticLogic arithmeticLogic;

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    public NUmber getNumber() {
        return number;
    }

    public void setNumber(NUmber number) {
        this.number = number;
    }

    public SubObj getSubObj() {
        return subObj;
    }

    public void setSubObj(SubObj subObj) {
        this.subObj = subObj;
    }

    public ObjArray getObjArray() {
        return objArray;
    }

    public void setObjArray(ObjArray objArray) {
        this.objArray = objArray;
    }

    public Array getArray() {
        return array;
    }

    public void setArray(Array array) {
        this.array = array;
    }

    public FunctionCall getFunctionCall() {
        return functionCall;
    }

    public void setFunctionCall(FunctionCall functionCall) {
        this.functionCall = functionCall;
    }

    public OneLine4For2Condition getOneLine4For2Condition() {
        return oneLine4For2Condition;
    }

    public void setOneLine4For2Condition(OneLine4For2Condition oneLine4For2Condition) {
        this.oneLine4For2Condition = oneLine4For2Condition;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public ArithmeticLogic getArithmeticLogic() {
        return arithmeticLogic;
    }

    public void setArithmeticLogic(ArithmeticLogic arithmeticLogic) {
        this.arithmeticLogic = arithmeticLogic;
    }

}
