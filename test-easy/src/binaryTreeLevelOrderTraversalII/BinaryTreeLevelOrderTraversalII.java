package binaryTreeLevelOrderTraversalII;

import java.util.LinkedList;
import java.util.List;
/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]

 * @author Scott Shi
 *
 */
public class BinaryTreeLevelOrderTraversalII {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<TreeNode> l = new LinkedList<>();
		List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        if(root == null) return wrapList;
        
        l.offer(root);
        while(!l.isEmpty()){
            int levelNum = l.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(l.peek().left != null) l.offer(l.peek().left);
                if(l.peek().right != null) l.offer(l.peek().right);
                subList.add(l.poll().val);
            }
            //¹Ø¼ü
            wrapList.add(0,subList);
        }
        return wrapList;
    }
}
