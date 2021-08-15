package ru.academit.elena072021.vector;

import java.util.Arrays;

public class Vector {
    private final double[] coordinates;

    // Конструктор a. Vector(n) – размерность n, все компоненты равны 0
    public Vector(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size (" + size + ") must be > 0");
        }

        coordinates = new double[size];
    }

    // Конструктор b. Vector(Vector) – конструктор копирования
    public Vector(Vector vector) {
        if (vector == null) {
            throw new NullPointerException("The argument must not be = null");
        }

        if (vector.coordinates.length == 0) {
            throw new IllegalArgumentException("Length of Vector must not be = 0");
        }

        coordinates = new double[vector.coordinates.length];

        System.arraycopy(vector.coordinates, 0, coordinates, 0, vector.coordinates.length);
    }

    // Конструктор c. Vector(double[]) – заполнение вектора значениями из массива
    public Vector(double[] array) {
        if (array == null) {
            throw new NullPointerException("The argument must not be = null");
        }

        if (array.length == 0) {
            throw new IllegalArgumentException("Length of array must not be = 0");
        }

        double[] coordinates = new double[array.length];
        coordinates = Arrays.copyOf(array, array.length);
    }

    // Конструктор d. Vector(n, double[]) – заполнение вектора значениями из массива. Если длина массива меньше n, то считать что в остальных компонентах 0
    public Vector(int size, double[] array) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size  (" + size + ") must be > 0");
        }

        if (array == null) {
            throw new NullPointerException("The argument must not be = null");
        }

        coordinates = new double[size];
        System.arraycopy(array, 0, coordinates, 0, Math.min(size, array.length));
    }

    // Метод getSize() для получения размерности вектора
    public int getSize() {
        return coordinates.length;
    }

    // Метод toString(), чтобы выдавал информацию о векторе в формате { значения компонент через запятую }
    @Override
    public String toString() {
        String string = Arrays.toString(coordinates);
        return "{" + string.substring(1, string.length() - 1) + "}";
    }

    // a. Прибавление к вектору другого вектора
    public void addition(Vector vector) {
        if (vector == null) {
            throw new NullPointerException("The argument must not be = null");
        }

        if (coordinates.length < vector.coordinates.length) {
            throw new IllegalArgumentException("Vector2  (" + coordinates.length + ")  must not be longer than vector1  (" + vector.coordinates.length + ") ");
        }

        int size = Math.min(coordinates.length, vector.coordinates.length);

        for (int i = 0; i < size; i++) {
            coordinates[i] = coordinates[i] + vector.coordinates[i];
        }
    }

    // b. Вычитание из вектора другого вектора
    public void subtraction(Vector vector) {
        if (vector == null) {
            throw new NullPointerException("The argument must not be = null");
        }

        if (coordinates.length < vector.coordinates.length) {
            throw new IllegalArgumentException("Vector2  (" + vector.coordinates.length + ")  must not be longer than vector1   (" + coordinates.length + ")  ");
        }

        int size = Math.min(coordinates.length, vector.coordinates.length);

        for (int i = 0; i < size; i++) {
            coordinates[i] = coordinates[i] - vector.coordinates[i];
        }
    }

    // c. Умножение вектора на скаляр
    public void multiplicationByScalar(double multiplier) {
        for (int i = 0; i < coordinates.length; i++) {
            coordinates[i] *= multiplier;
        }
    }

    // d. Разворот вектора (умножение всех компонент на -1)
    public void reversal() {
        multiplicationByScalar(-1);
    }

    // e. Получение длины вектора
    public double getVectorLength() {
        double temp = 0;

        for (double v : coordinates) {
            temp += v * v;
        }

        return Math.sqrt(temp);
    }

    // f. Получение компоненты вектора по индексу
    public double getVectorComponent(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index must be >= 0");
        }

        if (index >= coordinates.length) {
            throw new IllegalArgumentException("Index must be <= length of vector");
        }

        return coordinates[index];
    }

    // f. Установка компоненты вектора по индексу
    public void setVectorComponent(double component, int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index must be >= 0");
        }

        if (index >= coordinates.length) {
            throw new IllegalArgumentException("Index must be <= length of vector");
        }

        coordinates[index] = component;
    }

    // g. Переопределить метод equals, чтобы был true векторы имеют одинаковую размерность и соответствующие компоненты равны.
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            throw new NullPointerException("The argument shouldn't be = null");
        }

        if (this.getClass() != o.getClass()) {
            throw new IllegalArgumentException("The argument is not an instance of the Vector class");
        }

        if (coordinates.length != ((Vector) o).coordinates.length) {
            return false;
        }

        for (double coordinate : coordinates) {
            if (coordinate != ((Vector) o).coordinates.length) {
                return false;
            }
        }

        return true;
    }

    // g. Соответственно, переопределить hashCode
    @Override
    public int hashCode() {

        return Arrays.hashCode(coordinates);
    }

    // a. Сложение двух векторов – должен создаваться новый вектор
    public static Vector getAddition(Vector vector1, Vector vector2) {
        if (vector1 == null || vector2 == null) {
            throw new NullPointerException("The argument shouldn't be = null");
        }

        int size = Math.max(vector1.coordinates.length, vector2.coordinates.length);
        Vector vector = new Vector(size);

        for (int i = 0; i < size; i++) {
            double component = 0;

            if (i < vector1.coordinates.length) {
                component = vector1.coordinates[i];
            }

            if (i < vector2.coordinates.length) {
                component += vector2.coordinates[i];
            }

            vector.setVectorComponent(component, i);
        }

        return vector;
    }

    // b. Вычитание векторов – должен создаваться новый вектор
    public static Vector getSubtraction(Vector vector1, Vector vector2) {
        if (vector1 == null || vector2 == null) {
            throw new NullPointerException("The argument shouldn't be = null");
        }

        int size = Math.max(vector1.coordinates.length, vector2.coordinates.length);
        Vector vector = new Vector(size);

        for (int i = 0; i < size; i++) {
            double temp = 0;

            if (i < vector1.coordinates.length) {
                temp = vector1.coordinates[i];
            }

            if (i < vector2.coordinates.length) {
                temp -= vector2.coordinates[i];
            }

            vector.setVectorComponent(temp, i);
        }

        return vector;
    }

    // c. Скалярное произведение векторов
    public static double getScalarVectorsProduct(Vector vector1, Vector vector2) {
        if (vector1 == null || vector2 == null) {
            throw new NullPointerException("The argument shouldn't be = null");
        }

        int size = Math.min(vector1.coordinates.length, vector2.coordinates.length);
        double temp = 0;

        for (int i = 0; i < size; i++) {
            temp += vector1.coordinates[i] * vector2.coordinates[i];
        }

        return temp;
    }
}