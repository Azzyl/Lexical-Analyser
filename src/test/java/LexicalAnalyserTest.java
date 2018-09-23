import models.Token;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LexicalAnalyserTest {

    @Test
    public void testParseFile1() {
        LexicalAnalyser lexicalAnalyser = new LexicalAnalyser();
        String input = ("class\n" +
                "\tAPPLICATION\n" +
                "inherit\n" +
                "\tARGUMENTS\n" +
                "create\n" +
                "\tmake\n" +
                "feature {NONE} -- Initialization\n" +
                "\tmake\n" +
                "\t\t\t-- Run application.\n" +
                "\t\tdo\n" +
                "\t\t\tprint(argument(1).to_integer +\targument(2).to_integer)\n" +
                "\t\tend\n" +
                "end\n").replaceAll("\t", "");

        String exptectedOutput = "[Keyword: class]\n" +
                "[Identifier: APPLICATION]\n" +
                "[Keyword: inherit]\n" +
                "[Identifier: ARGUMENTS]\n" +
                "[Keyword: create]\n" +
                "[Identifier: make]\n" +
                "[Keyword: feature][Separator: {][Identifier: NONE][Separator: }][Identifier: make]\n" +
                "[Separator: do]\n" +
                "[Identifier: print][Separator: (][Identifier: argument][Separator: (][Literal: 1][Separator: )][Operator: .][Identifier: to_integer][Operator: +][Identifier: argument][Separator: (][Literal: 2][Separator: )][Operator: .][Identifier: to_integer][Separator: )]\n" +
                "[Separator: end]\n" +
                "[Separator: end]\n";
        ArrayList<Token> tokens = lexicalAnalyser.parseFile(input);
        String output = "";
        for (Token token : tokens) {
            output += token.toString();
        }
        assertEquals(exptectedOutput, output);
    }

    @Test
    public void testParseFile2() {
        LexicalAnalyser lexicalAnalyser = new LexicalAnalyser();
        String input = ("class\n" +
                "\tAPPLICATION\n" +
                " \n" +
                "create\n" +
                "\tmake\n" +
                " \n" +
                "feature\n" +
                " \n" +
                "\tmake\n" +
                "\t\t\t-- Test of middle_three_digits.\n" +
                "\t\tlocal\n" +
                "\t\t\ttest_1, test_2: ARRAY [INTEGER]\n" +
                "\t\tdo\n" +
                "\t\t\ttest_1 := <<123, -1008, -100, 100>>\n" +
                "\t\t\ttest_2 := <<1, 2, -1, -10, 2002, -2002, 0>>\n" +
                "\t\t\tacross\n" +
                "\t\t\t\ttest_1 as t\n" +
                "\t\t\tloop\n" +
                "\t\t\t\tio.put_string (\"The middle three digits of \" + t.item.out + \" are: %T \")\n" +
                "\t\t\t\tio.put_string (middle_three_digits (t.item) + \"%N\")\n" +
                "\t\t\tend\n" +
                "\t\t\tacross\n" +
                "\t\t\t\ttest_2 as t\n" +
                "\t\t\tloop\n" +
                "\t\t\t\tio.put_string (\"The middle three digits of \" + t.item.out + \" are: %T\")\n" +
                "\t\t\t\tio.put_string (middle_three_digits (t.item) + \"%N\")\n" +
                "\t\t\tend\n" +
                "\t\tend").replaceAll("\t", "");

        String exptectedOutput = "[Keyword: class]\n" +
                "[Identifier: APPLICATION]\n" +
                "\n" +
                "[Keyword: create]\n" +
                "[Identifier: make]\n" +
                "\n" +
                "[Keyword: feature]\n" +
                "\n" +
                "[Identifier: make]\n" +
                "[Keyword: local]\n" +
                "[Identifier: test_1][Separator: ,][Identifier: test_2][Operator: :][Identifier: ARRAY][Operator: [][Identifier: INTEGER][Operator: ]]\n" +
                "[Separator: do]\n" +
                "[Identifier: test_1][Operator: :][Operator: =][Operator: <][Operator: <][Literal: 123][Separator: ,][Identifier: -1008][Separator: ,][Identifier: -100][Separator: ,][Literal: 100][Operator: >][Operator: >]\n" +
                "[Identifier: test_2][Operator: :][Operator: =][Operator: <][Operator: <][Literal: 1][Separator: ,][Literal: 2][Separator: ,][Identifier: -1][Separator: ,][Identifier: -10][Separator: ,][Literal: 2002][Separator: ,][Identifier: -2002][Separator: ,][Literal: 0][Operator: >][Operator: >]\n" +
                "[Keyword: across]\n" +
                "[Identifier: test_1][Keyword: as][Identifier: t]\n" +
                "[Keyword: loop]\n" +
                "[Identifier: io][Operator: .][Identifier: put_string][Separator: (][Literal: \"The middle three digits of \"][Operator: +][Identifier: t][Operator: .][Identifier: item][Operator: .][Identifier: out][Operator: +][Literal: \" are: \"][Identifier: T][Literal: \")\n" +
                "io.put_string (middle_three_digits (t.item) + \"][Identifier: %N\"][Separator: )]\n" +
                "[Separator: end]\n" +
                "[Keyword: across]\n" +
                "[Identifier: test_2][Keyword: as][Identifier: t]\n" +
                "[Keyword: loop]\n" +
                "[Identifier: io][Operator: .][Identifier: put_string][Separator: (][Literal: \"The middle three digits of \"][Operator: +][Identifier: t][Operator: .][Identifier: item][Operator: .][Identifier: out][Operator: +][Literal: \" are: \"][Identifier: T\"][Separator: )]\n" +
                "[Identifier: io][Operator: .][Identifier: put_string][Separator: (][Identifier: middle_three_digits][Separator: (][Identifier: t][Operator: .][Identifier: item][Separator: )][Operator: +][Literal: \"\"][Identifier: N\"][Separator: )]\n" +
                "[Separator: end]\n" +
                "[Separator: end]";
        ArrayList<Token> tokens = lexicalAnalyser.parseFile(input);
        String output = "";
        for (Token token : tokens) {
            output += token.toString();
        }
        assertEquals(exptectedOutput, output);
    }
}
