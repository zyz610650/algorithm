package zyz.algorithm.type.tree.easy;

import zyz.algorithm.utils.TreeNode;

/**
 * @author zyz
 * @title: 相同的树
 * @seq: 100
 * @address: https://leetcode-cn.com/problems/same-tree/
 * @idea:
 */
public class SameTree_144 {

	public  boolean isSameTree(TreeNode p, TreeNode q) {
		if(p==null&&q==null) return true;
		if((p==null&&q!=null)||(p!=null&&q==null)) return false;
		if(p.val!=q.val) return false;
		return (isSameTree(p.left,q.left)&& isSameTree(p.right,q.right));

	}
}
