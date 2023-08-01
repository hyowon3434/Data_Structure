package list.arraylist.implementation;

public class ArrayList {

    // ArrayList의 크기
    private int size = 0;

    // 객체는 총 100개의 데이터를 담을 수 있게 설정
    private Object[] elementData = new Object[100];


    // ArrayList 값 추가하는 메소드

    // 1. 첫번째 인덱스에 값 추가
    public boolean addFirst(Object element){
        // add함수를 오출해서 0번째 인덱스를 입력하면 첫번째 인덱스에 값이 저장
        return add(0, element);
    }

    // 마지막 인덱스에 값 추가
    public boolean addLast(Object element){

        elementData[size] = element;
        size++;
        return true;
    }

    public boolean add(int index, Object element){


        for (int i = size-1; i >= index; i--){ // 반복횟수는 맨 마지막 인덱스부터 사용자가 입력한 인덱스까지 1씩 감소
            elementData[i+1] = elementData[i]; // 한칸씩 데이터를 오른쪽으로 이동
        }
        elementData[index] = element; // 입력된 데이터를 원하는 인덱스에 저장
        size++; // ArrayList의 크기 증가
        return true;
    }

    // 기본적으로 toString은 객체를 출력했을때 객체의 요소를 String으로 출력하는 역할
    public String toString(){

        String str = "[";
        for (int i = 0; i < size; i++){
            str += elementData[i];
            if (i < size - 1) { // 마지막 인덱스 값은 , 를 붙히지 않는다.
                str += ",";
            }
        }
        return str + "]";
    }

    // 원하는 인덱스 값 삭제
    public Object remove(int index) {

        // 삭제한 값을 리턴시키기 위한 변수
        Object removed = elementData[index];

        for (int i = index+1; i <= size-1; i++){ // add함수와 반대로 조건을 부여
            elementData[i-1] = elementData[i];
        }
        size--;
        elementData[size] = null; // 마지막 인덱스에 null 삽입

        return removed;
    }

    // 첫번째 인덱스 값 삭제
    public Object removeFirst(){
        return remove(0);
    }

    // 마지막 인덱스 값 삭제
    public Object removeLast(){
        return remove(size-1);
    }

    // 인덱스에 해당하는 값을 리턴
    public Object get(int index){
        return elementData[index];
    }

    // ArrayList의 크기를 리턴
    public int size() {
        return size;
    }

    // 값을 매개변수로 받아 ArrayList에서 매개변수와 요소가 일치했을때 해당 인덱스를 리턴
    // 아닐시 -1을 리턴하는 함수
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++){
            if (o.equals(elementData[i])){
                return i;
            }
        }
        return -1;
    }

    public ListIterator listIterator(){

        return new ListIterator();
    }

    // ListIterator class
    class ListIterator{
        private int nextIndex = 0;

        // nextIndex가 존재하는지 여부를 리턴
        public boolean hasNext(){

            return nextIndex < size();
        }

        // ArrayList의 현재 요소(nextIndex)를 메소드가 실행될 때마다 하나씩 리턴
        public Object next(){
//            Object returnData =  elementData[nextIndex];
//            nextIndex++;
//            return returnData;

            return elementData[nextIndex++];
        }


        // ArrayList의 현재 요소(nextIndex) 이전 요소를 리턴
        public Object previous() {
            return elementData[--nextIndex];
        }

        // 현재 인덱스가 첫번째 인덱스인지 여부를 리턴
        public boolean hasPrevious() {

            return nextIndex > 0;
        }

        // 값 추가
        public void add(Object element) {
            ArrayList.this.add(nextIndex++, element);
        }

        //값 제거
        public void remove() {
            ArrayList.this.remove(nextIndex-1);
            nextIndex--;
        }
    }
}
