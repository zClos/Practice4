package com.pvt.service.ui;

import java.util.Scanner;

class InputData {

    private static final String REPEAT_MSG = "Continue?  Y/N: ";
    private static final String CHARSET_NAME = "Cp1251";
    private static final String INCORRECT_DATA = "Incorrect data: ";

    private Scanner scanner;

    private Scanner scan() {
        return new Scanner(System.in, CHARSET_NAME);
    }

    public int scanInt() {
        scanner = scan();
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }
        return -1;
    }

    public String scanString() {
        scanner = scan();
        if (scanner.hasNext()) {
            return scanner.nextLine();
        }
        return null;
    }

    public boolean repeat() {
        do {
            System.out.println(REPEAT_MSG);
            String input = scanString().trim();
            input = input.toLowerCase();
            switch (input) {
                case "y":
                    return true;
                case "n":
                    return false;
                default:
                    System.out.println(INCORRECT_DATA + input);
            }
        } while (true);
    }
}
