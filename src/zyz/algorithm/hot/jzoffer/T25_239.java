package zyz.algorithm.hot.jzoffer;

import zyz.algorithm.utils.ListNode;

/**
 * @author zyz
 * @title: 剑指 Offer 25. 合并两个排序的链表
 * @seq: 16
 * @address: https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/submissions/
 * @idea:
 */
public class T25_239 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head=new ListNode();
		ListNode node=head;
		while(l1!=null&&l2!=null)
		{

			if(l1.val<l2.val)
			{
				node.next=l1;
				l1=l1.next;
			}
			else{
				node.next=l2;
				l2=l2.next;
			}
			node=node.next;

		}
		if(l1!=null) node.next=l1;
		if(l2!=null) node.next=l2;
		return head.next;
	}
}
