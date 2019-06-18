import java.security.Key;
import java.util.*;

/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/245/data-structure/1033/
 *
 * 全 O(1) 的数据结构
 * 实现一个数据结构支持以下操作：
 *
 * Inc(key) - 插入一个新的值为 1 的 key。或者使一个存在的 key 增加一，保证 key 不为空字符串。
 * Dec(key) - 如果这个 key 的值是 1，那么把他从数据结构中移除掉。否者使一个存在的 key 值减一。如果这个 key 不存在，这个函数不做任何事情。key 保证不为空字符串。
 * GetMaxKey() - 返回 key 中值最大的任意一个。如果没有元素存在，返回一个空字符串""。
 * GetMinKey() - 返回 key 中值最小的任意一个。如果没有元素存在，返回一个空字符串""。
 *
 * 挑战：以 O(1) 的时间复杂度实现所有操作。
 *
 */

public class AllOne {

    LinkedNodeSet head;
    LinkedNodeSet tail;
    HashMap<String, LinkedNodeSet> hashMap;
    /** Initialize your data structure here. */
    public AllOne() {
        hashMap = new HashMap<>();
        head = tail = null;
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (hashMap.containsKey(key)) {
            LinkedNodeSet nodeSet = hashMap.get(key);
            LinkedNodeSet set = incAddNode(nodeSet, key, nodeSet.value + 1);
            hashMap.put(key, set);
        } else {
            LinkedNodeSet set = incAddNode(null, key, 1);
            hashMap.put(key, set);
        }

    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (hashMap.containsKey(key)) {
            LinkedNodeSet nodeSet = hashMap.get(key);
            LinkedNodeSet set = decRemoveNode(nodeSet,key);
            if (set == null) {
                hashMap.remove(key);
            } else {
                hashMap.put(key, set);
            }
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (hashMap.size() == 0) {
            return "";
        }

//        StringBuilder stringBuilder = new StringBuilder();
//        for (String str : tail.set) {
//            stringBuilder.append(str);
//        }
//        return stringBuilder.toString();

        Iterator<String> iterator = tail.set.iterator();
        String result = null ;
        while (iterator.hasNext()) {
            result = iterator.next();
        }

        return result;
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (hashMap.size() == 0) {
            return "";
        }

//        StringBuilder stringBuilder = new StringBuilder();
//        for (String str : head.set) {
//            stringBuilder.append(str);
//        }
//
//        return stringBuilder.toString();

        Iterator<String> iterator = head.set.iterator();
        String result = null ;
        while (iterator.hasNext()) {
            result = iterator.next();
        }

        return result;
    }

    private LinkedNodeSet incAddNode(LinkedNodeSet current, String key, int value) {
        if (current != null) {
            current.set.remove(key);
            if (current.next != null) {
                LinkedNodeSet nextNodeSet = current.next;
                if (nextNodeSet.value == value) {
                    nextNodeSet.set.add(key);
                    removeEmptyNodeSet(current, current.pre, current.next);
                    return nextNodeSet;
                } else {
                    LinkedNodeSet newNodeSet = new LinkedNodeSet(current, nextNodeSet, value);
                    current.next = newNodeSet;
                    nextNodeSet.pre = newNodeSet;
                    newNodeSet.set.add(key);
                    removeEmptyNodeSet(current, current.pre, current.next);
                    return newNodeSet;
                }
            } else {
                LinkedNodeSet newNodeSet = new LinkedNodeSet(current, null, value);
                current.next = newNodeSet;
                newNodeSet.set.add(key);
                tail = newNodeSet;
                removeEmptyNodeSet(current, current.pre, current.next);
                return newNodeSet;

            }

        } else {
            if (head == null) {
                LinkedNodeSet newNodeSet = new LinkedNodeSet(null, null, value);
                newNodeSet.set.add(key);
                head = tail = newNodeSet;
                return newNodeSet;
            } else {
                if (head.value == value) {
                    head.set.add(key);
                    return head;
                } else {
                    LinkedNodeSet newNodeSet = new LinkedNodeSet(null, head, value);
                    newNodeSet.set.add(key);
                    head.pre = newNodeSet;
                    head = newNodeSet;
                    return head;
                }
            }
        }
    }

    private LinkedNodeSet decRemoveNode(LinkedNodeSet current, String key) {
        if (current.value == 1) {
            current.set.remove(key);
            removeEmptyNodeSet(current, current.pre, current.next);
            return null;
        } else {
            current.set.remove(key);
            if (current.pre != null) {
                LinkedNodeSet nodeSet = current.pre;
                if (nodeSet.value == current.value - 1) {
                    nodeSet.set.add(key);
                    removeEmptyNodeSet(current, current.pre, current.next);
                    return nodeSet;
                } else {
                    LinkedNodeSet newNodeSet = new LinkedNodeSet(nodeSet,current,current.value - 1);
                    nodeSet.next = newNodeSet;
                    current.pre = newNodeSet;
                    newNodeSet.set.add(key);
                    removeEmptyNodeSet(current, current.pre, current.next);
                    return newNodeSet;
                }
            } else {
                LinkedNodeSet newNodeSet = new LinkedNodeSet(null,current,current.value - 1);
                current.pre = newNodeSet;
                newNodeSet.set.add(key);
                head = newNodeSet;
                removeEmptyNodeSet(current, current.pre, current.next);
                return newNodeSet;
            }
        }
    }

    private void removeEmptyNodeSet(LinkedNodeSet current, LinkedNodeSet pre, LinkedNodeSet next) {
        if (current.set.size() == 0) {
            if (pre != null && next != null) {
                pre.next = next;
                next.pre = pre;
            } else if (pre != null) {
                pre.next = null;
                tail = pre;
            } else if (next != null) {
                next.pre = null;
                head = next;
            } else {
                head = tail = null;
            }
        }
    }

    class LinkedNodeSet {
        LinkedNodeSet pre;
        LinkedNodeSet next;
        HashSet<String> set;
        int value;

        LinkedNodeSet(LinkedNodeSet pre, LinkedNodeSet next, int value) {
            this.pre = pre;
            this.next = next;
            this.value = value;
            set = new HashSet<>();
        }
    }

}
