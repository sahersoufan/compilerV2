package AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Logic;

import AST.Elements.ElementsNodes.generic4Elements.Collection4LogicRet;
import AST.Elements.ElementsNodes.generic4Elements.Logic.LogicComprison;
import AST.Elements.ElementsNodes.generic4Elements.Logic.MiddleAndLastLogicComparison;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Collection4LogicRet4Must;

import java.util.ArrayList;
import java.util.List;

public class LogicComprison4Must {
    // first
    //this
    private String NotFirst;
    private Collection4LogicRet4Must collection4LogicRetFirst;
    //or
    private String openParFirst;
    private LogicComprison4Must logicComprisonFirst;
    private String closeParFirst;

    //from here to end are lists
    //middle & last
    private List<MiddleAndLastLogicComparison4Must> middleAndLastLogicComparisons = new ArrayList<>();

    public String getNotFirst() {
        return NotFirst;
    }

    public void setNotFirst(String notFirst) {
        NotFirst = notFirst;
    }

    public Collection4LogicRet4Must getCollection4LogicRetFirst() {
        return collection4LogicRetFirst;
    }

    public void setCollection4LogicRetFirst(Collection4LogicRet4Must collection4LogicRetFirst) {
        this.collection4LogicRetFirst = collection4LogicRetFirst;
    }

    public String getOpenParFirst() {
        return openParFirst;
    }

    public void setOpenParFirst(String openParFirst) {
        this.openParFirst = openParFirst;
    }

    public LogicComprison4Must getLogicComprisonFirst() {
        return logicComprisonFirst;
    }

    public void setLogicComprisonFirst(LogicComprison4Must logicComprisonFirst) {
        this.logicComprisonFirst = logicComprisonFirst;
    }

    public String getCloseParFirst() {
        return closeParFirst;
    }

    public void setCloseParFirst(String closeParFirst) {
        this.closeParFirst = closeParFirst;
    }

    public List<MiddleAndLastLogicComparison4Must> getMiddleAndLastLogicComparisons() {
        return middleAndLastLogicComparisons;
    }

    public void setMiddleAndLastLogicComparisons(List<MiddleAndLastLogicComparison4Must> middleAndLastLogicComparisons) {
        this.middleAndLastLogicComparisons = middleAndLastLogicComparisons;
    }
}
