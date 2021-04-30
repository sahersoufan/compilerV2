package AST.Elements.ElementsNodes.generic4Elements.comparison;

import AST.Elements.ElementsNodes.generic4Elements.Collection4everything;
import AST.Elements.ElementsNodes.generic4Elements.Logic.LogicComprison;

import java.util.ArrayList;

public class OneLineCondition {
    private LogicComprison logicComprison;
    private Collection4everything collection4everything1;
    private Collection4everything collection4everything2;

    private String openPar;
    private String questionMark;
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

    public Collection4everything getCollection4everything1() {
        return collection4everything1;
    }

    public void setCollection4everything1(Collection4everything collection4everything1) {
        this.collection4everything1 = collection4everything1;
    }

    public Collection4everything getCollection4everything2() {
        return collection4everything2;
    }

    public void setCollection4everything2(Collection4everything collection4everything2) {
        this.collection4everything2 = collection4everything2;
    }
}
