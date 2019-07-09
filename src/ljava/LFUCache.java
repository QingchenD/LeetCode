package ljava;

import java.util.*;

/**
 * 460. LFU缓存
 * https://leetcode-cn.com/problems/lfu-cache/
 *
 * 设计并实现最不经常使用（LFU）缓存的数据结构。它应该支持以下操作：get 和 put。
 * get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
 * put(key, value) - 如果键不存在，请设置或插入值。当缓存达到其容量时，它应该在插入新项目之前，使最不经常使用的项目无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，最近最少使用的键将被去除。
 *
 * 进阶：
 *   你是否可以在 O(1) 时间复杂度内执行两项操作？
 *
 * 示例：
 *   LFUCache cache = new LFUCache( 2 );
 *
 *       cache.put(1, 1);
 *       cache.put(2, 2);
 *       cache.get(1);       // 返回 1
 *       cache.put(3, 3);    // 去除 key 2
 *       cache.get(2);       // 返回 -1 (未找到key 2)
 *       cache.get(3);       // 返回 3
 *       cache.put(4, 4);    // 去除 key 1
 *       cache.get(1);       // 返回 -1 (未找到 key 1)
 *       cache.get(3);       // 返回 3
 *       cache.get(4);       // 返回 4
 */

public class LFUCache {

    /**
     * 执行用时 :176 ms, 在所有 Java 提交中击败了59.46%的用户
     * 内存消耗 :63.2 MB, 在所有 Java 提交中击败了77.78%的用户
     *
     * 最好表现：
     * 执行用时 :104 ms, 在所有 Java 提交中击败了95.50%的用户
     * 内存消耗 :53 MB, 在所有 Java 提交中击败了97.22%的用户
     */
    private HashMap<Integer, Node> map;
    private HashMap<Integer, LinkedHashSet<Integer>> frequencyMap;
    private int capacity;
    private int size;
    private int minFrequency;
    public LFUCache(int capacity) {
        this.map = new HashMap<>();
        this.frequencyMap = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;
        this.minFrequency = Integer.MAX_VALUE;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        reInsert(key, node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            reInsert(key, node);
        } else {
            if (size >= capacity) {
                removeNode();
            }
            Node node = new Node(key, value);
            insert(key, node);
            map.put(key,node);
            size++;
        }
    }

//    private void insert1(int key, Node node) {
//        LinkedHashSet<Integer> set = frequencyMap.get(node.frequency);
//        if (set == null) {
//            set = new LinkedHashSet<>();
//            frequencyMap.put(node.frequency, set);
//        }
//        set.add(key);
//        minFrequency = Math.min(node.frequency, minFrequency);
//    }

    private void insert(int key, Node node) {
        minFrequency = Math.min(node.frequency, minFrequency);
        frequencyMap.computeIfAbsent(node.frequency,k -> new LinkedHashSet<>()).add(key);
    }

    private void reInsert(int key, Node node) {
        LinkedHashSet<Integer> set = frequencyMap.get(node.frequency);
        if (set != null && set.size() > 0) {
            set.remove(key);
            if (minFrequency == node.frequency && set.size() == 0) {
                minFrequency = Integer.MAX_VALUE;
            }
        }

        node.frequency += 1;
        insert(key, node);
    }

    private void removeNode() {
        LinkedHashSet<Integer> set = frequencyMap.get(minFrequency);
        Iterator<Integer> iterator = set.iterator();
        Integer key = iterator.next();
        set.remove(key);
        map.remove(key);
        size--;
    }

    class Node {
        int key;
        int value;
        int frequency;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
        }
    }

    /**
     * 算法:
     *   使用HashMap来存储数据，使用双向链表来按照Frequency降序排序。 实现方法有参照LinkedHashMap类。
     *
     * 时间复杂度：O(c)
     * 空间复杂度：O(c)
     *
     * 执行用时 :219 ms, 在所有 Java 提交中击败了17.86%的用户
     * 内存消耗 :67.9 MB, 在所有 Java 提交中击败了41.67%的用户
     *
     * 算法的整体效率不高，主要耗时是在，访问数据后，需要根据Frenquency排序数据。
     */
//    private HashMap<Integer, Node> map;
//    private Node head, last;
//    private int capacity;
//    private int size;
//
//    public LFUCache(int capacity) {
//        this.map = new HashMap<>();
//        this.head = null;
//        this.last = null;
//        this.size = 0;
//        this.capacity = capacity;
//    }
//
//    public int get(int key) {
//        if (!map.containsKey(key)) return  -1;
//
//        Node node = map.get(key);
//        int rst = node.value;
//        reInsert(node, node.frequency + 1);
//        return rst;
//    }
//
//    public void put(int key, int value) {
//        if (capacity <= 0) return;
//
//        Node node;
//        if (map.containsKey(key)) {
//            node = map.get(key);
//            node.value = value;
//            reInsert(node, node.frequency + 1);
//        } else {
//            //容量满，删除最后一个
//            if (size >= capacity) {
//                map.remove(last.key);
//                size--;
//                if (size == 0) {
//                    head = last = null;
//                } else {
//                    Node pre = last.pre;
//                    pre.next = null;
//                    last = pre;
//                }
//            }
//
//            //插入最后一个
//            node = new Node(key, value);
//            map.put(key, node);
//            insert(last, node);
//        }
//    }
//
//    /**
//     *  先删除，再插入
//     */
//    private void reInsert(Node node, int frequency) {
//        //删除Node
//        if (size == 1) {
//            //不需要删除，直接frenquency++;
//            node.frequency = frequency;
//        } else {
//            Node preNode = node.pre;
//            if (node.pre != null) {
//                node.pre.next = node.next;
//                if (node.next != null) {
//                    node.next.pre = node.pre;
//                } else {
//                    last = node.pre;
//                }
//            } else {
//                head = node.next;
//            }
//            size --;
//            node.frequency = frequency;
//            insert(preNode, node);
//        }
//    }
//
//    private void insert(Node preNode, Node node) {
//        Node n = preNode;
//        while (n != null) {
//            if (n.frequency > node.frequency) break;
//            n = n.pre;
//        }
//
//        if (n == null) { //node.frequency is biggest
//            node.pre = null;
//            node.next = head;
//            if (size == 0) {
//                head = last = node;
//            } else {
//                head.pre = node;
//                head = node;
//            }
//        } else {
//            node.pre = n;
//            node.next = n.next;
//
//            if (n.next != null) {
//                n.next.pre = node;
//            } else {
//                last = node;
//            }
//            n.next = node;
//        }
//
//        size++;
//    }
//
//    class Node {
//        Node pre;
//        Node next;
//        int key;
//        int value;
//        int frequency;
//        Node (int key, int value) {
//            this.key = key;
//            this.value = value;
//            this.pre = null;
//            this.next = null;
//            this.frequency = 1;
//        }
//    }
}
