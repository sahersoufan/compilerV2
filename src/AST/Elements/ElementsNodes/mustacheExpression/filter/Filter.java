package AST.Elements.ElementsNodes.mustacheExpression.filter;

import AST.Elements.ElementsNodes.mustacheExpression.generic4mustache.Collection4Mustache;

public class Filter {
        private String Filter;
       private FormatName formatName;
   private String mustacheString;

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

    public String getMustacheString() {
        return mustacheString;
    }

    public void setMustacheString(String mustacheString) {
        this.mustacheString = mustacheString;
    }
}
