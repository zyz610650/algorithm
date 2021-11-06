package zyz.algorithm.hot.hot100;

import zyz.algorithm.utils.ListNode;

/**
 * @author zyz
 * @title: 排序链表
 * @seq: 148
 * @address: https://leetcode-cn.com/problems/sort-list/
 * @idea:
 */
public class SortList_197 {

	public ListNode sortList(ListNode head) {

		return sort(head,null);
	}
	public ListNode sort(ListNode left, ListNode right)
	{
		if(left==right) return left;
		ListNode node1=left;
		ListNode node2=right;
		while(node2!=right)
		{
			if(node2.next==right)
			{
				node2=node2.next;
				break;
			}
			node1=node1.next;
		}
		ListNode mid= node1.next;
		node1.next=null;
		left=sort(left,node1);
		right=sort(mid,right);
		return merge(left,right);
	}

	public ListNode merge(ListNode left,ListNode right)
	{
		ListNode head=new ListNode();
		ListNode node=head;
		while(left!=null&&right!=null)
		{
			if(left.val<=right.val)
			{
				node.next=left;
				left=left.next;
			}else{
				node.next=right;
				right=right.next;
			}
			node=node.next;
		}
		if(left!=null)  node.next=left;
		if(right!=null) node.next=right;
		return head.next;
	}
}
