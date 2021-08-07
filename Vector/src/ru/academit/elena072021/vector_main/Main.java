package ru.academit.elena072021.vector_main;

import ru.academit.elena072021.vector.Vector;

public class Main {
    public static void main(String[] args) {
        try {
            Vector vector1 = new Vector(10);
            System.out.println("vector1 = " + vector1);

            Vector vector2 = new Vector(new double[]{0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0});
            System.out.println("vector2 = " + vector2);

            Vector vector3 = new Vector(vector2);
            System.out.println("vector3 = " + vector3);

            Vector vector4 = new Vector(15, new double[]{10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0, 17.0, 18.0, 19.0});
            System.out.println("vector4 = " + vector4);

            Vector vector5 = Vector.getAddition(vector4, vector2);
            System.out.println("vector5 = " + vector5);

            Vector vector6 = Vector.getSubtraction(vector2, vector4);
            System.out.println("vector6 = " + vector6);

            System.out.println("Проверка на равенство vector1 и vector2 = " + vector1.equals(vector2));

            System.out.println("Сравнение hashCode у vector2 и vector3: " + vector2.hashCode() + " и " + vector3.hashCode());

            System.out.println("Сравнение hashCode у vector1 и vector2: " + vector1.hashCode() + " и " + vector2.hashCode());

            System.out.println("Скалярное произведение векторов: vector5 и vector6 = " + Vector.getScalarVectorsProduct(vector5, vector6));

            vector2.getVectorMultiplicationByScalar(3);
            System.out.println("vector2 = " + vector2);

            Vector vector7 = null;
            Vector vector8 = new Vector(vector7);

            Vector vector9 = new Vector(new double[]{1.0, 1.0, 1.0, 1.0});
            System.out.println("vector9 = " + vector9);

        } catch (IllegalArgumentException e1) {
            System.out.println();
            e1.printStackTrace();
        }
    }
}