package AST.Elements.ElementsNodes.generic4Elements.function;

public class FunctionCall {
    private FunctionName functionName;
    private FunctionCallFromVar functionCallFromVar;

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
}
