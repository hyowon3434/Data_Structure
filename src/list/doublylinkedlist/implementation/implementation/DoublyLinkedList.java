package list.doublylinkedlist.implementation.implementation;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int size = 0;



    private class Node{

        private Object data;
        private Node next;
        private Node prev;

        public Node(Object input){
            this.data = input;
            this.next = null;
            this.prev = null;
        }
        public String toString(){
            return String.valueOf(this.data);
        }

    }
    // head에 값 추가
    public void addFirst(Object input) {
        Node newNode = new Node(input);
        newNode.next = head;
        if (head != null){
            head.prev = newNode;
        }
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
            newNode.prev = tail;
            tail = newNode;
            size++;
        }

    }

    // index에 해당하는 노드 값 조회
    // node 메소드는 외부에 노출되면 안됨.
    /*public */ Node node(int index){
        if (index < size/2){
            Node x = head;
            for (int i = 0; i < index; i++){
                x = x.next;
            }
            return x;
        }else{
            Node x = tail;
            for (int i = size-1; i > index; i--){
                x = x.prev;
            }
            return x;
        }

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
            if (temp2 != null){
                temp2.prev = newNode;
            }
            newNode.prev = temp1;
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

    // LinkedList의 사이즈 리턴
    public int size(){
         return size;
    }

    // 특정한 인덱스의 노드 값 조회
    public Object get(int k){
         Node temp = node(k);
         return temp.data;
    }

    // 해당 값의 인덱스를 리턴
    public int indexOf(Object data){
        Node temp = head;
        int index = 0;
        while (temp.data != data){ // Node와 data가 같이 같을때 while문을 빠져나간다.
            temp = temp.next;
            index++;
            if (temp == null){
                return -1; // 해당 값이 없다면 -1을 리턴
            }
        }
        return index;
    }

    // Iterator
    public ListIterator listIterator(){

        return new ListIterator();
    }

    // ListIterator inner class
    public class ListIterator{
        private Node next;
        private Node lastReturned;
        private int nextIndex;


        ListIterator(){
            next = head;
        }

        // 다음 노드를 리턴
        public Object next(){
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.data;
        }

        // 다음 노드의 존재 여부를 리턴
        // linkedlist는 이전 노드의 정보를 알 수 없기 때문에
        // previous 함수를 만들 수 없다.
        public boolean hasNext(){
            return nextIndex < size();
        }

        // 값 추가
        public void add(Object input){
            Node newNode = new Node(input);

            if (lastReturned == null){
                head = newNode;
                newNode.next = next;
            }else{
                lastReturned.next = newNode;
                newNode.next = next;
            }


            lastReturned = newNode;
            nextIndex++;
            size++;
        }

        //현재 가리키고 있는 노드를 삭제
        public void remove(){
            if (nextIndex == 0){
                throw new IllegalStateException();
            }
            DoublyLinkedList.this.remove(nextIndex-1);
            nextIndex--;
        }
    }


}
