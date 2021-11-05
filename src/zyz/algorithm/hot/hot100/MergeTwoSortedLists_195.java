package zyz.algorithm.hot.hot100;

import zyz.algorithm.utils.ListNode;

/**
 * @author zyz
 * @title: 合并两个有序链表
 * @seq: 21
 * @address: https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * @idea:
 */
public class MergeTwoSortedLists_195 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head=new ListNode(0);
		ListNode node=head;
		while(l1!=null&&l2!=null)
		{
			ListNode tmp;
			if(l1.val<l2.val)
			{
				tmp=l1;
				node.next=tmp;
				node=tmp;
				tmp=tmp.next;
				node.next=null;
				l1=tmp;
			}
			else {
				tmp=l2;
				node.next=tmp;
				node=tmp;
				tmp=tmp.next;
				node.next=null;
				l2=tmp;
			}

		}
		if(l1!=null)
		{
			node.next=l1;
		}else{
			node.next=l2;
		}
		return head.next;
	}

}
