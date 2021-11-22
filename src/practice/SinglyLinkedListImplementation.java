package practice;

public class SinglyLinkedListImplementation {
    public static void main(String[] args) {
        LinkedListDE l1 = new LinkedListDE(new Link(5));
        System.out.println(l1);
        l1.deleteTail();

        l1.insertTail(new Link(12));
        l1.insertTail(new Link(20));
        l1.insertHead(new Link(66));
        l1.deleteTail();

        System.out.println("-----------------------\nFinal state:");
        System.out.println(l1);
    }
}

class Link {
    protected int data;
    protected Link next;

    public Link() {
        //
    }

    public Link(int data) {
        this.data=data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }

    public boolean hasNext() {
        if(next != null) return true;
        return false;
    }

    public String toString() {
        return String.valueOf(data);
    }
}

class LinkedList {
    protected Link head;

    public LinkedList(Link head) {
        this.head=head;
    }

    public LinkedList() {
        //
    }

    public Link getHead() {
        return head;
    }

    public void insertHead(Link newHead) {
        newHead.setNext(head);
        this.head = newHead;
        System.out.println("Inserted head: "+newHead);
        System.out.println(this);
    }

    public void insertHead(int data) {
        Link newHead = new Link(data);
        insertHead(newHead);
    }

    public boolean deleteHead() {
        if(head.hasNext()) {
            this.head=head.getNext();
            return true;
        }
        return false;
    }

    public String toString() {
        String out = "[";
        Link link = head;
        while(link.getNext() != null) {
            out +=  link.getData() + " -> ";
            link = link.getNext();
        }
        return out + link.getData()+"]";
    }
}

//Double-ended Linked List
class LinkedListDE extends LinkedList {
    Link tail;

    public LinkedListDE(Link head, Link tail) {
        this.head=head;
        this.tail=tail;
    }

    public LinkedListDE(Link head) {
        this(head, head);
    }

    public Link getTail() {
        return tail;
    }

    public void insertTail(Link newTail) {
        tail.setNext(newTail);
        setTail(newTail);
        System.out.println("Inserted tail: "+newTail+"\n"+this);
    }

    private void setTail(Link newTail) {
        newTail.setNext(null);
        tail = newTail;
    }

    public boolean deleteTail() {
        if(head == tail || !head.hasNext()) {
            return false;
        }
        Link prev = head;
        Link current = head.getNext();
        while(current.hasNext()) {
            prev = current;
            current = current.getNext();
        }
        System.out.println("Deleted tail: "+tail);
        setTail(prev);
        System.out.println(this);
        return true;
    }

    public boolean deleteHead() {
        if(head.hasNext()) {
            head = head.getNext();
            return true;
        }
        return false;
    }
}
