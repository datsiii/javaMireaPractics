package prac13.Ex2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyArray {
    ArrayList<Object> arr;

    public MyArray(ArrayList<?>... arr) {
        this.arr = new ArrayList<>();
        this.arr.addAll(Arrays.asList(arr));
    }

    public void add(Object el) {
        arr.add(el);
    }

    public void addAll(Object...el){
        arr.addAll(Arrays.asList(el));
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(arr);
        return sb.toString();
    }

    public Object get(int index) {
        return arr.get(index);
    }
}
