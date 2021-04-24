package AST.Elements.ElementsNodes.generic4Elements.function;

import AST.Elements.ElementsNodes.generic4Elements.Collection4ARITHMETIC;

public class FunctionCall {
    private FunctionName functionName;
    private FunctionCallFromVar functionCallFromVar;
    private Collection4ARITHMETIC collection4ARITHMETIC;

    public FunctionName getFunctionName() {
        return functionName;
    }

    public void setFunctionName(FunctionName functionName) {
        this.functionName = functionName;
    }

    public FunctionCallFromVar getFunctionCallFromVar() {
        return functionCallFromVar;
    }

    public void setFunctionCallFromVar(FunctionCallFromVar functionCallFromVar) {
        this.functionCallFromVar = functionCallFromVar;
    }

    public Collection4ARITHMETIC getCollection4ARITHMETIC() {
        return collection4ARITHMETIC;
    }

    public void setCollection4ARITHMETIC(Collection4ARITHMETIC collection4ARITHMETIC) {
        this.collection4ARITHMETIC = collection4ARITHMETIC;
    }
}
