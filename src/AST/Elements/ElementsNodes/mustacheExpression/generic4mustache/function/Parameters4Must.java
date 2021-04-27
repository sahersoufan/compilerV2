package AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.function;

import java.util.ArrayList;
import java.util.List;

public class Parameters4Must {
    private Parameter4Must parameter4Must;
    private List<mustacheComma> mustacheComma=new ArrayList<>();
    private List<Parameter4Must> Parameter4Must=new ArrayList<>();

    public void setMUSTACHE_COMMA(List<mustacheComma> MUSTACHE_COMMA) {
        this.mustacheComma = MUSTACHE_COMMA;
    }

    public void setParameter4Must(List<Parameter4Must> parameter4Must) {
        this.Parameter4Must = parameter4Must;
    }

    public void setParameter4Must(Parameter4Must parameter4Must) {
        this.parameter4Must = parameter4Must;
    }

    public Parameter4Must getParameter4Must() {
        return parameter4Must;
    }

    public List<mustacheComma> getMUSTACHE_COMMA() {
        return mustacheComma;
    }

}
