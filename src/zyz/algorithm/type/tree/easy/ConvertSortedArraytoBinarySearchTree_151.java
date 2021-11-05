package zyz.algorithm.type.tree.easy;

import zyz.algorithm.utils.TreeNode;

/**
 * @author zyz
 * @title: 将有序数组转换为二叉搜索树
 * @seq: 108
 * @address: https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * @idea:
 */
public class ConvertSortedArraytoBinarySearchTree_151 {

	public TreeNode sortedArrayToBST(int[] nums) {

		return preOrderTravel(nums,0,nums.length-1);
	}
	public TreeNode preOrderTravel(int[] nums,int s,int e)
	{
		if(s>e) return null;
		int t=(s+e)/2;
		TreeNode node=new TreeNode(nums[t]);
		node.left=preOrderTravel(nums,s,t-1);
		node.right=preOrderTravel(nums,t+1,e);
		return node;
	}
}
