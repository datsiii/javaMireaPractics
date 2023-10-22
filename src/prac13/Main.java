package prac13;
import prac13.Ex1.Ex1;
import prac13.Ex2.MyArray;
import prac13.Ex3.Files;
import prac13.Ex4.Solution;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> arr1 = new ArrayList<>(Arrays.asList(
                "123fd",
                "111",
                "555"
        ));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(
                1,
                14,
                16
        ));

        Ex1 ex1 = new Ex1();
        ArrayList<Object> arr = ex1.Execute(arr1, arr2);
        System.out.println(arr);

        MyArray myArr = new MyArray(arr1, arr2);
        System.out.println(myArr);
        myArr.add(arr);
        myArr.addAll(arr,arr1, arr2, "123", 123, 12.0, .01, 1e10 );
        System.out.println(myArr);;
        System.out.println(myArr.get(5));

        String directoryPath = "c:\\";
        Files ex4 = new Files();
        ex4.listFilesInDirectory(directoryPath);
        System.out.println(ex4.getFifthEl());



        Solution<String, String, Integer> solution = new Solution<>();

        solution.addToArrayList("one");
        solution.addToArrayList("two");
        solution.addToArrayList("three");
        List<String> stringList = solution.getList();
        System.out.println(stringList);

        solution.addToHashSet("apple");
        solution.addToHashSet("banana");
        solution.addToHashSet("cherry");
        Set<String> stringSet = solution.getSet();
        System.out.println(stringSet);

        solution.addToHashMap("key1", 1);
        solution.addToHashMap("key2", 2);
        solution.addToHashMap("key3", 3);
        HashMap<String, Integer> stringIntMap = solution.getMap();
        System.out.println(stringIntMap);

        List<Integer> intList = Solution.newArrayList(1, 2, 3, 4, 5);
        System.out.println(intList);

        Set<Integer> intSet = Solution.newHashSet(1, 2, 3, 4, 5);
        System.out.println(intSet);

        String [] keys = {"key1", "key2", "key3"};
        Integer[] values = {1, 2, 3};
        HashMap<String, Integer> hashMap = Solution.newHashMap(keys, values);
        System.out.println(hashMap);
    }

}