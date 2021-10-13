package zyz.algorithm.tree.easy;


import java.util.ArrayList;
import java.util.List;

/**
 * @author zyz
 * @title: 二叉树的中序遍历
 * @seq: 94
 * @address: https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * @idea:
 */
public class BinaryTreeInorderTraversal_141 {

	static List <Integer> list=new ArrayList <> ();
	public List<Integer> inorderTraversal(TreeNode1 root) {
		list.clear();
		dfs(root);
		return list;
	}

	static void dfs(TreeNode1 node)
	{
		if(node==null) return;
		dfs(node.left);
		list.add(node.val);
		dfs(node.right);
	}
}
class  TreeNode1{
	int val;
	TreeNode1 left;
	TreeNode1 right;

	public TreeNode1 (int val , TreeNode1 left , TreeNode1 right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public TreeNode1 (int val) {
		this.val = val;
	}

	TreeNode1(){};
}
