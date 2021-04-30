package AST.Elements.ElementsNodes.generic4Elements.function;

import AST.Elements.ElementsNodes.generic4Elements.array.ArrayCalling;
import AST.Elements.ElementsNodes.generic4Elements.property.Property;

import java.util.ArrayList;

public class FunctionCallFromVar {
    private String openPar;
    private ArrayList<Parameters> parameters = new ArrayList<>();
    private String closePar;
    private ArrayCalling arrayCalling;
    private Property property;


    public String getOpenPar() {
        return openPar;
    }

    public void setOpenPar(String openPar) {
        this.openPar = openPar;
    }

    public String getClosePar() {
        return closePar;
    }

    public void setClosePar(String closePar) {
        this.closePar = closePar;
    }

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
