package list.doublylinkedlist.implementation.implementation;


public class Main {
    public static void main(String[] args) {
        DoublyLinkedList numbers = new DoublyLinkedList();

        numbers.addLast(10);
        numbers.addLast(20);
        numbers.addLast(30);
        DoublyLinkedList.ListIterator i = numbers.listIterator();
        while (i.hasNext()){
            int number = (int)i.next();
            if (number == 20){
                i.remove();
            }
        }

        System.out.println(numbers);
    }
}
