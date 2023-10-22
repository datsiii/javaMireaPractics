package prac15.Ex2;


import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();
        queue.enqueue("Text1");
        queue.enqueue("Text2");
        queue.enqueue("Text3");
        System.out.println(queue.dequeue());
    }
}
