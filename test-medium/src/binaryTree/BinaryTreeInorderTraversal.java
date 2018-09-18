package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?
 * 
 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Aug 29, 2018 11:32:52 PM
 */
public class BinaryTreeInorderTraversal {

	/*
	 * ��ջ����ȳ����ص㣬�Ӹ�������������ѹ�����ӣ�curָ��ָ��ýڵ㣬�����������ӡ���û�������򵯳�����ĸ��ڵ㣬�����Һ���
	 * ��ֱ����ջ
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();

	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode cur = root;

	    while(cur!=null || !stack.empty()){
	        while(cur!=null){
	            stack.add(cur);
	            cur = cur.left;
	        }
	        cur = stack.pop();
	        list.add(cur.val);
	        cur = cur.right;
	    }

	    return list;
    }
}
