package zyz.algorithm.tree.easy.medium;


import zyz.algorithm.utils.TreeNode;

/**
 * @author zyz
 * @title: 验证二叉搜索树
 * @seq: 98
 * @address: https://leetcode-cn.com/problems/validate-binary-search-tree/
 * @idea:
 *  注意: 不能单纯的比较左节点小于中间节点，右节点大于中间节点就完事了。
 *  我们要比较的是 左子树所有节点小于中间节点，右子树所有节点大于中间节点。
 */
public class ValidateBinarySearchTree_142 {

	public boolean isValidBST(TreeNode root) {

		return preOrderTravel(root,Long.MIN_VALUE,Long.MAX_VALUE);
	}

	static boolean  preOrderTravel(TreeNode node,long  min,long  max)
	{
		if(node==null) return true;

		if(node.val<=min||node.val>=max) return false;

		return preOrderTravel(node.left,min,node.val)&&preOrderTravel(node.right,node.val,max);

	}


}
