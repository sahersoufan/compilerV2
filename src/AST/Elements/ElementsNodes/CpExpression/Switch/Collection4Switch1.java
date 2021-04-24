package AST.Elements.ElementsNodes.CpExpression.Switch;

import AST.Elements.ElementsNodes.generic4Elements.array.objArray;
import AST.Elements.ElementsNodes.generic4Elements.collection4ARITHMETIC;
import AST.Elements.ElementsNodes.generic4Elements.comparison.oneLineArithCondition;
import AST.Elements.ElementsNodes.generic4Elements.object.subObj;
import AST.Elements.ElementsNodes.generic4Elements.variable.variable;

public class Collection4Switch1 {
    private variable variable;
    private NUmber number;
    private String string;
    private objArray objArray;
    private subObj subObj;
    private OneLine4switch1 oneLine4switch1;
    private oneLineArithCondition oneLineArithCondition;

    public void setVariable(variable variable) {
        this.variable = variable;
    }


    public void setObjArray(objArray objArray) {
        this.objArray = objArray;
    }

    public void setSubObj(subObj subObj) {
        this.subObj = subObj;
    }

    public void setOneLine4switch1(OneLine4switch1 oneLine4switch1) {
        this.oneLine4switch1 = oneLine4switch1;
    }

    public void setOneLineArithCondition(oneLineArithCondition oneLineArithCondition) {
        this.oneLineArithCondition = oneLineArithCondition;
    }



    public variable getVariable() {
        return variable;
    }

    public objArray getObjArray() {
        return objArray;
    }

    public subObj getSubObj() {
        return subObj;
    }

    public OneLine4switch1 getOneLine4switch1() {
        return oneLine4switch1;
    }

    public oneLineArithCondition getOneLineArithCondition() {
        return oneLineArithCondition;
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
}
