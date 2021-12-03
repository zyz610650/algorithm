package zyz.algorithm.hot.jzoffer;

import zyz.algorithm.utils.ListNode;

/**
 * @author zyz
 * @title: 剑指 Offer 22. 链表中倒数第k个节点
 * @seq: 22
 * @address: https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * @idea:
 */
public class T22_245 {

	public ListNode getKthFromEnd(ListNode head, int k) {
		ListNode node=head;
		while(k>0)
		{
			node=node.next;
			k--;
		}
		while(node!=null)
		{
			head=head.next;
			node=node.next;
		}
		return head;
	}
}
