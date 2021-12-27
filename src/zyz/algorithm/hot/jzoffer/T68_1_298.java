package zyz.algorithm.hot.jzoffer;

import zyz.algorithm.utils.TreeNode;


/**
 * @author zyz
 * @title: 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 * @seq: 68
 * @address: https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * @idea:
 *  注意是二叉搜索树
 */
public class T68_1_298 {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while(root!=null)
		{
			if((root.val>p.val&&root.val>q.val))
			{
				root=root.left;
			}else if((root.val<p.val&&root.val<q.val))
			{
				root=root.right;
			}else return root;
		}
		return null;
	}
}
