package symTab;

import generatedGrammers.HTMLLexer;
import generatedGrammers.HTMLParser;
import org.antlr.symtab.Scope;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.util.*;

import org.antlr.v4.runtime.CharStream;

import static org.antlr.v4.runtime.CharStreams.fromFileName;


public class CheckSymbols {

    private static Map<Scope, List<String>> scopesVar = new HashMap<>();
    private static List<String> Ids = new ArrayList<>();
    private static String typeOfFormat = "";

    private static Scope tempScope;
    public static boolean checKResolve(Scope s, String v){
        if (!scopesVar.isEmpty()) {
            if (scopesVar.containsKey(s)) {
                List<String> tempScope = scopesVar.get(s);
                int index = tempScope.indexOf(v);
                if (index != -1) {
                    if (tempScope.get(index).equals(v)) {
                        return false;
                    }
                }
                scopesVar.get(s).add(v);
                return true;
            }
        }
        scopesVar.put(s,new ArrayList<String>(Collections.singleton(v)));
        return true;
    }

    public static boolean checkScope(Scope temp, Token nameToken){
        tempScope = temp;
        if (tempScope.getEnclosingScope() != null) {
            tempScope = tempScope.getEnclosingScope();
            // TODO are you sure that you need to get every scope
            while (tempScope.getEnclosingScope() != null) {
                if (tempScope.resolve(nameToken.getText()) != null) {
                    return false;
                }
                tempScope = tempScope.getEnclosingScope();
            }
        }
        return true;
    }

    public static boolean checkIdsDifferent(String id){
        if (!Ids.contains(id)){
            Ids.add(id);
            return true;
        }
        return false;
    }

    public static void setTypeOfFormat(String type){
        typeOfFormat = type;
    }

    public static boolean CheckTypeOfFormat(String value){

        value = value.replace("\"","");
        if (typeOfFormat.equals("date")){
            if (value.equals("dd/mm/yyyy h:m") || value.equals("dd/mm/yyyy h:m:s")) {
                return true;
            }else if(value.equals("mm/dd/yyyy h:m") || value.equals("mm/dd/yyyy h:m:s")){
                return true;
            }else if(value.equals("dd-mm-yyyy h:m") || value.equals("dd-mm-yyyy h:m:s")){
                return true;
            }else if(value.equals("mm-dd-yyyy h:m") || value.equals("mm-dd-yyyy h:m:s")){
                return  true;
            }else if (value.equals("mm-yyyy")){
                return true;
            }else if (value.equals("mm-yy")){
                return false;
            }
        }else if(typeOfFormat.equals("currency")){
            if (value.length() == 1){
                return true;
            }else{
                return  false;
            }
        }else if(typeOfFormat.equals(("upper"))){
            return false;
        }else if(typeOfFormat.equals("lower")){
            return false;
        }

        return false;
    }


    public static boolean checkIfInsideApp(Scope cs){
        String parents = cs.getName();
        if (parents.contains("App")){
            return true;
        }
        return false;
    }


    public static void error(Token t, String msg) {
        System.err.printf("line %d:%d %s\n", t.getLine(), t.getCharPositionInLine(),
                msg);
    }

    public boolean process() throws Exception {
        String source = "C:\\Users\\FATIMA\\Desktop\\compilerV2\\src\\sample.txt";
        String errorsFile = "C:\\Users\\FATIMA\\Desktop\\compilerV2\\src\\Errors.txt";
        String STFile = "C:\\Users\\FATIMA\\Desktop\\compilerV2\\src\\ST.txt";
        File EF1 = new File(errorsFile);
        if (EF1.exists()){
            EF1.delete();
        }
        File ST1 = new File(STFile);
        if (ST1.exists()){
            ST1.delete();
        }

        CharStream cs = fromFileName(source);
        HTMLLexer lexer = new HTMLLexer(cs);
        CommonTokenStream token = new CommonTokenStream(lexer);
        HTMLParser parser = new HTMLParser(token);
        System.out.println("");
        ParseTree tree = parser.htmlDocument();
        ParseTreeWalker walker = new ParseTreeWalker();
        DefPhase def = new DefPhase();
        walker.walk(def, tree);


        RefPhase ref = new RefPhase(def.globals, def.scopes, errorsFile, STFile);
        walker.walk(ref, tree);


        File EF = new File(errorsFile);
        return EF.length() != 0;
    }
}