package org.example;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String input = """
                process LoanApproval {
                    task SubmitApplication;
                    task ReviewApplication;
                    task ApproveLoan;
                }
                """;

        CodePointCharStream tream = CharStreams.fromString(input);
        BpmnSimpleLexer lexer = new BpmnSimpleLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        BpmnSimpleParser parser = new BpmnSimpleParser(tokens);

        ParseTree tree = parser.process();
        BpmnToSolidityVisitor visitor = new BpmnToSolidityVisitor();
        String solidityCode = visitor.visit(tree);

        // Écrire le code Solidity dans un fichier
        try (PrintWriter out = new PrintWriter("LoanApproval.sol")) {
            out.println(solidityCode);
        }

        System.out.println("✅ Smart contract Solidity généré avec succès !");
    }
}
