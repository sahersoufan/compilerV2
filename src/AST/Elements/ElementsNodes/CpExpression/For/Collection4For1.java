package AST.Elements.ElementsNodes.CpExpression.For;

import AST.Elements.ElementsNodes.generic4Elements.array.ObjArray;
import AST.Elements.ElementsNodes.generic4Elements.object.SubObj;
import AST.Elements.ElementsNodes.generic4Elements.variable.Variable;

public class Collection4For1 {
    private Variable variable;
    private SubObj subObj;
    private ObjArray objArray;

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    public SubObj getSubObj() {
        return subObj;
    }

    public void setSubObj(SubObj subObj) {
        this.subObj = subObj;
    }

    public ObjArray getObjArray() {
        return objArray;
    }

    public void setObjArray(ObjArray objArray) {
        this.objArray = objArray;
    }
}
