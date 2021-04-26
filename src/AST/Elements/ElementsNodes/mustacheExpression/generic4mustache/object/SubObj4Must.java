package AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.object;

import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Collection4MUSTARITHMETIC;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.property.Property4Must;

import java.util.ArrayList;
import java.util.List;

public class SubObj4Must {
    private List<String> subName=new ArrayList<>();
    private Property4Must property4Must;
    private String Arithmetic;
    private Collection4MUSTARITHMETIC collection4MUSTARITHMETIC;

    public List<String> getSubName() {
        return subName;
    }

    public void setSubName(List<String> subName) {
        this.subName = subName;
    }

    public Property4Must getProperty4Must() {
        return property4Must;
    }

    public void setProperty4Must(Property4Must property4Must) {
        this.property4Must = property4Must;
    }

    public String getArithmetic() {
        return Arithmetic;
    }

    public void setArithmetic(String arithmetic) {
        Arithmetic = arithmetic;
    }

    public Collection4MUSTARITHMETIC getCollection4MUSTARITHMETIC() {
        return collection4MUSTARITHMETIC;
    }

    public void setCollection4MUSTARITHMETIC(Collection4MUSTARITHMETIC collection4MUSTARITHMETIC) {
        this.collection4MUSTARITHMETIC = collection4MUSTARITHMETIC;
    }
}
