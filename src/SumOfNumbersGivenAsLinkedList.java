/**
 * Created by Jeet on 16-12-2016.
 * Sums up two numbers represented as Linked list
 * Input: (7-) 1 -) 6) + (5 -) 9 -) 2) .Thatis,617 + 295
 * Output: 2 -) 1 -) 9.That is, 912.
 */
public class SumOfNumbersGivenAsLinkedList {


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(9);
        linkedList.add(7);
        linkedList.add(8);
        linkedList.printLinkedList();
        int number = new SumOfNumbersGivenAsLinkedList().GetNumberFromLL(linkedList.head);
        System.out.println(number);
        int numberInReverse = new SumOfNumbersGivenAsLinkedList().GetNumberFromLLInReverse(linkedList.head,0);
        System.out.println("Reverse Order- "+numberInReverse);
    }

    public int Sum(LinkedList.Node head1, LinkedList.Node head2) {
        LinkedList.Node node1 = head1;
        LinkedList.Node node2 = head2;

        int number1 = GetNumberFromLL(node1);
        return number1;
    }

    public int GetNumberFromLL(LinkedList.Node node) {

        if (node.next == null) {
            return node.data;
        } else {
            int digit = GetNumberFromLL(node.next);
            int digitPlace = 1;
            int data = digit;
            do {
                digitPlace *= 10;
            } while ((data = data / 10) > 0);

            digit = (node.data * digitPlace) + digit;
            return digit;
        }
    }

    public int GetNumberFromLLInReverse(LinkedList.Node node, int index) {
        if (node == null) {
            return 0;
        } else {
            int digit = GetNumberFromLLInReverse(node.next, index + 1);
            int digitPlace = (int) Math.pow(10, index);
            return node.data * digitPlace + digit;
        }

    }

}
