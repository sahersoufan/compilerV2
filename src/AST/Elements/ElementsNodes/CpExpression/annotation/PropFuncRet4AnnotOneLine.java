package AST.Elements.ElementsNodes.CpExpression.annotation;

import AST.Elements.ElementsNodes.generic4Elements.property.propertyValue;

import java.util.ArrayList;
import java.util.List;

public class PropFuncRet4AnnotOneLine {
    private List<propertyValue> propertyValue=new ArrayList<>();
    private ArrayFuncRet4AnnotOneLine arrayFuncRet4AnnotOneLine;
    private FuncEndRet4AnnotOneLine funcEndRet4AnnotOneLine;



    public void setArrayFuncRet4AnnotOneLine(ArrayFuncRet4AnnotOneLine arrayFuncRet4AnnotOneLine) {
        this.arrayFuncRet4AnnotOneLine = arrayFuncRet4AnnotOneLine;
    }

    public void setFuncEndRet4AnnotOneLine(FuncEndRet4AnnotOneLine funcEndRet4AnnotOneLine) {
        this.funcEndRet4AnnotOneLine = funcEndRet4AnnotOneLine;
    }

    public List<propertyValue> getPropertyValue() {
        return propertyValue;
    }

    public ArrayFuncRet4AnnotOneLine getArrayFuncRet4AnnotOneLine() {
        return arrayFuncRet4AnnotOneLine;
    }

    public FuncEndRet4AnnotOneLine getFuncEndRet4AnnotOneLine() {
        return funcEndRet4AnnotOneLine;
    }


}
