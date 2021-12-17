package zyz.algorithm.hot.jzoffer;

import zyz.algorithm.utils.ListNode;

/**
 * @author zyz
 * @title: 剑指 Offer 52. 两个链表的第一个公共节点
 * @seq: 52
 * @address: https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 * @idea:
 *
 */
public class T52_276 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int la=0,lb=0;
		ListNode nodeA=headA,nodeB=headB;
		while(nodeA!=null)
		{
			la++;
			nodeA=nodeA.next;
		}
		while(nodeB!=null)
		{
			lb++;
			nodeB=nodeB.next;
		}
		while(la>lb)
		{
			headA=headA.next;
			la--;
		}
		while(lb>la)
		{
			lb--;
			headB=headB.next;
		}
		while(headA!=headB)
		{
			headA=headA.next;
			headB=headB.next;
		}
		return headA;

	}
}
