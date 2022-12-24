public class Main {
    public static void main(String[] args) {
        CircularSinglyLinkedList cSLL = new CircularSinglyLinkedList();

        cSLL.createCSLL(5);
        System.out.println(cSLL.getHead().getValue());
        System.out.println(cSLL.getHead().getNext().getValue());
    }
}
