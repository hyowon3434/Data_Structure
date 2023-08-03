package compare;

import list.arraylist.implementation.ArrayList;
import list.linkedlist.implementation.LinkedList;

public class Main {
    public static void main(String[] args) {
        ArrayList a = new ArrayList();
        a.addLast(10);
        a.addLast(20);
        a.addLast(30);
        ArrayList.ListIterator ai = a.listIterator();
        while(ai.hasNext()){
            if ((int)ai.next() == 20){
                ai.add(25);
            }
        }
        // 모든 인덱스의 값들을 한칸씩 뒤로 밀어내기 때문에
        // 속도 저하
        //a.addFirst(5);

        // 인덱스 번호를 알고 접근하기 때문에
        // 다른 값들을 조회할 필요가 없어
        // 속도 빠름
        //a.get(2);

        LinkedList l = new LinkedList();
        l.addLast(10);
        l.addLast(20);
        l.addLast(30);
        LinkedList.ListIterator li = l.listIterator();
        while(li.hasNext()){
            if ((int)li.next() == 20){
                li.add(25);
            }
        }

        // 첫번째 노드에 접근해 연결만 해주기 때문에
        // 속도에 강점
        //l.addFirst(5);


        // 모든 노드들을 조회해
        // 검색하려는 값과 대조를 해야함으로
        // 속도저하
        //l.get(2);

    }
}
