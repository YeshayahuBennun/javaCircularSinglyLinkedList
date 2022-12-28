public class Main {
    public static void main(String[] args) {
        CircularSinglyLinkedList cSLL = new CircularSinglyLinkedList();

        cSLL.createCSLL(5);
        cSLL.insertCSLL(4, 0);
        cSLL.insertCSLL(6, 2);
        cSLL.insertCSLL(7, 3);
        cSLL.traversalCSLL();
        cSLL.deleteNode(2);
        cSLL.traversalCSLL();

    }
}
