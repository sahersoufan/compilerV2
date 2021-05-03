package AST.Elements.ElementsNodes.generic4Elements.array;

import AST.Elements.ElementsNodes.generic4Elements.Logic.ArithmeticLogic;
import AST.Elements.ElementsNodes.generic4Elements.function.FunctionCallFromVar;
import AST.Elements.ElementsNodes.generic4Elements.property.Property;

import java.util.ArrayList;
import java.util.List;



public class ArrayCalling {
    private List<OAC> oacs = new ArrayList<>();

    private FunctionCallFromVar functionCallFromVar;
    private Property property;


    public List<OAC> getOacs() {
        return oacs;
    }

    public void setOacs(List<OAC> oacs) {
        this.oacs = oacs;
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
