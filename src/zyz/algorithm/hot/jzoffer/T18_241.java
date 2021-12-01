package zyz.algorithm.hot.jzoffer;

import zyz.algorithm.utils.ListNode;

/**
 * @author zyz
 * @title: 剑指 Offer 18. 删除链表的节点
 * @seq: 18
 * @address: https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * @idea:
 */
public class T18_241 {

	public ListNode deleteNode(ListNode head, int val) {
		ListNode node=new ListNode();
		node.next=head;
		head=node;
		while(head.next!=null)
		{
			if(head.next.val==val)
			{
				head.next=head.next.next;
				return node.next;
			}
			head=head.next;
		}
		return null;
	}
}
