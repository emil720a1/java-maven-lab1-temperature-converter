package org.example;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Scanner scanner = new Scanner(
                System.in,
                StandardCharsets.UTF_8
        );

        scanner.useLocale(Locale.US);

        TemperatureConverter converter = new TemperatureConverter();

        System.out.println("=== Конвертер температури ===");

        while (true) {
            printUnits();

            int fromChoice = readMenuChoice(
                    scanner,
                    "Оберіть початкову одиницю або 0 для виходу: ",
                    0,
                    3
            );

            if (fromChoice == 0) {
                System.out.println("Вихід. Дякуємо за використання!");
                break;
            }

            TemperatureUnit fromUnit = convertChoiceToUnit(fromChoice);

            double value = readDouble(
                    scanner,
                    "Введіть значення: "
            );

            if (!converter.isValid(value, fromUnit)) {
                System.out.println(
                        "Помилка: температура не можу бути нижчою за абсолютний нуль."
                );
                continue;
            }

            printUnits();

            int toChoice = readMenuChoice(
                    scanner,
                    "Введіть значення: ",
                    1,
                    3
            );

            TemperatureUnit toUnit = convertChoiceToUnit(toChoice);

            double result = converter.convert(
                    value,
                    fromUnit,
                    toUnit
            );

            System.out.printf(
                    Locale.US,
                    "%.2f %s = %.2f %s%n%n",
                    value,
                    fromUnit.getSymbol(),
                    result,
                    toUnit.getSymbol()
            );
        }
    }

    private static void printUnits() {
        System.out.println();
        System.out.println("1) Цельсій °C");
        System.out.println("2) Фаренгейт °F");
        System.out.println("3) Кельвін K");
    }

    private static int readMenuChoice(
            Scanner scanner,
            String message,
            int min,
            int max
    ) {
        while (true) {
            System.out.print(message);

            if (!scanner.hasNextInt()) {
                System.out.println("Помилка: введіть ціле число.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();

            if (choice < min || choice > max) {
                System.out.println("Помилка: такого пункту меню немає.");
                continue;
            }

            return choice;
        }
    }

    private static double readDouble(
            Scanner scanner,
            String message
    ) {
        while (true) {
            System.out.print(message);

            if (!scanner.hasNextDouble()) {
                System.out.println("Помилка: введіть число.");
                scanner.next();
                continue;
            }

            return scanner.nextDouble();
        }
    }

    private static TemperatureUnit convertChoiceToUnit(int choice) {
        return switch (choice) {
            case 1 -> TemperatureUnit.CELSIUS;
            case 2 -> TemperatureUnit.FAHRENHEIT;
            case 3 -> TemperatureUnit.KELVIN;
            default -> null;
        };
    }
}
