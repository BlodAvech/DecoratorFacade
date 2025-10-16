package Application;

import java.util.Scanner;

public class InputValidator
{
    public static int getIntInput(Scanner scanner, int min, int max) {
        while (true) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();

                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.println("Введите число от " + min + " до " + max);
                }
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Неверный формат. Введите число от " + min + " до " + max);
            }
        }
    }
    public static float getFloatInput(Scanner scanner) {
        while (true) {
            try {
                float input = scanner.nextFloat();
                scanner.nextLine();
                return input;
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Неверный формат");
            }
        }
    }

    public static String getStringInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}
