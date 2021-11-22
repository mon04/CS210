package labs.solutions;

import java.util.*;

public class Lab08 {
    public static void main(String args[] ) throws Exception {
        Scanner myscanner = new Scanner(System.in);
        int num = Integer.parseInt(myscanner.nextLine());
        Link[] array = new Link[num];
        for(int i=0;i<num;i++){
            array[i]=new Link(Integer.parseInt(myscanner.nextLine()));
        }
        while(myscanner.hasNext()){
            int select=myscanner.nextInt();
            int previous=myscanner.nextInt();
            int next=myscanner.nextInt();
            if(previous!=-1){
                array[select].previous=array[previous];
            }
            if(next!=-1){
                array[select].next=array[next];
            }
        }
        LinkedList mylist = new LinkedList();
        if(num>0){
            mylist.first=array[0];
            mylist.last=array[num-1];
        }
        System.out.println(mylist);
        System.out.println("Answer: "+search(mylist));
    }

    public static int search(LinkedList list) {
        Link link = list.first;
        int min = Integer.MAX_VALUE;

        for(int i=0; i < 2; i++) {
            min = list.smallestValue();
            list.removeLink(min);
        }
        return min;
    }
}

class Link{
    public int data;
    public Link next;
    public Link previous;

    public Link(int input){
        data=input;
        next=null;
        previous=null;
    }

    public void setNext(Link next) {
        this.next = next;
    }

    public void setPrevious(Link previous) {
        this.previous = previous;
    }
}

class LinkedList {
    public Link first;
    public Link last;

    public LinkedList(){
        first=null;
        last=null;
    }

    public boolean isEmpty(){
        return (first==null);
    }

    public void insertHead(Link insert){
        if(isEmpty()) {
            first=insert;
            last=insert;
        }else{
            first.previous=insert;
            insert.next=first;
            first=insert;
        }
    }

    public void removeLink(int key) {
        System.out.println("Remove "+key+":");
        //Catch empty list:
        if(isEmpty()) return;

        //Catch 1-long list:
        else if(first.next == null) {
            if(first.data == key) first=null;
            System.out.println(this);
            return;
        }

        Link link = first;
        while(link != null) {
            if(link.data == key) {
                //Link is in middle:
                if(link != first && link != last) {
                    link.previous.next = link.next;
                    link.next.previous = link.previous;
                    System.out.println(this);
                    return;
                }
                //Link is at head:
                else if(link == first) {
                    link.next.previous = null;
                    first = link.next;
                    System.out.println(this);
                    return;
                }
                //Link is at tail:
                else {//link == last:
                    link.previous.next = null;
                    last = link.previous;
                    System.out.println(this);
                    return;
                }
            }
            link = link.next;
        }
        System.out.println("Error removing: no match found for key: "+key);
    }

    public int smallestValue() {
        Link link = first;
        int min = Integer.MAX_VALUE;
        while(link != null) {
            if(link.data < min) {
                min = link.data;
            }
            link = link.next;
        }
        return min;
    }

    public String toString() {
        if(first == null) {
            return "[]";
        }

        String out = "[";
        Link link = first;
        while(link != null) {
            out +=  link.data + " -> ";
            link = link.next;
        }
        return out.substring(0,out.length()-(" -> ".length())) +"]";
    }
}