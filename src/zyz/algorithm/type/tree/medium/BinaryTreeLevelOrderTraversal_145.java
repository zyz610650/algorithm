package zyz.algorithm.type.tree.medium;

import zyz.algorithm.utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zyz
 * @title: 二叉树的层序遍历
 * @seq: 102
 * @address: https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * @idea:
 *  自己写的太罗嗦了 官方题解的思路很值得学习
 */
public class BinaryTreeLevelOrderTraversal_145 {
	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> lists=new ArrayList<>();
		if(root==null) return lists;
		Deque <TreeNode> queue=new LinkedList <> ();
		queue.addLast(root);

		TreeNode tmp=null;
		TreeNode pre=root;
		List <TreeNode> list=new ArrayList <> ();
		while(!queue.isEmpty())
		{
			tmp=queue.pollFirst();
			list.add(tmp);
			if(tmp==pre)
			{
				for(int i=list.size()-1;i>=0;i--)
				{
					TreeNode t=list.get(i);
					if(t.right!=null)
					{
						pre=t.right;
						break;
					}
					if(t.left!=null)
					{
						pre=t.left;
						break;
					}
				}
				List <Integer> tmpList=new ArrayList <> ();
				for(int i=0;i<list.size ();i++)
				{
					tmpList.add (list.get (i).val);
				}
				lists.add(tmpList);
				list=new ArrayList<>();

			}
			if(tmp.left!=null) queue.addLast(tmp.left);
			if(tmp.right!=null) { queue.addLast(tmp.right); }
		}
		return lists;
	}
}
