package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {

	/*
	 * 后续遍历可以看成根，右子树，左子树的反向插入，与前序遍历极其相似，唯一不同就是在队首插入，先右后左
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
