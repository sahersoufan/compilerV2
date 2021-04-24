package AST.Elements.ElementsNodes.CpExpression.model;

import java.util.ArrayList;
import java.util.List;

public class ModelExpression {
    private Collection4Model1 collection4Model1;

    public List<Collection4Model2> getCollection4Model2() {
        return collection4Model2;
    }
    // TODO make this right ! && ||

    public void setCollection4Model2(List<Collection4Model2> collection4Model2) {
        this.collection4Model2 = collection4Model2;
    }

    private List<Collection4Model2> collection4Model2=new ArrayList<>();

    public void setCollection4Model1(Collection4Model1 collection4Model1) {
        this.collection4Model1 = collection4Model1;
    }




    public Collection4Model1 getCollection4Model1() {
        return collection4Model1;
    }



}
