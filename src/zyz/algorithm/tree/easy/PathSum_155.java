package zyz.algorithm.tree.easy;

import zyz.algorithm.utils.TreeNode;

/**
 * @author zyz
 * @title:  路径总和
 * @seq: 112
 * @address: https://leetcode-cn.com/problems/path-sum/
 * @idea:
 */
public class PathSum_155 {

	public boolean hasPathSum(TreeNode root, int targetSum) {

		if(root==null) return false;

		return dfs( root,  targetSum);


	}
	public boolean dfs(TreeNode root, int targetSum) {


		if(root.left!=null&&root.right!=null)
			return dfs(root.left,targetSum-root.val)|| dfs(root.right,targetSum-root.val);


		if(root.left!=null)
			return dfs(root.left,targetSum-root.val);

		if(root.right!=null)
			return  dfs(root.right,targetSum-root.val);

		if(root.left==null&&root.right==null) return targetSum-root.val==0?true:false;
		return false;
	}
}
