import java.util.Scanner;

public class Lab07_Default {
    public static void main(String args[] ) throws Exception {

        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    }
}

//here's a queue class if you want to use it
class Queue{
    
    private int maxSize;
    private String[] queArray;
    private int front;
    private int rear;
    private int nItems;
    
    public Queue(int s){
        maxSize = s;
        queArray = new String[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }
    
    public boolean insert(String item){ 
    //fill this in
    }
      
    public String remove(){
    //fill this in
    } 

    public boolean isEmpty(){ 
        return (nItems==0);
    }
        
    public boolean isFull(){
        return (nItems==maxSize);
    }
        
    public int size(){ 
        return nItems;
    } 
}