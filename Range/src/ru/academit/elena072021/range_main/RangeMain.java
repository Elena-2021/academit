package ru.academit.elena072021.range_main;

import ru.academit.elena072021.range.Range;

import java.util.Scanner;

public class RangeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите координату начала диапазона: ");
        double from = scanner.nextDouble();

        System.out.print("Введите координату конца диапазона: ");
        double to = scanner.nextDouble();

        Range range = new Range(from, to);
        System.out.println("Длина диапазона = " + range.getLength());

        System.out.print("Введите произвольное число для проверки на попадание в диапазон: ");
        double enteredNumber = scanner.nextDouble();

        if (range.isInside(enteredNumber)) {
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

        Range range1 = new Range(from1, to1);
        Range range2 = new Range(from2, to2);

        Range range3 = null;
        range3 = range1.getIntersection(range2);

        if (range3 == null) {
            System.out.println("Пересечения диапазонов нет");
        } else {
            System.out.println("Пересечение диапазонов = от " + range3.getFrom() + " до " + range3.getTo());
        }

        Range[] array = null;
        array = range1.getIntegration(range2);

        System.out.print("Объедиение диапазонов =");

        for (Range e : array) {
            System.out.print(" от " + e.getFrom() + " до " + e.getTo());
        }

        array = range1.getDifference(range2);

        if ((from2 < from1 && to2 > to1)) {
            System.out.println();
            System.out.println("Разность диапазонов = 0");
        } else {
            System.out.println();
            System.out.print("Разность диапазонов =");

            for (Range e : array) {
                System.out.print(" от " + e.getFrom() + " до " + e.getTo());
            }
        }
    }
}