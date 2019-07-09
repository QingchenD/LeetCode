package ljava;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 *
 * 使用栈实现队列的下列操作：
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 *
 * 示例:
 * MyQueue queue = new MyQueue();
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 *
 * 说明:
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作
 *
 */

public class MyQueue {

    /**
     * 用时62ms,超过99.73%的用户
     */

    /**
     * 执行用时 :63 ms, 在所有 Java 提交中击败了99.58%的用户
     * 内存消耗 :34.1 MB, 在所有 Java 提交中击败了56.79%的用户
     */
    private Stack<Integer> firstStack;
    private Stack<Integer> secondStack;

    /** Initialize your data structure here. */
    public MyQueue() {
        firstStack = new Stack<>();
        secondStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        firstStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (secondStack.isEmpty()) {
            while (!firstStack.isEmpty()) {
                secondStack.push(firstStack.pop());
            }
        }
        return secondStack.isEmpty() ? -1 : secondStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (secondStack.isEmpty()) {
            while (!firstStack.isEmpty()) {
                secondStack.push(firstStack.pop());
            }
        }

        return secondStack.isEmpty() ? -1 : secondStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return firstStack.isEmpty() && secondStack.isEmpty();
    }
}
