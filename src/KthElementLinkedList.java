import com.sun.deploy.util.SystemUtils;

/**
 * Created by Jeet on 11-12-2016.
 */
public class KthElementLinkedList {


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(5);
        linkedList.add(8);
        linkedList.printLinkedList();
        findKthElement(5, linkedList.head);

    }


    public static void findKthElement(int k, LinkedList.Node head) {
        if (head == null) return;
        LinkedList.Node currentNode = head;
        LinkedList.Node kthNode = head;
        int i = 0;
        while (i < k - 1 && currentNode != null) {
            currentNode = currentNode.next;
            i++;
        }
        if (currentNode == null) {
            System.out.println("Kth element exceeds the lenght of the list.");
            return;
        }
        while (currentNode != null && currentNode.next != null) {
            currentNode = currentNode.next;
            kthNode = kthNode.next;
        }

        System.out.println("Kth Element- " + kthNode.data);
    }


}
