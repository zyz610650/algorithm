package zyz.algorithm.type.tree.medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zyz
 * @title: 填充每个节点的下一个右侧节点指针 II
 * @seq: 117
 * @address: https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 * @idea:
 */
public class PopulatingNextRightPointersinEachNode2_159 {

	public Node connect(Node root) {
		if(root==null) return root;
		Deque<Node> queue=new LinkedList<>();
		queue.addLast(root);
		int size;
		Node node;
		Node pre=null;
		while(!queue.isEmpty())
		{
			size=queue.size();
			for(int i=0;i<size;i++)
			{
				node=queue.pollFirst();
				if(pre!=null)
					pre.next=node;
				pre=node;
				if(node.left!=null)
					queue.addLast(node.left);
				if(node.right!=null)
					queue.addLast(node.right);
			}
			pre=null;
		}
		return root;
	}
}
