package zyz.algorithm.type.tree.easy;

import zyz.algorithm.utils.TreeNode;

/**
 * @author zyz
 * @title:  二叉树的最小深度
 * @seq: 111
 * @address: https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * @idea:
 */
public class MinimumDepthofBinaryTree_154 {
	public int minDepth(TreeNode root) {
		if(root==null) return 0;

		if(root.left!=null&&root.right!=null)
			return Math.min(minDepth (root.left),minDepth (root.right))+1;
		if(root.left!=null) return minDepth(root.left)+1;
		if(root.right!=null) return minDepth(root.right)+1;
		return 1;
	}
}
