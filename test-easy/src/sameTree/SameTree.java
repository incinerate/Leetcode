package sameTree;

public class SameTree {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null) return true;
		while(p!=null && q!=null) {
			if(q.val == p.val) {
				return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
			}else{
                return false;
            }
		}
		return false;
    }
}
