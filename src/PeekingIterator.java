import com.sun.org.apache.regexp.internal.RE;

import java.util.Iterator;
import java.util.Stack;

/**
 * 284. 顶端迭代器
 * https://leetcode-cn.com/problems/peeking-iterator/
 *
 * 给定一个迭代器类的接口，接口包含两个方法： next() 和 hasNext()。设计并实现一个支持 peek() 操作的顶端迭代器 -- 其本质就是把原本应由 next() 方法返回的元素 peek() 出来。
 *
 * 示例:
 * 假设迭代器被初始化为列表 [1,2,3]。
 * 调用 next() 返回 1，得到列表中的第一个元素。
 * 现在调用 peek() 返回 2，下一个元素。在此之后调用 next() 仍然返回 2。
 * 最后一次调用 next() 返回 3，末尾元素。在此之后调用 hasNext() 应该返回 false。
 *
 * 进阶：你将如何拓展你的设计？使之变得通用化，从而适应所有的类型，而不只是整数型？
 *
 */

class PeekingIterator implements Iterator<Integer> {

    /**
     * 执行用时 :97 ms, 在所有 Java 提交中击败了81.21%的用户
     * 内存消耗 :35.5 MB, 在所有 Java 提交中击败了65.79%的用户
     */

    private Iterator<Integer> iterator;
    private Integer peek;
    public PeekingIterator (Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        this.peek = iterator.hasNext()? iterator.next() : null;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return peek;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer rst = peek;
        if (iterator.hasNext()) {
            peek = iterator.next();
        } else {
            peek = null;
        }
        return rst;
    }

    @Override
    public boolean hasNext() {
        return (peek != null || iterator.hasNext());
    }




    /**
     * 执行用时 :99 ms, 在所有 Java 提交中击败了66.06%的用户
     * 内存消耗 :35.6 MB, 在所有 Java 提交中击败了65.79%的用户
     */

    /*
    private Iterator<Integer> iterator;
    private Stack<Integer> stack;
    public PeekingIterator (Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        this.stack = new Stack<>();
        stack.push(iterator.next());
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return stack.peek();
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer rst = stack.pop();
        if (iterator.hasNext()) {
            stack.push(iterator.next());
        }

        return rst;
    }

    @Override
    public boolean hasNext() {
        return (!stack.isEmpty() || iterator.hasNext());
    }
    */
}
