package AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.function;

import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.array.ArrayCalling4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.property.Property4Must;

import java.util.List;

public class FunctionCallFromVar4Must {
    private String openPar;
    private List<Parameters4Must> parameters4Must;
    private String closePar;
    private ArrayCalling4Must arrayCalling4Must;
    private Property4Must property4Must;

    public List<Parameters4Must> getParameters4Must() {
        return parameters4Must;
    }

    public void setParameters4Must(List<Parameters4Must> parameters4Must) {
        this.parameters4Must = parameters4Must;
    }

    public ArrayCalling4Must getArrayCalling4Must() {
        return arrayCalling4Must;
    }

    public void setArrayCalling4Must(ArrayCalling4Must arrayCalling4Must) {
        this.arrayCalling4Must = arrayCalling4Must;
    }

    public Property4Must getProperty4Must() {
        return property4Must;
    }

    public void setProperty4Must(Property4Must property4Must) {
        this.property4Must = property4Must;
    }

    public String getOpenPar() {
        return openPar;
    }

    public void setOpenPar(String openPar) {
        this.openPar = openPar;
    }

    public String getClosePar() {
        return closePar;
    }

    public void setClosePar(String closePar) {
        this.closePar = closePar;
    }
}
