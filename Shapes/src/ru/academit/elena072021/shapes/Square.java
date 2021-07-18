package ru.academit.elena072021.shapes;

public class Square implements Shape {
    private final double sideLength;
    private final int hash;

    public Square(double sideLength) {
        this.sideLength = sideLength;
        this.hash = (int) Math.ceil(sideLength);
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
        return Math.pow(sideLength, 2);
    }

    @Override
    public double getPerimeter() {
        return 4 * sideLength;
    }

    @Override
    public String toString() {
        return "[Квадрат: Сторона = " + this.sideLength + "]";
    }

    @Override
    public boolean equals(Shape shape) {
        if (shape == null || this.getClass() != shape.getClass()) {
            return false;
        }

        Square square = (Square) shape;
        return (this.sideLength == square.sideLength);
    }

    @Override
    public int hashCode() {
        return hash;
    }
}