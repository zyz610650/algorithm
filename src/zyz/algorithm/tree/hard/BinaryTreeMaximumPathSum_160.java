package zyz.algorithm.tree.hard;

import zyz.algorithm.utils.TreeNode;

/**
 * @author zyz
 * @title: 二叉树中的最大路径和
 * @seq: 124
 * @address: https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * @idea:
 * 之前自己的写法没有考虑清除结点移动路径
 * 四种情况
 * 1>左节点->父节点->右节点
 * 2>右节点->父节点->左节点
 * 3> 左节点->父节点->父节点-> 左/右/父....
 * 4> 右节点->父节点->父节点-> 左/右/父....
 */
public class BinaryTreeMaximumPathSum_160 {
	static int allMax=Integer.MIN_VALUE;;
	public int maxPathSum(TreeNode root) {

		allMax=Integer.MIN_VALUE;

		inOrder(root);

		return allMax;
	}

	public static int  inOrder(TreeNode node)
	{

		if(node==null) return 0;
		int left= Math.max (inOrder(node.left),0);
		int right=Math.max (inOrder(node.right),0);
		int max=node.val;
		max+=(left+right);
		//计算前两种情况
		allMax=Math.max(allMax,max);

		//核心 计算后两种情况
		return node.val+ Math.max (left,right);
	}
}
