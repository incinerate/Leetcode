package symmetricTree;
/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.


 * @author Scott Shi
 *
 */
public class SymmetricTree {

	/*
	 * 除根节点之外，其他节点对称的判定需要左的右孩子等右的左孩子，左的左孩子等于右的右孩子。
	 */
	public boolean isSymmetric(TreeNode root) {
	    return root==null || isSymmetricHelp(root.left, root.right);
	}

	private boolean isSymmetricHelp(TreeNode left, TreeNode right){
	    if(left==null || right==null)
	        return left==right;
	    if(left.val!=right.val)
	        return false;
	    return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
	}
}





