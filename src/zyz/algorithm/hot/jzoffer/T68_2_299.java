package zyz.algorithm.hot.jzoffer;

import zyz.algorithm.utils.TreeNode;

/**
 * @author zyz
 * @title: 剑指 Offer 68 - II. 二叉树的最近公共祖先
 * @seq: 68_2
 * @address: https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * @idea:
 *  注意是普通树
 */
public class T68_2_299 {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null || root==p ||root==q) return root;
		TreeNode left=lowestCommonAncestor(root.left,p,q);
		TreeNode right=lowestCommonAncestor(root.right,p,q);
		if(left==null) return right;
		if(right==null) return left;
		return root;
	}
}
