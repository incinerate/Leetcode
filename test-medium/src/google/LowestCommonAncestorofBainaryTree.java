package google;
/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: ��The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).��

Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of of nodes 5 and 1 is 3.
Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself
             according to the LCA definition.
Note:

All of the nodes' values will be unique.
p and q are different and both values will exist in the binary tree.


 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Nov 12, 2018 5:04:14 PM
 */
public class LowestCommonAncestorofBainaryTree {

	/*
	 * ˼·�� �����Tree��BST�������ǿ��Լ��㷨(lowestCommonAncestor_BST),���������ж�pq�Ƿ���root���ߡ�
	 * ���ֻ��һ��binary tree�Ļ������ǿ����õ����������ֱ���root�������������ң����pq��ͬһ�ߣ��ͼ���������ҡ�
	 * 
	 * ����֮�⣬���ǿ��Լ�������Node��binary���е�distance��ֻ��Ҫ��һ�����ڴӸ�Ancestor Node�����ҵ�leftDepth��
	 * RightDepth��
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }
	
	public TreeNode lowestCommonAncestor_BST(TreeNode root, TreeNode p, TreeNode q) {
	    while ((root.val - p.val) * (root.val - q.val) > 0)
	        root = p.val < root.val ? root.left : root.right;
	    return root;
	}
}
