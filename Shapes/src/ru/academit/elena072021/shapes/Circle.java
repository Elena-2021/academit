package ru.academit.elena072021.shapes;

public class Circle implements Shape {
    private final double radius;
    private final int hash;

    public Circle(double radius) {
        this.radius = radius;
        this.hash = (int) Math.ceil(radius);
    }

    @Override
    public double getWidth() {
        return 2 * radius;
    }

    @Override
    public double getHeight() {
        return 2 * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "[Круг: Радиус = " + this.radius + "]";
    }

    @Override
    public boolean equals(Shape shape) {
        if (shape == null || this.getClass() != shape.getClass()) {
            return false;
        }

        Circle s1 = (Circle) shape;
        return (this.radius == s1.radius);
    }

    @Override
    public int hashCode() {
        return hash;
    }
}