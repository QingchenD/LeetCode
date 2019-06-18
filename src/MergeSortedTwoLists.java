/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */

public class MergeSortedTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) return null;
        if (l1 == null) return  l2;
        if (l2 == null ) return l1;

        ListNode preHeader = new ListNode(0);
        ListNode tail = preHeader;
        ListNode node1 = l1;
        ListNode node2 = l2;

        while (node1 != null && node2 != null) {
            if (node1.val < node2.val)  {
                tail.next = node1;
                tail = node1;
                node1 = node1.next;
            } else {
                tail.next = node2;
                tail = node2;
                node2 = node2.next;
            }
        }

        //merge the rest of l1
        if (node1 != null) {
            tail.next = node1;
        }

        //merge the rest of l2
        if (node2 != null) {
            tail.next = node2;
        }

        return preHeader.next;
    }

}




