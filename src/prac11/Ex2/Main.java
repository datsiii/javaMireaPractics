package prac11.Ex2;

import prac11.Ex2.Student;

import java.util.ArrayList;
public class Main {
    private static int separation(Student[] arr, int left, int right) {
        Student separator = arr[right];
        int i = (left - 1);

        Student temp;
        for (int j = left; j <= right - 1; j++) {
            if (arr[j].getSortingByGPA().compare(arr[j], separator) != 1) {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;
        return (i + 1);
    }

    public static void quickSort(Student[] arr, int left, int right) {
        if (left < right) {
            int separator = separation(arr, left, right);

            quickSort(arr, left, separator - 1);
            quickSort(arr, separator + 1, right);
        }
    }
    public static void main(String[] args) {
        ArrayList<Student> s = new ArrayList<>();
        s.add(new Student("Alex", 1, 100));
        s.add(new Student("Nike", 2, 25));
        s.add(new Student("John", 4, 34));
        s.add(new Student("Amber", 5, 120));
        s.add(new Student("Feifeili", 3, 0));

        //insertionSort(iDNumber);
        //quickSort(iDNumber, 0, iDNumber.length - 1);

        /*for (Student student : iDNumber) {
            System.out.println(student);
        }*/

        new LabClassUI(s);
    }
}
