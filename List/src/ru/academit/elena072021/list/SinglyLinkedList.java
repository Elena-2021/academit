package ru.academit.elena072021.list;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList() {
        head = null;
        count = 0;
    }

    public SinglyLinkedList(T data) {
        head = new ListItem<>(data);
        count = 1;
    }

    // получение размера списка
    public int getSize() {
        return count;
    }

    // вставка элемента в начало
    public void addListBeginning(T data) {
        ListItem<T> p = new ListItem<>(data);
        p.setNext(head);
        head = p;
        count++;
    }

    // удаление первого элемента
    public T deleteListElementFirst() {
        T result = head.getData();
        head = head.getNext();
        count--;

        return result;
    }

    // вставка элемента в конец
    public void addListEnd(T data) {
        ListItem<T> lastElementPointer = null;

        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            lastElementPointer = p;
        }

        ListItem<T> p = new ListItem<>(data, null);

        if (lastElementPointer != null) {
            lastElementPointer.setNext(p);
        } else {
            head = p;
        }

        count++;
    }

    // удаление последнего элемента
    public T deleteLastElement() {
        ListItem<T> lastElementPointer = null;
        ListItem<T> previousElementPointer = null;

        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            previousElementPointer = lastElementPointer;
            lastElementPointer = p;
        }

        previousElementPointer.setNext(null);
        count--;

        return lastElementPointer.getData();
    }

    // вставка элемента по индексу
    public void InsertElementByIndex(int index, T data) {   // index - диапазон от нуля

        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("parameter index = " + index + " is outside the list interval [" + 0 + ";" + (count - 1) + "]");
        }

        if (index == 0) {
            addListBeginning(data);
        } else if (index == count) {
            addListEnd(data);
        } else {
            ListItem<T> previousElementPointer = head;

            for (int i = 1; i < index; i++) {
                previousElementPointer = previousElementPointer.getNext();
            }

            ListItem<T> p = new ListItem<>(data, previousElementPointer.getNext());
            previousElementPointer.setNext(p);
            count++;
        }
    }

    // удаление элемента по индексу
    public T deleteElementByIndex(int index) {   // index - диапазон от нуля
        if (index < 0 || index > count - 1) {
            throw new IndexOutOfBoundsException("parameter index = " + index + " is outside the list interval [" + 0 + ";" + (count - 1) + "]");
        }

        ListItem<T> previousElementPointer = head;

        for (int i = 0; i < index - 1; i++) {
            previousElementPointer = previousElementPointer.getNext();
        }

        T data = previousElementPointer.getNext().getData();

        if (index == 0) {
            data = previousElementPointer.getData();
            deleteListElementFirst();

            return data;
        }

        if (index == count - 1) {
            data = previousElementPointer.getNext().getData();
            deleteLastElement();

            return data;
        }

        previousElementPointer.setNext(previousElementPointer.getNext().getNext());
        count--;

        return data;
    }

    // получение значения по указанному индексу.
    public T getDataByIndex(int index) {   // index - диапазон от нуля
        if (index < 0 || index > count - 1) {
            throw new IndexOutOfBoundsException("parameter index = " + index + " is outside the list interval [" + 0 + ";" + (count - 1) + "]");
        }

        ListItem<T> elementPointer = head;

        for (int i = 0; i < index; i++) {
            elementPointer = elementPointer.getNext();
        }

        return elementPointer.getData();
    }

    // изменение значения по указанному индексу.
    public T setData(int index, T data) {   // index - диапазон от нуля
        if (index < 0 || index > count - 1) {
            throw new IndexOutOfBoundsException("parameter index = " + index + " is outside the list interval [" + 0 + ";" + (count - 1) + "]");
        }

        ListItem<T> elementPointer = head;

        for (int i = 0; i < index; i++) {
            elementPointer = elementPointer.getNext();
        }

        T oldData = elementPointer.getData();
        elementPointer.setData(data);

        return oldData;
    }

    // удаление узла по значению, пусть выдает true, если элемент был удален
    public boolean deleteDate(T data) {   // index - диапазон от нуля
        ListItem<T> previousElementPointer = null;
        ListItem<T> elementPointer;

        for (elementPointer = head; elementPointer != null && elementPointer.getData() != data; elementPointer = elementPointer.getNext()) {
            previousElementPointer = elementPointer;
        }

        // удаление первого элемента
        if (previousElementPointer == null) {
            deleteListElementFirst();

            return true;
        }

        // удаление последнего элемента
        if (elementPointer != null && elementPointer.getNext() == null && elementPointer.getData() == data) {
            System.out.println("End elementPointer.getData() == " + elementPointer.getData());
            deleteLastElement();

            return true;
        }

        // удаление среднего элемента
        if (elementPointer != null && elementPointer.getData() == data) {
            System.out.println("Mean elementPointer.getData() == " + data);
            previousElementPointer.setNext(previousElementPointer.getNext().getNext());
            count--;

            return true;
        }

        return false;
    }

    // разворот списка за линейное время
    public void reverseList() {
        ListItem<T>[] arrayPointer = new ListItem[count];
        int index = 0;

        for (ListItem<T> elementPointer = head; elementPointer != null; elementPointer = elementPointer.getNext()) {
            arrayPointer[index] = elementPointer;
            index++;
        }

        // проверка на несоответствии параметра count и длины списка
        if (arrayPointer[count - 1] == null || arrayPointer[count - 1].getNext() != null) {
            throw new IndexOutOfBoundsException("parameter count = " + count + " does not match the number of items in the list!");
        }

        head = arrayPointer[count - 1];
        ListItem<T> elementPointer = head;

        for (int i = count - 2; i >= 0; i--) {
            elementPointer.setNext(arrayPointer[i]);
            elementPointer = elementPointer.getNext();
        }

        elementPointer.setNext(null);
    }

    // копирование списка
    public SinglyLinkedList<T> copyList() {   // index - диапазон от нуля
        SinglyLinkedList<T> newSinglyLinkedList = new SinglyLinkedList<>();

        for (ListItem<T> elementPointer = head; elementPointer != null; elementPointer = elementPointer.getNext()) {
            newSinglyLinkedList.addListEnd(elementPointer.getData());
        }

        return newSinglyLinkedList;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            stringBuilder.append(", ");
            stringBuilder.append((String) p.getData());
        }

        return "Параметры односвязного списка: count = " + count + ", [" + stringBuilder.delete(0, 2) + "]";
    }

}