package zyz.algorithm.tree.medium;

import zyz.algorithm.utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zyz
 * @title: 二叉树的层序遍历 II
 * @seq: 107
 * @address: https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * @idea:

 */
public class BinaryTreeLevelOrderTraversal2_150 {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> lists=new ArrayList<>();
		if(root==null) return  lists;
		Deque < TreeNode > queue=new LinkedList <> ();
		queue.addLast(root);
		int size;
		TreeNode tmp=root;
		List <Integer> list;
		while(!queue.isEmpty())
		{
			size=queue.size();
			list=new ArrayList <> ();
			for(int i=0;i<size;i++)
			{
				tmp=queue.pollFirst();
				if(tmp.left!=null) queue.addLast(tmp.left);
				if(tmp.right!=null) queue.addLast(tmp.right);
				list.add(tmp.val);
			}
			lists.add(list);
		}

		List<List<Integer>> list1=new ArrayList<>();
		for(int i=lists.size()-1;i>=0;i--)
		{
			list1.add(lists.get(i));
		}
		return list1;
	}
}
