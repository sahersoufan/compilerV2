package AST.Elements.ElementsNodes.CpExpression.Switch;


import AST.Elements.ElementsNodes.generic4Elements.NUmber;
import AST.Elements.ElementsNodes.generic4Elements.array.ObjArray;
import AST.Elements.ElementsNodes.generic4Elements.comparison.OneLineArithCondition;
import AST.Elements.ElementsNodes.generic4Elements.object.SubObj;
import AST.Elements.ElementsNodes.generic4Elements.variable.Variable;

public class Collection4Switch1 {
    private Variable variable;
    private NUmber number;
    private String string;
    private ObjArray objArray;
    private SubObj subObj;
    private OneLine4switch1 oneLine4switch1;
    private OneLineArithCondition oneLineArithCondition;


    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    public NUmber getNumber() {
        return number;
    }

    public void setNumber(NUmber number) {
        this.number = number;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public ObjArray getObjArray() {
        return objArray;
    }

    public void setObjArray(ObjArray objArray) {
        this.objArray = objArray;
    }

    public SubObj getSubObj() {
        return subObj;
    }

    public void setSubObj(SubObj subObj) {
        this.subObj = subObj;
    }

    public OneLine4switch1 getOneLine4switch1() {
        return oneLine4switch1;
    }

    public void setOneLine4switch1(OneLine4switch1 oneLine4switch1) {
        this.oneLine4switch1 = oneLine4switch1;
    }

    public OneLineArithCondition getOneLineArithCondition() {
        return oneLineArithCondition;
    }

    public void setOneLineArithCondition(OneLineArithCondition oneLineArithCondition) {
        this.oneLineArithCondition = oneLineArithCondition;
    }
}
