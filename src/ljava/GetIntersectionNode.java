package ljava;

/**
 *  https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1024/
 *
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * 注意：
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 */

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int listASize = 0;
        int listBSize = 0;
        ListNode tail = headA;
        while (tail != null) {
            listASize ++;
            tail = tail.next;
        }

        tail = headB;
        while (tail != null) {
            listBSize ++;
            tail = tail.next;
        }

        int count ;
        ListNode currentA = headA;
        ListNode currentB = headB;
        boolean listALonger = (listASize - listBSize > 0);
        count = Math.abs(listASize - listBSize);
        while (currentA != null && currentB != null) {
            if (count > 0) {
                count --;
                if (listALonger) currentA = currentA.next;
                else currentB = currentB.next;
            } else {
                if (currentA == currentB) return currentA;
                else {
                    currentA = currentA.next;
                    currentB = currentB.next;
                }
            }
        }

        return null;

    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode tail = headA;
        while (tail.next != null) {
            tail = tail.next;
        }

        // create a circle
        tail.next = headB;

        // find cross node
        ListNode crossNode = detectCycle(headA);

        // set back
        tail.next = null;

        return crossNode;
    }

    private ListNode detectCycle(ListNode head) {
        if (head == null || head.next ==null)
            return null;

        ListNode slowIndex = head;
        ListNode fastIndex = head;

        while (fastIndex != null && fastIndex.next != null){
            slowIndex =slowIndex.next;
            fastIndex =fastIndex.next.next;

            if (slowIndex == fastIndex){
                slowIndex = head;

                while (slowIndex != fastIndex){
                    slowIndex = slowIndex.next;
                    fastIndex =fastIndex.next;
                }
                return slowIndex;
            }
        }
        return null;
    }
}
