package ru.academit.elena072021.list;

import java.util.NoSuchElementException;
import java.util.Objects;

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
        if (index == 0) {
            addFirst(data);
            return;
        }

        checkIndex(index, 1);

        ListItem<T> previousItem = getItem(index - 1);
        ListItem<T> newItem = new ListItem<>(data, previousItem.getNext());
        previousItem.setNext(newItem);
        size++;
    }

    // удаление элемента по индексу
    public T deleteByIndex(int index) {   // index - диапазон от нуля
        checkIndex(index);

        if (index == 0) {
            return deleteFirst();
        }

        ListItem<T> previousItem = getItem(index - 1);
        T deletedData = previousItem.getNext().getData();
        previousItem.setNext(previousItem.getNext().getNext());
        size--;

        return deletedData;
    }

    // получение значения по указанному индексу.
    public T getByIndex(int index) {   // index - диапазон от нуля
        checkIndex(index);

        return getItem(index).getData();
    }

    // изменение значения по указанному индексу.
    public T setByIndex(int index, T data) {   // index - диапазон от нуля
        checkIndex(index);

        ListItem<T> currentItem = getItem(index);
        T oldData = currentItem.getData();
        currentItem.setData(data);

        return oldData;
    }

    // удаление узла по значению, пусть выдает true, если элемент был удален
    public boolean deleteByData(T data) {
        if (size == 0) {
            return false;
        }

        // удаление первого элемента
        if (head != null && Objects.equals(head.getData(), data)) {
            deleteFirst();

            return true;
        }

        for (ListItem<T> previousItem = head, currentItem = head.getNext(); currentItem != null; currentItem = currentItem.getNext()) {
            if (Objects.equals(currentItem.getData(), data)) {
                previousItem.setNext(currentItem.getNext());
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
        SinglyLinkedList<T> newList = new SinglyLinkedList<>();

        // проверка на пустой список
        if (size == 0) {
            return newList;
        }

        newList.size = size;
        ListItem<T> newListPreviousItem = newList.head;

        for (ListItem<T> currentItem = head; currentItem != null; currentItem = currentItem.getNext()) {
            ListItem<T> newListCurrentItem = new ListItem<>(currentItem.getData());

            if (newListPreviousItem == null) {
                newList.head = newListCurrentItem;
            } else {
                newListPreviousItem.setNext(newListCurrentItem);
            }

            newListPreviousItem = newListCurrentItem;
        }

        return newList;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");

        for (ListItem<T> currentItem = head; currentItem != null; currentItem = currentItem.getNext()) {
            stringBuilder.append(", ");
            stringBuilder.append(currentItem.getData());
        }

        stringBuilder.delete(1, 3);
        stringBuilder.append("]");

        //return "size = " + size + ", " + stringBuilder;
        return stringBuilder.toString();
    }

    public T getFirst() {
        if (size == 0) {
            throw new NoSuchElementException("The SinglyLinkedList contains no elements");
        }

        return head.getData();
    }

    private void checkIndex(int index) {
        checkIndex(index, 0);
    }

    private void checkIndex(int index, int sizeChange) {
        if (index < 0 || index >= size + sizeChange) {
            throw new IndexOutOfBoundsException("Parameter index = " + index + " is outside the list interval [0;" + (size - 1 + sizeChange) + "]");
        }
    }

    private ListItem<T> getItem(int index) {
        checkIndex(index);

        ListItem<T> item = head;

        for (int i = 0; i < index; i++) {
            item = item.getNext();
        }

        return item;
    }
}