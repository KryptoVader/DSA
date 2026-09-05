package LL;

import java.util.Arrays;

public class CircularLinkedList<T> implements Cloneable {
    private static class Node<T> implements Cloneable {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return this.data;
        }

        public Node<T> getNext() {
            return this.next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> clone() throws CloneNotSupportedException {
            return new Node<T>(this.data, this.next);
        }
    }

    private int size;
    private Node<T> head;
    private Node<T> tail;

    public CircularLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public CircularLinkedList(T data) {
        this.size = 1;
        Node<T> n = new Node<T>(data);
        this.head = n;
        this.tail = n;
        this.tail.setNext(this.head);
    }

    public boolean isEmpty() {
        return (this.head == null && this.tail == null && this.size == 0);
    }

    public int size() {
        return this.size;
    }

    public T first() {
        if (this.isEmpty()) {
            return null;
        }
        return this.head.getData();
    }

    public T last() {
        if (this.isEmpty()) {
            return null;
        }
        return this.tail.getData();
    }

    public void addFirst(T data) throws NullPointerException {
        if (data == null)
            throw new NullPointerException("Invalid Value");

        Node<T> node = new Node<>(data);
        if (isEmpty()) {
            this.size = 1;
            this.head = node;
            this.tail = node;
            this.tail.setNext(this.head);
        } else {
            node.setNext(this.head);
            this.tail.setNext(node);
            this.head = node;
            this.size++;
        }
    }

    public void addLast(T data) throws NullPointerException {
        if (data == null)
            throw new NullPointerException("Invalid Value");
        Node<T> node = new Node<>(data);
        if (isEmpty()) {
            this.size = 1;
            this.head = node;
            this.tail = node;
            this.tail.setNext(this.head);
        } else {
            node.setNext(this.head);
            this.tail.setNext(node);
            this.tail = node;
            this.size++;
        }
    }

    public void addAt(int index, T data) throws IndexOutOfBoundsException {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Index is Invalid!!");
        }
        if (index == 0) {
            this.addFirst(data);
        } else if (index == this.size) {
            this.addLast(data);
        } else {
            int i = 0;
            var ptr = this.head;
            while (i < index - 1) {
                ptr = ptr.getNext();
                i++;
            }

            Node<T> node = new Node<T>(data);
            node.setNext(ptr.getNext());
            ptr.setNext(node);
            this.size++;
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            System.err.println("Linked List is empty");
            return null;
        } else {
            T data = this.head.getData();
            this.tail.setNext(this.head.getNext());
            this.head = this.head.getNext();
            this.size--;

            if (this.size == 0) {
                this.head = null;
                this.tail = null;
            }
            return data;
        }
    }

    public T removeLast() {
        if (isEmpty()) {
            System.err.println("Linked List is empty");
            return null;
        } else {
            T data = this.tail.getData();
            Node<T> ptr = this.tail;
            while (ptr.getNext() != this.tail) {
                ptr = ptr.getNext();
            }
            ptr.setNext(this.head);
            this.tail = ptr;
            this.size--;

            if (this.size == 0) {
                this.head = null;
                this.tail = null;
            }
            return data;
        }
    }

    public T removeAt(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is Invalid!!");
        }
        if (index == 0) {
            return this.removeFirst();
        } else if (index == this.size - 1) {
            return this.removeLast();
        } else {
            int i = 0;
            var slow = this.head;
            var fast = this.head.getNext();
            while (i < index - 1) {
                slow = slow.getNext();
                fast = fast.getNext();
                i++;
            }

            T data = fast.getData();
            slow.setNext(fast.getNext());
            this.size--;
            return data;
        }
    }

    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is Invalid!!");
        }

        int i = 0;
        var ptr = this.head;
        while (i < index) {
            ptr = ptr.getNext();
            i++;
        }
        return ptr.getData();
    }

    public boolean contains(T data) {
        if(this.head == null)
            return false;
        var ptr = this.head;
        do {
            if (ptr.getData().equals(data)) {
                return true;
            }
            ptr = ptr.getNext();
        } while (ptr != this.head);
        return false;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int indexOf(T data) {
        if (this.head == null)
            return -1;
        int i = 0;
        var ptr = this.head;
        do {
            if (ptr.getData().equals(data)) {
                return i;
            }
            ptr = ptr.getNext();
            i++;
        } while (ptr != this.head);
        return -1;
    }

    public T[] toArray(T[] arr){
        if(arr.length < this.size){
            arr = Arrays.copyOf(arr, this.size);
        }
        Node<T> ptr = this.head;
        int i = 0;

        if(this.head != null){
            do{
                arr[i++] = ptr.getData();
                ptr = ptr.getNext();
            }while(ptr != this.head);
        }

        return arr;
    }

    public void fromArray(T[] arr) {
        this.clear();
        for (T val : arr) {
            this.addLast(val);
        }
    }

    public void reverse() {
        Node<T> slow = this.head;
        Node<T> fast = this.head.getNext();
        int i = 0;
        while (i < this.size - 1) {
            if (slow == this.head) {
                slow.setNext(this.tail);
            }
            var temp = fast;
            fast = fast.getNext();
            temp.setNext(slow);
            slow = temp;
            i++;
        }
        this.head = slow;
        this.tail = fast;
    }

    public String toString() {
        if (this.isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        var ptr = this.head;
        do {
            sb.append(ptr.getData());
            if (ptr.getNext() != this.head) {
                sb.append(", ");
            }
            ptr = ptr.getNext();
        } while (ptr != this.head);
        sb.append("]");
        return sb.toString();
    }
}