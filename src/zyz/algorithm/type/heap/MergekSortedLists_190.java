package zyz.algorithm.type.heap;

import zyz.algorithm.utils.ListNode;

import java.util.*;

/**
 * @author zyz
 * @title: 合并K个升序链表
 * @seq: 23
 * @address: https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * @idea:
 */
public class MergekSortedLists_190 {

	public ListNode mergeKLists1(ListNode[] lists) {
		if(lists.length==0) return null;
		ListNode head=new ListNode();

		ListNode node=head;
		int n=0;
		while(n!=lists.length)
		{
			int tmp=Integer.MAX_VALUE;
			int index=-1;
			for(int i=0;i<lists.length;i++)
			{
				if(lists[i]!=null&&lists[i].val<tmp)
				{
					index=i;
					tmp=lists[i].val;
				}
			}
			if(index==-1) break;
			node.next=lists[index];
			node=node.next;
			lists[index]=lists[index].next;
			if(lists[index]==null) n++;
		}
		return head.next;

	}

	public ListNode mergeKLists(ListNode[] lists) {
		// 用堆也行
//		PriorityQueue<ListNode> priorityQueue=new PriorityQueue <> (new Comparator < ListNode > () {
//			@Override
//			public int compare (ListNode o1 , ListNode o2) {
//				return 0;
//			}
//		})
		List <ListNode> list=new ArrayList <> ();
		for(int i=0;i<lists.length;i++)
		{
			ListNode node=lists[i];
			while(node!=null)
			{
				list.add(node);
				node=node.next;
			}
		}
		ListNode[]  arr=list.toArray(new ListNode[0]);
		Arrays.sort (arr , (o1 , o2) -> o1.val-o2.val);
		ListNode head=new ListNode();
		ListNode node=head;
		for(int i=0;i<arr.length;i++)
		{
			node.next=arr[i];
			node=node.next;
		}
		return head.next;
	}
}
