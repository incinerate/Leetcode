package google;

/**
 * Given a complete binary tree, count the number of nodes.

Note:

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Example:

Input: 
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6
 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Dec 29, 2018 6:39:52 PM
 */
public class CountCompleteTreeNodes {

	//��һ�뷨���������O(n), TLE. ������O(log(n))�ķ�����height����O(logn), countNodes����O(logn),��������
	//ʱ�临�Ӷ�O(logn^2), amazing solution!
	private int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
    public int countNodes(TreeNode root) {
        int h = height(root);
        return h < 0 ? 0 :
               height(root.right) == h-1 ? (1 << h) + countNodes(root.right)
                                         : (1 << h-1) + countNodes(root.left);
    }
}
