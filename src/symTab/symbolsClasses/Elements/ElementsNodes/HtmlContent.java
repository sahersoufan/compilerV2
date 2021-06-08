package symTab.symbolsClasses.Elements.ElementsNodes;


import org.antlr.symtab.Scope;
import org.antlr.symtab.Symbol;

import java.util.List;
import java.util.Set;

public class HtmlContent implements Scope, Symbol {
    private Scope scope;


    @Override
    public String getName() {
        return null;
    }

    @Override
    public Scope getScope() {
        return scope;
    }

    @Override
    public void setScope(Scope scope) {
this.scope=scope;
    }

    @Override
    public int getInsertionOrderNumber() {
        return 0;
    }

    @Override
    public void setInsertionOrderNumber(int i) {

    }

    @Override
    public Scope getEnclosingScope() {
        return scope;
    }

    @Override
    public void setEnclosingScope(Scope scope) {

    }

    @Override
    public void define(Symbol symbol) throws IllegalArgumentException {

    }

    @Override
    public Symbol resolve(String s) {
        return null;
    }

    @Override
    public Symbol getSymbol(String s) {
        return null;
    }

    @Override
    public void nest(Scope scope) throws IllegalArgumentException {

    }

    @Override
    public List<Scope> getNestedScopes() {
        return null;
    }

    @Override
    public List<Scope> getEnclosingPathToRoot() {
        return null;
    }

    @Override
    public List<Scope> getNestedScopedSymbols() {
        return null;
    }

    @Override
    public List<? extends Symbol> getSymbols() {
        return null;
    }

    @Override
    public List<? extends Symbol> getAllSymbols() {
        return null;
    }

    @Override
    public Set<String> getSymbolNames() {
        return null;
    }

    @Override
    public int getNumberOfSymbols() {
        return 0;
    }

    @Override
    public String toQualifierString(String s) {
        return null;
    }
}
