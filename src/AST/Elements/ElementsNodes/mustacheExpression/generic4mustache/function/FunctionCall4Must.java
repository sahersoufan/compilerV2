package AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.function;

import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Collection4MUSTARITHMETIC;
import com.sun.source.tree.NewArrayTree;

import java.util.ArrayList;
import java.util.List;

public class FunctionCall4Must {
    private FunctionName4Must functionName4Must;
    private FunctionCallFromVar4Must functionCallFromVar4Must;
    private String mustacheArithmetic;
    private List<collection4MUSTARITHMETIC> collection4MUSTARITHMETIC= new ArrayList<>();

    public FunctionName4Must getFunctionName4Must() {
        return functionName4Must;
    }

    public void setFunctionName4Must(FunctionName4Must functionName4Must) {
        this.functionName4Must = functionName4Must;
    }

    public FunctionCallFromVar4Must getFunctionCallFromVar4Must() {
        return functionCallFromVar4Must;
    }

    public void setFunctionCallFromVar4Must(FunctionCallFromVar4Must functionCallFromVar4Must) {
        this.functionCallFromVar4Must = functionCallFromVar4Must;
    }

    public String getMustacheArithmetic() {
        return mustacheArithmetic;
    }

    public void setMustacheArithmetic(String mustacheArithmetic) {
        this.mustacheArithmetic = mustacheArithmetic;
    }

    public void setCollection4MUSTARITHMETIC(List<collection4MUSTARITHMETIC> collection4MUSTARITHMETIC) {
        this.collection4MUSTARITHMETIC = collection4MUSTARITHMETIC;
    }

    public List<collection4MUSTARITHMETIC> getCollection4MUSTARITHMETIC() {
        return collection4MUSTARITHMETIC;
    }
}
