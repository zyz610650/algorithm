package zyz.algorithm.tree.medium;

import zyz.algorithm.utils.TreeNode;

/**
 * @author zyz
 * @title:  从中序与后序遍历序列构造二叉树
 * @seq: 106
 * @address: https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * @idea:
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal_149 {

	public static void main (String[] args) {
		int[] inorder = {9,3,15,20,7}, postorder  = {9,15,7,20,3};
		System.out.println (buildTree(inorder,postorder));
	}

	public static TreeNode buildTree(int[] inorder, int[] postorder) {


		return postTravel(inorder,postorder,0,inorder.length-1,0,inorder.length-1);
	}

	public static TreeNode postTravel(int[] inorder,int[] postorder,int is,int ie,int ps,int pe)
	{
		System.out.println (is+" "+ie+" "+ps+" "+pe+" ");
		if(is>ie) return null;
		int it=0;
		for(it=is;it<=ie;it++)
		{
			if(postorder[pe]==inorder[it])
				break;
		}
		if(it>ie) return null;
		TreeNode left= postTravel(inorder,postorder,is,it-1,ps,ps+it-is-1);
		TreeNode right=postTravel(inorder,postorder,it+1,ie,ps+it-is,pe-1);
		TreeNode node=new TreeNode(inorder[it]);
		node.left=left;
		node.right=right;
		return node;
	}
}
