package ru.academit.elena072021.arraylisthome;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListHome {
    public static void main(String[] args) throws IOException {
        String file = "array_list_home.txt";
        ArrayList<String> listFromFile = new ArrayList<>();
        String stringFromFile;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((stringFromFile = reader.readLine()) != null) {
                listFromFile.add(stringFromFile);
            }
            System.out.println("Список строк из файла: " + listFromFile);
        } catch (FileNotFoundException e) {
            System.out.println("File " + file + " not found.");
        }

        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(2, 4, 9, 3, 4, 0, 23, 8));
        System.out.println("Список целых чисел: " + arrayList1);

        int i = 0;

        while (i < arrayList1.size()) {
            if (arrayList1.get(i) % 2 == 0) {
                arrayList1.remove(i);
            } else {
                i++;
            }
        }

        System.out.println("Список целых чисел без четных чисел: " + arrayList1);

        ArrayList<Integer> arrayList2 = new ArrayList<>(Arrays.asList(1, 1, 1, 0, 10, 4, 5, 9, 4, 10, 7, 11, 11, 12));
        System.out.println("Список целых чисел с повторяющимися числами: " + arrayList2);

        ArrayList<Integer> integersList = new ArrayList<>(arrayList2.size());
        integersList.add(arrayList2.get(0));

        for (int j = 1; j <= arrayList2.size(); j++) {
            boolean hasInteger = integersList.contains(arrayList2.get(j - 1));

            if (!hasInteger) {
                integersList.add(arrayList2.get(j - 1));
            }
        }

        System.out.println("Список целых чисел без повторений: " + integersList);
    }
}