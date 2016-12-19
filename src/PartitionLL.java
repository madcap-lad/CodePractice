import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by Jeet on 12-12-2016.
 */
public class PartitionLL {


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(10);
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(8);
        linkedList.add(10);
        linkedList.add(2);
        linkedList.add(1);
        linkedList.add(5);
        linkedList.printLinkedList();
//        new PartitionLL().Partition(linkedList.head, 5);
        new PartitionLL().PartitionByRearrange(linkedList.head, 5);
        System.out.println("After Partitioning the LL");
        linkedList.printLinkedList();
    }

    public void Partition(LinkedList.Node head, int partition) {

        LinkedList.Node current = head;
        while (current != null) {

            LinkedList.Node runner = null;
            while (current != null && current.data < partition)
                current = current.next;

            if (current != null)
                runner = current.next;

            while (runner != null && runner.data >= partition)
                runner = runner.next;

            if (runner != null && current != null) {
                int temp = current.data;
                current.data = runner.data;
                runner.data = temp;
            } else
                break;
        }

    }


    public LinkedList.Node PartitionByRearrange(LinkedList.Node head, int partition) {
        LinkedList.Node node = head;
        LinkedList.Node smallStart = null;
        LinkedList.Node smallEnd = null;
        LinkedList.Node largerStart = null;
        LinkedList.Node largerEnd = null;
        LinkedList.Node prev = null;
        while (node != null) {
            if (node.data < partition) {
                if (smallStart == null) {
                    smallStart = node;
                    smallEnd =node;

                } else {
                    smallEnd.next = node;
                    smallEnd = smallEnd.next;
                }
                if (prev == null) {
                    head = node.next;
                } else {
                    prev.next = node.next;
                }
                node = node.next;
                smallEnd.next = null;
            } else {
                prev = node;
                node = node.next;
            }

        }
        smallEnd.next = head;

        return smallStart;

    }

}
