package AST.Elements.ElementsNodes.generic4Elements;

import AST.Elements.ElementsNodes.generic4Elements.array.ObjArray;
import AST.Elements.ElementsNodes.generic4Elements.comparison.ComparisonExpression;
import AST.Elements.ElementsNodes.generic4Elements.comparison.OneLineBoolCondition;
import AST.Elements.ElementsNodes.generic4Elements.function.FunctionCall;
import AST.Elements.ElementsNodes.generic4Elements.object.SubObj;
import AST.Elements.ElementsNodes.generic4Elements.variable.Variable;

public class Collection4LogicRet {
    private Variable variable;
    private TrueOrFalse trueOrFalse;
    private ObjArray objArray;
    private FunctionCall functionCall;
    private SubObj subObj;
    private ComparisonExpression comparisonExpression;
    private OneLineBoolCondition oneLineBoolCondition;

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

    public ComparisonExpression getComparisonExpression() {
        return comparisonExpression;
    }

    public void setComparisonExpression(ComparisonExpression comparisonExpression) {
        this.comparisonExpression = comparisonExpression;
    }

    public OneLineBoolCondition getOneLineBoolCondition() {
        return oneLineBoolCondition;
    }

    public void setOneLineBoolCondition(OneLineBoolCondition oneLineBoolCondition) {
        this.oneLineBoolCondition = oneLineBoolCondition;
    }

    public TrueOrFalse getTrueOrFalse() {
        return trueOrFalse;
    }

    public void setTrueOrFalse(TrueOrFalse trueOrFalse) {
        this.trueOrFalse = trueOrFalse;
    }
}
