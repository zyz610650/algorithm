package zyz.algorithm.tree.medium;

import zyz.algorithm.utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zyz
 * @title: 二叉树的右视图
 * @seq: 199
 * @address: https://leetcode-cn.com/problems/binary-tree-right-side-view/
 * @idea:

 */
public class BinaryTreeRightSideView_165 {
	public List <Integer> rightSideView(TreeNode root) {
		List<Integer> list=new ArrayList <> ();
		if(root==null) return list;
		Deque <TreeNode> queue=new LinkedList <> ();
		queue.addLast(root);
		TreeNode node=null;
		int size=0;
		while(!queue.isEmpty())
		{
			size=queue.size();
			for(int i=0;i<size;i++)
			{
				node=queue.pollFirst();
				if(node.left!=null) queue.addLast(node.left);
				if(node.right!=null) queue.addLast(node.right);
			}
			list.add(node.val);

		}


		return list;
	}

}
