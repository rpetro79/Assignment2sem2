package BlockingQueueAdapter;

public class BlockingQueueAdapter<T> implements BlockingQueue<T> {
    private ArrayList<T> q;
    private int cap;

    public BlockingQueueAdapter(int cap) {
        this.cap = cap;
        q = new ArrayList<T>();
    }

    public int size()
    {
        return q.size();
    }

    public synchronized void add(T element)
    {
        while(q.size() >= cap)
        {
            try {
                wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        q.add(element);
        notifyAll();
    }

    public synchronized T retrieve()
    {
        while(q.isEmpty())
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T el = q.remove(0);
        notifyAll();
        return el;
    }

    public boolean isEmpty()
    {
        return q.isEmpty();
    }

    public String toString()
    {
        return q.toString();
    }
}
