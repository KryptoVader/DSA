package Stack;

public class stack<T> {
    private T[] arr;
    private int size;
    private int top;

    public stack(int size){
        this.size = size;
        this.arr = (T[]) new Object[size];
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
        this.top++;
        this.arr[this.top] = data;
        return;
    }

    public T pop(){
        if(isEmpty()){
            System.err.println("Stack underflow");
            return null;
        }
        T d = this.arr[this.top];
        this.top--;
        return d;
    }

    public T peek(){
        if(isEmpty()){
            System.err.println("Stack underflow");
            return null;
        }
        return this.arr[this.top];
    }

    public int size(){
        return this.size;
    }

    public String toString() {
        if (this.isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        var ptr = this.top;
        while(ptr >= 0){
            sb.append(this.arr[ptr]);
            if(ptr != 0){
                sb.append(", ");
            }
            ptr--;
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