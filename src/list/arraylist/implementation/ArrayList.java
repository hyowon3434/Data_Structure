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
}
