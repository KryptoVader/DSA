import java.util.Arrays;

class Array implements Cloneable{
    private int[] arr;
    private int ele; // Used to showcase how many elements are present
    Array(){
        arr = new int[1];
        ele = 0;
    }

    Array(int capacity) throws IllegalAccessException{
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative");
        }

        this.arr = new int[capacity];
        this.ele = 0;
    }

    /**
     * Adds the element at the last place very similar to static array.
     * 
     * @param n
     */
    public void add(int n){
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
    public void add(int i, int n) throws IndexOutOfBoundsException{
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
    public int get(int i) throws IndexOutOfBoundsException{
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
     * This is the function focused on  Updating the value of an element present at index i and returns the old value.
     * 
     * @param i This is the index where the value is present
     * @param val This is the new value which we have to update with.
     * @throws IndexOutOfBoundsException if the index i is not in range 0 <= i <= ele
     */
    public int set(int i, int val) throws IndexOutOfBoundsException{
        if(i < 0 || i >= ele){
            throw new IndexOutOfBoundsException("Invalid Index Access!!");
        }
        
        int temp = this.arr[i];
        this.arr[i] = val;
        return temp;
    }

    /**
     * This is focused on whether the particular element is present or not
     * 
     * @param val This is the value which is to be searched
     * @return It returns boolean value true or false depending.
     */
    public boolean contains(int val){
        for(int i =0; i < this.ele; i++){
            if (this.arr[i] == val){
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
    public int indexOf(int val){
        for(int i =0; i < this.ele; i++){
            if (this.arr[i] == val){
                return i;
            }
        }
        return -1;
    }

    /** 
     * This is used to reset the whole array or if you to clear the whole array.
    */
    public void clear(){
        this.arr = new int[1];
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
        int[] arr1 = Arrays.copyOf(this.arr, this.ele);
        this.arr = arr1;
    }

    /**
     * This is used to reverse an array elements in place.
     */
    public void reverse(){
        for(int i =0; i < this.ele / 2; i++){
            int temp = this.arr[i];
            this.arr[i] = this.arr[ele - i -1];
            this.arr[ele - i - 1] = temp;
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        Array n = new Array();
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
    public int[] toArray(){
        int arr1[] = Arrays.copyOf(arr, ele);
        return arr1;
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
}

public class DynamicArray{
    public static void main(String[] args) {
        try{
            Array arr = new Array();
            for (int i =0; i < 5; i++){
                arr.add(i);
            }
            System.out.println(arr);
            arr.remove(4);
            arr.set(2, 10);
            System.out.println(arr);
            System.out.println(arr.size());
            arr.reverse();
            System.out.println(arr);
            var arr1 = (Array) arr.clone();
            System.out.println(arr1);

            for(int  i =0; i < 10; i++){
                arr.add(i);
            }
            System.out.println(arr);
        } catch (CloneNotSupportedException e){
            System.out.println(e.getMessage());
        } catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println(e);
        }
    }
}