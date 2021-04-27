package AST.Elements.ElementsNodes.mustacheExpression.filter;

import java.util.ArrayList;
import java.util.List;

public class FormatName {
    private List<String> mustachIdentifier = new ArrayList<>();

    public void setMustachIdentifier(List<String> mustachIdentifier) {
        this.mustachIdentifier = mustachIdentifier;
    }

    public List<String> getMustachIdentifier() {
        return mustachIdentifier;
    }
}
