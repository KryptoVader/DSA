package Queue;
import LL.LinkedList;

public class queueLL<T> {
    private LinkedList<T> l;
    private int front, rear, size;

    public queueLL(int size){
        this.l = new LinkedList<>();
        this.size = size;
        this.front = 0;
        this.rear = 0;
    }

    public boolean isFull(){
        return this.size == this.rear;
    }

    public boolean isEmpty(){
        return this.front == this.rear;
    }

    public int size(){
        return this.rear - this.front;
    }

    public void enqueue(T value){
        if(isFull()){
            System.out.println("Queue Overflow");
            return;
        }

        this.l.addLast(value);
        this.rear++;
    }

    public T dequeue(){
        if(isEmpty()){
            System.out.println("Queue Underflow");
            return null;
        }

        T data = this.l.removeFirst();
        this.front++;
        return data;
    }

    public T peek(){
        if(isEmpty()){
            System.out.println("Queue Underflow");
            return null;
        }

        T data = this.l.removeFirst();
        this.l.addFirst(data);
        return data;
    }   

    public String toString() {
        if (this.isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        var ptr = this.l.iterator();
        int i = this.front;
        while(ptr.hasNext()){
            sb.append(ptr.next());
            if(i != this.rear){
                sb.append(", ");
            }
            i++;
        }
        sb.append("]");
        return sb.toString();
    }
}
