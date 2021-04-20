package AST.Elements.ElementsNodes;



public class HtmlAttribute {


    private String tagName;
    private String attValue;
    private appExpression appExpression;
    private forExpression forExpression;
    private showHideExpression showHideExpression;
    private switchExpression switchExpression;
    private switchCaseExpression switchCaseExpression;
    private ifExpression ifExpression;
    private modelExpression modelExpression;
    private annotationExpression annotationExpression;


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

    public appExpression getAppExpression() {
        return appExpression;
    }

    public void setAppExpression(appExpression appExpression) {
        this.appExpression = appExpression;
    }

    public forExpression getForExpression() {
        return forExpression;
    }

    public void setForExpression(forExpression forExpression) {
        this.forExpression = forExpression;
    }

    public showHideExpression getShowHideExpression() {
        return showHideExpression;
    }

    public void setShowHideExpression(showHideExpression showHideExpression) {
        this.showHideExpression = showHideExpression;
    }

    public switchExpression getSwitchExpression() {
        return switchExpression;
    }

    public void setSwitchExpression(switchExpression switchExpression) {
        this.switchExpression = switchExpression;
    }

    public switchCaseExpression getSwitchCaseExpression() {
        return switchCaseExpression;
    }

    public void setSwitchCaseExpression(switchCaseExpression switchCaseExpression) {
        this.switchCaseExpression = switchCaseExpression;
    }

    public ifExpression getIfExpression() {
        return ifExpression;
    }

    public void setIfExpression(ifExpression ifExpression) {
        this.ifExpression = ifExpression;
    }

    public modelExpression getModelExpression() {
        return modelExpression;
    }

    public void setModelExpression(modelExpression modelExpression) {
        this.modelExpression = modelExpression;
    }

    public annotationExpression getAnnotationExpression() {
        return annotationExpression;
    }

    public void setAnnotationExpression(annotationExpression annotationExpression) {
        this.annotationExpression = annotationExpression;
    }
}
