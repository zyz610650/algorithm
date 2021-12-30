package zyz.algorithm.hot.txtop50;

import zyz.algorithm.utils.ListNode;

/**
 * @author zyz
 * @title: 237. 删除链表中的节点
 * @seq: 237
 * @address: https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * @idea:
 */
public class T237_307 {

	public void deleteNode(ListNode node) {
		while(node.next.next!=null)
		{
			node.val=node.next.val;
			node=node.next;
		}
		node.val=node.next.val;
		node.next=null;
	}
}
