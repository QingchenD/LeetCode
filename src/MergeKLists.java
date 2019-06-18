import javax.swing.text.html.MinimalHTMLWriter;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */


public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        boolean hasNode = true;
        ListNode header = null;
        ListNode tail = null;
        ListNode node;
        int minIndex;

        while (hasNode) {
            hasNode = false;
            minIndex = 0;
            for (int i = 0 ; i < lists.length; i++) {
                if (lists[i] == null) continue;
                else hasNode = true;

                minIndex = getMin(lists,minIndex, i);
            }
            if (!hasNode) break;
            node = lists[minIndex];
            lists[minIndex] = node.next;

            if (header == null) {
                header = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        return header;
    }

    private int getMin(ListNode[] lists, int l, int r) {
        if (lists[l] == null && lists[r] == null) return -1;
        else if (lists[l] == null) return r;
        else if (lists[r] == null) return l;
        if (lists[l].val > lists[r].val) return r;
        else return l;
    }
}


