import sun.awt.image.ImageWatched;

/**
 * Created by Jeet on 06-01-2017.
 */
public class LinkedListsIntersects {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(5);
        linkedList.add(8);
        linkedList.printLinkedList();

        LinkedList linkedList2 = new LinkedList();
        linkedList2.add(7);
        linkedList2.add(6);
        linkedList2.add(2);
        linkedList2.add(4);
        System.out.println("List 2: ");
        linkedList2.printLinkedList();
        LinkedList.Node node = linkedList.head;
        //node = node.next.next;

        LinkedList.Node intersectNode = linkedList2.head;
        while (intersectNode.next != null)
            intersectNode = intersectNode.next;
        intersectNode.next = node;

        LinkedList.Node doIntersects = checkIfListsIntersect(linkedList, linkedList2);
        if (doIntersects != null)
            System.out.println("Intersects at-" + doIntersects.data);
        else
            System.out.println("Lists don't intersect.");
        System.out.println("Check by length.");
        doIntersects = findIntersectingNodeByLength(linkedList, linkedList2);
        if (doIntersects != null)
            System.out.println("Intersects at-" + doIntersects.data);
        else
            System.out.println("Lists don't intersect.");

    }

    private static LinkedList.Node checkIfListsIntersect(LinkedList linkedList, LinkedList linkedList2) {

        LinkedList.Node tail1 = linkedList.head;
        LinkedList.Node tail2 = linkedList2.head;

        while (tail1.next != null)
            tail1 = tail1.next;
        while (tail2.next != null)
            tail2 = tail2.next;

        if (tail1 == tail2) {
            LinkedList.Node node = findIntersectingNode(linkedList, linkedList2);
            return node;
        }
        return null;

    }

    private static LinkedList.Node findIntersectingNode(LinkedList linkedList, LinkedList linkedList2) {

        LinkedList.Node current = linkedList.head;

        while (current != null) {
            LinkedList.Node runner = linkedList2.head;
            while (runner != null) {
                if (current == runner)
                    return current;
                runner = runner.next;
            }
            current = current.next;
        }
        return null;
    }


    private static LinkedList.Node findIntersectingNodeByLength(LinkedList linkedList, LinkedList linkedList2) {

        LinkedList.Node current = linkedList.head;
        LinkedList.Node current2 = linkedList2.head;

        int len1, len2;
        len1 = getListLength(linkedList);
        len2 = getListLength(linkedList2);

        if (len1 == len2) {
            return getIntersectingNode(current, current2);
        } else {
            int diff = Math.abs(len1 - len2);
            if (len1 > len2) {
                for (int i = 0; i < diff; i++) {
                    current = current.next;
                }
            } else {
                for (int i = 0; i < diff; i++) {
                    current2 = current2.next;
                }
            }
            return getIntersectingNode(current, current2);
        }


    }

    private static int getListLength(LinkedList linkedList) {
        LinkedList.Node current = linkedList.head;
        int len1 = 0;

        while (current != null) {
            len1++;
            current = current.next;
        }
        return len1;
    }

    private static LinkedList.Node getIntersectingNode(LinkedList.Node runner1, LinkedList.Node runner2) {
        while (runner1 != null && runner2 != null) {
            if (runner1 == runner2)
                return runner1;
            runner1 = runner2.next;
            runner2 = runner2.next;
        }
        return null;
    }

}
