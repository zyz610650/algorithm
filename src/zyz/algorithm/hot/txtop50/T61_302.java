package zyz.algorithm.hot.txtop50;

import zyz.algorithm.utils.ListNode;

/**
 * @author zyz
 * @title: 61. 旋转链表
 * @seq: 61
 * @address: https://leetcode-cn.com/problems/rotate-list/
 * @idea:
 */
public class T61_302 {

	public ListNode rotateRight(ListNode head, int k) {
		if(head==null||k==0) return head;
		ListNode node=head;
		int len=0;
		while(node!=null)
		{
			node=node.next;
			len++;
		}
		node=head;
		k=k%len;
		if(k==0||len==1||k==len) return head;
		k=len-k-1;

		ListNode tmp=null;
		while(k>0)
		{
			node=node.next;
			k--;
		}
		tmp=node.next;
		node.next=null;
		node=tmp;
		while(node.next!=null) node=node.next;
		node.next=head;
		return tmp;
	}
}
