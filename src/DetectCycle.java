/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1023/
 *
 * 环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，
 * 则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 * 进阶：
 * 你是否可以不用额外空间解决此题？
 */

public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
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


    public boolean hasCycle(ListNode head) {
        if (head == null || head.next ==null)
            return false;

        ListNode slowIndex = head;
        ListNode fastIndex = head;

        while (fastIndex != null && fastIndex.next != null){
            slowIndex =slowIndex.next;
            fastIndex =fastIndex.next.next;

            if (slowIndex == fastIndex){
                return true;
            }
        }
        return false;
    }
}
