package symTab.symbolsClasses.Elements.ElementsNodes.CpExpression.app;

import org.antlr.symtab.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AppExpression extends LocalScope{
    private Scope scope;
    private String name;
    public AppExpression(Scope enclosingScope, String name) {
        super(enclosingScope);
        this.scope=enclosingScope;
        this.name=name;
    }

    @Override
    public String getName() {
        List<String> l = new ArrayList<>();
        Scope tempScope = scope;
        if (tempScope != null) {

            l.add(tempScope.getName());
        }
        l.add(" - App Scope");
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : l){
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}
