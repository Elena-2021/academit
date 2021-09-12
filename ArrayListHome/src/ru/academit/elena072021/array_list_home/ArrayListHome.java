package ru.academit.elena072021.array_list_home;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListHome {
    public static void main(String[] args) throws IOException {
        String file = "array_list_home.txt";
        ArrayList<String> fileStringList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String stringFromFile;

            while ((stringFromFile = reader.readLine()) != null) {
                fileStringList.add(stringFromFile);
            }

            System.out.println("Список строк из файла: " + fileStringList);
        } catch (FileNotFoundException e) {
            System.out.println("File " + file + " not found.");
        } catch (IOException e) {
            System.out.println("No data received from the file" + file);
        }

        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(2, 4, 9, 3, 4, 0, 23, 8));
        System.out.println("Список целых чисел: " + arrayList1);

        for (int i = 0; i < arrayList1.size(); i++) {
            if (arrayList1.get(i) % 2 == 0) {
                arrayList1.remove(i);
                i--;
            }
        }

        System.out.println("Список без четных чисел: " + arrayList1);

        ArrayList<Integer> arrayList2 = new ArrayList<>(Arrays.asList(1, 1, 1, 0, 10, 4, 5, 9, 4, 10, 7, 11, 11, 12));
        System.out.println("Список с повторяющимися числами: " + arrayList2);

        if (arrayList2 == null) {
            System.out.println("Нет списка с повторяющимися числами");
        } else {
            ArrayList<Integer> noRepeatingIntegersList = new ArrayList<>(arrayList2.size());

            for (Integer e : arrayList2) {
                if (!noRepeatingIntegersList.contains(e)) {
                    noRepeatingIntegersList.add(e);
                }
            }

            System.out.println("Список целых чисел без повторений: " + noRepeatingIntegersList);
        }
    }
}