import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 234. 回文链表
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 *
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 *
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 */

public class PalindromeList {

    /**
     *  使用栈来存储，不破坏链表结构
     *
     *  本以为使用数组后，速度会快些，但使用数组存储数据，不仅浪费空间，而且速度慢：
     *  1. 或许数组的扩容比较浪费时间？
     *  2. 或许整数的装箱，拆箱比较费时间？
     *
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        List<Integer> list = new ArrayList<>();
        ListNode h = head;
        while (h != null) {
            list.add(h.val);
            h = h.next;
        }

        int count = list.size() >> 1;
        for (int i = 0; i < count; i++) {
            if (list.get(i).intValue() != list.get(list.size() - 1 - i).intValue()) return false;
        }

        return true;
    }



    /**
     * 反转后半段字符串，破坏了链表的结构。
     * @param head
     * @return
     */
    public boolean isPalindrome1(ListNode head) {
        if (head == null) return true;

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //反转后半部分字符
        ListNode halfHead = slow.next;
        ListNode pre = null,next = null;
        if (halfHead != null) {
            pre = halfHead.next;
            halfHead.next = null;
        }

        while (pre != null) {
            next = pre.next;
            pre.next = halfHead;
            halfHead = pre;
            pre = next;
        }

        ListNode l1 = head;
        ListNode l2 = halfHead;
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val)  break;

            l1 = l1.next;
            l2 = l2.next;
        }

        return (l2 == null);
    }
}
