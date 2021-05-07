package main;

import AST.HtmlDocument;
import Base.BaseVisitor;
import generatedGrammers.HTMLLexer;
import generatedGrammers.HTMLParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import treePrinter.SimpleTreeNode;
import treePrinter.printer.listing.ListingTreePrinter;

import java.io.IOException;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Main {

    public static void main(String[] args) {
	// write your code here



<<<<<<< HEAD
=======
        root.addChild(new SimpleTreeNode("Child 3"));
        root.addChild(new SimpleTreeNode("Child 5"));
        root.addChild(new SimpleTreeNode("Child 6"));
        new ListingTreePrinter().print(root);





        try {
            String source = "E:\\forth year\\COMP\\src\\sample.txt";
            CharStream cs = fromFileName(source);
            HTMLLexer lexer = new HTMLLexer(cs);
            CommonTokenStream token = new CommonTokenStream(lexer);
            HTMLParser parser = new HTMLParser(token);
            ParseTree tree = parser.htmlDocument();
            // define baseVisitor object
            BaseVisitor base = new BaseVisitor();
            //visit antlr tree and save nodes in mayar tree
            HtmlDocument doc = (HtmlDocument) base.visit(tree);
            System.out.println(doc);
            // mayar add function in baseVisitor to print the tree from object (base)



        } catch (IOException e) {
            e.printStackTrace();
        }
>>>>>>> 0d94d1f2a0b4b83b4e0cf3f16a709c5b83142056
    }
}