package AST.Elements.ElementsNodes.generic4Elements.object;

import AST.Elements.ElementsNodes.generic4Elements.property.Property;

public class SubObj {
    private String identifier;
    private Property property;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String objName) {
        this.identifier = objName;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}
