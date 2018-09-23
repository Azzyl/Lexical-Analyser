import models.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        LexicalAnalyser lexicalAnalyser = new LexicalAnalyser();
        File file = new File("Program.txt");
        String text = FileUtils.readFileToString(file);
        text += '\n';
        ArrayList<Token> tokens = lexicalAnalyser.parseFile(text);
        for (Token token: tokens
             ) {
            System.out.print(token.toString());
        }
    }
}