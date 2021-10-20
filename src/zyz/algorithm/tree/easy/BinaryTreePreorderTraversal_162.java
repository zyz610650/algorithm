package zyz.algorithm.tree.easy;

import zyz.algorithm.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 先序
 * @author: @zyz
 */
public class BinaryTreePreorderTraversal_162 {

	static List <Integer> list=new ArrayList <> ();
	public List<Integer> preorderTraversal(TreeNode root) {
		list.clear();
		preOrder(root);
		return list;
	}

	public static void preOrder(TreeNode node)
	{
		if(node==null) return;
		list.add(node.val);
		preOrder(node.left);
		preOrder(node.right);
	}
}
