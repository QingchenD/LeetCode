package ljava;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 说明:
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */

public class SwapListPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return head;

        ListNode pre = head;
        ListNode ls1 = head;
        ListNode ls2 = ls1.next;
        while (ls2 != null) {
            ls1.next = ls2.next;
            ls2.next = ls1;

            if (pre == head) head = ls2;
            else {
                pre.next = ls2;
                pre = ls1;
            }

            ls1 = ls1.next;
            if (ls1 == null) break;
            ls2 = ls1.next;
        }

        return head;
    }
}

