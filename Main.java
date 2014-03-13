package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if(BrainfuckInterpreter.isCorrect(input)){
        char code[] = input.toCharArray();
        BrainfuckInterpreter lelik = new BrainfuckInterpreter();
        lelik.run(code);
        }
        else
            System.out.print("Incorrect code! Please,check it.");

    }
}
