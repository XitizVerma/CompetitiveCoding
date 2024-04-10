package ProblemsAndSolutions;

import java.util.Stack;

public class QueueUsingStack {

    Stack<Integer> stack;
    public QueueUsingStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        Stack<Integer> newStack = new Stack<>();
        while(!stack.empty()){
            newStack.push(stack.pop());
        }
        stack.push(x);
        while(!newStack.empty())
            stack.push(newStack.pop());
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.empty();
    }
}

class StockSpanner {

    Stack<Integer> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        stack.push(price);
        Stack<Integer> temp = stack;
        int i=0;
        while(!temp.empty() && temp.peek()<=price){
            i++;
            temp.pop();
        }
        return i;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
