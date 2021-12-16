package zyz.algorithm.hot.jzoffer;

import zyz.algorithm.utils.ListNode;

/**
 * @author zyz
 * @title: 剑指 Offer 51. 数组中的逆序对
 * @seq: 51
 * @address: https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
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
