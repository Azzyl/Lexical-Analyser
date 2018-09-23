import models.*;

import java.util.ArrayList;
import java.util.Arrays;

public class LexicalAnalyser {

    String[] keywords = {"across", "agent", "alias", "all", "as", "assign", "attribute", "check", "class", "convert",
            "create", "debug", "deferred", "else", "elseif", "ensure", "expanded", "export", "external",
            "feature", "from", "frozen", "if", "inherit", "inspect", "invariant", "like", "local", "loop",
            "note", "obsolete", "old", "once", "only", "precursor", "redefine", "rename", "require", "rescue", "retry",
            "select", "separate", "then", "tuple", "undefine", "until", "variant", "void", "when", "current", "result",
            "true", "false"};

    String[] separator = {";", "do", "end", "{", "}", "(", ")", ","};

    String[] newLine = {"\r", "\n", "\r\n"};

    String[] comments = {"--"};

    String[] operators = {"+", "-", "*", "/", "[", "]", "?", "!",
            "^", ",", "<", ">", "&", "|", ".", "\\", "~", "$",
            ":=", ":", "=", "xor", "and", "not", "or", "implies"};

    ArrayList<Token> tokens = new ArrayList<Token>();

    private boolean isNum(String str) {
        if (str.charAt(0) == '.') return false;
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) >= '0' & str.charAt(i) <= '9') | str.charAt(i) == '.') {
                continue;
            } else return false;
        }
        return true;
    }

    private boolean checkOperator(String str) {
        if (Arrays.asList(operators).contains(str.toLowerCase()))
            return true;
        return false;
    }

    private boolean checkSeparator(String str) {
        if (Arrays.asList(separator).contains(str.toLowerCase()))
            return true;
        return false;
    }

    private boolean checkKeyword(String str) {
        if (Arrays.asList(keywords).contains(str.toLowerCase()))
            return true;
        return false;
    }

    private boolean checkNewLine(String str) {
        if (Arrays.asList(newLine).contains(str.toLowerCase()))
            return true;
        return false;
    }

    public ArrayList parseFile(String input) {
        String temp = "";
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ') {
                temp += input.charAt(i);
                if (temp.equals("-")) {
                    if (input.charAt(i + 1) == '-') {
                        while (input.charAt(++i) != '\n') {
                        }
                        temp = "";
                    }
                } else if (checkKeyword(temp)) {
                    tokens.add(new KeywordToken(temp));
                    temp = "";
                } else if (checkSeparator(temp)) {
                    tokens.add(new SeparatorToken(temp));
                    temp = "";
                } else if (checkNewLine(temp)) {
                    tokens.add(new NewLineToken());
                    temp = "";
                } else if (!isNum(temp) & checkOperator(temp)) {
                    tokens.add(new OperatorToken(temp));
                    temp = "";
                } else {
                    if (temp.equals("\"")) {
                        while (input.charAt(++i) != '\"' & !(input.charAt(i) == '%')) {
                            temp += input.charAt(i);
                        }
                        tokens.add(new LiteralToken(temp + "\""));
                        temp = "";
                    } else
                    if (temp.equals("\'")) {
                        while (input.charAt(++i) != '\'' & !(input.charAt(i) == '%')) {
                            temp += input.charAt(i);
                        }
                        tokens.add(new LiteralToken(temp + "\'"));
                        temp = "";
                    } else
                    if (input.charAt(i + 1) == ' ' | checkNewLine(String.valueOf(input.charAt(i + 1))) |
                            checkSeparator(String.valueOf(input.charAt(i + 1))) |
                            checkOperator(String.valueOf(input.charAt(i + 1)))) {
                        if (isNum(temp)) {
                            if (input.charAt(i + 1) != '.') {
                                tokens.add(new LiteralToken(temp));
                                temp = "";
                            }
                        } else {
                            tokens.add(new IdentifierToken(temp));
                            temp = "";
                        }
                    }
                }
            }
        }
        return tokens;
    }
}
