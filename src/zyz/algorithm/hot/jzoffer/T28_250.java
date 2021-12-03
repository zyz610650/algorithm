package zyz.algorithm.hot.jzoffer;

import zyz.algorithm.utils.TreeNode;

/**
 * @author zyz
 * @title: 剑指 Offer 28. 对称的二叉树
 * @seq: 28
 * @address: https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 * @idea:
 */
public class T28_250 {
	public boolean isSymmetric(TreeNode root) {

		return dfs(root,root);
	}
	public boolean dfs(TreeNode left,TreeNode right)
	{
		if(left==null&&right!=null) return false;
		if(left!=null&&right==null) return false;
		if(left==null&&right==null) return true;
		return (left.val==right.val)&&dfs(left.left,right.right)&&dfs(left.right,right.left);

	}
}
