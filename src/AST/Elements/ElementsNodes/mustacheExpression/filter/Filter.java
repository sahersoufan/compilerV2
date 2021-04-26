package AST.Elements.ElementsNodes.mustacheExpression.filter;

import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Collection4Mustache;

public class Filter {
        private ModelName modelName;
      // private MUSTACHE_FILTER MUSTACHE_FILTER;
       private FormatName formatName;
   private Collection4Mustache collection4Mustache;

    public void setCollection4Mustache(Collection4Mustache collection4Mustache) {
        this.collection4Mustache = collection4Mustache;
    }

    public void setFormatName(FormatName formatName) {
        this.formatName = formatName;
    }

    public void setModelName(ModelName modelName) {
        this.modelName = modelName;
    }

    public FormatName getFormatName() {
        return formatName;
    }

    public ModelName getModelName() {
        return modelName;
    }
}
