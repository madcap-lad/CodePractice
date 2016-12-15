/**
 * Created by Jeet on 11-12-2016.
 */
public class LinkedListDuplicateElement {



    public void removeDuplicate(LinkedList.Node head) {
        LinkedList.Node currentNode = head;
        while (currentNode.next != null) {
            LinkedList.Node forwardNode = currentNode.next;
            int value = currentNode.data;
            LinkedList.Node prev = currentNode;
            while (forwardNode != null) {
                if (forwardNode.data == currentNode.data) {
                    prev.next = forwardNode.next;
                    forwardNode = forwardNode.next;
                    continue;
                }
                prev = forwardNode;
                forwardNode = forwardNode.next;
            }
            if (currentNode.next != null)
                currentNode = currentNode.next;

        }

    }


    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(8);
        linkedList.add(2);
        linkedList.add(5);
        linkedList.add(7);
        linkedList.add(5);
        printLinkedList(linkedList.head);
        System.out.println("After de-duping elements: ");
        new LinkedListDuplicateElement().removeDuplicate(linkedList.head);

        printLinkedList(linkedList.head);


    }

    private static void printLinkedList(LinkedList.Node head) {

        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }

    }

}
