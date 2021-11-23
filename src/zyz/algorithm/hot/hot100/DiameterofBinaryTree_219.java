package zyz.algorithm.hot.hot100;

import zyz.algorithm.utils.TreeNode;

/**
 * @author zyz
 * @title: 二叉树的直径
 * @seq: 543
 * @address: https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * @idea:
 *
 */
public class DiameterofBinaryTree_219 {

	int ans=0;
	public int diameterOfBinaryTree(TreeNode root) {

		dfs(root);
		return ans;
	}
	public int dfs(TreeNode root)
	{
		if(root==null) return 0;
		int l=dfs(root.left);
		int r=dfs(root.right);
		int res=l+r;
		ans=Math.max(ans,res);
		return Math.max(l,r)+1;
	}
}
