package linked_list;

public class MyLinkedList<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }
    }

    private Node head;
    private int size;

    public MyLinkedList(){
        this.head = null;
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public void addFirst(E e) {
        head = new Node(e, null);
        size++;

    }

}
