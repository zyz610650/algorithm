package zyz.algorithm.tree;

import zyz.algorithm.utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 树遍历的非递归版本
 * @author: @zyz
 */
public class InOrderTraversal {

	/**
	 * 非递归中序遍历
	 * @param root
	 */
	public  void inOrder(TreeNode root)
	{
		Deque<TreeNode> stack=new LinkedList <> ();
		TreeNode node;
		while (!stack.isEmpty ()&&root!=null)
		{
			while (root!=null)
			{
				stack.push (root);
				root=root.left;
			}
			root=stack.pop();
			System.out.println (root.val);
			root=root.right;
		}
	}

	/**
	 * 非递归先序遍历 利用栈
	 * @param root
	 */
	public  void preOrder(TreeNode root)
	{
		Deque<TreeNode> stack=new LinkedList <> ();
		stack.push (root);
		TreeNode node;
		while(!stack.isEmpty()) {//思路：根据前序遍历（根左右）特点，优先遍历根节点，再而处理左右节点，通过循环就可以实现前序遍历
			node = stack.pop ();
			System.out.print (node.val + " ");
			if (node.right != null) {
				stack.push (node.right);
			}
			if (node.left != null) {
				stack.push (node.left);
			}
		}
	}
}
