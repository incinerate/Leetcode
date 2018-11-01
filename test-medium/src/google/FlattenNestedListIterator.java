package google;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:

Input: [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,1,2,1,1].
Example 2:

Input: [1,[4,[6]]]
Output: [1,4,6]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,4,6].
 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Oct 27, 2018 3:11:11 PM
 */
public class FlattenNestedListIterator implements Iterator<Integer>{
	
	/*
	 * 思路：因为NestedInteger有两种值：integer和List<NestedInteger> 所以在hasNset方法中判断一下，如果
	 * 是Integer就继续执行next(),return 这个Integer,在list中remove掉;否则的话先不执行next()，先展开，再判断
	 * 第一个值是否是Integer， so and so force.
	 */
	
	List<NestedInteger> list;
    NestedInteger item;

	public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        this.list = nestedList;
    }

    @Override
    public Integer next() {
        return list.remove(0).getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!list.isEmpty()) {
        	item = list.get(0);
        	if(item.isInteger()) return true;
            item = list.remove(0);
        	list.addAll(0, item.getList());
        }
		return false;
    }
}
