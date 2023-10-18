package prac13.Ex1;

import java.util.ArrayList;

public class Ex1 {
    public <E, T> ArrayList<Object> Execute(ArrayList<E> arr1, ArrayList<T> arr2) {
        ArrayList<Object> arr = new ArrayList<>();
        arr.addAll(arr1);
        arr.addAll(arr2);
        return arr;
    }
}

