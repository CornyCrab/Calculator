import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine();
        try {
            String result = calc(input);
            System.out.println("Output:");
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Output:");
            System.out.println("throws Exception");
        }
    }

    public static String calc(String input) throws Exception {
        String[] parts = input.split(" ");
        if (parts.length != 3) {
            throw new Exception();
        }

        }
        String num1 = parts[0];
        String operator = parts[1];
        String num2 = parts[2];

        }
        boolean isRoman = isRoman(num1) && isRoman(num2);
        boolean isArabic = isArabic(num1) && isArabic(num2);

        if (isRoman) {
            int intNum1 = romanToArabic(num1);
            int intNum2 = romanToArabic(num2);
            int result = calculate(intNum1, intNum2, operator);
            if (result < 1) {
                throw new Exception();
            }
            return arabicToRoman(result);
        } else if (isArabic) {
            int intNum1 = Integer.parseInt(num1);
            int intNum2 = Integer.parseInt(num2);
            int result = calculate(intNum1, intNum2, operator);
            return Integer.toString(result);
        } else {
            throw new Exception();
        }
    }

    private static boolean isRoman(String num) {
        try {
            romanToArabic(num);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean isArabic(String num) {
        try {
            int value = Integer.parseInt(num);
            return value >= 1 && value <= 10;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int romanToArabic(String roman) throws Exception {
        switch (roman) {
            case "I": return 1;
            case "II": return 2;
            case "III": return 3;
            case "IV": return 4;
            case "V": return 5;
            case "VI": return 6;
            case "VII": return 7;
            case "VIII": return 8;
            case "IX": return 9;
            case "X": return 10;
            default: throw new Exception();
        }
    }

    private static String arabicToRoman(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("Римские числа не могут быть меньше 1");
        }
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        return roman[number];
    }

            String result = processExpression(input);
            // Обрезаем результат, если нужно
            result = truncateIfNecessary(result);
            System.out.println("Результат: \"" + result + "\"");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
    private static int calculate(int num1, int num2, String operator) throws Exception {
        switch (operator) {
            case "+": return num1 + num2;
            case "-": return num1 - num2;
            case "*": return num1 * num2;
            case "/": return num1 / num2;
            default: throw new Exception();
        }
    }
}
