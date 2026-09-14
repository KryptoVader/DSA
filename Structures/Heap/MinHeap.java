package Heap;
import List.DynamicList;

public class MinHeap<T extends Comparable<T>> {
    private DynamicList<T> list;

    public MinHeap(){
        this.list = new DynamicList<T>();
    }

    public MinHeap(T[] arr){
        this.list = new DynamicList<T>(arr);
        int parent = this.list.size() / 2 - 1;
        while(parent >= 0){
            int current = parent;
            while(2* current + 1 < this.list.size()){
                int right = 2 * current + 2;
                int left = 2* current + 1;
                var check = left;
                if(right < this.list.size()){
                    T rightChild = this.list.get(right);
                    T leftChild = this.list.get(left);
                    check = leftChild.compareTo(rightChild) < 0? left : right;
                }

                if(this.list.get(current).compareTo(this.list.get(check)) <= 0){
                    break;
                }

                this.list.swap(current, check);
                current = check;
            }
            parent--;
        }
    }

    public int size(){
        return this.list.size();
    }

    public boolean isEmpty(){
        return this.list.size() == 0;
    }

    public T peek(){
        if(this.isEmpty()){
            System.out.println("Heap is empty");
            return null;
        }
        return this.list.get(0);
    }

    public void insert(T x){
        if(x == null){
            System.err.println("The data cannot be null");
            return;
        }

        this.list.add(x);
        int idx = this.list.size() - 1;
        while(idx != 0){
            int parent = (idx - 1) / 2;
            if(this.list.get(idx).compareTo(this.list.get(parent)) < 0){
                this.list.swap(parent, idx);
                idx = parent;
            }
            else{
                break;
            }
        }
    }

    public T remove(){
        if(isEmpty()){
            System.out.println("The Heap is Empty");
            return null;
        }

        T data = this.list.get(0);
        this.list.swap(0, this.size()-1);
        this.list.remove(this.size()-1);

        if(this.list.size() == 0){
            return data;
        }

        int idx = 0;
        while(2*idx+1 < this.list.size()){
            int left = 2*idx + 1;
            int right = 2*idx + 2;
            var check = left;
            if(right < this.list.size()){
                T rightChild = this.list.get(right);
                T leftChild = this.list.get(left);
                check = leftChild.compareTo(rightChild) < 0? left : right;
            }
            
            if(this.list.get(idx).compareTo(this.list.get(check)) > 0){
                this.list.swap(idx, check);
                idx = check;
            }
            else{
                break;
            }
        }
        return data;
    }

    public String toString(){
        return this.list.toString();
    }

    public static void main(String[] args){
        Integer[] arr = {40, 10, 30, 5, 20, 15, 2, 50, 1};
        MinHeap<Integer> h = new MinHeap<>(arr);
        System.out.println(h);
        while (!h.isEmpty()) 
            System.out.println(h.remove());
    }   
}
