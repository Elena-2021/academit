package ru.academit.elena072021.shapes;

import java.util.Comparator;

public interface Shape {
    double getWidth();

    double getHeight();

    double getArea();

    double getPerimeter();

    Comparator<Shape> AreaComparator = Comparator.comparingDouble(Shape::getArea);

    Comparator<Shape> PerimeterComparator = Comparator.comparingDouble(Shape::getPerimeter);

    boolean equals(Shape obj);

    int hashCode();
}