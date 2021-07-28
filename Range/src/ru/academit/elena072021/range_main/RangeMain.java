package ru.academit.elena072021.range_main;

import ru.academit.elena072021.range.Range;

import java.util.Scanner;

public class RangeMain {
    public static void printArray(Range[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }

            System.out.print(array[i]);
        }

        System.out.println("]");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите координату начала диапазона: ");
        double from = scanner.nextDouble();

        System.out.print("Введите координату конца диапазона: ");
        double to = scanner.nextDouble();

        Range range1 = new Range(from, to);
        System.out.println("Длина диапазона = " + range1.getLength());

        System.out.print("Введите произвольное число для проверки на попадание в диапазон: ");
        double enteredNumber = scanner.nextDouble();

        if (range1.isInside(enteredNumber)) {
            System.out.println("Введенное число " + enteredNumber + " находится в заданном диапазоне.");
        } else {
            System.out.println("Введенное число " + enteredNumber + " не находится в заданном диапазоне.");
        }

        System.out.println();
        System.out.println("Теперь необходимы координаты двух диапазонов");
        System.out.print("Введите координату начала первого диапазона: ");
        double from1 = scanner.nextDouble();

        System.out.print("Введите координату конца первого диапазона: ");
        double to1 = scanner.nextDouble();

        System.out.print("Введите координату начала второго диапазона: ");
        double from2 = scanner.nextDouble();

        System.out.print("Введите координату конца второго диапазона: ");
        double to2 = scanner.nextDouble();

        Range range2 = new Range(from1, to1);
        Range range3 = new Range(from2, to2);

        System.out.println("Пересечение диапазонов = " + range2.getIntersection(range3));

        System.out.print("Объединение диапазонов = ");
        printArray(range2.getUnion(range3));

        System.out.print("Разность диапазонов = ");
        printArray(range2.getDifference(range3));
    }
}