package symTab.symbolsClasses.Elements.ElementsNodes.CpExpression.For;

import org.antlr.symtab.LocalScope;
import org.antlr.symtab.Scope;
import org.antlr.symtab.Symbol;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ForExpression extends LocalScope {
    private Scope scope;
    private String name;

    public ForExpression(Scope enclosingScope , String name) {
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
//            tempScope = tempScope.getEnclosingScope();
        }
        l.add(" - For Scope");
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : l){
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}
