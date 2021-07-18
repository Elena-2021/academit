package ru.academit.elena072021.shapes;

public class Triangle implements Shape {
    private final double x1;
    private final double y1;
    private final double x2;
    private final double y2;
    private final double x3;
    private final double y3;

    private final int hash;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;

        this.hash = (int) Math.ceil((Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)) + Math.sqrt(Math.pow(x2 - x3, 2) +
                Math.pow(y2 - y3, 2)) + Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2)));
    }

    @Override
    public double getWidth() {
        return Math.max(Math.max(x1, x2), x3) - Math.min(Math.min(x1, x2), x3);
    }

    @Override
    public double getHeight() {
        return Math.max(Math.max(y1, y2), y3) - Math.min(Math.min(y1, y2), y3);
    }

    @Override
    public double getArea() {
        double side1 = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        double side2 = Math.sqrt(Math.pow(x2 - x3, 2) + Math.pow(y2 - y3, 2));
        double side3 = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));

        double semiPerimeter = (side1 + side2 + side3) / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3));
    }

    @Override
    public double getPerimeter() {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)) + Math.sqrt(Math.pow(x2 - x3, 2) + Math.pow(y2 - y3, 2)) +
                Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));
    }

    @Override
    public String toString() {
        return "[Треугольник: Точка 1 = (" + this.x1 + ", " + this.y1 + "), Точка 2 = (" + this.x2 + ", " + this.y2 + ")," +
                " Точка 3 = (" + this.x3 + ", " + this.y3 + ")]";
    }

    @Override
    public boolean equals(Shape shape) {
        if (shape == null || this.getClass() != shape.getClass()) {
            return false;
        }

        Triangle triangle = (Triangle) shape;
        double side1 = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        double side2 = Math.sqrt(Math.pow(x2 - x3, 2) + Math.pow(y2 - y3, 2));
        double side3 = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));

        double triangle2Side1 = Math.sqrt(Math.pow(triangle.x1 - triangle.x2, 2) + Math.pow(triangle.y1 - triangle.y2, 2));
        double triangle2Side2 = Math.sqrt(Math.pow(triangle.x2 - triangle.x3, 2) + Math.pow(triangle.y2 - triangle.y3, 2));
        double triangle2Side3 = Math.sqrt(Math.pow(triangle.x1 - triangle.x3, 2) + Math.pow(triangle.y1 - triangle.y3, 2));

        return ((side1 == triangle2Side1 && side2 == triangle2Side2 && side3 == triangle2Side3) || (side1 == triangle2Side1 &&
                side2 == triangle2Side3 && side3 == triangle2Side2) || (side1 == triangle2Side2 && side2 == triangle2Side3 &&
                side3 == triangle2Side1) || (side1 == triangle2Side2 && side2 == triangle2Side1 && side3 == triangle2Side3) ||
                (side1 == triangle2Side3 && side2 == triangle2Side1 && side3 == triangle2Side2) || (side1 == triangle2Side3 &&
                side2 == triangle2Side2 && side3 == triangle2Side1));
    }

    @Override
    public int hashCode() {
        return hash;
    }
}