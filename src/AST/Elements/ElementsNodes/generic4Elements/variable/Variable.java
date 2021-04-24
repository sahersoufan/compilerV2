package AST.Elements.ElementsNodes.generic4Elements.variable;

import AST.Elements.ElementsNodes.generic4Elements.Collection4ARITHMETIC;

public class Variable {
    private VariableName variableName;
    private String Arithmetic;
    private Collection4ARITHMETIC collection4ARITHMETIC;


    public VariableName getVariableName() {
        return variableName;
    }

    public void setVariableName(VariableName variableName) {
        this.variableName = variableName;
    }

    public Collection4ARITHMETIC getCollection4ARITHMETIC() {
        return collection4ARITHMETIC;
    }

    public void setCollection4ARITHMETIC(Collection4ARITHMETIC collection4ARITHMETIC) {
        this.collection4ARITHMETIC = collection4ARITHMETIC;
    }

    public String getArithmetic() {
        return Arithmetic;
    }

    public void setArithmetic(String arithmetic) {
        Arithmetic = arithmetic;
    }
}
