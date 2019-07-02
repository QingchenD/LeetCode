import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 341. 扁平化嵌套列表迭代器
 * https://leetcode-cn.com/problems/flatten-nested-list-iterator/comments/
 *
 *
 */

public class NestedIterator implements Iterator<Integer> {

    /**
     * 执行用时 :7 ms, 在所有 Java 提交中击败了77.02%的用户
     * 内存消耗 :40.7 MB, 在所有 Java 提交中击败了32.05%的用户
     */
    private List<Integer> list = new ArrayList<>();
    private Iterator<Integer> iterator;

    public NestedIterator(List<NestedInteger> nestedList) {
        for(NestedInteger item:nestedList){
            unfold(item);
        }
        iterator = list.iterator();
    }

    private void unfold(NestedInteger nested){
        if(nested.isInteger()){
            list.add(nested.getInteger());
        }
        else{
            for(NestedInteger item:nested.getList()){
                unfold(item);
            }
        }
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }


    /**
     * 执行用时 :7 ms, 在所有 Java 提交中击败了77.02%的用户
     * 内存消耗 :41.2 MB, 在所有 Java 提交中击败了28.85%的用户
     */
    /*
    private List<Integer> list = new ArrayList<>();
    private int index;
    private void add(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                list.add(nestedInteger.getInteger());
            } else {
                add(nestedInteger.getList());
            }
        }
    }

    public NestedIterator(List<NestedInteger> nestedList) {
        add(nestedList);
    }

    @Override
    public Integer next() {
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }
    */
}

 interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
 }
