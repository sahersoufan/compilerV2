package AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Logic;

import AST.Elements.ElementsNodes.generic4Elements.Collection4Arithmetic;
import AST.Elements.ElementsNodes.generic4Elements.Logic.ArithmeticLogic;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Collection4MUSTArithmetic;

public class LastArithmeticLogic4Must {

    private String Arithmetic;
    //this
    private Collection4MUSTArithmetic collection4MUSTArithmetic;
    //or
    private String OpenPar;
    private ArithmeticLogic4Must arithmeticLogic;
    private String ClosePar;

    public String getArithmetic() {
        return Arithmetic;
    }

    public void setArithmetic(String arithmetic) {
        Arithmetic = arithmetic;
    }

    public Collection4MUSTArithmetic getCollection4MUSTArithmetic() {
        return collection4MUSTArithmetic;
    }

    public void setCollection4MUSTArithmetic(Collection4MUSTArithmetic collection4MUSTArithmetic) {
        this.collection4MUSTArithmetic = collection4MUSTArithmetic;
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
}
