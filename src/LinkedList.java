/**
 * Created by Jeet on 11-12-2016.
 */

public class LinkedList {

        public Node head;

        public class Node {
            public Node next;
            public int data;
        }


        public void add(int value) {
            Node node = new Node();
            node.data = value;
            if (head == null) {
                head = node;
                return;
            }

            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = node;
        }


        /*
        Delete the node.
         */
        public void delete(int value) {
            Node currentNode = head;
            Node nodeToDelete, prev = null;

            while (currentNode != null) {
                if (currentNode.data == value) {
                    prev.next = currentNode.next;
                    currentNode = null;
                    break;
                }
                prev = currentNode;
                currentNode = currentNode.next;
            }

        }

    public void printLinkedList() {
        Node current = head ;
        while (current!= null) {
            System.out.println(current.data);
            current= current.next;
        }

    }


}
