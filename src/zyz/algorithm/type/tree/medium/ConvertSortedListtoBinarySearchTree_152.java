package zyz.algorithm.type.tree.medium;


import lombok.extern.slf4j.Slf4j;
import zyz.algorithm.utils.ListNode;
import zyz.algorithm.utils.TreeNode;

/**
 * @author zyz
 * @title: 有序链表转换二叉搜索树
 * @seq: 109
 * @address: https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 * @idea:
 *   快慢指针
 */
@Slf4j
public class ConvertSortedListtoBinarySearchTree_152 {

	public TreeNode sortedListToBST(ListNode head) {

		int n=0;
		ListNode node=head;
		while(node!=null)
		{
			node=node.next;
			n++;
		}
		return preOrderTravel(head,n);
	}

	public TreeNode preOrderTravel(ListNode node,int n)
	{
		if(n<1) return null;
		if(node==null) return null;
		ListNode start=node;
		int i=0;
		int mid=(n)/2;
		while(i<mid)
		{
			node=node.next;
			i++;
		}

		// System.out.println (n+" "+mid+" "+String.valueOf (n-mid-1));
		TreeNode root=new TreeNode(node.val);

		root.left=preOrderTravel( start, mid);
		root.right=preOrderTravel( node.next, n-mid-1);
		return root;

	}
}
