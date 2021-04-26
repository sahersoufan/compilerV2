package AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.property;

import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.array.ArrayCalling4Must;
import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.function.FunctionCallFromVar4Must;

public class Property4Must {
   private PropertyValue4Must propertyValue4Must;
    private ArrayCalling4Must arrayCalling4Must;
    private FunctionCallFromVar4Must functionCallFromVar4Must;

    public void setArrayCalling4Must(ArrayCalling4Must arrayCalling4Must) {
        this.arrayCalling4Must = arrayCalling4Must;
    }

    public void setFunctionCallFromVar4Must(FunctionCallFromVar4Must functionCallFromVar4Must) {
        this.functionCallFromVar4Must = functionCallFromVar4Must;
    }

    public void setPropertyValue4Must(PropertyValue4Must propertyValue4Must) {
        this.propertyValue4Must = propertyValue4Must;
    }

    public ArrayCalling4Must getArrayCalling4Must() {
        return arrayCalling4Must;
    }

    public FunctionCallFromVar4Must getFunctionCallFromVar4Must() {
        return functionCallFromVar4Must;
    }

    public PropertyValue4Must getPropertyValue4Must() {
        return propertyValue4Must;
    }
}
