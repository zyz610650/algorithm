package zyz.algorithm.tree.medium;

import zyz.algorithm.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyz
 * @title: 路径总和 II
 * @seq: 113
 * @address: https://leetcode-cn.com/problems/path-sum-ii/
 * @idea:
 */
public class PathSum2_156 {
	static List<List<Integer>> lists=new ArrayList<>();
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

		lists.clear();
		if(root==null) return lists;
		preOrder(root,targetSum,new ArrayList<>());
		return lists;

	}

	public static void preOrder(TreeNode root, int targetSum,List<Integer> list)
	{

		int left,right;
		list.add(root.val);
		if(root.left==null&&root.right==null)
		{
			if(targetSum-root.val==0)
			{
				lists.add(new ArrayList<>(list));
			}
		}
		if(root.left!=null)
		{
			preOrder(root.left,targetSum-root.val,list);

		}
		if(root.right!=null)
		{
			preOrder(root.right,targetSum-root.val,list);
		}
		list.remove(list.size()-1);
	}
}
