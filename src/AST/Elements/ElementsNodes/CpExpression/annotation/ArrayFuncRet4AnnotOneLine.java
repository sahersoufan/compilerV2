package AST.Elements.ElementsNodes.CpExpression.annotation;

import AST.Elements.ElementsNodes.generic4Elements.Collection4ARITHMETIC;

import java.util.ArrayList;
import java.util.List;

public class ArrayFuncRet4AnnotOneLine {

    private List<Collection4ARITHMETIC> collection4ARITHMETIC=new ArrayList<>();
    private PropFuncRet4AnnotOneLine propFuncRet4AnnotOneLine;
    private FuncEndRet4AnnotOneLine funcEndRet4AnnotOneLine;




    public void setPropFuncRet4AnnotOneLine(PropFuncRet4AnnotOneLine propFuncRet4AnnotOneLine) {
        this.propFuncRet4AnnotOneLine = propFuncRet4AnnotOneLine;
    }

    public void setFuncEndRet4AnnotOneLine(FuncEndRet4AnnotOneLine funcEndRet4AnnotOneLine) {
        this.funcEndRet4AnnotOneLine = funcEndRet4AnnotOneLine;
    }


    public PropFuncRet4AnnotOneLine getPropFuncRet4AnnotOneLine() {
        return propFuncRet4AnnotOneLine;
    }

    public FuncEndRet4AnnotOneLine getFuncEndRet4AnnotOneLine() {
        return funcEndRet4AnnotOneLine;
    }

    public List<Collection4ARITHMETIC> getCollection4ARITHMETIC() {
        return collection4ARITHMETIC;
    }

    public void setCollection4ARITHMETIC(List<Collection4ARITHMETIC> collection4ARITHMETIC) {
        this.collection4ARITHMETIC = collection4ARITHMETIC;
    }
}
