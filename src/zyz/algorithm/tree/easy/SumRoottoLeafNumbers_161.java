package zyz.algorithm.tree.easy;

import zyz.algorithm.utils.TreeNode;

/**
 * @author zyz
 * @title: 求根节点到叶节点数字之和
 * @seq: 129
 * @address: https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 * @idea:
 */
public class SumRoottoLeafNumbers_161 {
	static int ans=0;

	// 改进 用int替换String
	public int sumNumbers(TreeNode root) {

		ans=0;
		preOrder(root,0);

		return ans;
	}

	public static void preOrder(TreeNode root,int n)
	{
		if(root==null) return;
		n=n*10+root.val;
		if(root.left==null&&root.right==null)
		{
			ans+=n;
			return;
		}
		preOrder(root.left, n);
		preOrder(root.right, n);

	}
	public int sumNumbers1(TreeNode root) {
		String str="";
		ans=0;
		preOrder1(root,str);

		return ans;
	}

	public static void preOrder1(TreeNode root,String str)
	{
		if(root==null) return;
		str+=root.val;
		if(root.left==null&&root.right==null)
		{
			ans+=Integer.valueOf(str);
			return;
		}
		preOrder1(root.left,str);
		preOrder1(root.right,str);

	}
}
