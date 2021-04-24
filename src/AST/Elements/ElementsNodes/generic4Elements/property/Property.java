package AST.Elements.ElementsNodes.generic4Elements.property;

import AST.Elements.ElementsNodes.generic4Elements.array.ArrayCalling;
import AST.Elements.ElementsNodes.generic4Elements.function.FunctionCallFromVar;

import java.util.ArrayList;

public class Property {
    private ArrayList<PropertyValue> propertyValues=new ArrayList<>();
    private ArrayCalling arrayCalling;
    private FunctionCallFromVar functionCallFromVar;

    public ArrayList<PropertyValue> getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(ArrayList<PropertyValue> propertyValues) {
        this.propertyValues = propertyValues;
    }

    public ArrayCalling getArrayCalling() {
        return arrayCalling;
    }

    public void setArrayCalling(ArrayCalling arrayCalling) {
        this.arrayCalling = arrayCalling;
    }

    public FunctionCallFromVar getFunctionCallFromVar() {
        return functionCallFromVar;
    }

    public void setFunctionCallFromVar(FunctionCallFromVar functionCallFromVar) {
        this.functionCallFromVar = functionCallFromVar;
    }
}
