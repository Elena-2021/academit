package ru.academit.elena072021.shapes_main;

import java.util.Arrays;
import ru.academit.elena072021.shapes.*;

public class Main {
    public static Shape getShapesSortToArea(Shape[] array, int position) {    // position - порядковый номер позиции от max к min.
        Arrays.sort(array, Shape.AreaComparator);

        if (array.length - position < 0) {
            return null;
        }

        return array[array.length - position];
    }

    public static Shape getShapesSortToPerimeter(Shape[] array, int position) {   // position - порядковый номер позиции от max к min.
        Arrays.sort(array, Shape.PerimeterComparator);

        if (array.length - position < 0) {
            return null;
        }

        return array[array.length - position];
    }

    public static void main(String[] args) {

        Shape rectangle = new Rectangle(11, 2);
        System.out.println(rectangle);
        System.out.println("Периметр = " + rectangle.getPerimeter());
        System.out.println("Площадь  = " + rectangle.getArea());
        System.out.println();

        Shape triangle = new Triangle(0, 0, 3, 0, 0, 4);
        System.out.println(triangle);
        System.out.println("Периметр = " + triangle.getPerimeter());
        System.out.println("Площадь  = " + triangle.getArea());
        System.out.println();

        Shape circle = new Circle(4);
        System.out.println(circle);
        System.out.println("Периметр = " + circle.getPerimeter());
        System.out.println("Площадь  = " + circle.getArea());
        System.out.println();

        Shape square = new Square(3);
        System.out.println(square);
        System.out.println("Периметр = " + square.getPerimeter());
        System.out.println("Площадь  = " + square.getArea());
        System.out.println();

        Shape[] array = new Shape[]{rectangle, triangle, circle, square, new Square(2), new Square(1),
                new Rectangle(9, 2), new Rectangle(8, 2), new Circle(1), new Circle(3)};

        System.out.println("Фигура с максимальной площадью:");
        Shape maxArea = getShapesSortToArea(array, 1);
        System.out.println(maxArea);

        if (maxArea != null) {
            System.out.println("Площадь  = " + maxArea.getArea());
        }
        System.out.println();

        System.out.println("Фигура со вторым по величине периметром");
        Shape maxPerimeter = getShapesSortToPerimeter(array, 2);
        System.out.println(maxPerimeter);

        if (maxPerimeter != null) {
            System.out.println("Периметр = " + maxPerimeter.getPerimeter());
        }
    }
}