package AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.comparison;

import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Logic.LogicComprison4Must;

public class OneLineBoolCondition4Must {
    private String openPar;
    private LogicComprison4Must logicComprison4Must;
    private String questionMark;
    private boolean first;
    private boolean second;
    private String closePar;

    public String getOpenPar() {
        return openPar;
    }

    public void setOpenPar(String openPar) {
        this.openPar = openPar;
    }

    public LogicComprison4Must getLogicComprison4Must() {
        return logicComprison4Must;
    }

    public void setLogicComprison4Must(LogicComprison4Must logicComprison4Must) {
        this.logicComprison4Must = logicComprison4Must;
    }

    public String getQuestionMark() {
        return questionMark;
    }

    public void setQuestionMark(String questionMark) {
        this.questionMark = questionMark;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public boolean isSecond() {
        return second;
    }

    public void setSecond(boolean second) {
        this.second = second;
    }

    public String getClosePar() {
        return closePar;
    }

    public void setClosePar(String closePar) {
        this.closePar = closePar;
    }
}
