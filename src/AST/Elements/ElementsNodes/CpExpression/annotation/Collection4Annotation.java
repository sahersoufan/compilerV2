package AST.Elements.ElementsNodes.CpExpression.annotation;

import AST.Elements.ElementsNodes.generic4Elements.array.ArrName;
import AST.Elements.ElementsNodes.generic4Elements.object.Obj;

public class Collection4Annotation {

    private FunctionCall4AnnotOneLine functionCall4AnnotOneLine;

    private ArrName arrName;
    private ArrayFuncRet4AnnotOneLine arrayFuncRet4AnnotOneLine;

    private Obj obj;
    private PropFuncRet4AnnotOneLine propFuncRet4AnnotOneLine;

    private OneLine4Annotation oneLine4Annotation;

    public void setFunctionCall4AnnotOneLine(FunctionCall4AnnotOneLine functionCall4AnnotOneLine) {
        this.functionCall4AnnotOneLine = functionCall4AnnotOneLine;
    }


    public void setArrayFuncRet4AnnotOneLine(ArrayFuncRet4AnnotOneLine arrayFuncRet4AnnotOneLine) {
        this.arrayFuncRet4AnnotOneLine = arrayFuncRet4AnnotOneLine;
    }


    public void setPropFuncRet4AnnotOneLine(PropFuncRet4AnnotOneLine propFuncRet4AnnotOneLine) {
        this.propFuncRet4AnnotOneLine = propFuncRet4AnnotOneLine;
    }

    public void setOneLine4Annotation(OneLine4Annotation oneLine4Annotation) {
        this.oneLine4Annotation = oneLine4Annotation;
    }



    public FunctionCall4AnnotOneLine getFunctionCall4AnnotOneLine() {
        return functionCall4AnnotOneLine;
    }


    public ArrayFuncRet4AnnotOneLine getArrayFuncRet4AnnotOneLine() {
        return arrayFuncRet4AnnotOneLine;
    }


    public PropFuncRet4AnnotOneLine getPropFuncRet4AnnotOneLine() {
        return propFuncRet4AnnotOneLine;
    }

    public OneLine4Annotation getOneLine4Annotation() {
        return oneLine4Annotation;
    }


    public ArrName getArrName() {
        return arrName;
    }

    public void setArrName(ArrName arrName) {
        this.arrName = arrName;
    }

    public Obj getObj() {
        return obj;
    }

    public void setObj(Obj obj) {
        this.obj = obj;
    }
}
