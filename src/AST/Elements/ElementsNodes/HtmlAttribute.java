package AST.Elements.ElementsNodes;



import AST.Elements.ElementsNodes.CpExpression.For.ForExpression;
import AST.Elements.ElementsNodes.CpExpression.If.IfExpression;
import AST.Elements.ElementsNodes.CpExpression.Switch.SwitchCaseExpression;
import AST.Elements.ElementsNodes.CpExpression.Switch.SwitchExpression;
import AST.Elements.ElementsNodes.CpExpression.annotation.AnnotationExpression;
import AST.Elements.ElementsNodes.CpExpression.app.AppExpression;
import AST.Elements.ElementsNodes.CpExpression.model.ModelExpression;
import AST.Elements.ElementsNodes.CpExpression.showHide.ShowHideExpression;

public class HtmlAttribute {


    private String tagName;
    private String attValue;
    private AppExpression appExpression;
    private ForExpression forExpression;
    private ShowHideExpression showHideExpression;
    private SwitchExpression switchExpression;
    private SwitchCaseExpression switchCaseExpression;
    private IfExpression ifExpression;
    private ModelExpression modelExpression;
    private AnnotationExpression annotationExpression;


    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getAttValue() {
        return attValue;
    }

    public void setAttValue(String attValue) {
        this.attValue = attValue;
    }

    public AppExpression getAppExpression() {
        return appExpression;
    }

    public void setAppExpression(AppExpression appExpression) {
        this.appExpression = appExpression;
    }

    public ForExpression getForExpression() {
        return forExpression;
    }

    public void setForExpression(ForExpression forExpression) {
        this.forExpression = forExpression;
    }

    public ShowHideExpression getShowHideExpression() {
        return showHideExpression;
    }

    public void setShowHideExpression(ShowHideExpression showHideExpression) {
        this.showHideExpression = showHideExpression;
    }

    public SwitchExpression getSwitchExpression() {
        return switchExpression;
    }

    public void setSwitchExpression(SwitchExpression switchExpression) {
        this.switchExpression = switchExpression;
    }

    public SwitchCaseExpression getSwitchCaseExpression() {
        return switchCaseExpression;
    }

    public void setSwitchCaseExpression(SwitchCaseExpression switchCaseExpression) {
        this.switchCaseExpression = switchCaseExpression;
    }

    public IfExpression getIfExpression() {
        return ifExpression;
    }

    public void setIfExpression(IfExpression ifExpression) {
        this.ifExpression = ifExpression;
    }

    public ModelExpression getModelExpression() {
        return modelExpression;
    }

    public void setModelExpression(ModelExpression modelExpression) {
        this.modelExpression = modelExpression;
    }

    public AnnotationExpression getAnnotationExpression() {
        return annotationExpression;
    }

    public void setAnnotationExpression(AnnotationExpression annotationExpression) {
        this.annotationExpression = annotationExpression;
    }
}
