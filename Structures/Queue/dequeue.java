package Queue;

import List.DynamicList;

public class dequeue<T> {
    private DynamicList<T> arr;
    private int size, front, rear, count;

    public dequeue(int size){
        this.size  = size;
        this.arr   = new DynamicList<>(size);
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
       return this.arr.toString();
    }

    public void insertFront(T data){
        if(isFull()){
            System.err.println("Queue overflow");
            return;
        }

        this.arr.add(this.front, data);
        this.rear++;
        this.count++;
    }

    public void insertRear(T data){
        if(isFull()){
            System.err.println("Queue overflow");
            return;
        }

        this.arr.add(this.rear, data);
        this.rear++;
        this.count++;
    }

    public T deleteFront(){
        if(isEmpty()){
            System.err.println("Queue underflow");
            return null;
        }

        T data = this.arr.get(this.front);
        this.arr.remove(this.front);
        this.rear--;
        this.count--;
        return data;
    }

    public T deleteRear(){
        if(isEmpty()){
            System.err.println("Queue underflow");
            return null;
        }

        T data = this.arr.get(this.rear-1);
        this.arr.remove(this.rear-1);
        this.count--;
        this.rear--;
        return data;
    }

    public T getFront(){
        if(isEmpty()){
            System.err.println("Queue underflow");
            return null;
        }

        return this.arr.get(this.front);
    }

    public T getRear(){
        if(isEmpty()){
            System.err.println("Queue underflow");
            return null;
        }

        return this.arr.get(this.rear-1);
    }

    public static void main(String[] args) {
        dequeue<Integer> d = new dequeue<>(5);
        for(int i = 0; i < 5; i++){
            d.insertFront(i+1);
        }
        System.out.println(d);
        System.out.println(d.deleteRear());
        d.insertRear(10);
        System.out.println(d.deleteFront());
        System.out.println(d.getFront() + ", " + d.getRear());
        System.out.println(d);
    }
}