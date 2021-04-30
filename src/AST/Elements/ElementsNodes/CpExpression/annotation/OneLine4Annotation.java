package AST.Elements.ElementsNodes.CpExpression.annotation;


import AST.Elements.ElementsNodes.generic4Elements.Logic.LogicComprison;

import java.util.ArrayList;
import java.util.List;

public class OneLine4Annotation {
    private LogicComprison logicComprison;
    private Collection4Annotation collection4Annotation1_1;
    private Collection4Annotation collection4Annotation1_2;


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

    public Collection4Annotation getCollection4Annotation1_1() {
        return collection4Annotation1_1;
    }

    public void setCollection4Annotation1_1(Collection4Annotation collection4Annotation1_1) {
        this.collection4Annotation1_1 = collection4Annotation1_1;
    }

    public Collection4Annotation getCollection4Annotation1_2() {
        return collection4Annotation1_2;
    }

    public void setCollection4Annotation1_2(Collection4Annotation collection4Annotation1_2) {
        this.collection4Annotation1_2 = collection4Annotation1_2;
    }
}
