package numbers;

import java.lang.reflect.Method;
import java.util.ArrayList;

class NumberArray {
    static long[] getNumbers(long number, int consecutiveNumbers) {
        long[] numbers = new long[consecutiveNumbers];

        for (int i = 0; i < consecutiveNumbers; i++) {
            numbers[i] = number + i;
        }
        return numbers;
    }

    static long[] getNumbers(long number, int consecutiveNumbers, String property) {
        long[] numbers = new long[consecutiveNumbers];

        try {
            Method method = NumberProperty.class.getDeclaredMethod(getNumberPropertyMethodName(property), long.class);

            for (int i = 0; i < consecutiveNumbers; ) {
                if ((boolean) method.invoke(null, number)) {
                    numbers[i] = number;
                    i++;
                }
                number++;
            }
        } catch (Exception ignored) {}
        return numbers;
    }

    static long[] getNumbers(long number, int consecutiveNumbers, String[] properties) {
        long[] numbers = new long[consecutiveNumbers];

        try {
            Method method0 = NumberProperty.class.getDeclaredMethod(getNumberPropertyMethodName(properties[0]), long.class);
            Method method1 = NumberProperty.class.getDeclaredMethod(getNumberPropertyMethodName(properties[1]), long.class);

            for (int i = 0; i < consecutiveNumbers; ) {
                if ((boolean) method0.invoke(null, number) && (boolean) method1.invoke(null, number)) {
                    numbers[i] = number;
                    i++;
                }
                number++;
            }
        } catch (Exception ignored) {}
        return numbers;
    }

    static long[] getNumbers(long number, int consecutiveNumbers, ArrayList<String> properties) {
        long[] numbers = new long[consecutiveNumbers];

        try {
            for (int i = 0; i < consecutiveNumbers; ) {
                for (String property : properties) {
                    if (!(boolean) NumberProperty.class.getDeclaredMethod(getNumberPropertyMethodName(property), long.class).invoke(null, number)) {
                        break;
                    }
                    numbers[i] = number;
                    i++;
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