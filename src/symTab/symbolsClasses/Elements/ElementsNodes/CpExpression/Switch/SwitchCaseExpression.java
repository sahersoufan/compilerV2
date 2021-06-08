package symTab.symbolsClasses.Elements.ElementsNodes.CpExpression.Switch;

import org.antlr.symtab.LocalScope;
import org.antlr.symtab.Scope;
import org.antlr.symtab.Symbol;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SwitchCaseExpression extends LocalScope {

    private Scope scope;
    private String name;


    public SwitchCaseExpression(Scope enclosingScope , String name) {
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
        l.add(" - CASE Scope");
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : l){
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}
