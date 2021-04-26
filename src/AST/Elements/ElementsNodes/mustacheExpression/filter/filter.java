package AST.Elements.ElementsNodes.mustacheExpression.filter;

import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.collection4Mustache;

public class filter {
        private modelName modelName;
      // private MUSTACHE_FILTER MUSTACHE_FILTER;
       private formatName formatName;
   private collection4Mustache collection4Mustache;

    public void setCollection4Mustache(collection4Mustache collection4Mustache) {
        this.collection4Mustache = collection4Mustache;
    }

    public void setFormatName(AST.Elements.ElementsNodes.mustacheExpression.filter.formatName formatName) {
        this.formatName = formatName;
    }

    public void setModelName(AST.Elements.ElementsNodes.mustacheExpression.filter.modelName modelName) {
        this.modelName = modelName;
    }

    public AST.Elements.ElementsNodes.mustacheExpression.filter.formatName getFormatName() {
        return formatName;
    }

    public AST.Elements.ElementsNodes.mustacheExpression.filter.modelName getModelName() {
        return modelName;
    }
}
