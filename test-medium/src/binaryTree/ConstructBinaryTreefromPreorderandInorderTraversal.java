package binaryTree;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.

	Note:
	You may assume that duplicates do not exist in the tree.
	
	For example, given
	
	preorder = [3,9,20,15,7]
	inorder = [9,3,15,20,7]
	Return the following binary tree:
	
	    3
	   / \
	  9  20
	    /  \
	   15   7

 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Sep 3, 2018 7:38:12 PM
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {

	/*
	 * The basic idea is here:
	Say we have 2 arrays, PRE and IN.
	Preorder traversing implies that PRE[0] is the root node.
	Then we can find this PRE[0] in IN, say it's IN[5].
	Now we know that IN[5] is root, so we know that IN[0] - IN[4] is on the left side, IN[6] to the end is on the right side.
	Recursively doing this on subarrays, we can build a tree out of it :)
	 */
	 public TreeNode buildTree(int[] preorder, int[] inorder) {
		 return recersive(preorder,inorder,inorder.length-1,0,0);
	 }

	private TreeNode recersive(int[] preorder, int[] inorder, int inEnd, int pre, int in) {
		if (pre > preorder.length - 1 || in > inEnd) {
	        return null;
	    }
		TreeNode root = new TreeNode(preorder[pre]);
		
//		int index = Arrays.binarySearch(inorder, root.val);
		int index = 0;
		for (int i = in; i <= inEnd; i++) {
	        if (inorder[i] == root.val) {
	            index = i;
	        }
	    }
		root.left = recersive(preorder, inorder, index-1, pre+1, in);
		root.right = recersive(preorder, inorder, inEnd, pre+index-in+1, index+1);
		// TODO Auto-generated method stub
		return root;
	}
}
