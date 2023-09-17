package numbers;

import static numbers.NumberProperty.*;

final class PrintOutput {
    static void printWelcomeMessage() {
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println();
    }

    static void printSupportedRequests() {
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("  * the first parameter represents a starting number;");
        System.out.println("  * the second parameter shows how many consecutive numbers are to be processed;");
        System.out.println("- two natural numbers and a property to search for;");
        System.out.println("- two natural numbers and two properties to search for;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.");
        System.out.println();
    }

    static void printNumberProperties(long number) {
        System.out.println("Properties of " + number);
        System.out.println("        even: " + isNumberEven(number));
        System.out.println("         odd: " + isNumberOdd(number));
        System.out.println("        buzz: " + isNumberBuzz(number));
        System.out.println("        duck: " + isNumberDuck(number));
        System.out.println(" palindromic: " + isNumberPalindromic(number));
        System.out.println("      gapful: " + isNumberGapful(number));
        System.out.println("         spy: " + isNumberSpy(number));
        System.out.println("       sunny: " + isNumberSunny(number));
        System.out.println("      square: " + isNumberSquare(number));
        System.out.println("     jumping: " + isNumberJumping(number));
        System.out.println();
    }

    static void printNumberProperties(long[] numbers) {
        for (long number : numbers) {
            System.out.print(number + " is");
            System.out.print(isNumberEven(number) ? " even" : "");
            System.out.print(isNumberOdd(number) ? " odd" : "");
            System.out.print(isNumberBuzz(number) ? ", buzz" : "");
            System.out.print(isNumberDuck(number) ? ", duck" : "");
            System.out.print(isNumberPalindromic(number) ? ", palindromic" : "");
            System.out.print(isNumberGapful(number) ? ", gapful" : "");
            System.out.print(isNumberSpy(number) ? ", spy" : "");
            System.out.print(isNumberSunny(number) ? ", sunny" : "");
            System.out.print(isNumberSquare(number) ? ", square" : "");
            System.out.print(isNumberJumping(number) ? ", jumping" : "");
            System.out.println();
        }
        System.out.println();
    }
}