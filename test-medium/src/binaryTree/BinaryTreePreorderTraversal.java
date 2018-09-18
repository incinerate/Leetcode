package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 * Given a binary tree, return the preorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]
Follow up: Recursive solution is trivial, could you do it iteratively?
 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Sep 7, 2018 8:15:15 PM
 */
public class BinaryTreePreorderTraversal {

	public List<Integer> preorderTraversal(TreeNode root) {
	
		List<Integer> list = new ArrayList<Integer>();

	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode cur = root;

	    while(cur!=null || !stack.empty()){
	        while(cur!=null){
	            stack.add(cur);
	            list.add(cur.val);
	            cur = cur.left;
	        }
	        cur = stack.pop();
	        cur = cur.right;
	    }

	    return list;
		
    }
}
