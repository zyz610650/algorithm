package zyz.algorithm.type.tree.easy;

import zyz.algorithm.utils.TreeNode;

/**
 * @author zyz
 * @title:  二叉树的最大深度
 * @seq: 104
 * @address: https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * @idea:
 */
public class MaximumDepthofBinaryTree_147 {

	public int maxDepth(TreeNode root) {
		if(root==null) return 0;
		int left =maxDepth(root.left);
		int right=maxDepth(root.right);
		return Math.max(left,right)+1;
	}
}
