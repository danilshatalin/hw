import java.util.Scanner;

public class UserInput {
    public static float getFloatInput() {
        Scanner scanner = new Scanner(System.in);
        float result = 0.0f;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Введите дробное число: ");
            if (scanner.hasNextFloat()) {
                result = scanner.nextFloat();
                validInput = true;
            } else {
                System.out.println("Некорректный ввод! Пожалуйста, введите дробное число.");
                scanner.next(); // Сбросить некорректный ввод перед повторным запросом
            }
        }

        return result;
    }

    public static void main(String[] args) {
        float userInput = getFloatInput();
        System.out.println("Вы ввели число: " + userInput);
    }
}
