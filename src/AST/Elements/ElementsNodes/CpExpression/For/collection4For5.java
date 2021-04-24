package AST.Elements.ElementsNodes.CpExpression.For;

import AST.Elements.ElementsNodes.generic4Elements.array.ObjArray;
import AST.Elements.ElementsNodes.generic4Elements.Collection4ARITHMETIC;
import AST.Elements.ElementsNodes.generic4Elements.comparison.ComparisonExpression;
import AST.Elements.ElementsNodes.generic4Elements.comparison.OneLineBoolCondition;
import AST.Elements.ElementsNodes.generic4Elements.function.FunctionCall;
import AST.Elements.ElementsNodes.generic4Elements.object.SubObj;
import AST.Elements.ElementsNodes.generic4Elements.variable.Variable;

public class collection4For5 {
    private Variable variable;
    private Collection4ARITHMETIC collection4ARITHMETIC;
    private ObjArray objArray;
    private FunctionCall functionCall;
    private SubObj subObj;
    private ComparisonExpression comparisonExpression;
    private OneLineBoolCondition oneLineBoolCondition;

    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    public void setCollection4ARITHMETIC(Collection4ARITHMETIC collection4ARITHMETIC) {
        this.collection4ARITHMETIC = collection4ARITHMETIC;
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

    public void setComparisonExpression(ComparisonExpression comparisonExpression) {
        this.comparisonExpression = comparisonExpression;
    }

    public void setOneLineBoolCondition(OneLineBoolCondition oneLineBoolCondition) {
        this.oneLineBoolCondition = oneLineBoolCondition;
    }



    public Variable getVariable() {
        return variable;
    }

    public Collection4ARITHMETIC getCollection4ARITHMETIC() {
        return collection4ARITHMETIC;
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

    public ComparisonExpression getComparisonExpression() {
        return comparisonExpression;
    }

    public OneLineBoolCondition getOneLineBoolCondition() {
        return oneLineBoolCondition;
    }


}
