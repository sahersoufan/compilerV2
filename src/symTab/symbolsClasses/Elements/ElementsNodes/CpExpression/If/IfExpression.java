package symTab.symbolsClasses.Elements.ElementsNodes.CpExpression.If;

import org.antlr.symtab.LocalScope;
import org.antlr.symtab.Scope;

import java.util.ArrayList;
import java.util.List;

public class IfExpression extends LocalScope {
    private Scope scope;
    private String name;
    public IfExpression(Scope enclosingScope, String name) {
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
            tempScope = tempScope.getEnclosingScope();
        }
        l.add(" - IF Scope");
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : l){
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}