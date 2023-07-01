//Реализовать простой калькулятор,  добавить логер.

import jdk.jfr.Recording;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class Calkulator {
    public static void main(String[] args) throws IOException {
        Logger LOGGER = Logger.getLogger(Calkulator.class.getName());
        // Создаем файловый обработчик
        FileHandler fileHandler = new FileHandler("Lesson2Log.txt", false);
        // Добавляем обработчик к логгеру
        LOGGER.addHandler(fileHandler);

        // Начинаем запись событий
        Recording recording = new Recording();
        recording.start();
        int x, y;
        char op;
        double res = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.print("введите х= ");
        x = scanner.nextInt();
        System.out.print("введите y= ");
        y = scanner.nextInt();
        System.out.print("\nвведите оператор (+, -, *, /): ");
        op = scanner.next().charAt(0);
        scanner.close();
        calculation(x, y, res, op);
    }

    public static void calculation(int x, int y, double res, char op) {
        if (op == '+') {
            res = x + y;
        }
        if (op == '-') {
            res = x - y;
        }
        if (op == '*') {
            res = x * y;
        }
        if (op == '/') {
            res = (double) x / y;
        }
        System.out.printf(x + " " + op + " " + y + " = " + res);
    }
}







