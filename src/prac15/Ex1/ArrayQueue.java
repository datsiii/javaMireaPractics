package prac15.Ex1;

// INV: FIFO (First in - first out)
//      0 <= size
//      queue[head]..queue[tail] - queue
public class ArrayQueue {
    private ArrayQueueModule queue;
    public ArrayQueue(){
        this.queue = ArrayQueueModule.getInstance();//неявно передаем ссылку на экземпляр
    }
    public Object dequeue(){
        return queue.dequeue();
    }
    public Object element(){
        return queue.element();
    }
    public void enqueue(Object item){
        queue.enqueue(item);
    }
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    public boolean clear() {
        return queue.clear();
    }
    public int size(){
        return queue.size();
    }
}
