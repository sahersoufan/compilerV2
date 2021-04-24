package AST.Elements.ElementsNodes.CpExpression.annotation;

import AST.Elements.ElementsNodes.generic4Elements.array.ArrName;
import AST.Elements.ElementsNodes.generic4Elements.object.Obj;

public class collection4Annotation {

    private  functionCall4AnnotOneLine functionCall4AnnotOneLine;
    private ArrName arrName;
    private arrayFuncRet4AnnotOneLine arrayFuncRet4AnnotOneLine;
    private Obj obj;
    private propFuncRet4AnnotOneLine propFuncRet4AnnotOneLine;
    private oneLine4Annotation oneLine4Annotation;

    public void setFunctionCall4AnnotOneLine(functionCall4AnnotOneLine functionCall4AnnotOneLine) {
        this.functionCall4AnnotOneLine = functionCall4AnnotOneLine;
    }

    public void setArrName(ArrName arrName) {
        this.arrName = arrName;
    }

    public void setArrayFuncRet4AnnotOneLine(arrayFuncRet4AnnotOneLine arrayFuncRet4AnnotOneLine) {
        this.arrayFuncRet4AnnotOneLine = arrayFuncRet4AnnotOneLine;
    }

    public void setObj(Obj obj) {
        this.obj = obj;
    }

    public void setPropFuncRet4AnnotOneLine(propFuncRet4AnnotOneLine propFuncRet4AnnotOneLine) {
        this.propFuncRet4AnnotOneLine = propFuncRet4AnnotOneLine;
    }

    public void setOneLine4Annotation(oneLine4Annotation oneLine4Annotation) {
        this.oneLine4Annotation = oneLine4Annotation;
    }



    public functionCall4AnnotOneLine getFunctionCall4AnnotOneLine() {
        return functionCall4AnnotOneLine;
    }

    public ArrName getArrName() {
        return arrName;
    }

    public arrayFuncRet4AnnotOneLine getArrayFuncRet4AnnotOneLine() {
        return arrayFuncRet4AnnotOneLine;
    }

    public Obj getObj() {
        return obj;
    }

    public propFuncRet4AnnotOneLine getPropFuncRet4AnnotOneLine() {
        return propFuncRet4AnnotOneLine;
    }

    public oneLine4Annotation getOneLine4Annotation() {
        return oneLine4Annotation;
    }




}
