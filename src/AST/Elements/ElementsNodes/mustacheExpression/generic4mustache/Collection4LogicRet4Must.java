package AST.Elements.ElementsNodes.mustacheExpression.generic4mustache;


import AST.Elements.ElementsNodes.generic4Elements.comparison.OneLineBoolCondition;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.array.ObjArray4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.comparison.ComparisonExp4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.comparison.OneLineBoolCondition4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.function.FunctionCall4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.object.SubObj4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.var.MustacheVariable;

public class Collection4LogicRet4Must {
    private MustacheVariable mustacheVariable;
    private  Boolean  mustacheTrue;
    private Boolean mustacheFalse;
    private ObjArray4Must objArray4Must;
     private FunctionCall4Must functionCall4Must;
    private SubObj4Must subObj4Must;
    private ComparisonExp4Must comparisonExp4Must;
    private OneLineBoolCondition4Must oneLineBoolCondition4Must;


    public MustacheVariable getMustacheVariable() {
        return mustacheVariable;
    }

    public void setMustacheVariable(MustacheVariable mustacheVariable) {
        this.mustacheVariable = mustacheVariable;
    }

    public Boolean getMustacheTrue() {
        return mustacheTrue;
    }

    public void setMustacheTrue(Boolean mustacheTrue) {
        this.mustacheTrue = mustacheTrue;
    }

    public Boolean getMustacheFalse() {
        return mustacheFalse;
    }

    public void setMustacheFalse(Boolean mustacheFalse) {
        this.mustacheFalse = mustacheFalse;
    }

    public ObjArray4Must getObjArray4Must() {
        return objArray4Must;
    }

    public void setObjArray4Must(ObjArray4Must objArray4Must) {
        this.objArray4Must = objArray4Must;
    }

    public FunctionCall4Must getFunctionCall4Must() {
        return functionCall4Must;
    }

    public void setFunctionCall4Must(FunctionCall4Must functionCall4Must) {
        this.functionCall4Must = functionCall4Must;
    }

    public SubObj4Must getSubObj4Must() {
        return subObj4Must;
    }

    public void setSubObj4Must(SubObj4Must subObj4Must) {
        this.subObj4Must = subObj4Must;
    }

    public ComparisonExp4Must getComparisonExp4Must() {
        return comparisonExp4Must;
    }

    public void setComparisonExp4Must(ComparisonExp4Must comparisonExp4Must) {
        this.comparisonExp4Must = comparisonExp4Must;
    }

    public OneLineBoolCondition4Must getOneLineBoolCondition4Must() {
        return oneLineBoolCondition4Must;
    }

    public void setOneLineBoolCondition4Must(OneLineBoolCondition4Must oneLineBoolCondition4Must) {
        this.oneLineBoolCondition4Must = oneLineBoolCondition4Must;
    }
}
