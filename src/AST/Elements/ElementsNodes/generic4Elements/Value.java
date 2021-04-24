package AST.Elements.ElementsNodes.generic4Elements;

public class Value {
    private String string;
    private NUmber number;
    private boolean True;
    private boolean False;
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

    public boolean isTrue() {
        return True;
    }

    public void setTrue(boolean aTrue) {
        True = aTrue;
    }

    public boolean isFalse() {
        return False;
    }

    public void setFalse(boolean aFalse) {
        False = aFalse;
    }

    public Object getNull() {
        return Null;
    }

    public void setNull(Object aNull) {
        Null = aNull;
    }
}
