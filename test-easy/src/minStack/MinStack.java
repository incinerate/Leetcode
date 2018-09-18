package minStack;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

 * @author Scott Shi
 *
 */
public class MinStack {
	/*
	 * ��ͨ��stack����ʵ��ǰ����ܣ���Ҫget��Min num����Ҫ������Stack�е�Ԫ�ؽ��м�¼���������ÿ�����һ��������LinkedListʵ��
	 */
	
	Stack<Integer> stack;
	LinkedList<Integer> list;

	/** initialize your data structure here. */
    public MinStack() {
        this.stack = new Stack<>();
        this.list = new LinkedList<>();
    }
    
    public void push(int x) {
    	list.add(x);
        stack.push(x);
        Collections.sort(list);
    }
    
    public void pop() {
        Integer pop = stack.pop();
        list.remove(pop);
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return list.getFirst();
    }
}
