package zyz.algorithm.type.tree.easy;

import zyz.algorithm.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 后序遍历
 * @author: @zyz
 */
public class BinaryTreePostorderTraversal_163 {
	static List <Integer> list=new ArrayList <> ();
	public List<Integer> postorderTraversal(TreeNode root) {
		list.clear();
		preOrder(root);
		return list;
	}

	public static void preOrder(TreeNode node)
	{
		if(node==null) return;

		preOrder(node.left);
		preOrder(node.right);
		list.add(node.val);
	}
}
