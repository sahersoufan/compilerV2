package AST.Elements.ElementsNodes.CpExpression.app;

import java.util.ArrayList;
import java.util.List;

public class AppExpression {

    private Collection4App1 collection4App1;
    private List<Collection4App2> collection4App2=new ArrayList<>();
    // TODO make this right ! && ||

    public List<Collection4App2> getCollection4App2() {
        return collection4App2;
    }

    public void setCollection4App2(List<Collection4App2> collection4App2) {
        this.collection4App2 = collection4App2;
    }




    public void setCollection4App1(Collection4App1 collection4App1) {
        this.collection4App1 = collection4App1;
    }

    public Collection4App1 getCollection4App1() {
        return collection4App1;
    }




}
