package AST.Elements.ElementsNodes.generic4Elements.function;

import java.util.ArrayList;

public class Parameters {
    private ArrayList<Parameter> parameters = new ArrayList<>();
    private ArrayList<Parameter> internalParameters = new ArrayList<>();

    public ArrayList<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(ArrayList<Parameter> parameters) {
        this.parameters = parameters;
    }

    public ArrayList<Parameter> getInternalParameters() {
        return internalParameters;
    }

    public void setInternalParameters(ArrayList<Parameter> internalParameters) {
        this.internalParameters = internalParameters;
    }
}
