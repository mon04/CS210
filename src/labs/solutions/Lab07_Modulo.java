package labs.solutions;

import java.util.Scanner;

public class Lab07_Modulo {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String allCommands = "";
        while(scan.hasNextLine()) {
            allCommands += ";" + scan.nextLine();
        }
        String[] commands = allCommands.substring(1).split(";");

        Queue1 q = new Queue1(commands.length);

        for(String command : commands) {
            System.out.println(command);
            if(command.equals("REMOVE")) {
                if(!q.isEmpty()) {
                    q.remove();
                }
            }
            else {
                String value = command.split(" ")[1];
                q.insert(value);
            }
            System.out.println(q);
            q.printArray();
        }
        System.out.println(q.getMiddleValue());
    }
}


class Queue1 {
    private int capacity;
    private String[] values;
    private int front;
    private int rear;
    private int quantity;

    public Queue1(int maxSize) {
        this.capacity=maxSize;
        values=new String[maxSize];
        front=0;
        rear=-1;
        quantity=0;
    }

    public boolean insert(String v) {
        if(isFull()) { return false; }
        if(rear == capacity-1) { rear=-1; }
        rear++;
        values[rear]=v;
        quantity++;
        return true;
    }

    public String remove() {
        if(isEmpty()) { return null; }
        String temp = values[front];
        front++;
        if(front == capacity) { front=0; }
        quantity--;
        return temp;
    }

    public String peek() {
        if(!isEmpty()) {
            return values[front];
        }
        return null;
    }

    public String getMiddleValue() {
        int i = (front+(quantity/2))%capacity;
        if(quantity%2 == 0) {
            if(i != 0) i--;
            else i = capacity;
        }
        System.out.println("The middle index is: "+i);
        return values[i];
    }

    public void printArray() {
        String out = "[";
        for(String v: values) {
            out += v+", ";
        }
        System.out.println(out.substring(0,out.length()-2)+"]");
    }

    public boolean isFull() {
        return quantity == capacity;
    }

    public boolean isEmpty() {
        return quantity == 0;
    }

    @Override
    public String toString() {
        if(quantity == 0) return "[]";
        if(quantity == 1) return "["+peek()+"]";
        String out = "[";
        int i=front;
        while(i != (rear+1)%capacity) {
            out += values[i] + ", ";
            i++;
            if(i == capacity) {
                i=0;
            }
        }
        return out.substring(0,out.length()-2) + "]";
    }
}