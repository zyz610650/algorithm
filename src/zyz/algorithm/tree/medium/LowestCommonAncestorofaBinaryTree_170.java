package zyz.algorithm.tree.medium;

import zyz.algorithm.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyz
 * @title: 二叉树的最近公共祖先
 * @seq: 236
 * @address: https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * @idea:
 */
public class LowestCommonAncestorofaBinaryTree_170 {


	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (root==null) return null;
		if (root==p||root==q) return root;
		TreeNode lf=null,rf=null;
		lf=lowestCommonAncestor (root.left,p,q);
		rf=lowestCommonAncestor (root.right,p,q);
		if (lf!=null&&rf!=null)
		{
			return root;
		}else if (lf!=null) return lf;
		else if (rf!=null) return rf;
		return null;

	}

	public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
		List <TreeNode> list1=new ArrayList <> ();
		List <TreeNode> list2=new ArrayList <> ();

		postOrder(root,p,list1);
		postOrder(root,q,list2);

		TreeNode node=null;
		for (int i=list1.size ()-1,j=list2.size ()-1;i>=0&&j>=0;i--,j--)
		{
			if (list1.get (i)==list2.get (j))  node=list1.get (i);
		}
		return node;
	}
	public static boolean postOrder(TreeNode root,TreeNode node,List<TreeNode> list)
	{
		if (root==null) return false;
		if (root==node)
		{
			list.add (root);
			return true;
		}
		boolean flag=false;
		flag=postOrder (root.left,node,list);
		if (flag)
		{
			list.add (root);
			return true;
		}
		flag=postOrder (root.right,node,list);
		if (flag)
		{
			list.add (root);
			return true;
		}
		return false;
	}
}
