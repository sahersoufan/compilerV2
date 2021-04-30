package AST.Elements.ElementsNodes.generic4Elements.Logic;

import AST.Elements.ElementsNodes.generic4Elements.Collection4Arithmetic;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticLogic {
    //first
    //this
    private Collection4Arithmetic collection4Arithmetic;
    //or
    private String OpenPar;
    private ArithmeticLogic arithmeticLogic;
    private String ClosePar;
    //last
    private List<LastArithmeticLogic> lastArithmeticLogic = new ArrayList<>();


    public Collection4Arithmetic getCollection4Arithmetic() {
        return collection4Arithmetic;
    }

    public void setCollection4Arithmetic(Collection4Arithmetic collection4Arithmetic) {
        this.collection4Arithmetic = collection4Arithmetic;
    }

    public String getOpenPar() {
        return OpenPar;
    }

    public void setOpenPar(String openPar) {
        OpenPar = openPar;
    }

    public ArithmeticLogic getArithmeticLogic() {
        return arithmeticLogic;
    }

    public void setArithmeticLogic(ArithmeticLogic arithmeticLogic) {
        this.arithmeticLogic = arithmeticLogic;
    }

    public String getClosePar() {
        return ClosePar;
    }

    public void setClosePar(String closePar) {
        ClosePar = closePar;
    }

    public List<LastArithmeticLogic> getLastArithmeticLogic() {
        return lastArithmeticLogic;
    }

    public void setLastArithmeticLogic(List<LastArithmeticLogic> lastArithmeticLogic) {
        this.lastArithmeticLogic = lastArithmeticLogic;
    }
}
