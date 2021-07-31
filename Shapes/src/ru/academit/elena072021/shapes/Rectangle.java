package ru.academit.elena072021.shapes;

public class Rectangle implements Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return "{Прямоугольник: Ширина = " + width + ", Высота = " + height + "}";
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Rectangle rectangle = (Rectangle) object;

        return width == rectangle.width && height == rectangle.height;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        hash = prime * hash + Double.hashCode(width);
        hash = prime * hash + Double.hashCode(height);

        return hash;
    }
}