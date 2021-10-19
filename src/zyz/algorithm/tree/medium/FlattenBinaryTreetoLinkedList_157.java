package zyz.algorithm.tree.medium;

import zyz.algorithm.utils.TreeNode;

/**
 * @author zyz
 * @title: 二叉树展开为链表
 * @seq: 114
 * @address: https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * @idea:
 *
 */
public class FlattenBinaryTreetoLinkedList_157 {

	public void flatten(TreeNode root) {
		if(root==null) return ;

		flatten(root.left);
		flatten(root.right);
		if(root.left!=null)
		{
			TreeNode right=root.left;
			while(right.right!=null) right=right.right;
			right.right=root.right;
			root.right=root.left;
			root.left=null;
		}
		return ;
	}
}
