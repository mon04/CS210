package practice.recursion;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MergeSortLinkedList {
    public static void main(String[] args) throws IOException {
        Node head = new Node("");
        File input = new File("src/practice/recursion/words/verbs");
        try {
            Scanner scan = new Scanner(input);
            head.value = scan.nextLine();
            Node current = head;
            while(scan.hasNext()) {
                Node nextNode = new Node(scan.nextLine());
                current.next = nextNode;
                current = nextNode;
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("Original:\n"+head+"\n");

        Sorting.mergeSort(head);
        String outputName = input.getCanonicalPath()+"_sorted.txt";
        System.out.println("Writing to: "+outputName+"...");
        File output = new File(outputName);
        output.createNewFile();
        FileWriter file = new FileWriter(output);

        Node current = head;
        boolean first=true;
        while(current != null) {
            System.out.println(current.value);
            if(first) {
                file.append(current.value);
                first=false;
            }
            else file.append("\n"+current.value);
            current = current.next;
        }
        file.close();
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
        String sbString = sb.toString();
        return sbString.substring(0, sbString.length()-1);
    }
}

class Sorting {

    public static Node mergeSort(Node head) {
        if (head == null || !head.hasNext())
            return head;
        //Split list
        Node left = head;
        Node right = head.getListMid();
        Node temp = right.next;
        right.next = null;
        right = temp;

        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    private static Node merge(Node headLeft, Node headRight) {
        Node tail = new Node("");
        Node dummy = tail;
        while (headLeft != null && headRight != null) {
            if (compare(headLeft, headRight)) {
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

    private static boolean compare(Node a, Node b) {
        //Compares Node values alphabetically
        return a.value.compareTo(b.value) < 0;
    }
}