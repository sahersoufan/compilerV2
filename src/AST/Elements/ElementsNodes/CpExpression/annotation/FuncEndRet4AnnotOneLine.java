package AST.Elements.ElementsNodes.CpExpression.annotation;

import AST.Elements.ElementsNodes.generic4Elements.function.Parameters;

import java.util.ArrayList;
import java.util.List;

public class FuncEndRet4AnnotOneLine {

    private PropFuncRet4AnnotOneLine propFuncRet4AnnotOneLine;
    private ArrayFuncRet4AnnotOneLine arrayFuncRet4AnnotOneLine;

    private List<Parameters> functionParameters = new ArrayList<>();




    public void setArrayFuncRet4AnnotOneLine(ArrayFuncRet4AnnotOneLine arrayFuncRet4AnnotOneLine) {
        this.arrayFuncRet4AnnotOneLine = arrayFuncRet4AnnotOneLine;
    }

    public void setPropFuncRet4AnnotOneLine(PropFuncRet4AnnotOneLine propFuncRet4AnnotOneLine) {
        this.propFuncRet4AnnotOneLine = propFuncRet4AnnotOneLine;
    }


    public ArrayFuncRet4AnnotOneLine getArrayFuncRet4AnnotOneLine() {
        return arrayFuncRet4AnnotOneLine;
    }

    public PropFuncRet4AnnotOneLine getPropFuncRet4AnnotOneLine() {
        return propFuncRet4AnnotOneLine;
    }


    public List<Parameters> getFunctionParameters() {
        return functionParameters;
    }

    public void setFunctionParameters(List<Parameters> functionParameters) {
        this.functionParameters = functionParameters;
    }
}
