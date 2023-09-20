package prac5;


public class Functions {

    public static long factorial(int n) {
        // условие выхода
        // Базовый случай
        // когда остановиться повторять рекурсию ?
        if (n == 1) {
            return 1;
        }
        // Шаг рекурсии / рекурсивное условие
        return factorial(n - 1) * n;
    }

    public static String palindrom(String s){
        // Базовый случай
        if (s.length() == 1) {
            return "YES";
        } else {
            if (s.substring(0, 1).equals(s.substring(s.length() - 1, s.length()))) {
                // Базовый случай
                if (s.length() == 2) {
                    return "YES";
                }
                // Шаг рекурсии / рекурсивное условие
                return palindrom(s.substring(1, s.length() - 1));
            } else {
                return "NO";
            }
        }
    }

    public static int reverse(int n){
        // Базовый случай
        if (n < 10) {
            return n;
        }// Шаг рекурсии / рекурсивное условие
        else {
            System.out.print(n % 10);
            return reverse(n / 10);
        }
    }


}
