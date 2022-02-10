package ru.makhmutov.task1;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Calculator {

    private static final int UPPER_BOUNDARY = 1000;
    private static final int LOWER_BOUNDARY = 0;

    /**
     * The entry point of the Calculator program.
     * The program scans 2 positive integer values
     * and performs one of chosen operations
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        seeOperations();
        performOperation();
    }

    /**
     * This method displays all operations
     * and their id numbers
     */
    private static void seeOperations() {
        System.out.println("Possible operations: ");
        for (Operation operation : Operation.values()) {
            System.out.format("%d. %s%n", (operation.ordinal() + 1), operation.getOp());
        }
    }

    /**
     * This method allows insertion of operation type,
     * two integer values and performing the operation
     */
    private static void performOperation() {
        try (Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH)) {
            Operation operation = scanOperation(scanner);
            int value1;
            int value2;
            value1 = scanNumber(scanner, LOWER_BOUNDARY, UPPER_BOUNDARY, "first");
            value2 = scanNumber(scanner, LOWER_BOUNDARY, UPPER_BOUNDARY, "second");
            switch (operation) {
                case ADD:
                    System.out.println(value1 + value2);
                    break;
                case SUBTRACT:
                    System.out.println(value1 - value2);
                    break;
                case MULTIPLY:
                    System.out.println(value1 * value2);
                    break;
                case DIVIDE:
                    if (value2 != 0) {
                        System.out.println(value1 / value2);
                        break;
                    } else {
                        System.out.println("Error: Division by 0");
                        System.exit(-1);
                    }
                default:
                    System.out.println("Wrong operation chosen!");
            }
        }
    }

    /**
     * This method allows reading valid input integer values.
     *
     * @param scanner         The object of Scanner class needed
     *                        for scanning the number
     * @param lowerBoundary   The lower boundary for input value
     * @param upperBoundary   The upper boundary for input value
     * @return The obtained value received via scanning
     */
    private static int scanNumber(Scanner scanner, int lowerBoundary,
                                     int upperBoundary, String type) {
        int value = -1; // initially out of allowed boundaries
        boolean validityFlag;
        System.out.print("\nType the " + type + " value: ");
        do {
            try {
                value = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("\nUse only integer value, try one more time: ");
                validityFlag = false;
                scanner.next();
                continue;
            }
            if (lowerBoundary == upperBoundary && value < lowerBoundary) {
                System.out.format("%nPlease enter the number not lower than %d: ",
                        lowerBoundary);
                validityFlag = false;
            } else if (lowerBoundary != upperBoundary &&
                    (value < lowerBoundary || value > upperBoundary)) {
                System.out.format("%nPlease enter the number in range [%d; %d]: ",
                        lowerBoundary, upperBoundary);
                validityFlag = false;
            } else {
                validityFlag = true;
            }
        } while (!validityFlag);
        return value;
    }

    /**
     * This method allows to scan the operation number
     *
     * @param scanner The object of Scanner class needed
     *                for scanning the number
     * @return The obtained value received via scanning
     */
    private static Operation scanOperation(Scanner scanner) {
        double value = 0.5; // the initial value should not be integer to be a barrier for the program
        boolean inserted = false;
        System.out.print("Type the operation number: ");
        do {
            try {
                value = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.print("\nDo not enter characters, try one more time: ");
                scanner.next();
                continue;
            }
            for (Operation operation : Operation.values()) {
                if (value == (operation.ordinal() + 1)) {
                    inserted = true;
                    break;
                }
            }
            if (!inserted) {
                System.out.print("\nPlease insert applicable values: ");
            }
        } while (!inserted);
        return Operation.values()[(int) (value - 1)];
    }
}
