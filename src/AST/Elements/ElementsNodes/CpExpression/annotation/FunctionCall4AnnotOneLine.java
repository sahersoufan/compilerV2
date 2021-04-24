package AST.Elements.ElementsNodes.CpExpression.annotation;

import AST.Elements.ElementsNodes.generic4Elements.function.FunctionName;

public class FunctionCall4AnnotOneLine {


    private FunctionName functionName;
    private FuncEndRet4AnnotOneLine funcEndRet4AnnotOneLine ;


    public FuncEndRet4AnnotOneLine getFuncEndRet4AnnotOneLine() {
        return funcEndRet4AnnotOneLine;
    }


    public void setFuncEndRet4AnnotOneLine(FuncEndRet4AnnotOneLine funcEndRet4AnnotOneLine) {
        this.funcEndRet4AnnotOneLine = funcEndRet4AnnotOneLine;
    }

    public FunctionName getFunctionName() {
        return functionName;
    }

    public void setFunctionName(FunctionName functionName) {
        this.functionName = functionName;
    }
}
