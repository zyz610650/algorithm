package zyz.algorithm.hot.hot100;

import zyz.algorithm.utils.TreeNode;

/**
 * @author zyz
 * @title: 把二叉搜索树转换为累加树
 * @seq: 538
 * @address: https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 * @idea:
 */
public class ConvertBSTtoGreaterTree_218 {

	public TreeNode convertBST(TreeNode root) {

		if(root==null)  return null;

		root.val+=dfs(root.right,0);
		dfs(root.left,root.val);
		return root;

	}
	public int dfs(TreeNode root,int n)
	{
		if(root==null)  return n;

		root.val=dfs(root.right,n)+ root.val;
		return dfs(root.left,root.val);
	}
}
