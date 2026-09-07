package Queue;

public class queue<T> {
    private T[] arr;
    private int size, front, rear;

    public queue(int size){
        this.size = size;
        this.arr = (T[]) new Object[size];
        this.front = 0;
        this.rear = 0;
    }

    public boolean isFull(){
        return this.size == this.rear;
    }

    public boolean isEmpty(){
        return this.front == this.rear;
    }

    public void enqueue(T value){
        if(isFull()){
            System.out.println("Queue Overflow");
            return;
        }

        this.arr[this.rear] = value;
        this.rear++;
    }

    public T dequeue(){
        if(isEmpty()){
            System.out.println("Queue Underflow");
            return null;
        }

        T data = this.arr[this.front];
        this.front++;
        return data;
    }

    public T peek(){
        if(isEmpty()){
            System.out.println("Queue Underflow");
            return null;
        }

        return this.arr[this.front];
    }   

    public int size(){
        return this.rear - this.front;
    }

    public String toString(){
        if (this.isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        var ptr = this.front;
        while(ptr < this.size){
            sb.append(this.arr[ptr]);
            if(ptr != this.rear - 1){
                sb.append(", ");
            }
            ptr++;
        }
        sb.append("]");
        return sb.toString();
    }
}
