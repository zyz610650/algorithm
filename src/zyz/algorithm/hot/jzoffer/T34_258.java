package zyz.algorithm.hot.jzoffer;

import zyz.algorithm.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
/**
 * @author zyz
 * @title: 剑指 Offer 34. 二叉树中和为某一值的路径
 * @seq: 34
 * @address: https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/submissions/
 * @idea:
 */
public class T34_258 {

	List<List<Integer>> list=new ArrayList<>();
	public List<List<Integer>> pathSum(TreeNode root, int target) {

		list=new ArrayList<>();

		dfs(root,target,new ArrayList <> ());
		return list;
	}

	public void dfs(TreeNode root, int target, List <Integer> ans)
	{


		if(root==null) return;
		ans.add(root.val);
		if(target-root.val==0&&root.left==null&&root.right==null)
		{

			list.add(new ArrayList<>(ans));
			ans.remove(ans.size()-1);
			return;
		}

		dfs(root.left,target-root.val,ans);
		dfs(root.right,target-root.val,ans);
		ans.remove(ans.size()-1);
	}
}
