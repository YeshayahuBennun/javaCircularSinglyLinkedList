public class CircularSinglyLinkedList {
    private Node head;
    private Node tail;
    private int size;


    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    //Create Circular Singly Linked List
    public Node createCSLL(int nodeValue) {
        head = new Node();//-----------------------------------------------------------O(1)
        Node node = new Node();//------------------------------------------------------O(1)
        node.setValue(nodeValue);//----------------------------------------------------O(1)
        node.setNext(node);//----------------------------------------------------------O(1)
        head = node;//-----------------------------------------------------------------O(1)
        tail = node;//-----------------------------------------------------------------O(1)
        size = 1;//--------------------------------------------------------------------O(1)

        return head;//-----------------------------------------------------------------O(1)
    }

    //insert Circular Singly Linked List
    public void insertCSLL(int nodeValue, int location) {
        Node node = new Node();//------------------------------------------------------O(1)
        node.setValue(nodeValue);//----------------------------------------------------O(1)
        if (head == null) {//----------------------------------------------------------O(1)
            createCSLL(nodeValue);//---------------------------------------------------O(1)
            return;//------------------------------------------------------------------O(1)
        } else if (location == 0) {//--------------------------------------------------O(1)
            node.setNext(head);//------------------------------------------------------O(1)
            head = node;//-------------------------------------------------------------O(1)
            tail.setNext(head);//------------------------------------------------------O(1)
        } else if (location >= size) {//-----------------------------------------------O(1)
            tail.setNext(node);//------------------------------------------------------O(1)
            tail = node;//-------------------------------------------------------------O(1)
            tail.setNext(head);//------------------------------------------------------O(1)
        } else {//---------------------------------------------------------------------O(1)
            Node tempNode = head;//----------------------------------------------------O(1)
            int index = 0;//-----------------------------------------------------------O(1)
            while (index < location - 1) {//-------------------------------------------O(N)
                tempNode = tempNode.getNext();//------   ------------------------------O(1)
                index++;//-------------------------------------------------------------O(1)
            }
            node.setNext(tempNode.getNext());//----------------------------------------O(1)
            tempNode = node;//---------------------------------------------------------O(1)
        }
        size++;//----------------------------------------------------------------------O(1)
    }

    //Traversal Circular Single Linked List
    public void traversalCSLL() {
        if (head != null) {
            Node temNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(temNode.getValue());
                if (i != size - 1) {
                    System.out.print(" -> ");
                }
                temNode = temNode.getNext();
            }
        }else {
            System.out.println("CSLL does not exist");
        }
    }
}
