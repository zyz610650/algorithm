package zyz.algorithm.hot.jzoffer;

import zyz.algorithm.utils.TreeNode;

/**
 * @author zyz
 * @title: 剑指 Offer 27. 二叉树的镜像
 * @seq: 27
 * @address: https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 * @idea:
 */
public class T27_249 {
	public TreeNode mirrorTree(TreeNode root) {
		return dfs(root);
	}
	public TreeNode dfs(TreeNode root)
	{
		if(root==null) return null;
		TreeNode node=new TreeNode(root.val);
		node.right=dfs(root.left);
		node.left=dfs(root.right);
		return node;
	}
}
