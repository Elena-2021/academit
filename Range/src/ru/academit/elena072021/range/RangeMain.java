package ru.academit.elena072021.range;

import java.util.Scanner;

public class RangeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите координату начала диапазона: ");
        double rangeStart = scanner.nextDouble();

        System.out.print("Введите координату конца диапазона: ");
        double rangeEnd = scanner.nextDouble();

        Range range = new Range(rangeStart, rangeEnd);
        System.out.println("Длина диапазона = " + range.getLength());

        System.out.print("Введите произвольное число для проверки на попадание в диапазон: ");
        double enteredNumber = scanner.nextDouble();

        if (range.isInside(enteredNumber)) {
            System.out.println("Введенное число " + enteredNumber + " находится в заданном диапазоне.");
        } else {
            System.out.println("Введенное число " + enteredNumber + " не находится в заданном диапазоне.");
        }
    }
}