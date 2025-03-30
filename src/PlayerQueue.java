
// This class extends LinkedList to manage players' hands as FIFO queues 
import java.util.LinkedList;

public class PlayerQueue<E extends Card> extends LinkedList<E> {
    
    public void put(E card) {
        addLast(card);
    }

   
    public E get() {
        return isEmpty() ? null : removeFirst();
    }

   
    public E peek() {
        return getFirst();
    }
}
