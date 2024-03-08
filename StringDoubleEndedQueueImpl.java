import java.io.PrintStream;
import java.util.NoSuchElementException;

class Node {
    String data;
    Node previous;
    Node next;

    public Node(String data) {
        this.data = data;
        previous = null;
        next = null;
    }
}

public class StringDoubleEndedQueueImpl implements StringDoubleEndedQueue {

    public Node head;
    public Node tail;

    public StringDoubleEndedQueueImpl() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        if (head == null && tail == null){
            return true ;
        }
        return false;
    }

    public void addFirst(String item) {

        Node newNode = new Node(item);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
    }

    public String removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("Queue is empty!");
        }

        String data = head.data;
        head = head.next;
        if (head != null){
            head.previous = null;
        }else{
            tail = null;
        }

        return data;
    }

    public void addLast(String item) {
        Node newNode = new Node(item);

        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
    }

    public String removeLast(){
        if (tail == null){
            throw new NoSuchElementException("Queue is empty!");
        }

        String data = tail.data;
        tail = tail.previous;
        if (tail != null){
            tail.next = null;
        }else{
            head = null;
        }

        return data;
    }

    public String getFirst() {

        String firstData = head.data;
        return firstData;
    }

    public String getLast() {
        String lastData = tail.data;
        return lastData;
    }

    public void printQueue(PrintStream stream) {
        Node current = head ;
        while (current != null){
            stream.print(current.data + " ");
            current = current.next;
        }
        stream.println();
    }


    public int size() {
        int count = 0;
        Node current = head;
        while (current != null){
            count = count + 1;
            current = current.next;
        }
        return count;
    }


    public static void main(String[] args) {
        StringDoubleEndedQueueImpl dLinkedList = new StringDoubleEndedQueueImpl();

        if (dLinkedList.isEmpty() == true){
            System.out.println("The Queue is empty!");
        }

        dLinkedList.addLast("A");
        dLinkedList.addLast("B");
        dLinkedList.addLast("C");
        dLinkedList.printQueue(System.out);
        System.out.println("The size of the Queue is " + dLinkedList.size());
        //System.out.println("The first node of the Queue is " + dLinkedList.getFirst());
        //System.out.println("The last node of the Queue is " + dLinkedList.getLast());
        System.out.println("The " + dLinkedList.removeFirst() + " is the first node of the Queue and it was removed!");
        System.out.println("The " + dLinkedList.removeLast() + " is the last node of the Queue and it was removed!" );
        dLinkedList.printQueue(System.out);

    }

}
