package binaryTree;
/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Sep 4, 2018 5:15:25 PM
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
	/*
	 * ����˼·���������ƣ�����inorder���ҵ�root������postorder������root�����Եõ�����������������
	 * ���ѭ����ע��3��������inStart,inEnd,��postStart.ע����������������postStart�ı�ʾ������
	 */
	public TreeNode buildTree(int[] inorder, int[] postorder) {
	    return buildTree(inorder, inorder.length-1, 0, postorder, postorder.length-1);
	}

	private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder,
			int postStart) {
		if (postStart < 0 || inStart < inEnd)
			return null;
		
		//The last element in postorder is the root.
		TreeNode root = new TreeNode(postorder[postStart]);
		
		//find the index of the root from inorder. Iterating from the end.
		int rIndex = inStart;
		for (int i = inStart; i >= inEnd; i--) {
			if (inorder[i] == postorder[postStart]) {
				rIndex = i;
				break;
			}
		}
		//build right and left subtrees. Again, scanning from the end to find the sections.
		root.right = buildTree(inorder, inStart, rIndex + 1, postorder, postStart-1);
		root.left = buildTree(inorder, rIndex - 1, inEnd, postorder, postStart - (inStart - rIndex) -1);
		return root;
	}
}