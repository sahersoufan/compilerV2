package AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.function;

import java.util.ArrayList;
import java.util.List;

public class Parameters4Must {
    private Parameter4Must parameter4Must;
    private List<MUSTACHE_COMMA> MUSTACHE_COMMA=new ArrayList<>();
    private List<Parameter4Must> parameter4Must=new ArrayList<>();

    public void setMUSTACHE_COMMA(List<MUSTACHE_COMMA> MUSTACHE_COMMA) {
        this.MUSTACHE_COMMA = MUSTACHE_COMMA;
    }

    public void setParameter4Must(List<Parameter4Must> parameter4Must) {
        this.parameter4Must = parameter4Must;
    }

    public void setParameter4Must(Parameter4Must parameter4Must) {
        this.parameter4Must = parameter4Must;
    }

    public Parameter4Must getParameter4Must() {
        return parameter4Must;
    }

    public List<MUSTACHE_COMMA> getMUSTACHE_COMMA() {
        return MUSTACHE_COMMA;
    }

}
