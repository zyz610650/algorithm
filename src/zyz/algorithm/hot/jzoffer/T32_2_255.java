package zyz.algorithm.hot.jzoffer;

import zyz.algorithm.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zyz
 * @title: 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * @seq: 32
 * @address: https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 * @idea:
 */
public class T32_2_255 {

	public List< List <Integer> > levelOrder(TreeNode root) {
		List<List<Integer>> list=new ArrayList <> ();
		if(root==null) return list;
		int size=1;
		Queue <TreeNode> queue=new LinkedList <> ();
		queue.add(root);
		TreeNode node;
		while(!queue.isEmpty())
		{
			size=queue.size();
			List<Integer> ans=new ArrayList<>();
			for(int i=0;i<size;i++)
			{
				node=queue.poll();
				ans.add(node.val);
				if(node.left!=null) queue.add(node.left);
				if(node.right!=null) queue.add(node.right);
			}
			list.add(ans);
		}
		return list;
	}
}
