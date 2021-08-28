package ru.academit.elena072021.vector;

import java.util.Arrays;

public class Vector {
    private double[] coordinates;

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

        coordinates = Arrays.copyOf(vector.coordinates, vector.coordinates.length);
    }

    // Конструктор c. Vector(double[]) – заполнение вектора значениями из массива
    public Vector(double[] array) {
        if (array == null) {
            throw new NullPointerException("The argument must not be = null");
        }

        if (array.length == 0) {
            throw new IllegalArgumentException("Length of array must not be = 0");
        }

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

        coordinates = Arrays.copyOf(array, size);
    }

    // Метод getSize() для получения размерности вектора
    public int getSize() {
        return coordinates.length;
    }

    // Метод toString(), чтобы выдавал информацию о векторе в формате { значения компонент через запятую }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");

        for (double coordinate : coordinates) {
            stringBuilder.append(", ");
            stringBuilder.append(coordinate);
        }

        stringBuilder.append("}");
        stringBuilder.delete(1, 3);

        return stringBuilder.toString();
    }

    // a. Прибавление к вектору другого вектора
    public void add(Vector vector) {
        if (vector == null) {
            throw new NullPointerException("The argument must not be = null");
        }

        if (coordinates.length < vector.coordinates.length) {
            coordinates = Arrays.copyOf(coordinates, vector.coordinates.length);
        }

        for (int i = 0; i < vector.coordinates.length; i++) {
            coordinates[i] += vector.coordinates[i];
        }
    }

    // b. Вычитание из вектора другого вектора
    public void subtract(Vector vector) {
        if (vector == null) {
            throw new NullPointerException("The argument must not be = null");
        }

        if (coordinates.length < vector.coordinates.length) {
            coordinates = Arrays.copyOf(coordinates, vector.coordinates.length);
        }

        for (int i = 0; i < vector.coordinates.length; i++) {
            coordinates[i] -= vector.coordinates[i];
        }
    }

    // c. Умножение вектора на скаляр
    public void multiplyByScalar(double multiplier) {
        for (int i = 0; i < coordinates.length; i++) {
            coordinates[i] *= multiplier;
        }
    }

    // d. Разворот вектора (умножение всех компонент на -1)
    public void reverse() {
        multiplyByScalar(-1);
    }

    // e. Получение длины вектора
    public double getLength() {
        double squaresSum = 0;

        for (double v : coordinates) {
            squaresSum += v * v;
        }

        return Math.sqrt(squaresSum);
    }

    // f. Получение компоненты вектора по индексу
    public double getCoordinate(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index (" + index + ") must be greater than or equal to zero");
        }

        if (index >= coordinates.length) {
            throw new IndexOutOfBoundsException("The index (" + index + ") must be less than " + coordinates.length);
        }

        return coordinates[index];
    }

    // f. Установка компоненты вектора по индексу
    public void setCoordinate(int index, double coordinate) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index (" + index + ") must be greater than or equal to zero");
        }

        if (index >= coordinates.length) {
            throw new IndexOutOfBoundsException("The index (" + index + ") must be less than " + coordinates.length);
        }

        coordinates[index] = coordinate;
    }

    // g. Переопределить метод equals, чтобы был true векторы имеют одинаковую размерность и соответствующие компоненты равны.
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        Vector vector = (Vector) o;

        if (coordinates.length != vector.coordinates.length) {
            return false;
        }

        for (int i = 0; i < coordinates.length; i++) {
            if (coordinates[i] != vector.coordinates[i]) {
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
    public static Vector getSum(Vector vector1, Vector vector2) {
        if (vector1 == null) {
            throw new NullPointerException("First argument shouldn't be = null");
        }

        if (vector2 == null) {
            throw new NullPointerException("Second argument shouldn't be = null");
        }

        Vector resultingVector = new Vector(vector1);
        resultingVector.add(vector2);

        return resultingVector;
    }

    // b. Вычитание векторов – должен создаваться новый вектор
    public static Vector getDifference(Vector vector1, Vector vector2) {
        if (vector1 == null) {
            throw new NullPointerException("First argument shouldn't be = null");
        }

        if (vector2 == null) {
            throw new NullPointerException("Second argument shouldn't be = null");
        }

        Vector resultingVector = new Vector(vector1);
        resultingVector.subtract(vector2);

        return resultingVector;
    }

    // c. Скалярное произведение векторов
    public static double getScalarProduct(Vector vector1, Vector vector2) {
        if (vector1 == null) {
            throw new NullPointerException("First argument shouldn't be = null");
        }

        if (vector2 == null) {
            throw new NullPointerException("Second argument shouldn't be = null");
        }

        int minSize = Math.min(vector1.coordinates.length, vector2.coordinates.length);
        double scalarProduct = 0;

        for (int i = 0; i < minSize; i++) {
            scalarProduct += vector1.coordinates[i] * vector2.coordinates[i];
        }

        return scalarProduct;
    }
}