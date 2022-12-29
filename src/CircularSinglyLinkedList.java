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
        if (head != null) {//----------------------------------------------------------O(1)
            Node temNode = head;//-----------------------------------------------------O(1)
            for (int i = 0; i < size; i++) {//-----------------------------------------O(N)
                System.out.print(temNode.getValue());//--------------------------------O(1)
                if (i != size - 1) {//-------------------------------------------------O(1)
                    System.out.print(" -> ");//----------------------------------------O(1)
                }
                temNode = temNode.getNext();//-----------------------------------------O(1)
            }
            System.out.println("\n");
        } else {
            System.out.println("\nCSLL does not exist");//-----------------------------O(1)
        }
    }

    //Search Circular Single Linked List
    public boolean searchCSLL(int nodeValue) {
        if(head!=null){//--------------------------------------------------------------O(1)
            Node tempNode = head;//----------------------------------------------------O(1)
            for (int i = 0; i < size; i++) {//-----------------------------------------O(N)
                if(tempNode.getValue()==nodeValue){//----------------------------------O(1)
                    System.out.println("Found node at location: "+i);//----------------O(1)
                    return true;//-----------------------------------------------------O(1)
                }
                tempNode = tempNode.getNext();//---------------------------------------O(1)
            }
        }
        System.out.println("Node not found!");//---------------------------------------O(1)
        return false;//----------------------------------------------------------------O(1)
    }

    // Delete a node in Circular Singly Linked List Method
    public void deleteNode(int location) {
        if (head == null) {//----------------------------------------------------------O(1)
            System.out.println("The CSLL does not exist! ");//-------------------------O(1)
            return;//------------------------------------------------------------------O(1)
        } else if (location == 0) {// Deleting the first node -------------------------O(1)
            //More than one node
            head = head.getNext();//---------------------------------------------------O(1)
            tail.setNext(head);//------------------------------------------------------O(1)
            size--;//------------------------------------------------------------------O(1)
            //Only one node
            if (size == 0) {//---------------------------------------------------------O(1)
                tail = null;//---------------------------------------------------------O(1)
                head.setNext(null);//--------------------------------------------------O(1)
                head = null;//---------------------------------------------------------O(1)
            }
        } else if (location >= size-1) {//Deleting the last node//-----------------------O(1)
            Node tempNode = head;//----------------------------------------------------O(1)
            for (int i =0; i<size-2; i++) {//------------------------------------------O(1)
                tempNode = tempNode.getNext();//---------------------------------------O(1)
            }
            //Only one node
            if (tempNode == head) {//--------------------------------------------------O(1)
                head.setNext(null);//--------------------------------------------------O(1)
                tail = head = null;//--------------------------------------------------O(1)
                size--;//--------------------------------------------------------------O(1)
                return;//--------------------------------------------------------------O(1)
            }
            //more than one node
            tempNode.setNext(head);//--------------------------------------------------O(1)
            tail = tempNode;//---------------------------------------------------------O(1)
            size--;//------------------------------------------------------------------O(1)
        } else {//Deleting at any given position
            Node tempNode = head;//----------------------------------------------------O(1)
            for (int i=0; i < location-1; i++) {//-------------------------------------O(n)
                tempNode = tempNode.getNext();//---------------------------------------O(1)
            }
            tempNode.setNext(tempNode.getNext().getNext());//--------------------------O(1)
            size--;//------------------------------------------------------------------O(1)
        }
    }
    /*
* suppose the linked list has 5 elements.
then the value of size is 5
*  so if we go to this condition else if (location >= size)  and put last element's index as location it'll be 4 >= 5
*  which is false so I think that the last element's case will go under the else case (which is intermediate value
*  case) and this tail won't be updated.
*  also similarly within else if (location >= size) 's for loop case  i.e for (int i=0; i<size-1; i++) the loop
*  termination condition should be size - 2
+  instead of size-1 as the tail still points to the previous last element which we just deleted.
*  I don't know if it's much of a problem since the code is working but pointed out just in case.
*  All you have to do is in the case of removing last element, instead of writing else case as (location <= size)
*  write (location <=size-1)  and change the for loop upper bound (for the case of normal and circular singly
* linked list) from size - 1 to size - 2 .*/


  //Delete an Entire CSLL
    public void deleteCSLL(){
       if(head==null){//---------------------------------------------------------------O(1)
           System.out.println("The CSLL does not exist!");//---------------------------O(1)
       }else {
           head=null;//----------------------------------------------------------------O(1)
           tail.setNext(null);//-------------------------------------------------------O(1)
           tail = null;//--------------------------------------------------------------O(1)
           System.out.println("CSLL has been deleted");//------------------------------O(1)
       }
    }
}
