package Hashset;

import LL.LinkedList;

@SuppressWarnings("unchecked")
public class hashset<T>{
    private LinkedList<T>[] buckets;
    private int size;
    private double loadFactor, threshold;

    public hashset(int size){
        this.buckets = new LinkedList[size];
        this.size = 0;
        this.loadFactor = 0.75;
        this.threshold = this.loadFactor * this.buckets.length;
    }

    public boolean add(T data){
        if(data == null){
            System.err.println("The value can never be null");
            return false;
        }

        var hash = data.hashCode();
        var idx = Math.floorMod(hash, this.buckets.length);
        var ptr = this.buckets[idx];

        if(ptr == null){
            this.buckets[idx] = new LinkedList<T>(data);
            this.size++;
            if(this.size > this.threshold)
                this.resize();
            return true;
        }

        if(ptr.contains(data)){
            return false;
        }
        
        ptr.addLast(data);
        this.size++;
        if(this.size > this.threshold)
            this.resize();
        return true;
    }

    public boolean contains(T data){
        if(data == null){
            System.err.println("The value can never be null");
            return false;
        }

        var hash = data.hashCode();
        var idx = Math.floorMod(hash, this.buckets.length);
        var ptr = this.buckets[idx];
        
        if(ptr == null){
            return false;
        }
        return ptr.contains(data);
    }

    public boolean remove(T data){
        if(!contains(data)){
            System.err.println("The value is not present");
            return false;
        }

        var hash = data.hashCode();
        var idx = Math.floorMod(hash, this.buckets.length);
        var ptr = this.buckets[idx];

        if(ptr.first().equals(data)){
            if(ptr.size() != 1){
                ptr.removeFirst();
                this.size--;
                return true;
            }
            this.buckets[idx] = null;
            this.size--;
            return true;
        }

        ptr.removeValue(data);
        this.size--;
        return true;
    }

    private void resize(){
        LinkedList<T>[] arr = new LinkedList[this.buckets.length * 2];
        for(int i = 0; i < this.buckets.length; i++){
            LinkedList<T> ptr = this.buckets[i];
            if(ptr == null){
                continue;
            }

            var iterator = ptr.iterator();
            while(iterator.hasNext()){
                T data = iterator.next();
                var hash = data.hashCode();
                var idx = Math.floorMod(hash, arr.length);
                var p = arr[idx];

                if(p == null){
                    arr[idx] = new LinkedList<T>(data);
                    continue;
                }
                
                p.addLast(data);
            }
        }
        this.buckets = arr;
        this.threshold = this.loadFactor * arr.length;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        boolean first = true;
        for (LinkedList<T> bucket : buckets) {
            if (bucket == null) {
                continue;
            }
            var iterator = bucket.iterator();
            while (iterator.hasNext()) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append(iterator.next());
                first = false;
            }
        }
        sb.append("}");
        return sb.toString();
    }
}