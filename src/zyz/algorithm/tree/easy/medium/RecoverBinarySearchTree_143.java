package zyz.algorithm.tree.easy.medium;

import zyz.algorithm.utils.TreeNode;

/**
 * @author: @zyz
 */
public class RecoverBinarySearchTree_143 {
	public static void main (String[] args) {
		if (1 > Integer.MAX_VALUE) {
			System.out.println ("2");
		}
	}


 // O(1)  莫里斯遍历
	public void recoverTree(TreeNode root)
	{
		if (root==null) return;
		TreeNode x=null;
		TreeNode y=null;
		TreeNode pre=null; //存取前驱
		TreeNode tmp=null;
		while (root!=null)
		{
			if (root.left!=null)
			{
				tmp=root.left;
				while (tmp.right!=null&&tmp.right!=root)
				{
					tmp=tmp.right;
				}
				if (tmp.right==null)
				{
					tmp.right=root;
					root=root.left;
				}else{
					// 处理tmp.right==root的情况
					if (pre!=null&&pre.val>root.val)
					{
						y=root;
						if (x==null)
						{
							x=pre;
						}

					}
					pre=root;
					root=root.right;
					tmp.right=null;

				}
			}else{
				// 处理left为Null的情况 即叶子节点的父节点
				//1 2 3 7 5 6 4
				// 在遍历过程中单独看7和5 他两个位置不对
				// 但题目中说了只有两个节点位置不对
				// 一定是只需要交换第一个和最后一个即可
//				所以有
//				if (x==null)
//				{
//					x=pre;
//				}
				if (pre!=null&&pre.val>root.val)
				{
					y=root;
					if (x==null)
					{
						x=pre;
					}
				}
				pre=root;
				root=root.right;
			}
		}
		if(x!=null && y!=null) {
			int t = x.val;
			x.val = y.val;
			y.val = t;
		}
	}

}
