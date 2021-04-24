package AST.Elements.ElementsNodes.CpExpression.annotation;

import AST.Elements.ElementsNodes.generic4Elements.property.PropertyValue;

import java.util.ArrayList;
import java.util.List;

public class propFuncRet4AnnotOneLine {
    private List<PropertyValue> propertyValue=new ArrayList<>();
    private arrayFuncRet4AnnotOneLine arrayFuncRet4AnnotOneLine;
    private funcEndRet4AnnotOneLine funcEndRet4AnnotOneLine;



    public void setArrayFuncRet4AnnotOneLine(arrayFuncRet4AnnotOneLine arrayFuncRet4AnnotOneLine) {
        this.arrayFuncRet4AnnotOneLine = arrayFuncRet4AnnotOneLine;
    }

    public void setFuncEndRet4AnnotOneLine(funcEndRet4AnnotOneLine funcEndRet4AnnotOneLine) {
        this.funcEndRet4AnnotOneLine = funcEndRet4AnnotOneLine;
    }

    public List<PropertyValue> getPropertyValue() {
        return propertyValue;
    }

    public arrayFuncRet4AnnotOneLine getArrayFuncRet4AnnotOneLine() {
        return arrayFuncRet4AnnotOneLine;
    }

    public funcEndRet4AnnotOneLine getFuncEndRet4AnnotOneLine() {
        return funcEndRet4AnnotOneLine;
    }


}
