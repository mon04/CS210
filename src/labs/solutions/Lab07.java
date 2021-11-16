package labs.solutions;

import java.util.Scanner;

public class Lab07 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String fullInput = "";
        while(scan.hasNextLine()) {
            fullInput += ";" + scan.nextLine();
        }
        scan.close();
        String[] commands = fullInput.substring(1).split(";");

        Queue q = new Queue(commands.length);

        for(String command : commands) {
            //System.out.println(command);
            if(command.equals("REMOVE")) {
                if(!q.isEmpty()) {
                    q.remove();
                }
            } else {
                q.insert(command.split(" ")[1]);
            }
        }

        if(q.isEmpty()) {
            System.out.println("empty");
        } else {
            int size = q.size();
            int i = size/2;
            if(size%2==0) {
                i--;
            }
            while(i>0) {
                q.remove();
                i--;
            }
            System.out.println(q.remove());
        }
    }
}


class Queue {
    private int capacity;
    private String[] values;
    private int front;
    private int rear;
    private int size;

    public Queue(int capacity) {
        this.capacity=capacity;
        values=new String[capacity];
        front=0;
        rear=-1;
        size=0;
    }

    public boolean insert(String v) {
        if(isFull()) {
            return false;
        }
        if(rear == capacity-1) { rear=-1; }
        rear++;
        values[rear]=v;
        size++;
        return true;
    }

    public String remove() {
        if(isEmpty()) { return null; }
        String temp = values[front];
        front++;
        if(front == capacity) { front=0; }
        size--;
        return temp;
    }

    public String peek() {
        if(!isEmpty()) {
            return values[front];
        }
        return null;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public String toString() {
        if(size == 0) return "[]";
        if(size == 1) return "["+peek()+"]";
        String out = "[";
        int i = front;
        while(i <= rear) {
            out += values[i] + ", ";
            i++;
        }
        return out.substring(0, out.length()-2) + "]";
    }

    /*public void printFullArray() {
        String out = "[";
        for(String v: values) {
            out += v+", ";
        }
        System.out.println(out.substring(0,out.length()-2)+"]");
    }*/

}
