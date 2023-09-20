package prac5;


import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static long ex9(int a, int b) {
        if (a - 1 > b) return 0; else if (a - 1 == b) return 1; else return (
                (long) Functions.factorial(b + 1) /
                        (Functions.factorial(a) * Functions.factorial(b + 1 - a))
        );
    }

    public static void main(String[] args) {
        // EX 8
        System.out.println(Functions.palindrom("arаra"));

        // EX 9
        System.out.println(ex9(5, 5));

        // EX 10
        System.out.println(Functions.reverse(142146));


       // System.out.println(Functions.amount());
    }
}
