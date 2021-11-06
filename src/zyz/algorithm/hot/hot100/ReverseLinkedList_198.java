package zyz.algorithm.hot.hot100;

import zyz.algorithm.utils.ListNode;

/**
 * @author zyz
 * @title: 反转链表
 * @seq: 206
 * @address: https://leetcode-cn.com/problems/reverse-linked-list/
 * @idea:
 */
public class ReverseLinkedList_198 {

	public ListNode reverseList(ListNode head) {

		ListNode node=new ListNode();
		ListNode tmp;
		while(head!=null)
		{
			tmp=node.next;
			node.next=head;
			head=head.next;
			node.next.next=tmp;
		}
		return node.next;
	}
}
