package AST.Elements.ElementsNodes.generic4Elements.function;

import AST.Elements.ElementsNodes.generic4Elements.array.ArrayCalling;
import AST.Elements.ElementsNodes.generic4Elements.property.Property;

import java.util.ArrayList;

public class FunctionCallFromVar {
    private ArrayList<Parameters> parameters = new ArrayList<>();
    private ArrayCalling arrayCalling;
    private Property property;

    public ArrayList<Parameters> getParameters() {
        return parameters;
    }

    public void setParameters(ArrayList<Parameters> parameters) {
        this.parameters = parameters;
    }

    public ArrayCalling getArrayCalling() {
        return arrayCalling;
    }

    public void setArrayCalling(ArrayCalling arrayCalling) {
        this.arrayCalling = arrayCalling;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}
