package practice.recursion;

import java.io.File;
import java.util.Scanner;

public class MergeSortLinkedList {
    public static void main(String[] args) {
        Node head = new Node("");
        try {
            Scanner scan = new Scanner(new File("src/resources/words"));
            head.value = scan.nextLine();
            Node current = head;
            int scanned = 0;
            while(scan.hasNext()) {
                Node nextNode = new Node(scan.nextLine());
                current.next = nextNode;
                current = nextNode;
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println(
                Sorting.mergeSort(head, Sorting.Order.ASCENDING)
        );
    }
}

class Node {
    String value;
    Node next;

    public Node(String value) {
        this.value = value;
    }

    public boolean hasNext() {
        return next != null;
    }

    public Node getListMid() {
        //returns middle node from list - if list has an even number of nodes, returns left of middle
        Node slow = this;
        Node fast = next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = this;
        while(current != null) {
            sb.append(String.format("%s\n", current.value));
            current = current.next;
        }
        return sb.toString();
    }
}

class Sorting {
    enum Order {
        ASCENDING, DESCENDING;
    }

    public static Node mergeSort(Node head) {
        return mergeSort(head, Order.ASCENDING);
    }

    public static Node mergeSort(Node head, Order ord) {
        if (head == null || !head.hasNext())
            return head;
        //Split list
        Node left = head;
        Node right = head.getListMid();
        Node temp = right.next;
        right.next = null;
        right = temp;

        left = mergeSort(left, ord);
        right = mergeSort(right, ord);
        return merge(left, right, ord);
    }

    private static Node merge(Node headLeft, Node headRight, Order ord) {
        Node tail = new Node("");
        Node dummy = tail;
        while (headLeft != null && headRight != null) {
            if (compare(headLeft, headRight, ord)) {
                tail.next = headLeft;
                headLeft = headLeft.next;
            } else {
                tail.next = headRight;
                headRight = headRight.next;
            }
            tail = tail.next;
        }
        if (headLeft != null) tail.next = headLeft;
        if (headRight != null) tail.next = headRight;
        return dummy.next;
    }

    private static boolean compare(Node a, Node b, Order ord) {
        //Compares Node values alphabetically
        if (ord == Order.ASCENDING) {
            return a.value.compareTo(b.value) < 0;
        }
        return a.value.compareTo(b.value) > 0; //DESCENDING
    }
}