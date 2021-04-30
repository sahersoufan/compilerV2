package AST.Elements.ElementsNodes.CpExpression.annotation;

import AST.Elements.ElementsNodes.generic4Elements.Logic.ArithmeticLogic;

import java.util.ArrayList;
import java.util.List;

public class ArrayFuncRet4AnnotOneLine {
    private String openBracket;
    private List<ArithmeticLogic> arithmeticLogics=new ArrayList<>();
    private String closeBracket;


    private PropFuncRet4AnnotOneLine propFuncRet4AnnotOneLine;
    private FuncEndRet4AnnotOneLine funcEndRet4AnnotOneLine;


    public String getOpenBracket() {
        return openBracket;
    }

    public void setOpenBracket(String openBracket) {
        this.openBracket = openBracket;
    }

    public String getCloseBracket() {
        return closeBracket;
    }

    public void setCloseBracket(String closeBracket) {
        this.closeBracket = closeBracket;
    }

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

    public List<ArithmeticLogic> getArithmeticLogics() {
        return arithmeticLogics;
    }

    public void setArithmeticLogics(List<ArithmeticLogic> arithmeticLogics) {
        this.arithmeticLogics = arithmeticLogics;
    }
}
