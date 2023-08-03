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

    //toString 재정의
    public String toString(){
         if (head == null){
             return "[]";
         }
         Node temp = head;
         String str = "[";

         while (temp.next != null){
             str += temp.data + ", ";
             temp = temp.next;
         }
        str += temp.data;
         return str+"]";
    }

    // head에 해당하는 노드 값 삭제
    public Object removeFirst(){
         Node temp  = head;
         head =  head.next;

         Object returnData = temp.data;
         temp = null;
         size--;
         return returnData;
    }

    // 원하는 인덱스의 노드 값 삭제
    public Object remove(int k){
         if (k == 0){
             return removeFirst();
         }

         Node temp = node(k-1); // 이전 노드값 temp에 저장
         Node todoDeleted = temp.next;
         temp.next = temp.next.next;
         Object returnData = todoDeleted.data;

         if (todoDeleted == tail){
             tail = temp;
         }
         todoDeleted = null;
         size--;

         return returnData;
    }

    // 마지막 인덱스의 노드 값 삭제
    // remove함수에서 node함수를 호출하기 때문에
    // 마지막 인덱스의 노드 이전 값을 찾는 과정을 거쳐서
    // 속도가 느림.
    public Object removeLast(){
         return remove(size-1);
    }
}
