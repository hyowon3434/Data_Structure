package list.linkedlist.implementation;

import javax.jws.Oneway;

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
            addFirst(input); // LinkedList에 데이터가 없다면 addFirst 호출
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

    // 원하는 인덱스에 값 추가
    public void add(int k, Object input) {
        if (k == 0){
            addFirst(input); // 인덱스값이 0이면 addFirst 함수 호출
        }else {
            Node temp1 = node(k - 1); // node 함수를 통해 원하는 인덱스 노드에 이전 노드가 어떤 값인지 알아낸다.
            Node temp2 = temp1.next;
            Node newNode = new Node(input);

            temp1.next = newNode;
            newNode.next = temp2;
            size++;

            if (newNode.next == null){
                tail = newNode;
            }

        }
    }
}
