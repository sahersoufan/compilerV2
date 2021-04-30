package AST.Elements.ElementsNodes.generic4Elements.comparison;

import AST.Elements.ElementsNodes.generic4Elements.Logic.ArithmeticLogic;
import AST.Elements.ElementsNodes.generic4Elements.Logic.LogicComprison;

public class OneLineArithCondition {
    private String openPar;
    private LogicComprison logicComprison;
    private String questionMark;
    private ArithmeticLogic arithmeticLogic1;
    private ArithmeticLogic arithmeticLogic2;
    private String closePar;

    public String getOpenPar() {
        return openPar;
    }

    public void setOpenPar(String openPar) {
        this.openPar = openPar;
    }

    public String getQuestionMark() {
        return questionMark;
    }

    public void setQuestionMark(String questionMark) {
        this.questionMark = questionMark;
    }

    public String getClosePar() {
        return closePar;
    }

    public void setClosePar(String closePar) {
        this.closePar = closePar;
    }

    public LogicComprison getLogicComprison() {
        return logicComprison;
    }

    public void setLogicComprison(LogicComprison logicComprison) {
        this.logicComprison = logicComprison;
    }

    public ArithmeticLogic getArithmeticLogic1() {
        return arithmeticLogic1;
    }

    public void setArithmeticLogic1(ArithmeticLogic arithmeticLogic1) {
        this.arithmeticLogic1 = arithmeticLogic1;
    }

    public ArithmeticLogic getArithmeticLogic2() {
        return arithmeticLogic2;
    }

    public void setArithmeticLogic2(ArithmeticLogic arithmeticLogic2) {
        this.arithmeticLogic2 = arithmeticLogic2;
    }
}
