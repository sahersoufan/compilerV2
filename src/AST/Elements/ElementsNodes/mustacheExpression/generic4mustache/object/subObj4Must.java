package AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.object;

import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.collection4MUSTARITHMETIC;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.property.property4Must;

import java.util.ArrayList;
import java.util.List;

public class subObj4Must {
    private List<String> subName=new ArrayList<>();
    private property4Must property4Must;
    private String Arithmetic;
    private collection4MUSTARITHMETIC collection4MUSTARITHMETIC;

    public List<String> getSubName() {
        return subName;
    }

    public void setSubName(List<String> subName) {
        this.subName = subName;
    }

    public AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.property.property4Must getProperty4Must() {
        return property4Must;
    }

    public void setProperty4Must(AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.property.property4Must property4Must) {
        this.property4Must = property4Must;
    }

    public String getArithmetic() {
        return Arithmetic;
    }

    public void setArithmetic(String arithmetic) {
        Arithmetic = arithmetic;
    }

    public AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.collection4MUSTARITHMETIC getCollection4MUSTARITHMETIC() {
        return collection4MUSTARITHMETIC;
    }

    public void setCollection4MUSTARITHMETIC(AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.collection4MUSTARITHMETIC collection4MUSTARITHMETIC) {
        this.collection4MUSTARITHMETIC = collection4MUSTARITHMETIC;
    }
}
