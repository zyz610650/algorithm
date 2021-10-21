package zyz.algorithm.tree.medium;

import zyz.algorithm.utils.TreeNode;

/**
 * @author zyz
 * @title: 翻转二叉树
 * @seq: 226
 * @address: https://leetcode-cn.com/problems/invert-binary-tree/
 * @idea:
 *
 */
public class InvertBinaryTree_167 {
	public TreeNode invertTree(TreeNode root) {

		if(root==null) return null;
		TreeNode tmp=root.right;
		root.right=invertTree(root.left);
		root.left=invertTree(tmp);
		return root;
	}
}
