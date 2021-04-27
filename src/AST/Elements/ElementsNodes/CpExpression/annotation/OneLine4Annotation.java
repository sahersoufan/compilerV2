package AST.Elements.ElementsNodes.CpExpression.annotation;

import AST.Elements.ElementsNodes.generic4Elements.comparison.Collection4oneLineCondition;

import java.util.ArrayList;
import java.util.List;

public class OneLine4Annotation {

    private List<Collection4oneLineCondition> collection4oneLineCondition=new ArrayList<>();
    private Collection4Annotation collection4Annotation;

    // TODO make this right ! && ||
    // TODO check this

    public List<Collection4oneLineCondition> getCollection4oneLineCondition() {
        return collection4oneLineCondition;
       // if(a && (!b || c)) //TODO add this to parser, add this to arithmetic

       //
    }

    public void setCollection4oneLineCondition(List<Collection4oneLineCondition> collection4oneLineCondition) {
        this.collection4oneLineCondition = collection4oneLineCondition;
    }

    public void setCollection4Annotation(Collection4Annotation collection4Annotation) {
        this.collection4Annotation = collection4Annotation;
    }

    public Collection4Annotation getCollection4Annotation() {
        return collection4Annotation;
    }


}
