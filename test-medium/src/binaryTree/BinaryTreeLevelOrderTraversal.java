package binaryTree;

import java.util.LinkedList;
import java.util.List;
/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 * @title 
 * @description TODO
 * @author Cun Shi
 * @date:   Sep 1, 2018 10:06:11 PM
 */
public class BinaryTreeLevelOrderTraversal {

	/*
	 * 每次在linkedlist中加入一层level中的所有node，找到这些node的下一层node，再把它们都删除掉。用levelNum 可以完美
	 * 控制for循环次数
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
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
            wrapList.add(subList);
        }
        return wrapList;
    }
}
