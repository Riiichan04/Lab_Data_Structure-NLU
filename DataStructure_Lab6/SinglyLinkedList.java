package lab6;

public class SinglyLinkedList<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size;

    public int size() {
        return this.size;
    }
    public boolean isEmpty() {
        return false;
    }
    public E first() {
        if (this.size == 0) return null;
        else return this.head.getData();
    }
    public E last() {
        if (this.size == 0) return null;
        else return this.tail.getData();
    }
    public void addFirst(E e) {
        Node<E> newHead = new Node<>(e, null);
        if (this.head == null) {
            this.head = this.tail = newHead;
        }
        else {
            newHead.setNext(this.head);
            this.head = newHead;
        }
        size++;
    }

    public void addLast(E e) {
        Node<E> newTail = new Node<>(e, null);
        if (this.head == null) addFirst(e);
        else {
            this.tail.setNext(newTail);
            this.tail = newTail;
            size++;
        }
    }

    public E removeFirst() {
        if (size == 0) return null;

        else {
            E result = this.head.getData();
            Node<E> newList = this.head.getNext();
            this.head.setNext(null);
            this.head = newList;
            size--;
            return result;
        }
    }

    public E removeLast() {
        if (size == 0) return null;
        else {
            Node<E> tempNode = this.head;
            while (tempNode.getNext().getNext() != null) {
                tempNode = tempNode.getNext();
            }
            E result = this.tail.getData();
            tempNode.setNext(tempNode.getNext().getNext());
            this.tail = tempNode;
            size--;
            return result;
        }
//        else {
//            E result = this.tail.getData();
//            this.tail = null;
//            size--;
//            return result;
//        }
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> test = new SinglyLinkedList<>();
        test.addFirst(2);
        test.addLast(4);
        test.addLast(8);
        test.removeFirst();
//        test.removeLast();
        test.addLast(5);
        Node<Integer> temp = test.head;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }
}
