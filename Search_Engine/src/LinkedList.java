
public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private Node<T> current;
    public LinkedList () {
        head = current = null;
    }
    public boolean empty () {
        return head == null;
    }
    public boolean last () {
        return current.next == null;
    }
    public boolean full () {
        return false; }
    public void findFirst () {
        current = head;
    }
    public void findNext () {
        current = current.next; }
    public T retrieve () {
        return current.data; }
    public void update (T val) {
        current.data = val; }
    public void insert (T val) {
        Node<T> tmp;
        if (empty()) {
            current = head = new Node<T> (val);
        }
        else {
            tmp = current.next;
            current.next = new Node<T> (val);
            current = current.next;
            current.next = tmp;
        }
    }
    public void remove () {
        if (current == head) {
            head = head.next;
        }
        else {
            Node<T> tmp = head;
            while (tmp.next != current)
                tmp = tmp.next;
            tmp.next = current.next;
        }
        if (current.next == null)
            current = head;
        else
            current = current.next;
    }

    public boolean contains(Object o) {
        Node<T> current = head;  // Start from the head of the list

        // Traverse the list
        while (current != null) {
            if (current.data.equals(o)) {  // Compare node data with the given object
                return true;  // Return true if a match is found
            }
            current = current.next;  // Move to the next node
        }
        return false;  // Return false if no match was found
    }
    public void setCurrent(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }
        Node<T> current = head;
        int currentIndex = 0;
        while (current != null) {
            if (currentIndex == index) {
                return ;
            }
            current = current.next;
            currentIndex++;
        }
        // in case index out of bounds
        throw new IndexOutOfBoundsException("Index out of bounds: " + index);
    }
    public boolean hasNext() {
       //return current != null && current.next != null;
       return current == null;
    }
}
