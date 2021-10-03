package ru.academit.elena072021.list_main;

import ru.academit.elena072021.list.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        /*SinglyLinkedList<String> stringsList = new SinglyLinkedList<>();
        //stringsList.deleteFirst();
        stringsList.deleteByData("грибы");
        System.out.println("Проверяем методы delete = " + stringsList);
        System.out.println();*/

        SinglyLinkedList<String> stringsList = new SinglyLinkedList<>("Element");
        System.out.println(stringsList);
        System.out.println();

        stringsList.addFirst("text");
        stringsList.addLast("text_End");
        stringsList.addLast("text_End2");
        System.out.println(stringsList);
        System.out.println();

        System.out.println("Удаленный элемент: " + stringsList.deleteFirst());
        System.out.println(stringsList);
        System.out.println();

        stringsList.addFirst("text_Front");
        System.out.println("Список со вставленным элементом в начало. " + stringsList);
        System.out.println();

        System.out.println("Удаленный элемент: " + stringsList.deleteLast());
        System.out.println(stringsList);
        System.out.println();

        System.out.println("Вставка элемента по индексу: 'InsertElement'");
        stringsList.insertByIndex(3, "InsertElement");
        System.out.println(stringsList);
        System.out.println();

        System.out.println("Удаление элемента по индексу: 'Index = 3'");
        System.out.println("Удаленный элемент: " + stringsList.deleteByIndex(3));
        System.out.println(stringsList);
        System.out.println();

        System.out.println("Получение значения по указанному индексу: " + stringsList.getByIndex(2));
        System.out.println();

        System.out.println("Значение измененного элемента: " + stringsList.setByIndex(1, "Fish"));
        System.out.println("Изменение значения по указанному индексу: " + stringsList);
        System.out.println();

        System.out.println("Значение удаленного элемента: " + stringsList.deleteByData("text_End1"));
        System.out.println(stringsList);
        System.out.println();

        System.out.println("Скопированный список: " + stringsList.getCopy());
        //stringsList.deleteLast();
        System.out.println();

        SinglyLinkedList<String> stringsList2 = new SinglyLinkedList<>();
        stringsList2.reverse();
        System.out.println("Разворот списка: " + stringsList2);
    }
}