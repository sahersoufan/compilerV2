package AST.Elements.ElementsNodes.generic4Elements.array;

import AST.Elements.ElementsNodes.generic4Elements.Collection4ARITHMETIC;
import AST.Elements.ElementsNodes.generic4Elements.function.FunctionCallFromVar;
import AST.Elements.ElementsNodes.generic4Elements.property.Property;

import java.util.ArrayList;

public class ArrayCalling {
    private ArrayList<Collection4ARITHMETIC> collection4ARITHMETICArrayList = new ArrayList<>();
    private FunctionCallFromVar functionCallFromVar;
    private Property property;

    public ArrayList<Collection4ARITHMETIC> getCollection4ARITHMETICArrayList() {
        return collection4ARITHMETICArrayList;
    }

    public void setCollection4ARITHMETICArrayList(ArrayList<Collection4ARITHMETIC> collection4ARITHMETICArrayList) {
        this.collection4ARITHMETICArrayList = collection4ARITHMETICArrayList;
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
