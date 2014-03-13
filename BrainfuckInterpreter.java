package com.company;

import java.io.IOException;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BrainfuckInterpreter {
    /**variables*/
    private char[] code;
    private int[] cellset;
    private Stack<CellInfo> cycle;
    /**methods*/
    public static boolean isCorrect(String testString){
        Pattern authCode=Pattern.compile("(\\+|-|>|<|\\.|,|\\[|])*e$");
        Matcher m=authCode.matcher(testString);
        return m.matches();
    }
    public void run(char[] c) {
        code = c.clone();
        int numberOfCells = 0;
        for (char symbol : code) {
            if (symbol == '>')
                ++numberOfCells;
        }
        cellset = new int[numberOfCells + 1];
        for (int cell : cellset)
            cell = 0;
        cycle = new Stack<CellInfo>();
        int currentCell = 0;
        int currentCode = 0;
        /**the end of preparing to execute**/
        while (code[currentCode] != 'e') {
            switch (code[currentCode]) {
                case '+':
                    ++cellset[currentCell];
                    break;
                case '-':
                    --cellset[currentCell];
                    break;
                case '>':
                    ++currentCell;
                    break;
                case '<':
                    --currentCell;
                    break;
                case '.':
                    System.out.print((char)cellset[currentCell]);
                    break;
                case ',':
                    try {
                        cellset[currentCell] = System.in.read();
                    } catch (IOException e) {
                        System.out.print("Input ERROR");
                    }
                    break;
                case '[':
                    cycle.push(new CellInfo(currentCell,currentCode));
                    break;
                case ']':
                    if (cellset[cycle.firstElement().cellOrdinalNumber] == 0)
                        cycle.pop();
                    else
                        currentCode = cycle.firstElement().codeOrdinalNumber;
                    break;
            }
            ++currentCode;
        }
    }
}
