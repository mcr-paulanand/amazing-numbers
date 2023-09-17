package numbers;

import java.util.ArrayList;

class NumberArray {
    static long[] getNumbers(long number, int consecutiveNumbers) {
        long[] numbers = new long[consecutiveNumbers];

        for (int i = 0; i < consecutiveNumbers; i++) {
            numbers[i] = number + i;
        }
        return numbers;
    }

    static long[] getNumbers(long number, int consecutiveNumbers, ArrayList<String> properties) {
        long[] numbers = new long[consecutiveNumbers];

        try {
            for (int i = 0; i < consecutiveNumbers; ) {
                for (int p = 0; p < properties.size(); p++) {
                    if (!(boolean) NumberProperty.class.getDeclaredMethod(getNumberPropertyMethodName(properties.get(p)), long.class).invoke(null, number)) {
                        break;
                    }

                    if (p == properties.size() - 1) {
                        numbers[i] = number;
                        i++;
                    }
                }
                number++;
            }
        } catch (Exception ignored) {}
        return numbers;
    }

    private static String getNumberPropertyMethodName(String property) {
        StringBuilder methodName = new StringBuilder(property);
        methodName.setCharAt(0, Character.toUpperCase(property.charAt(0)));
        methodName.insert(0, "isNumber");
        return methodName.toString();
    }
}