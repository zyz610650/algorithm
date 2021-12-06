package zyz.algorithm.hot.jzoffer;

import zyz.algorithm.utils.TreeNode;

import java.util.*;

/**
 * @author zyz
 * @title: 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * @seq: 32
 * @address: https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 * @idea:
 */
public class T33_3_256 {
	public List< List <Integer> > levelOrder(TreeNode root) {
		List<List<Integer>> list=new ArrayList <> ();

		if(root==null) return list;
		int size=0;
		TreeNode node;
		Queue <TreeNode> queue=new LinkedList <> ();
		boolean flag=false;
		queue.add(root);
		List<Integer> ans=new ArrayList<>();
		ans.add(root.val);
		while(!queue.isEmpty())
		{
			size=queue.size();
			List<Integer> res=new ArrayList<>();
			if(flag)
			{
				for(int i=ans.size()-1;i>=0;i--)
					res.add(ans.get(i));
			}else{
				for(int i=0;i<ans.size();i++)
					res.add(ans.get(i));
			}
			list.add(res);
			flag=!flag;

			ans=new ArrayList<>();
			for(int i=0;i<size;i++)
			{
				node=queue.poll();
				if(node.left!=null)
				{
					ans.add(node.left.val);
					queue.add(node.left);
				}
				if(node.right!=null)
				{
					ans.add(node.right.val);
					queue.add(node.right);
				}
			}

		}
		return list;
	}
}
