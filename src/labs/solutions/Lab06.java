package labs.solutions;

import java.util.Scanner;

public class Lab06 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Stack stack = new Stack(n);
        for(int i=0; i < n; i++) {
            String command = scan.nextLine();
            execute(command, stack);
        }
        System.out.println(stack.peek());
    }

    public static void execute(String command, Stack stack) {

        if(command.equals("POP")) {
            if(!stack.isEmpty()) {
                stack.pop();
            }
        }
        else {
            stack.push(
                    Long.parseLong(command.substring(5))
            );
        }

    }

}

class Stack {

    private int maxSize;
    private long[] stackArray;
    private int top;

    public Stack(int maxSize) {
        this.maxSize=maxSize;
        stackArray=new long[maxSize];
        top=-1;
    }

    public void push(long n) {
        stackArray[++top]=n;
    }

    public long pop() {
        return stackArray[top--];
    }

    public long peek() {
        return stackArray[top];
    }

    public void makeEmpty() {
        top=-1;
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public boolean isFull() {
        return top == maxSize;
    }

}
