package prac15.Ex2;

import prac15.Ex1.ArrayQueueModule;

import java.util.LinkedList;
public class LinkedQueue {
    private LinkedList<Object> items;
    protected int front, rear;
    protected static final int SIZE = 16;

    public static ArrayQueueModule instance;

    LinkedQueue(){
        items = new LinkedList<>();
        front = -1;
        rear = -1;
    }
    public boolean isEmpty() {
        return front == rear;
    }
    // check if the queue is full
    boolean isFull() {
        if (front == 0 && rear == SIZE - 1) {
            return true;
        }
        if (front == rear + 1) {
            return true;
        }
        return false;
    }

    public Object dequeue(){
        Object element;
        if(isEmpty()){
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        else {
            element = items.get(front);
            // remove element from the front of queue
            items.remove(front);
            System.out.println( element + " Deleted");
            return (element);

        }

    }

    public void enqueue(Object element){
        // if queue is full
        if (isFull()) {
            System.out.println("Queue is full");
        }
        else {
            if (front == -1)
                front = 0;
            rear = (rear + 1) % SIZE;
            items.add(element);
        }
    }

    public boolean clear(){
        boolean temp = !isEmpty();
        items.clear();
        front = rear = -1;
        return temp;
    }
    public Object element(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        return items.get(front);
    }

    public int size(){
        return items.size();
    }


}
