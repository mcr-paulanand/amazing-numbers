package numbers;

final class NumberProperty {

    static final String[] NUMBER_PROPERTIES = {"even", "odd", "buzz", "duck", "palindromic", "gapful", "spy", "sunny", "square", "jumping"};
    static final String[][] EXCLUSIVE_PROPERTIES = { {"even", "odd"}, {"duck", "spy"}, {"square", "sunny"} };

    static boolean isNumberEven(long number) {
        return number % 2 == 0;
    }

    static boolean isNumberOdd(long number) {
        return number % 2 != 0;
    }

    static boolean isNumberBuzz(long number) {
        return number % 7 == 0 || number % 10 == 7;
    }

    static boolean isNumberDuck(long number) {
        return Long.toString(number).contains("0");
    }

    static boolean isNumberPalindromic(long number) {
        long reverseNumber = 0;
        long tempOriginal = number;

        while (tempOriginal > 0) {
            long lastDigit = tempOriginal % 10;
            reverseNumber = reverseNumber * 10 + lastDigit;
            tempOriginal = tempOriginal / 10;
        }

        return number == reverseNumber;
    }

    static boolean isNumberGapful(long number) {
        String numberString = Long.toString(number);
        if (numberString.length() > 2) {
            int firstDigit = Character.getNumericValue(numberString.charAt(0));
            int lastDigit = (int) (number % 10);
            int divideNumber = firstDigit * 10 + lastDigit;

            return number % divideNumber == 0;
        }
        return false;
    }

    static boolean isNumberSpy(long number) {
        long sum = 0;
        long product = 1;

        char[] digits = Long.toString(number).toCharArray();

        for (char digit : digits) {
            sum += Integer.parseInt(Character.toString(digit));
            product *= Integer.parseInt(Character.toString(digit));
        }

        return sum == product;
    }

    static boolean isNumberSunny(long number) {
        return Math.sqrt(number + 1) % 1 == 0;
    }

    static boolean isNumberSquare(long number) {
        return Math.sqrt(number) % 1 == 0;
    }

    static boolean isNumberJumping(long number) {
        int[] digits = Long.toString(number).chars().map(c -> c-'0').toArray();

        for (int i = 1; i < digits.length; i++) {
            if (Math.abs(digits[i]-digits[i - 1]) != 1) return false;
        }
        return true;
    }
}