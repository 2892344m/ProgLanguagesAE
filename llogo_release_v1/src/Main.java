import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import ast.*;
import antlr.*;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    private static Expr loadAndParse(String path) throws Exception {
        String code = Files.readString(Paths.get(path));
        CharStream input = CharStreams.fromString(code);
        LLogoLexer lexer = new LLogoLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LLogoParser parser = new LLogoParser(tokens);
        parser.setErrorHandler(new BailErrorStrategy());
        ParseTree tree = parser.expr();
        //System.out.println(tree.toStringTree(parser));
        return new LLogoASTGeneratorVisitor().visitProgram(tree);
    }
    
    private static void typecheck(Expr prog) {
        Type type = (new Typecheck()).typecheckExpr(new Environment<>(), prog);
        System.out.println("Type: " + type);
    }

    private static InterpResult interp(Expr prog) {
        InterpResult result = (new Interp()).interpExpr(prog);
        System.out.println("Result: " + result.getValue());
        return result;
    }

    private static void renderInstructions(List<Instruction> instrs) {
        Render r = new Render(instrs);
        r.run();
    }

    private static void renderSample(String sampleName) {
        if (sampleName.equals("square")) {
            renderInstructions(Samples.square());
        } else if (sampleName.equals("squarePen")) {
            renderInstructions(Samples.squarePen());
        } else if (sampleName.equals("squareFractal")) {
            renderInstructions(Samples.squareFractal());
        } else if (sampleName.equals("squareDef")) {
            renderInstructions(Samples.squareDef());
        } else if (sampleName.equals("snowflake")) {
            renderInstructions(Samples.snowflake());
        } else if (sampleName.equals("spiral")) {
            renderInstructions(Samples.spiral());
        } else if (sampleName.equals("triangles")) {
            renderInstructions(Samples.triangles());
        } else {
            System.out.println("Unknown sample: " + sampleName);
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length == 1) {
            String inputFile = args[0];
            Expr p = loadAndParse(inputFile);
            typecheck(p);
            Expr desugared = Desugar.desugarExpr(p);
            List<Instruction> instrs = interp(desugared).getInstructions();
            renderInstructions(instrs);
        } else if (args.length == 2 && args[0].equals("-typecheck")) {
            String inputFile = args[1];
            Expr p = loadAndParse(inputFile);
            typecheck(p);
        } else if (args.length == 2 && args[0].equals("-interp")) {
            String inputFile = args[1];
            Expr p = loadAndParse(inputFile);
            InterpResult res = interp(Desugar.desugarExpr(p));
            System.out.println("Result: " + res.getValue());
            List<Instruction> instrs = res.getInstructions();
            System.out.println("Instructions:");
            instrs.forEach((instr) -> System.out.println(instr.toString()));
        } else if (args.length == 2 && args[0].equals("-sample")) {
            String sampleName = args[1];
            renderSample(sampleName);
        } else {
            System.out.println("Usage: ./run.(sh|bat) [-typecheck | -interp | -sample <sample-name>] <filename>");
        }
    }
}
