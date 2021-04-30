package AST.Elements.ElementsNodes.mustacheExpression.generic4mustache;


import AST.Elements.ElementsNodes.generic4Elements.Logic.ArithmeticLogic;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Logic.ArithmeticLogic4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.array.ObjArray4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.comparison.OneLineCondition4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.function.FunctionCall4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.object.SubObj4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.var.MustacheVariable;

public class Collection4CompMust {
    private ArithmeticLogic4Must arithmeticLogic4Must;

    public ArithmeticLogic4Must getArithmeticLogic4Must() {
        return arithmeticLogic4Must;
    }

    public void setArithmeticLogic4Must(ArithmeticLogic4Must arithmeticLogic4Must) {
        this.arithmeticLogic4Must = arithmeticLogic4Must;
    }
}
