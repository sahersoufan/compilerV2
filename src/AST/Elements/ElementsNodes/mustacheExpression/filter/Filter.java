package AST.Elements.ElementsNodes.mustacheExpression.filter;

import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Collection4Mustache;

public class Filter {
        private ModelName modelName;
        private String Filter;
       private FormatName formatName;
   private Collection4Mustache collection4Mustache;

    public ModelName getModelName() {
        return modelName;
    }

    public void setModelName(ModelName modelName) {
        this.modelName = modelName;
    }

    public String getFilter() {
        return Filter;
    }

    public void setFilter(String filter) {
        Filter = filter;
    }

    public FormatName getFormatName() {
        return formatName;
    }

    public void setFormatName(FormatName formatName) {
        this.formatName = formatName;
    }

    public Collection4Mustache getCollection4Mustache() {
        return collection4Mustache;
    }

    public void setCollection4Mustache(Collection4Mustache collection4Mustache) {
        this.collection4Mustache = collection4Mustache;
    }
}
