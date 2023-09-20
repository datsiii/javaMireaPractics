package somePractics;

import somePractics.Book;

import java.lang.*;

public class TestBook {
    public static void main(String[] args) {
        Book b1 = new Book("Eko Ogawa", "Memory police", 279, 45);
        Book b2 = new Book("E.M. Remark", "Life on loan");
        Book b3 = new Book();

        b2.setPages(237);
        b2.setReadingSpeed(55.0);
        b3.setAuthor("Frank Herbert");
        b3.setName("Dune");
        b3.setPages(896);
        //b3.setReadingSpeed(50);

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);

        b1.getTime();
        b2.getTime();
        b3.getTime();
    }
}
