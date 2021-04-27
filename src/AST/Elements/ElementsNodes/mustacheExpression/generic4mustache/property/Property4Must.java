package AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.property;

import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.array.ArrayCalling4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.function.FunctionCallFromVar4Must;

import java.util.ArrayList;
import java.util.List;

public class Property4Must {
    private List<PropertyValue4Must> PropertyValue4Must = new ArrayList<>();
    private ArrayCalling4Must arrayCalling4Must;
    private FunctionCallFromVar4Must functionCallFromVar4Must;

    public List<AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.property.PropertyValue4Must> getPropertyValue4Must() {
        return PropertyValue4Must;
    }

    public void setPropertyValue4Must(List<AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.property.PropertyValue4Must> propertyValue4Must) {
        PropertyValue4Must = propertyValue4Must;
    }

    public ArrayCalling4Must getArrayCalling4Must() {
        return arrayCalling4Must;
    }

    public void setArrayCalling4Must(ArrayCalling4Must arrayCalling4Must) {
        this.arrayCalling4Must = arrayCalling4Must;
    }

    public FunctionCallFromVar4Must getFunctionCallFromVar4Must() {
        return functionCallFromVar4Must;
    }

    public void setFunctionCallFromVar4Must(FunctionCallFromVar4Must functionCallFromVar4Must) {
        this.functionCallFromVar4Must = functionCallFromVar4Must;
    }
}
