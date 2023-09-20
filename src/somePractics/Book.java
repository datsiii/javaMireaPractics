package somePractics;

import java.lang.*;

public class Book {
    private String author;

    private String name;
    private int pages;
    private double readingSpeed;

    public Book(String author, String name,  int pages, double readingSpeed){
        this.author = author;
        this.name = name;
        this.pages = pages;
        this.readingSpeed = readingSpeed;
    }

    public Book(String author, String name){
        this.author = author;
        this.name = name;
        this.readingSpeed = 50.0;
    }

    public Book(){
        this.author = "";
        this.name = "";
        this.pages = 0;
        this.readingSpeed = 50.0;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPages(int pages){
        this.pages = pages;
    }

    public void setReadingSpeed(double readingSpeed){
        this.readingSpeed = readingSpeed;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public int getPages() {
        return pages;
    }

    public double getReadingSpeed() {
        return readingSpeed;
    }

    public String toString() {
        return "the book "+name+" written by "+author+" has "+pages+" pages";
    }

    public void getTime(){
        System.out.println("time needed to read "+name+": "+(pages/readingSpeed)+" hours");
    }
}
