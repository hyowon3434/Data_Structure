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
    // head에 값 추가

    public void addFirst(Object input) {
        Node newNode = new Node(input);
        newNode.next = head;
        head = newNode;
        size++;
        if (head.next == null){
            tail = head;
        }
    }

    // tail에 값 추가
    public void addLast(Object input) {
        Node newNode = new Node(input);
        if (size == 0){
            addFirst(input);
        }else {
            tail.next = newNode;
            tail = newNode;
            size++;
        }

    }

    // index에 해당하는 노드 값 조회
    // node 메소드는 외부에 노출되면 안됨.
     /*public*/ Node node(int index){
        Node x = head;
       for (int i = 0; i < index; i++){
           x = x.next;
       }
        return x;
    }
}
