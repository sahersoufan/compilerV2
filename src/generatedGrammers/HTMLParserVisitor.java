// Generated from E:/forth year/1/CompV2/src/main/antlr\HTMLParser.g4 by ANTLR 4.9.1
package generatedGrammers;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link HTMLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface HTMLParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link HTMLParser#htmlDocument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlDocument(HTMLParser.HtmlDocumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#scriptletOrSeaWs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScriptletOrSeaWs(HTMLParser.ScriptletOrSeaWsContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#htmlElements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlElements(HTMLParser.HtmlElementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#htmlElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlElement(HTMLParser.HtmlElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#htmlContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlContent(HTMLParser.HtmlContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#htmlAttribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlAttribute(HTMLParser.HtmlAttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#htmlChardata}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlChardata(HTMLParser.HtmlChardataContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#htmlMisc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlMisc(HTMLParser.HtmlMiscContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#htmlComment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlComment(HTMLParser.HtmlCommentContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#appExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAppExpression(HTMLParser.AppExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#collection4App1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollection4App1(HTMLParser.Collection4App1Context ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#oneLine4AppCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOneLine4AppCondition(HTMLParser.OneLine4AppConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#forExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForExpression(HTMLParser.ForExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#collection4For1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollection4For1(HTMLParser.Collection4For1Context ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#collection4For2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollection4For2(HTMLParser.Collection4For2Context ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#oneLine4For2Condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOneLine4For2Condition(HTMLParser.OneLine4For2ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#collection4For3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollection4For3(HTMLParser.Collection4For3Context ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#oneLine4For3Condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOneLine4For3Condition(HTMLParser.OneLine4For3ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#collection4For5}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollection4For5(HTMLParser.Collection4For5Context ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#oneLine4For5Condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOneLine4For5Condition(HTMLParser.OneLine4For5ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#showExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowExpression(HTMLParser.ShowExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#hideExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHideExpression(HTMLParser.HideExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#switchExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchExpression(HTMLParser.SwitchExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#switchCaseExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchCaseExpression(HTMLParser.SwitchCaseExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#collection4Switch1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollection4Switch1(HTMLParser.Collection4Switch1Context ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#oneLine4switch1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOneLine4switch1(HTMLParser.OneLine4switch1Context ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#ifExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfExpression(HTMLParser.IfExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#modelExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModelExpression(HTMLParser.ModelExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#collection4Model1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollection4Model1(HTMLParser.Collection4Model1Context ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#oneLine4ModelCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOneLine4ModelCondition(HTMLParser.OneLine4ModelConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#annotationClickExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationClickExpression(HTMLParser.AnnotationClickExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#annotationOverExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationOverExpression(HTMLParser.AnnotationOverExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#collection4Annotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollection4Annotation(HTMLParser.Collection4AnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#oneLine4Annotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOneLine4Annotation(HTMLParser.OneLine4AnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#functionCall4AnnotOneLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall4AnnotOneLine(HTMLParser.FunctionCall4AnnotOneLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#arrayFuncRet4AnnotOneLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayFuncRet4AnnotOneLine(HTMLParser.ArrayFuncRet4AnnotOneLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#propFuncRet4AnnotOneLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropFuncRet4AnnotOneLine(HTMLParser.PropFuncRet4AnnotOneLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#funcEndRet4AnnotOneLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncEndRet4AnnotOneLine(HTMLParser.FuncEndRet4AnnotOneLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(HTMLParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#variableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableName(HTMLParser.VariableNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(HTMLParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#trueOrFalse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueOrFalse(HTMLParser.TrueOrFalseContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#objArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjArray(HTMLParser.ObjArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#arrName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrName(HTMLParser.ArrNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#arrayCalling}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayCalling(HTMLParser.ArrayCallingContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(HTMLParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#obj}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObj(HTMLParser.ObjContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#subObj}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubObj(HTMLParser.SubObjContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#objBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjBody(HTMLParser.ObjBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#pair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair(HTMLParser.PairContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKey(HTMLParser.KeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#property}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty(HTMLParser.PropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#propertyValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyValue(HTMLParser.PropertyValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(HTMLParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#functionCallFromVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallFromVar(HTMLParser.FunctionCallFromVarContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#functionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionName(HTMLParser.FunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(HTMLParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(HTMLParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#comparisonExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpression(HTMLParser.ComparisonExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#oneLineCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOneLineCondition(HTMLParser.OneLineConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#oneLineBoolCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOneLineBoolCondition(HTMLParser.OneLineBoolConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#oneLineArithCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOneLineArithCondition(HTMLParser.OneLineArithConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#comparisonOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonOperator(HTMLParser.ComparisonOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#logicComprison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicComprison(HTMLParser.LogicComprisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#middleAndLastLogicComparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMiddleAndLastLogicComparison(HTMLParser.MiddleAndLastLogicComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#arithmeticLogic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticLogic(HTMLParser.ArithmeticLogicContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#lastArithmeticLogic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLastArithmeticLogic(HTMLParser.LastArithmeticLogicContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(HTMLParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#collection4everything}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollection4everything(HTMLParser.Collection4everythingContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#collection4comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollection4comparison(HTMLParser.Collection4comparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#collection4Arithmetic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollection4Arithmetic(HTMLParser.Collection4ArithmeticContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#collection4LogicRet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollection4LogicRet(HTMLParser.Collection4LogicRetContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#mustacheExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMustacheExpression(HTMLParser.MustacheExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#collection4Mustache}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollection4Mustache(HTMLParser.Collection4MustacheContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#collection4LogicRet4Must}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollection4LogicRet4Must(HTMLParser.Collection4LogicRet4MustContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#collection4CompMust}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollection4CompMust(HTMLParser.Collection4CompMustContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#collection4MUSTArithmetic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollection4MUSTArithmetic(HTMLParser.Collection4MUSTArithmeticContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#logicComprison4Must}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicComprison4Must(HTMLParser.LogicComprison4MustContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#middleAndLastLogicComparison4Must}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMiddleAndLastLogicComparison4Must(HTMLParser.MiddleAndLastLogicComparison4MustContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#arithmeticLogic4Must}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticLogic4Must(HTMLParser.ArithmeticLogic4MustContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#lastArithmeticLogic4Must}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLastArithmeticLogic4Must(HTMLParser.LastArithmeticLogic4MustContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#mustacheVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMustacheVariable(HTMLParser.MustacheVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#mustacheNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMustacheNumber(HTMLParser.MustacheNumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#mustacheValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMustacheValue(HTMLParser.MustacheValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#objArray4Must}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjArray4Must(HTMLParser.ObjArray4MustContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#arrName4Must}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrName4Must(HTMLParser.ArrName4MustContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#arrayCalling4Must}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayCalling4Must(HTMLParser.ArrayCalling4MustContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#functionCall4Must}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall4Must(HTMLParser.FunctionCall4MustContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#functionCallFromVar4Must}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallFromVar4Must(HTMLParser.FunctionCallFromVar4MustContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#functionName4Must}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionName4Must(HTMLParser.FunctionName4MustContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#parameters4Must}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters4Must(HTMLParser.Parameters4MustContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#parameter4Must}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter4Must(HTMLParser.Parameter4MustContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#subObj4Must}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubObj4Must(HTMLParser.SubObj4MustContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#property4Must}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty4Must(HTMLParser.Property4MustContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#propertyValue4Must}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyValue4Must(HTMLParser.PropertyValue4MustContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#oneLineCondition4Must}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOneLineCondition4Must(HTMLParser.OneLineCondition4MustContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#oneLineArithCondition4Must}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOneLineArithCondition4Must(HTMLParser.OneLineArithCondition4MustContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#oneLineBoolCondition4Must}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOneLineBoolCondition4Must(HTMLParser.OneLineBoolCondition4MustContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#comparisonExp4Must}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExp4Must(HTMLParser.ComparisonExp4MustContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#mustacheComparisonOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMustacheComparisonOperator(HTMLParser.MustacheComparisonOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilter(HTMLParser.FilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#modelName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModelName(HTMLParser.ModelNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#formatName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormatName(HTMLParser.FormatNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#script}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScript(HTMLParser.ScriptContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#style}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStyle(HTMLParser.StyleContext ctx);
}