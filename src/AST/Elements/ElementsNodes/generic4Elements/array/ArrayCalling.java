package AST.Elements.ElementsNodes.generic4Elements.array;

import AST.Elements.ElementsNodes.generic4Elements.Logic.ArithmeticLogic;
import AST.Elements.ElementsNodes.generic4Elements.function.FunctionCallFromVar;
import AST.Elements.ElementsNodes.generic4Elements.property.Property;

import java.util.ArrayList;

public class ArrayCalling {
    private String openBracket;
    private ArrayList<ArithmeticLogic> arithmeticLogics = new ArrayList<>();
    private FunctionCallFromVar functionCallFromVar;
    private Property property;
    private String closeBracket;


    public String getOpenBracket() {
        return openBracket;
    }

    public void setOpenBracket(String openBracket) {
        this.openBracket = openBracket;
    }

    public String getCloseBracket() {
        return closeBracket;
    }

    public void setCloseBracket(String closeBracket) {
        this.closeBracket = closeBracket;
    }

    public ArrayList<ArithmeticLogic> getArithmeticLogics() {
        return arithmeticLogics;
    }

    public void setArithmeticLogics(ArrayList<ArithmeticLogic> arithmeticLogics) {
        this.arithmeticLogics = arithmeticLogics;
    }

    public FunctionCallFromVar getFunctionCallFromVar() {
        return functionCallFromVar;
    }

    public void setFunctionCallFromVar(FunctionCallFromVar functionCallFromVar) {
        this.functionCallFromVar = functionCallFromVar;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}
