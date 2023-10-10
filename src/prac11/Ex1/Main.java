package prac11.Ex1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Ex1.ExceptionIncorrectINN {

        Scanner myScanner = new Scanner( System.in);
        System.out.print( "Enter name ");
        String username = myScanner.next();

        Ex1.ExceptionIncorrectINN ex1 = new Ex1.ExceptionIncorrectINN("incorrect INN");
        ex1.exceptionDemo();
    }
}

class Ex1{
    public static class ExceptionIncorrectINN extends Exception{
        public ExceptionIncorrectINN(String errorMessage){
            super(errorMessage);
        }
        public long exceptionDemo() throws ExceptionIncorrectINN {
            System.out.print( "Enter INN ");
            try(Scanner myScanner = new Scanner( System.in)) {
                long INN  = Long.parseLong(myScanner.next());
                //System.out.println(INN);
                String INNs = Long.toString(INN);
                //System.out.println(INNs + " " + INN);
                if(INNs.length() == 12){
                    return INN;
                }
                else {throw new ExceptionIncorrectINN("Incorrect INN");}
           }
            catch (NumberFormatException err){
                throw new ExceptionIncorrectINN("Incorrect INN");
            }
        }
    }

}


