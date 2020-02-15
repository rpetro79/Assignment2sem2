package BlockingQueueAdapter;

public interface BlockingQueue<T> {
    public int size();
    public void add(T element);
    public T retrieve();
    public boolean isEmpty();
    public String toString();
}
