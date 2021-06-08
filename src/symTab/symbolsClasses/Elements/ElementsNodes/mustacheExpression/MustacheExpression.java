package symTab.symbolsClasses.Elements.ElementsNodes.mustacheExpression;

import org.antlr.symtab.LocalScope;
import org.antlr.symtab.Scope;

import java.util.ArrayList;
import java.util.List;

public class MustacheExpression extends LocalScope {
    private Scope scope;
    private String name;
    private boolean IAmInsideYou = true;
    public MustacheExpression (Scope enclosingScope) {
        super(enclosingScope);
        this.scope=enclosingScope;

    }

    @Override
    public String getName() {
        List<String> l = new ArrayList<>();
        Scope tempScope = scope;
        if (tempScope != null) {
            l.add(tempScope.getName());
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : l){
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}
