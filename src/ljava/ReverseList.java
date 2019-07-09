package ljava;

/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1038/
 *
 * 反转一个单链表。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 */

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode pre = head;
        while (pre.next != null) {
            ListNode node = pre.next;
            pre.next = node.next;
            node.next = head;
            head = node;
        }

        return head;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null) return head;
        head = reverse(head, head);
        return head;
    }

    private ListNode reverse(ListNode head, ListNode pre) {
        if (pre.next != null) {
            ListNode node = pre.next;
            pre.next = node.next;
            node.next = head;
            head = node;
            head = reverse(head, pre);
        }
        return  head;
    }
}
