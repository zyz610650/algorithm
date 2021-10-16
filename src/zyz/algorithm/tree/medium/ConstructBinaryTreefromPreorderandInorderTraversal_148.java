package zyz.algorithm.tree.medium;

import zyz.algorithm.utils.TreeNode;

/**
 * @author zyz
 * @title: 从前序与中序遍历序列构造二叉树
 * @seq: 105
 * @address: https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @idea:
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal_148 {

	public static void main (String[] args) {
		int[] preorder = {3,9,20,15,7}, inorder = {9,3,15,20,7};
		System.out.println (buildTree(preorder,inorder));
	}
	public static TreeNode buildTree(int[] preorder, int[] inorder) {

		return postTravel(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
	}

	public static TreeNode postTravel (int[] preorder,int[] inorder,int ps,int pe,int is,int ie)
	{
		if (ps>pe) return null;
		System.out.println (ps+" "+pe+" "+is+" "+ie);
		int it=0;
		for( it=is;it<=ie;it++)
		{
			if(inorder[it]==preorder[ps])
			{
				break;
			}
		}
		if(it>ie) return null;
		int leftnum=it-is;
		int rightnum=ie-it;
		TreeNode left=postTravel(preorder,inorder,ps+1,ps+leftnum,is,it-1);
		TreeNode right=postTravel(preorder,inorder,ps+leftnum+1,pe,it+1,ie);
		TreeNode node=new TreeNode(inorder[it]);
		node.left=left;
		node.right=right;
		return node;
	}
}
