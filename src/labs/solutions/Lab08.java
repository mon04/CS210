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
        System.out.println(search(mylist));
    }

    public static int search(LinkedList list) {
        Link node = list.first;
        while(node != null) {
            //Mismatched relations between node and its previous/next:
            if((node != list.first && node.previous.next != node) || (node != list.last && node.next.previous != node)) {
                return 0;
            }
            node = node.next;
        }
        int firstSmallest = list.getSmallestValue();
        list.removeLink(firstSmallest);
        return list.getSmallestValue(firstSmallest);
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

        //Catch empty list:
        if(isEmpty()) { return; }

        //Catch 1-long list:
        Link link = first;
        if(first.next == null) {
            if(first.data == key) first=null;
            return;
        }

        //List is longer than 1:
        while(link != null) {
            if(link.data == key) {

                if(link != first && link != last) {
                    link.previous.next = link.next;
                    link.next.previous = link.previous;
                    return;
                }

                else if(link == first) {
                    link.next.previous = null;
                    first = link.next;
                    return;
                }

                else {
                    link.previous.next = null;
                    last = link.previous;
                    return;
                }

            }
            link = link.next;
        }
    }

    public int getSmallestValue() {
        if(isEmpty()) { return -1; }
        if(first==last) { return first.data; }

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

    public int getSmallestValue(int restrict) {
        if(isEmpty()) { return -1; }
        if(first==last) { return first.data; }

        Link link = first;
        int min = Integer.MAX_VALUE;

        while(link != null) {
            if(link.data > restrict && link.data < min) {
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