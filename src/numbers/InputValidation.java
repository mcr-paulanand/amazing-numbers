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

        if (numberOfInputs >= 1 && isNumberInvalid(number)) return true;
        if (numberOfInputs >= 2 && isConsecutiveNumberInvalid(consecutiveNumbers)) return true;
        if (numberOfInputs == 3 && isPropertyInvalid(properties)) return true;
        if (numberOfInputs >= 4 && (isPropertyInvalid(properties) || isPropertyExclusive(properties))) return true;

        return false;
    }

    static boolean isInputExit(long number) {
        if (number == 0) {
            System.out.println("Goodbye!");
            return true;
        }
        return false;
    }

    private static boolean isNumberInvalid(long number) {
        if (number < 0) {
            System.out.println("The first parameter should be a natural number or zero.");
            return true;
        } else {
            return false;
        }
    }
    private static boolean isConsecutiveNumberInvalid(long number) {
        if (number <= 0) {
            System.out.println("The second parameter should be a natural number.");
            return true;
        } else {
            return false;
        }
    }

    private static boolean isPropertyInvalid(String property) {
        return !Arrays.asList(NUMBER_PROPERTIES).contains(property);
    }

    private static boolean isPropertyInvalid(ArrayList<String> properties) {
        int numberOfWrongProperties = 0;
        ArrayList<String> wrongProperties = new ArrayList<>();

        for (String property : properties) {
            if (isPropertyInvalid(property)) {
                numberOfWrongProperties++;
                wrongProperties.add(property);
            }
        }

        switch (numberOfWrongProperties) {
            case 0:
                return false;
            case 1:
                System.out.println("The property " + wrongProperties + " is wrong.");
                System.out.println("Available properties: " + Arrays.toString(NUMBER_PROPERTIES));
                return true;
            default:
                System.out.println("The properties " + wrongProperties + " are wrong.");
                System.out.println("Available properties: " + Arrays.toString(NUMBER_PROPERTIES));
                return true;
        }
    }

    private static boolean isPropertyExclusive(ArrayList<String> properties) {
        for (String[] exclusiveProperty : EXCLUSIVE_PROPERTIES) {
            if (properties.containsAll(List.of(exclusiveProperty))) {
                System.out.println("The request contains mutually exclusive properties: " + Arrays.toString(exclusiveProperty));
                System.out.println("Available properties: " + Arrays.toString(NUMBER_PROPERTIES));
                return true;
            }
        }
        return false;
    }
}