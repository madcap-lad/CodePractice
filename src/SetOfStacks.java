import org.omg.CORBA.portable.ApplicationException;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jeet on 10-01-2017.
 */
public class SetOfStacks {

    private int maxStackSize;
    int[][] values;
    int currentStack = 0, top = -1;
    int defaultStacksCount = 10;

    public SetOfStacks() {

    }


    public SetOfStacks(int maxStackSize) {
        this.maxStackSize = maxStackSize;
        values = new int[defaultStacksCount][maxStackSize];
    }

    public static void main(String[] args) {
        SetOfStacks stacks = new SetOfStacks(10);
        for(int i=1;i<25;i++)
        {
            stacks.push(i);
        }
        Scanner sc = new Scanner(System.in);
        sc.next();

        for(int j=0;j<15;j++)
        {
            System.out.println(stacks.pop());
        }
    }

    void push(int value) {
        if (top == maxStackSize - 1) {
            checkAndExpandArray();
            currentStack++;
            top = 0;
        } else {
            ++top;
        }
        values[currentStack][top] = value;
    }


    int pop() {
        if (top == -1)
            throw new IllegalStateException("Stack is empty.");

        int data = values[currentStack][top];
        values[currentStack][top] = Integer.MIN_VALUE;

        if (top == 0 && currentStack == 0) {
            top = -1;
        } else if (top == 0) {
            top = maxStackSize - 1;
            currentStack--;
        } else
            top--;
        return data;
    }


    private void checkAndExpandArray() {
        if (currentStack == defaultStacksCount-1) {
            int newStore[][] = new int[2 * values.length][];

            for (int i = 0; i < values.length; i++) {
                newStore[i] = Arrays.copyOf(values[i], values[i].length);
            }

            values = newStore;
        }

    }

}
