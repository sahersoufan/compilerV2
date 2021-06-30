package main;

import AST.HtmlDocument;
import Base.BaseVisitor;
import generateCode.CodeGeneration;
import generatedGrammers.HTMLLexer;
import generatedGrammers.HTMLParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import symTab.CheckSymbols;
import treePrinter.SimpleTreeNode;
import treePrinter.printer.listing.ListingTreePrinter;

import java.io.IOException;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
            CheckSymbols checkSymbols = new CheckSymbols();
            if (checkSymbols.process()){
                System.out.println("don't continue");
            }else {
            System.out.println("continue");
            String source = "C:\\Users\\FATIMA\\Desktop\\compilerV2\\src\\sample.txt";
            CharStream cs = fromFileName(source);
            HTMLLexer lexer = new HTMLLexer(cs);
            CommonTokenStream token = new CommonTokenStream(lexer);
            HTMLParser parser = new HTMLParser(token);
            ParseTree tree = parser.htmlDocument();
            // define baseVisitor object
            BaseVisitor base = new BaseVisitor();
            //visit antlr tree and save nodes in mayar tree
            HtmlDocument doc = (HtmlDocument) base.visit(tree);

            // mayar add function in baseVisitor to print the tree from object (base)
            System.out.println();
            base.printTree();
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}