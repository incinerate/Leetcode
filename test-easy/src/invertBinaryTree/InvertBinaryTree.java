package invertBinaryTree;
/**
 * Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
 * @author Administrator
 *
 */
public class InvertBinaryTree {

	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;
		if (root.left != null || root.right != null) {
			TreeNode temp;
			temp = root.right;
			root.right = root.left;
			root.left = temp;
			invertTree(root.left);
			invertTree(root.right);
		}
		
		return root;
	}
}
