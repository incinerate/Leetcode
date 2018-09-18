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
	 * 用栈后进先出的特点，从根出发，有左孩子压入左孩子，cur指针指向该节点，继续搜索左孩子。若没有左孩子则弹出最近的根节点，搜索右孩子
	 * ，直到空栈
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
