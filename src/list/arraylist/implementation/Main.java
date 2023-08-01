package list.arraylist.implementation;

public class Main {
    public static void main(String[] args) {

        ArrayList numbers = new ArrayList();

        // 마지막 인덱스에 값 추가
        numbers.addLast(10);
        numbers.addLast(20);
        numbers.addLast(30);
        numbers.addLast(40);

        // 원하는 인덱스에 값 추가
        // ArrayList는 값을 추가할 때 기존의 인덱스의 뒤에 있는 값을
        // 모두 한 칸씩 밀려서 위치하기 때문에 시간이 많이 소요됨
        numbers.add(1, 15);

        // 첫번째 인덱스에 데이터 추가
        numbers.addFirst(5);

        System.out.println(numbers);

//        for (int i = 0; i < numbers.size(); i++){
//            System.out.println(numbers.get(i));
//        }

        ArrayList.ListIterator li = numbers.listIterator();

        while(li.hasNext()){
            System.out.println(li.next());
        }
    }
}
