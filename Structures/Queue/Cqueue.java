package Queue;

public class Cqueue<T>{
    private T[] arr;
    private int size, front, rear, count;

    public Cqueue(int size){
        this.size  = size;
        this.arr   = (T[]) new Object[size];
        this.front = 0;
        this.rear  = 0;
        this.count = 0;
    }

    public boolean isFull(){
       return this.count == this.size;
    }

    public boolean isEmpty(){
        return this.count == 0;
    }

    public int size(){
        return this.count;
    }

    public String toString(){
        if (this.isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        var ptr = this.front;
        for(int i = 0; i < this.count; i++){
            sb.append(this.arr[ptr]);
            if(i != this.count - 1){
                sb.append(", ");
            }
            ptr = (ptr + 1) % this.size;
        }
        sb.append("]");
        return sb.toString();
    }

    public void enqueue(T data){
        if(isFull()){
            System.out.println("Queue Overflow");
            return;
        }

        this.arr[this.rear] = data;
        this.rear = (this.rear + 1) % this.size;
        this.count++;
    }

    public T dequeue(){
        if(isEmpty()){
            System.out.println("Queue Underflow");
            return null;
        }

        T data = this.arr[this.front];
        this.front = (this.front + 1) % this.size;
        this.count--;
        return data;
    }
}