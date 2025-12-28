package com.airtribe.learntrack.util;

import java.util.Scanner;

public class InputValidator {
    public static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Enter valid number: ");
        }
        return scanner.nextInt();
    }
}