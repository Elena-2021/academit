import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayListHome {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        try (Scanner scanner = new Scanner(new FileInputStream("array_list_home.txt"))) {
            ArrayList<String> arrayListHome = new ArrayList<>();

            while (scanner.hasNextLine()) {
                arrayListHome.add(scanner.nextLine());
            }

            System.out.println(arrayListHome);
        }

        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(2, 4, 9, 3, 4, 0, 23, 8));
        System.out.println(arrayList1);

        int i = 0;

        while (i < arrayList1.size()) {
            if (arrayList1.get(i) % 2 == 0) {
                arrayList1.remove(i);
            } else i++;
        }

        System.out.println(arrayList1);

        ArrayList<Integer> arrayList2 = new ArrayList<>(Arrays.asList(1, 1, 1, 0, 10, 4, 5, 9, 4, 10, 7, 11, 11));
        System.out.println(arrayList2);

        ArrayList<Integer> arrayList3 = new ArrayList<>();

        arrayList3.addAll(arrayList2);

        for (int k = 0; k < arrayList3.size(); k++) {
            int n = k + 1;

            while (n < arrayList3.size()) {
                if (arrayList3.get(k).equals(arrayList3.get(n))) {
                    arrayList3.remove(n);
                } else n++;
            }
        }

        System.out.println(arrayList3);
    }
}