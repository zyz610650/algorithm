package zyz.algorithm.hot.jzoffer;

import zyz.algorithm.utils.TreeNode;

/**
 * @author zyz
 * @title: 剑指 Offer 26. 树的子结构
 * @seq: 26
 * @address: https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 * @idea:
 */
public class T26_248 {
	public boolean isSubStructure(TreeNode A, TreeNode B) {

		if(A==null) return false;
		if(B==null) return false;
		return dfs(A,B);

	}

	public boolean dfs(TreeNode A,TreeNode B)
	{
		if(A==null&&B!=null) return false;
		if(A!=null&&B==null) return true;
		if(A==null&&B==null) return true;
		if(A.val==B.val)
		{
			boolean f1=dfs2(A.left,B.left);
			boolean f2=dfs2(A.right,B.right);
			if(f1&&f2) return true;
		}
		boolean fl1=dfs(A.left,B);
		if(fl1) return true;
		boolean fl2=dfs(A.right,B);
		return fl2;
	}
	public boolean dfs2(TreeNode A,TreeNode B)
	{
		if(A==null&&B!=null) return false;
		if(A!=null&&B==null) return true;
		if(A==null&&B==null) return true;
		if(A.val!=B.val) return false;
		boolean f1=dfs2(A.left,B.left);
		boolean f2=dfs2(A.right,B.right);
		return f1&&f2;

	}
}
