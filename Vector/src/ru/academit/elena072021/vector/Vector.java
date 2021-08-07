package ru.academit.elena072021.vector;

import java.util.Arrays;

public class Vector {
    private final double[] vector;

    // Конструктор a. Vector(n) – размерность n, все компоненты равны 0
    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be > 0");
        }

        this.vector = new double[n];
    }

    // Конструктор b. Vector(Vector) – конструктор копирования
    public Vector(Vector vector2) {
        if (vector2 == null) {
            throw new IllegalArgumentException("argument must not be = null");
        }

        this.vector = new double[vector2.getSize()];

        for (int i = 0; i < vector2.getSize(); i++) {
            this.vector[i] = vector2.getVectorComponent(i);
        }
    }

    // Конструктор c. Vector(double[]) – заполнение вектора значениями из массива
    public Vector(double[] array) {
        if (array == null) {
            throw new IllegalArgumentException("argument must not be = null");
        }

        this.vector = new double[array.length];
        System.arraycopy(array, 0, this.vector, 0, array.length);
    }

    // Конструктор d. Vector(n, double[]) – заполнение вектора значениями из массива. Если длина массива меньше n, то считать что в остальных компонентах 0
    public Vector(int n, double[] array) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be > 0");
        }

        if (array == null) {
            throw new IllegalArgumentException("argument must not be = null");
        }

        this.vector = new double[n];
        System.arraycopy(array, 0, vector, 0, Math.min(n, array.length));
    }

    // Метод getSize() для получения размерности вектора
    public int getSize() {
        return vector.length;
    }

    // Метод toString(), чтобы выдавал информацию о векторе в формате { значения компонент через запятую }
    @Override
    public String toString() {
        String string = Arrays.toString(vector);
        return "{" + string.substring(1, string.length() - 1) + "}";
    }

    // a. Прибавление к вектору другого вектора
    public void getAddition(Vector vector2) {
        if (vector2 == null) {
            throw new IllegalArgumentException("argument must not be = null");
        }

        if (vector.length < vector2.getSize()) {
            throw new IllegalArgumentException("vector2 must not be longer than vector1");
        }

        int size = Math.min(vector.length, vector2.getSize());

        for (int i = 0; i < size; i++) {
            vector[i] = vector[i] + vector2.getVectorComponent(i);
        }
    }

    // b. Вычитание из вектора другого вектора
    public void getSubtraction(Vector vector2) {
        if (vector2 == null) {
            throw new IllegalArgumentException("argument must not be = null");
        }

        if (vector.length < vector2.getSize()) {
            throw new IllegalArgumentException("vector2 must not be longer than vector1");
        }

        int size = Math.min(vector.length, vector2.getSize());

        for (int i = 0; i < size; i++) {
            vector[i] = vector[i] - vector2.getVectorComponent(i);
        }
    }

    // c. Умножение вектора на скаляр
    public void getVectorMultiplicationByScalar(int multiplier) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] = vector[i] * multiplier;
        }
    }

    // d. Разворот вектора (умножение всех компонент на -1)
    public void getVectorReversal() {
        for (int i = 0; i < vector.length; i++) {
            vector[i] = vector[i] * -1;
        }
    }

    // e. Получение длины вектора
    public double getVectorLength() {
        double length = 0;

        for (double v : vector) {
            length += v * v;
        }

        return Math.sqrt(length);
    }

    // f. Получение компоненты вектора по индексу
    public double getVectorComponent(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index must be >= 0");
        }

        return vector[index];
    }

    // f. Установка компоненты вектора по индексу
    public void setVectorComponent(double component, int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index must be >= 0");
        }

        if (vector.length < index) {
            throw new IllegalArgumentException("index must be < length of vector");
        }

        vector[index] = component;
    }

    // g. Переопределить метод equals, чтобы был true векторы имеют одинаковую размерность и соответствующие компоненты равны.
    @Override
    public boolean equals(Object vector2) {
        if (vector2 == null) {
            throw new IllegalArgumentException("the argument shouldn't be = null");
        }

        if (this.getClass() != vector2.getClass()) {
            throw new IllegalArgumentException("the argument is not an instance of the Vector class");
        }

        if (vector.length != ((Vector) vector2).getVectorLength()) {
            return false;
        }

        boolean temp = true;

        for (int i = 0; i < vector.length; i++) {
            if (vector[i] != ((Vector) vector2).getVectorComponent(i)) {
                temp = false;
            }
        }

        return temp;
    }

    // g. Соответственно, переопределить hashCode
    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        for (double v : vector) {
            hash = prime * hash + Double.hashCode(v);
        }

        return hash;
    }

    // a. Сложение двух векторов – должен создаваться новый вектор
    public static Vector getAddition(Vector vector1, Vector vector2) {
        if (vector1 == null || vector2 == null) {
            throw new IllegalArgumentException("the argument shouldn't be = null");
        }

        int size = Math.max(vector1.getSize(), vector2.getSize());
        Vector vector = new Vector(size);

        for (int i = 0; i < size; i++) {
            double component = 0;

            if (i < vector1.getSize()) {
                component = vector1.getVectorComponent(i);
            }

            if (i < vector2.getSize()) {
                component += vector2.getVectorComponent(i);
            }

            vector.setVectorComponent(component, i);
        }

        return vector;
    }

    // b. Вычитание векторов – должен создаваться новый вектор
    public static Vector getSubtraction(Vector vector1, Vector vector2) {
        if (vector1 == null || vector2 == null) {
            throw new IllegalArgumentException("the argument shouldn't be = null");
        }

        int size = Math.max(vector1.getSize(), vector2.getSize());
        Vector vector = new Vector(size);

        for (int i = 0; i < size; i++) {
            double temp = 0;

            if (i < vector1.getSize()) {
                temp = vector1.getVectorComponent(i);
            }

            if (i < vector2.getSize()) {
                temp -= vector2.getVectorComponent(i);
            }

            vector.setVectorComponent(temp, i);
        }

        return vector;
    }

    // c. Скалярное произведение векторов
    public static double getScalarVectorsProduct(Vector vector1, Vector vector2) {
        if (vector1 == null || vector2 == null) {
            throw new IllegalArgumentException("the argument shouldn't be = null");
        }

        int size = Math.min(vector1.getSize(), vector2.getSize());
        double temp = 0;

        for (int i = 0; i < size; i++) {
            temp += vector1.getVectorComponent(i) * vector2.getVectorComponent(i);
        }

        return temp;
    }
}