package zyz.algorithm.type.tree.easy;

import zyz.algorithm.utils.TreeNode;

/**
 * @author: @zyz
 */
public class BalancedBinaryTree_153 {
	static boolean flag=true;
	public boolean isBalanced(TreeNode root) {
		flag=true;
		if(root==null) return true;
		int left=postOrder(root.left);
		int right=postOrder(root.right);
		if(flag==false) return false;
		if(Math.abs(right-left)>1) return false;
		else return true;
	}

	public static int postOrder(TreeNode node)
	{

		if(node==null) return 0;
		int left=postOrder(node.left);
		if(flag==false) return left;
		int right=postOrder(node.right);
		if(Math.abs(right-left)>1)
		{
			flag=false;
		}
		return Math.max(left,right)+1;
	}

	//官方写法 思想一致
	public boolean isBalanced1(TreeNode root) {
		return balanced(root) != -1;
	}

	private int balanced(TreeNode node) {
		if (node == null) return 0;
		int leftHeight, rightHeight;
		if ((leftHeight = balanced(node.left)) == -1
				|| (rightHeight = balanced(node.right)) == -1
				|| Math.abs(leftHeight - rightHeight) > 1)
			return -1;
		return Math.max(leftHeight, rightHeight) + 1;
	}
}
