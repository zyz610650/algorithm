package zyz.algorithm.hot.jzoffer;

import zyz.algorithm.utils.TreeNode;

/**
 * @author zyz
 * @title: 剑指 Offer 55 - I. 二叉树的深度
 * @seq: 55
 * @address: https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 * @idea:
 *
 */
public class T55_1_280 {

	public int maxDepth(TreeNode root) {

		if(root==null) return 0;

		return Math.max(maxDepth(root.left),maxDepth(root.right))+1;

	}
}
