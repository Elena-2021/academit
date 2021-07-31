package ru.academit.elena072021.shapes_main;

import java.util.Arrays;

import ru.academit.elena072021.shapes.*;

public class Main {
    /* Неоднозначное требование "Компараторы нужно перенести в пакет к main", это может означать, как перенос классов в пакет с main, так и реализация компараторов в файле класса main.
    public static Comparator<Shape> AreaComparator = Comparator.comparingDouble(Shape::getArea);
    public static Comparator<Shape> PerimeterComparator = Comparator.comparingDouble(Shape::getPerimeter); */
    public static Shape getShapeWithAreaSizeSetPosition(Shape[] array, int position) {    // position - порядковый номер позиции от max к min.
        if (array.length < position) {
            return null;
        }

        Arrays.sort(array, new AreaComparator());

        return array[array.length - position];
    }

    public static Shape getShapeWithPerimeterSizeSetPosition(Shape[] array, int position) {   // position - порядковый номер позиции от max к min.
        if (array.length < position) {
            return null;
        }

        Arrays.sort(array, new PerimeterComparator());

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

        Shape[] shapesArray = {
                rectangle,
                triangle,
                circle,
                square,
                new Square(2),
                new Square(1),
                new Rectangle(9, 2),
                new Rectangle(8, 2),
                new Circle(1),
                new Circle(3)
        };

        System.out.println("Фигура с максимальной площадью:");
        Shape shapeWithMaxArea = getShapeWithAreaSizeSetPosition(shapesArray, 1);
        System.out.println(shapeWithMaxArea);

        if (shapeWithMaxArea != null) {
            System.out.println("Площадь  = " + shapeWithMaxArea.getArea());
        }
        System.out.println();

        System.out.println("Фигура со вторым по величине периметром");
        Shape shapeWithSecondLargestPerimeter = getShapeWithPerimeterSizeSetPosition(shapesArray, 2);
        System.out.println(shapeWithSecondLargestPerimeter);

        if (shapeWithSecondLargestPerimeter != null) {
            System.out.println("Периметр = " + shapeWithSecondLargestPerimeter.getPerimeter());
        }
    }
}