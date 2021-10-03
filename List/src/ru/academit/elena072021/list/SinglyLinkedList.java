package ru.academit.elena072021.list;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int size;

    public SinglyLinkedList() {
    }

    public SinglyLinkedList(T data) {
        head = new ListItem<>(data);
        size = 1;
    }

    // получение размера списка
    public int getSize() {
        return size;
    }

    // вставка элемента в начало
    public void addFirst(T data) {
        head = new ListItem<>(data, head);
        size++;
    }

    // удаление первого элемента
    public T deleteFirst() {
        if (size == 0) {
            throw new NoSuchElementException("The list don't contains elements, deletion is not possible.");
        }

        T deletedData = head.getData();
        head = head.getNext();
        size--;

        return deletedData;
    }

    // вставка элемента в конец
    public void addLast(T data) {
        insertByIndex(size, data);
    }

    // удаление последнего элемента
    public T deleteLast() {
        if (size == 0) {
            throw new NoSuchElementException("The list don't contains elements, deletion is not possible.");
        }

        return deleteByIndex(size - 1);
    }

    // вставка элемента по индексу
    public void insertByIndex(int index, T data) {   // index - диапазон от нуля
        isIndexCorrect(index - 1);

        if (index == 0) {
            addFirst(data);
        } else {
            ListItem<T> previousItem = head;

            for (int i = 1; i < index; i++) {
                previousItem = previousItem.getNext();
            }

            if (index != size) {
                ListItem<T> currentItem = new ListItem<>(data, previousItem.getNext());
                previousItem.setNext(currentItem);
            } else {
                ListItem<T> currentItem = new ListItem<>(data);
                previousItem.setNext(currentItem);
            }

            size++;
        }
    }

    // удаление элемента по индексу
    public T deleteByIndex(int index) {   // index - диапазон от нуля
        isIndexCorrect(index);

        ListItem<T> previousItem = head;

        for (int i = 1; i < index; i++) {
            previousItem = previousItem.getNext();
        }

        T deletedData = previousItem.getNext().getData();

        if (index == 0) {
            return deleteFirst();
        }

        previousItem.setNext(previousItem.getNext().getNext());
        size--;

        return deletedData;
    }

    // получение значения по указанному индексу.
    public T getByIndex(int index) {   // index - диапазон от нуля
        isIndexCorrect(index);

        ListItem<T> currentItem = head;

        for (int i = 0; i < index; i++) {
            currentItem = currentItem.getNext();
        }

        return currentItem.getData();
    }

    // изменение значения по указанному индексу.
    public T setByIndex(int index, T data) {   // index - диапазон от нуля
        isIndexCorrect(index);

        ListItem<T> currentItem = head;

        for (int i = 0; i < index; i++) {
            currentItem = currentItem.getNext();
        }

        T oldData = currentItem.getData();
        currentItem.setData(data);

        return oldData;
    }

    // удаление узла по значению, пусть выдает true, если элемент был удален
    public boolean deleteByData(T data) {   // index - диапазон от нуля
        // удаление первого элемента
        if (head != null && head.getData().equals(data)) {
            deleteFirst();

            return true;
        }

        for (ListItem<T> previousItem = head, currentItem = head.getNext(); currentItem != null; currentItem = currentItem.getNext()) {
            if (currentItem.getData().equals(data)) {
                previousItem.setNext(previousItem.getNext().getNext());
                size--;

                return true;
            }

            previousItem = currentItem;
        }

        return false;
    }

    // разворот списка за линейное время
    public void reverse() {
        // проверка на пустой список и на список с одним элементом
        if (size <= 1) {
            return;
        }

        for (ListItem<T> previousItem = null, currentItem = head, nextItem = currentItem.getNext(); nextItem != null; ) {
            currentItem.setNext(previousItem);
            previousItem = currentItem;
            currentItem = nextItem;

            if (nextItem.getNext() == null) {
                nextItem = null;
                currentItem.setNext(previousItem);
                head = currentItem;
            } else {
                nextItem = nextItem.getNext();
            }
        }
    }

    // копирование списка
    public SinglyLinkedList<T> getCopy() {
        // проверка на пустой список
        if (size == 0) {
            return new SinglyLinkedList<>();
        }

        SinglyLinkedList<T> newSinglyLinkedList = new SinglyLinkedList<>();
        ListItem<T> newLastItem = newSinglyLinkedList.head;

        for (ListItem<T> currentItem = head; currentItem != null; currentItem = currentItem.getNext()) {
            ListItem<T> newCurrentItem = new ListItem<>(currentItem.getData());

            if (newLastItem == null) {
                newSinglyLinkedList.head = newCurrentItem;
            } else {
                newLastItem.setNext(newCurrentItem);
            }

            newLastItem = newCurrentItem;
            newSinglyLinkedList.size++;
        }

        return newSinglyLinkedList;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (ListItem<T> currentItem = head; currentItem != null; currentItem = currentItem.getNext()) {
            stringBuilder.append(", ");
            stringBuilder.append(currentItem.getData());
        }

        return "size = " + size + ", [" + stringBuilder.delete(0, 2) + "]";
    }

    public T getFirst() {
        if (size == 0) {
            throw new NoSuchElementException("The SinglyLinkedList contains no elements");
        }

        return head.getData();
    }

    private void isIndexCorrect(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Parameter index = " + index + " is outside the list interval [0;" + (size - 1) + "]");
        }
    }

    private ListItem<T> getItem(int index) {
        ListItem<T> item = head;

        for (int i = 0; i < index; i++) {
            item = item.getNext();
        }

        return item;
    }
}