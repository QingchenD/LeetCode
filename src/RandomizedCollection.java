import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * 381. O(1) 时间插入、删除和获取随机元素 - 允许重复
 * https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
 *
 * 设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。
 * 注意: 允许出现重复元素。
 * insert(val)：向集合中插入元素 val。
 * remove(val)：当 val 存在时，从集合中移除一个 val。
 * getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。
 */

public class RandomizedCollection {

    /**
     * 执行用时 :137 ms, 在所有 Java 提交中击败了35.07%的用户
     * 内存消耗 :39.4 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    private ArrayList<Integer> list;
    private Random random;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        this. list = new ArrayList<>();
        this.random = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        return list.add(val);
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        return list.remove(Integer.valueOf(val));
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
