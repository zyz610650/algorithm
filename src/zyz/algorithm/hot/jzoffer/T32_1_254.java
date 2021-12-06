package zyz.algorithm.hot.jzoffer;

import zyz.algorithm.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zyz
 * @title: 剑指 Offer 32 - I. 从上到下打印二叉树 I
 * @seq: 32
 * @address: https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 * @idea:
 */
public class T32_1_254 {

	public int[] levelOrder(TreeNode root) {
		if(root==null) return new int[0];
		List <Integer> list=new ArrayList <> ();
		Queue <TreeNode> queue=new LinkedList <> ();
		queue.add(root);
		TreeNode node;
		while(!queue.isEmpty())
		{
			node=queue.poll();
			list.add(node.val);
			if(node.left!=null) queue.add(node.left);
			if(node.right!=null) queue.add(node.right);
		}

		return list.stream ().mapToInt (Integer::intValue).toArray ();
	}


}
