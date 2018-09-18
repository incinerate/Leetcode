package binaryTree;

import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
 * memory, where h is the height of the tree.
 * 
 * Credits: Special thanks to @ts for adding this problem and creating all test
 * cases.
 * 
 * 
 * @title
 * @description TODO
 * @author Cun Shi
 * @date: Sep 8, 2018 6:33:28 PM
 */
public class BinarySearchTreeIterator {
	/*
	 * ��Ҫ�ҵ���Сֵ�������ҵ�������Ǹ�node������Ĺؼ������backtrace�ҵ���һ����С��ֵ
	 * stack���ԺܺõĴ洢cur�ĸ��ڵ㣬�������Һ���������һ����Сֵ
	 */

	Stack<TreeNode> stack;

	public BinarySearchTreeIterator(TreeNode root) {
		this.stack = new Stack<>();

		TreeNode cur = root;
		while (cur != null) {
			stack.add(cur);
			if (cur.left != null)
				cur = cur.left;
			else
				break;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode cur = stack.pop();
		TreeNode node = cur;
		if (cur.right != null) {
			cur = cur.right;
			while (cur != null) {
				stack.push(cur);
				if (cur.left != null)
					cur = cur.left;
				else
					break;
			}
		}

		return node.val;
	}
}
