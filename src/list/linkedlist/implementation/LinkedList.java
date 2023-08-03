package list.linkedlist.implementation;

public class LinkedList {

    private Node head;
    private Node tail;
    private int size = 0;

    private class Node{

        private Object data;
        private Node next;
        public Node(Object input){
            this.data = input;
            this.next = null;
        }
        public String toString(){
            return String.valueOf(this.data);
        }

    }

    // 값 추가
    public void addFirst(Object input) {
        Node newNode = new Node(input);
        newNode.next = head;
        head = newNode;
        size++;
        if (head.next == null){
            tail = head;
        }
    }
}
