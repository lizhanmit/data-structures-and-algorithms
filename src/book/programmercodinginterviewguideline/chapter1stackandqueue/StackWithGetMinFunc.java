package book.programmercodinginterviewguideline.chapter1stackandqueue;

import java.util.Stack;

/**
 * Time complexity: O(1)
 * Space complexity: O(n)
 */
public class StackWithGetMinFunc {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public StackWithGetMinFunc() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int newNum) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (newNum < this.getMin()) {
            this.stackMin.push(newNum);
        } else {
            this.stackMin.push(this.getMin());
        }

        this.stackData.push(newNum);
    }

    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("The stack is empty");
        }

        this.stackMin.pop();
        return this.stackData.pop();
    }

    public int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("The stack is empty");
        }

        return stackMin.peek();
    }
}
