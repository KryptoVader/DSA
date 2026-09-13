package Hashmap;

import java.util.HashSet;

import Hashset.hashset;

@SuppressWarnings("unchecked")
public class hashmap<K,T>{
    private static class Node<K,T>{
        private T data;
        private K key;
        private Node<K,T> next;

        public Node(K key, T data){
            this.key = key;
            this.data = data;
            this.next = null;
        }

        public T getData(){
            return this.data;
        }

        public K getKey(){
            return this.key;
        }
        
        public Node<K,T> getNext(){
            return this.next;
        }

        public void setNext(Node<K,T> next){
            this.next = next;
        }

        public void setData(T data){
            this.data = data;
        }
    }

    private Node<K,T>[] buckets;
    private int size;
    private double loadFactor, threshold;

    public hashmap(int size){
        this.buckets = (Node<K,T>[]) new Node[size];
        this.size = 0;
        this.loadFactor = 0.75;
        this.threshold = this.loadFactor * this.buckets.length;
    }

    public int size(){
        return this.size;
    }

    public void put(K key, T value){
        if (key == null){
            System.err.println("Key cannot be null");
            return;
        }

        var hash = key.hashCode();
        var idx = Math.floorMod(hash, buckets.length);
        Node<K,T> ptr = this.buckets[idx];
        Node<K,T> prev = null;

        if(ptr == null){
            this.buckets[idx] = new Node<>(key, value);
            this.size++;
            if (this.size > this.threshold)
                this.resize();
            return;
        }

        while(ptr != null){
            if(ptr.getKey().equals(key)){
                ptr.setData(value);
                return ;
            }
            prev = ptr;
            ptr = ptr.getNext();
        }
        
        Node<K,T> n = new Node<>(key, value);
        prev.setNext(n);
        this.size++;
        if (this.size > this.threshold)
                this.resize();
        return;
    }

    public T get(K key){
        if (key == null){
            System.err.println("Key cannot be null");
            return null;
        }

        var hash = key.hashCode();
        var idx = Math.floorMod(hash, buckets.length);
        Node<K,T> ptr = this.buckets[idx];

        if(ptr == null){
            System.err.println("Key not found!");
            return null;
        }

        while(ptr != null){
            if(ptr.getKey().equals(key)){
                return ptr.getData();
            }
            ptr = ptr.getNext();
        }
        System.err.println("Key not found!");
        return null;
    }

    public void remove(K key){
        if (key == null){
            System.err.println("Key cannot be null");
            return;
        }

        var hash = key.hashCode();
        var idx = Math.floorMod(hash, buckets.length);
        Node<K,T> ptr = this.buckets[idx];
        Node<K,T> prev = null;

        if(ptr == null){
            System.err.println("Key not found!");
            return;
        }

        if(ptr.getKey().equals(key)){
            if(ptr.getNext() == null){
                this.buckets[idx] = null;
                this.size--;
                return;
            }
            this.buckets[idx] = ptr.getNext();
            this.size--;
            return;
        }

        while(ptr != null){
            if(ptr.getKey().equals(key)){
                prev.setNext(ptr.getNext());
                this.size--;
                return;
            }
            prev = ptr;
            ptr = ptr.getNext();
        }

        System.err.println("Key not found!");
        return;
    }

    public void resize(){
        Node<K,T>[] arr = (Node<K,T>[]) new Node[this.buckets.length * 2];
        for(int i = 0 ; i < this.buckets.length; i++){
            var ptr = this.buckets[i];
            while(ptr != null){
                K key = ptr.getKey();
                T value = ptr.getData();
                var hash = key.hashCode();
                var idx = Math.floorMod(hash, arr.length);

                if(arr[idx] == null){
                    arr[idx] = new Node<>(key, value);
                    ptr = ptr.getNext();
                    continue;
                }

                var p = arr[idx];
                while(p.getNext() != null){
                    p = p.getNext();
                }
                p.setNext(new Node<>(key, value));
                ptr = ptr.getNext();
            }
        }

        this.buckets = arr;
        this.threshold = this.loadFactor * this.buckets.length;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        boolean first = true;
        for (int i = 0; i < buckets.length; i++) {
            Node<K,T> ptr = buckets[i];
            while (ptr != null) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append(ptr.getKey()).append(" : ").append(ptr.getData());
                first = false;
                ptr = ptr.getNext();
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public hashset<K> keySet(){
        hashset<K> keys = new hashset<K>(this.size);
        for(int i = 0; i < this.buckets.length; i++){
            var ptr = this.buckets[i];
            if(ptr == null){
                continue;
            }

            while(ptr != null){
                keys.add(ptr.getKey());
                ptr = ptr.getNext();
            }
        }

        return keys;
    }

    public static void main(String[] args) {
        hashmap<String, Integer> map = new hashmap<>(9);

        // Basic insert
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 30);

        System.out.println("Map: " + map);
        System.out.println("Keys: " + map.keySet());

        // Update existing key
        map.put("B", 999);

        System.out.println("\nAfter updating B:");
        System.out.println("Map: " + map);
        System.out.println("Keys: " + map.keySet());

        // Remove
        map.remove("A");

        System.out.println("\nAfter removing A:");
        System.out.println("Map: " + map);
        System.out.println("Keys: " + map.keySet());

        // Trigger resize
        map.put("D", 40);
        map.put("E", 50);
        map.put("F", 60);
        map.put("G", 70);

        System.out.println("\nAfter resize:");
        System.out.println("Map: " + map);
        System.out.println("Keys: " + map.keySet());

        // Verify size == number of keys
        System.out.println("\nSize: " + map.size());
        System.out.println("Number of keys: " + map.keySet().size());
    }
}