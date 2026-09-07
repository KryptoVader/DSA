package Queue;
import Stack.stack; 

public class queueS<T> {
    private stack<T> s1, s2;
    private int size, front, rear;

    public queueS(int size){
        this.size = size;
        this.s1 = new stack<T>(size);
        this.s2 = new stack<T>(size);
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

    public void enqueue(T data){
        if(isFull()){
            System.out.println("Queue Overflow");
            return;
        }

        s1.push(data);
        this.rear++;
    }

    public T dequeue(){
        if(isEmpty()){
            System.out.println("Queue Underflow");
            return null;
        }

        for(int i = 0; i < this.rear; i++){
            s2.push(s1.pop());
        }
        T data = s2.pop();
        this.rear--;
        for(int i = 0; i < this.rear; i++){
            s1.push(s2.pop());
        }
        return data;
    }

    public T peek(){
        if(isEmpty()){
            System.out.println("Queue Underflow");
            return null;
        }

        for(int i = 0; i < this.rear; i++){
            s2.push(s1.pop());
        }
        T data = s2.peek();
        for(int i = 0; i < this.rear; i++){
            s1.push(s2.pop());
        }
        return data;
    }

    public String toString(){
        for(int i = 0; i < this.rear; i++){
            s2.push(s1.pop());
        }
        String res = s2.toString();
        for(int i = 0; i < this.rear; i++){
            s1.push(s2.pop());
        }
        return res;
    }
}
