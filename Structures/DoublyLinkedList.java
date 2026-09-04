import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements Iterable<T>{
    private static class Node<T>{
        private T data;
        private Node<T> prev;
        private Node<T> next;

        public Node(T data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }

        public Node(T data, Node<T> prev, Node<T> next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public T getData(){
            return this.data;
        }

        public Node<T> getNext(){
            return this.next;
        }

        public Node<T> getPrev(){
            return this.prev;
        }

        public void setNext(Node<T> next){
            this.next = next;
        }

        public void setPrev(Node<T> prev){
            this.prev = prev;
        }

        public void setData(T data){
            this.data = data;
        }
    } 

    private int size;
    private Node<T> head; // Sentinels
    private Node<T> tail; //Sentinels

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public DoublyLinkedList(T data){
        Node<T> node = new Node<T>(data);
        this.head = new Node<T>(null);
        this.tail = new Node<T>(null, node, null);
        this.head.setNext(node);
        node.setPrev(this.head);
        node.setNext(this.tail);
        this.size = 1;
    }

    public int getSize(){
        return this.size;
    }

    public T first() throws NoSuchElementException{
        if(this.isEmpty()){
            throw new NoSuchElementException("Linked List is Empty");
        }
        return this.head.getNext().getData();
    }

    public T last() throws NoSuchElementException{
        if(this.isEmpty()){
            throw new NoSuchElementException("Linked List is Empty");
        }
        return this.tail.getPrev().getData();
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public void addFirst(T data) throws NullPointerException{
        if(data == null) throw new NullPointerException("Data cannot be null");
        if(this.isEmpty()){
            Node<T> node = new Node<T>(data);
            this.head = new Node<T>(null);
            this.tail = new Node<T>(null, node, null);
            this.head.setNext(node);
            node.setPrev(this.head);
            node.setNext(this.tail);
            this.size = 1;
        }
        else {
            Node<T> node = new Node<T>(data, this.head, this.head.getNext());
            this.head.getNext().setPrev(node);
            this.head.setNext(node);
            this.size++;
        }
    }

    public void addLast(T data) throws NullPointerException{
        if(data == null) throw new NullPointerException("Data cannot be null");
        if(this.isEmpty()){
            Node<T> node = new Node<T>(data);
            this.head = new Node<T>(null);
            this.tail = new Node<T>(null, node, null);
            this.head.setNext(node);
            node.setPrev(this.head);
            node.setNext(this.tail);
            this.size = 1;
        }
        else {
            Node<T> node = new Node<T>(data, this.tail.getPrev(), this.tail);
            this.tail.getPrev().setNext(node);
            this.tail.setPrev(node);
            this.size++;
        }
    }

    public void addAt(int index, T data) throws IndexOutOfBoundsException, IllegalArgumentException{
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Inavlid Index");
        }
        if (data == null) throw new IllegalArgumentException("The data cannot be null");
        if(index == 0){
            this.addFirst(data);
        }
        else if( index == this.size){
            this.addLast(data);
        }
        else {
            int i = 0; 
            var ptr = this.head.getNext();
            while(i < index-1 && ptr != this.tail){
                ptr = ptr.getNext();
                i++;
            }
            Node<T> node = new Node<>(data,ptr, ptr.getNext());
            ptr.getNext().setPrev(node);
            ptr.setNext(node);
            this.size++;
        }
    } 

    public T removeFirst(){
        T data = this.head.getNext().getData();
        this.head.setNext(this.head.getNext().getNext());
        this.head.getNext().setPrev(this.head);
        this.size--;
        return data;
    }

    public T removeLast(){
        T data = this.tail.getPrev().getData();
        this.tail.setPrev(this.tail.getPrev().getPrev());
        this.tail.getPrev().setNext(this.tail);
        this.size--;
        return data;
    }

    public T removeAt(int index) throws IndexOutOfBoundsException{
        if(index < 0 || index >= this.size) throw new IndexOutOfBoundsException("Invalid Index");
        T data = null;
        if(index == 0){
            this.removeFirst();
        } 
        else if (index == this.size-1){
            this.removeLast();
        }
        else{
            int i = 0;
            var slow = this.head;
            var fast = this.head.getNext();
            while(i < index){
                i++;
                slow = slow.getNext();
                fast = fast.getNext();
            }

            data = fast.getData();
            slow.setNext(fast.getNext());
            fast.getNext().setPrev(slow);
            this.size--;
        }
        return data;
    }

    public boolean contains(T data){
        var ptr = this.head.getNext();
        while(ptr != this.tail){
            if(ptr.getData() == data){
                return true;
            }
            ptr = ptr.getNext();
        }
        return false;
    }

    public int indexOf(T data){
        var ptr = this.head.getNext();
        int i = 0;
        while(ptr != this.tail){
            if(ptr.getData() == data){
                return i;
            }
            ptr = ptr.getNext();
            i++;
        }
        return -1;
    }

    public int lastIndexOf(T data){
        var ptr = this.tail.getPrev();
        int i = this.size - 1;
        while(ptr != this.head){
            if(ptr.getData() == data){
                return i;
            }
            ptr = ptr.getPrev();
            i--;
        }
        return -1;
    }

    public void clear(){
        this.head.setNext(this.tail);
        this.tail.setPrev(this.head);
        this.size = 0;
    }

    public T get(int index){
        if(index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException("Invalid Index");
        }

        int i = 0;
        var ptr = this.head.getNext(); 
        while(i < index){
            i++;
            ptr = ptr.getNext();
        }
        return ptr.getData();
    }

    public void set(int index, T data) throws IndexOutOfBoundsException, IllegalArgumentException{
        if(index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException("Invalid Index");
        }
        if(data == null) throw new IllegalArgumentException("Invalid data");
        int i = 0;
        var ptr = this.head.getNext(); 
        while(i < index){
            i++;
            ptr = ptr.getNext();
        }
        ptr.setData(data);
    }

    public String toString(){
        var sb = new StringBuilder();
        sb.append("[ ");
        var ptr = this.head.getNext();
        while(ptr != this.tail){
            sb.append(ptr.getData());
            if(ptr.getNext() != this.tail){
                sb.append(", ");
            }
            ptr = ptr.getNext();
        }
        sb.append(" ]");
        return new String(sb);
    }

    public Iterator<T> iterator(){
        return new DoublyLinkedListIterator();
    }

    public Iterator<T> reverseIterator(){
        return new DoublyLinkedListReverseIterator();
    }

    private class DoublyLinkedListIterator implements Iterator<T>{
        private int cursor = 0;
        private boolean canRemove = false;

        public boolean hasNext(){
            return this.cursor < DoublyLinkedList.this.getSize();
        }

        public T next(){
            if(!hasNext()){
                throw new NoSuchElementException("No Element found");
            }

            T temp = DoublyLinkedList.this.get(this.cursor);
            this.cursor++;
            canRemove = true;
            return temp;
        }

        public void remove(){
            if(!canRemove){
                throw new IllegalStateException("remove() can only be called once per next()");
            }
            DoublyLinkedList.this.removeAt(this.cursor - 1);
            this.cursor--;
            canRemove = false;
        }
    }

    private class DoublyLinkedListReverseIterator implements Iterator<T> {
        private Node<T> current = DoublyLinkedList.this.tail.prev;
        private boolean canRemove = false;

        public boolean hasNext() {
            return current != DoublyLinkedList.this.head; 
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No element found");
            }
            T data = current.data;
            current = current.prev; 
            canRemove = true;
            return data;
        }

        public void remove() {
            if (!canRemove) {
                throw new IllegalStateException("remove() can only be called once per next()");
            }

            Node<T> toRemove = current.next;
            toRemove.prev.next = toRemove.next;
            toRemove.next.prev = toRemove.prev;

            DoublyLinkedList.this.size--;
            canRemove = false;
        }
    }
}
