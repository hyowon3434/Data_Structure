import java.util.ArrayList;
import java.util.Iterator;

public class Practice {
    public static void main(String[] args) {

        // ArrayList 선언
        ArrayList<Integer> numbers = new ArrayList<>();

        // numbers에 값 추가
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);

        System.out.println(numbers);


        // 인덱스에 접근해서 값을 추가할 수 있다.
        // 기존 인덱스으 값과 그 뒤의 값들은 한 칸씩 뒤로 밀려난다.
        numbers.add(1, 50);
        System.out.println(numbers);


        // 인덱스에 접근해 해당 데이터를 지우고 그 뒤에 데이터들은 한 칸씩 땡겨진다.
        numbers.remove(2);
        System.out.println(numbers);

        // 해당 인덱스의 값 조회
        System.out.println(numbers.get(2));

        // ArrayList의 크기
        System.out.println(numbers.size());


        Iterator it = numbers.iterator();

        while (it.hasNext()){ // hasNext의 리턴값은 불리언 타입으로 Iterator에 다음 요소가 존재하는지 여부를 리턴
            int value = (int) it.next(); // next 함수는 다음 요소를 리턴
            if (value == 30){
                it.remove();
            }
            System.out.println(value);
        }
        System.out.println(numbers);



        for (int value : numbers){
            System.out.println(value);
        }

        for (int i = 0; i < numbers.size(); i++){
            System.out.println(numbers.get(i));
        }

        // second commit 완료!!
    }
}
