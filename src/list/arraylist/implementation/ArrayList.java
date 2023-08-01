package list.arraylist.implementation;

public class ArrayList {

    // ArrayList의 크기
    private int size = 0;

    // 객체는 총 100개의 데이터를 담을 수 있게 설정
    private Object[] elementData = new Object[100];


    // ArrayList 값 추가하는 메소드
    public boolean addLast(Object element){

        elementData[size] = element;
        size++;
        return true;
    }
}
