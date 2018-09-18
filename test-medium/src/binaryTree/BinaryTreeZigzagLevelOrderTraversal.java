package binaryTree;

import java.util.LinkedList;
import java.util.List;
/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

	For example:
	Given binary tree [3,9,20,null,null,15,7],
	    3
	   / \
	  9  20
	    /  \
	   15   7
	return its zigzag level order traversal as:
	[
	  [3],
	  [20,9],
	  [15,7]
	]

 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Sep 2, 2018 9:53:14 PM
 */
public class BinaryTreeZigzagLevelOrderTraversal {

	/*
	 * ��BinaryTreeLevelOrderTraversal���ƣ�ֻ������һ��flag����������linkedlist�м���
	 * ���ӻ����Һ��ӣ�ע��collection����һ��add(index,object) �ķ������Կ��Ƽ���object��λ�ã�0��ʾ����ͷ��
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		LinkedList<TreeNode> l = new LinkedList<>();
		List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
		if (root == null)
			return wrapList;

		boolean order = true;
		l.offer(root);
		while (!l.isEmpty()) {
			int levelNum = l.size();
			List<Integer> subList = new LinkedList<Integer>();
			for (int i = 0; i < levelNum; i++) {
				TreeNode node = l.poll();
				if(order)
					subList.add(node.val);
				else {
					subList.add(0, node.val);
				}
				if (node.left != null)
					l.offer(node.left);
				if (node.right != null)
					l.offer(node.right);
			}
			wrapList.add(subList);
			order = !order;
		}
		return wrapList;
	}
}
