package validateBinarySearchTree;

import java.util.Stack;

public class ValidateBinarySearchTree {

	public static boolean isValidBST(TreeNode root) {
		if (root == null) return true;
		   Stack<TreeNode> stack = new Stack<>();
		   TreeNode pre = null;
		   while (root != null || !stack.isEmpty()) {
		      while (root != null) {
		         stack.push(root);
		         root = root.left;
		      }
		      root = stack.pop();
		      
		      
		      //改造下面代码，可以处理多种binary tree类型的题目
		      if(pre != null && root.val <= pre.val) return false;
		      pre = root;
		      root = root.right;
		   }
		   return true;
    }
}
