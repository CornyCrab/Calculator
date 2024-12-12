
import java.util.Scanner;

public class StringCalculator {

    public static String processExpression(String expression) {
        // Убираем пробелы
        expression = expression.replace(" ", "");

        // Проверка на операцию сложения строк
        if (expression.contains("+")) {
            String[] parts = expression.split("\\+");
            if (parts.length == 2 && isValidString(parts[0]) && isValidString(parts[1])) {
                // Убираем кавычки и выполняем сложение
                return parts[0].substring(1, parts[0].length() - 1) + parts[1].substring(1, parts[1].length() - 1);
            } else {
                throw new IllegalArgumentException("Некорректный формат для операции сложения.");
            }
        }

        // Проверка на операцию вычитания строк
        else if (expression.contains("-")) {
            String[] parts = expression.split("-");
            if (parts.length == 2 && isValidString(parts[0]) && isValidString(parts[1])) {
                // Убираем кавычки и выполняем вычитание
                return parts[0].substring(1, parts[0].length() - 1).replace(parts[1].substring(1, parts[1].length() - 1), "");
            } else {
                throw new IllegalArgumentException("Некорректный формат для операции вычитания.");
            }
        }

        // Проверка на операцию умножения строки на число
        else if (expression.contains("*")) {
            String[] parts = expression.split("\\*");
            if (parts.length == 2 && isValidString(parts[0]) && isValidNumber(parts[1])) {
                // Убираем кавычки и выполняем умножение
                int times = Integer.parseInt(parts[1]);
                String str = parts[0].substring(1, parts[0].length() - 1);
                return str.repeat(times);
            } else {
                throw new IllegalArgumentException("Некорректный формат для умножения строки на число.");
            }
        }

        // Проверка на операцию деления строки на число
        else if (expression.contains("/")) {
            String[] parts = expression.split("/");
            if (parts.length == 2 && isValidString(parts[0]) && isValidNumber(parts[1])) {
                // Убираем кавычки и выполняем деление
                int divisor = Integer.parseInt(parts[1]);
                if (divisor <= 0) {
                    throw new IllegalArgumentException("Число для деления должно быть больше 0.");
                }
                String str = parts[0].substring(1, parts[0].length() - 1);
                return str.length() > divisor ? str.substring(0, str.length() / divisor) : str;
            } else {
                throw new IllegalArgumentException("Некорректный формат для деления строки на число.");
            }
        }

        // Если операция не поддерживается
        else {
            throw new IllegalArgumentException("Недопустимая операция.");
        }
    }

    // Проверка, является ли строка корректной
    private static boolean isValidString(String str) {
        return str.startsWith("\"") && str.endsWith("\"") && str.length() <= 12;
    }

    // Проверка, является ли строка корректным числом от 1 до 10
    private static boolean isValidNumber(String str) {
        try {
            int num = Integer.parseInt(str);
            return num >= 1 && num <= 10;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Функция для обрезки строки до 40 символов
    private static String truncateIfNecessary(String result) {
        if (result.length() > 40) {
            return result.substring(0, 40) + "...";
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение (например, \"100\" + \"500\"): ");
        String input = scanner.nextLine();


        try {
            String result = processExpression(input);
            // Обрезаем результат, если нужно
            result = truncateIfNecessary(result);
            System.out.println("Результат: \"" + result + "\"");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}