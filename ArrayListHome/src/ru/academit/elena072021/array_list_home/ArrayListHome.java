package ru.academit.elena072021.array_list_home;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListHome {
    public static void main(String[] args) {
        String file = "array_list_home.txt";
        ArrayList<String> fileStringsList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String stringFromFile;

            while ((stringFromFile = reader.readLine()) != null) {
                fileStringsList.add(stringFromFile);
            }

            System.out.println("Список строк из файла: " + fileStringsList);
        } catch (FileNotFoundException e) {
            System.out.println("Файл " + file + " не найден.");
        } catch (IOException e) {
            System.out.println("Нет данных из файла" + file);
        }

        ArrayList<Integer> integersList = new ArrayList<>(Arrays.asList(2, 4, 9, 3, 4, 0, 23, 8));
        System.out.println("Список целых чисел: " + integersList);

        for (int i = 0; i < integersList.size(); i++) {
            if (integersList.get(i) % 2 == 0) {
                integersList.remove(i);
                i--;
            }
        }

        System.out.println("Список без четных чисел: " + integersList);

        ArrayList<Integer> repeatedIntegersList = new ArrayList<>(Arrays.asList(1, 1, 1, 0, 10, 4, 5, 9, 4, 10, 7, 11, 11, 12));
        System.out.println("Список с повторяющимися числами: " + repeatedIntegersList);

        ArrayList<Integer> noRepeatingIntegersList = new ArrayList<>(repeatedIntegersList.size());

        if (repeatedIntegersList.size() == 0) {
            System.out.println("Список с повторяющимися числами пустой");
        } else {
            for (Integer e : repeatedIntegersList) {
                if (!noRepeatingIntegersList.contains(e)) {
                    noRepeatingIntegersList.add(e);
                }
            }

            System.out.println("Список целых чисел без повторений: " + noRepeatingIntegersList);
        }
    }
}