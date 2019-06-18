/**
 * https://leetcode-cn.com/problems/rotate-list/
 *
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 *
 * 示例 2:
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 */

public class RotateListRight {

    //快慢指针
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;

        ListNode slow = head, fast = head;
        for (int i = 1; i <= k; i++) {
            if (fast.next != null) fast = fast.next;
            else if (k == i) {
                return head;
            } else  {
                k = k % i;
                i = 0; //  i will add 1 in for{} , so stat with 0=(1-1);
                fast = head;
            }
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;
    }
}
