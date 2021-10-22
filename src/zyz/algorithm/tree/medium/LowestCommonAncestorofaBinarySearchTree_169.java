package zyz.algorithm.tree.medium;

import zyz.algorithm.utils.TreeNode;

/**
 * @author zyz
 * @title: 二叉搜索树的最近公共祖先
 * @seq: 235
 * @address: https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * @idea:
 */
public class LowestCommonAncestorofaBinarySearchTree_169 {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while(root!=null)
		{
			if(root.val<p.val&&root.val<q.val)
			{
				root=root.right;
			}else if (root.val>p.val&&root.val>q.val)
			{
				root=root.left;
			}else{
				break;
		}
		}
		return root;
	}
}
