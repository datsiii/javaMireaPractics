package prac15.Ex2;

public interface Queue {
    public Object dequeue();
    public Object element();
    public void enqueue(Object item);
    public boolean isEmpty();
    public boolean clear();
    public int size();
}
