package prac10;

import com.sun.jdi.ThreadReference;
import com.sun.jdi.event.ExceptionEvent;

import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;
import java.security.PrivilegedExceptionAction;
import java.util.Scanner;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Ex1.Exception1_1 ex1 = new Ex1.Exception1_1();
        ex1.exceptionDemo();

        Ex2.Exception2 ex2 = new Ex2.Exception2();
        ex2.exceptionDemo();

        Ex6.ThrowsDemo ex6 = new Ex6.ThrowsDemo();
        ex6.printMessage(null);

        Ex8.ThrowsDemo ex8 = new Ex8.ThrowsDemo();
        ex8.getKey();


    }
}

class Ex1{
    public static class Exception1_1 {
        public void exceptionDemo() {
            try{
                System.out.println( 2/0 );
            } catch ( ArithmeticException e ) {
                System.out.println("Attempted division by zero");
            }
        }
    }
    public static class Exception1 {
        public void exceptionDemo() {
            System.out.println( 2 / 0 );
            /*
                    Exception in thread "main" java.lang.ArithmeticException: / by zero
                    	at Ex1$Exception1.exceptionDemo(Main.java:14)
                    	at Main.main(Main.java:6)
            */
        }
    }
}


class Ex2{
    public static class Exception2 {
        public void exceptionDemo() {
            Scanner myScanner = new Scanner( System.in);
            System.out.print( "Enter an integer ");
            String intString = myScanner.next();
            try {
                int i = Integer.parseInt(intString);
                System.out.println( 2/i );
            }catch (NumberFormatException e){
                System.out.println("NumberFormatException");
            }catch (ArithmeticException e){
                System.out.println("ArithmeticException");
            }

            /*
            Enter an integer qwre
            Exception in thread "main" java.lang.NumberFormatException: For input string: "qwre"
                at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
                at java.base/java.lang.Integer.parseInt(Integer.java:665)
                at java.base/java.lang.Integer.parseInt(Integer.java:781)
                at Ex2$Exception2.exceptionDemo(Main.java:44)
                at Main.main(Main.java:10)
             */
            /*
            Enter an integer 0
            Exception in thread "main" java.lang.ArithmeticException: / by zero
                at Ex2$Exception2.exceptionDemo(Main.java:45)
                at Main.main(Main.java:10)
             */
            /*
            Enter an integer 1.2
            Exception in thread "main" java.lang.NumberFormatException: For input string: "1.2"
                at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
                at java.base/java.lang.Integer.parseInt(Integer.java:665)
                at java.base/java.lang.Integer.parseInt(Integer.java:781)
                at Ex2$Exception2.exceptionDemo(Main.java:44)
                at Main.main(Main.java:10)
             */
            /*
            Enter an integer 1
            2
             */
        }
    }
}

class Ex3{
    public static class Exception3 {
        public void exceptionDemo() {
            Scanner myScanner = new Scanner( System.in);
            System.out.print( "Enter an integer ");
            String intString = myScanner.next();
//            try {
//                int i = Integer.parseInt(intString);
//                System.out.println( 2/i );
//            }catch (Exception e) {
//                System.out.println("Exception");
//            } catch (NumberFormatException e){
//                System.out.println("NumberFormatException");
//            }catch (ArithmeticException e){
//                System.out.println("ArithmeticException");
//            }
            /*
            java: exception java.lang.NumberFormatException has already been caught
             */
        }
    }
}

class Ex4{
    public static class Exception4 {
        public void exceptionDemo() {
            Scanner myScanner = new Scanner( System.in);
            System.out.print( "Enter an integer ");
            String intString = myScanner.next();
            try {
                int i = Integer.parseInt(intString);
                System.out.println( 2/i );
            }catch (NumberFormatException e){
                System.out.println("NumberFormatException");
            }catch (ArithmeticException e){
                System.out.println("ArithmeticException");
            }finally {
                System.out.println("-----Программа заверщена----");
            }
        }
    }
}

class Ex5{
    public class ThrowsDemo {
        public void getDetails(String key) {
            if(key == null) {
                try {
                    throw new NullPointerException("null key in getDetails" );
                }catch (NullPointerException e){
                    System.out.println("Выход");
                }
            }
            // do something with the key
        }
    }
}
class Ex6 {
    public static class ThrowsDemo {
        public void printMessage(String key) {
            String message = null;
            try {
                message = getDetails(key);
            } catch (NullPointerException e) {
                message = "Null";
            }

            System.out.println(message);
        }
        public String getDetails(String key) throws NullPointerException{
            if(key == null) {
                throw new NullPointerException( "null key in getDetails" );
            }
            return "data for" + key; }
        // data for123
        /*
        Exception in thread "main" java.lang.NullPointerException: null key in getDetails
            at Ex6$ThrowsDemo.getDetails(Main.java:154)
            at Ex6$ThrowsDemo.printMessage(Main.java:149)
            at Main.main(Main.java:13)
         */
    }
}



class Ex8 {
    public static class ThrowsDemo {
        public void getKey() {
            Scanner myScanner = new Scanner( System.in );
            String key = myScanner.next();
            System.out.println("Введите данные: ");
            while (true) {
                try {
                    printDetails(key);
                    break;
                } catch (Exception e) {
                    System.out.println("Ошибка\nВведите новые данные: ");
                    key = myScanner.next();
                }
            }
        }
        public void printDetails(String key) throws Exception {
            String message = getDetails(key);
            System.out.println( message );
        }
        private String getDetails(String key) throws Exception {
            if(key.equals("123"))
                throw new Exception( "Key set to empty string" );
            return "data for " + key; }
    }

}

class Ex7_1{
    public static class ThrowsDemo {
        public void getKey() {
            Scanner myScanner = new Scanner( System.in );
            String key = myScanner.next();
            try {
                printDetails( key );
            }catch (Exception e){
                System.out.println("Ошибка");
            }
        }
        public void printDetails(String key) throws Exception {
            String message = getDetails(key);
            System.out.println( message );
        }
        private String getDetails(String key) throws Exception {
            if(key == "")
                throw new Exception( "Key set to empty string" );
            return "data for " + key; }
    }

}