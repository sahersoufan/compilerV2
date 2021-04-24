package AST.Elements.ElementsNodes.CpExpression.annotation;

import AST.Elements.ElementsNodes.generic4Elements.comparison.collection4oneLineCondition;

import java.util.ArrayList;
import java.util.List;

public class OneLine4Annotation {

    private Collection4Annotation collection4Annotation;
    private List<collection4oneLineCondition > collection4oneLineCondition=new ArrayList<>();

    public List<collection4oneLineCondition> getCollection4oneLineCondition() {
        return collection4oneLineCondition;
    }

    public void setCollection4oneLineCondition(List<collection4oneLineCondition> collection4oneLineCondition) {
        this.collection4oneLineCondition = collection4oneLineCondition;
    }





    public void setCollection4Annotation(Collection4Annotation collection4Annotation) {
        this.collection4Annotation = collection4Annotation;
    }

    public Collection4Annotation getCollection4Annotation() {
        return collection4Annotation;
    }


}
