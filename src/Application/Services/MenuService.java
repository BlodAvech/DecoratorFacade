package Application.Services;

import Application.Application;
import Application.InputValidator;
import Application.Enums.MenuOption;

import java.util.Scanner;

public class MenuService {

    public MenuOption displayMainMenu(Scanner scanner) {
        System.out.println("\n=== Главное меню ===");
        System.out.println("1. Список Источников света");
        System.out.println("2. Проигрыватель");
        System.out.println("3. Термостат");
        System.out.println("4. Камеры Видеонаблюдения");
        System.out.println("5. Режимы дома");
        System.out.println("6. Выйти");
        System.out.print("Выберите опцию: ");

        int choice = InputValidator.getIntInput(scanner, 1, 6);
        return MenuOption.fromValue(choice);
    }
}

