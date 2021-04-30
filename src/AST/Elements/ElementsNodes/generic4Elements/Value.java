package AST.Elements.ElementsNodes.generic4Elements;

public class Value {
    private String string;
    private NUmber number;
    private TrueOrFalse trueOrFalse;
    private Object Null;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public NUmber getNumber() {
        return number;
    }

    public void setNumber(NUmber number) {
        this.number = number;
    }

    public TrueOrFalse getTrueOrFalse() {
        return trueOrFalse;
    }

    public void setTrueOrFalse(TrueOrFalse trueOrFalse) {
        this.trueOrFalse = trueOrFalse;
    }

    public Object getNull() {
        return Null;
    }

    public void setNull(Object aNull) {
        Null = aNull;
    }
}
