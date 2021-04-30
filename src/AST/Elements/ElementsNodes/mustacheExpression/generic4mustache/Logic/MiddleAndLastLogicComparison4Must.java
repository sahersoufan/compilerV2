package AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Logic;

import AST.Elements.ElementsNodes.generic4Elements.Collection4LogicRet;
import AST.Elements.ElementsNodes.generic4Elements.Logic.LogicComprison;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Collection4LogicRet4Must;

public class MiddleAndLastLogicComparison4Must {
    //this
    private String AndMiddle;
    private String NotAndMiddle;
    //or
    private String OrMiddle;
    private String NotOrMiddle;
    //last
    //this
    private Collection4LogicRet4Must collection4LogicRet;
    //or
    private String openParLast;
    private LogicComprison4Must logicComprisonLast;
    private String closeParLast;

    public String getAndMiddle() {
        return AndMiddle;
    }

    public void setAndMiddle(String andMiddle) {
        AndMiddle = andMiddle;
    }

    public String getNotAndMiddle() {
        return NotAndMiddle;
    }

    public void setNotAndMiddle(String notAndMiddle) {
        NotAndMiddle = notAndMiddle;
    }

    public String getOrMiddle() {
        return OrMiddle;
    }

    public void setOrMiddle(String orMiddle) {
        OrMiddle = orMiddle;
    }

    public String getNotOrMiddle() {
        return NotOrMiddle;
    }

    public void setNotOrMiddle(String notOrMiddle) {
        NotOrMiddle = notOrMiddle;
    }

    public Collection4LogicRet4Must getCollection4LogicRet() {
        return collection4LogicRet;
    }

    public void setCollection4LogicRet(Collection4LogicRet4Must collection4LogicRet) {
        this.collection4LogicRet = collection4LogicRet;
    }

    public String getOpenParLast() {
        return openParLast;
    }

    public void setOpenParLast(String openParLast) {
        this.openParLast = openParLast;
    }

    public LogicComprison4Must getLogicComprisonLast() {
        return logicComprisonLast;
    }

    public void setLogicComprisonLast(LogicComprison4Must logicComprisonLast) {
        this.logicComprisonLast = logicComprisonLast;
    }

    public String getCloseParLast() {
        return closeParLast;
    }

    public void setCloseParLast(String closeParLast) {
        this.closeParLast = closeParLast;
    }
}
