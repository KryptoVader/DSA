package Stack;

import LL.LinkedList;
public class stackLL<T> {
    private LinkedList<T> l;
    private int size, top;

    public stackLL(int size){
        this.l = new LinkedList<>();
        this.size = size;
        this.top = -1;
    }

    public boolean isFull(){
        return this.size == this.top + 1;
    }

    public boolean isEmpty(){
        return this.top == -1;
    }

    public void push(T data){
        if(isFull()){
            System.err.println("Stack Overflow");
            return;
        }

        this.l.addFirst(data);
        this.top++;
    }

    public T pop(){
        if(isEmpty()){
            System.err.println("Stack underflow");
            return null;
        }
        T data = this.l.removeFirst();
        this.top--;
        return data;
    }

    public T peek(){
        if(isEmpty()){
            System.err.println("Stack underflow");
            return null;
        }
        T data = this.l.removeFirst();
        this.l.addFirst(data);
        return data;
    }

    public int size(){
        return this.size;
    }

    public String toString() {
        if (this.isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        var ptr = this.l.iterator();
        int i = this.top;
        while(ptr.hasNext()){
            sb.append(ptr.next());
            if(i == 0){
                sb.append(", ");
            }
            i--;
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        stack<Integer> s = new stack<>(5);
        for(int i = 0; i < 5; i++){
            s.push(i+1);
        }
        System.out.println(s);
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s);
    }
}
