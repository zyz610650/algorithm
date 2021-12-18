package zyz.algorithm.hot.jzoffer;

import zyz.algorithm.utils.TreeNode;

/**
 * @author zyz
 * @title: 剑指 Offer 55 - II. 平衡二叉树
 * @seq: 55_2
 * @address: https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 * @idea:
 *
 */
public class T55_2_281 {

	public static void main (String[] args) {


	}
	boolean flag=true;
	public boolean isBalanced(TreeNode root) {
		flag=true;
		dfs(root);
		return flag;
	}

	public int dfs(TreeNode root)
	{
		if(root==null) return 0;
		int left=dfs(root.left);
		int right=dfs(root.right);
		if(Math.abs(left-right)>1)
		{
			flag=false;
			return 0;
		}
		return Math.max(left,right)+1;
	}
}
