public class Node <T> {
        public T data;
        public Node<T> next;
        public Node () {
            data = null;
            next = null;
        }
        public Node (T val) {
            data = val;
            next = null;
        }
}
/*class node <K, V> {
    K key;
    V value;
    node<K, V> next;
    public node () {
        this.key = null;
        this.value = null;
        this.next = null;
    }
    public node(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}*/
