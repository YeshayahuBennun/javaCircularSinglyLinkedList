public class Main {
    public static void main(String[] args) {
        CircularSinglyLinkedList cSLL = new CircularSinglyLinkedList();

        cSLL.createCSLL(5);
        cSLL.insertCSLL(4, 0);
        cSLL.insertCSLL(6, 1);
        cSLL.insertCSLL(7, 8);
        System.out.println(cSLL.getHead().getValue());
        cSLL.traversalCSLL();
        System.out.println();
        cSLL.searchCSLL(10);

    }
}
