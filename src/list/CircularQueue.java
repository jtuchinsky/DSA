package list;

// Leetcode 622
public class CircularQueue {
    //Node front = null;
    Node rear = null;
    int capacity = 0;
    int size = 0;

    public CircularQueue(int k) {
        this.capacity = k;
    }

    public boolean enQueue(int value) {
        System.out.println("enqueue " + value);
        System.out.println(this.toString() + "size: " + size);
        if(size == capacity) return false;
        if(rear == null) {
            rear = new Node(value);
            rear.next = rear;
        } else {
            Node tmp = new Node(value);
            tmp.next = rear.next;
            rear.next = tmp;
        }
        size++;
        System.out.println(this.toString()  + "size: " + size);
        return true;
    }

    public boolean deQueue() {
        System.out.println("dequeue");
        System.out.println(this.toString()  + "size: " + size);
        if(rear == null) return false;
        if(size == 1) { rear = null; size = 0; return true;}
        Node tmp = rear.next;
        rear.next = tmp.next.next;
        tmp = null;
        size--;
        System.out.println(this.toString() + "size: " + size);
        return true;
    }

    public int Front() {
        return size == 0 ? -1 : rear.val;
    }

    public int Rear() {
        return size == 0 ? -1 : rear.next.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public String toString(){
        if (size == 0) return "[]";
        Node tmp = rear.next;
        String ret = "[";
        for (int i = 0; i < size; i++){
            ret += tmp.val + ", ";
            tmp = tmp.next;
        }
        ret +=  "<<" + tmp.val + ">>]";
        return ret.toString();
    }
    class Node {
        int val;
        Node next;

        public Node(int value){
            val = value;
        }

        public String toString(){
            return "" + val;
        }
    }

    public static void main(String[] args) {
        CircularQueue me = new CircularQueue(3);
        me.enQueue(1);
        me.enQueue(2);
        me.enQueue(3);
        me.enQueue(4);
        System.out.println(me.Rear());
        System.out.println(me.isFull());
        me.deQueue();
        me.enQueue(4);
        System.out.println(me.Rear());
    }
}
