package ru.academit.elena072021.shapes;

public class Square implements Shape {
    private final double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }

    @Override
    public double getWidth() {
        return sideLength;
    }

    @Override
    public double getHeight() {
        return sideLength;
    }

    @Override
    public double getArea() {
        return sideLength * sideLength;
    }

    @Override
    public double getPerimeter() {
        return 4 * sideLength;
    }

    @Override
    public String toString() {
        return "{Квадрат: Длина стороны = " + sideLength + "}";
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Square square = (Square) object;

        return sideLength == square.sideLength;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        hash = prime * hash + Double.hashCode(sideLength);

        return hash;
    }
}