package zyz.algorithm.type.tree.medium;

import zyz.algorithm.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: @zyz
 */
public class BinarySearchTreeIterator_164 {


}
class BSTIterator {


	static List <Integer> list=new ArrayList <> ();
	static int index=0;
	public BSTIterator(TreeNode root) {


		inOrder(root);
	}

	public int next() {
		return list.get(index++);
	}

	public boolean hasNext() {

		if(index<list.size()) return true;
		else return false;
	}

	static void inOrder(TreeNode node)
	{
		if(node==null) return;
		inOrder(node.left);
		list.add(node.val);
		inOrder(node.right);
	}
}

