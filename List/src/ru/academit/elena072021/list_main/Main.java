package ru.academit.elena072021.list_main;

import ru.academit.elena072021.list.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<String> stringsList = new SinglyLinkedList<>("Element");
        System.out.println(stringsList);
        System.out.println();

        stringsList.addListBeginning("text");
        stringsList.addListEnd("text_End");
        stringsList.addListEnd("text_End2");
        System.out.println(stringsList);
        System.out.println();

        System.out.println("Удаленный элемент: " + stringsList.deleteListElementFirst());
        System.out.println(stringsList);
        System.out.println();

        stringsList.addListBeginning("text_Front");
        System.out.println("Список со вставленным элементом в начало. " + stringsList);
        System.out.println();

        System.out.println("Удаленный элемент: " + stringsList.deleteLastElement());
        System.out.println(stringsList);
        System.out.println();

        System.out.println("Вставка элемента по индексу: 'InsertElement'");
        stringsList.insertElementByIndex(3, "InsertElement");
        System.out.println(stringsList);
        System.out.println();

        System.out.println("Удаление элемента по индексу: 'Index = 3'");
        System.out.println("Удаленный элемент: " + stringsList.deleteElementByIndex(3));
        System.out.println(stringsList);
        System.out.println();

        System.out.println("Получение значения по указанному индексу: " + stringsList.getDataByIndex(2));
        System.out.println();

        System.out.println("Значение измененного элемента: " + stringsList.setData(1, "Fish"));
        System.out.println("Изменение значения по указанному индексу: " + stringsList);
        System.out.println();

        System.out.println("Значение удаленного элемента: " + stringsList.deleteDate("text_Front1"));
        System.out.println(stringsList);
        System.out.println();

        System.out.println("Скопированный список: " + stringsList.copyList());
        System.out.println();

        stringsList.reverseList();
        System.out.println("Разворот списка: " + stringsList);
    }
}