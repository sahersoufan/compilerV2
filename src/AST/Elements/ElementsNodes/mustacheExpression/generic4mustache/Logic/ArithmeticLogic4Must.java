package AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Logic;

import AST.Elements.ElementsNodes.generic4Elements.Collection4Arithmetic;
import AST.Elements.ElementsNodes.generic4Elements.Logic.ArithmeticLogic;
import AST.Elements.ElementsNodes.generic4Elements.Logic.LastArithmeticLogic;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Collection4MUSTArithmetic;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticLogic4Must {
    //first
    //this
    private Collection4MUSTArithmetic collection4Arithmetic;
    //or
    private String OpenPar;
    private ArithmeticLogic4Must arithmeticLogic;
    private String ClosePar;
    //last
    private List<LastArithmeticLogic4Must> lastArithmeticLogic = new ArrayList<>();


    public Collection4MUSTArithmetic getCollection4Arithmetic() {
        return collection4Arithmetic;
    }

    public void setCollection4Arithmetic(Collection4MUSTArithmetic collection4Arithmetic) {
        this.collection4Arithmetic = collection4Arithmetic;
    }

    public String getOpenPar() {
        return OpenPar;
    }

    public void setOpenPar(String openPar) {
        OpenPar = openPar;
    }

    public ArithmeticLogic4Must getArithmeticLogic() {
        return arithmeticLogic;
    }

    public void setArithmeticLogic(ArithmeticLogic4Must arithmeticLogic) {
        this.arithmeticLogic = arithmeticLogic;
    }

    public String getClosePar() {
        return ClosePar;
    }

    public void setClosePar(String closePar) {
        ClosePar = closePar;
    }

    public List<LastArithmeticLogic4Must> getLastArithmeticLogic() {
        return lastArithmeticLogic;
    }

    public void setLastArithmeticLogic(List<LastArithmeticLogic4Must> lastArithmeticLogic) {
        this.lastArithmeticLogic = lastArithmeticLogic;
    }
}
