public class Main {
    public static void main(String[] args) {
        CircularSinglyLinkedList cSLL = new CircularSinglyLinkedList();

        cSLL.createCSLL(5);
        cSLL.insertCSLL(4, 0);
        cSLL.insertCSLL(6, 0);
        System.out.println(cSLL.getHead().getValue());
        cSLL.traversalCSLL();
    }
}
