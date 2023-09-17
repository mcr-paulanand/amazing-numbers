package numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static numbers.NumberProperty.NUMBER_PROPERTIES;
import static numbers.NumberProperty.EXCLUSIVE_PROPERTIES;
import static numbers.PrintOutput.printSupportedRequests;

final class InputValidation {
    static boolean isInputInvalid(int numberOfInputs, long number, int consecutiveNumbers, ArrayList<String> properties) {
        if (numberOfInputs == 0) {
            printSupportedRequests();
            return true;
        }

        if (numberOfInputs >= 1 && isNotNaturalNumber(number)) {
            System.out.println("The first parameter should be a natural number or zero.");
            return true;
        }

        if (numberOfInputs >= 2 && isNotNaturalNumber(consecutiveNumbers)) {
            System.out.println("The second parameter should be a natural number.");
            return true;
        }

        if (numberOfInputs == 3 && isPropertyInvalid(properties.get(0))) {
            System.out.println("The property [" + properties.get(0) + "] is wrong.");
            System.out.println("Available properties: " + Arrays.toString(NUMBER_PROPERTIES));
            return true;
        }

        if (numberOfInputs == 4) {
            if (isPropertyInvalid(properties)) {

                if (isPropertyInvalid(properties.get(0)) && isPropertyInvalid(properties.get(1))) {
                    System.out.println("The properties " + properties + " are wrong.");
                } else if (isPropertyInvalid(properties.get(0))) {
                    System.out.println("The property [" + properties.get(0) + "] is wrong.");
                } else if (isPropertyInvalid(properties.get(1))) {
                    System.out.println("The property [" + properties.get(1) + "] is wrong.");
                }

                System.out.println("Available properties: " + Arrays.toString(NUMBER_PROPERTIES));
                return true;
            }

            if (isPropertyExclusive(properties)) {
                System.out.println("The request contains mutually exclusive properties: " + properties);
                System.out.println("Available properties: " + Arrays.toString(NUMBER_PROPERTIES));
                return true;
            }
        }
        return false;
    }

    static boolean isInputExit(long number) {
        if (number == 0) {
            System.out.println("Goodbye!");
            return true;
        }
        return false;
    }

    private static boolean isNotNaturalNumber(long number) {
        return number <= 0;
    }

    private static boolean isPropertyInvalid(String property) {
        return !Arrays.asList(NUMBER_PROPERTIES).contains(property);
    }

    private static boolean isPropertyInvalid(ArrayList<String> properties) {
        return !Arrays.asList(NUMBER_PROPERTIES).containsAll(properties);
    }

    private static boolean isPropertyExclusive(ArrayList<String> properties) {
        for (String[] exclusiveProperty : EXCLUSIVE_PROPERTIES) {
            if (properties.containsAll(List.of(exclusiveProperty))) return true;
        }
        return false;
    }
}