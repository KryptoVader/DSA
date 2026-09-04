import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicList<T extends Object> implements Cloneable, Iterable<T>{
    private T[] arr;
    private int ele; // Used to showcase how many elements are present
    
    @SuppressWarnings("unchecked")
    public DynamicList(){
        this.arr = (T[]) new Object[1];
        this.ele = 0;
    }

    @SuppressWarnings("unchecked")
    public DynamicList(int capacity){
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative");
        }

        this.arr = (T[]) new Object[capacity];
        this.ele = 0;
    }

    /**
     * Adds the element at the last place very similar to static array.
     * 
     * @param n
     */
    public void add(T n){
        if (ele == arr.length){
            increase(); //This is the function responsible to create the new arr which is double in size of the current one.
        }
        arr[ele] = n;
        ele++;
    }

    /**
     * This version of add, Adds the element at the specified position while shifting rest elements
     * @param i this is the index i where we have to add the value n
     * @param n
     * @throws IndexOutOfBoundsException if the index i is not in range 0 <= i <= ele
     */
    public void add(int i, T n) throws IndexOutOfBoundsException{
        if(i < 0 || i > ele){
            throw new IndexOutOfBoundsException("Invalid Index Access!!");
        }
        
        if (ele == arr.length){
            increase(); //This is the function responsible to create the new arr which is double in size of the current one.
        }

        System.arraycopy(arr, i, arr, i + 1, ele - i);
        arr[i] = n;
        ele++;
    }

    /**
     * 
     * @param i
     * @return The element present at index i
     * @throws IndexOutOfBoundsException if the index i is not in range 0 <= i <= ele
     */
    public T get(int i) throws IndexOutOfBoundsException{
        if(i >= ele || i < 0){
            throw new IndexOutOfBoundsException("Invalid Index Access!!");
        }

        return this.arr[i];
    }

    /**
     * Removes the element at the specified index.
     *
     * @param i the index of the element to be removed
     * @throws IndexOutOfBoundsException if the index i is not in range 0 <= i <= ele
    */
    public void remove(int i) throws IndexOutOfBoundsException{
        if (i < 0 || i >= ele){
            throw new IndexOutOfBoundsException("Invalid Index Access!!");
        }

        System.arraycopy(arr, i + 1, arr, i, ele - i - 1);
        this.ele--;
    }

    /**
     * Removes the first occurrence of the specified element.
     * @param element the element to remove
     * @return true if the list contained the element
     * @throws NoSuchElementException if you choose the throwing variant
     */
    public void remove(T element) throws NoSuchElementException{
        int index = this.indexOf(element);
        if(index == -1){
            throw new NoSuchElementException("Element not found: " + element);
        }
        this.remove(index);
    }

    /**
     * This is the function focused on  Updating the value of an element present at index i and returns the old value.
     * 
     * @param i This is the index where the value is present
     * @param val This is the new value which we have to update with.
     * @throws IndexOutOfBoundsException if the index i is not in range 0 <= i <= ele
     */
    public T set(int i, T val) throws IndexOutOfBoundsException{
        if(i < 0 || i >= ele){
            throw new IndexOutOfBoundsException("Invalid Index Access!!");
        }
        
        T temp = this.arr[i];
        this.arr[i] = val;
        return temp;
    }

    /**
     * This is focused on whether the particular element is present or not
     * 
     * @param val This is the value which is to be searched
     * @return It returns boolean value true or false depending.
     */
    public boolean contains(T val){
        for(int i =0; i < this.ele; i++){
            if (this.arr[i].equals(val)){
                return true;
            }
        }
        return false;
    }

    /**
     * This returns the first index of the value present in the array
     * 
     * @param val
     * @return Returns the index if present else -1
     */
    public int indexOf(T val){
        for(int i =0; i < this.ele; i++){
            if (this.arr[i].equals(val)){
                return i;
            }
        }
        return -1;
    }

    /** 
     * This is used to reset the whole array or if you to clear the whole array.
    */
    @SuppressWarnings("unchecked")
    public void clear(){
        this.arr = (T[]) new Object[1];
        this.ele = 0;
    }

    /**
     * This returns the size of the current array i.e the number of elements present
     * @return int n
     */
    public int size(){
        return this.ele;
    }

    /**
     * Used to tell whether the array is empty or not
     * @return boolean 
     */
    public boolean isEmpty(){
        return this.ele == 0;
    }

    /**
     * Used to create an array of exact size.
     */
    public void trimToSize(){
        T[] arr1 = Arrays.copyOf(this.arr, this.ele);
        this.arr = arr1;
    }

    /**
     * This is used to reverse an array elements in place.
     */
    public void reverse(){
        for(int i =0; i < this.ele / 2; i++){
            T temp = this.arr[i];
            this.arr[i] = this.arr[ele - i -1];
            this.arr[ele - i - 1] = temp;
        }
    }

    @Override
    public DynamicList<T> clone() throws CloneNotSupportedException{
        DynamicList<T> n = new DynamicList<>();
        for(int i =0; i < this.ele; i++){
            n.add(this.arr[i]);
        }
        return n;
    }

    /**
     * Returns a new static array containing all elements in this dynamic array.
     *
     * @return an int array containing the stored elements
     */
    public T[] toArray(){
        T arr1[] = Arrays.copyOf(arr, ele);
        return arr1;
    }

    /**
     * Returns a new list containing the elements in the range [fromIndex, toIndex).
     *
     * @param fromIndex inclusive start (0‑based)
     * @param toIndex   exclusive end
     * @return a new DynamicList<T> with those elements
     * @throws IndexOutOfBoundsException if fromIndex < 0, toIndex > size(), or fromIndex > toIndex
     */
    public DynamicList<T> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > ele || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException(
                "fromIndex: " + fromIndex + ", toIndex: " + toIndex + ", size: " + ele
            );
        }
        DynamicList<T> slice = new DynamicList<>(toIndex - fromIndex);
        for (int i = fromIndex; i < toIndex; i++) {
            slice.add(this.arr[i]);
        }
        return slice;
    }

    private void increase(){
        this.arr = Arrays.copyOf(arr, this.arr.length * 2 + 1); 
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for(int i = 0 ; i < this.ele; i++){
            sb.append(this.arr[i]);
            if(i+1 != this.ele ){
                sb.append(", ");
            }
        }
        sb.append("}");
        return new String(sb);
    }

    @Override
    public Iterator<T> iterator(){
        return new DynamicListIterator();
    }

    private class DynamicListIterator implements Iterator<T>{
        private int cursor = 0;
        private boolean canRemove = false;

        /**
         * @return Returns whether the next element exists or not
         */
        @Override
        public boolean hasNext(){
            return this.cursor < DynamicList.this.size();
        }

        /**
         * @return Returns the current element
         * @throws NoSuchElementException
         */
        @Override
        public T next(){
            if(!hasNext()){
                throw new NoSuchElementException("No Element found");
            }
            T temp = DynamicList.this.get(this.cursor);
            this.cursor++;
            canRemove = true;
            return temp;
        }

        /**
         * This removes the current element
         * 
         * @throws IllegalStateException 
         */
        @Override
        public void remove(){
            if(!canRemove){
                throw new IllegalStateException("remove() can only be called once per next()");
            }
            DynamicList.this.remove(cursor - 1);
            this.cursor--;
            canRemove = false;
        }
    }
}