package zyz.algorithm.type.tree.medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zyz
 * @title: 填充每个节点的下一个右侧节点指针
 * @seq: 116
 * @address: https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 * @idea:
 */
public class PopulatingNextRightPointersinEachNode_158 {

	public Node connect(Node root) {
		if(root==null) return root;
		Deque <Node> queue=new LinkedList <> ();
		queue.addLast(root);
		Node node=null;
		Node last=root;
		Node pre=null;
		while(!queue.isEmpty())
		{
			node=queue.pollFirst();
			if(pre==null)
				pre=node.right;
			else
			{
				pre.next=node.left;
				pre=node.right;
			}
			if(node.left!=null)
			{
				node.left.next=node.right;
				node.right.next=null;
			}else{
				break;
			}
			if(node==last)
			{
				last=node.right;
				pre=null;
			}
			if(node.left.left!=null)
			{
				queue.addLast(node.left);
				queue.addLast(node.right);
			}
		}
		return root;
	}
}

class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;

	public Node () {
	}

	public Node (int _val) {
		val = _val;
	}

	public Node (int _val , Node _left , Node _right , Node _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
}
//-1
//		0
//		1
//		2
//		3
//		4
//		5