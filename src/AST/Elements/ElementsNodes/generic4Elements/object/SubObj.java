package AST.Elements.ElementsNodes.generic4Elements.object;

import AST.Elements.ElementsNodes.generic4Elements.Collection4ARITHMETIC;
import AST.Elements.ElementsNodes.generic4Elements.property.Property;

public class SubObj {
    private String identifier;
    private Property property;
    private Collection4ARITHMETIC collection4ARITHMETIC;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Collection4ARITHMETIC getCollection4ARITHMETIC() {
        return collection4ARITHMETIC;
    }

    public void setCollection4ARITHMETIC(Collection4ARITHMETIC collection4ARITHMETIC) {
        this.collection4ARITHMETIC = collection4ARITHMETIC;
    }
}
