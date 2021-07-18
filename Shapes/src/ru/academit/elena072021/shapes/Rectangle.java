package ru.academit.elena072021.shapes;

public class Rectangle implements Shape {
    private final double width;
    private final double height;
    private final int hash;


    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
        this.hash = (int) Math.ceil(width + height);
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
        return 2 * width + 2 * height;
    }

    @Override
    // переопределим метод toString() для печати
    public String toString() {
        return "[Прямоугольник: Ширина = " + this.width + ", Высота = " + this.height + "]";
    }

    @Override
    public boolean equals(Shape shape) {
        if (shape == null || this.getClass() != shape.getClass()) {
            return false;
        }

        Rectangle rectangle = (Rectangle) shape;
        return ((this.width == rectangle.width && this.height == rectangle.height) || (this.width == rectangle.height &&
                this.height == rectangle.width));
    }

    @Override
    public int hashCode() {
        return hash;
    }
}