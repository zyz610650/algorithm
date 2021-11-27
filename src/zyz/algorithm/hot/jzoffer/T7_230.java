package zyz.algorithm.hot.jzoffer;

import zyz.algorithm.utils.TreeNode;

/**
 * @author zyz
 * @title: 剑指 Offer 07. 重建二叉树
 * @seq: 7
 * @address: https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 * @idea:
 */
public class T7_230 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {

		return travel(preorder,inorder,0,preorder.length-1,0,inorder.length-1);

	}
	public TreeNode travel(int[] preorder,int[] inorder,int pl,int ph,int il,int ih)
	{
		if(pl>ph) return null;
		int mid=0;
		for(int i=il;i<=ih;i++)
		{
			if(preorder[pl]==inorder[i])
			{
				mid=i;
				break;
			}
		}
		TreeNode node=new TreeNode(preorder[pl]);
		int m=mid-il;
		node.left=travel(preorder,inorder,pl+1,pl+m,il,mid-1);
		node.right=travel(preorder,inorder,pl+m+1,ph,mid+1,ih);
		return node;
	}
}
