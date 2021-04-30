package AST.Elements.ElementsNodes.generic4Elements.Logic;

import AST.Elements.ElementsNodes.generic4Elements.Collection4LogicRet;

import java.util.ArrayList;
import java.util.List;

public class LogicComprison {
    // first
    //this
    private String NotFirst;
    private Collection4LogicRet collection4LogicRetFirst;
    //or
    private String openParFirst;
    private LogicComprison logicComprisonFirst;
    private String closeParFirst;

    //from here to end are lists
    //middle & last
    private List<MiddleAndLastLogicComparison> middleAndLastLogicComparisons = new ArrayList<>();

    public String getNotFirst() {
        return NotFirst;
    }

    public void setNotFirst(String notFirst) {
        NotFirst = notFirst;
    }

    public Collection4LogicRet getCollection4LogicRetFirst() {
        return collection4LogicRetFirst;
    }

    public void setCollection4LogicRetFirst(Collection4LogicRet collection4LogicRetFirst) {
        this.collection4LogicRetFirst = collection4LogicRetFirst;
    }

    public String getOpenParFirst() {
        return openParFirst;
    }

    public void setOpenParFirst(String openParFirst) {
        this.openParFirst = openParFirst;
    }

    public LogicComprison getLogicComprisonFirst() {
        return logicComprisonFirst;
    }

    public void setLogicComprisonFirst(LogicComprison logicComprisonFirst) {
        this.logicComprisonFirst = logicComprisonFirst;
    }

    public String getCloseParFirst() {
        return closeParFirst;
    }

    public void setCloseParFirst(String closeParFirst) {
        this.closeParFirst = closeParFirst;
    }

    public List<MiddleAndLastLogicComparison> getMiddleAndLastLogicComparisons() {
        return middleAndLastLogicComparisons;
    }

    public void setMiddleAndLastLogicComparisons(List<MiddleAndLastLogicComparison> middleAndLastLogicComparisons) {
        this.middleAndLastLogicComparisons = middleAndLastLogicComparisons;
    }
}
