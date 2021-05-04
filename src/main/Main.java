package main;

import treePrinter.SimpleTreeNode;
import treePrinter.printer.listing.ListingTreePrinter;

public class Main {

    public static void main(String[] args) {
	// write your code here
        SimpleTreeNode root = new SimpleTreeNode("root");


        root.addChild(new SimpleTreeNode("Child 1"));
        root.addChild(new SimpleTreeNode("Child 2"));
        SimpleTreeNode child3 = new SimpleTreeNode("Child 3");
        SimpleTreeNode sonOfChild3 = new SimpleTreeNode("Son ofChild 3");
        SimpleTreeNode sonOfSon3 = new SimpleTreeNode("Son of son child 3");
        sonOfChild3.addChild(sonOfSon3);
        child3.addChild(sonOfChild3);
        root.addChild(child3);



        root.addChild(new SimpleTreeNode("Child 3"));
        root.addChild(new SimpleTreeNode("Child 5"));
        root.addChild(new SimpleTreeNode("Child 6"));
        new ListingTreePrinter().print(root);
    }
}