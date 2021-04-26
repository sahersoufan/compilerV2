package AST.Elements.ElementsNodes.mustacheExpression.generic4mustache;


import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.array.ObjArray4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.comparison.ComparisonExp4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.function.FunctionCall4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.object.SubObj4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.var.MustacheVariable;

public class Collection4OLCMust {
    private MustacheVariable mustacheVariable;
    private  boolean  MUSTACHE_TRUE;
    private boolean MUSTACHE_FALSE;
    private ObjArray4Must objArray4Must;
     private FunctionCall4Must functionCall4Must;
    private SubObj4Must subObj4Must;
    private ComparisonExp4Must comparisonExp4Must;

    public void setmustacheVariable(MustacheVariable mustacheVariable) {
        this.mustacheVariable = mustacheVariable;
    }
    public void setMUSTACHE_TRUE(boolean MUSTACHE_TRUE) {
        this.MUSTACHE_TRUE = MUSTACHE_TRUE;
    }
    public void setMUSTACHE_FALSE(boolean MUSTACHE_FALSE) {
        this.MUSTACHE_FALSE = MUSTACHE_FALSE;
    }
    public void setobjArray4Must(ObjArray4Must objArray4Must) {
        this.objArray4Must = objArray4Must;
    }

    public void setfunctionCall4Must(FunctionCall4Must functionCall4Must) {
        this.functionCall4Must = functionCall4Must;
    }
    public void setsubObj4Must(SubObj4Must subObj4Must) {
        this.subObj4Must = subObj4Must;
    }
    public void setcomparisonExp4Must(ComparisonExp4Must comparisonExp4Must) {
        this.comparisonExp4Must = comparisonExp4Must;
    }


    public MustacheVariable getmustacheVariable() {
        return mustacheVariable;
    }
    public boolean getMUSTACHE_TRUE() {
        return MUSTACHE_TRUE;
    }
    public boolean getMUSTACHE_FALSE() {
        return MUSTACHE_FALSE;
    }
    public ObjArray4Must getobjArray4Must() {
        return objArray4Must;
    }
    public FunctionCall4Must getfunctionCall4Must() {
        return functionCall4Must;
    }
    public SubObj4Must getsubObj4Must() {
        return subObj4Must;
    }
    public ComparisonExp4Must getcomparisonExp4Must() {
        return comparisonExp4Must;
    }




}
