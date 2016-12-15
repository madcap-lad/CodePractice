/**
 * Created by Jeet on 12-12-2016.
 */
public class DeleteRandomNodeInLL {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(5);
        linkedList.add(8);
        linkedList.printLinkedList();
        new DeleteRandomNodeInLL().delete(linkedList.head);
        System.out.println("After Deleting the node");
        linkedList.printLinkedList();
    }

    public void delete(LinkedList.Node nodeToDelete)
    {

        LinkedList.Node currentNode = nodeToDelete.next;
        LinkedList.Node prev = nodeToDelete;

        while(currentNode.next!=null)
        {
            prev.data=currentNode.data;
            prev = currentNode;
            currentNode = currentNode.next;

        }
        prev.data = currentNode.data;
        prev.next = null;
    }

}
