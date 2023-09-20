package prac6;

public class App {

    /*public static <T> void insertionSort(Comparable<T>[] arr) {
        Comparable<T> current;
        for (int i = 1; i < arr.length; i++) {
            current = arr[i];
            for (int j = i; j > 0; j--) {
                if (arr[j - 1].compareTo((T) current) == 1) {
                    arr[j] = arr[j - 1];
                } else {
                    arr[j] = current;
                    break;
                }
            }
        }
    }*/


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
        Student[] iDNumber = new Student[5];
        iDNumber[0] = new Student("Alex", 1, 100);
        iDNumber[1] = new Student("Nike", 2, 25);
        iDNumber[2] = new Student("John", 4, 34);
        iDNumber[3] = new Student("Amber", 5, 120);
        iDNumber[4] = new Student("Feifeili", 3, 0);

        //insertionSort(iDNumber);
        quickSort(iDNumber, 0, iDNumber.length - 1);

        for (Student student : iDNumber) {
            System.out.println(student);
        }
    }
}
