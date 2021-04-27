package AST.Elements.ElementsNodes.mustacheExpression.filter;

import java.util.ArrayList;
import java.util.List;

public class ModelName {
    private List<String> mustachIdentifier = new ArrayList<>();

    public List<String> getMustachIdentifier() {
        return mustachIdentifier;
    }

    public void setMustachIdentifier(List<String> mustachIdentifier) {
        this.mustachIdentifier = mustachIdentifier;
    }
}


