package zyz.algorithm.type.tree.medium;

import zyz.algorithm.utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zyz
 * @title: 二叉树的锯齿形层序遍历
 * @seq: 103
 * @address: https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 * @idea:
 */
public class BinaryTreeZigzagLevelOrderTraversal_146 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		List<List<Integer>>lists=new ArrayList<>();
		if(root==null) return lists;
		Deque<TreeNode> queue=new LinkedList<>();
		queue.add(root);
		List<Integer> list=new ArrayList<>();
		list.add(root.val);
		lists.add(list);
		boolean flag=false;
		TreeNode tmp;
		while(!queue.isEmpty())
		{
			int size=list.size();
			list=new ArrayList<>();
			for(int i=0;i<size;i++)
			{
				tmp=queue.pollFirst();
				if(tmp.left!=null)
				{
					queue.addLast(tmp.left);
					list.add(tmp.left.val);
				}
				if(tmp.right!=null)
				{
					queue.addLast(tmp.right);
					list.add(tmp.right.val);
				}
			}
			if(list.isEmpty()) break;
			if(!flag)
			{
				List<Integer> tmpList=new ArrayList<>();
				for(int i=list.size()-1;i>=0;i--)
				{
					tmpList.add(list.get(i));
				}
				lists.add(tmpList);
			}else{
				lists.add(list);
			}

			flag=!flag;

		}
		return lists;
	}
}
