package Node;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> tail;
    private boolean reverse;


    public void setReverse(boolean reverse) {
        this.reverse = reverse;
    }

    private static class Node<T> {
        Node<T> next;
        Node<T> previous;
        T element;
        public Node(T element) {
            this.element = element;
        }
    }

    public void addElement(T element) {
        this.head = new Node<>(element);
        this.tail = head;
        this.head.next = null;
        this.head.previous = null;
    }

    public void removeElement(T element) {
        Node temp = head;
        Node tempPrevious = null;
        while (temp != null) {
            if (element == temp.element) {
                if (tempPrevious == null) {
                    head = temp.next;
                } else {
                    tempPrevious.next = temp.next;
                }
            } else {
                tempPrevious = temp;

            }
            temp = temp.next;
        }
    }



    public void addHead(T headElement) {
        if (head == null) {
            addElement(headElement);
        } else {
            Node <T> temp = head;
            head = new Node<>(headElement);
            head.next = temp;
            temp.previous = head;
        }
    }

    public void addHeadArray(T[] headArray) {
        T[] headArray2 = (T[]) new Object[headArray.length];
        for (int i =0, j = headArray2.length-1; i < headArray.length ; i++, j--) {
            headArray2[j] = headArray[i];
        }
        for (T element : headArray2) {
            addHead(element);
        }
    }

    public void addHeadCollection(Iterable<T> collection) {
        for (T element : collection) {
            addHead(element);
        }
    }

    public void replaceList(Iterable<T> collection, Iterable<T> collection1) {
        addHeadCollection(collection1);
        for (T element : collection) {
            removeElement(element);
        }
    }


    public void addTail(T tailElement) {
        if (tail == null) {
            addElement(tailElement);
        } else {
            Node <T> temp = tail;
            tail = new Node<>(tailElement);
            tail.previous = temp;
            temp.next = tail;
        }
    }

    public void addTailArray(T[] tailArray) {
        for (T element : tailArray) {
            addTail(element);
        }
    }

    public void addTailCollection(Iterable<T> tailCollection) {
        for (T element : tailCollection) {
            addTail(element);
        }
    }


    void listPrint() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.println(temp.element);
            temp = temp.next;
        }
    }

    void listPrintRevers() {
        Node<T> temp = tail;
        while (temp != null) {
            System.out.println(temp.element);
            temp = temp.previous;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new linkedListIterator<>(head, tail, reverse);
    }

    private static class linkedListIterator<T> implements Iterator<T> {
        Node head;
        Node tail;
        Boolean reverse;

        public linkedListIterator(Node head, Node tail, Boolean reverse) {
            if (reverse==false) {
                this.head = head;
                this.tail = null;
            } else {
                this.tail = tail;
                this.head = null;
            }
            this.reverse = reverse;
        }


        @Override
        public boolean hasNext() {
            return head != null | tail != null;

        }


        @Override
        public T next() {
            if (head != null) {
                T value = (T) head.element;
                head = head.next;
                return value;
            } else {
                T value = (T) tail.element;
                tail = tail.previous;
                return value;
            }
        }
    }
}






