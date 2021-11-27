package zyz.algorithm.hot.hot100;

import zyz.algorithm.utils.TreeNode;

/**
 * @author zyz
 * @title: 合并二叉树
 * @seq: 617
 * @address: https://leetcode-cn.com/problems/merge-two-binary-trees/
 * @idea:
 */
public class MergeTwoBinaryTrees_222 {

	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		if(root1==null) return root2;
		if(root2==null) return root1;

		TreeNode node=new TreeNode(root1.val+root2.val);
		node.left=mergeTrees(root1.left,root2.left);
		node.right=mergeTrees(root1.right,root2.right);
		return node;
	}
	public TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
		if(root1==null&&root2==null) return null;
		TreeNode newNode=new TreeNode();
		if(root1!=null)
			newNode.val+=root1.val;
		if(root2!=null)
			newNode.val+=root2.val;
		if(root1!=null&&root2==null)
		{
			newNode.left=mergeTrees(root1.left,null);
			newNode.right=mergeTrees(root1.right,null);
		}else if(root1==null&&root2!=null)
		{
			newNode.left=mergeTrees(null,root2.left);
			newNode.right=mergeTrees(null,root2.right);
		}else{
			newNode.left=mergeTrees(root1.left,root2.left);
			newNode.right=mergeTrees(root1.right,root2.right);
		}
		return newNode;
	}
}
