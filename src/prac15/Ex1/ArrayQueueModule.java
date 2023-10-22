package prac15.Ex1;


public class ArrayQueueModule {

// INV: FIFO (First in - first out)
//      0 <= size <= q.length - 1
//      queue[head]..queue[tail] - queue
//      queue - Singleton
//      q.length = 2**x
    private int[] items = new int[SIZE];
    protected int front, rear;
    protected static final int SIZE = 16;

    // PRE: queue - null
    // POST: queue.size = 0;
    //       q.length = 16;
    private ArrayQueueModule(){
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
            // remove element from the front of queue
            element = items[front];
            // if the queue has only one element
            if (front >= rear) {
                front = -1;
                rear = -1;
            }
            else {
                // mark next element as the front
                front = (front + 1) % SIZE;
            }
            System.out.println( element + " Deleted");
            return (element);

        }

    }

    public void enqueue(int element){
        // if queue is full
        if (isFull()) {
            System.out.println("Queue is full");
        }
        else {
            if (front == -1)
                front = 0;
            rear = (rear + 1) % SIZE;
            items[rear] = element;
        }
    }
    public boolean clear(){
        boolean temp = !isEmpty();
        front=rear=0;

    }
}
