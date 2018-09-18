package maximumDepthofBinaryTree;

/**
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root
 * node down to the farthest leaf node.
 * 
 * @author Administrator
 *
 */
public class MaxDepthofBinaryTree {

	public int maxDepth(BinaryTreeNode root) {
		if (root == null)
			return 0;
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

}
/*
 * if the node does not exist, simply return 0. Otherwise, return the 1+the
 * longer distance of its subtree.
 */