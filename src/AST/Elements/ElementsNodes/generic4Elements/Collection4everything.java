package AST.Elements.ElementsNodes.generic4Elements;

import AST.Elements.ElementsNodes.generic4Elements.Logic.ArithmeticLogic;
import AST.Elements.ElementsNodes.generic4Elements.Logic.LogicComprison;
import AST.Elements.ElementsNodes.generic4Elements.array.Array;
import AST.Elements.ElementsNodes.generic4Elements.array.ObjArray;
import AST.Elements.ElementsNodes.generic4Elements.comparison.ComparisonExpression;
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
    private ComparisonExpression comparisonExpression;
    private LogicComprison logicComprison;
    private ArithmeticLogic arithmeticLogic;
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

    public ComparisonExpression getComparisonExpression() {
        return comparisonExpression;
    }

    public void setComparisonExpression(ComparisonExpression comparisonExpression) {
        this.comparisonExpression = comparisonExpression;
    }

    public LogicComprison getLogicComprison() {
        return logicComprison;
    }

    public void setLogicComprison(LogicComprison logicComprison) {
        this.logicComprison = logicComprison;
    }

    public ArithmeticLogic getArithmeticLogic() {
        return arithmeticLogic;
    }

    public void setArithmeticLogic(ArithmeticLogic arithmeticLogic) {
        this.arithmeticLogic = arithmeticLogic;
    }
}
