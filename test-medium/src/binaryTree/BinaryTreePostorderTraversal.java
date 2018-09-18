package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {

	/*
	 * �����������Կ��ɸ������������������ķ�����룬��ǰ������������ƣ�Ψһ��ͬ�����ڶ��ײ��룬���Һ���
	 */
	 public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		while(cur!=null || !stack.empty()) {
			while(cur!=null) {
				stack.add(cur);
				res.add(0,cur.val);
				cur = cur.right;
			}
			cur = stack.pop();
			cur = cur.left;
		}
		
		return res;
	        
	 }
}
