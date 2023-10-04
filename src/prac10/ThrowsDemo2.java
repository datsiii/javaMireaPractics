package prac10;

import java.util.Scanner;

public class ThrowsDemo2 {
    public void getKey() {
        Scanner myScanner = new Scanner(System.in);
        boolean validInput = false;

        while (!validInput) {
            try {
                String key = myScanner.next();
                printDetails(key);
                validInput = true;
            } catch (Exception e) {
                System.out.println("Exception caught: " + e.getMessage());
                System.out.println("Please try again.");
            }
        }
    }

    public void printDetails(String key) throws Exception {
        try {
            String message = getDetails(key);
            System.out.println(message);
        } catch (Exception e) {
            throw e;
        }
    }

    private String getDetails(String key) throws Exception {
        if (key.equals("")) {
            throw new Exception("Key set to empty string");
        }
        return "data for " + key;
    }

    static public void main(String[] args){
        ThrowsDemo2 demo = new ThrowsDemo2();
        demo.getKey();
    }
}

