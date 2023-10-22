package prac15.Ex1;

// INV: FIFO (First in - first out)
//      0 <= size <= q.length - 1
//      queue[head]..queue[tail] - queue
//      queue - Singleton
//      q.length = 2**x
public class ArrayQueueModule {

    private Object[] items;
    protected int front, rear;
    protected static final int SIZE = 16;

    public static ArrayQueueModule instance;

    private ArrayQueueModule(){
        items = new Object[SIZE];
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

    public void enqueue(Object element){
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
        //front=rear=0;
        Object[] new_items = new Object[SIZE];
        System.arraycopy(items, front, new_items, 0, Math.abs(front-rear));
        rear = Math.abs(front-rear);
        front = 0;
        items = new_items;
        return temp;
    }
    public Object element(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        return items[front];
    }

    public int size(){
        return items.length;
    }

    public static ArrayQueueModule getInstance(){
        if(instance == null){
            instance = new ArrayQueueModule();
        }
        return instance;
    }
}
