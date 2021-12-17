package zyz.algorithm.hot.jzoffer;

import zyz.algorithm.utils.TreeNode;

/**
 * @author zyz
 * @title: 剑指 Offer 54. 二叉搜索树的第k大节点
 * @seq: 54
 * @address: https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/solution/mian-shi-ti-54-er-cha-sou-suo-shu-de-di-k-da-jie-d/
 * @idea:
 *
 */
public class T54_279 {

	int cnt=0;
	int n=0;
	public int kthLargest(TreeNode root, int k) {
		cnt=0;
		dfs(root,k);
		return n;
	}
	public void dfs(TreeNode root,int k)
	{
		if(root==null) return;
		dfs(root.right,k);
		cnt++;
		if(cnt==k)
		{
			n=root.val;
			return;
		}
		dfs(root.left,k);
	}
}
