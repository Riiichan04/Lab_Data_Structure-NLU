package lab6;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<E> {
    public static final int DEFAULT_CAPACITY = 10;
    private E[] elements;
    private int size;   //Current length of ArrayList

    public MyArrayList() {
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        this.elements = (E[]) new Object[capacity];
    }

    public void growSize() {
        E[] newElements = (E[]) new Object[elements.length*2];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int i) throws IndexOutOfBoundsException {
        if (i >= size || i < 0) throw new IndexOutOfBoundsException("Uh huh!");
        else {
            return elements[i];
        }
    }

    public E set(int i, E e) throws IndexOutOfBoundsException {
        if (i >= size || i < 0) throw new IndexOutOfBoundsException("Uh huh!");
        else {
            E result = elements[i];
            elements[i] = e;
            return result;
        }
    }

    public boolean add(E e) {
        if (this.size >= elements.length) this.growSize();
        elements[size] = e;
        size++;
        return true;
    }

    public void add(int i, E e) throws IndexOutOfBoundsException {
        if (i > this.size || i < 0) throw new IndexOutOfBoundsException("Uh huh!");
        else {
            if (this.size >= elements.length) this.growSize();
            for (int j = i; j < elements.length; j++) {
                elements[j+1] = elements[j];
            }
            elements[i] = e;
            size++;
        }
    }

    public E remove(int i) throws IndexOutOfBoundsException {
        if (i > this.size || i < 0) throw new IndexOutOfBoundsException("Uh huh!");
        else {
            E result = elements[i];
            for (int j = i; j < elements.length - 1; j++) {
                elements[j] = elements[j+1];
            }
            size--;
            return result;
        }
    }

    public void clear() {
        this.size = 0;
        elements = (E[]) new Object[this.size];
    }

    public int lastIndexOf(Object o) {
        for (int i = elements.length - 1; i > -1; i--) {
            if (elements[i].equals(o)) return i;
        }
        return -1;
    }

    public E[] toArray() {
        E[] result = (E[]) new Object[size];
        System.arraycopy(elements, 0, result, 0, size);
        return result;
    }

    public MyArrayList<E> clone() {
        MyArrayList<E> result = new MyArrayList<>();
        result.elements = this.elements.clone();
        result.size = this.size;
        return result;
    }

    public boolean contains(E o) {
        return this.indexOf(o) > -1;
    }

    public int indexOf(E o) {
        if (isEmpty()) return -1;
        else {
            for (int i = 0; i < elements.length; i++) {
                if (elements[i].equals(o)) return i;
            }
            return -1;
        }
    }

    public boolean remove(E e) {
        if (this.indexOf(e) > -1) {
            remove(this.indexOf(e));
            return true;
        }
        else return false;
    }

    public void sort(Comparator<E> c) {
        Arrays.sort(elements, 0, size-1, c);
    }

    public static void main(String[] args) {
        MyArrayList<Integer> test = new MyArrayList<>();
        for (int i = 0; i < 10; i++) {
            test.add(i);
        }
        for (int i = 0; i < 10; i++) {
            test.add(-i);
        }
        System.out.println(test.get(2));
        System.out.println(test.indexOf(5));
        System.out.println(test.remove(3));
        for (int i = 0; i < test.size(); i++) {
            System.out.print(test.get(i) + " ");
        }
        System.out.println();
        MyArrayList<Integer> test2 = test.clone();
        for (int i = 0; i < test2.size(); i++) {
            System.out.print(test2.get(i) + " ");
        }
        System.out.println();
        test2.clear();
        System.out.println(test2.size());
    }
}
