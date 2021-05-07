package AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.array;

import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Collection4MUSTArithmetic;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Logic.ArithmeticLogic4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.function.FunctionCallFromVar4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.property.Property4Must;

import java.util.ArrayList;
import java.util.List;

public class ArrayCalling4Must {
    private String openBracket;
    private List<ArithmeticLogic4Must> arithmeticLogic4Must = new ArrayList<>();
    private String closeBracket;
    private FunctionCallFromVar4Must functionCallFromVar4Must;
    private Property4Must property4Must;

    public String getOpenBracket() {
        return openBracket;
    }

    public void setOpenBracket(String openBracket) {
        this.openBracket = openBracket;
    }

    public List<ArithmeticLogic4Must> getArithmeticLogic4Must() {
        return arithmeticLogic4Must;
    }

    public void setArithmeticLogic4Must(List<ArithmeticLogic4Must> arithmeticLogic4Must) {
        this.arithmeticLogic4Must = arithmeticLogic4Must;
    }

    public String getCloseBracket() {
        return closeBracket;
    }

    public void setCloseBracket(String closeBracket) {
        this.closeBracket = closeBracket;
    }

    public FunctionCallFromVar4Must getFunctionCallFromVar4Must() {
        return functionCallFromVar4Must;
    }

    public void setFunctionCallFromVar4Must(FunctionCallFromVar4Must functionCallFromVar4Must) {
        this.functionCallFromVar4Must = functionCallFromVar4Must;
    }

    public Property4Must getProperty4Must() {
        return property4Must;
    }

    public void setProperty4Must(Property4Must property4Must) {
        this.property4Must = property4Must;
    }
}
