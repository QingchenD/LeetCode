/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1040/
 *
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 *
 * 示例 2:
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */

public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        // find the middle of the list;
        ListNode walker = head;
        ListNode runner = head;
        ListNode prev = null;
        while(runner != null && runner.next != null)
        {
            prev = walker;
            walker = walker.next;
            runner = runner.next.next;
        }

        //broke the list
        prev.next = null;

        //sort left and right
        ListNode lhs = sortList(head);
        ListNode rhs = sortList(walker);

        //merge left and right and return the list
        return mergeTwoLists(lhs, rhs);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
