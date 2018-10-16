package GoldmanSachs;

import java.util.Stack;

/*
https://www.geeksforgeeks.org/queue-using-stacks/
The problem is opposite of this post. We are given a stack data structure with push and pop operations,
the task is to implement a queue using instances of stack data structure and operations on them.

A queue can be implemented using two stacks. Let queue to be implemented be q and stacks used to
implement q be stack1 and stack2. q can be implemented in two ways:

solution:
Method 1 (By making enQueue operation costly)
This method makes sure that oldest entered element is always at the top of stack 1, so that deQueue operation just pops from stack1.
To put the element at top of stack1, stack2 is used.
enQueue(q, x)
  1) While stack1 is not empty, push everything from stack1 to stack2.
  2) Push x to stack1 (assuming size of stacks is unlimited).
  3) Push everything back to stack1.
Here time complexity will be O(n)

deQueue(q)
  1) If stack1 is empty then error
  2) Pop an item from stack1 and return it
Here time complexity will be O(1)


Method 2 (By making deQueue operation costly)
In this method, in en-queue operation, the new element is entered at the top of stack1.
In de-queue operation, if stack2 is empty then all the elements are moved to stack2 and finally top of stack2 is returned.

enQueue(q,  x)
  1) Push x to stack1 (assuming size of stacks is unlimited).
Here time complexity will be O(1)

deQueue(q)
  1) If both stacks are empty then error.
  2) If stack2 is empty
       While stack1 is not empty, push everything from stack1 to stack2.
  3) Pop the element from stack2 and return it.
Here time complexity will be O(n)

Method 2 is definitely better than method 1.
Method 1 moves all the elements twice in enQueue operation,
while method 2 (in deQueue operation) moves the elements once and moves elements only if stack2 empty.
 */
public class QueueByStack {

    static Stack<Integer> s1 = new Stack<Integer>();
    static Stack<Integer> s2 = new Stack<Integer>();

    static void enQueue(int x) {
        // Move all elements from s1 to s2
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
            //s1.pop();
        }

        // Push item into s1
        s1.push(x);

        // Push everything back to s1
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
            //s2.pop();
        }
    }

    // Dequeue an item from the queue
    static int deQueue() {
        // if first stack is empty
        if (s1.isEmpty()) {
            System.out.println("Q is Empty");
            System.exit(0);
        }

        // Return top of s1
        int x = s1.peek();
        s1.pop();
        return x;
    }
}
