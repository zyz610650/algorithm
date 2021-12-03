package zyz.algorithm.hot.jzoffer;

import zyz.algorithm.utils.ListNode;

/**
 * @author zyz
 * @title: 剑指 Offer 24. 反转链表
 * @seq: 24
 * @address: https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * @idea:
 */
public class T24_246 {
	public ListNode reverseList(ListNode head) {
		if(head==null) return null;
		ListNode Nhead=head;
		head=head.next;
		Nhead.next=null;
		ListNode node;
		while(head!=null)
		{
			node=head.next;
			head.next=Nhead;
			Nhead=head;
			head=node;
		}
		return Nhead;
	}
}
