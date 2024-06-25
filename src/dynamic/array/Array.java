package dynamic.array;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class Array <T> implements Iterable<T> {

    private T[] array;
    private int length; //what use thinks the size is
    private int capacity; //actual size of array

    /*
    Calling the default constructer , if no value is given by the user , this(10) call the parameterized constructer
     */
    public Array() {
        this(10);
    }


    /*
    initializes the array with the inputed value or the default value from the default constructor
     */
    public Array(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Illegal capacity "+ capacity);
        }
        this.capacity = capacity;
        array = (T[]) new Object[capacity];

    }


    /*
    To return the size of the array
     */
    public int size() {
        return length;
    }

    /*
    Function to check if the size is empty or not
     */
    public boolean isEmpty() {
        return size() == 0;
    }


    /*
    get the element at the position of index
     */
    public T get(int index){
        return array[index];
    }

    public void set(int index, T elem){
        if (index < 0 || index >= length) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        array[index] = elem;
    }

    /*

     */
    public void clear(){
        for(int i=0; i<capacity;i++){
            array[i] = null;
        }
        length = 0;
    }


    /*
    here the length is used as both index of the array and for returning the actual length
     */

    //check if the this is object or array
    public void add(T elem){
        if(length == capacity) {
            capacity *= 2;
            T[] temp = (T[]) new Object[capacity];

            for(int i = 0; i < length; i++) {
                temp[i] = array[i];
            }
            array = temp;
        }
        array[length++] = elem;

    }


    /*
    to remove a value from the from an index location
     */
    public T removeAt(int index){
        T value = array[index];
        for(int i=index; i<length; i++){
            array[i] = array[i+1];
        }
        array[--length] = null;
        return value;
    }

    /*
    to remove element from the last of the array
     */
    public boolean removeLast(){
        if(isEmpty()){
            return false;
        }
        else {
            removeAt(length-1);
            return true;
        }
    }

    /*
    to remove an given element from the array
     */
    public boolean remove(Object obj){
        for(int i=0;i<length;i++){
            if(obj.equals(array[i])){
                removeAt(i);
                return true;
            }
        }
        return false;
    }


    /*
    To find the index of the given element
     */
    public int indexOf(Object obj){
        for(int i=0;i<length;i++){
            if(obj.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }


    /*
    used to if an element is present in the array
     */
    public boolean contains(Object obj){
        return indexOf(obj)!=-1;
    }

    /*
    overriding Iterator constructor
     */
    @Override
    public Iterator <T> iterator(){
            return new Iterator<T>() {
                int index = 0;
                public boolean hasNext() {  return index < length;  }
                public T next() {   return array[index++];  }
            };
        }

    /*
    overriding toString constructor/method
     */
    @Override
    public String toString(){
        if(length == 0){ return "[]";}
        StringBuilder sb = new StringBuilder(length).append("[");
        for(int i=0; i<length-1; i++){
            sb.append(array[i]).append(", ");
        }
        return sb.append(array[length-1]).append("]").toString();
    }


}



    


