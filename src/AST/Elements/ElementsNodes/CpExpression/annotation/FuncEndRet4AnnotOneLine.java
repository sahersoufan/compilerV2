package AST.Elements.ElementsNodes.CpExpression.annotation;

import AST.Elements.ElementsNodes.generic4Elements.function.parameters;

public class FuncEndRet4AnnotOneLine {

    private PropFuncRet4AnnotOneLine propFuncRet4AnnotOneLine=new PropFuncRet4AnnotOneLine();
    private parameters functionParameters = new parameters();
    private ArrayFuncRet4AnnotOneLine arrayFuncRet4AnnotOneLine=new ArrayFuncRet4AnnotOneLine();



    public void setFunctionParameters(parameters functionParameters) {
        this.functionParameters = functionParameters;
    }

    public void setArrayFuncRet4AnnotOneLine(ArrayFuncRet4AnnotOneLine arrayFuncRet4AnnotOneLine) {
        this.arrayFuncRet4AnnotOneLine = arrayFuncRet4AnnotOneLine;
    }

    public void setPropFuncRet4AnnotOneLine(PropFuncRet4AnnotOneLine propFuncRet4AnnotOneLine) {
        this.propFuncRet4AnnotOneLine = propFuncRet4AnnotOneLine;
    }

    public parameters getFunctionParameters() {
        return functionParameters;
    }

    public ArrayFuncRet4AnnotOneLine getArrayFuncRet4AnnotOneLine() {
        return arrayFuncRet4AnnotOneLine;
    }

    public PropFuncRet4AnnotOneLine getPropFuncRet4AnnotOneLine() {
        return propFuncRet4AnnotOneLine;
    }





}
