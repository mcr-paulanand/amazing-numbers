package numbers;

import java.util.ArrayList;
import java.util.Scanner;

import static numbers.InputValidation.isInputExit;
import static numbers.InputValidation.isInputInvalid;
import static numbers.NumberArray.getNumbers;
import static numbers.PrintOutput.*;

public class Main {

    public static void main(String[] args) {
        long number;
        int consecutiveNumbers;
        ArrayList<String> properties;
        int numberOfInputs;
        int numberOfProperties;
        long[] numbers;

        printWelcomeMessage();
        printSupportedRequests();

        while (true) {
            number = -1;
            consecutiveNumbers = 0;
            properties = new ArrayList<>();
            numberOfInputs = 0;
            numberOfProperties = 0;

            System.out.print("Enter a request: ");
            Scanner userInput = new Scanner(new Scanner(System.in).nextLine());

            if (userInput.hasNextLong()) {
                number = userInput.nextLong();
                numberOfInputs++;
                if (userInput.hasNextInt()) {
                    consecutiveNumbers = userInput.nextInt();
                    numberOfInputs++;
                    while (userInput.hasNext() && numberOfProperties < NumberProperty.NUMBER_PROPERTIES.length){
                        properties.add(userInput.next().toLowerCase());
                        numberOfProperties++;
                        numberOfInputs++;
                    }
                }
            }

            if (isInputExit(number)) break;
            if (isInputInvalid(numberOfInputs, number, consecutiveNumbers, properties)) continue;

            switch (numberOfInputs) {
                case 1:
                    printNumberProperties(number);
                    break;
                case 2:
                    numbers = getNumbers(number, consecutiveNumbers);
                    printNumberProperties(numbers);
                    break;
                default:
                    numbers = getNumbers(number, consecutiveNumbers, properties);
                    printNumberProperties(numbers);
                    break;
            }
        }
    }
}