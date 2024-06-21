package com.SalesTaxesProject.SalesTaxesProject.util;

import java.util.Scanner;

public class InputReaderUtil {

    private static final Scanner scanner = new Scanner(System.in, "UTF-8");

    public int readSelection() {
        try {
            int input = Integer.parseInt(scanner.nextLine());
            return input;
        } catch (Exception e) {
            System.out.println("Error reading input. Please enter valid number");
            return -1;
        }
    }
}
