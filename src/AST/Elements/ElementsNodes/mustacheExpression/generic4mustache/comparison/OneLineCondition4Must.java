package AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.comparison;


import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Collection4Mustache;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Collection4LogicRet4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Logic.LogicComprison4Must;

public class OneLineCondition4Must {
    private String openPar;
    private LogicComprison4Must logicComprison4Must;
    private String questionMark;
    private Collection4Mustache collection4Mustache1;
    private Collection4Mustache collection4Mustache2;
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

    public Collection4Mustache getCollection4Mustache1() {
        return collection4Mustache1;
    }

    public void setCollection4Mustache1(Collection4Mustache collection4Mustache1) {
        this.collection4Mustache1 = collection4Mustache1;
    }

    public Collection4Mustache getCollection4Mustache2() {
        return collection4Mustache2;
    }

    public void setCollection4Mustache2(Collection4Mustache collection4Mustache2) {
        this.collection4Mustache2 = collection4Mustache2;
    }

    public String getClosePar() {
        return closePar;
    }

    public void setClosePar(String closePar) {
        this.closePar = closePar;
    }
}
