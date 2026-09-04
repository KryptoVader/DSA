package LL;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Cloneable, Iterable<T>{
    private static class Node<T> implements Cloneable{
        private T data;
        private Node<T> next;

        public Node(T data){
            this.data = data;
            this.next = null;
        }

        public Node(T data, Node<T> next){
            this.data = data;
            this.next = next;
        }

        public T getData(){
            return this.data;
        }
        
        public Node<T> getNext(){
            return this.next;
        }

        public void setNext(Node<T> next){
            this.next = next;
        }

        public Node<T> clone() throws CloneNotSupportedException{
            return new Node<T>(this.data, this.next);
        }
    }

    private int size;
    private Node<T> head;
    private Node<T> tail;

    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public LinkedList(T data){
        Node<T> node = new Node<T>(data);
        this.head = node;
        this.tail = node;
        this.size = 1;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public T first(){
        if(this.isEmpty()){
            return null;
        }
        return this.head.getData();
    }

    public T last(){
        if(this.isEmpty()){
            return null;
        }
        return this.tail.getData();
    }

    public void addFirst(T data) throws NullPointerException{
        if(data == null){
            throw new NullPointerException("Give some Value");
        }
        Node<T> node = new Node<T>(data, this.head);
        if(this.isEmpty()){
            this.tail = node;
        }
        this.head = node;
        this.size++;
    }

    public void addLast(T data) throws NullPointerException{
        if(data == null){
            throw new NullPointerException("Give some Value");
        }
        Node<T> node = new Node<T>(data);
        if(this.isEmpty()){
            this.head = node;
            this.tail = node;
        } else {
            this.tail.setNext(node);
            this.tail = node;
        }
        this.size++;
    }

    //The Function here focuses on 0 Indexing so if index is 3 then it would mean i = 3 not 3rd element.
    public void addAt(int index, T data) throws IndexOutOfBoundsException{
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index is Invalid!!");
        }
        if(index == 0){
            this.addFirst(data);
        } else if (index == this.size){
            this.addLast(data);
        } else {
            int i =0;
            var ptr = this.head;
            while(i < index-1 && ptr != null){ // The reason for -1 is because while loop would go till that loop so like if i < 2 the it would stop at 2 so if I want at 2nd Index then it should then i should be at 1.
                ptr = ptr.getNext();
                i++;
            }

            Node<T> node = new Node<T>(data);
            node.setNext(ptr.getNext());
            ptr.setNext(node);
            this.size++;
        }
    }

    private void sizeZero(){
        this.head = null;
        this.tail = null;
    }

    public T removeFirst(){
        if(this.isEmpty()){
            throw new NoSuchElementException("removeFirst on empty list");
        }
        T data = this.head.getData();
        this.head = this.head.getNext();
        this.size--;

        if(this.size == 0){
            this.sizeZero();
        }
        return data;
    }


    public T removeLast(){
        if(this.isEmpty()){
            throw new NoSuchElementException("removeFirst on empty list");
        }
        T data = this.tail.getData();
        if(this.size == 1){
            this.size--;
            this.sizeZero();
            return data;
        }

        var ptr = this.head;

        while(ptr.getNext() != this.tail){
            ptr = ptr.getNext();
        }
        this.tail = ptr;
        this.tail.setNext(null);
        this.size--;

        if(this.size == 0){
            this.sizeZero();
        }
        return data;
    }

    public T removeAt(int index) throws IndexOutOfBoundsException{
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index is Invalid!!");
        }
        if(index == 0){
            return this.removeFirst();
        } else if (index == this.size-1){
            return this.removeLast();
        } else {
            int i =0;
            var slow = this.head;
            var fast = this.head.getNext();
            while( i < index-1 && fast != null){
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

    public T get(int index) throws IndexOutOfBoundsException{
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index is Invalid!!");
        }

        int i =0;
        var ptr = this.head;
        while(i < index && ptr != null){
            ptr = ptr.getNext();
            i++;
        }
        return ptr.getData();
    }

    public boolean contains(T data){
        var ptr = this.head;
        while(ptr != null){
            if(ptr.getData().equals(data)){
                return true;
            }
            ptr = ptr.getNext();
        }
        return false;
    }

    public void clear(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @SuppressWarnings("unchecked")
    public T[] toArray(){
        T[] arr = (T[])new Object[this.size];
        var ptr = this.head;
        int i = 0;
        while(ptr!= null){
            arr[i] = ptr.getData();
            i++;
            ptr = ptr.getNext();
        }
        return arr;
    }

    public void fromArray(T[] arr){
        this.clear();
        for (T val : arr) {
            this.addLast(val);
        }
    }

    public void reverse(){
        if (this.isEmpty() || this.head.getNext() == null) return;

        var curr = this.head;
        Node<T> prev = null;
        this.tail = this.head;
        while(curr != null){
            var next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        this.head = prev;
        this.tail.setNext(null);
    }

    public int indexOf(T data){
        int i = 0;
        var ptr = this.head;
        while(ptr != null){
            if(ptr.getData().equals(data)){
                return i;
            }
            ptr = ptr.getNext();
            i++;
        }
        return -1;
    }

    public LinkedList<T> clone() throws CloneNotSupportedException{
        if (this.isEmpty()) return new LinkedList<T>();
        var ll = new LinkedList<T>();
        var ptr = this.head;
        while(ptr != null){
            ll.addLast(ptr.getData());
            ptr = ptr.getNext();
        }
        return ll;
    }

    public void removeValue(T data) throws NoSuchElementException{
        if(! this.contains(data)){
            throw new NoSuchElementException("No such Element found");
        }
        int index = this.indexOf(data);
        this.removeAt(index);
    }

    public void removeAll(T data){
        while(this.contains(data)){
            this.removeValue(data);
        }
    }

    public LinkedList<T> subList(int from, int to){
        if(from < 0 || from >= this.size || to < 0 || to > this.size){
            throw new IndexOutOfBoundsException("Invalid Index");
        }
        if (from == to) return new LinkedList<T>();

        int i = 0;
        var ptr = this.head;
        while(ptr != null && i < from){
            ptr = ptr.getNext();
            i++;
        }

        LinkedList<T> ll = new LinkedList<>(ptr.getData());
        ptr = ptr.getNext();
        while(i < to && ptr != null){
            ll.addLast(ptr.getData());
            ptr = ptr.getNext();
            i++;
        }
        return ll;
    }

    public String toString() {
        if (this.isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        var ptr = this.head;
        while (ptr != null) {
            sb.append(ptr.getData());
            if (ptr.getNext() != null) sb.append(", ");
            ptr = ptr.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator(){
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T>{
        private int cursor = 0;
        private boolean canRemove = false;

        public boolean hasNext(){
            return this.cursor < LinkedList.this.size();
        }

        public T next(){
            if(!hasNext()){
                throw new NoSuchElementException("No Element found");
            }

            T temp = LinkedList.this.get(this.cursor);
            this.cursor++;
            canRemove = true;
            return temp;
        }

        public void remove(){
            if(!canRemove){
                throw new IllegalStateException("remove() can only be called once per next()");
            }
            LinkedList.this.removeAt(cursor - 1);
            this.cursor--;
            canRemove = false;
        }
    }
}